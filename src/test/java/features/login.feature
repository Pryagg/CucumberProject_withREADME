Feature: Login

@Regression @login
Scenario: Verify successful login
	Given I click on Sign In button on homepage
	When I enter test2@mailinator.com as email
	And I enter 12345 as password
	And I click on login button
	Then I verify that I am successfully logged in
	
	@Regression @login
Scenario: Verify error - invalid password
	Given I click on Sign In button on homepage
	When I enter test2@mailinator.com as email
	And I enter 45636 as password
	And I click on login button
	Then I verify that an error is displayed as 'Invalid Login'
	
	@Regression @login
Scenario: Verify error - Unregistered email address
	Given I click on Sign In button on homepage
	When I enter abc@abc.com as email
	And I enter 12345 as password
	And I click on login button
	Then I verify that an error is displayed as 'Invalid Login'
	
	@Regression @login
Scenario: Verify error - invalid email
	Given I click on Sign In button on homepage
	When I enter abcgg as email
	And I enter invalid password
	And I click on login button
	Then I verify that an error is displayed as 'Invalid Login'
	
	@Regression @Login
	Scenario: Verify blank username and password errors
		Given I click on Sign In button on homepage
		When I click on login button
		Then I verify the errors to enter username and password are displayed
	

	
	
	
	