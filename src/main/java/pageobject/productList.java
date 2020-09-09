package pageobject;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
//import testcases.Webelement;

public class productList extends TestBase{

	public static String[] results;
	static //This is how we declare a static array variable inside class
	{
		results = new String[100];
	}

	public static HashMap<String,String> hs = new HashMap<String,String>();
	
	
	
WebDriver driver;
	
	//Hided by me on 18-Apr-2020
	
	public productList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='PRData_filter']/label/input")
	static
	WebElement searchtextbox; 
	
	@FindBy(xpath="//div[@id='PRData_info']")
	static
	WebElement search_result; 
	
   public static WebElement searchbox()
   {
	  return searchtextbox;
   } 

   public static WebElement searchresult()
   {
	   return search_result;
   } 

   public static String[] show_array() 
   {
	  String[] arr = new String[10];
	  searchbox().sendKeys("bread");
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  //use of HashMap here to store 
	  hs.put("productList_search", searchresult().getText());
	  //use of an Array to store
	  arr[0]= searchresult().getText();
	  results[0]=arr[0];
	  return arr;
   } 
   
   
}