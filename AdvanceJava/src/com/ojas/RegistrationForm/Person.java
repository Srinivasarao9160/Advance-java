package com.ojas.RegistrationForm;

import java.io.Serializable;

public class Person implements Serializable {
	private int pid;
	private String ename;
	private String connectno;
	private String email;
	private String gender;
	private String address;
	public Person() {
		super();
	}
	public Person(int pid, String ename, String connectno, String email, String gender, String address) {
		super();
		this.pid = pid;
		this.ename = ename;
		this.connectno = connectno;
		this.email = email;
		this.gender = gender;
		this.address = address;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getConnectno() {
		return connectno;
	}
	public void setConnectno(String connectno) {
		this.connectno = connectno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", ename=" + ename + ", connectno=" + connectno + ", email=" + email + ", gender="
				+ gender + ", address=" + address + "]";
	}
	
	

}
