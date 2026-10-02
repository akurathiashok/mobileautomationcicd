/**
 * 
 */
package org.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

/**
 * 
 */
public class AndroidMobileGuestures

{

	AndroidDriver driver;

	  public AndroidMobileGuestures(AndroidDriver driver) 
	  {
		  this.driver=driver;
	  }
	 

	public void longPress(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));

	}
	
	public void justScroll(WebElement ele)
	{
		Map<String, Object> params = new HashMap();
		params.put("elementId", ele);
		params.put("direction", "down");
		params.put("percent", 3.0);
		
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params
			);

	}
	
	public void swipeNow(WebElement ele, String direction)
	{
		Map<String, Object> params = new HashMap();
		params.put("elementId", ele);
		params.put("direction", direction);
		params.put("percent", 0.25);
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", params
			);

	}
	
	public void dragNow(WebElement ele)
	{
		Map<String, Object> params = new HashMap();
		params.put("elementId", ele);
		params.put("endX", 656);
		params.put("endY", 638);
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", params
			);

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