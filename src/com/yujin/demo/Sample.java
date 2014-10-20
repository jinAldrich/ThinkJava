package com.yujin.demo;

public class Sample extends com.yujin.demo.classload.Sample{

	public static void main(String[] args) {
		Person person = new Person();
		Man man = new Man();
		Person man2 = new Man();
		person.say();
		man.say();
		man2.say();
		man2.walk();
	}
}

class Man extends Person {
	public int id;
	public int phoneNum;
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("Man can say!!");
	}
	
	
}