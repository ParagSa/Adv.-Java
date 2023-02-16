package com.project;

import java.sql.*;
import java.util.ArrayList;

public class FreelancerDBHandler extends DBHandler{
	Connection connection;
	Statement statement;
	ResultSet rs;

	public FreelancerDBHandler() {

		super();
		super.connect();
		connection = super.connection;
		statement = super.statement;
	}

	public boolean addExperience(String[] languages,String username) {
		String query;

		for(String temp:languages) {
			query = "insert into experience (username,subject_of_experience) values(\"" + username 
					+ "\",\"" + temp + "\");" ;   

			try {
				statement.executeUpdate(query);
			} catch (SQLException e) {				
				e.printStackTrace();
			}	
		}
		return true;

	}


	/*public Project getProject(int project_id) {

		Project project = null;
		String query;
		query = "Select project_id,duration,project_name,project_description,image_path,client_name,project_status from project"
				+ " where project_id = \"" + project_id + "\";" ;

		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
				project = new Project(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return project;

	}*/
	


	public boolean insertBidding(String username,String client,int projectId,float amt) {

		String query = "Insert into bidding (project_id,bidder,client_name,amount) values (" + projectId +",\"" + username +
				"\" , \"" + client + "\"," + amt +");";  
		try {
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return true;
	}

	public boolean updateMessageStatus(String username,String another) {

		String query = "Update messages set state = \"Seen\" where ((sender = \"" + username + "\" and receiver = \"" 
				+ another + "\") or (sender =\""+ another + "\" and receiver = \"" + username+"\")) and state = "
				+ "\"Unseen\";";

		try {
			statement.executeUpdate(query);

		}catch(Exception e) {
			e.printStackTrace();

		}
		return true;


	}

	public int[] getMsgNtfnCount(String username) {

		int[] countArray = new int[2];

		String msgQuery = "Select count(*) from messages where (receiver = \""
				+ username + "\") and state = \"Unseen\" ;";

		String ntfQuery = "Select count(*) from notification_for_freelancer where username = \"" + username +
				"\" and state = \"Unseen\" ;";
		try {
			rs = statement.executeQuery(msgQuery);
			while(rs.next()) {
				countArray[0] = rs.getInt(1);

			}

			rs = statement.executeQuery(ntfQuery);
			while(rs.next()) {
				countArray[1] = rs.getInt(1);

			}
		}catch(Exception e) {
			e.printStackTrace();

		}
		return countArray;

	}

	public ArrayList<Comment> getComments(String username){

		ArrayList<Comment> comments = null;

		String query = "Select commented_by,commented_portion,date_of_comment from commentsforclients "
				+ "where username = \"" + username + "\" order by date_of_comment asc;";	

		try {

			rs = statement.executeQuery(query);
			comments = new ArrayList<Comment>();

			while(rs.next()) {
				comments.add(new Comment(rs.getString(1),rs.getString(2),rs.getTimestamp(3)));

			}							

		}catch(Exception e) {
			e.printStackTrace();

		}
		return comments;

	}

	public boolean insertComment(String username,String clientName,String comment,int projectId) {

		String query = "insert into commentsforclients (username,commented_by,commented_portion,date_of_comment) values ("
				+ "\"" + clientName + "\",\"" + username + "\",\"" + comment + "\",now());";

		String notification = username + "has commented on your profile ";

		String cmtInsertQuery = "insert into notification_for_client (username,project_id,notification,state)"
				+ "values (\"" + clientName + "\"," + projectId +",\"" + notification + "\",\"Unseen\");" ;

		try {
			statement.executeUpdate(query);

			statement.executeUpdate(cmtInsertQuery);


		}catch(Exception e) {
			e.printStackTrace();

		}

		return true;

	}
	
	
	public ArrayList<Project> searchSuggestedProjects(String username){
		
		ArrayList<Project> suggestedProjects = new ArrayList<Project>();
		
		String query = "select project_id,project_name,image_path,client_name from project where "
				+ "project_status like \"Bidding\";";  
				
		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
				suggestedProjects.add(new Project(rs.getInt(1),"Bidding",rs.getString(3),rs.getString(2),rs.getString(4)));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return  suggestedProjects;		
		
		
	}

	public boolean rateTheClient(String username,String clientName,int projectId,float x) {

		if(x <= 5) {
			String updateRatingQuery;

			String updateProjectQuery = "Update project set client_rating = " + x + "where project_id = " + projectId
					+";";

			String notification =  username + " has rated  "+ x +" you on the project";

			String ratingQuery = "Select rating from clients where client_name = \"" + clientName + "\";";

			String query = "Insert into notification_for_client (username,project_id,notification,state) values ("
					+ "\"" + clientName + "\"," + projectId + ",\"" + notification + "\",\"Unseen\");";

			try {
				statement.executeUpdate(updateProjectQuery);

				rs = statement.executeQuery(ratingQuery);

				while(rs.next()) {
					x = x + rs.getFloat(1);
					x = (float)x/2;

				}

				updateRatingQuery = "Update clients set rating = " + x + " where client_name = \"" + clientName
						+"\";";
				statement.executeUpdate(updateRatingQuery);

				statement.executeUpdate(query);


			}catch(Exception e) {
				e.printStackTrace();

			}
			return true;			

		}

		else {

			return false;
		}


	}

	public ArrayList<String> getSubjectList(){

		ArrayList<String> subjects = null;

		String query = "Select name_of_subject from subject_name;";

		try {
			rs = statement.executeQuery(query);

			subjects = new ArrayList<>();
			while(rs.next()) {	
				subjects.add(rs.getString(1));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return subjects;


	}

	public ArrayList<Project> getMyProject(String username){

		ArrayList<Project> projects = null;

		String query = "Select project_id,project_name,client_name,project_status, image_path from project "
				+ "where freelancer_name = \"" + username + "\";";

		try {
			rs = statement.executeQuery(query);

			projects = new ArrayList<>();

			while(rs.next()) {	
				projects.add(new Project(rs.getInt(1),rs.getString(4),rs.getString(5),rs.getString(2),rs.getString(3)));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return projects;	

	}

	public boolean notifySubmission(Project project,String username) {
		String query = "Update project set project_status = \"Complete\" where project_id = " + project.projectId + ";";

		String  notification = project.projectName + " has been submitted by " + username ;

		String ntfnQuery = "Insert into notification_for_client (username,project_id,notification,state) values (\"" +
				project.clientName + "\"," + project.projectId + ",\"" + notification + "\",\"Unseen\");";

		try {
			statement.executeUpdate(query);
			statement.executeUpdate(ntfnQuery);

		}catch(Exception e) {
			e.printStackTrace();

		}	

		return true;
	}
	
	public boolean updateBidding(String username,int projectId,float amt) {
		String query = "Update bidding set amount = " + amt + " where bidder = \"" + username + "\" and project_id = "+ 
	                    projectId + ";";
		try {
			statement.executeUpdate(query);
			return true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return false;
		
	}


}
