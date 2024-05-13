package eFW_Pages;

import efw_setUp.efw_BaseTest;

public class MyAccountPage extends efw_BaseTest {
	
	private static String view_address = "//a[@class='text-link' and contains(text(),'View addresses')]";
	
//	@FindBy(xpath = "//a[@href='/account/address']")
//	private WebElement viewaddress_link;
	
	
	public static void userAddress() {
		getElement("xpath", view_address).click();

	}
	
	
	
	

}
