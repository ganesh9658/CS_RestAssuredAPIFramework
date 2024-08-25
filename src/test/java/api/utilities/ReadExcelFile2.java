package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile2 {

	public static FileInputStream fileInputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFCell cell ;
	public static XSSFRow row;
	
	public static String getCellValue(String fileName, String sheetName, int rowNo,int CellNo )
	{
		try {
			
			fileInputStream=new FileInputStream(fileName);
			workBook=new XSSFWorkbook(fileInputStream);
			excelSheet=workBook.getSheet(sheetName);
			cell=workBook.getSheet(sheetName).getRow(rowNo).getCell(CellNo);
			
			workBook.close();
			
			return cell.getStringCellValue();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
		
	}
	public static int getRowCount(String fileName,String sheetName)
	{
		try {
			fileInputStream=new FileInputStream(fileName);
			workBook=new XSSFWorkbook(fileInputStream);
			excelSheet=workBook.getSheet(sheetName);
			
			int ttlrows=excelSheet.getLastRowNum()+1;
			workBook.close();
			return ttlrows;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
		
	}
	
	public static int getCellCount(String fileName,String sheetName) throws IOException
	{
		try {
			fileInputStream=new FileInputStream(fileName);
			workBook=new XSSFWorkbook(fileInputStream);
			excelSheet=workBook.getSheet(sheetName);
			
			int ttlCells=excelSheet.getRow(0).getLastCellNum();
			workBook.close();
			
			return ttlCells;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
		
	}
}
