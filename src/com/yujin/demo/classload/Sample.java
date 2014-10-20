package com.yujin.demo.classload;

import java.lang.reflect.Method;

public class Sample { 
    private static Sample instance; 

    public void setSample(Object instance) { 
        this.instance = (Sample) instance; 
    } 
    
    public void testClassIdentity() { 
        String classDataRootPath = "\\home\\yujin\\test\\classData"; 
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath); 
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath); 
        String className = "com.yujin.demo.classload.Sample"; 	
        try { 
            Class<?> class1 = fscl1.loadClass(className); 
            Object obj1 = class1.newInstance(); 
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
