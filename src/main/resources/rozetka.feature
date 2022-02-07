Feature: rozetka
  As a user
  I want to test the purchase of a product and check the total product price
  So that I can be sure that site works correctly

  Scenario Outline: Check the total product price
    And User opens home page page
    And User find item by '<item>'
    And User input item '<model>'
    And User select the found product '<model>'
    And User click on first product in list
    And User click on buy button
    Then User checks the total product '<price>'
    Examples:
      | item     | model  | price  |
      | Notebook | Apple  | 100000 |
      | Keyboard | A4Tech | 100000 |

