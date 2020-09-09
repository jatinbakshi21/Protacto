package stepDefinations;


import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import pageObjects.LandingPage;
import pageobject.Loginpage;
//import pageObjects.portalHomePage;
import testBase.TestBase;



public class stepDefination extends TestBase {

	SoftAssert softassert = new SoftAssert();
	
	
	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		launchBrowser();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}
	
	
	@Given("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {
		System.out.println("jojojo");
		Loginpage lp = new Loginpage(driver);
		//lp.username().sendKeys(arg0);   
	}
	
	
	@Then("^Verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		String str=driver.getTitle();
		System.out.println("Title =" + str);
		softassert.assertEquals(str,"Dashboard - BAKERS 35");
		softassert.assertAll();	
	}
	

	 @When("^User enters (.+) and (.+) and logs in$")
	 public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 Loginpage lp=new Loginpage(driver);
			lp.username().sendKeys(username);
			lp.password().sendKeys(password);
			lp.Login_click();
	 }
	
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	        //driver.quit();
	    }
	


}
