/**
 * 
 */
package org.mobile;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.mobilepages.ExpandableListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class SwipeTest extends BaseTest {
	
	@Test
	public void swipeIt()
	{
		ExpandableListPage expandablePage = new ExpandableListPage(driver);
		expandablePage.doSwipe();
		
		
	}

}
