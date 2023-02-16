package com.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.project.Util;
import com.project.Data;
import com.project.DataSet;

public class DBHandler implements DAOInterface{
	Connection connection;
	Statement statement;
	ResultSet rs;
	@Override
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/techlance?autoReconnect=true&useSSL=false","root","Mamun");
			statement = connection.createStatement();
		}catch(Exception e) {
			e.printStackTrace();			
		}

	}

	@Override
	public boolean addDescription(String username, String description,String designation) {
		String tableName,attr;
		if(designation.equals("client")) {
			tableName = "clients";
			attr = "client_name";
            
		}
		else {

			tableName = "freelancer";
			attr = "username";
		}


		String query = "update "+ tableName +" set description = \"" + description + "\" where "+ attr+ " = \"" 
				+ username + "\";"; 
		try {
			statement.executeUpdate(query);
			return true;

		}catch(Exception e) {
			e.printStackTrace();

		}

		return false;

	}
	
	public boolean addFileToProject(String finalOrNot,PersonalInfo pInfo,String name) {
		
		String attr;
		
		if(finalOrNot.equals("Final")) {
			attr = "file_path";
			
			
		}else {
			attr = "req_file_path" ;			
		}
		
		String query = "update project set "+ attr +" = \"" + name + "\" where  project_id = " 
				+ pInfo.getUsername() + ";"; 
		
		try {
			statement.executeUpdate(query);
			if(finalOrNot.equals("Final")) {
				updateTheStatusOfProject(pInfo);
				
			}
			
			return true;

		}catch(Exception e) {
			e.printStackTrace();

		}

		return false;
		
	}

	@Override
	public boolean addImage(String username, String imagePath,String designation) {

		String tableName;
		String attr;
		if(designation.equals("client")) {
			tableName = "clients";
			attr = "client_name";
			

		}else {

			tableName = "freelancer";
			attr = "username";
		}

		String query = "update "+ tableName +" set image_path = \"" + imagePath + "\" where " + attr + "  = \"" 
				+ username + "\""; 
		try {
			statement.executeUpdate(query);
			return true;

		}catch(Exception e) {
			e.printStackTrace();

		}

		return false;
	}
	
	public boolean addImageToProject(PersonalInfo project,String imagePath) {
		
		String query = "update project set image_path = \"" + imagePath + "\" where project_id  = " 
				+ project.getUsername() + ""; 
		try {
			statement.executeUpdate(query);
			return true;

		}catch(Exception e) {
			e.printStackTrace();

		}

		return false;
		
	}
	
	public ArrayList<String> autoSearch(String name){
		ResultSet freelancerResult,clientsResult,projectResult;

		ArrayList<String> searchResult = new ArrayList<>();

		String freelancerQuery,clientsQuery,projectQuery,formattedString;

		formattedString = Util.formatString(name);

		freelancerQuery = "Select fullname from freelancer where fullname like \"" + formattedString + "\";";

		clientsQuery = "Select fullname from clients where fullname like \"" + formattedString + "\";";

		projectQuery = "Select project_name from project where project_name like \"" + formattedString + "\";";

		try {
			freelancerResult = statement.executeQuery(freelancerQuery);
			while(freelancerResult.next()) {
				searchResult.add(freelancerResult.getString(1));

			}


			clientsResult = statement.executeQuery(clientsQuery);

			while(clientsResult.next()) {
				searchResult.add(clientsResult.getString(1));

			}

			projectResult = statement.executeQuery(projectQuery); 	

			while(projectResult.next()) {
				searchResult.add(projectResult.getString(1));

			}


		}catch(Exception e) {
			e.printStackTrace();

		}

		return searchResult;		
		
	}

	@Override
	public void close() {
		try {
			statement.close();
			connection.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
public String getClientStatistics() {
		
		try {
			String query = "select  address,sum(rating)/count(*) from clients group by address;";
			rs = statement.executeQuery(query);
			
			Data data = new Data();
			DataSet list = new DataSet();
			
			while(rs.next()) {
				
				data.labels.add(rs.getString(1));
				list.data.add((int)(rs.getFloat(2)*20));		
				
			}
			
			data.datasets.add(list);
			Gson gson = new Gson();
			String json = gson.toJson(data);
			
			return json;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return null;		
		
	}

    public ArrayList<String> getExperience(PersonalInfo pInfo){
    	
    	ArrayList<String> list = new ArrayList<>();
    	String query = "select subject_of_experience from experience where username = \"" + pInfo.getUsername() + "\";";
    	try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
               
			   list.add(rs.getString(1));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;	
    	
    	
    }
    
    public ArrayList<User> getProjectRatingList(){
    	ArrayList<User> projectList = new ArrayList<>();
    	User user;

		String query = "select * from project order by freelancer_rating + client_rating desc;";

		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
               user = new User(rs.getString(2),Integer.toString(rs.getInt(1)),rs.getString(3),"Project",(rs.getFloat(1)+rs.getFloat(2))/2);
			   projectList.add(user);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return projectList;	
    	
    	
    }
    
    public ArrayList<User> getFreelancerRatingList(){
    	ArrayList<User> freelancerList = new ArrayList<>();
    	User user;

		String query = "select * from freelancer order by rating desc;";

		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
               user = new User(rs.getString(2),rs.getString(1),rs.getString(3),"Freelancer",rs.getString(6));			
               freelancerList.add(user);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return freelancerList;	
    	
    	
    }
    
    public ArrayList<User> getClientRatingList(){
    	ArrayList<User> clientList = new ArrayList<>();
    	User user;

		String query = "select * from clients order by rating desc;";

		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
               user = new User(rs.getString(2),rs.getString(1),rs.getString(3),"Client",rs.getString(6));			
               clientList.add(user);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return clientList;
    	
    	
    }

	
	
	public String getFreelancerStatistics() {
		
		try {
			String query = "select  address,sum(rating)/count(*) from freelancer group by address;";
			rs = statement.executeQuery(query);
			
			Data data = new Data();
			DataSet list = new DataSet();
			
			while(rs.next()) {
				
				data.labels.add(rs.getString(1));
				list.data.add((int)(rs.getFloat(2)*20));		
				
			}
			
			data.datasets.add(list);
			Gson gson = new Gson();
			String json = gson.toJson(data);
			
			return json;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return null;	
		
		
	}
	
	
	 

	public ArrayList<Message> getMessage(String username,String receiver){		

		ArrayList<Message> message = new ArrayList<>();

		String query = "Select * from messages where (sender = \"" + username + "\" and receiver = \"" 
				+ receiver + "\") or (sender =\""+ receiver + "\" and receiver = \"" + username+"\") order by "
				+ "time_of_sending desc;";

		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {

				message.add(new Message(rs.getString(1),rs.getString(2),rs.getString(4),rs.getTimestamp(3)));


			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return message;		



	}
	

	public ArrayList<Project> getMyProject(String username){

		ArrayList<Project> projects = null;
		return projects;	

	}

	public Project getTheProject(int projectId){

		Project project = null;

		String query = "Select project_id,project_name,freelancer_name,project_status, image_path,client_name,file_path,req_file_path,client_rating,"
				+ "freelancer_rating from project "
				+ "where project_id = " + projectId + ";";

		try {
			rs = statement.executeQuery(query);

			while(rs.next()) {	
				project = new Project(rs.getInt(1),rs.getString(4),rs.getString(5),rs.getString(2),rs.getString(6),rs.getString(7));

				if(rs.getString(8) != null) {
					project.setClientFile(rs.getString(8));
					
				}
				if(rs.getFloat(9) != 0) {
					
					project.setRating(rs.getFloat(9));
				}
				if(rs.getFloat(10) != 0) {
					project.setFreelancerRating(rs.getFloat(10));
					
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return project;	

	}
	
	public PersonalInfo getTheProjectDeveloper(int projectId){
		
		PersonalInfo pInfo = null;
		
		String query;
		
		query = "Select freelancer_name from project where project_id = " + projectId + ";" ;

		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
				 pInfo = new PersonalInfo(rs.getString(1),"freelancer");

			}
			query = "Select fullname from freelancer where username = \"" + pInfo.getUsername() + "\";";
			
			rs = statement.executeQuery(query);
			
			if(rs.next()) {
				pInfo.setUserType(rs.getString(1));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pInfo;
		
		
	}
	
	public User getTheUser(String username) {
		
		User user = null;
		ResultSet rs1;
        

		String query = "Select * from freelancer where username = \"" + username + "\";";

		try {
			rs = statement.executeQuery(query);
			//languageOfExpertise = statement.executeQuery(queryForExperience);


			while(rs.next()) {
				user = new User(rs.getString(2),rs.getString(1),rs.getString(3),rs.getString(7),"freelancer",rs.getString(5));                

			}
			
			query = "Select * from clients where client_name = \"" + username + "\";";
			
			rs1 = statement.executeQuery(query);
			

			while(rs1.next()) {
				user = new User(rs1.getString(2),rs1.getString(1),rs1.getString(3),rs1.getString(7),"client",rs1.getString(5));                

			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;
		
	}


	public int[] getMsgNtfnCount(String username,String designation) {

		String tableName;
		if(designation.equals("client")) {
			tableName = "notification_for_client";

		}
		else {

			tableName = "notification_for_freelancer";
		}


		int[] countArray = new int[2];

		String msgQuery = "Select count(*) from messages where (sender = \"" + username + "\" or receiver = \""
				+ username + "\") and state = \"Unseen\" ;";

		String ntfQuery = "Select count(*) from "+ tableName  +" where (sender = \"" + username + "\" or receiver = \""
				+ username + "\") and state = \"Unseen\" ;";
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

	public ArrayList<MessagedEntity> getMessagedPersonList(String username){

		ArrayList<String> messageList = null;
		ArrayList<MessagedEntity> msgPersons = null;


		String query = "Select sender,receiver from messages where sender = \"" + username + "\" or receiver = \""
				+ username + "\";";

		String msgQuery;
		try {
			rs = statement.executeQuery(query);

			messageList = new ArrayList<String>();

			while(rs.next()) {
				if(rs.getString(1).equals(username) && !(messageList.contains(rs.getString(2)))) {
					messageList.add(rs.getString(2));

				}
				else if(rs.getString(2).equals(username) && !(messageList.contains(rs.getString(1)))){
					messageList.add(rs.getString(1));
				}


			}

			String str = "";

			for(int i = 0;i < messageList.size();i++) {
				if(i == 0) {
					str += "(";

				}
				str += "\"" + messageList.get(i) + "\"";

				if(i == messageList.size() - 1) {
					str += ")";

				}
				else {
					str += ",";

				}

			}

			if(str.length() > 2) {			

				msgQuery = "Select username,fullname,image_path from freelancer where username in " +  str + ";";

				msgPersons = new ArrayList<>();

				rs = statement.executeQuery(msgQuery);

				while(rs.next()) {

					msgPersons.add(new MessagedEntity(rs.getString(1),rs.getString(2),rs.getString(3)));
				}

				msgQuery = "Select client_name,fullname,image_path from clients where client_name in " +  str + ";";
				rs = statement.executeQuery(msgQuery);

				while(rs.next()) {

					msgPersons.add(new MessagedEntity(rs.getString(1),rs.getString(2),rs.getString(3)));
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}


		return msgPersons;


	}


	public ArrayList<String> getNotification(String username,String userType){

		String query = null,updateQuery = null;
		ResultSet rs;
		ArrayList<String> notifications = null;

		String tableName;

		if(userType.equals("client")) {
			tableName = "notification_for_client";

		}else {
			tableName = "notification_for_freelancer";

		}

		query = "Select notification from "+ tableName +" where username = \"" + username + "\"";

		updateQuery = "Update "+ tableName +" set state = \"Seen\" where username = \"" + username + "\" and state = \"Unseen\";";

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

	public ArrayList<Project> getOthersProject(String another,String userType){

		ArrayList<Project> projects = null;

		if(userType.equals("freelancer")) {
			String query = "Select project_id,project_name,client_name,project_status, image_path,client_rating from project "
					+ "where freelancer_name = " + another + ";";

			try {
				rs = statement.executeQuery(query);

				projects = new ArrayList<>();

				while(rs.next()) {	
					projects.add(new Project(rs.getInt(1),rs.getString(4)
							,rs.getString(5),rs.getString(2),rs.getString(3),rs.getFloat(6)));

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		else if(userType.equals("client")) {
			String query = "Select project_id,project_name,freelancer_name,project_status, image_path,freelancer_rating from project "
					+ "where client_name = " + another + ";";

			try {
				rs = statement.executeQuery(query);

				projects = new ArrayList<>();

				while(rs.next()) {	
					projects.add(new Project(rs.getInt(1),rs.getString(4)
							,rs.getString(5),rs.getString(2),rs.getString(3),rs.getFloat(6)));

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}	


		}

		return projects;


	}
	
	public String getPaymentStatus(PersonalInfo pInfo) {
		String status;
		String query = "Select * from transaction_table where project_id = " + pInfo.getUsername();
		try {
			rs = statement.executeQuery(query);

			while(rs.next()) {
				
				return "paid";
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return "unpaid";
		
	}
	
	public String getLanguageStatistics() {
		
		try {
			String query = "select name_of_subject,count(*) from subject_name left outer join requirements  \n" + 
					"on name_of_subject = requirement group by(name_of_subject)";
			rs = statement.executeQuery(query);
			
			Data data = new Data();
			DataSet list = new DataSet();
			
			while(rs.next()) {
				
				data.labels.add(rs.getString(1));
				list.data.add(rs.getInt(2));		
				
			}
			
			data.datasets.add(list);
			Gson gson = new Gson();
			String json = gson.toJson(data);
			
			return json;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return null;	
		
		
	}
	
	public ArrayList<String> getSubjectList(String data){
		ArrayList<String> str = new ArrayList<>();
		String query = "select * from subject_name where name_of_subject like \"%" + data + "%\""  ; 
		try {
		
		
		rs = statement.executeQuery(query);
		
		while(rs.next()) {
			str.add(rs.getString(1));
			
	    }
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return str;
		
		
	}


	public ArrayList<Bidder> getTheBidders(int projectId){

		ArrayList<Bidder> bidderList = null; 
		ResultSet rs;

		String query = "select freelancer.username,freelancer.rating,freelancer.fullname,bidding.amount"
				+ " from freelancer inner join bidding on freelancer.username = bidding.bidder where bidding.project_id ="
				+ projectId + ";";

		try {

			rs = statement.executeQuery(query);
			bidderList = new ArrayList<>();

			while(rs.next()) {
				bidderList.add(new Bidder(rs.getString(1),rs.getString(3),rs.getFloat(4),rs.getFloat(2)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bidderList;


	}
    
	

	@Override
	public boolean insert(String fullName, String email, String password, String address,String designation) {

		String tableName;
		String columnName;
		if(designation.equals("client")) {
			tableName = "clients";
            columnName = "client_name";
		}
		else {

			tableName = "freelancer";
			columnName = "username";
		}


		try {
			String query = "Select * from freelancer where username = \"" + email + "\";" ;
			rs = statement.executeQuery(query);
			while(rs.next()) {

				return false;
			}

			query = "Select * from clients where client_name = \"" + email + "\";" ;

			rs = statement.executeQuery(query);

			while(rs.next()) {

				return false;
			}


			query = "insert into " + tableName +" ("+columnName+",fullname,address,passcode,rating) values(\""
					+ email + "\",\"" + fullName +"\",\"" + address + "\",\"" + password +"\",0);" ;
			statement.executeUpdate(query);


		}catch(Exception e) {
			e.printStackTrace();

		} 
		return true;
	}

	public boolean insertMessage(String from,String to,String msg) {

		try {

			String query = "insert into messages (sender,receiver,time_of_sending,message,state) values(\""
					+ from + "\",\"" + to +"\", now() ,\"" + msg +"\",\"Unseen\");" ;

		    statement.executeUpdate(query);

		}catch(Exception e) {
			e.printStackTrace();

		}
		
		return true;


	}

	public PersonalInfo logInCheck(String email,String password) {
		try {

			String query = "Select * from freelancer where username = \"" + email + "\" "
					+ "and passcode = \"" + password + "\";" ;

			rs = statement.executeQuery(query);

			while(rs.next()) {
				return new PersonalInfo(email,"freelancer");
			}	

			query = "Select * from clients where client_name = \"" + email + "\" "
					+ "and passcode = \"" + password + "\";" ;

			rs = statement.executeQuery(query);
			while(rs.next()) {
				return new PersonalInfo(email,"client");
			}


		}catch(Exception e) {
			e.printStackTrace();

		} 
		return null;

	}
	
	public PersonalInfo rtnPerson(String username) {
		
		try {

			String query = "Select * from freelancer where username = \"" + username + "\"; ";
					

			rs = statement.executeQuery(query);

			while(rs.next()) {
				return new PersonalInfo(username,"freelancer");
			}	

			query = "Select * from clients where client_name = \"" + username + "\";";
			
			rs = statement.executeQuery(query);
			while(rs.next()) {
				return new PersonalInfo(username,"client");
			}


		}catch(Exception e) {
			e.printStackTrace();

		} 
		return null;
		
		
		
	}

	public ArrayList<User> searchFromDB(String name){

		ResultSet freelancerResult,clientsResult,projectResult;

		ArrayList<User> searchResult = new ArrayList<>();

		String freelancerQuery,clientsQuery,projectQuery,formattedString;

		formattedString = Util.formatString(name);

		freelancerQuery = "Select username,fullname,address,image_path from freelancer where fullname like \"" + formattedString + "\";";

		clientsQuery = "Select client_name,fullname,address,image_path from clients where fullname like \"" + formattedString + "\";";

		projectQuery = "Select project_id,project_name,client_name,image_path from project where project_name like \"" + formattedString + "\";";

		try {
			freelancerResult = statement.executeQuery(freelancerQuery);
			while(freelancerResult.next()) {
				searchResult.add(new User(freelancerResult.getString(2),freelancerResult.getString(1),freelancerResult.getString(3),
						freelancerResult.getString(4),"freelancer"));

			}


			clientsResult = statement.executeQuery(clientsQuery);

			while(clientsResult.next()) {
				searchResult.add(new User(clientsResult.getString(2),clientsResult.getString(1),clientsResult.getString(3),
						clientsResult.getString(4),"client"));

			}

			projectResult = statement.executeQuery(projectQuery); 	

			while(projectResult.next()) {
				searchResult.add(new User(projectResult.getString(2),Integer.toString(projectResult.getInt(1)),projectResult.getString(3),
						projectResult.getString(4),"project"));

			}


		}catch(Exception e) {
			e.printStackTrace();

		}

		return searchResult;

	}
	
	public boolean updateTheStatusOfProject(PersonalInfo pInfo) {
		
		ResultSet clientResult;
		String updateQuery,notificationQuery,clientQuery,notification;
		String freelancerName = "",clientName = "" ,projectName = "";
		
		
		updateQuery = "update project set project_status = \"Completed\" where project_id = " + pInfo.getUsername() + ";" ;
		
		clientQuery = "select project_name,client_name,freelancer_name from project where project_id = "+ pInfo.getUsername() +";";
		
		try {
			
			statement.executeUpdate(updateQuery);
			
			clientResult = statement.executeQuery(clientQuery);
			
			while(clientResult.next()) {
				freelancerName = clientResult.getString(3);
				clientName = clientResult.getString(2);
				projectName = clientResult.getString(1);
			}
			
			notification = "Project " + projectName + "has been completed by " + freelancerName;
			
			notificationQuery = "insert into notification_for_client (username,project_id,notification,state) values "
					+ "(\""+ clientName + "\"," + pInfo.getUsername() + ",\""+ notification +"\",\"Unseen\")";			
			
			statement.executeUpdate(notificationQuery);			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		
		return false;
		
		
	}



}