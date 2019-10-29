package laybymgmt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FianancialReports {

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
	@Test(priority=1)//Enter credentials
	public void Useridpassword(){
		driver.findElement(By.id("userName")).sendKeys("1234567");
		driver.findElement(By.id("password")).sendKeys("test1234");
		driver.findElement(By.id("Login")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/validateUser");
	}
	@Test(priority=3)//Login to store
	public void Verifystoreselection(){
		driver.findElement(By.id("userStoresDropDown")).sendKeys("0871");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/showLayByHome?usrSelectedStoreId=871");
	}
	@Test(priority=4)
	public void FinancialReports(){
		driver.findElement(By.xpath("//span[text()='Reporting']")).click();
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[4]/ul/li[5]/a")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/financialReports");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}	
	@Test(priority=5)
	public void FinancialReports_UnclaimedCustomerDepositReport_CentralReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='financeRpt']/table/tbody/tr[1]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/unclaimedCustomerDepositRpt");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
	}
	@Test(priority=6)
	public void FinancialReports_CancellationSummaryReport_CentralReport_Summary_all_combination() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='financeRpt']/table/tbody/tr[2]/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='fromDate']")).sendKeys("01/09/2017");
		driver.findElement(By.xpath("//*[@id='toDate']")).sendKeys("01/09/2019");
		driver.findElement(By.xpath("//*[@id='SU']")).click();
		driver.findElement(By.xpath("//*[@id='ALL']")).click();
		driver.findElement(By.xpath("//*[@id='cancellationSummaryReport']/div[4]/input")).click();			
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/generateCancellationSummaryPreview?from=01/09/2017&to=01/09/2019");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
	}
	@Test(priority=7)
	public void FinancialReports_CancellationSummaryReport_CentralReport_Detail_All_combination() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='fromDate']")).sendKeys("01/09/2017");
		driver.findElement(By.xpath("//*[@id='toDate']")).sendKeys("01/09/2019");
		driver.findElement(By.xpath("//*[@id='DE']")).click();
		driver.findElement(By.xpath("//*[@id='ALL']")).click();
		driver.findElement(By.xpath("//*[@id='cancellationSummaryReport']/div[4]/input")).click();	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/generateCancellationSummaryPreview?from=01/09/2017&to=01/09/2019");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
	}
	@Test(priority=8)
	public void FinancialReports_CancellationSummaryReport_CentralReport_Summary_Speicficstore_combination() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='fromDate']")).sendKeys("01/09/2017");
		driver.findElement(By.xpath("//*[@id='toDate']")).sendKeys("01/09/2019");
		driver.findElement(By.xpath("//*[@id='SU']")).click();
		driver.findElement(By.xpath("//*[@id='SINGLE']")).click();
		driver.findElement(By.xpath("//*[@id='userStoresDropDown']")).sendKeys("0871");
		driver.findElement(By.xpath("//*[@id='cancellationSummaryReport']/div[4]/input")).click();	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/generateCancellationSummaryPreview?from=01/09/2017&to=01/09/2019");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
	}
	@Test(priority=9)
	public void FinancialReports_CancellationSummaryReport_CentralReport_Detail_Speicficstore_combination() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='fromDate']")).sendKeys("01/09/2017");
		driver.findElement(By.xpath("//*[@id='toDate']")).sendKeys("01/09/2019");
		driver.findElement(By.xpath("//*[@id='DE']")).click();
		driver.findElement(By.xpath("//*[@id='SINGLE']")).click();
		driver.findElement(By.xpath("//*[@id='userStoresDropDown']")).sendKeys("0871");
		driver.findElement(By.xpath("//*[@id='cancellationSummaryReport']/div[4]/input")).click();	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/generateCancellationSummaryPreview?from=01/09/2017&to=01/09/2019");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
	}
	@Test(priority=10)
	public void FinancialReports_SalesReport_CentralReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='financeRpt']/table/tbody/tr[3]/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='startDate']")).sendKeys("01/09/2017");
		driver.findElement(By.xpath("//*[@id='endDate']")).sendKeys("01/09/2019");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='saleComponent']/table[2]/tbody/tr[3]/td/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/previewSaleReport?Sdate=01/09/2017&Edate=01/09/2019");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
}
	@Test(priority=11)
	public void FinancialReports_DepartmentsReport_CentralReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='financeRpt']/table/tbody/tr[4]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/departmentsRpt");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
}
	@Test(priority=12)
	public void FinancialReports_PaymentReconciliationReport_CentralReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='financeRpt']/table/tbody/tr[5]/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='startDate']")).sendKeys("01/09/2017");
		driver.findElement(By.xpath("//*[@id='endDate']")).sendKeys("01/09/2019");
		driver.findElement(By.xpath("//*[@id='paymentReconciliationComponent']/table[2]/tbody/tr[3]/td/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/previewPaymentReconciliationReport");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
}
}
	
