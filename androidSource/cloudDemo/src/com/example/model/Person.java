package com.example.model;

public class Person {

	public int _id ;
	public String name ;
	public String age ;
	public String info ;
	
	public Person(){}
	
	public Person(String name,String age,String info){
		this.name = name ;
		this.age = age ;
		this.info = info ;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
