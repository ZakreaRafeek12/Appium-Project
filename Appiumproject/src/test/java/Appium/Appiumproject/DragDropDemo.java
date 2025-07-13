package Appium.Appiumproject;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;



public class DragDropDemo extends BaseTest{
	

	@Test
	
	public void AppiumStrat() throws MalformedURLException, URISyntaxException, InterruptedException {
	    driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	    WebElement Source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	    
	    DragDrop(Source,660,580);
	    String Resault =  driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/drag_result_text\"]")).getText();
	    Assert.assertEquals(Resault,"Dropped!");
	    
	}

}
