package com.hello.spring.boot.model;

import java.util.Date;

public class UserModel {

	/** 姓名 */
	private String name;
	/** 年龄 */
	private Integer age;
	/** 出生日期 */
	private Date birthday;

	public UserModel() {
	}

	public UserModel(String name, Integer age, Date birthday) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
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
