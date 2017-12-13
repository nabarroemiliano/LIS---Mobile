package LISHP.LISHP;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PrimerTest {

	private static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args)
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "ZY222WSLZT");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("appPackage", "tips.lis.mobile");
		caps.setCapability("appActivity", "tips.lis.mobile.MainActivity");
		caps.setCapability("noReset", "true");
		
		try
		{
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		}
		catch(MalformedURLException e){
			System.out.println(e.getMessage());
		}		
		
	
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
	
		
		driver.findElement(By.xpath("//android.webkit.WebView[@content-desc='TITULO APLICACIÓN']/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText")).sendKeys("administrador");
		driver.findElement(By.xpath("//android.webkit.WebView[@content-desc='TITULO APLICACIÓN']/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText")).sendKeys("administrador");
		
		driver.findElementByAccessibilityId("Ingresar").click();
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Confirmar']")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc='more_vert']")).click();
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[1]")).click();
		
		String aux = driver.findElement(By.xpath("//android.view.View[@content-desc='(423-B) ARROYOS, ANA MARIA Fecha Nac.: 2017/12/13 N° Orden: 805 Estado: Cateter']")).getText();
		
		System.out.println(aux);
		
		if(aux.contains("Estado: Cateter"))
		{
			System.out.println("Prueba OK");
		}
		else
		{
			System.out.println("Prueba Wrong");

		}
		
	}
	
}
