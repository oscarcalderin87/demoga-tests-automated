Feature: Text Box

  @textbox
  Scenario Outline: Fill Form
    Given The user goes to the Text Box page
    When The user fills the form with the data: "<fullName>", "<email>", "<currentAddress>" and "<permanentAddress>"
    Then The output data is being displayed
    And The output data contains the expected data: "<fullName>", "<email>", "<currentAddress>" and "<permanentAddress>"
    Examples:
      | fullName | email              | currentAddress | permanentAddress |
      | john doe | john.doe@gmail.com | Av 1 #1234     | Av 24 #567       |
