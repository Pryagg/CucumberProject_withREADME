Feature: Cart

  @Regression @Cart
  Scenario: Verify the elements displayed on Cart page
    Given I login as an individual 1
    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
    Then I verify the elements on the cart page

  @Regression @Cart
  Scenario: Verify that product details page is displayed when clicked on Continue shopping
    Given I login as an individual 1
    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
    And I click on Continue shopping button
    Then I see that I am landed on product details page

  @Regression @Cart
  Scenario: Remove from cart
    Given I login as an individual 1
    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
    And I verify that the product is added to cart
    Then I click on Remove from cart button
    Then I see that the product is removed from the cart

#  @Regression @Cart
#  Scenario: Invalid gift card
#    Given I login as an individual 1
#    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
#    And I enter gift card value as abc
#    And I click on update cart button
#    Then I see that the gift card error is displayed

  @Regression @Cart
  Scenario: Invalid coupon
    Given I login as an individual 1
    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
    And I enter promotion code value as abc
    And I click on apply coupon button
    Then I see that the promotion code error is displayed

  @Regression @Cart
  Scenario: Expired coupon
    Given I login as an individual 1
    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
    And I enter promotion code value as STAY-WELL
    And I click on apply coupon button
    Then I see that the coupon code is expired

  @Regression @Cart
  Scenario: Valid gift card
    Given I login as an individual 1
    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
    And I enter gift card value as (.+)
    And I click on apply card button
    Then I see that the gift card is applied


  @Regression @Cart
  Scenario: Valid coupon
    Given I login as an individual 1
    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
    And I enter promotion code value as abc
    And I click on apply coupon button
    Then I see that the promotion code is applied

#    @Regression @Cart
#    Scenario: Verify that the order notes added in the cart is displayed as delivery instructions
#      Given I login as an individual 1
#      When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart
#      And I add notes in the cart
#      Then I navigate to shipping address
#      Then I see that the notes added in the cart is displayed as delivery instructions


#  @Regression @Cart
#  Scenario: Test feature
#    Given I login as an individual 1
#    When I add Duovir 10 Tablets ( Lamivudine and Zidovudine) from Aids category to cart ( add different product in the cart) (on google chrome) (on mozilla) on web, tab and iphone
#    And I add notes in the cart
#    Then I navigate to shipping address
#    Then I see that the notes added in the cart is displayed as delivery instructions
#






		
	
	
	