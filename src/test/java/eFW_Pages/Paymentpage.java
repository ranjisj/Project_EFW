package eFW_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Paymentpage {
	
	@FindBy(xpath = "//input[@id=\"TextField0\"]")
	private WebElement txt_giftcode;

	@FindBy(xpath = "//input[@id='billing_address_selector-custom_billing_address']")
	private WebElement radiobtn_billingaddress;
	
	@FindBy(xpath = "//input [@id='billing-address1']")
	private WebElement txt_billingaddress;
	
	@FindBy(xpath = "//input[@id='TextField9']")
	private WebElement txt_billingaddress2;
	
	@FindBy(xpath = "//input[@id='TextField10']")
	private WebElement txt_city;
	
	@FindBy(xpath = "//select[@id='Select4']")
	private WebElement txt_state;
	
	@FindBy(xpath = "//input[@id='TextField11']")
	private WebElement txt_pincode;
	
	@FindBy(xpath = "//input[@id='TextField12']")
	private WebElement txt_deliveryupdate;
	
	@FindBy(xpath = "//div[@id='pay-button-container'] //button[@type='submit']")
	private WebElement btn_paynow;
	
	

}
