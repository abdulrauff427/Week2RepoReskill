package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RetailDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class RegisterDataProvider {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RegisterBean> list = new RetailDAO().getRegister(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegisterBean temp : list){
			Object[]  obj = new Object[12]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.getEmail();
			obj[3] = temp.getTelephone();
			obj[4] = temp.getAddress1();
			obj[5] = temp.getAddress2();
			obj[6] = temp.getCity();
			obj[7] = temp.getPostalcode();
			obj[8] = temp.getCountry();
			obj[9] = temp.getRegion();
			obj[10] = temp.getPassword();
			obj[11] = temp.getConfirmpassword();
			
			
			
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
}