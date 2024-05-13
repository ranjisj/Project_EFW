package eFW_Pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import efw_setUp.efw_BaseTest;

public class CreateAccountPage extends efw_BaseTest{
	
//	@FindBy(id = "FirstName")
//	private WebElement txt_firstname;
//
//	@FindBy(id = "LastName")
//	private WebElement txt_lastname;
//	
//	@FindBy(id = "Email")
//	private WebElement txt_email;
//
//	@FindBy(id = "CreatePassword")
//	private WebElement txt_createpassword;
//	
//	@FindBy(xpath= "//input[@value = 'Create']")
//	private WebElement btn_createaccount;
	
	private static String createAccount = "//a[@id='customer_register_link']";
	private static String txt_firstname = "FirstName";
	private static String txt_lastname = "LastName";
	private static String txt_email = "Email";
	private static String txt_createpassword = "CreatePassword";
	private static String btn_createaccount = "//input[@value = 'Create']";
	private static String errorMsg = "//div[@class='errors']//li";
	
	
public static void createUser() throws InterruptedException, InvalidFormatException, IOException {
		try {
			
		
	 	getElement("xpath", createAccount).click();
	 	
		String path = "C:\\Users\\welcome\\eclipse-workspace\\fwf_project\\src\\test\\resources\\TestData\\EFW_TestDataSheet.xlsx";
		String data = efw_BaseTest.getData("CreateAcctCredentials", 1, 0, path);
		System.out.println(data);
		getElement(path, data);
		WebElement element1 = getElement("ID", txt_firstname);
		
		efw_BaseTest.sendKeys(element1, data);
		System.out.println("FirstName is entered");
		Thread.sleep(1000);
		String data2 = efw_BaseTest.getData("CreateAcctCredentials", 1, 1, path);
		System.out.println(data2);
		getElement(path, data2);
		WebElement element2 = getElement("ID", txt_lastname);
		efw_BaseTest.sendKeys(element2, data2);
		System.out.println("LastName is entered");
		String data3 = efw_BaseTest.getData("CreateAcctCredentials", 1, 2, path);
		System.out.println(data3);
		getElement(path, data3);
		WebElement element3 = getElement("ID", txt_email);
		efw_BaseTest.sendKeys(element3, data3);
		System.out.println("Email is entered");
		String data4 = efw_BaseTest.getData("CreateAcctCredentials", 1, 3, path);
		System.out.println(data4);
		getElement(path, data4);
		WebElement element4 = getElement("ID", txt_createpassword);
		efw_BaseTest.sendKeys(element4, data4);
		System.out.println("Password is entered");
		element4.sendKeys(Keys.ENTER);
//		getElement("xpath", btn_createaccount).click();
		System.out.println("CreateAcct button is clicked");
		Thread.sleep(40000);
//		String data3 = efw_BaseTest.getData("CreateAcctCredentials", 1, 4, path);
//		boolean UsernameVerify = userName.contains(data3);
//		WebElement element4 = getElement("xpath", userName);
//		efw_BaseTest.assertEquals(data3, element4.getText(), "equal");
		WebElement eleErrorMessage = getElement("xpath", errorMsg);
		String dataErrorMessage = efw_BaseTest.getData("CreateAcctCredentials", 1, 4, path);
		efw_BaseTest.assertEquals(dataErrorMessage, eleErrorMessage.getText(), "equal");
		System.out.println("Error Message has been Verified");
		test.log(Status.PASS, "Successful CreateUser ");
		} 
		
		catch (Exception e) {
			test.log(Status.FAIL, "Unable to CreateUser "+e.getMessage());
		}
	}
	
	
}
