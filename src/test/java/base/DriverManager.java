package base;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class DriverManager {
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	public static WebDriver getDriver() {
		return dr.get();
	}
public static void setWebDriver(WebDriver driver) {
	dr.set(driver);
}
public static  ExtentTest getExtentReport() {
	return testReport.get();

}
public static void setExtentReport(ExtentTest test) {
	testReport.set(test);

}
}
