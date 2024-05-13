package eFW_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import efw_setUp.efw_BaseTest;

public class Cartpage extends efw_BaseTest {
	
	private static String checkbox_cartterms = "//input[@id='CartTerms']";
	private static String btn_checkout = "//button[@class=\"btn cart__checkout\"]";

//	@FindBy(xpath = "//input[@id='CartTerms']")
//	private WebElement checkbox_cartterms;
//
//	@FindBy(xpath = "//button[@class=\"btn cart__checkout\"]")
//	private WebElement btn_checkout;
	 
	public static void userheckout() {
		try {
			
		getElement("xpath", checkbox_cartterms).click();
		getElement("xpath", btn_checkout).click();
		
		test.log(Status.PASS, "The pop-up has occured successfully");

	} catch (Exception e) {
		test.log(Status.FAIL, "The pop-up has not occured successfully "+e.getMessage());
	}
		

	}

}
