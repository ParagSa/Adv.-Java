package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientDBHandler extends DBHandler{
	Connection connection;
	Statement statement;
	ResultSet rs;
	
	public ClientDBHandler() {
		super();
		super.connect();
		connection = super.connection;
		statement = super.statement;
	}

	public ArrayList<String> getNotification(String username,String userType){

		String query = null,updateQuery = null;
		ResultSet rs;
		ArrayList<String> notifications = null;



		query = "Select notification from notification_for_freelancer where username = \"" + username + "\" and state = \"Unseen\"";

		updateQuery = "Update notification_for_freelancer set state = \"Seen\" where username = \"" + username + "\";";

		try {
			rs = statement.executeQuery(query);
			notifications = new ArrayList<>();


			while(rs.next()) {
				notifications.add(rs.getString(1));				

			}

			statement.executeUpdate(updateQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return notifications;

	}
	
	public boolean insertComment(String username,String freelancerName,String comment,int projectId) {

		String query = "insert into comments (username,commented_by,commented_portion,date_of_comment) values ("
				+ "\"" + freelancerName+ "\",\"" + username + "\",\"" + comment + "\",now());";

		String notification = username + "has commented on your profile ";

		String cmtInsertQuery = "insert into notification_for_freelancer (username,project_id,notification,state)"
				+ "values (\"" + freelancerName + "\"," + projectId +",\"" + notification + "\",\"Unseen\");" ;

		try {
			statement.executeUpdate(query);

			statement.executeUpdate(cmtInsertQuery);


		}catch(Exception e) {
			e.printStackTrace();

		}

		return true;

	}
	
	public boolean insertPayment(PersonalInfo pInfo,String clientAccount ,String freelancerAccount,float x) {
		
		String query = "insert into transaction_table (project_id,freelancer_account,paypal_account,amount) values ("
				+ pInfo.getUsername() + ",\"" + freelancerAccount + "\",\"" + clientAccount + "\","+ x +");";
		
		try {			
			statement.executeUpdate(query);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
		
	}

	public int insertProject(String projectName,String projectDescription,String client,String days,String[] languages) {
		int projectID = -1;
		try {

			
			ResultSet rs1,rs2;
			String notification;
			String query = "insert into project (project_name,project_description,client_name,project_status,duration) values(\""
					+ projectName + "\",\"" + projectDescription + "\",\"" + client + "\", \"Bidding\" ,\'" + days +  "\');";
			statement.executeUpdate(query);

			query = "select project_id from project where project_name = \"" + projectName + "\" and client_name = \""+ client + "\";";

			rs = statement.executeQuery(query);

			while(rs.next()) {
				projectID = rs.getInt(1);

			}
			
			for(String str:languages) {
				
				query = "insert into requirements (project_id,requirement) values (" + projectID + ",\"" + str + "\");";
                statement.executeUpdate(query);
				
			}
			

			query = "select distinct experns.username from experience experns " + 
					"where not exists (	select requirement from requirements where project_id = " + projectID +   
					"	and requirement not in (select subject_of_experience from experience exp where exp.username = experns.username)" + 
					");";

			rs1 = statement.executeQuery(query);

			notification = " Invitation of bidding Project : " + projectName + " by : " + client;
			
			System.out.println("notification length " + notification.length());
			ArrayList<String> listOfUname = new ArrayList<>();

			while(rs1.next()) {
				System.out.println(rs1.getString(1));
				listOfUname.add(rs1.getString(1));

			}

			for(int i = 0 ;i < listOfUname.size();i++) {
				query = "insert into notification_for_freelancer (username,project_id,notification,state) values (\"" + 
						listOfUname.get(i) + "\"," + projectID + ",\"" + notification + "\",\"Unseen\");";
				statement.executeUpdate(query);

			}
			

		}catch(Exception e) {
			e.printStackTrace();

		} 
		return projectID;



	}
	
	
	public ArrayList<Project> getMyProject(String username){

		ArrayList<Project> projects = null;

		String query = "Select project_id,project_name,freelancer_name,project_status, image_path from project "
				+ "where client_name = \"" + username + "\";";

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
	

	public boolean selectFreelancer(String username,int projectId) {

		String projectQuery = "Select project_name from project where project_id = " + projectId + ";";
		String projectName = "";
		ResultSet biddingResult;
		String clientName = "";
		
		String biddingQuery = "Select * from bidding where project_id = " + projectId + " and bidder = \"" + username + "\";";
       
		
		Bidder bidder = null; 
		
		String query = null;

		String insertionQuery;

		try {
			
			biddingResult = statement.executeQuery(biddingQuery);
			
			while(biddingResult.next()) {
				bidder = new Bidder(username,biddingResult.getFloat(4));
				clientName = biddingResult.getString(3);
				
			}
			
			query = "Update project set freelancer_name = \"" + bidder.username +"\",final_amt = " 
					+ bidder.amt + ",start_date = now(),project_status = \"Running\"  where project_id = "
					+ projectId + ";";
			
			statement.executeUpdate(query);

			rs = statement.executeQuery(projectQuery);

			while(rs.next()) {
				projectName = rs.getString(1);

			}
			String notification = "You have been selected for project " + projectName + " by " + clientName;

			insertionQuery = "insert into notification_for_freelancer (username,project_id,notification,state)"
					+ "values (\"" + bidder.username + "\"," + projectId + ",\"" + notification + "\","
					+ "\"Unseen\");";

			statement.executeUpdate(insertionQuery);



		}catch(Exception e) {
			e.printStackTrace();

		}
		return true;


	}


	public boolean rateTheFreelancer(String username,String freelancerName,int projectId,float x) {

		if(x <= 5) {
			String updateRatingQuery;

			String updateProjectQuery = "Update project set freelancer_rating = " + x + "where project_id = " + projectId
					+";";

			String notification =  username + " has rated you on the project";

			String ratingQuery = "Select rating from freelancer where username = \"" + freelancerName + "\";";

			String query = "Insert into notification_for_freelancer (username,project_id,notification,state) values ("
					+ "\"" + freelancerName + "\"," + projectId + ",\"" + notification + "\",\"Unseen\");";

			try {
				statement.executeUpdate(updateProjectQuery);

				rs = statement.executeQuery(ratingQuery);



				while(rs.next()) {
					x = x + rs.getFloat(1);
					x = (float)x/2;

				}

				updateRatingQuery = "Update clients set rating = " + x + "where client_name = \"" + freelancerName
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

	public ArrayList<Comment> getComments(String username){

		ArrayList<Comment> comments = null;

		String query = "Select commented_by,commented_portion,date_of_comment from comments "
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

	public boolean notifyPayment(String username,Project project) {
		String notification = username + "has paid for " + project.projectName;

		String query = "Insert into notification_for_freelancer (username,project_id,notification,state) values (\""
				+ username + "\","+ project.projectId +",\"" + notification + "\",\"Unseen\");";

		String updateQuery = "Update project set project_status = \"Paid\" where project_id =" + project.projectId + ";"; 

		try {

			statement.executeUpdate(updateQuery);
			statement.executeUpdate(query);

		}catch(Exception e) {
			e.printStackTrace();

		}

		return true;

	}

}
