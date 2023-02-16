package com.jobportal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "requirements1")
public class JobOpening {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workId;// PK, auto increment

	private int userId;// SESSION - employees ID
	
	private int employerId; // Employers ID
	
	private  String skillsReq; // drop down
	
	private String JobDesc;// Job desc
	
	private long mobileNumber;// Job desc

	private LocalDate postDate;// post date , now()
	
	private LocalDate workDate;// future date .. jis din kam krna hai
	
	private double reward;// skip
	
	private String jobCity;// location
	private String JobDist;// 
	private String JobState;// 
	
	private String status; // internal status active and close
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "user_id") private User user;
	 */

	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "jobs_users", joinColumns = @JoinColumn(name = "workId"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int setUserId() {
		return this.userId ;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getSkillsReq() {
		return skillsReq;
	}

	public void setSkillsReq(String skillsReq) {
		this.skillsReq = skillsReq;
	}

	public String getJobDesc() {
		return JobDesc;
	}

	public void setJobDesc(String jobDesc) {
		JobDesc = jobDesc;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public LocalDate getWorkDate() {
		return workDate;
	}

	public void setWorkDate(LocalDate workDate) {
		this.workDate = workDate;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	public String getJobCity() {
		return jobCity;
	}

	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	public String getJobDist() {
		return JobDist;
	}

	public void setJobDist(String jobDist) {
		JobDist = jobDist;
	}

	public String getJobState() {
		return JobState;
	}

	public void setJobState(String jobState) {
		JobState = jobState;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "JobOpening [workId=" + workId + ", userId=" + userId + ", employerId=" + employerId + ", skillsReq="
				+ skillsReq + ", JobDesc=" + JobDesc + ", mobileNumber=" + mobileNumber + ", postDate=" + postDate
				+ ", workDate=" + workDate + ", jobCity=" + jobCity + ", ]";
	}

}
