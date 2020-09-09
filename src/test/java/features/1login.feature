Feature: Login into Application
@Smoke
Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://wahjiwah-admin.lexerpos.com/login/" Site
And Click on Login link in home page to land on Secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is succesfully logged in
And close browsers
Examples:
|username			|password	|
|demouser	|duser1234		|

@Regression1
Scenario Outline: login validation with invalid credentials
Given Initialize the browser with chrome
And Navigate to "http://wahjiwah-admin.lexerpos.com/login/" Site
When User enters <username> and <password> and logs in
Then Verify that validation message appears on page
And close browsers
Examples:
|username			|password	|
|test919@gmail.com	|123456		|

@Regression
Scenario Outline: login validation with valid credentials
Given Initialize the browser with chrome
And Navigate to "http://wahjiwah-admin.lexerpos.com/login/" Site
When User enters <username> and <password> and logs in
Then Verify that user is succesfully logged in
And close browsers
Examples:
|username			|password	|
|demouser	|duser1234	|
