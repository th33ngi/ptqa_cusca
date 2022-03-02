package cusca.brain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cusca.listener.EventListener;
import cusca.utility.Constants;
import cusca.utility.OptionsManager;

public class BasePage extends Page {
	public static Properties prop;
	public static WebDriver driver;
	public OptionsManager optionsManager;
	public static EventFiringWebDriver eventDriver;
	public static EventListener eventListener;

	// a base page constructor is created
	public BasePage(WebDriver driver) {
		super(driver);
	}

	// start the web driver
	public WebDriver initDriver() {		
		String browserName = Constants.BROWSER_NAME;
		if(browserName.equals("chrome")) {
			optionsManager = new OptionsManager();
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		}

		eventDriver = new EventFiringWebDriver(driver);
		eventListener = new EventListener();
		eventDriver.register(eventListener);
		driver = eventDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		return driver;
	}

	// get properties from properties file
	public Properties initProperties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/cusca/sources/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}