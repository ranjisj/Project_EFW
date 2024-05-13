package ewf_TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import eFW_Pages.HomePage;
import eFW_Pages.LoginPage;
import efw_Runner.RunnerSetUP;


public class TC_02_Userlogin extends RunnerSetUP{
	@Test 
	public void loginScreen() throws InterruptedException, InvalidFormatException, IOException, AWTException {
		HomePage.clickProfileIcon();
		LoginPage.loginUser();
//		LoginPage loginPage = new LoginPage();
//		loginPage.txtPassing();
}
}