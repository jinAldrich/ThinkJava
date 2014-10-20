package com.yujin.demo;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//public class SAXParse extends DefaultHandler{
//    public SAXParse() {
//        super();
//    } 
//    public void startElement(String uri, String localName, String qName, Attributes attr){  
//       if(attr.getLength()>0){  
//           for(int i = 0;i<attr.getLength();i++){  
//               System.out.println(attr.getQName(i)+" = "+attr.getValue(i));
//               System.out.println(uri);
//               System.out.println(attr.getValue(localName));
//               System.out.println(attr.getValue(qName));
//           }  
//       }  
//    }  
//    public static void main(String[] args){  
//        try{    
//          //实例化用于分析的工厂
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//           //实例化分析类
//            SAXParser parser = factory.newSAXParser();
//            SAXParse handler = new SAXParse();  
//            parser.parse("example.xml",handler);  
//           }catch(Exception e){  
//            System.out.println(e.toString());  
//        }  
//    }  
// }
public class SAXParse extends DefaultHandler{
    private static Properties props;   //用于存放名字属性对(key-value)
    private String currentName; //当前扫描到的键值
    private static StringBuffer currentValue = new StringBuffer();   //当前名字对应的值
    private static String Name;//键值对
    private static String Value;
    public SAXParse(){
        super();
        this.props=new Properties();
    } 
    
    public void startElement(String uri,String localName,String qName,Attributes attr){
        System.out.println("<---------startElement-------->");
        System.out.println("uri:::" + uri);  
        System.out.println("localName:::" + localName);  
        System.out.println("qName:::" + qName); 
        currentValue.delete(0,currentValue.length());
        this.currentName=qName;
    }
     
    //碰到节点开始和结束之间的字符<element>***</element>
    public void characters(char[] ch,int start,int length) throws SAXException{
        System.out.println("<---------characters-------->");
        currentValue.append(ch,start,length);
    }
    //碰到节点结束</element>  
    public void endElement(String uri,String localName,String qName){
        System.out.println("<---------endElement-------->");
        System.out.println("uri:::" + uri);  
        System.out.println("localName:::" + localName);  
        System.out.println("qName:::" + qName);
        String name=currentName;
        String value=currentValue.toString().trim();
        if(name!=""&&value!="")
            System.out.println(name+"="+value);
        if(name=="name")
            Name=value;
        if(name=="value")
            Value=value;
        if(qName=="property")
               props.put(Name,Value);
       
        this.currentName="";
        currentValue.delete(0,currentValue.length());
    }  
     public String getElementValue(String elementName){
         System.out.println("<---------getElementValue-------->");
        //elementValue:对应于elementName的节点的属性值
        String elementValue=null;
        elementValue=props.getProperty(elementName);
        return elementValue;
    }

    public static void main(String[] args) {
        String url = "http://qd.baidupcs.com/file/b1656d325739d57143f1d221b75f41ed?fid=3358418198-250528-1081812709713841&time=1411612783&sign=FDTAXER-DCb740ccc5511e5e8fedcff06b081203-%2B1o%2F9zWFZUCFl%2BdnwQaPWrDIu5c%3D&to=qb&fm=Nin,B,U,nc&newver=1&newfm=1&flow_ver=3&expires=8h&rt=sh&r=544426768&mlogid=3260872087&vuk=3358418198&vbdid=1153820493&fn=version.xml";
//        try {
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser parser = factory.newSAXParser();
//            SAXParse handler = new SAXParse();
//            parser.parse("example.xml", handler);
//            System.out.println(handler.getElementValue("searcher.response.maxage "));
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
        try {
            URL _url = new URL(url);
            SAXParserFactory factory=SAXParserFactory.newInstance();  
            factory.setNamespaceAware(true);  
            factory.setValidating(false);  
            SAXParser parser=factory.newSAXParser();  
            InputStream is = _url.openStream();
            parser.parse(is, new DefaultHandler() {
                private String currentName;
                /**
                 * 碰到开始节点<element>
                 */
                @Override
                public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
                        throws SAXException {
                    System.out.println("<---------startElement-------->");
//                    System.out.println("uri:::" + uri);  
                    System.out.println("localName:::" + localName);  
                    System.out.println("qName:::" + qName); 
                    currentValue.delete(0,currentValue.length());
                    this.currentName=qName;
                }
                /**
                 * 碰到节点结束</element>
                 */
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("<---------endElement-------->");
//                    System.out.println("uri:::" + uri);  
//                    System.out.println("localName:::" + localName);  
//                    System.out.println("qName:::" + qName);
                    String name=currentName;
                    String value=currentValue.toString().trim();
                    if(name!=""&&value!="")
//                        System.out.println(name+"="+value);
                    if(name=="name")
                        Name=value;
                    if(name=="value")
                        Value=value;
                    if(qName=="property")
                           props.put(Name,Value);
                   
                    this.currentName="";
                    currentValue.delete(0,currentValue.length());
                }

                /**
                 * 碰到节点开始和结束之间的字符<element>***</element>
                 */
                @Override
                public void characters(char[] ch, int start, int length)
                        throws SAXException {
                    System.out.println("<---------characters-------->");
//                    System.out.println(String.valueOf(ch).toString());
                    currentValue.append(ch,start,length);
                    System.out.println("currentValue: " + currentValue);
                }
                
            });
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}
