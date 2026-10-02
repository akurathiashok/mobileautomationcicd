/**
 * 
 */
package org.mobile;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.mobilepages.ExpandableListPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

/**
 * 
 */
public class longPressTest extends BaseTest {
	
	
	@Test
	public void pressLong()
	{
		ExpandableListPage expandablePage = new ExpandableListPage(driver);
		expandablePage.doLongPress();
		String actualText = expandablePage.sampleMenu.getText();
		AssertJUnit.assertEquals(actualText, "Sample menu");
		AssertJUnit.assertTrue(expandablePage.sampleMenu.isDisplayed());
	}

}
