/**
 * 
 */
package org.mobile;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.mobilepages.PreferencePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * 
 */
public class PreferenceTest extends BaseTest{

	
	@Test
	public void testFlowOne()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		PreferencePage prefPage = new PreferencePage(driver);
		prefPage.actionOne();
		prefPage.actionTwo();
		prefPage.actionThree();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Preferences from XML\"]")).click();
//		driver.findElement(By.id("android:id/widget_frame")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit text preference\"]")).click();
//		driver.findElement(By.id("android:id/edit")).click();
//		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']")).sendKeys("Lion");
//		driver.findElement(By.id("android:id/button1")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"List preference\"]")).click();
//		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Charlie Option 03\"]")).click();
	}

}
