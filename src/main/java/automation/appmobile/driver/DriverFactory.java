package automation.appmobile.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DriverFactory {

    private static final String APK_PATH = "classpath:app/cadastro_clientes_teste.apk";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
	
	public AppiumDriver<MobileElement> createInstance(String device) {
		
		DeviceType deviceType = DeviceType.valueOf(device.toUpperCase());
		
		switch (deviceType) {
			case ANDROID:
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		        capabilities.setCapability(MobileCapabilityType.APP, new File(APK_PATH));
		        capabilities.setCapability("appPackage", "br.com.dudstecnologia.cadastrodeclientes");
				capabilities.setCapability("appActivity", "br.com.dudstecnologia.cadastrodeclientes.MainClientes");
		        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			try {
				return new AndroidDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
			} catch (MalformedURLException e) {
				log.error("URL is malformed: " + e.getMessage());
			}
	
			default:
				throw new RuntimeException("Invalid device type.");
		}
	}

}
