
@tag
 Feature: Verify User API behavior with different inputs for Get request

  
  Scenario: Verify user with valid and existing first name
  Given the User API endpoint for first name is available
  When the user sends a GET request with a valid and existing first name
  Then the user receives response status code 20
  
  #Scenario Outline: Verify GET user by first name
    #Given User API endpoint is available
    #When User sends a GET request with "<firstNameInput>"
    #Then User receives response status code "<expectedStatus>"
#
    #Examples:
      #| firstNameInput                | expectedStatus |
      #| Valid and existing firstname | 200            |
      #| Case-converted firstname     | 404            |
      #| Firstname with space         | 404            |
      #| Non-existent firstname       | 404            |
      #| Empty firstname              | 404            |
      #| Null firstname               | 404            |
      #| Special characters firstname| 404            |
      #| Extremely long firstname     | 200            |
#
  #Scenario Outline: Verify GET user by ID
    #Given User API endpoint is available
    #When User sends a GET request with "<userIDInput>"
    #Then User receives response status code "<expectedStatus>"
#
    #Examples:
      #| userIDInput                 | expectedStatus |
      #| Valid ID                   | 200            |
      #| ID containing space        | 200            |
      #| Non-existent ID            | 404            |
      #| Invalid ID format          | 400            |
      #| Empty ID                   | 404            |
      #| Null ID                    | 404            |
      #| Special characters in ID   | 404            |
      #| Extremely long ID          | 404            |
#
  #Scenario Outline: Verify User API with invalid configurations
    #Given User API endpoint is available
    #When User sends a GET request to "<endpoint>" using "<method>" with base URL "<baseURL>"
    #Then User receives response status code "<expectedStatus>"
#
    #Examples:
      #| endpoint         | method | baseURL           | expectedStatus |
      #| /users/valid     | PUT    | validBaseURL      | 405            |
      #| /users/valid     | GET    | invalidBaseURL    | 404            |
      #| /invalidEndpoint | GET    | validBaseURL      | 405            |
      #| /users/valid     | GET    | invalidBaseURL    | 406            |
      #| /users/valid     | DELETE | validBaseURL      | 407            |
      #| /invalid         | GET    | validBaseURL      | 408            |
      #| ""               | GET    | validBaseURL      | 409            |
      #| /bad-endpoint    | GET    | validBaseURL      | 410            |
      #| /users           | PATCH  | validBaseURL      | 411            |
