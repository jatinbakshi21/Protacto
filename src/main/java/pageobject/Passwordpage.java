package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class Passwordpage extends TestBase{
	//WebDriver driver;
	
	
	public Passwordpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}//*/
	
	@FindBy(xpath=".//input[@name='user_password']")
	WebElement password;

	@FindBy(xpath=".//input[@type='submit']")
	WebElement Loginbutton;
	
	@FindBy(xpath=".//span[@input-group-addon='#e0c8c8']")
	WebElement bgcolour;    
	

   public WebElement password()
   {
	   return password;
   }
   
   public void Login_click()
   {
	   Loginbutton.click();
   } 

}