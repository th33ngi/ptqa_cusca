package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import cusca.brain.BaseTest;
import cusca.page.GooglePage;
import cusca.utility.Constants;

public class GooglePageTest extends BaseTest {
	
	@Test(priority=1, enabled=true)
	public void verifyGooglePage() {
		String title = page.getInstance(GooglePage.class).getGooglePageTitle();
		Assert.assertEquals(title, Constants.GOOGLE_PAGE_TITLE);
	}
	
	@Test(priority=2, enabled=true)
	public void SearchWikipediaPage() {
		page.getInstance(GooglePage.class).searchWikiPage(Constants.WIKIPEDIA_PHRASE);
		Boolean result = page.getInstance(GooglePage.class).isWikipedia();
		Assert.assertTrue(result);
	}
}