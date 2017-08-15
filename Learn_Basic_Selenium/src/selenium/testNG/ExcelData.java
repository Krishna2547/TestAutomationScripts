package selenium.testNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExcelData {
	

	@Parameters({"ExcelPath"})
	@Test(priority=1)
	public void ReadData(String Epath) throws Exception {
		FileInputStream fis=new FileInputStream(Epath);
		@SuppressWarnings("resource")
		 XSSFWorkbook wb = new XSSFWorkbook(fis);		
	XSSFSheet sh1=wb.getSheet("Sheet1");
	
	int NumOfRows=sh1.getLastRowNum();
	for(int i=0; i<=NumOfRows; i++) {
		for(int j=0;j<2;j++) {
			
			System.out.print(sh1.getRow(i).getCell(j).getStringCellValue());
			System.out.print("   ");
		}
		System.out.println(" ");
	}
	wb.close();
	}
	
	@Parameters({"ExcelPath"})
	@Test(priority=2)
	public void WriteData(String Epath) throws Exception {
		
		FileInputStream fis=new FileInputStream(Epath);
		@SuppressWarnings("resource")
		 XSSFWorkbook wb = new XSSFWorkbook(fis);	
		XSSFSheet sh1=wb.getSheet("Sheet1");
		
		sh1.getRow(0).createCell(2).setCellValue("You Rock!");
		
		FileOutputStream fos=new FileOutputStream(Epath);
		
		wb.write(fos);
		wb.close();
	}
	
}
