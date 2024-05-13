package efw_setUp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.ExcelReader;
import base.BaseClass;
import base.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class efw_BaseTest extends BaseClass {

	public static Properties prop = new Properties();
	protected static ExtentReports extent;
	protected static ExtentTest test;
	public static String timeStamp = currentDate();
	protected static ExcelReader testData = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\EFW_TestDataSheet.xlsx");
	public efw_BaseTest() {
		this.driver = DriverManager.getDriver();
	}

	public static void configProperty() {
		try {
			InputStream input = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.Properties");
			prop.load(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void browserSetUp(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_value.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extension");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-incognito");
			options.addArguments("--start-maximized");
//			options.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver(options);
//			((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%';");

		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + prop.getProperty("EdgeDriverPath"));
			driver = new EdgeDriver();

		}
	}

	public static void generateReport() throws IOException {
		ExtentSparkReporter spark_all = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\ExtentReport\\AutomationReport_" + timeStamp + ".html");
		spark_all.loadXMLConfig(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Report_config\\report_config.xml");
		

		ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\ExtentReport\\AutomationReport_Failure" + timeStamp + ".html");
		sparkReporter_failed.loadXMLConfig(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Report_config\\report_config.xml");
		sparkReporter_failed.filter().statusFilter().as(new Status[] { Status.FAIL }).apply();
//		extent.attachReporter(spark_all, sparkReporter_failed);
		extent = new ExtentReports();
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("UserName", System.getProperty("user.name"));
		extent.setSystemInfo("HoseName", InetAddress.getLocalHost().getHostName());

//		
		
		
	}
	
	public static Long wait_Time() {
		String value = prop.getProperty("Time");
		Long time = Long.parseLong(value);
		return time;
		

	}

	
	
}
