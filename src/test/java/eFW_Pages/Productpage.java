package eFW_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productpage {

	@FindBy(xpath = "//div[@data-value='S'] //label[@class='variant__button-label']")
	private WebElement btn_productsize;

	@FindBy(xpath = "//button[@id = 'AddToCart-8404202651871']")
	private WebElement btn_addtocart;

}
