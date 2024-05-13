package ewf_TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import eFW_Pages.HomePage;
import eFW_Pages.TrackingPage;
import efw_Runner.RunnerSetUP;

public class TC_05_TrackingScreen extends RunnerSetUP{

	@Test
	public void addressScreen() throws InterruptedException, InvalidFormatException, IOException {
		HomePage.clickProfileIcon();
		TrackingPage.trackDetails();
	}
}
