/**
 * 
 */
package org.mobile;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.mobilepages.ExpandableListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class ScrollTest extends BaseTest {
	
	@Test
	public void pressLong()
	{
		ExpandableListPage expandablePage = new ExpandableListPage(driver);
		//expandablePage.doScroll();
		//expandablePage.views.click();
		//justScroll(expandablePage.scrollToWebview);
		expandablePage.doScroll();
		expandablePage.clickWebview.click();
		String actualText = expandablePage.webViewTitle.getText();
		AssertJUnit.assertEquals(actualText, "Views/WebView");
		AssertJUnit.assertTrue(expandablePage.webViewTitle.isDisplayed());
	}

}
