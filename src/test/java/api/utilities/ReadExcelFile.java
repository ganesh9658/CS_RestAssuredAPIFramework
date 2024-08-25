package api.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static FileInputStream fileinputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFCell cell;
	public static XSSFRow  row;
	
	public static String getCellValue(String filename,String sheetname, int rowNo, int cellNo /* column no*/)
	{
		
		try {
			 fileinputStream=new FileInputStream(filename);
			 workBook=new XSSFWorkbook(fileinputStream);
			 excelSheet=workBook.getSheet(sheetname);
			 cell=workBook.getSheet(sheetname).getRow(rowNo).getCell(cellNo);
			
			workBook.close();
			
			return cell.getStringCellValue();
		} 
		catch (Exception e) 
		{
			return "";
		}
	
	}
		public static int getRowCount(String fileName,String sheetName)
		{
			try {
				
				fileinputStream=new FileInputStream(fileName);
				//create XSSFWorkBook Class object for excel file manipulation
				
				workBook =new XSSFWorkbook(fileinputStream);
				excelSheet=workBook.getSheet(sheetName);
				
				int ttlrows=excelSheet.getLastRowNum()+1;
				
				workBook.close();
				
				return ttlrows;
				
			} catch (Exception e) 
			{
				// TODO: handle exception
			}
			return 0;
			
		}
	
	public static int getCellCount(String fileName, String SheetName)
	{
		try {
			fileinputStream=new FileInputStream(fileName);
			//create XSSFWorkBook Class object for excel file manipulation
			workBook=new XSSFWorkbook(fileinputStream);
			excelSheet=workBook.getSheet(SheetName);
			
			//get total no of columns
			int ttlCells=excelSheet.getRow(0).getLastCellNum();
			workBook.close();
			
			return ttlCells;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
		
	}

}
