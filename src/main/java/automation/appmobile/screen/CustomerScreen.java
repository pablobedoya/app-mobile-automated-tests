package automation.appmobile.screen;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CustomerScreen extends BaseScreen {
	
	public CustomerScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@FindBy(id="rdBasico")
	private MobileElement basicRegistration;
	
	@FindBy(id="editNome")
	private MobileElement name;
	
	@FindBy(id="editRg")
	private MobileElement rg;
	
	@FindBy(id="editCpf")
	private MobileElement cpf;
	
	@FindBy(id="editData")
	private MobileElement birthDate;
	
	@FindBy(id="editEndereco")
	private MobileElement address;
	
	@FindBy(id="editNumero")
	private MobileElement number;
	
	@FindBy(id="editBairro")
	private MobileElement district;
	
	@FindBy(id="editCep")
	private MobileElement postalCode;
	
	@FindBy(id="editCidade")
	private MobileElement city;
	
	@FindBy(id="text1")
	private MobileElement state;
	
	@FindBy(id="Telefone1")
	private MobileElement phone1;
	
	@FindBy(id="Telefone2")
	private MobileElement phone2;
	
	@FindBy(id="editEmail")
	private MobileElement email;
	
	@FindBy(id="editObs")
	private MobileElement note;
	
	@FindBy(id="btnSalvar")
	private MobileElement buttonSave;

	@FindBy(id="btnExcluir")
	private MobileElement buttonDelete;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	private MobileElement message;
	
	@FindBy(xpath="//android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[@text = 'OK']")
	private MobileElement buttonOkModal;
	
	@FindBy(xpath="//android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[@text = 'SIM']")
	private MobileElement buttonYesModal;
	
	public void selectBasicRegistration() {
		basicRegistration.click();
	}
	
	public void fillName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void fillPhone1(String phone) {
		this.phone1.clear();
		this.phone1.sendKeys(phone);
	}
	
	public void fillPhone2(String phone) {
		this.phone2.clear();
		this.phone2.sendKeys(phone);
	}
	
	public void clickButtonSave() {
		buttonSave.click();
	}
	
	public void clickButtonDelete() {
		buttonDelete.click();
	}
	
	public boolean messageIsPresent(String message) {
		return this.message.getText().equals(message);
	}
	
	public void clickButtonOkModal() {
		buttonOkModal.click();
	}
	
	public void clickButtonYesModal() {
		buttonYesModal.click();
	}

}
