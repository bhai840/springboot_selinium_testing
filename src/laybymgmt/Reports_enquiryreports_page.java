package laybymgmt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Reports_enquiryreports_page {

	public WebDriver driver;
	@BeforeTest
	public void Launchbrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get(	"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/#no-back-button");
	}
	@AfterTest
	public void Closebrowser(){
		System.out.println("End of test case");
		driver.close();
	}
	@Test(priority=2)//Enter credentials
	public void Useridpassword(){
		driver.findElement(By.id("userName")).sendKeys("1234567");
		driver.findElement(By.id("password")).sendKeys("test1234");
		driver.findElement(By.id("Login")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/validateUser");
	}
	@Test(priority=3)//Login to store
	public void Verifystoreselection(){
		driver.findElement(By.id("userStoresDropDown")).sendKeys("0854");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/showLayByHome?usrSelectedStoreId=854");
	}
	@Test(priority=4)//Validation of Layby enquiry button inside update
	public void Reporting_EnquiryReports(){
		driver.findElement(By.xpath("//span[text()='Reporting']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Enquiry')]")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/enquiryReports");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@Test(priority=5)//Validation of Layby enquiry button inside update
	public void Reporting_EnquiryReports_Laybydate_storereport() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='storeReport']")).click();
		driver.findElement(By.id("crStartDate")).sendKeys("01/09/2017");
		driver.findElement(By.id("crEndDate")).sendKeys("01/09/2019");
		driver.findElement(By.xpath("//*[@id='dateReportSearchForm']/table[2]/tbody/tr[4]/td[3]/font/input")).click();			
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/creationDateReport?isCentral=no");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=6)//validation of Layby enquiry button inside update
	public void Reporting_EnquiryReports_Laybydate_Centralreport(){
		driver.findElement(By.xpath("//*[@id='centralReport']")).click();
		driver.findElement(By.id("crStartDate")).sendKeys("01/02/2018");
		driver.findElement(By.id("crEndDate")).sendKeys("01/02/2019");
		driver.findElement(By.xpath("//*[@id='dateReportSearchForm']/table[2]/tbody/tr[4]/td[3]/font/input")).click();	
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/creationDateReport?isCentral=yes");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=7)//value report - store report
	public void Reporting_EnquiryReports_value_StoreReport(){
		driver.findElement(By.xpath("//*[@id='command']/table/tbody/tr[2]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		driver.findElement(By.id("reportEndDate")).sendKeys("01/02/2019");
		driver.findElement(By.xpath("//*[@id='valueReportSearchForm']/table[2]/tbody/tr[3]/td[3]/font/input")).click();	      
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/valueReport?isCentral=no");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=8)//Value Report **central report**
	public void Reporting_EnquiryReports_value_CentralReport(){
		driver.findElement(By.xpath("//*[@id='command']/table/tbody/tr[2]/td[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		driver.findElement(By.id("reportEndDate")).sendKeys("01/02/2019");
		driver.findElement(By.xpath("//*[@id='valueReportSearchForm']/table[2]/tbody/tr[3]/td[3]/font/input")).click();	      
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/valueReport?isCentral=yes");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=9)//Outstanding balance enquiry report(store report)
	public void Reporting_EnquiryReports_OutstandingBalance_StoreReport(){
		driver.findElement(By.xpath("//*[@id='command']/table/tbody/tr[3]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		driver.findElement(By.id("outstandingBalance")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id='command']/table[2]/tbody/tr[5]/td/font/input")).click();	      
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/previewOutstandingBalanceReport?isCentral=no&previewType=outstandingBalance&value=10");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=10)//outstanding balance enquiry report(central report)
	public void Reporting_EnquiryReports_OutstandingBalance_CentralReport(){
		driver.findElement(By.xpath("//*[@id='command']/table/tbody/tr[3]/td[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		driver.findElement(By.id("outstandingBalance")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id='command']/table[2]/tbody/tr[5]/td/font/input")).click();	      
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/previewOutstandingBalanceReport?isCentral=yes&previewType=outstandingBalance&value=10");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=11)//Required Lay-by Stock Report(store report)
	public void Reporting_EnquiryReports_RLbyStocktakeReport_StoreReport(){
		driver.findElement(By.xpath("//*[@id='command']/table/tbody/tr[4]/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='ALL']")).click();
		driver.findElement(By.xpath("//*[@id='AS']")).click();
		driver.findElement(By.xpath("//*[@id='enquiryComponent']/input[1]")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/overPreOrderReport");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=12)//Required Lay-by Stock Report(central report)
	public void Reporting_EnquiryReports_RLbyStocktakeReport_CentralReport(){
		driver.findElement(By.xpath("//*[@id='command']/table/tbody/tr[4]/td[3]/input")).click();
		driver.findElement(By.xpath("//*[@id='ALL']")).click();
		driver.findElement(By.xpath("//*[@id='AS']")).click();
		driver.findElement(By.xpath(" //*[@id='SU']")).click();
		driver.findElement(By.xpath("//*[@id='enquiryComponent']/input[1]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/overPreOrderReport");
		driver.navigate().back();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}}
	
	/*List<List<Object>> test = getValuesFromTable(driver.findElements(By.xpath("//*[@id='dateReportSearchForm']/div[3]/table/tbody/tr")));
	int i=0;
	float layByValue=0;
	while(i<test.size()-1){
		layByValue = Float.parseFloat(test.get(i).get(11).toString().replace("$", "").replace(",",""))+layByValue;
		i++;
	}

	String total = "//*[@id='dateReportSearchForm']/div[3]/table/tbody/tr[dynamic]/td[11]";
	String layByValueAppln = prepareWebElementWithDynamicXpathWithInt(total, test.size(), driver).getText();

	if(layByValue == Float.parseFloat(layByValueAppln.replace("$", "").replace(",",""))){
	System.out.println("Value matches="+layByValue+" "+layByValueAppln);	
	}
	else{
		System.out.println("Value Mismatches="+layByValue+" "+layByValueAppln);
	}
	driver.navigate().back();
	driver.navigate().back();
}
****************************

	public List<List<Object>> getValuesFromTable(List<WebElement> objectTable) { 
		List<List<Object>> tableValues = new ArrayList<List<Object>>();
		List<Object> row = null;
		List<WebElement> tr_collection = objectTable;
		int row_Count = objectTable.size();
		System.out.println("Number Of Rows = " + row_Count);
		int row_num,col_num;
		row_num=1;
		for(WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
			System.out.println("NUMBER OF COLUMNS="+td_collection.size());
			col_num=0;
			row = new ArrayList<>(td_collection.size());
			for(WebElement tdElement : td_collection)
			{
				//System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
				row.add(tdElement.getText());	            	
				col_num++;
			}

			tableValues.add(row);

			row_num++;
		}

		return tableValues;
	}

	public WebElement prepareWebElementWithDynamicXpathWithInt(String xpathValue, int i,WebDriver driver) { //meenu
		return driver.findElement(By.xpath(xpathValue.replace("dynamic", ""+i)));		
	}
}*/	


