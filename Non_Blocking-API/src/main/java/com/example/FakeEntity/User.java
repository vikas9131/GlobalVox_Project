package com.example.FakeEntity;

public class User {

	private int id;
	private String Name;
	private String Address;
	private String occupation;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String address, String occupation) {
		super();
		this.id = id;
		Name = name;
		Address = address;
		this.occupation = occupation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
}
