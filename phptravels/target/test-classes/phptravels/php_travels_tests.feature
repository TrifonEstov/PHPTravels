Feature: Account management
  As a customer,
  I want to be able to log into my account

  Scenario: Successful login and logout
    Given the user is on PHP Travels homepage
    When he navigates to the sign in page
    And he enters "user@phptravels.com" as account email
    And he enters "demouser" as a password
    And he clicks Login button
    Then ensure that the account is successfully logged in
    And he clicks on Logout button
    Then ensure that the account is successfully logged out

  Scenario: Unsuccessful login
    Given the user is on PHP Travels homepage
    When he navigates to the sign in page
    And he enters "notexistinguser@gmail.com" as account email
    And he enters "123456" as a password
    And he clicks Login button
    Then ensure that the login is unsuccessful

  Scenario: Unsuccessful login - missing password
    Given the user is on PHP Travels homepage
    When he navigates to the sign in page
    And he enters "user@phptravels.com" as account email
    And he enters "" as a password
    And he clicks Login button
    Then ensure that the login is unsuccessful
#    And make sure that error message is shown

  Scenario: Successful Sign up as customer
    Given the user is on PHP Travels homepage
    When he navigates to the sign up page
    And he enters "Trifon" as first name,"Estov" as last name and "359877533938" as phone number
    And he enters email
    And he enters "123456" as password
    And he clicks on Signup button
    Then ensure that the sign up is successful
    And make sure that the sign into newly created account is successful

  Scenario: Unsuccessful signup - email already exists
    Given the user is on PHP Travels homepage
    When he navigates to the sign up page
    And he enters "Trifon" as first name,"Estov" as last name and "359877533938" as phone number
    And he enters "user@phptravels.com" already used email
    And he enters "123456" as password
    And he clicks on Signup button
    Then ensure that the sign up is unsuccessful due to already existing user