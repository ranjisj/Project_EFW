package eFW_Pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import efw_setUp.efw_BaseTest;

public class LoginPage extends efw_BaseTest{
//	public LoginPage() {
//		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//	}
//	@FindBy(xpath="//div[@id='CustomerLoginForm']//input[@name='customer[email]']")
//	private static WebElement txt_emailid;
	
	private static String txt_emailid1 = "//div[@id='CustomerLoginForm']//input[@name='customer[email]']";
	private static String txt_password1 = "//div[@id='CustomerLoginForm']//input[@name='customer[password]']";
	private static String signIn_btn = "//button[@type='submit' and contains(text(),'Sign In')]";
	private static String userName = "//div[@class = 'grid__item medium-up--one-third']//p[@class='h5']";
//	private static String myAccount = "//h1[text()='My account']";
	
//	@FindBy(xpath="//input[@id='CustomerEmail']")
//	public static WebElement txt_emailid;
//
//	@FindBy(xpath="//div[@id='CustomerLoginForm']//input[@name='customer[password]']")
//	public static WebElement txt_pass;
//
//	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Sign In')]")
//	public static WebElement btn_signIn;
//
//	@FindBy(id = "customer_register_link")
//	public static WebElement create_acct_link;
//
//	@FindBy(id = "CustomerLoginForm")
//	private WebElement loginform;
//
//	@FindBy(xpath = "//h1[@class='section-header__title' and contains(text(),'Login')]")
//	private WebElement logintitle;
//	
	
//	public WebElement getTxt_emailid() {
//		return txt_emailid;
//	}
//
//
//	public static WebElement getTxt_pass() {
//		return txt_pass;
//	}
//
//
//	public static WebElement getBtn_signIn() {
//		return btn_signIn;
//	}
//
//
//	public WebElement getCreate_acct_link() {
//		return create_acct_link;
//	}
//
//
//	public WebElement getLoginform() {
//		return loginform;
//	}
//
//
//	public WebElement getLogintitle() {
//		return logintitle;
//	}


	public static void loginUser() throws InvalidFormatException, IOException, InterruptedException {
		
		String path = "C:\\Users\\welcome\\eclipse-workspace\\fwf_project\\src\\test\\resources\\TestData\\EFW_TestDataSheet.xlsx";
		String data = efw_BaseTest.getData("LoginCredentials", 1, 0, path);
		System.out.println(data);
		getElement(path, data);
		WebElement element1 = getElement("XPATH", txt_emailid1);
		efw_BaseTest.sendKeys(element1, data);
		Thread.sleep(1000);
		String data2 = efw_BaseTest.getData("LoginCredentials", 1, 1, path);
		System.out.println(data2);
		getElement(path, data2);
		WebElement element2 = getElement("XPATH", txt_password1);
		efw_BaseTest.sendKeys(element2, data2);
		System.out.println("Password is entered");
//		element2.sendKeys(Keys.ENTER);
//		getElement("xpath", signIn_btn);
		getElement("xpath", signIn_btn).click();
		System.out.println("Sign In button is clicked");
//		Thread.sleep(2000);
//		WebElement element4 = getElement("xpath", myAccount);
//		boolean acct = (element4.getText()).contains("MY ACCOUNT");
//		System.out.println(element4);
//		Assert.assertTrue(acct, "My Account is verified");
//		String data3 = efw_BaseTest.getData("LoginCredentials", 1, 2, path);
//		boolean UsernameVerify = userName.contains(data3);
//		WebElement element4 = getElement("xpath", userName);
//		efw_BaseTest.assertEquals(data3, element4.getText(), "equal");
		
	}
}

   
