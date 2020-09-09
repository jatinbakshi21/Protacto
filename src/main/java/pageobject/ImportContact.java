package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
public class ImportContact extends TestBase {
	WebDriver driver;
	
	public ImportContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='FormBorder']")
	WebElement table;

	@FindBy(xpath="//td[contains(text(),'Showing')]")
	WebElement count;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement deletebutton;
	
	@FindBy(xpath="//tr[8]//td[16]//a[1]")
	WebElement editlink;
	
	@FindBy(xpath="//tr[5]//td[16]//a[2]")
	WebElement deletelink;
	
   public WebElement deletebutton()
   {
	   return deletebutton;
   }
     
   public WebElement editlink()
   {
	   return editlink;
   }

   public WebElement deletelink()
   {
	   return deletelink;
   }
   
   public WebElement table()
   {
	   return table;
   }
   public WebElement pagecount()
   {
	   return count;
   }
      
}
