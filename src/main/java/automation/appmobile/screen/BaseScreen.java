package automation.appmobile.screen;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseScreen {
	
	protected AppiumDriver<MobileElement> driver;
	
	public BaseScreen(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public AppiumDriver<MobileElement> getDriver() {
    	return driver;
    }
	
	public void touchBackKeyAndroid() {
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void touchHomeKeyAndroid() {
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
