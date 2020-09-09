package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;


public class Delete_Contact extends TestBase {
	WebDriver driver;
	
	public Delete_Contact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='FormBorder']")
	WebElement table;

//	@FindBy(xpath="//td[contains(text(),'Showing 1 - 6 of 6')]")
//	WebElement count;
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement deletebutton;
	
	@FindBy(xpath="//tr[8]//td[16]//a[1]")
	WebElement editlink;
	
	@FindBy(xpath="//tr[5]//td[16]//a[2]")
	WebElement deletelink;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	WebElement contactLink;
	
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
//   public WebElement pagecount()
//   {
//	   return count;
//   }
   
   public Delete_Contact contactLink()
   {
	   contactLink.click();
	   Delete_Contact dc = new Delete_Contact(driver);
	   return dc;
   }   
}
