package stepDefinations;


import static org.testng.Assert.assertEquals;
//import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.Add_products;
import pageobject.Homepage;
import testBase.TestBase;

public class Add_product extends TestBase{

	SoftAssert softassert = new SoftAssert();
	
	ErrorCollector err = new ErrorCollector();
	@Before
	public void setup() {
		System.out.println("Launch browser");
	}	
	
	@Given("User is on Home page")
	public void user_is_on_Home_page() {
		System.out.println("passed @ homepage");
	}

	@Rule
	
	@Given("User is on product page")
	public void User_is_on_product_page() {
		Add_products ap = new Add_products(driver);
		String title =  driver.getTitle();
		System.out.println("Title************** "+title);
		softassert.assertEquals(title,"Add Product - BAKERS 350");
		//softassert.assertAll();
		System.out.println("Title "+ title);
		//assertEquals("Add Product - BAKERS 350",title);
	}
		

	@When("User fills the product details")
	public void User_fills_the_product_details() {
		Add_products ad = new Add_products(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;// code to change attributes value
		js.executeScript("document.getElementById('type').setAttribute('style', 'none')");

		WebElement select = driver.findElement(By.id("type"));//to select value from dropdown
		((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, "combo");
		
		ad.product_type1().click();
		ad.productname().sendKeys("jamuns");
		Actions ar = new Actions(driver);
		ar.moveByOffset(352, 596);
		ad.addbutton().click();
	}
	
	@When("User clicks on product Link")
	public void user_clicks_on_product_Link() {
		Homepage Home = new Homepage(driver);
		WebElement btn=super.waitExplecit(driver, 5000, Home.product_btn());
		softassert.assertEquals(btn.isDisplayed(),true);
		//softassert.assertAll();
		btn.click();
	}
	@And("User clicks on Addproduct")
	public void user_clicks_on_Addproduct() {
		Homepage Home = new Homepage(driver);
		WebElement btn2=super.waitExplecit(driver, 5000, Home.Addproduct());
		softassert.assertEquals(btn2.isDisplayed(),true);
		//softassert.assertAll();
		btn2.click();
		}
	@Rule
	@Then("Verify Add product page opens")
	public void verify_Add_product_page_opens() {
		//try {
		Add_products ap = new Add_products(driver);
		String str=ap.Verify_addproduct().getText();
		System.out.println("Text "+ str);
		softassert.assertEquals("Add Products",str);
		softassert.assertAll();
		//assertEquals("Time hai ","Add Products",str);
//		}
//		catch (Throwable e)
//			{
//				err.addError(e);
//			}
		}

	
}