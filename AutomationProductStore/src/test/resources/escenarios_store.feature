#lenguage: EN

#Author: Alain Quintero
Feature: as a certifier, I want test the product store page

  Background:
    Given the user open the product store page in the browser chrome
#      Given the user open the product store page in the browser firefox

  @success
  Scenario Outline: Successful registration
    When the user completes the resgitration success
      | user   | password   |
      | <user> | <password> |
    Then the user should see an alert with the message Sign up successful.
    Examples:
      | user        | password  |
      | alainUser12 | alain1234 |

@failed
  Scenario Outline: Failed registration, User already exist
    When the user completes the resgitration failed
      | user   | password   |
      | <user> | <password> |
    Then the user should see an alert with the message This user already exist.
    Examples:
      | user        | password  |
      | alainUser12 | alain1234 |

  @Purchase
  Scenario Outline: make a successful purchase
    When the user completes the log in process
      | user   | password   |
      | <user> | <password> |
    And the user select the category and the product of store
      | category   | product   |
      | <category> | <product> |
    And the user complete the process of purchase
      | name   | country   | city   | creditCard   | month   | year   |
      | <name> | <country> | <city> | <creditCard> | <month> | <year> |
    Then the user should see the message Thank you for your purchase!
    Examples:
      | user      | password  | category | product           | name  | country  | city | creditCard       | month | year |
      | alainUser | alain1234 | Phones   | Samsung galaxy s6 | Alain | Colombia | Cali | 1234657809876543 | mayo  | 2024 |
      | alainUser | alain1234 | Laptops  | Sony vaio i5      | Alain | Colombia | Cali | 1234657809876543 | mayo  | 2024 |
      | alainUser | alain1234 | Monitors | Apple monitor 24  | Alain | Colombia | Cali | 1234657809876543 | mayo  | 2024 |


