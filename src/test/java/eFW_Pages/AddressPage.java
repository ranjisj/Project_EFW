package eFW_Pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import efw_setUp.efw_BaseTest;

public class AddressPage extends efw_BaseTest {
	private static String addAddress = "//button[@type='button' and contains(text(),'Add address')]";
	private static String txt_addressfirstname = "AddressFirstNameNew";
	private static String txt_addresslasttname = "AddressLastNameNew";
	private static String txt_address1 = "//input[@name = 'address[address1]']";
	private static String txt_address2 = "//input[@name = 'address[address2]']";
	private static String txt_city = "//input[@name = 'address[city]']";
	private static String txt_province = "//select[@name = 'address[province]']";
	private static String txt_zip = "//input[@name = 'address[zip]']";
	private static String txt_phone = "//input[@name = 'address[phone]']";
	private static String checkbox_default = "//input[@name = 'address[default]']";
	private static String btn_addaddress = "//button[@type='submit' and contains(text(),'Add address')]";

	
//	@FindBy(xpath = "//button[@type='button' and contains(text(),'Add address')]")
//	private WebElement btn_editbutton;
//
//	@FindBy(xpath = "(//input[@name = 'address[address1]']")
//	private WebElement txt_address1;
//
//	@FindBy(xpath = "(//input[@name = 'address[address2]']")
//	private WebElement txt_address2;
//
//	@FindBy(xpath = "(//input[@name = 'address[city]']")
//	private WebElement txt_city;
//
//	@FindBy(xpath = "(//select[@name = 'address[province]']")
//	private WebElement txt_province;
//
//	@FindBy(xpath = "(//input[@name = 'address[zip]']")
//	private WebElement txt_zip;
//
//	@FindBy(xpath = "(//input[@name = 'address[phone]']")
//	private WebElement txt_phone;
//
//	@FindBy(xpath = "(//input[@name = 'address[default]']")
//	private WebElement checkbox_default;
//
//	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Add address')]")
//	private WebElement btn_addaddress;

	public static void userAddressDetail() throws InvalidFormatException, IOException, InterruptedException {
		
		getElement("xpath", addAddress).click();
		
		String path = "C:\\Users\\welcome\\eclipse-workspace\\fwf_project\\src\\test\\resources\\TestData\\EFW_TestDataSheet.xlsx";
		String data = efw_BaseTest.getData("AddressDetails", 1, 0, path);
		System.out.println(data);
		getElement(path, data);
		WebElement element1 = getElement("ID", txt_addressfirstname);
		
		efw_BaseTest.sendKeys(element1, data);
		System.out.println("FirstName is entered");
		Thread.sleep(1000);
		String data2 = efw_BaseTest.getData("AddressDetails", 1, 1, path);
		System.out.println(data2);
		getElement(path, data2);
		WebElement element2 = getElement("ID", txt_addresslasttname);
		efw_BaseTest.sendKeys(element2, data2);
		System.out.println("LastName is entered");
		String data3 = efw_BaseTest.getData("AddressDetails", 1, 2, path);
		System.out.println(data3);
		getElement(path, data3);
		WebElement element3 = getElement("xpath", txt_address1);
		efw_BaseTest.sendKeys(element3, data3);
		System.out.println("address1 is entered");
		String data4 = efw_BaseTest.getData("AddressDetails", 1, 3, path);
		System.out.println(data4);
		getElement(path, data4);
		WebElement element4 = getElement("xpath", txt_address2);
		efw_BaseTest.sendKeys(element4, data4);
		System.out.println("address2 is entered");
		String data5 = efw_BaseTest.getData("AddressDetails", 1, 4, path);
		System.out.println(data5);
		getElement(path, data5);
		WebElement element5 = getElement("xpath", txt_city);
		efw_BaseTest.sendKeys(element5, data5);
		System.out.println("city is entered");
		String data6 = efw_BaseTest.getData("AddressDetails", 1, 5, path);
		System.out.println(data6);
		getElement(path, data6);
		WebElement element6 = getElement("xpath", txt_province);
		efw_BaseTest.sendKeys(element6, data6);
		System.out.println("province is entered");
		String data7 = efw_BaseTest.getData("AddressDetails", 1, 6, path);
		System.out.println(data7);
		getElement(path, data7);
		WebElement element7 = getElement("xpath", txt_zip);
		efw_BaseTest.sendKeys(element7, data7);
		System.out.println("zip is entered");
		String data8 = efw_BaseTest.getData("AddressDetails", 1, 7, path);
		System.out.println(data8);
		getElement(path, data8);
		WebElement element8= getElement("xpath", txt_phone);
		efw_BaseTest.sendKeys(element8, data6);
		System.out.println("phone is entered");
		
		getElement("xpath", checkbox_default).click();
		getElement("xpath", btn_addaddress).click();
		

	}
}
