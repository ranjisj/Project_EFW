package eFW_Pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import efw_setUp.efw_BaseTest;

public class TrackingPage extends efw_BaseTest {
	

	private static String trackOrderTitle = "//div[@class='toolbar__content']//a[text()='TRACK ORDER']";
	private static String trackNumber = "//input[@id='tracktorOrderName']";
	private static String trackEmail = "//input[@id='tracktorOrderEmail']";
	private static String track_btn = "//button[@id='tracktorTrack']";
	private static String errorIncorrectOrder = "//section[@id='tracktorOrderDetails']//h1";
	
	public static void trackDetails() throws InvalidFormatException, IOException, InterruptedException {

		getElement("xpath", trackOrderTitle).click();
		WebElement element = getElement("XPATH", trackNumber);
		scrollDown(element);
		String path = "C:\\Users\\welcome\\eclipse-workspace\\fwf_project\\src\\test\\resources\\TestData\\EFW_TestDataSheet.xlsx";
		String data = efw_BaseTest.getData("TrackingDetails", 1, 0, path);
		efw_BaseTest.sendKeys(element, data);
		String data2 = efw_BaseTest.getData("TrackingDetails", 1, 1, path);
		WebElement element2 = getElement("XPATH", trackEmail);
		efw_BaseTest.sendKeys(element2, data2);
		Thread.sleep(1000);
		getElement("XPATH", track_btn).click();
		String data5 = efw_BaseTest.getData("TrackingDetails", 1, 2, path);
		errorIncorrectOrder.equals(data5);
		System.out.println("COULD NOT FIND ORDER Error Message has been Verified");
		Thread.sleep(2000);
		WebElement element4 = getElement("xpath", errorIncorrectOrder);
		efw_BaseTest.assertEquals(data5, element4.getText(), "equal");
		System.out.println("assert verified");
	}
}
