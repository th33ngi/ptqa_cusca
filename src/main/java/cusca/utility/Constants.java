package cusca.utility;

import org.openqa.selenium.WebDriver;

import cusca.brain.BasePage;

public class Constants extends BasePage {
	public Constants(WebDriver driver) {
		super(driver);
	}
	
	//Config Properties
	public static final String BROWSER_NAME = prop.getProperty("chrome");
	public static final String CHROME_DRIVER = prop.getProperty("windrivers")+"/chromedriver";
	public static final String URL = prop.getProperty("appurl");
	
	public static final String GOOGLE_PAGE_TITLE = "Google";
	public static final String WIKIPEDIA_PHRASE = "Wikipedia";
	public static final String WIKIPEDIA_PAGE_LINK = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
	public static final String WIKIPEDIA_PAGE_TITLE = "Wikipedia, la enciclopedia libre";
	public static final String SELENIUM_PHRASE = "Selenium";
	
	public static final String TUTORIAL_PAGE_LINK = "https://www.tutorialdeprogramacion.com/2019/08/tutorial-python-con-selenium.html";
	public static final String INTRODUCTION_PARAGRAPH = "Tutorial Selenium con python: Instalando, configurando y poniendo en marcha - Tutoriales de programación y un poco más";
		
}
