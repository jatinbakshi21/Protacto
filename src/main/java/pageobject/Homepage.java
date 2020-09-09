package pageobject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class Homepage extends TestBase{

	//TestBase tb = new TestBase();
	//WebDriver driver;
	
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  
  @FindBy(xpath="//li[@class='mm_products']//a[@class='dropmenu']")
  WebElement product_btn;
  
  @FindBy(xpath="//span[contains(text(),'Add Product')]")
  WebElement Addproduct_btn;
  
  @FindBy(xpath="//span[contains(text(),'List Products')]")
  WebElement listproducts;
  
  @FindBy(xpath="//a[@href='http://wahjiwah-admin.lexerpos.com/pos']")
  WebElement POS_link;

  public WebElement product_btn()
  {
//	WebDriverWait wait = new WebDriverWait(driver, 15);
//	WebElement wb = product_btn();
//	wb=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='mm_products']//a[@class='dropmenu']")));
    return product_btn;

  }
  public WebElement Addproduct()
  {
  	return Addproduct_btn;
  }

  public WebElement listproducts()
  {
  	return listproducts;
  }
  
  public WebElement poslink()
  {
  	return POS_link;
  }
  
  public void Get_brokenLinks() {
	  String homePage = "http://wahjiwah-admin.lexerpos.com";
      String url = "";
      HttpURLConnection huc = null;
      int respCode = 200;
      
//      driver = new ChromeDriver();
//      
//      driver.manage().window().maximize();
      
      //driver.get(homePage);
      
      List<WebElement> links = driver.findElements(By.tagName("a"));
      
      Iterator<WebElement> it = links.iterator();
      
      while(it.hasNext()){
          
          url = it.next().getAttribute("href");
          
          System.out.println(url);
      
          if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
              continue;
          }
          
          if(!url.startsWith(homePage)){
              System.out.println("URL belongs to another domain, skipping it.");
              continue;
          }
          
          try {
              huc = (HttpURLConnection)(new URL(url).openConnection());
              
              huc.setRequestMethod("HEAD");
              
              huc.connect();
              
              respCode = huc.getResponseCode();
              
              if(respCode > 200){
                  System.out.println(url+" is a broken link");
              }
              else{
                  System.out.println(url+" is a valid link");
              }
                  
          } catch (MalformedURLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
      }
      
      //driver.quit();
  }
  
  
}
