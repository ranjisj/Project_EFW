package ewf_TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.Test;

import eFW_Pages.HomePage;
import eFW_Pages.LoginPage;
import efw_Runner.RunnerSetUP;

public class TC_01_LoginPage extends RunnerSetUP{

	@Test
	public void PopUPscreen() throws InterruptedException {
		HomePage.clickProfileIcon();
	

	}
	
}
