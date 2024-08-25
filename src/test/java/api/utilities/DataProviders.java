package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="AllData")
	public String[][] AllDataProvider()
	{
		String fname=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttlRowNo=ReadExcelFile.getRowCount(fname, "Sheet1");
		int ttlCellNo=ReadExcelFile.getCellCount(fname, "Sheet1");
		
		String userData[][]=new String[ttlRowNo-1][ttlCellNo];
		
		for(int rowNo=1;rowNo<ttlRowNo;rowNo++)
		{
			for(int CellNO=0;CellNO<ttlCellNo;CellNO++)
			{
				userData[rowNo-1][CellNO]=ReadExcelFile.getCellValue(fname, "Sheet1", rowNo, CellNO);
			}
		}
		
		
		return userData;
		
	}
	
	@DataProvider(name="UserName")
	public String[] UserNameData()
	{
		String fname=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		int ttlRowNo=ReadExcelFile.getRowCount(fname, "Sheet1");
		
		//String userData[]=new String[ttlRowNo-1];
		String UserName[]=new String[ttlRowNo-1];
		
		System.out.println("Username count is "+UserName);
		for(int rowNo=1;rowNo<ttlRowNo;rowNo++)
		{
			UserName[rowNo-1]=ReadExcelFile.getCellValue(fname, "Sheet1", rowNo, 1);
		}
		return UserName;
		
	}
	
} 
