package utilities;

import java.io.File;

//page no-1
//6]for data driven test we want utility class.. to get data frome excel sheet and sent to testclass.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilitt {

	public static FileInputStream fi;	//Writting in excel file
	public static FileOutputStream fo;	//Reading in excel file
	public static XSSFWorkbook workbook;		//creating workbook in excel file
	public static XSSFSheet sheet;			//creating sheet in excel file
	public static XSSFRow row;			//creating Row in excel sheet
	public static XSSFCell cell;			//creating cell in excel sheet
	public static CellStyle style;		//providing style(color) to Row's & Cell's
	String path;
	
	public ExcelUtilitt(String path) //this is constructor passing path because creat this no need to add excel path everywhere this constructor will take care of it.
	{
		this.path=path;
	}
	
	//1)Row count...
	public int getRowCount(String sheetName) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}
	
	//2)Cell count...
	public int getCellCount(String sheetName, int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}

	//3)Call Cell Data:-If any data which we want we have to call by calling method.
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell= row.getCell(colnum);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
			data = formatter.formatCellValue(cell); // Return the formate value of a cell as a string regardless
		}
		catch (Exception e)
		{
			data=" ";
		}
		
		workbook.close();
		fi.close();
		return data;
	}
	
	
	//4)SetCellData:- perticuler 4th method we use for writting the data into
	//cell whever we want to written something just call this method.
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
	{
		File  xlfile=new File(path);
		if (!xlfile.exists())
		{
			workbook =new XSSFWorkbook();
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetName)==-1) //If sheet is not exists then create a new sheet
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null) //If row is not exists create  new Row.
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();	
	}
	
	//1)Now feel Green color into cell where test is pass..
	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rownum);
		cell =row.createCell(colnum);
		
		style =workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	//2)Now feel Red color into cell where test is fail..
	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(path);
	    workbook = new XSSFWorkbook(fi);
	    sheet = workbook.getSheet(sheetName);
	    row = sheet.getRow(rownum);
	    cell = row.createCell(colnum);

	    style = workbook.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.RED.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	    cell.setCellStyle(style);

	    fo = new FileOutputStream(path);  // MISSING LINE
	    workbook.write(fo);

	    workbook.close();
	    fi.close();
	    fo.close();
		}
		
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

