package DataProvider;

import org.testng.annotations.DataProvider;

import Utilities.ExcelLibrary;

public class DataProviders {
	ExcelLibrary obj = new ExcelLibrary();
	
	@DataProvider(name = "credentials")
	public Object[][] getAccountData(){
		int rowCount =obj.getRowCount("Credentials");
		int colCount = obj.getColumnCount("Credentials");
		int actRowCount = rowCount -1 ;
		Object [][] data = new Object[rowCount][colCount]; 
		for(int i=0; i< actRowCount ; i++) {
			for(int j=0; j< colCount; j++)
			{
				data[i][j] = obj.getCellData("Credentials", j, i+2);
			}
		}
		return data;
	}
}
