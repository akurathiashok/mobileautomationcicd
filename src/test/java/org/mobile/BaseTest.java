/**
 * 
 */
package org.mobile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * 
 */
public class BaseTest {
	AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void launchApp() throws MalformedURLException, URISyntaxException {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\ashok\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setApp("C:\\Users\\ashok\\eclipse-workspace\\mobile\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setDeviceName("Android Device");
		options.setAutomationName("UiAutomator2");
		/*
		 * DesiredCapabilities cap = new DesiredCapabilities();
		 * cap.setCapability(MobileCapabilityType.APP,
		 * "C:\\Users\\ashok\\eclipse-workspace\\mobile\\src\\test\\java\\resources\\ApiDemos-debug.apk"
		 * ); cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		 * cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		 */
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
	}
	
		@AfterClass
	public void quitApp()
	{
		driver.quit();
		service.stop();
	}
	
		public String screenShotTaken(String testcaseName, AndroidDriver driver) throws IOException
		{
			File source = this.driver.getScreenshotAs(OutputType.FILE);
			String destinationPath = System.getProperty("user.dir")+"//report"+testcaseName+".png";
			FileUtils.copyFile(source, new File(destinationPath));
			return destinationPath;
				
		}
		
}
