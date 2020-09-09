package pageobject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class Loginpage extends TestBase{

	WebDriver driver;
	
	//Hided by me on 18-Apr-2020
	
	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}//*/
	
	@FindBy(xpath="//input[@name='identity']")
	WebElement username;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Loginbutton;
	
	@FindBy(xpath="//p[contains(text(),'Login Failed, Please try agains')]")
	WebElement validationtext;
	
	
	@FindBy(xpath="//input[@name='password'][@type='password']")
	WebElement password;

	@FindBy(xpath="//a[@href='#forgot_password']")
	WebElement forgot_paswd;
	
   public WebElement username()
   {
	   return username;
	   
   }
        
   public WebElement password()
   {
	   return password;
	   
   }
   
   public void Login_click()
   {
	   Loginbutton.click();
	   get_cookie();
	   //cookiewrite();
   } 
   
   public void get_cookie()
   {
	 
	   File file = new File("Cookies.data");							
       try		
       {	  
           // Delete old file if exists
    	   file.delete();		
           file.createNewFile();			
           FileWriter fileWrite = new FileWriter(file);							
           BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
           // loop for getting the cookie information 		
           	
           // loop for getting the cookie information 		
           for(Cookie ck : driver.manage().getCookies())							
           {			
               Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
               Bwrite.newLine();             
           }			
           Bwrite.close();			
           fileWrite.close();	
           
       }
       catch(Exception ex)					
       {		
           ex.printStackTrace();			
       }		
   }		
	 
   
   public void cookiewrite() {
	   
	   try{			
		     
	        File file = new File("Cookies.data");							
	        FileReader fileReader = new FileReader(file);							
	        BufferedReader Buffreader = new BufferedReader(fileReader);							
	        String strline;			
	        while((strline=Buffreader.readLine())!=null){									
	        StringTokenizer token = new StringTokenizer(strline,";");									
	        while(token.hasMoreTokens()){					
	        String name = token.nextToken();					
	        String value = token.nextToken();					
	        String domain = token.nextToken();					
	        String path = token.nextToken();					
	        Date expiry = null;					
	        		
	        String val;			
	        if(!(val=token.nextToken()).equals("null"))
			{		
	        	expiry = new Date(val);					
	        }		
	        Boolean isSecure = new Boolean(token.nextToken()).								
	        booleanValue();		
	        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
	        System.out.println(ck);
	        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
	        }		
	        }		
	        }catch(Exception ex){					
	        ex.printStackTrace();			
	        }		
	   //line removed by me     
	   //driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");					
	}	
	   
   
   

   public WebElement validationtext()
   {
	   return validationtext;
   } 
   
   public WebElement forgot()
   {
	   return forgot_paswd;
   }
}