package selenium.testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNG_Listners implements ITestListener{

	//***This listener is implemented in TestNG_ParallelTesting.java***
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("The test execution started. test name is :"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		System.out.println("The test execution sucessfull. Status is :"+result.getStatus());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("The test execution failed. Status is :"+result.getStatus());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("The test execution skipped. test name is :"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}
