package Appium.Appiumproject;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PressKeyAndDirectellyPage extends BaseTest{
	@Test
	public void AppiumStrat() throws MalformedURLException, URISyntaxException
	{
//		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies}");
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation rotation = new DeviceRotation(0, 0, 90);
		driver.rotate(rotation);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String Alerttitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(Alerttitle,"WiFi settings");
		driver.setClipboardText("Zakaria");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElement(By.id("android:id/button1")).click();
		
	}

}
