package com.hello.servlet2_5.web.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 表单校验bean，所有字段必须都是字符串，用于获得浏览器发送的所有数据，并对数据有效性进行校验。
 * * 1 提供校验validate()
 * * 2 记录每一项校验结果
 * @author 传智·左慈
 *
 */
public class UserFormBean {
	private String id;
	private String username;
	private String password;
	private String repassword;//确认密码
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
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
	public UserFormBean() {
		super();
	}
	public UserFormBean(String id, String username, String password, String repassword, String gender, String age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.repassword = repassword;
		this.gender = gender;
		this.age = age;
	}

	//记录错误信息 map.key 对应字段 ， map.value 提示信息
	private Map<String,String> errorMsg = new HashMap<String, String>();
	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 校验
	 * @return
	 */
	public boolean validate() {
		boolean temp = true;
		//1 用户名不能为空
		if(username == null || "".equals(username.trim())){
			errorMsg.put("usernameMsg", "用户名不能为空");
			temp = false;
		} else {
			if(username.matches("^[a-zA-Z0-9]{6,12}$")){
				errorMsg.put("usernameMsg", "用户名必须是6-12字符");
				temp = false;
			}
		}

		//2 密码不能为空
		if(password == null || "".equals(password.trim())){
			errorMsg.put("passwordMsg", "密码不能为空");
			temp = false;
		} else {
			//3 密码一致
			if(!  password.equals(repassword)){
				errorMsg.put("repasswordMsg", "确认密码和密码不一致");
				temp = false;
			}
		}

		return temp;
	}
	

	public static void main(String[] args) {
		boolean s = "12456".matches("^[a-zA-Z0-9]{6,12}$");
		System.out.println(s);
				
	}
	
	
	
}
