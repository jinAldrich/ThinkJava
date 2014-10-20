package com.yujin.demo;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class ClassLoaderDemo {
	static Properties properties;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		properties = System.getProperties();
		Collection<Object> collection = properties.values();
		System.out.println(collection.getClass().getClassLoader());
		System.out.println("\n\n");
		for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) { 
			System.out.println(entry.getKey()+"\t"+entry.getValue()); 
		}
		
		try {
			Class c = Class.forName("com.yujin.demo.Person");
			Person person= (Person)c.newInstance();
			person.name = "lining";
			person.id = 123456;
			person.age = 24;
			System.out.println(person.toString());
			ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
	        do { 
	            System.out.println(loader.toString()); 
	            loader = loader.getParent(); 
	        } while (true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		java.lang.ClassLoader loader = ClassLoader.getSystemClassLoader();
//		try {
//			Class<? extends Person> c = (Class<? extends Person>) loader.loadClass("com.yujin.demo.Person");
//			Constructor<?>[] constructor = c.getConstructors();
//			System.out.println(constructor.toString());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
