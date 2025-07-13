package Appium.Appiumproject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	boolean canScrollMore;
	
	public AndroidDriver driver;
	@BeforeClass
	public void Appiumtest() throws MalformedURLException, URISyntaxException
	{
//		Start automation on Android Device 
		UiAutomator2Options options= new  UiAutomator2Options();
//		this is Device Name on Amlator 
		options.setDeviceName("AutoAndroid");
//		this is path app
		options.setApp("C:\\Users\\zakre\\eclipse-workspace\\Appiumproject\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
//		open  session in  Appium 
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	public void LongPressAction(WebElement longPress)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		        "elementId",((RemoteWebElement) longPress).getId(),
		        "duration", 1500
		    ));
	}
	public void scrollDemoAction()
	{
		 do{ 
			   canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    	    "left", 100, "top", 100, "width", 200, "height", 200,
		    	    "direction", "down",
		    	    "percent", 3.0
		    	));
		   }
		   while(canScrollMore);
	}
	
	public void SwipDemoAction(WebElement ele,String direction)
	{
		( (JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void DragDrop(WebElement ele,int X,int Y)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
	    	    "elementId", ((RemoteWebElement) ele).getId(),
	    	    "endX", X,
	    	    "endY", Y
	    	));
	}
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}

}
