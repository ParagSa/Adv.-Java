package com.jobportal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "User_Details")
public class User {

	@Id // Primary_Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id") // If the column_name is same, no need so specify the name in () again
	private int userId;

	private String password;
	
	private String fname;
	private String lname;
	
	@Column(name = "mob_num")
	private long mobileNo;
	private String email;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	private double age;

	@Column(name = "date_of_joining")
	private LocalDate dateOfJoining;

	private String city;
	private String district;
	private String state;

	private String about;
	
	//Role of user
	private String role;

	@ManyToMany(mappedBy = "users", fetch=FetchType.EAGER)
	private List<JobOpening> jobOepnings;
	
	public List<JobOpening> getJobOepnings() {
		return jobOepnings;
	}

	public void setJobOepnings(List<JobOpening> jobOepnings) {
		this.jobOepnings = jobOepnings;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", dateOfJoining=" + dateOfJoining + ", role=" + role + ", ]";
	}

	
	
}
