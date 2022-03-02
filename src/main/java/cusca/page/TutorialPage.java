package cusca.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cusca.brain.BasePage;
import cusca.utility.WebElements;

public class TutorialPage extends BasePage{
	WebElements webElement;
	List<WebElement> elements;
	
	public TutorialPage (WebDriver driver) {
		super(driver);
		webElement = new WebElements(driver);
	}
	
	//Page locator
	By pText = By.xpath("//p[text()='Selenium es un set de herramienta desarrolladas en java para automatización de tareas en navegadores orientadas al testing de páginas web.']");
	
	
	public String getTutorialPageTitle() {
		return webElement.getPageTitle();
	}
	
	public Boolean isIntrodutionText() {
		return webElement.isDisplayed(pText);
	}
}
