package ewf_TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import eFW_Pages.CreateAccountPage;
import eFW_Pages.HomePage;
import efw_Runner.RunnerSetUP;

public class TC_03_CreateAccountScreen extends RunnerSetUP {

	@Test
	public void PopUPscreen() throws InterruptedException, InvalidFormatException, IOException {
		HomePage.clickProfileIcon();
		CreateAccountPage.createUser();
		
}}
