package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
//import testcases.Webelement;

public class Add_products extends TestBase{

WebDriver driver;
	
	//Hided by me on 18-Apr-2020
	
	public Add_products(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}//*/

	@FindBy(xpath="//div[@id='select2-result-label-48']/span")
	WebElement product_type; 

	@FindBy(xpath="//h2[@class='blue']")
	WebElement Verify_addproduct; 	
	
	@FindBy(xpath="//select[@id='type']")
	WebElement product_type1;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement productname;

	@FindBy(xpath="//input[@id='price']")
	WebElement price;
	
	@FindBy(xpath="//input[@name='add_product']")
	WebElement addbutton;
	
	
   public WebElement Verify_addproduct()
   {
	  return Verify_addproduct;
   }	
	
   public WebElement product_type1()
   {
	  return product_type1;
   } 
 
   public WebElement productname()
   {
	  return productname;
   } 

   public WebElement price()
   {
	  return price;
   } 
  
   public WebElement addbutton()
   {
	  return addbutton;
   } 
   
   
}