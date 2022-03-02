package cusca.utility;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cusca.brain.BasePage;


public class WebElements extends BasePage{
	JavascriptExecutor js;
	WebElement element;
	
	public WebElements(WebDriver driver) {
		super(driver);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		List<WebElement> elements = driver.findElements(locator);
		return elements;	
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void sendKys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public void sendKeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}
	
	public void closeWindow() {
		driver.close();
	}
	
	public Boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void selectOption(By locator, String txt) {
		List<WebElement> options = findElements(locator);
		for (WebElement option: options) {
	        if(txt.equals(option.getAttribute("href"))){
	        	option.click();
	        	break;
	        }
	    }
	}
}