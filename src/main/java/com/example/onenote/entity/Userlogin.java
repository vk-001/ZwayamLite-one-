package com.example.onenote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.NotBlank;

//import com.sun.istack.NotNull;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

@Entity

@Table(name="userdetails_tbl")
public class Userlogin {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false, unique = true)
	//@NotNull(message = "Email is mandatory")
	private String email;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable =false)
	private String lastname;
	
	@Column(nullable = false)
	private String pwd;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
