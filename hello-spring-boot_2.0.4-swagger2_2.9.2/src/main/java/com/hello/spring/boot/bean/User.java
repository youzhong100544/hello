package com.hello.spring.boot.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="User",description="用户")
public class User implements Serializable {

	/**
	 * 主键id
	 */
	@ApiModelProperty(value="主键ID", name="id", example="2")
	private Integer id;

	/** 姓名 */
	@Range(max=32, message = "最大长度32")
	@ApiModelProperty(value="姓名", name="id", example="小强")
	private String name;
	/** 年龄 */
	@ApiModelProperty(value="年龄", name="id", example="22")
	private Integer age;
	/** 出生日期 */
	@ApiModelProperty(value="出生日期", name="id", example="2008-08-08")
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
