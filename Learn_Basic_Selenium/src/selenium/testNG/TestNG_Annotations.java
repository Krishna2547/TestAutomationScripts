package selenium.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Annotations {
	
  @Test(priority=1,description="1st Test Method",alwaysRun=true,groups= {"A"})
  public void abc() {
	  System.out.println("abc");
  }
  
  @Test(priority=2,description="2nd Test Method",alwaysRun=false,groups= {"B"},dependsOnMethods="abc")
  public void def() {
	  System.out.println("def");
  }
  
  @Test(priority=3,description="3rd Test Method",alwaysRun=false,groups= {"A"},enabled=false)
  public void ghi() {
	  System.out.println("ghi");
  }
  
  @Test(priority=4,description="4st Test Method",alwaysRun=true,groups= {"B"})
  public void jkl() {
	  System.out.println("jkl");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Let the action begin");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("***** The End *****");
  }

}
