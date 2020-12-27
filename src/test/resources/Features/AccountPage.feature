Feature: Account page feature

  Background: 
    Given user has already logged in to the application
      | userName                        | password     |
      | seleniumdummypractice@gmail.com | Selenium@123 |

  Scenario: Accounts page title
    When user is on Account page
    Then account page title should be "My account - My Store"

  Scenario: Account section count
    Given user is on Account page
    Then user gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
    And account section count should be 5