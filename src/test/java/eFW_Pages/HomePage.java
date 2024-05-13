package eFW_Pages;

import com.aventstack.extentreports.Status;

import efw_setUp.efw_BaseTest;

public class HomePage extends efw_BaseTest {

	private static String usericon = "//div[@class='site-nav__icons']//a[@href='/account']";
	private static String subscriptionPopUp = "//button[text()='No thanks']";

	public static void clickProfileIcon() throws InterruptedException {
		try {
			Thread.sleep(3000);

			getElement("xpath", subscriptionPopUp).click();

			getElement("xpath", usericon).click();
			test.log(Status.PASS, "UserIcon is Clicked");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to click the UserIcon : "+e.getMessage());
		}

		

	}

}
