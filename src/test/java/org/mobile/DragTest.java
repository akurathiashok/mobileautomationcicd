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
public class DragTest extends BaseTest {
	
	@Test
	public void dragIt()
	{
		ExpandableListPage expandablePage = new ExpandableListPage(driver);
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
