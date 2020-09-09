package stepDefinations;

import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.Homepage;
import testBase.TestBase;

public class HomePage extends TestBase{

	SoftAssert softassert = new SoftAssert();

	@When("User logs in successfully")
	public void user_logs_in_successfully() {
		Homepage Home = new Homepage(driver);
		System.out.println(driver.getTitle());
		

		softassert.assertEquals("Dashboard - BAKERS 35", driver.getTitle());
		softassert.assertAll();
	}
	@Then("Verify the title of Homepage")
	public void Verify_the_title_of_Homepage() {
		Homepage Home = new Homepage(driver);
		System.out.println(driver.getTitle());
		softassert.assertEquals("Dashboard - BAKERS 35", driver.getTitle());
		softassert.assertAll();
	}
	
//	@Then("Verify Add product page opens")
//	public void verify_Add_product_page_opens() {
//		Add_products ap = new Add_products(driver);
//		String str=ap.Verify_addproduct().getText();
//		softassert.assertEquals("Add Product", str);
//		softassert.assertAll();
//	}
	
}
