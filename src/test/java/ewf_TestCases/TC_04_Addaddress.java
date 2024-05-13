package ewf_TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import eFW_Pages.AddressPage;
import eFW_Pages.HomePage;
import eFW_Pages.LoginPage;
import eFW_Pages.MyAccountPage;
import efw_Runner.RunnerSetUP;

public class TC_04_Addaddress extends RunnerSetUP {
	
	
	@Test
	public void addressScreen() throws InterruptedException, InvalidFormatException, IOException {
		HomePage.clickProfileIcon();
		LoginPage.loginUser();
		MyAccountPage.userAddress();
		AddressPage.userAddressDetail();

	}

}
