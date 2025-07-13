package Appium.Appiumproject;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;



public class gesturesLongPress extends BaseTest{
	@Test
	public void PressLongAction() throws MalformedURLException, URISyntaxException, InterruptedException {
	    driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
	    driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();

	    WebElement longPress = driver.findElement(
	        By.xpath("//android.widget.TextView[@text='People Names']")
	    );
	    	
	    	LongPressAction(longPress);
	    
	    String MenuText = driver.findElement(By.id("android:id/title")).getText();
	    Assert.assertEquals(MenuText, "Sample menu");
	    Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

	    Thread.sleep(2000);
	}

}
