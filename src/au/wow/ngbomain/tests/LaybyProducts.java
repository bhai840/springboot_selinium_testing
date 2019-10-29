package au.wow.ngbomain.tests;
import org.openqa.selenium.JavascriptExecutor;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import au.wow.ngbo.utils.BasePage;
import au.wow.ngbo.utils.CustomExtentReports;
import au.wow.ngbo.utils.TestBase;
import au.wow.ngbo.utils.TestContext;
import au.wow.ngbo.utils.TestStatus;
import au.wow.ngbo.utils.XMLDataReader;
import au.wow.ngbomain.objects.LaybyObjects;

import au.wow.ngbomain.pages.CommonFunctions;
import au.wow.ngbomain.pages.LaybyPages;
//import au.wow.ngbomain.pages.objLaybyPages;
//import au.wow.ngbomain.pages.Pack;
import au.wow.ngbomain.pages.WoWLoginPage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class LaybyProducts extends TestBase{
	private static final Object ExpCustName = null;
	private Logger log = LogManager.getLogger(LaybyProducts.class);
	//SQLWrapper sql = new SQLWrapper(log);
	WoWLoginPage loginPage;
	BasePage BaseObj;
	CommonFunctions common;
	//StoreProperties storeprop;
	LaybyPages objLaybyPages;
	LaybyObjects objLaybyObjects;
	int ADcount=0;
	List<List<Object>> results;
	List<List<Object>> results1;
	public static XMLDataReader data;
	public static boolean isFirstTest=true;
	public static String mName="";
	public static String cName ="";
	public static ArrayList<String> methodList = new ArrayList<String>();
	public static  ExtentTest extLogger;
	public static ExtentReports extReport;	
	public static boolean isExceptionCaptured=false;
	int count=0;		
	public static WebDriver driver;



	public LaybyProducts(){
		super.log=log;
	}

	
	@Test(description = "Creating a product")
	public void LaybyProducts_FDNewProduct() throws InterruptedException, IOException
	{
		TestStatus status = getTestStatus();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 //get current date 
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 System.out.println(date1);
		
		  File src=new File("C:\\Soft\\LaybyBrowser\\TestData\\Data.xlsx");
		  FileInputStream fis=new FileInputStream(src);
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet sh1= wb.getSheetAt(0);
		  System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
		
		  objLaybyObjects.CreateProduct.click();
		
		  objLaybyObjects.productId1.sendKeys(sh1.getRow(1).getCell(0).getStringCellValue());
		  objLaybyObjects.description1.sendKeys(sh1.getRow(1).getCell(1).getStringCellValue());	  
		  objLaybyObjects.price1.sendKeys(sh1.getRow(1).getCell(2).getStringCellValue());
		  objLaybyObjects.imageUrl1.sendKeys(sh1.getRow(1).getCell(3).getStringCellValue());
		  
		  objLaybyObjects.submit.click();
		
		  objLaybyObjects.Products1.click();
		  
		  int columnCount=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		  
		  WebElement element = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + columnCount + "]/td[1]"));
		  String id = element.getText();
		  
		  WebElement element1 = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + columnCount + "]/td[2]"));
		  String Prodid = element1.getText();
		  
		  WebElement element2 = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + columnCount + "]/td[3]"));
		  String description = element2.getText();
		  
		  WebElement element3 = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + columnCount + "]/td[4]"));
		  String price = element3.getText();
		  
		  if ( sh1.getRow(1).getCell(0).getStringCellValue().contains(Prodid)){
		     htmlToExtent(cName,mName,extLogger,driver, "Product ID" + Prodid +"  ;;;Pass");
		    }
		    else
		    {
		     System.out.print("Verification unsuccessful");
		     htmlToExtent(cName,mName,extLogger,driver, "Product ID : " + Prodid +"  ;;;Fail");
		    }
		  
		  
		  if ( sh1.getRow(1).getCell(1).getStringCellValue().contains(description)){
			     htmlToExtent(cName,mName,extLogger,driver, "Description : " + description +"  ;;;Pass");
			    }
			    else
			    {
			     System.out.print("Verification unsuccessful");
			     htmlToExtent(cName,mName,extLogger,driver, "Description : " + description +"  ;;;Fail");
			    }
		  
		  if ( sh1.getRow(1).getCell(2).getStringCellValue().contains(price)){
			     htmlToExtent(cName,mName,extLogger,driver, "Price : " + price +"  ;;;Pass");
			    }
			    else
			    {
			     System.out.print("Verification unsuccessful");
			     htmlToExtent(cName,mName,extLogger,driver, "Price : " + price +"  ;;;Fail");
			    }
		}
		 
		
	
	@Test(description = "Central Management - Layby Products_Update")
	public void LaybyProducts_Update() throws InterruptedException
	{
			TestStatus status = getTestStatus();
			objLaybyObjects.UserName.sendKeys("1234567");
			objLaybyObjects.Password.sendKeys("test1234");
			objLaybyObjects.Login.click();
			Select drpStore = new Select (driver.findElement (By.id("userStoresDropDown")));
			drpStore.selectByValue("854");
			objLaybyObjects.Continue.click();
			objLaybyObjects.CentralManagement.click();
			objLaybyObjects.ProductConfiguration.click();
			Thread.sleep(1000);
			objLaybyObjects.UpdateProduct.click();
			objLaybyObjects.LaybyTC.clear();
			objLaybyObjects.LaybyTC.sendKeys("Automation - Layby Terms and Conditions Apply");
			objLaybyObjects.UpdateProductButton.click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			System.out.println("Product Updated Successfully");	
			objLaybyObjects.UpdateProduct.click();
			String Input = driver.findElement(By.name("termsAndConditions")).getAttribute("value");
	        if (Input.equals("Automation - Layby Terms and Conditions Apply"))
	        {
	        	System.out.println("Product Updated Successfully");	
	         	htmlToExtent(cName,mName,extLogger,driver, "Update of new product ;;;Pass");
	        } 
	        else 
	        {
	        	System.out.println("Product not Updated Successfully");	
	         	htmlToExtent(cName,mName,extLogger,driver, "Update of new product  ;;;Fail");
	        }
	        objLaybyObjects.Logout.click();
	}
		
			
	@Test(description = "Central Management - Layby Products_FixedFinalisationDate Layby")
	public void LaybyProducts_NewFFDLayby() throws InterruptedException
	{
				TestStatus status = getTestStatus();
				objLaybyObjects.UserName.sendKeys("1234567");
				objLaybyObjects.Password.sendKeys("test1234");
				objLaybyObjects.Login.click();
				Select drpStore = new Select (driver.findElement (By.id("userStoresDropDown")));
				drpStore.selectByValue("854");
				objLaybyObjects.Continue.click();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				 //get current date 
				 Date date = new Date();
				 String date1= dateFormat.format(date);
					objLaybyObjects.CentralManagement.click();
					objLaybyObjects.ProductConfiguration.click();
			objLaybyObjects.AddButton.click();
			Thread.sleep(1000);
			System.out.println("New Product creation page");
			objLaybyObjects.FixedFinalisationDateLayby.click();
			objLaybyObjects.LaybyName.sendKeys("FFD" +date1);
			objLaybyObjects.FixedFinalisationDate.sendKeys(date1);
			objLaybyObjects.LaybyfeeEan.sendKeys("9314223544076");
			objLaybyObjects.LaybyfeeAmount.sendKeys("5");
			objLaybyObjects.CancellationEan.sendKeys("9350763950007");
			objLaybyObjects.CancellationAmount.sendKeys("12");
			objLaybyObjects.MinDeposit.sendKeys("10");
			objLaybyObjects.MinInterimPayment.sendKeys("10");
			objLaybyObjects.ReceiptHeader.sendKeys("Automation");
			objLaybyObjects.MaxExtension.sendKeys("1");
			objLaybyObjects.MaxDeferments.sendKeys("1");
			objLaybyObjects.ScheduleRequiredYes.click();
			objLaybyObjects.PreorderNo.click();
			objLaybyObjects.LaybyStartDate.sendKeys(date1);
			objLaybyObjects.LaybyEndDate.sendKeys(date1);
			objLaybyObjects.LaybyGracePeriod.sendKeys("2");
			objLaybyObjects.LaybyTC.sendKeys("Terms and Conditions Apply");
			Thread.sleep(1000);
			objLaybyObjects.SaveProduct.click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			boolean Text1 = driver.getPageSource().contains("FFD" +date1);
	    if (Text1 == true)
	    {
	     System.out.print("Verification successful");
	  	htmlToExtent(cName,mName,extLogger,driver, "FFD Layby created  ;;;Pass");
	    }
	    else
	    {
	     System.out.print("Verification unsuccessful");
      	htmlToExtent(cName,mName,extLogger,driver, "FFD layby created  ;;;Fail");
	        }
	        objLaybyObjects.Logout.click();
	    }
	    
	
			@Test(description = "Central Management - Layby Products-Preorder")
			public void LaybyProducts_PreorderLayby() throws InterruptedException
			{
				
						TestStatus status = getTestStatus();
						objLaybyObjects.UserName.sendKeys("1234567");
						objLaybyObjects.Password.sendKeys("test1234");
						objLaybyObjects.Login.click();
						Select drpStore = new Select (driver.findElement (By.id("userStoresDropDown")));
						drpStore.selectByValue("854");
						objLaybyObjects.Continue.click();
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						 //get current date 
						 Date date1 = new Date();
						 String date2= dateFormat.format(date1);
							objLaybyObjects.CentralManagement.click();
							objLaybyObjects.ProductConfiguration.click();
		objLaybyObjects.AddButton.click();
		Thread.sleep(1000);
		System.out.println("New Product preorder creation page");
		objLaybyObjects.FixedDurationLayby.click();
		objLaybyObjects.LaybyName.sendKeys("PO" +date1);
		objLaybyObjects.LaybyDuration.sendKeys("3");
		objLaybyObjects.LaybyfeeEan.sendKeys("9314223544076");
		objLaybyObjects.LaybyfeeAmount.sendKeys("5");
		objLaybyObjects.CancellationEan.sendKeys("9350763950007");
		objLaybyObjects.CancellationAmount.sendKeys("12");
		objLaybyObjects.MinDeposit.sendKeys("10");
		objLaybyObjects.MinInterimPayment.sendKeys("10");
		objLaybyObjects.ReceiptHeader.sendKeys("Automation");
		objLaybyObjects.MaxExtension.sendKeys("1");
		objLaybyObjects.MaxDeferments.sendKeys("1");
		objLaybyObjects.ScheduleRequiredYes.click();
		objLaybyObjects.PreorderYes.click();
		objLaybyObjects.LaybyStartDate.sendKeys(date2);
		objLaybyObjects.LaybyEndDate.sendKeys(date2);
		objLaybyObjects.LaybyGracePeriod.sendKeys("2");
		objLaybyObjects.LaybyTC.sendKeys("Terms and Conditions Apply");
		Thread.sleep(1000);
		objLaybyObjects.SaveProduct.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		boolean Text2 = driver.getPageSource().contains("PO" +date1);
	    if (Text2 == true)
	    {
	     System.out.print("Verification successful");
	     htmlToExtent(cName,mName,extLogger,driver, "Preorder layby created  ;;;Pass");
	    }
	    else
	    {
	     System.out.print("Verification unsuccessful");
	     htmlToExtent(cName,mName,extLogger,driver, "Preorder layby created  ;;;Fail");
        }
        objLaybyObjects.Logout.click();
	    }
	    
		


			 

	@BeforeMethod(alwaysRun=true)
	public void setUp(Method m9,ITestContext testcontext) throws IOException, InterruptedException{	
		waitFor(2);
		System.out.println("test1 - beforemethod");
		mName=m9.getName().toString().trim();			
		if(!methodList.contains(m9.getName().toString().trim())){
			methodList.add(m9.getName().toString().trim());
			extLogger = extReport.startTest(m9.getName().toString().trim());
		}
		initializeTestcontext();
		log.info("Loading Testdata for the test case: " + m9.getName().toString());
		data.getTCNameFromChildren(m9.getName().toString().trim());
		if(isFirstTest){
			driver=createDriver(TestContext.getStringProperty("baseURL"), TestContext.getStringProperty("browser"), cName, mName, extLogger,driver);
		}else{

			driver.navigate().refresh();
			TimeUnit.SECONDS.sleep(5);
			driver.navigate().to(TestContext.getStringProperty("baseURL"));
		}
		/*	String title = driver.getCurrentUrl();
			if(title.contains("logginOut"))
			{
				driver.navigate().refresh();
				TimeUnit.SECONDS.sleep(5);
			}else if(title.contains("home")){
				driver.navigate().refresh();
				TimeUnit.SECONDS.sleep(5);
			}else{
				driver.navigate().refresh();
				TimeUnit.SECONDS.sleep(5);
				if(driver.findElements(By.xpath("//*[@class='homeLink']")).size()>0)
				{
					if(driver.findElement(By.xpath("//*[@class='homeLink']")).isDisplayed()){
						WebElement  home = driver.findElement(By.xpath("//*[@class='homeLink']"));
						scrolltoElement(home,driver);
						home.click();
						TimeUnit.SECONDS.sleep(5);
						loginPage.Logout(BigWOpticalsScenarios, BigWOpticalstestname, driver);
						driver.navigate().refresh();
						TimeUnit.SECONDS.sleep(5);}
				}
			}
		}*/
		isFirstTest=false;

		//driver =createDriver(getContext().getStringProperty("baseURL"), getContext().getStringProperty("browser"));
		setDriver(driver);
		testcontext.setAttribute("WebDriver", driver);
		testcontext.setAttribute("Customreports", this.customreport);
		customreport.startTest(m9.getName().toString());
		initializeTestStatus();
		reportPath = new File(getContext().getStringProperty("reportPath"));
		Laybytestname = m9.getName().toString().trim();
		Laybytestdesc = m9.getAnnotation(Test.class).description();
		htmlToExtent(cName,mName,extLogger,driver,"<b><i><h4>Docker run - "+getContext().getStringProperty("isDocketRun")+"</h4></i></b>;;;Info");

		objLaybyObjects= PageFactory.initElements(this.driver,LaybyObjects.class);
		objLaybyPages= PageFactory.initElements(this.driver, LaybyPages.class);
		//objInStoreDisplayPromotionsObjects = PageFactory.initElements(this.driver, InStoreDisplayPromotionsObjects.class);
		BaseObj = PageFactory.initElements(driver, BasePage.class);
		common = PageFactory.initElements(driver, CommonFunctions.class);
		//storeprop = PageFactory.initElements(driver, StoreProperties.class);
	}

	@BeforeClass
	public void loadXMLFile(){	
		//initializeTestcontext();
		System.out.println("test1 - Beforeclass");
		data = new XMLDataReader(log);
		customreport=new CustomExtentReports();
		log.info("Loading data for the class: " );
		data.loadTestDataXML(System.getProperty("user.dir") + "\\TestData\\NGBO\\AdjLogReport.xml");
		customreport.createExtentReport();
		cName=this.getClass().getSimpleName();
		reportPath = new File(TestContext.getStringProperty("reportPath"));			
		extReport = new ExtentReports(TestContext.getStringProperty("reportPath") +"\\"+this.getClass().getSimpleName()+".html");
		classList.add(this.getClass().getSimpleName());
	}



	@AfterClass(alwaysRun=true)
	public void tearDown() throws IOException, ParseException{
		waitFor(1);
		System.out.println("afterclass");
		sceCtMap.put(cName+"_totalCt", methodList.size());
		sceCtMap.put(cName+"_passCt", methodList.size() - extentList.get(cName).size());
		sceCtMap.put(cName+"_failCt", extentList.get(cName).size());
		tcCt.put(this.getClass().getSimpleName().toString(),ADcount);
		extReport.endTest(extLogger);
		extReport.flush();
		removeDriver();
		closeDriver(driver);
		moduleName.put("Modules", LaybyModules);
		waitFor(1);
		int ADArtM=ADcount;
		LaybyMC=""+ADArtM;
	}

	@AfterMethod(alwaysRun=true)
	protected void flushReports(ITestResult result9, Method m9) throws IOException, ParseException {
		System.out.println("AffterMethod");
		waitFor(1);

		extReport.endTest(extLogger);
		extReport.flush();
		try{
			if(result9.getAttribute("isFail").equals("true")&& !isExceptionCaptured){
				htmlToExtent(cName,mName,extLogger,driver,"Iteration terminated due to error;;;INFO");	
				result9.removeAttribute("isFail");
			}}catch(Exception e ){
			}
		customreport.getExtentReport().endTest(customreport.getExtentTest());
		customreport.getExtentReport().flush();
		waitFor(1);
		if(getResultStatusName(result9.getStatus()).equalsIgnoreCase("Fail")|| getResultStatusName(result9.getStatus()).equalsIgnoreCase("Info")|| getResultStatusName(result9.getStatus()).equalsIgnoreCase("Info")){
			int cnt = LaybyPrecount2+1;
			htmlToExtent(cName,mName,extLogger,driver,"<b><i><h4>Completed Status : Iteration - "+ cnt +"</h4></i></b>;;;Warning");
			LaybyPrecount2++;
		}
		if(LaybyPrecount2==reCount || getResultStatusName(result9.getStatus()).equalsIgnoreCase("Pass")){
			LaybyPrecount2=-1;
		}
		waitFor(1);		
	}

}