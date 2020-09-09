package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;//by jatin on 13-may
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

//import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;


//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.ExtentReports;

//import excelReader.Excel_Reader;
//import helper.WaitHelper;

public class TestBase {
	// Data Variables
	ExtentReports extent;
	//public static ExtentTest logger;//for Extent report logs
	//public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;
	//public static ExtentReports extent;//for Extent report
	//public static ExtentTest test;
	public ITestResult result;
	//public Excel_Reader excel_reader;
	// Data Methods
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		//extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/reports/test"
		//		+ formater.format(calendar.getTime()) + ".html", false);
	}
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			//test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			//test.log(LogStatus.SKIP,
			//		result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			//test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			
			//String screen = getScreenshot("");//hidded on 25-july
			
			//test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			//test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getResult(result);
	}
/*
	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + "Test Started");
	}
*/
	@AfterClass(alwaysRun = true)
	public void endTest() {
		// driver.quit();
		//extent.endTest(test);
		//extent.flush();
	}

	// Method to get single locator for Web pages
	public static WebElement getLocator(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		System.out.println("Inside Get Element");
		System.out.println("Locator Type: " + locatorType);
		System.out.println("Locator Value: " + locatorValue);

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	// Method to get multiple locators for Web pages
	public static List<WebElement> getLocators(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		System.out.println("Inside Get ElementS");
		System.out.println("Locator Type: " + locatorType);
		System.out.println("Locator Value: " + locatorValue);

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public WebElement getWebElement(String locator) throws Exception {
		return getLocator(OR.getProperty(locator));
	}

	public List<WebElement> getWebElements(String locator) throws Exception {
		return getLocators(OR.getProperty(locator));
	}

	public void getBrowser(String browser) {
		if (System.getProperty("os.name").contains("Windows")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
			}
		}
	}
	// Load Properties Files
	public void loadPropertiesFile() throws IOException {
		String log4jConfigPath = "log4j.properties";
		//PropertyConfigurator.configure(log4jConfigPath);

		OR = new Properties();
		f1 = new File(System.getProperty("user.dir") + "/config/config.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		//logger.info("Loading config.properties");
	}
	// Take Screenshot
	
	
//	public String getScreenshot(String imageName) throws IOException {
//		if (imageName.equalsIgnoreCase("")) {
//			imageName = "blank";
//		}
//		// cast driver with TakeScreenshoot Interface
//		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String imageLocation = System.getProperty("user.dir") + "/src/main/java/screenshots/";
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//		String actualImageName = imageLocation + imageName + "_" + formater.format(calendar.getTime()) + ".png";
//		File destFile = new File(actualImageName);
//		//FileUtils.copyFile(image, destFile);////by jatin on 13-may-20
//		//logger.info("Screenshoot taken...");
//		return actualImageName;
//	}

	// Method for Implicit wait
	public void waitImplicit(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// Method for Explicit wait
	public WebElement waitExplecit(WebDriver driver, long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Method for fluent wait
	@SuppressWarnings("deprecation")
	public WebElement waitFluent(WebDriver driver, long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		//wait.pollingEvery(5, TimeUnit.SECONDS);  commented by me after compile error and upgrading selenium version
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Read property file
	//public String[][] getData(String ecxelName, String sheetName) {
		//String excelLocation = System.getProperty("user.dir") + "\\src\\main\\java\\data\\" + ecxelName;
		//excel_reader = new Excel_Reader();
		//return excel_reader.getExcelData(excelLocation, sheetName);
	//}

	//@BeforeTest--->hided on 04-Aug
	public void launchBrowser() {
		try {
			loadPropertiesFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Config config = new Config(OR);
		System.out.println("browser "+config.getBrowser());
		getBrowser(config.getBrowser());
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
		driver.get(config.getWebsite());
		//above New line added by me on 21-Sep-2019
		
		//extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\STMExtentReport.html", true);
		//if true=then it will replace a new report else false then append the report
		//extent.addSystemInfo("Host Name","Software Testing Material");
		//extent.addSystemInfo("Environment","Automation Testing");
		//extent.addSystemInfo("User Name","Jatin Bakshi");
		//extent.loadConfig(new File(System.getProperty("user.dir")+"\\test-output\\extent-config.xml"));
		
		//WaitHelper waitHelper = new WaitHelper(driver);
		//waitHelper.setImplicitWait(config.getImplicitWait(), TimeUnit.SECONDS);
		//waitHelper.setPageLoadTimeout(config.getPageLoadTimeOut(), TimeUnit.SECONDS);

	}
//@BeforeTest
//public void config()
//
//{
//
//// ExtentReports , ExtentSparkReporter
//
//String path =System.getProperty("user.dir")+"\\reports\\index.html";
//System.out.println("Pathhh  " + path);
///ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//
//reporter.config().setReportName("Web Automation Results");
//
//reporter.config().setDocumentTitle("Test Results");
//
//extent =new ExtentReports();
//
//extent.attachReporter(reporter);
//
//extent.setSystemInfo("Tester", "Jatin Bakshy");
//
//}
//public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
//{
//	TakesScreenshot ts=(TakesScreenshot) driver;
//	File source =ts.getScreenshotAs(OutputType.FILE);//Commented by Jatin 21-june 
//	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
//	FileUtils.copyFile(source,new File(destinationFile));
//	return destinationFile;
//
//
//}	


//public void getScreenShotPath()
//{
//	TakesScreenshot ts=(TakesScreenshot) driver;
//	File source =ts.getScreenshotAs(OutputType.FILE);//Commented by Jatin 21-june 
//	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
//	FileUtils.copyFile(source,new File(destinationFile));
//	return destinationFile;
//
//
//}

//@AfterTest
	public void endReport() {
	try {	
	extent.flush();

	}
	catch(Exception e){
System.out.println("DDDDDDDDDDDD LUNER "+e);
		
	}
}
	
}
