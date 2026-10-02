/**
 * 
 */
package org.mobilepages;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidMobileGuestures;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 */
public class ExpandableListPage extends AndroidMobileGuestures{
	AndroidDriver driver;
	
	public ExpandableListPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(accessibility ="Views")
	public WebElement views;
	
	@AndroidFindBy(accessibility ="Gallery")
	public WebElement gallery;
	
	@AndroidFindBy(accessibility ="1. Photos")
	public WebElement photos;
	
	@AndroidFindBy(xpath ="//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]")
	public WebElement imageOne;
	
	@AndroidFindBy(uiAutomator ="new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"WebView\"))")
	public WebElement scrollToWebview;
	
	@AndroidFindBy(accessibility ="WebView")
	public WebElement clickWebview;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Views/WebView\"]")
	public WebElement webViewTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
	public WebElement expandableLists;
	
	@AndroidFindBy(accessibility="1. Custom Adapter")
	public WebElement customAdapter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"People Names\"]")
	public WebElement peopleNames;
	
	@AndroidFindBy(accessibility="Drag and Drop")
	public WebElement dragAndDrop;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_1")
	public WebElement sourceToDrag;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_result_text")
	public WebElement droppedText;
	
	@AndroidFindBy(id="android:id/title")
	public WebElement sampleMenu;
	
	public void doLongPress()
	{
		views.click();
		expandableLists.click();
		customAdapter.click();
		longPress(peopleNames);
	}
	
	public void doScroll()
	{
		views.click();
		scrollToWebview.click();
	}
	
	public void doSwipe()
	{
		views.click();
		gallery.click();
		photos.click();
		swipeNow(imageOne, "left");
	}
	
	public void dragDrop()
	{
		views.click();
		dragAndDrop.click();
		dragNow(sourceToDrag);
	}
	
	public void launchActivity()
	{
		String intent = "io.appium.android.apis" + "/" + "io.appium.android.apis.ApiDemos";
		Map<String, Object> params = new HashMap<>();
		params.put("intent", intent);
		driver.executeScript("mobile: startActivity", params);
	}

}
