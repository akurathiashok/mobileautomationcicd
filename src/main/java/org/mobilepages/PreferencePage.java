/**
 * 
 */
package org.mobilepages;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.utils.AndroidMobileGuestures;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * 
 */
public class PreferencePage extends AndroidMobileGuestures{
	
	AndroidDriver driver;
	
	public PreferencePage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Preference']")
	private WebElement preferenceOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='1. Preferences from XML']")
	private WebElement optionOne;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='3. Preference dependencies']")
	private WebElement prefDependencies;
	
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")
	private WebElement wifiSettings;
	
	@AndroidFindBy(id="android:id/checkbox")
	private WebElement wifiCheckBox;
	
	@AndroidFindBy(id="android:id/edit")
	public WebElement wifiName;
	
	@AndroidFindBy(id="android:id/alertTitle")
	public WebElement wifiAlertTitle;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement okButton;
	
	@AndroidFindBy(id="android:id/widget_frame")
	private WebElement frameOne;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/title' and @text='Edit text preference']")
	private WebElement editPreference;
	
	@AndroidFindBy(id="android:id/edit")
	private WebElement editField;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='android:id/edit']")
	private WebElement enterInputValue;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/title' and @text='List preference']")
	private WebElement listPrefernce;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Charlie Option 03']")
	private WebElement optionThree;
	
	public void actionOne()
	{
		preferenceOption.click();
		optionOne.click();
		frameOne.click();
	}
	
	public void actionTwo()
	{
		editPreference.click();
		editField.click();
		enterInputValue.sendKeys("Lion");
		okButton.click();
	}
	
	public void actionThree()
	{
		listPrefernce.click();
		optionThree.click();
	}
	
	public void wifiSettings()
	{
		preferenceOption.click();
		prefDependencies.click();
//		DeviceRotation landscape = new DeviceRotation(0,0,90);
//		driver.rotate(landscape);
		wifiCheckBox.click();
		wifiSettings.click();
		wifiName.click();
		/*
		 * driver.setClipboardText("Organic Wifi");
		 * wifiName.sendKeys(driver.getClipboardText()); driver.pressKey(new
		 * KeyEvent(AndroidKey.ENTER)); String alertName = wifiAlertTitle.getText();
		 * //Assert.assertEquals(alertName, "WiFi settings"); okButton.click();
		 * driver.pressKey(new KeyEvent(AndroidKey.BACK)); driver.pressKey(new
		 * KeyEvent(AndroidKey.HOME));
		 */
	}
	
	public List<HashMap<String, String>> jsonToHashMap(String jsonFilePath) throws IOException
	{
		//System.getProperty("user.dir"+"\\src\\test\\java\\resources\\jsonData.json")
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8 );
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	}
	
}
