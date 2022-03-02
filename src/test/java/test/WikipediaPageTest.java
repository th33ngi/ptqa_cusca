package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import cusca.brain.BaseTest;
import cusca.page.GooglePage;
import cusca.page.TutorialPage;
import cusca.page.WikipediaPage;
import cusca.utility.Constants;

public class WikipediaPageTest extends BaseTest {
	
	@Test(priority=3, enabled=true)
	public void navigateToWikipediaPage() {
		page.getInstance(GooglePage.class).getWikipediaPage(Constants.WIKIPEDIA_PAGE_LINK);
		String title = page.getInstance(WikipediaPage.class).getWikipediaPageTitle();
		System.out.println("We are on: "+title+" Page");
		Assert.assertEquals(title, Constants.WIKIPEDIA_PAGE_TITLE);
	}
	
	@Test(priority=4, enabled=true)
	public void searchSeleniumPage() {
		page.getInstance(WikipediaPage.class).searchSelenium(Constants.SELENIUM_PHRASE);
		Boolean result = page.getInstance(WikipediaPage.class).isSelenium();
		Assert.assertTrue(result);
	}
	
	@Test(priority=5, enabled=true)
	public void clickOnEnlacesExternos() {
		page.getInstance(WikipediaPage.class).enlacesExternos();
		Boolean result = page.getInstance(WikipediaPage.class).isEnlacesExternos();
		Assert.assertTrue(result);
	}
	
	@Test(priority=6, enabled=true)
	public void selectTutorialSeleniumPage() {
		page.getInstance(WikipediaPage.class).getTutorialPage(Constants.TUTORIAL_PAGE_LINK);
		String title = page.getInstance(TutorialPage.class).getTutorialPageTitle();
		System.out.println("We are on: "+title+" Page");
		Assert.assertEquals(title, Constants.INTRODUCTION_PARAGRAPH);
	}
}
