package eFW_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import efw_setUp.efw_BaseTest;

public class HomePage extends efw_BaseTest{
//	
//@FindBy(xpath="//div[@class='site-nav__icons']//a[@href='/account']")
//private static WebElement usericon ;
	
	private static String usericon = "//div[@class='site-nav__icons']//a[@href='/account']";
//	private static String subscriptionPopUp = "//button[contains(text(),'No thanks')]";
	

	private static String subscriptionPopUp = "//button[text()='No thanks']";

//	@FindBy (xpath = "//div[@class='modal__inner']//button[text()='No thanks']")
//	
	//button[contains(text(),'No thanks')]
//	private static WebElement subscriptionPopUpLink;
	
@FindBy (xpath = "//div[@class = 'footer__newsletter'] //input[@name = 'contact[email]']")
private WebElement newsletteremail;

@FindBy (xpath = "//div[@class=\"header-item header-item--split-left\"] //a[@href=\"/collections/shop-by-category\"]")
private WebElement headershopcategory;

@FindBy (xpath = "//div[@class='site-nav__dropdown megamenu text-left'] //a[@href='/collections/kanz-kota-suits']")
private WebElement drpdwncollections ;



public static void clickProfileIcon() throws InterruptedException {
//	getElement("xpath", usericon).click();
		
		Thread.sleep(3000);
//	efw_BaseTest.wait_ElementToBeClickable(10,subscriptionPopUpLink,"No thanks");
		getElement("xpath", subscriptionPopUp).click();
//		Thread.sleep(5000);
		getElement("xpath", usericon).click();
		
}

	
}
