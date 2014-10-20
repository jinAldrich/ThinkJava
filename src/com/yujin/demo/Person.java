package com.yujin.demo;

public class Person {

	public String name; 
	public int age;
	public int id;
	public void walk() {
		System.out.println("Person can walk!");
	}
	public void say() {
		System.out.println("Person can say!");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:" + name + " age:" + age + " id:"+id;
	}
}
