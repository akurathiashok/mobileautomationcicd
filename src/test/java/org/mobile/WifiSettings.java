/**
 * 
 */
package org.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mobilepages.PreferencePage;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * 
 */
public class WifiSettings extends BaseTest {
	
	@BeforeMethod 
	  public void preSetApp() 
	  { 
		  String intent = "io.appium.android.apis" + "/" + "io.appium.android.apis.ApiDemos";
	  Map<String, Object> params = new HashMap<>();
	  params.put("intent", intent);
	  params.put("wait", true);
	  driver.executeScript("mobile: startActivity", params);
	}
	
	@Test(dataProvider="sampleDataDriven")
	public void verifyWifiSetting(HashMap<String,String> input)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PreferencePage prefPage = new PreferencePage(driver);
			prefPage.wifiSettings();	
			driver.setClipboardText(input.get("wifiName"));
			prefPage.wifiName.sendKeys(driver.getClipboardText());
			//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			String alertName = prefPage.wifiAlertTitle.getText();
			//Assert.assertEquals(alertName, "WiFi settings");
			prefPage.okButton.click();
			//driver.pressKey(new KeyEvent(AndroidKey.BACK));
			//driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	@DataProvider
	public Object[][] sampleDataDriven() throws IOException
	{
		PreferencePage prefPage = new PreferencePage(driver);
		List<HashMap<String, String>> data = prefPage.jsonToHashMap(System.getProperty("user.dir"+"\\src\\test\\java\\resources\\jsonData.json"));
		return new Object[][] 
				{
					{data.get(0)}
				};
	}

}
