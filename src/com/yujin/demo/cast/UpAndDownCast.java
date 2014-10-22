package com.yujin.demo.cast;

import com.yujin.demo.cast.A.iA;
import com.yujin.demo.cast.A.iiA;

public class UpAndDownCast implements iA, iiA{

	public static void main(String[] args) {
//		 A a1 = new B(); // 向上转型
//         a1.aMthod();    // 调用父类aMthod()，a1遗失B类方法bMethod1()、bMethod2()
//         B b1 = (B) a1; // 向下转型，编译无错误，运行时无错误
//         b1.aMthod();    // 调用父类A方法
//         b1.bMethod1(); // 调用B类方法
//         b1.bMethod2(); // 调用B类方法
//         A a2 = new A();
//         //B b2 = (B) a2; // 向下转型，编译无错误，运行时将出错
//         if (a2 instanceof B) {
//        	 B b2 = (B) a2;
//        	 b2.aMthod();
//        	 b2.bMethod1();
//        	 b2.bMethod2();
//         } else {
//        	 System.out.println("a2 is not B's instanceof");
//         }
//		A a = new A();
//		A.method();
		display((iA)new UpAndDownCast());
		display((iiA)new UpAndDownCast());
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("say!");
	}
	
	public static void display(iA i) {
		if (null != i) {
			i.say();
		} else {
			System.out.println("i is null");
		}
	}
	
	public static void display(iiA ii) {
		if (null != ii) {
			ii.say();
		} else {
			System.out.println("ii is null");
		}
	}
}

class A {
	public A() {
		System.out.println("A construct!");
	}
	static {
		System.out.println("static 2 block!");
	}
	static {
		System.out.println("static 1 block!");
	}
	static void method() {
		System.out.println("method!");
	}
	void aMthod() {
		System.out.println("A method");
	}
	
	public class inner {
		
	}
	public interface iA {
		public void say();
	}
	public interface iiA {
		public void say();
	}
}

class B extends A {
	
	@Override
	void aMthod() {
		// TODO Auto-generated method stub
		super.aMthod();
	}

	void bMethod1() {
		System.out.println("B method 1");
	}

	void bMethod2() {
		System.out.println("B method 2");
	}
}