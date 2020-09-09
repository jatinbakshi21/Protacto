package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
//import testcases.Webelement;

public class pos extends TestBase{

WebDriver driver;
	
	//Hided by me on 18-Apr-2020
	
	public pos(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="#category-12o > img")
	WebElement breads; 

	@FindBy(xpath="//button[@id='category-46o']")
	WebElement beverages;
	
	@FindBy(xpath="//button[@id='product-0781']")
	WebElement black_forest; 
	
	@FindBy(xpath="//div[@id='category-list']")
	WebElement category_div; 	
	
	@FindBy(xpath="//div[@id='item-list']/div/div")
	WebElement product_div; 
	
	@FindBy(xpath="//button[@type='button'][@class='btn btn-primary']")
	WebElement ok_button;
	
	@FindBy(xpath="//a[@id='live_sync']")
	WebElement sync;
	
	@FindBy(xpath="//button[@id='payment']")
	WebElement payment_button; 

	@FindBy(xpath="//span[@id='submit-withoutprint']")
	WebElement submit_withoutprint; 
	
   public WebElement breads()
   {
	  return breads;
   } 

   public WebElement beverages()
   {
	  return beverages;
   }
   
   public WebElement category_div()
   {
	  return category_div;
   } 

   public WebElement product_div()
   {
	  return product_div;
   } 
   
   public int category_list()
   {
	   return category_div.findElements(By.tagName("button")).size();
   }
   
   public int searchProducts()
   {
	   return product_div.findElements(By.tagName("button")).size();
   } 
   
   public WebElement ok_button()
   {
	  return ok_button;
   }  
   
   public WebElement sync()
   {
	  return sync;
   }      
   
   public WebElement payment_button()
   {
	  return payment_button;
   }    
   
   public WebElement black_forest()
   {
	  return black_forest;
   }  
   
   public WebElement submit_withoutprint_button()
   {
	  return submit_withoutprint;
   }       
   
   
   public void Product_Category_count() {
	   
		//Below codes use javascript executor to click on category
		for (int i =0;i<=category_list()-1;i++) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", category_div().findElements(By.tagName("button")).get(i));
			System.out.println("Products Count= " + searchProducts());
		}
	   //beverages.click();
	   
   }
   
   public void First_payment() {
	   
		//Below codes use javascript executor to click on categories
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click();", product_div().findElements(By.tagName("button")).get(0));
//			js.executeScript("arguments[0].click();", product_div().findElements(By.tagName("button")).get(1));
	   		black_forest.click();
	   		black_forest.click();
	   		black_forest.click();
	   		black_forest.click();
	   		
	   		payment_button.click();
			submit_withoutprint.click();
			driver.manage().window().maximize();
   }
   
   
   
   
   
}