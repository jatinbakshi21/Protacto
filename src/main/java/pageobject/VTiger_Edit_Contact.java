package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
public class VTiger_Edit_Contact extends TestBase {
	WebDriver driver;
	
	public VTiger_Edit_Contact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text'][@name='lastname']")
	WebElement lastname;

	@FindBy(xpath="//input[@name='Edit'][@type='submit']")
	WebElement editbutton;

	@FindBy(xpath="//table//table[2]//tbody[1]//tr[1]//td[1]//div[1]//input[1]")
	WebElement savebutton;
	
	@FindBy(xpath="//img[@id='jscal_trigger_support_end_date']")
	WebElement calander;
	
	@FindBy(xpath="//tr[@class='headrow']//td[2]")
	WebElement maymonth;
	
	@FindBy(xpath="//td[@class='day'][contains(text(),'19')]")
	WebElement mayday;
	
	@FindBy(xpath="//input[@name='Delete']")
	WebElement deletebutton;
	
	@FindBy(xpath="//input[@name='btn1'][@title='Change']")
	WebElement changebutton;
	
	@FindBy(xpath="//input[@name='title'][@type='text']")
	WebElement title;
	
	@FindBy(xpath="//input[@name='department'][@type='text']")
	WebElement department;
	
	@FindBy(xpath="//input[@name='email'][@type='text']")
	WebElement email;
		
	public WebElement Editbutton()
   {
	   return editbutton;
   }
   public WebElement lastname()
   {
	   return lastname;
   }        
   public WebElement Savebutton()
   {
	   return savebutton;
   }
   public WebElement deletebutton()
   {
	   return deletebutton;
   }
   public WebElement Changebutton()
   {
	   return changebutton;
   }
   public WebElement title()
   {
	   return title;
   }
   public WebElement department()
   {
	   return department;
   }
   public WebElement email()
   {
	   return email;
   }
   public WebElement calander()
   {
	   return calander;
   }
   public WebElement maymonth()
   {
	   return maymonth;
   }
   public WebElement mayday()
   {
	   return mayday;
   }
}
