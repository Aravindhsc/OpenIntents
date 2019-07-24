Feature: Verifying Shopping List

  Scenario: Adding and removing List items
    Given User Navigates to Home page
    When User Add List
    And Add some Items to List 
    | ListName | Device1 | Device2 | Device3 |
    	| List1 | Samsung Galaxy S9 | Samsung Galaxy S10 | Google Pixel3Xl |
    	| List2 | iPhone8Plus | iPhone XS Max |iPhone8 |
    Then Delete An Items in List
  
  Scenario: Sorting List items
  		Given User Navigates to Home page
    When User Add List
    And Add some Items to List
    | ListName | Device1 | Device2 | Device3 |
    	| List1 | Samsung Galaxy S9 | Samsung Galaxy S10 | Google Pixel3Xl |
    	| List2 | iPhone8Plus | iPhone XS Max |iPhone8 |
    And Sort the list
    Then Validate the list

