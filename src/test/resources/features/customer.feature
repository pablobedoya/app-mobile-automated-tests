Feature: Customer CRUD

  Scenario: Customer successfully created
		Given I want to register a customer
		And I enter the basic customer data
		When I submit the registration
		Then should return that customer was created successfully
		
  Scenario: Customer successfully updated
  	Given I successfully registered a customer
		And I enter new data to update it
		When I submit the update
		Then should return that customer was updated successfully
  
  Scenario: Customer successfully deleted
  	Given I successfully registered a customer
		And I select the customer to delete it
		When I submit the delete
		Then should return that customer was deleted successfully
