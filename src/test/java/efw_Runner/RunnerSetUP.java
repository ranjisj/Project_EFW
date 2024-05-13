package efw_Runner;

import java.io.IOException;

import org.apache.hc.core5.http.Method;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Test;

import efw_setUp.efw_BaseTest;

public class RunnerSetUP extends efw_BaseTest{
	
	@BeforeSuite
    public void intialSetup() throws IOException {
		generateReport();
		configProperty();
		
		try {
			browserSetUp(prop.getProperty("BrowserName"));
			driver.manage().deleteAllCookies();
			loadUrl(prop.getProperty("URL"), wait_Time());
			
		} catch (Exception e) {
			
			
		}
		
		
	}
	
	@BeforeTest
	
	public void startTest(ITestContext context) {
		test=extent.createTest(context.getName().toUpperCase());

	}
   @AfterMethod
   public void checkStatus(java.lang.reflect.Method m, ITestResult result) {
	if (result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL, result.getThrowable());
	}
	else if (result.getStatus()==ITestResult.SKIP) {
		test.log(Status.SKIP, result.getThrowable());
	}
	else {
		test.log(Status.PASS, m.getName().toUpperCase()+" is Passed");
	}
}
       
  @AfterSuite
  public void endTest() {
	  
//	  driver.manage().deleteAllCookies(); // Deletes all the cookies
//	driver.quit();
	extent.flush();

	

}
  
  @AfterClass
  
  public void reportFlush() {
		


}


}
