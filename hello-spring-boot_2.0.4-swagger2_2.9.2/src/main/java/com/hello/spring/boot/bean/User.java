package com.hello.spring.boot.bean;

import java.util.Date;

public class User {

	/**
	 * 主键id
	 */
	private Integer id;

	/** 姓名 */
	private String name;
	/** 年龄 */
	private Integer age;
	/** 出生日期 */
	private Date birthday;

	public User() {
	}

	public User(String name, Integer age, Date birthday) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public User(Integer id, String name, Integer age, Date birthday) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
