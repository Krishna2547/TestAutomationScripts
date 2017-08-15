package selenium.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class TestNG_DataProvider {
  
	@Test(priority=1, dataProvider = "TestData", groups= {"A"})
  public void PrintData(Integer n, String s) {
		System.out.println("the integer value is"+n);
		System.out.println("the string value is "+s);
  }
	
	@Test(priority=0, dataProvider="Numdata", groups= {"B"})
	public void WriteData(Integer a, Integer b) {
		
		System.out.println("The first value: "+a);
		System.out.println("The Second value: "+b);
	}
  
	@BeforeMethod
  public void beforeMethod() {
		System.out.println("Before Method");
  }

  
	@AfterMethod
  public void afterMethod() {
		System.out.println("After Method");
		
  }

@DataProvider(name="Numdata")
public Object[][] getdata(){
	
	Object[][] data=new Object[3][2];
	data[0][0]=23;
	data[0][1]=31;
	
	data[1][0]=42;
	data[1][1]=54;
	
	data[2][0]=61;
	data[2][1]=75;
	
	return data;
	
}
	
	
  @DataProvider(name="TestData")
  public Object[][] TestData() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      new Object[] { 3, "c" },
    };
  }
}
