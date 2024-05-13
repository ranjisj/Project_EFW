package base;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	protected static WebDriverWait wait ;
	
	// get Driver Launch

				public void getdriver() {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
	//Maximize
				public void maximize() {
					driver.manage().window().maximize();
				}			
	// get current Url

				public static String getcurent() {
					String currentUrl = driver.getCurrentUrl();
					return currentUrl;
				}
	//To load Url

				public static void loadUrl(String url , long waitTime) {
					wait=new WebDriverWait(driver, Duration.ofSeconds(waitTime));
					driver.get(url);
					wait.until(ExpectedConditions.urlToBe(url));
					}
				
	// Inerst value in Textbox

				public static void sendKeys(WebElement element, String data) {
					element.sendKeys(data);
				}

			
	//Insert the value using js
	public static void setAttributewithjs(String attributevalue, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + attributevalue + "')", element);
	}

	//  drag and Drop
		public void dragAndDrop(WebElement element) {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(element, element).perform();
			
		}	
  // moveto Elelmment
			public void moveToElement(WebElement element) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element).perform();
			}
//  SimpleAlert
			public void simpleAlert() {
				Alert al = driver.switchTo().alert();
				al.accept();
			}
			
//  scrollDown
			public static void scrollDown(WebElement element) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true)", element);
			}
// scrollUp
			public void scrollUp(WebElement element) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(false)", element);
			}
			
// TakeScreenShord
			public void getScreenShot(String path) throws IOException {
				TakesScreenshot tk = (TakesScreenshot) driver;
				File source = tk.getScreenshotAs(OutputType.FILE);
				System.out.println(source);
				File des = new File(path);
				System.out.println(des);
				FileUtils.copyFile(source, des);
			}
//to click button

			public static void click(WebElement element) {
				element.click();
			}
// Find locator using id

			public WebElement findElementById(String attributevalue) {
				WebElement element = driver.findElement(By.id(attributevalue));
				return element;
			}
// Find locator using name

			public WebElement findElementByName(String attributevalue) {
				WebElement element = driver.findElement(By.name(attributevalue));
				return element;
			}
//Find locator using className

			public WebElement findElementByClassName(String attributevalue) {
				WebElement element = driver.findElement(By.className(attributevalue));
				return element;
			}
//Find locator using xpath

			public static WebElement findElementByxpath(String attributevalue) {
				WebElement element = driver.findElement(By.xpath(attributevalue));
				return element;
			}
		
//Quit
			public void quit() {
				driver.quit();
			}

// Close
			public void close() {
				driver.close();
			}

//wait
			public void waittime(long value) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		
//locator
			public static WebElement getElement(String locatorName, String locatorValue) {
				switch (locatorName.toUpperCase()) {
				case "XPATH":
					return driver.findElement(By.xpath(locatorValue));
				case "ID":
					return	driver.findElement(By.id(locatorValue));
				case "CLASSNAME":
					return	driver.findElement(By.className(locatorValue));
				case "CSSSELECTOR":
					return	driver.findElement(By.cssSelector(locatorValue));
				case "LINKTEXT":
					return	driver.findElement(By.linkText(locatorValue));
				case "NAME":
					return	driver.findElement(By.name(locatorValue));
				case "PARTIALLINKTEXT":
					return	driver.findElement(By.partialLinkText(locatorValue));
				case "TAGNAME":
					return	driver.findElement(By.tagName(locatorValue));

				default:
					return null;
				}
			}
			
//timestamp
			
			public static String currentDate() {
				
				String curtDate= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				return curtDate;

			}
			
			public static void wait_ElementToBeClickable(long waitTime, WebElement element, String text) {
				
				wait= new WebDriverWait(driver, Duration.ofSeconds(waitTime));
				wait.until(ExpectedConditions.textToBePresentInElement(element, text));
				
				
			}
			
public static void wait_textToBePresentInElementValue(long waitTime, WebElement element, String text) {
				
				wait= new WebDriverWait(driver, Duration.ofSeconds(waitTime));
				wait.until(ExpectedConditions.textToBePresentInElement(element, text));
				
				
			}

public static String getData(String sheetName, int rownum, int cellnum, String path)
		throws IOException, InvalidFormatException {
	String data = null;
	File file = new File(path);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	CellType type = cell.getCellType();
	switch (type) {
	case STRING:
		data = cell.getStringCellValue();
		break;
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cell)) {
			data = new SimpleDateFormat("dd-MMM-yy").format(cell.getDateCellValue());
		} else {
			data = BigDecimal.valueOf(cell.getNumericCellValue()).toString();
		}
		break;

	default:
		break;
	}
	return data;
}

public static void assertEquals(String actual, String expected, String message) {
    Assert.assertEquals(actual, expected, message );
}

public static void assertTrue(boolean condition, String message) {
    Assert.assertTrue(condition, message);
}



}
