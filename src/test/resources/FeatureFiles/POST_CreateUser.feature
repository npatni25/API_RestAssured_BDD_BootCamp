@tag
Feature: API POST (Create User) request scenarios 

  @createUser
  Scenario: Successfully create a new user with valid data
    Given the request body contains valid first name, last name, contact number, email, and address
    When When post request is sent
    Then the response status code should be 201 with Message:created

  #Scenario: User creation fails with missing required fields
    #Given the request body is missing the contact number or email ID
    #When When post request is sent
    #Then the response status code should be 400 with error:BadRequest
  #
  #Scenario: User creation fails with missing FirstName fields
    #Given the request body is missing user First name
    #When When post request is sent
    #Then the response status code should be 400 with error:BadRequest
#
   #Scenario: User creation fails with missing email id fields
    #Given the request body is missing the email ID
    #When When post request is sent
    #Then the response status code should be 400 with error:BadRequest
#
   #Scenario: User creation fails with Invalid email format (e.g. user@domain)fields
    #Given the request body is having invalid email ID format
    #When When post request is sent
    #Then the response status code should be 400 with error:BadRequest
#
  #Scenario: User creation fails with Non-numeric contact_number (e.g. abc123)fields
    #Given the request body is having invalid user contact number format
    #When When post request is sent
    #Then the response status code should be 400 with error:BadRequest
#
  #Scenario: User creation fails with Duplicate email_id already registered fields
    #Given the request body is having duplicate email ID format
    #When When post request is sent
    #Then the response status code should be 409 with error: Conflict for email id 
#
    #Scenario: User creation fails with Duplicate contact_number already registered fields
    #Given the request body is having duplicate contact number
    #When When post request is sent
    #Then the response status code should be 409 with error: Conflict for contact already exists
#
   #Scenario: User creation fails with Missing entire userAddress object fields
    #Given the request body is missing entire userAddress object
    #When When post request is sent
    #Then the response status code should be 201 with created
#
  #Scenario: User creation fails with missing zipCode as string instead of integer (e.g. ABCDE)fields
    #Given the request body is having invalid Zipcode format
    #When When post request is sent
    #Then the response status code should be 400 with error:BadRequest
#
   #Scenario: User creation fails with missing Empty body {}
#
    #Given the request body is missing
    #When When post request is sent
    #Then the response status code should be 415 with error:MediaType
#
  #Scenario: User creation fails with Extra unknown field in request (e.g. user_role)
#
    #Given the request body is having extra field
    #When When post request is sent
    #Then the response status code should be 400 with error:BadRequest
#
    #Scenario: User creation fails with Large payload (over 1MB)
#
    #Given the request body is having Large payload
    #When When post request is sent
    #Then the response status code should be 500 with error:Internal server error
#
    #Scenario: User creation fails with invalid token
#
    #Given the request body is not authorized
    #When When post request is sent
    #Then the response status code should be 401 with error:Unauthorised user