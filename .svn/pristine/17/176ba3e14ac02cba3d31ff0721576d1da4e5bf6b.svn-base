Feature: Homepage

  @Regression @home
  Scenario: Verify the elements on the home page
    Given I login as an individual 1
    When I navigate to home page
    Then I verify area for header is displayed
    And I verify area for main content is displayed
    And I verify area for footer is displayed

  @Regression @home @header
  Scenario: Verify the elements in the header
    Given I login as an individual 1
    Then I verify that navigation menu for Country & Currency is displayed
    Then I verify that navigation menu for Account is displayed
    And I verify that list of categories is displayed
    And I verify that search box is displayed
    Then I verify that navigation links is displayed
    And I verify that shipping banner is displayed

  @Regression @home @main 
  Scenario: Verify the main content of the page
    Given I login as an individual 1
    When I navigate to home page
    Then I verify that image is displayed

  @Regression @home @footer
  Scenario: Verify the footer links
    Given I login as an individual 1
    When I navigate to home page
    Then I verify page Home in the footer links is displayed
    And I verify page About Us in the footer links is displayed
    And I verify page Contact Us in the footer links is displayed
    And I verify page Site Guide in the footer links is displayed
    And I verify page Reviews in the footer links is displayed
    And I verify page Sitemap in the footer links is displayed
    And I verify page Blog in the footer links is displayed

  @Regression @home @footer 
  Scenario: Verify the support links in the footer
    Given I login as an individual 1
    When I navigate to home page
    Then I verify link for My Account in the support links is displayed
    And I verify link for Privacy Statement in the support links is displayed
    And I verify link for Terms & Conditions in the support links is displayed
    And I verify link for Cookies Policy in the support links is displayed
    And I verify link for FAQ in the support links is displayed
    And I verify link for Shipping & Returns in the support links is displayed
    And I verify link for Blog in the support links is displayed

  @Regression @home @header 
  Scenario: Verify the Country & Currency navigation menu
    When I click on Country & Currency dropdown
    Then I verify Country & Currency popup is displayed
    And I verify selected country and currency with title is displayed
    And I verify save and close buttons are displayed

  @Regression @home @header @currency 
  Scenario: Verify that the user is able to update the country and currency
    Given I click on Country & Currency dropdown
    When I select United Kingdom as country
    And I select GB Pounds as currency
    And I click on Save
   Then I verify that United Kingdom and GB Pounds is displayed against country & currency

  @Regression @home @header 
  Scenario: Verify the Account navigation menu - as a guest
    Given I navigate to home page
    Then I verify that the greeting is displayed
    When I click on Account dropdown
    Then I verify that Account popup is displayed
    And I verify that Sign in link is displayed
    Then I verify that the Sign up link is displayed

