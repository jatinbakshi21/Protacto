Feature: validate Homepages
  @Smoke
  Scenario: Product page opens when user clicks on product button
    Given User is on Home page
    When User clicks on product Link
    And User clicks on Addproduct
    Then Verify Add product page opens

  @Regression
  Scenario Outline: login validation with valid credentials
    Given Initialize the browser with chrome
    And Navigate to "http://wahjiwah-admin.lexerpos.com/login/" Site
    When User enters <username> and <password> and logs in
    Then Verify that user is succesfully logged in
    And close browsers

    Examples: 
      | username | password  |
      | demouser | duser1234 |
