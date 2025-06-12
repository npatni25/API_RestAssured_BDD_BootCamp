@tag
Feature: Update user scenarios via PATCH Request

  Scenario: Verify that the user is able to update the user information with only first name
    Given User with only first name is available
    When User sends a PATCH request with first name
    Then The user should get the status code as 200: OK

  Scenario: Verify that the user is able to update the user information with only email
    Given User with only email is available
    When User sends a PATCH request with email
    Then The user should get the status code as 200: OK

  Scenario: Verify that the user is able to update the user information with only contact number
    Given User with only contact number is available
    When User sends a PATCH request with contact number
    Then The user should get the status code as 200: OK

  Scenario: Verify that the user is able to update the user information with all required fields
    Given User with all required fields available
    When User sends a PATCH request with all required fields
    Then The user should get the status code as 200: OK

  Scenario: Verify that the user is unable to update the user information with invalid user ID
    Given User with invalid user ID is available
    When User sends a PATCH request with invalid user ID
    Then The user should get the status code as 400: BAD REQUEST

  Scenario: Verify that the user is unable to update the user information with empty body
    Given User with empty body is available
    When User sends a PATCH request with empty body
    Then The user should get the status code as 400: BAD REQUEST

  Scenario: Verify that the user is unable to update the user information with invalid First Name
    Given User with invalid first name is available
    When User sends a PATCH request with invalid first name
    Then The user should get the status code as 400: BAD REQUEST

  Scenario: Verify that the user is unable to update the user information with Alpha Numeric Last Name
    Given User with Alpha Numeric Last name is available
    When User sends a PATCH request with Alpha Numeric Last name
    Then The user should get the status code as 400: BAD REQUEST

  Scenario: Verify that the user is unable to update the user information with Alpha Numeric Contact Number
    Given User with Alpha Numeric contact number is available
    When User sends a PATCH request with Alpha Numeric contact number
    Then The user should get the status code as 400: BAD REQUEST