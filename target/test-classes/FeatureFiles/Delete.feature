
@tag
Feature: API Delete request scenarios 

  Scenario: Delete an existing user by UserID
    Given User with the mentioned UserID is already present
    When /deleteuser/userId request is sent
    Then The Response Status Code 200 Okay with success message User is deleted successfully should be displayed

  Scenario: Delete an existing user by FirstName
    Given User with the mentioned FirstName is already present
    When /deleteuser/username/userfirstname requent is sent
    Then The Response Status Code 200 Okay with success message User is deleted successfully should be displayed
  
  Scenario: Delete the user by UserID which was already removed
    Given User with mentioned UserID was deleted
    When DELETE Endpoint : /deleteuser/userId request is sent
    Then The Response Status Code 404 NOT FOUND with message User does not exist with nameuserID should be displayed

  Scenario: Delete the user by FirstName which was already removed
    Given User with mentioned FirstName was deleted
    When DELETE Endpoint : /deleteuser/username/userfirstname request is sent
    Then The Response Status Code 404 NOT FOUND with message User does not exist with nameuserfirstname should be displayed
 
  Scenario: Delete user by providing invalid format of UserID (Alpha-Numeric)
    Given User with UserID which includes Alpha-Numeric is not present
    When /deleteuser/userId contains alpha-numeric request is sent
    Then Pop up should be displayed to enter only numeric values for UserID and should not allow user to execute

  Scenario: Delete user by providing invalid format of UserID (space in between the UserID)
    Given User with UserID which includes space in the UserID is not present
    When /deleteuser/userId contains space request is sent
    Then Pop up should be displayed to enter only numeric values for UserID and should not allow user to execute

  Scenario: Delete user by providing invalid format of UserID (special characters in the UserID)
    Given User with UserID which includes special character in the UserID is not present
    When /deleteuser/userId contains special characters request is sent
    Then Pop up should be displayed to enter only numeric values for UserID and should not allow user to execute

  Scenario: Delete user by providing invalid format of FirstName (Alpha-Numeric)
    Given User with FirstName which includes Alpha-Numeric is not present
    When /deleteuser/username/userfirstname contains alpha-numeric requent is sent
    Then Pop up should be displayed to enter only alphabetic values for FirstName and should not allow user to execute

  Scenario: Delete user by providing invalid format of FirstName (Space in between the FirstName)
    Given User with FirstName which includes space in the UserID is not present
    When /deleteuser/username/userfirstname contains space requent is sent
    Then Pop up should be displayed to enter only alphabetic values with no space in between for FirstName and should not allow user to execute

  Scenario: Delete user by providing invalid format of FirstName (Special characters in the FirstName)
    Given User with FirstName which includes special character in the UserID is not present
    When /deleteuser/username/userfirstname contains special characters requent is sent
    Then Pop up should be displayed to enter only alphabetic values for FirstName and should not allow user to execute

  Scenario: Delete user by keeping UserID blank
    Given Any valid user is present in the system
    When /deleteuser/ request is sent
    Then 404 status

  Scenario: Delete user by keeping FirstName blank
    Given Any valid user is present in the system
    When /deleteuser/username/ request is sent

    #Scenario: Verify that the user deleted by userID is not present
    #Given User with mentioned UserID was deleted
    #When GET EndPoint:user/userId request is sent
    #Then The Response Status Code 404 NOT FOUND with message User does not exist with nameuserID should be displayed
#
  #Scenario: Verify that the user deleted by FirstName is not present
    #Given User with mentioned FirstName was deleted
    #When GET EndPoint:users/username/userFirstName request is sent
    #Then The Response Status Code 404 NOT FOUND with message User does not exist with nameuserfirstname should be displayed
  
  #Scenario: Trying to update (PUT) information of the deleted user
    #Given User was removed
    #When PUT EndPoint: updateuser/userId request is sent
    #Then The Response Status Code 400 - Bad request - invalid inputs should be displayed
#
  #Scenario: Adding/creating a deleted user using POST with the same user details
    #Given User with the same deatils is not present in the system
    #When POST EndPoint: /createusers request is sent
    #Then The Response Status Code 201 Okay with success message User Created should be displayed
    