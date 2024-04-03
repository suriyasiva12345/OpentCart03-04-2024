package utilites;

import java.io.File;
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

public class ExcelUtilites {

	
	public FileInputStream fileInput;
	public FileOutputStream fileOutput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow rows;
	public XSSFCell cells;
	public CellStyle cellStyle;
	
	String path;
	public ExcelUtilites(String path) 
	{
		this.path = path ;
	}

	
	public int getRowsCount(String sheetName) throws IOException
	{
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		
		workbook.close();
		fileInput.close();
		
		return rowCount;
	}
	
	public int getCellsCount(String sheetName,int rowNum ) throws IOException
	
	{
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		rows = sheet.getRow(rowNum);
		int cellCount = rows.getLastCellNum();
		
		workbook.close();
		fileInput.close();
		return cellCount;
		
	}
	
   public String getCellsData(String sheetName,int rowNum ,int cellNum) throws IOException
	
	{
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		rows = sheet.getRow(rowNum);
		cells = rows.getCell(cellNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try 
		{
		 data = formatter.formatCellValue(cells);
		}
		catch(Exception e)
		{
			data = " ";
		}
		
		workbook.close();
		fileInput.close();
		return data;
		
	}
   
   public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fileOutput=new FileOutputStream(path);
		workbook.write(fileOutput);
		}
				
		fileInput=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInput);
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			{
			workbook.createSheet(sheetName);
			}
		sheet=workbook.getSheet(sheetName);
					
		if(sheet.getRow(rownum)==null) 
		{// If row not exists then create new Row
				sheet.createRow(rownum);
		}
		rows=sheet.getRow(rownum);
		
		cells=rows.createCell(colnum);
		cells.setCellValue(data);
		fileOutput=new FileOutputStream(path);
		workbook.write(fileOutput);		
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}
   
   public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
	   fileInput=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetName);
		
		rows=sheet.getRow(rownum);
		cells=rows.getCell(colnum);
		
		cellStyle=workbook.createCellStyle();
		
		cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cells.setCellStyle(cellStyle);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}
	
	
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fileInput=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetName);
		rows=sheet.getRow(rownum);
		cells=rows.getCell(colnum);
		
		cellStyle=workbook.createCellStyle();
		
		cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cells.setCellStyle(cellStyle);		
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}
}
