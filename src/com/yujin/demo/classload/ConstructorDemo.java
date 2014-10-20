package com.yujin.demo.classload;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ConstructorDemo {
	// 无参构造器
	public ConstructorDemo() {
		System.out.println("用无参构造器实例化了一个对象。");
	}

	// 有参构造器
	public ConstructorDemo(String s) {
		System.out.println("用有参构造器实例化了一个对象。参数为" + s);
	}

	// 无参方法
	public void method() {
		System.out.println("执行了无参方法。");
	}

	// 有参方法
	public void method(String s) {
		System.out.println("执行了有参方法。参数为：" + s);
	}

	public static void main(String[] args) throws Exception {
		Class testClass = Class.forName("com.yujin.demo.classload.ConstructorDemo");
		// 实例化一个对象，此时会调用无参构造器
		Object testObj1 = testClass.newInstance();
		// 获得带一个参数的构造器
		Constructor testConstructor = testClass.getConstructor(String.class);
		// 输出构造器的name
		System.out.println("构造器名:" + testConstructor.getName());
		// 用一个参数实例化一个对象
		Object testObj2 = testConstructor.newInstance("yuanjb");
		// 获得类的无参方法
		Method methodA = testClass.getMethod("method", null);
		// 输出方法名
		System.out.println("方法名：" + methodA.getName());
		// 调用无参方法
		methodA.invoke(testObj2, null);
		// 获得类的有参方法
		Method methodB = testClass.getMethod("method", String.class);
		// 调用有参方法
		methodB.invoke(testObj2, "parameter");

		try {
			// 尝试调用构造方法（构造器）
			// 获得类的构造方法
			Method methodC = testClass.getMethod(testConstructor.getName(),String.class);
			// 调用有参方法
			methodC.invoke(testObj2, "parameter2");
		} catch (NoSuchMethodException e) {
			System.out.println("/n **** 出错啦 ****");
			System.out.println(" 此处报错，说明Method无法调用Constructor。换句话说，Method类可以调用类方法但不能调用构造器。");
			System.out.println(" 有时构造器被我们称为构造方法，但由此看来，这种说法不严格。");
		}
	}
}
