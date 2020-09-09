$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/1login.feature");
formatter.feature({
  "name": "Login into Application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Positive test validating login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "Initialize the browser with chrome",
  "keyword": "Given "
});
formatter.step({
  "name": "Navigate to \"http://wahjiwah-admin.lexerpos.com/login/\" Site",
  "keyword": "And "
});
formatter.step({
  "name": "Click on Login link in home page to land on Secure sign in Page",
  "keyword": "And "
});
formatter.step({
  "name": "User enters \u003cusername\u003e and \u003cpassword\u003e and logs in",
  "keyword": "When "
});
formatter.step({
  "name": "Verify that user is succesfully logged in",
  "keyword": "Then "
});
formatter.step({
  "name": "close browsers",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "demouser",
        "duser1234"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Positive test validating login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Initialize the browser with chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.initialize_the_browser_with_chrome()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to \"http://wahjiwah-admin.lexerpos.com/login/\" Site",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.navigate_to_Site(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login link in home page to land on Secure sign in Page",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters demouser and duser1234 and logs in",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefination.user_enters_and_and_logs_in(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify that user is succesfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.verify_that_user_is_succesfully_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close browsers",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.close_browsers()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/features/2HomePage.feature");
formatter.feature({
  "name": "validate Homepages",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Product page opens when user clicks on product button",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Home page",
  "keyword": "Given "
});
formatter.match({
  "location": "Add_product.user_is_on_Home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on product Link",
  "keyword": "When "
});
formatter.match({
  "location": "Add_product.user_clicks_on_product_Link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Addproduct",
  "keyword": "And "
});
formatter.match({
  "location": "Add_product.user_clicks_on_Addproduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Add product page opens",
  "keyword": "Then "
});
formatter.match({
  "location": "Add_product.verify_Add_product_page_opens()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\texpected [Add Product] but found [Add Products]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:43)\r\n\tat stepDefinations.Add_product.verify_Add_product_page_opens(Add_product.java:92)\r\n\tat ✽.Verify Add product page opens(src/test/java/features/2HomePage.feature:7)\r\n",
  "status": "failed"
});
formatter.uri("src/test/java/features/3Add_product.feature");
formatter.feature({
  "name": "Add a product in add product page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Fill the product details and click on add product",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on product page",
  "keyword": "Given "
});
formatter.match({
  "location": "Add_product.User_is_on_product_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User fills the product details",
  "keyword": "When "
});
formatter.match({
  "location": "Add_product.User_fills_the_product_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Add product page opens",
  "keyword": "Then "
});
formatter.match({
  "location": "Add_product.verify_Add_product_page_opens()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\texpected [Add Product - BAKERS 350] but found [Add Product - BAKERS 35],\n\texpected [Add Product] but found [Add Products]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:43)\r\n\tat stepDefinations.Add_product.verify_Add_product_page_opens(Add_product.java:92)\r\n\tat ✽.Verify Add product page opens(src/test/java/features/3Add_product.feature:6)\r\n",
  "status": "failed"
});
});