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
public class AnimationReversing extends BaseTest {
	
	@Test
	public void testFlowFive()
	{
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Reversing\"]")).click();
		driver.findElement(By.id("io.appium.android.apis:id/startButton")).click();
		driver.findElement(By.id("io.appium.android.apis:id/reverseButton")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
