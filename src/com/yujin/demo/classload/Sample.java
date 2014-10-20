package com.yujin.demo.classload;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Sample { 
    private static Sample instance; 
    public String name = "123";
    public int id = 100;
    
    public void setSample(Object instance) {
    	System.out.println("<---setSample--->");
        this.instance = (Sample) instance; 
    } 
    
    public String say() {
    	return null;
    }
    private int song() {
    	return 10;
    }
    
    public native String walk();
    
    
    public void testClassIdentity() { 
        String classDataRootPath = "\\home\\yujin\\test\\classData"; 
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath); 
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath); 
        String className = "com.yujin.demo.classload.Sample"; 	
        try { 
            Class<?> class1 = fscl1.loadClass(className); 
            Object obj1 = class1.newInstance(); 
            Method[] methods = class1.getMethods();
            Field[] fields = class1.getFields();
            for (int i = 0; i < fields.length; i++) {
            	System.out.println(fields[i].getName());
            }
            for (int i = 0; i < methods.length; i++) {
            	System.out.println(methods[i].getName());
            }
            Class<?> class2 = fscl2.loadClass(className); 
            Object obj2 = class2.newInstance(); 
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class); 
            setSampleMethod.invoke(obj1, obj2); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
     }
    
    public static void main(String[] args) {
    	instance = new Sample();
    	instance.testClassIdentity();
	}
 }
