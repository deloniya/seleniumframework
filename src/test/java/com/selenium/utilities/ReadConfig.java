package com.selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		 File src= new File ("./Configuration/config.properties");
		 
		 try {
			 FileInputStream fis= new FileInputStream (src);
			 pro = new Properties();
			 pro.load(fis);
			 
		 }
		 catch (Exception e) {
			 
			 System.out.println("Exception is" + e.getMessage());
		 }
	}
	
	 public String getURL()
	 {
		 String url = pro.getProperty("baseURL");
		 return url;
	 }
	 
	 public String getuname() {
		 
		 String uname = pro.getProperty("username");
		 return uname;
	 }
	 
	 public String getpassword() {
		 
		 String password= pro.getProperty("password");
		 return password;
	 }
	
	 public String getchromepath() {
		 
		 String chropath = pro.getProperty("chromepath");
		 return chropath;
	 }
	 
	 public String getedgepath() {
		 
		 String edgepath = pro.getProperty("edgepath");
		 return edgepath;
	 }

}
