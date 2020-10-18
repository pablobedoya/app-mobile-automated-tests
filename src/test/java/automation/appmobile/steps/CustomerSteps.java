package automation.appmobile.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import automation.appmobile.data.CustomerDataUtil;
import automation.appmobile.driver.DriverFactory;
import automation.appmobile.model.Customer;
import automation.appmobile.screen.CustomerScreen;
import automation.appmobile.screen.MainScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerSteps {
	
	private DriverFactory driverFactory = new DriverFactory();
	private MainScreen mainScreen;
	private CustomerScreen customerScreen;
	private Customer customer;

	@Given("I want to register a customer")
	public void i_want_to_register_a_customer() {
		mainScreen = new MainScreen(driverFactory.createInstance("Android"));
		customerScreen = new CustomerScreen(mainScreen.getDriver());
		
		mainScreen.clickButtonOptions();
		mainScreen.clickButtonNewCustomer();
	}

	@And("I enter the basic customer data")
	public void i_enter_the_basic_customer_data() {
	    customerScreen.selectBasicRegistration();
	    customerScreen.fillName(CustomerDataUtil.generateName());
	    customerScreen.fillPhone1(CustomerDataUtil.generatePhone());
	}

	@When("I submit the registration")
	public void i_submit_the_registration() {
		customerScreen.clickButtonSave();
	}

	@Then("should return that customer was created successfully")
	public void should_return_that_customer_was_created_successfully() {
	    assertTrue(customerScreen.messageIsPresent("Cadastro efetuado com sucesso"));
	}

	@Given("I successfully registered a customer")
	public void i_successfully_registered_a_customer() {
		customer = Customer.builder()
				.name(CustomerDataUtil.generateName())
				.phone1(CustomerDataUtil.generatePhone())
				.build();
		
		mainScreen = new MainScreen(driverFactory.createInstance("Android"));
		customerScreen = new CustomerScreen(mainScreen.getDriver());
		
		mainScreen.clickButtonOptions();
		mainScreen.clickButtonNewCustomer();
		
		customerScreen.selectBasicRegistration();
		customerScreen.fillName(customer.getName());
	    customerScreen.fillPhone1(customer.getPhone1());
	    customerScreen.clickButtonSave();
	    customerScreen.clickButtonOkModal();
	    customerScreen.touchBackKeyAndroid();
	}

	@And("I enter new data to update it")
	public void i_enter_new_data_to_update_it() {
		mainScreen.selectCustomer(customer.getName());
		customerScreen.selectBasicRegistration();
		customerScreen.fillName(CustomerDataUtil.generateName());
	    customerScreen.fillPhone1(CustomerDataUtil.generatePhone());
	    customerScreen.fillPhone2(CustomerDataUtil.generatePhone());
	}

	@When("I submit the update")
	public void i_submit_the_update() {
	    customerScreen.clickButtonSave();
	}

	@Then("should return that customer was updated successfully")
	public void should_return_that_customer_was_updated_successfully() {
	    assertTrue(customerScreen.messageIsPresent("Cadastro atualizado com sucesso"));
	}

	@And("I select the customer to delete it")
	public void i_select_the_customer_to_delete_it() {
		mainScreen.selectCustomer(customer.getName());
	}

	@When("I submit the delete")
	public void i_submit_the_delete() {
		customerScreen.clickButtonDelete();
		customerScreen.clickButtonYesModal();
	}

	@Then("should return that customer was deleted successfully")
	public void should_return_that_customer_was_deleted_successfully() {
		customerScreen.touchBackKeyAndroid();
		assertFalse(mainScreen.customerIsPresent(customer.getName()));
	}
	
}
