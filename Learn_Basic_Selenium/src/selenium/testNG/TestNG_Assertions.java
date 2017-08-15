package selenium.testNG;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertions {
  
@Test(enabled=false)
  public void testSoft() {
		
		SoftAssert assertion = new SoftAssert();
		System.out.println("Before asserting");
		assertion.assertEquals(34, 43);
		System.out.println("After asserting");
		assertion.assertAll();
		
  }

@Test(enabled=false)
public void testHard() {
	
	System.out.println("before hard asserting");
	Assert.assertEquals(11, 15);
	System.out.println("After hard assering");
}

@Test
public void remAsserts() {
	
	Assert.assertFalse(3<2, "The expected condition found to be false");
	Assert.assertNotEquals(45, 45, 0);
	Assert.assertTrue(5>2);
	Assert.fail("Test case failed");
	
}
}
