Feature: Shipping

  @Regression
  Scenario: Verify the elements on shipping page
    Given I am on home page
    When I click on Account dropdown
    Then I click on Sign up link
    And Verify My Account registration page opens
    And I enter personal information on checkout for individual1
    Then I enter billing information on checkout for individual1
    And I tick my shipping address is same as my billing
    Then tick all privacy preferences
    And I create my account
    Then I verify that my account page displays
		
	
	
	