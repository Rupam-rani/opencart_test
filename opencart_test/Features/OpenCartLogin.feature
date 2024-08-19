Feature: Login with Valid Credential

  @sanity
  Scenario: Successful Login with Valid Credential
    Given the user navigates to login page
    When user enters email as "pammi123@gmail.com" and password as "Test@123"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
      #Scenario Outline: Login Data Driven Excel
       #Given the user navigates to login page
     # Then the user should be redirected to the MyAccount Page by passing email and password with excel row "<row_index>"
       #Examples:
      #| row_index |
      #|         1 |
      #|         2 |
      #|         3 |
