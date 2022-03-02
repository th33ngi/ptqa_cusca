package cusca.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cusca.brain.BasePage;
import cusca.utility.WebElements;

public class WikipediaPage extends BasePage{
	WebElements webElement;
	List<WebElement> elements;
	
	public WikipediaPage (WebDriver driver) {
		super(driver);
		webElement = new WebElements(driver);
	}
	
	//Page locator
	By inputName = By.name("search");
	By h1Span = By.xpath("//h1[text()='Selenium']");
	By goButton = By.name("go");
	By aTagName = By.tagName("a");
	By externalLink = By.partialLinkText("Enlaces externos");
	By h2Span = By.xpath("//h2/span[text()='Enlaces externos']");
	
	
	public String getWikipediaPageTitle() {
		return webElement.getPageTitle();
	}
	
	public WikipediaPage searchSelenium(String param) {
		webElement.sendKys(inputName, param);
		webElement.click(goButton);
		return new WikipediaPage(driver);
	}
	
	public Boolean isSelenium() {
		return webElement.isDisplayed(h1Span);
	}
	
	public void enlacesExternos() {
		webElement.click(externalLink);
	}
	
	public Boolean isEnlacesExternos() {
		return webElement.isDisplayed(h2Span);
	}
	
	public TutorialPage getTutorialPage(String param) {
		webElement.selectOption(aTagName, param);
		return new TutorialPage(driver);
	}
}
