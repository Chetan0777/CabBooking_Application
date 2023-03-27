package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Email(message =  "Email is not in 'example@email.com' format")
	@Column(unique = true)
	private String email;
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String lastName;
	@Size(min = 10, max = 12)
	@Column(unique = true)
	private String mobile;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})",message="atleast contain 1 Numeric,1 special charecter or one lowercase 1uper leter and size must be 6 to 12")
	private String password;
	private Integer[] currentPosition=new Integer[2];
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer[] getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Integer[] currentPosition) {
		this.currentPosition = currentPosition;
	}
	

}