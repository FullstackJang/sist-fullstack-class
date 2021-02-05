package com.sist.PersonDao;

public class Person {

	private int id = 20181004;
	private String name = "박혜수";
	
	public Person() {
		System.out.println("기본생성자 동작함");
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
