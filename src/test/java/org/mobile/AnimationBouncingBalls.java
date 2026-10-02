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
public class AnimationBouncingBalls extends BaseTest {
	
	@Test
	public void testFlowTwo()
	{
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Bouncing Balls\"]")).click();
		driver.findElement(By.xpath("//android.view.View")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
