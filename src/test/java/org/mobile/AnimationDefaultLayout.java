/**
 * 
 */
package org.mobile;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * 
 */
public class AnimationDefaultLayout extends BaseTest {
	
	@Test
	public void testFlowFour()
	{
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Default Layout Animations\"]")).click();
		for(int i=1;i<=50;i++)
		{
			driver.findElement(By.id("io.appium.android.apis:id/addNewButton")).click();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
