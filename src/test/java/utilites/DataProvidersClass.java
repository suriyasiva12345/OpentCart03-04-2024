package utilites;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidersClass 

{

	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException
	{
		String path = "F:\\Java Set up\\Day 01\\OpenCart\\testDatas\\Opencart_LoginData.xlsx";
		
		ExcelUtilites xlutils = new ExcelUtilites(path);
		
		int totalRows = xlutils.getRowsCount("Sheet1");
		
		int totalCells = xlutils.getCellsCount("Sheet1", 1);
		
		String LoginData[][] = new String[totalRows][totalCells];
		
		for(int r = 1;r<=totalRows;r++)
		{
			for(int c=0;c<totalCells;c++)
			{
				LoginData[r-1][c] = xlutils.getCellsData("Sheet1", r, c);
			}
		}
		
		return LoginData;
	}
}
