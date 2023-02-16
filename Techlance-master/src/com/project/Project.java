package com.project;

import java.util.ArrayList;

public class Project {
	int projectId;
	int projectDuration;
	String projectName;	
	String projectDescription;
	String imagePath;
	String clientName;
	String status;
	float rating;	
	float freelancerRating;
	float amount;
	ArrayList<Bidder> bidders;
	String filePath;
	String clientFile;	

	PersonalInfo developer;
	

	public Project(int id,int duration,String name,String description,String img,String client,String status) {
		projectId = id;
		projectDuration = duration;
		projectName = name;
		projectDescription = description;
		imagePath = img;
		clientName = client;
		this.status = status;
		
		
	}
	public Project(int id,String status,String imagePath,String projectName,String clientName,String filePath) {
		this.projectId = id;
		this.status = status;
		this.imagePath = imagePath;
		this.projectName = projectName;
		this.clientName = clientName;
		this.filePath = filePath;
		
	}
	
	
	public Project(int id,String status,String imagePath,String projectName,String clientName) {
		this.projectId = id;
		this.status = status;
		this.imagePath = imagePath;
		this.projectName = projectName;
		this.clientName = clientName;		
		
	}
	
	public Project(int id,String status,String imagePath,String projectName,String clientName,float rating) {
		this.projectId = id;
		this.status = status;
		this.imagePath = imagePath;
		this.projectName = projectName;
		this.clientName = clientName;		
		this.rating = rating;
	}
	
	public String getStatus() {
		return status;
	}

	public String getClientName() {
		return clientName;
	}

	public String getName() {
		return this.projectName;
		
	}

	public int getProjectId() {
		return projectId;
	}

	public int getProjectDuration() {
		return projectDuration;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public String getImagePath() {
		return imagePath;
	}
	
	public void setBidders(ArrayList<Bidder> bidderList) {
		
		this.bidders = bidderList;
         
	}
	
	public PersonalInfo getDeveloper() {
		return developer;
	}

	public String getFilePath() {
		return filePath;
	}
	public String getClientFile() {
		return clientFile;
	}
	
	public float getFreelancerRating() {
		return freelancerRating;
	}
	public void setFreelancerRating(float freelancerRating) {
		this.freelancerRating = freelancerRating;
	}
	public void setDeveloper(PersonalInfo developer) {
		this.developer = developer;
	}

	public float getRating() {
		return rating;
	}

	public ArrayList<Bidder> getBidders() {
		return bidders;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public void setProjectDuration(int projectDuration) {
		this.projectDuration = projectDuration;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setClientFile(String clientFile) {
		this.clientFile = clientFile;
	}
	

}
