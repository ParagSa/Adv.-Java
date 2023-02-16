package com.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static String stringToDate(String dateStr) {
		Date date;
		String formattedDate = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(dateStr);
			formattedDate= new SimpleDateFormat("dd/MM/yyyy, Ka").format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        return formattedDate;
		
	}
	
	public static String formatString(String str) {
		String resultStr = "";
		String[] strArray = str.split(" ");

		if (str.length() != 0) {
			resultStr = "%";
			for (String temp : strArray) {
				resultStr += temp + "%";

			}
		}

		return resultStr;

	}
	
	/*public static String nameFile(int projectId) {
		
		
		
	}*/
	

}
