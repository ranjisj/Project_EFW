package efw_Runner;


import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.Status;


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
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName() + "" + capabilities.getBrowserVersion();
		test=extent.createTest(context.getName().toUpperCase());
		test.assignDevice(device);
		
	}
	
   @AfterTest
   public void checkStatus(Method m, XmlTest xmlTest, ITestResult result) {
	if (result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL, result.getThrowable());
	}
	else if (result.getStatus()==ITestResult.SKIP) {
		test.log(Status.SKIP, result.getThrowable());
	}
	else {
		test.log(Status.PASS, m.getName().toUpperCase()+" is Passed");
	}
	test.assignCategory(xmlTest.getName());
}
       
  @AfterSuite
  public void endTest() {
	  
//	  driver.manage().deleteAllCookies(); // Deletes all the cookies
	driver.quit();
	extent.flush();

}
  
}
