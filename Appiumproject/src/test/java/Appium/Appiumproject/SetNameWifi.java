package Appium.Appiumproject;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SetNameWifi extends BaseTest{
	@Test
	public void AppiumStrat() throws MalformedURLException, URISyntaxException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation rotation = new DeviceRotation(0, 0, 90);
		driver.rotate(rotation);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String Alerttitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(Alerttitle,"WiFi settings");
		driver.setClipboardText("Zakaria");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
