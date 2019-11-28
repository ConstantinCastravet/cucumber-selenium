Feature: Reset functionality on login page of Application

  Scenario Outline: Login with valid username and password
    Given Open the Login Page
    Then Enter valid username"<username>"
    Then  Enter valid password"<password>"
    Then Click login button
    Then User should be

    Examples:
      | username        | password       |
      | endavamainadmin | ndvMnSR33eAA01 |


  Scenario Outline: Login with invalid  password
    Given Open the Login Page
    Then Enter valid username"<username>"
    Then  Enter invalid password"<password>"
    Then Click login button
    Then Should be displayed error message

    Examples:
      | username        | password       |
      | endavamainadmin | inavildpassword |
