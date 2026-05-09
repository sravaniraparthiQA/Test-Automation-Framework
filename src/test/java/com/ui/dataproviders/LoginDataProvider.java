package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestdataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "/testData/loginData.json");
		FileReader fileReader = new FileReader(testDataFile);
		TestData data = gson.fromJson(fileReader, TestData.class); //de-serialization

		//trying to retrieve the data from testData we have got from .json
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (User user : data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
			return dataToReturn.iterator();
	}
	
	@DataProvider(name = "LoginCSVDataprovider")
	public Iterator<User> loginCSVDataprovider() {
		
		return CSVReaderUtility.readCSVFile("loginData.csv");
		
	}

	@DataProvider(name = "LoginExcelDataprovider")
	public Iterator<User> loginExcelDataprovider() {
		
		return ExcelReaderUtility.readExcelFile("loginData.xlsx");
		
	}
	
}
