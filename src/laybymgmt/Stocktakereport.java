package laybymgmt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Stocktakereport {
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
	public void Reporting_StocktakeReport(){
		driver.findElement(By.xpath("//span[text()='Reporting']")).click();
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[4]/ul/li[4]/a")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/stocktakeReport");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}	
	@Test(priority=5)//
	public void Reporting_StocktakeReport_StoreReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='storeReport']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/stocktakeExceptionReport?");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
	}
}
