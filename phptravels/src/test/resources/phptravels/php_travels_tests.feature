Feature: PHP Travels tests
  As a customer,
  I want to:
  - sign up, login and logout
  - search for hotel in desired destination
  - book a vacation

  Scenario: Successful login and logout
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to the sign in page
    And he enters "user@phptravels.com" as account email
    And he enters "demouser" as a password
    And he clicks Login button
    Then ensure that the account is successfully logged in
    And he clicks on Logout button
    Then ensure that the account is successfully logged out

  Scenario: Unsuccessful login - not existing account
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to the sign in page
    And he enters "notexistinguser@gmail.com" as account email
    And he enters "123456" as a password
    And he clicks Login button
    Then ensure that the login is unsuccessful

  Scenario: Unsuccessful login - missing password
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to the sign in page
    And he enters "user@phptravels.com" as account email
    And he enters "" as a password
    And he clicks Login button
    Then ensure that the login is unsuccessful
#    And make sure that error message is shown

  Scenario: Successful Sign up as customer
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to the sign up page
    And he enters "Trifon" as first name,"Estov" as last name and "359877533938" as phone number
    And he enters email
    And he enters "123456" as password
    And he clicks on Signup button
    Then ensure that the sign up is successful
    And make sure that the sign into newly created account is successful

  Scenario: Unsuccessful signup - email already exists
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to the sign up page
    And he enters "Trifon" as first name,"Estov" as last name and "359877533938" as phone number
    And he enters "user@phptravels.com" as already used email
    And he enters "123456" as password
    And he clicks on Signup button
    Then ensure that the sign up is unsuccessful due to already existing user

  Scenario: Search for hotel by city
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to hotels page
    Then ensure that search search form and featured hotels section are available
#    And he clicks on search field and enters "Plovdiv" as desired destination
    And he selects checkin and checkout dates
    And he selects travelers number and nationality
    And he clicks on Search button
#    Then ensure that desired destination is found

  Scenario: Book featured hotel - without registration
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to the Featured Hotels section
    And he selects desired hotel
    And he selects desired room
    And he enters personal information
    And he enters travellers information
    And he chooses payment method
    And he accepts T&C and confirms booking
    Then ensure that the booking is completed

