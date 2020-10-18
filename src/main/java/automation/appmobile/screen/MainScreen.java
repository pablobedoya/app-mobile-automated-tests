package automation.appmobile.screen;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MainScreen extends BaseScreen {

	public MainScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
	private MobileElement buttonOptions;
	
	@FindBy(id="floating_novo")
	private MobileElement buttonNewCustomer;
	
	@FindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.TextView")
	private MobileElement customer;
	
	public void clickButtonOptions() {
		buttonOptions.click();
	}
	
	public void clickButtonNewCustomer() {
		buttonNewCustomer.click();
	}
	
	public void selectCustomer(String name) {
		customer.findElementByLinkText(name).click();
	}

	public boolean customerIsPresent(String name) {
		return this.customer.getText().equals(name);
	}

}
