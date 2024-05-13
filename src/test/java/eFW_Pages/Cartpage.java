package eFW_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cartpage {

	@FindBy(xpath = "//input[@id='CartTerms']")
	private WebElement checkbox_cartterms;

	@FindBy(xpath = "//button[@class=\"btn cart__checkout\"]")
	private WebElement btn_checkout;

}
