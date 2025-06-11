@tag
Feature: Update User (PUT) scenarios

  Scenario: Verify user with valid and existing first name
    Given User API endpoint {firstName}is available
    When User sends a GET request with Valid firstname
    Then User recieves response status code should be 200

  Scenario: Verify user with first name input with case conversion
    Given User API endpoint {firstName}is available
    When User sends a GET request with Case-converted firstname
    Then User recieves response status code should be 404

  Scenario: Verify user with first name containing space
    Given User API endpoint {firstName}is available
    When User sends a GET request with spaces firstname
    Then User sends a GET request with spaces firstname

  Scenario: Verify user with a first name that does not exist
    Given User API endpoint {firstName}is available
    When User sends a GET request with No existing firstname
    Then User recieves response status code should be 404

  Scenario: Verify user with an empty first name
    Given User API endpoint {firstName}is available
    When User sends a GET request with empty firstname
    Then User recieves response status code should be 404

  Scenario: Verify user with null as first name
    Given User API endpoint {firstName}is available
    When User sends a GET request with null firstname
    Then User recieves response status code should be 404

  Scenario: Verify user with special characters in first name
    Given User API endpoint {firstName}is available
    When User sends a GET request with special characters firstname
    Then User recieves response status code should be 404

  Scenario: Verify user with an extremely long first name
    Given User API endpoint {firstName}is available
    When User sends a GET request with long firstname
    Then User recieves response status code should be 200

  Scenario: Verify user with valid first name with invalid method type
    Given User API endpoint {user}is available
    When User sends a GET request with ivalid method type
    Then User recieves 405Method Not Allowed

  Scenario: Verify user with valid first name with invalid baseURL
    Given User API endpoint {user}is available
    When User sends a GET request with ivalid baseURL
    Then User recieves 404 Not Found

  Scenario: Verify user with valid firstname with  invalid endpoint
    Given User API endpoint {firstName}is available
    When User sends a GET request with ivalid endpoint
    Then user recieves 405 Method Not Allowed

  Scenario: Verify user with valid ID
    Given User API endpoint {userID}is available
    When User sends a GET request with valid ID
    Then User recieves response status code should be 200

  Scenario: Verify user with ID containing space
    Given User API endpoint {userID}is available
    When Verify user with ID containing space
    Then User recieves response status code should be 200

  Scenario: Verify user with non-existent ID
    Given User API endpoint {userID}is available
    When User sends a GET request with non-existent ID
    Then User recieves response status code should be 404

  Scenario: Verify user with invalid ID format
    Given User API endpoint {userID}is available
    When User sends a GET request with invalid ID format
    Then User recieves response status code should be 400

  Scenario: Verify user with a ID that does not exist
    Given User API endpoint {userID}is available
    When User sends a GET request with No existing ID
    Then User recieves response status code should be 404

  Scenario: Verify user with an empty ID
    Given User API endpoint {userID}is available
    When User sends a GET request with empty ID
    Then User recieves response status code should be 404

  Scenario: Verify user with null as ID
    Given User API endpoint {userID}is available
    When User sends a GET request with null ID
    Then User sends a GET request with null ID

  Scenario: Verify user with special characters in ID
    Given User API endpoint {userID}is available
    When User sends a GET request with special characters ID
    Then User recieves response status code should be 404

  Scenario: Verify user with an extremely long ID
    Given User API endpoint {userID}is available
    When User sends a GET request with long ID
    Then User recieves response status code should be 404

  Scenario: Verify user with userID with  invalid endpoint
    Given User API endpoint {userID}is available
    When User sends a GET request with  ID
    Then User recieves response status code should be 404

  Scenario: Verify user with userID with  invalid baseURL
    Given User API endpoint {userID}is available
    When User sends a GET request with  ID
    Then User recieves response status code should be 404

  Scenario: Verify user with valid userID with invalid method type
    Given User API endpoint {userID}is available
    When User sends a GET request with  ID
    Then User recieves response status code should be 404

  Scenario: Verify user with invalid URL with valid basic Auth
    Given User API endpoint {userID}is available
    When User sends a GET request with  user
    Then User recieves response status code should be 404

  Scenario: Verify user without endpoint
    Given User API endpoint {userID}is available
    When User sends a GET request with  user
    Then User recieves response status code should be 404

  Scenario: Verify user with invalid endpoint
    Given User API endpoint {userID}is available
    When User sends a GET request with  user
    Then User recieves response status code should be 404

  Scenario: Verify user with invalid method type
    Given User API endpoint {userID}is available
    When User sends a GET request with  user
    Then User recieves response status code should be 404 (edited)
