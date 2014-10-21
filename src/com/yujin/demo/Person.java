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
	
	public static void main(String[] args) {
		Person person = new Person();
		person.walk();
		Person personMan = new Mans();
		personMan.walk();
		Mans man = new Mans();
		man.walk();
		
		Person manPerson = new Person();
		if (manPerson instanceof Mans) {
			Mans mans = (Mans)manPerson;
		} else {
			System.out.println("manPerson is not Mans instanceof");
		}
		manPerson.walk();
	}
	
}

class Mans extends Person {

	@Override
	public void walk() {
		System.out.println("Man can walk!");
	}

	@Override
	public void say() {
		System.out.println("Man can say!");
	}
	
}

class Woman extends Person {

	@Override
	public void walk() {
		System.out.println("Woman can walk!");
	}
	
}
