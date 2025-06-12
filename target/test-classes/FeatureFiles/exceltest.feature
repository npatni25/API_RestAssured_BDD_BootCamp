
@tag
Feature: Title of your feature
  I want to use this template for my feature file

 @exceltest
  Scenario: get user scenario
    Given User is already present
    When The user writes Python code from given sheetname "sheet1" firstname "UserFirstName" and lastname "UserLastName" 
    And Click on Run button
    Then User gets error alert box under Terminologies section
