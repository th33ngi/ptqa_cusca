package cusca.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cusca.brain.BasePage;
import cusca.utility.WebElements;


public class GooglePage extends BasePage{
	WebElements webElement;
	List<WebElement> elements;

	public GooglePage (WebDriver driver) {
		super(driver);
		webElement = new WebElements(driver);
	}
	
	//Page locator
	By inputName = By.name("q");
	By aTagName = By.tagName("a");
	By span = By.xpath("//div[@class='tF2Cxc']//h3[text()='Wikipedia']");
	
	public String getGooglePageTitle() {
		return webElement.getPageTitle();
	}
	
	public GooglePage searchWikiPage(String param) {
		webElement.sendKeys(inputName, param);
		return new GooglePage(driver);
	}
	
	public WikipediaPage getWikipediaPage(String param) {
		webElement.selectOption(aTagName, param);
		return new WikipediaPage(driver);
	}
	
	public Boolean isWikipedia() {
		return	webElement.isDisplayed(span);
	}
}