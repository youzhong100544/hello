package com.hello.servlet2_5.domain;

public class User {

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String id, String username, String password, String gender,
	            String age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
	}

	private String id;
	private String username;
	private String password;
	private String gender;  //性别
	private String age;		//年龄
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	
	
	
	
}
