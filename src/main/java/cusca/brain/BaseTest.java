package cusca.brain;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public static WebDriver driver;
	public Page page;
	BasePage basePage;
	
	//set up properties, web driver and instance of page class,
	//before starting the test suite.
	@BeforeSuite
	public void setUp() {
		basePage = new BasePage(driver);
		basePage.initProperties();
		driver = basePage.initDriver();
		page = new Page(driver);
	}
	
	@BeforeClass
	public void startUp() {
		basePage = new BasePage(driver);
		page = new Page(driver);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}