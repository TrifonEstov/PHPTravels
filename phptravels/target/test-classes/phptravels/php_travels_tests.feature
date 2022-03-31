Feature: PHP Travels tests
  As a customer,
  I want to:
  - sign up, login and logout
  - search for hotel
  - search for flight
  - apply for visa
  - book a hotel

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

  Scenario: Book s featured hotel - without registration
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to the Featured Hotels section
    And he selects desired hotel
    And he selects desired room
    And he enters personal information
    And he enters travellers information
    And he chooses payment method
    And he accepts T&C and confirms booking
    Then ensure that the booking is completed

  Scenario: Book a featured hotel - with already logged in account
    Given the user is on PHP Travels homepage with accepted cookies
    When he navigates to the sign in page
    And he enters "user@phptravels.com" as account email
    And he enters "demouser" as a password
    And he clicks Login button
    Then ensure that the account is successfully logged in
    And he turns back to the homepage
    And he navigates to the Featured Hotels section
    And he selects desired hotel
    And he selects desired room
    And he enters travellers information
    And he chooses payment method
    And he accepts T&C and confirms booking
    Then ensure that the booking is completed

#  Scenario: Search for hotel by city
#    Given the user is on PHP Travels homepage with accepted cookies
#    When he navigates to hotels page
#    Then ensure that search search form and featured hotels section are available
#    And he clicks on search field and enters "Plovdiv" as desired destination
#    And he selects checkin and checkout dates
#    And he selects travelers number and nationality
#    And he clicks on Search hotel button
#    Then ensure that desired destination is found
#
#  Scenario: Search for flights
#    Given the user is on PHP Travels homepage with accepted cookies
#    When he navigates to flights page
#    And he selects "Sofia" as departure and "Munich" as destination airport
#    And he selects "Economy Premium" as flight type
#    And he selects departure date
#    And he selects the number of passangers
#    And he clicks on Search flight button
#    Then ensure that search result matches desired criteria
#
#  Scenario: Apply for visa
#    Given the user is on PHP Travels homepage with accepted cookies
#    When he navigates to submit visa page
#    And he selects "Bulgaria" as origin country and "Canada" as destination country
#    And he chooses visa start date
#    And he clicks on Submit button
#    Then ensure that submission form is displayed
#    And he enters