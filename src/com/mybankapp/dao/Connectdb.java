package com.mybankapp.dao;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//This class creates a sql connection object and return it after connecting it db
public class Connectdb {

	public URL getPath() {
		return this.getClass().getClassLoader().getResource("db.properties");
	}
	public static Connection dbconnect() {
		
		try {
			//connect properties file and load db properties
			Connectdb cdb=new Connectdb();
			File file=new File(cdb.getPath().toURI());
			FileReader fp=new FileReader(file);
			Properties properties=new Properties();
			properties.load(fp);
			String drivername=properties.getProperty("driver");
			String url=properties.getProperty("url");
			String user=properties.getProperty("username");
			String password=properties.getProperty("password");
			Class.forName(drivername);
			return DriverManager.getConnection(url, user, password);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
