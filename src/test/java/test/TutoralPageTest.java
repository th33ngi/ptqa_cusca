package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import cusca.brain.BaseTest;
import cusca.page.TutorialPage;

public class TutoralPageTest extends BaseTest {
	
	@Test(priority=7, enabled=true)
	public void verifyIntrodutionText() {
		Boolean result = page.getInstance(TutorialPage.class).isIntrodutionText();
		Assert.assertTrue(result);
	}

}
