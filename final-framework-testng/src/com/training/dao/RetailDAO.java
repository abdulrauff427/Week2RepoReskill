package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RetailDAO {
	
	Properties properties; 
	
	public RetailDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public List<RegisterBean> getRegister(){
		String sql = properties.getProperty("get.register"); 
		
		GetConnection gc  = new GetConnection(); 
		List<RegisterBean> list = null;
		try {
			gc.ps2 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<RegisterBean>(); 
			
			gc.rs2 = gc.ps2.executeQuery(); 
			
			while(gc.rs2.next()) {
			
				RegisterBean temp = new RegisterBean(); 
				temp.setFirstName(gc.rs2.getString(1));
				temp.setLastName(gc.rs2.getString(2));
				temp.setEmail(gc.rs2.getString(3));
				temp.setTelephone(gc.rs2.getString(4));
				temp.setAddress1(gc.rs2.getString(5));
				temp.setAddress2(gc.rs2.getString(6));
				temp.setCity(gc.rs2.getString(7));
				temp.setPostalcode(gc.rs2.getString(8));
				temp.setCountry(gc.rs2.getString(9));
				temp.setRegion(gc.rs2.getString(10));
				temp.setPassword(gc.rs2.getString(11));
				temp.setConfirmpassword(gc.rs2.getString(12));
				

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RetailDAO().getLogins().forEach(System.out :: println);
		new RetailDAO().getRegister().forEach(System.out :: println);
	}
	
	
}
