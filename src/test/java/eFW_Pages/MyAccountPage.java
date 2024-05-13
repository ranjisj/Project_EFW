package eFW_Pages;

import com.aventstack.extentreports.Status;

import efw_setUp.efw_BaseTest;

public class MyAccountPage extends efw_BaseTest {
	
	private static String view_address = "//a[@class='text-link' and contains(text(),'View addresses')]";
	
//	@FindBy(xpath = "//a[@href='/account/address']")
//	private WebElement viewaddress_link;
	
	
	public static void userAddress() {
		try {
			
		getElement("xpath", view_address).click();
		test.log(Status.PASS, "Successfully clicked the view address ");
} 
		
		catch (Exception e) {
			test.log(Status.FAIL, "Unable to Click the View Address "+e.getMessage());
		}
	}
	
	
	
	

}
