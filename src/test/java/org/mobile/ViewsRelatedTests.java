/**
 * 
 */
package org.mobile;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.mobilepages.ExpandableListPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

/**
 * 
 */
public class ViewsRelatedTests extends BaseTest 
{
	
	ExpandableListPage expandablePage;
	
	  @BeforeMethod 
	  public void preSetApp() 
	  { 
		  String intent = "io.appium.android.apis" + "/" + "io.appium.android.apis.ApiDemos";
	  Map<String, Object> params = new HashMap<>(); 
	  params.put("intent", intent);
	  params.put("wait", true);
	  driver.executeScript("mobile: startActivity", params);
		  }
	 
	
	@Test
	public void pressLong()
	{
		expandablePage = new ExpandableListPage(driver);
		expandablePage.doLongPress();
		String actualText = expandablePage.sampleMenu.getText();
		AssertJUnit.assertEquals(actualText, "Sample menu");
		AssertJUnit.assertTrue(expandablePage.sampleMenu.isDisplayed());
	}
	
	@Test
	public void scrollIt()
	{
		expandablePage = new ExpandableListPage(driver);
		expandablePage.doScroll();
		expandablePage.clickWebview.click();
		String actualText = expandablePage.webViewTitle.getText();
		AssertJUnit.assertEquals(actualText, "Views/WebView");
		AssertJUnit.assertTrue(expandablePage.webViewTitle.isDisplayed());
	}
	
	@Test
	public void swipeIt()
	{
		expandablePage = new ExpandableListPage(driver);
		expandablePage.doSwipe();
	}
	
	@Test
	public void dragIt()
	{
		expandablePage = new ExpandableListPage(driver);
		expandablePage.dragDrop();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualText=expandablePage.droppedText.getText();
		AssertJUnit.assertEquals(actualText, "Dropped!");
		
	}

}
