Feature: Add a product in add product page
@Smoke
Scenario: Fill the product details and click on add product
Given User is on product page
When User fills the product details
Then Verify Add product page opens

