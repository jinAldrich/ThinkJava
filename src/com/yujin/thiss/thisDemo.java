package com.yujin.thiss;

public class thisDemo {
	public Person p3 = new Person();
	public static Person p4 = new Person();
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("王五");
		p1.setAge(10);
		Person p2 = new Person();
		p2.setName("李六");
		p2.setAge(20);
		p1.print();
		p2.print();
		p4.setName("赵七");
		p4.setAge(30);
	}
}

class Person {
	public String name;
	public int age;
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
	} 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
