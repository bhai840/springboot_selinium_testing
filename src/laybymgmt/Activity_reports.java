package laybymgmt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Activity_reports{
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
	@Test(priority=2)//Login to store
	public void Verifystoreselection(){
		driver.findElement(By.id("userStoresDropDown")).sendKeys("0854");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/showLayByHome?usrSelectedStoreId=854");
	}
	@Test(priority=3)//Validation of Layby enquiry button inside update
	public void Reporting_ActivityReports(){
		driver.findElement(By.xpath("//span[text()='Reporting']")).click();
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[4]/ul/li[2]/a")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/activityReport");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@Test(priority=4)//
	public void Reporting_ActivityReports_ItemsReport_StoreReport_AricleNo() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='activity']/table/tbody/tr[1]/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='artRadio']")).click();
		driver.findElement(By.xpath("//*[@id='resetArt']")).sendKeys("891713");
		driver.findElement(By.xpath("//*[@id='activityComponent']/table[2]/tbody/tr[4]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/previewItemReport?isCentral=no&articleNo891713");
		driver.navigate().back();
	}
	@Test(priority=5)//
	public void Reporting_ActivityReports_ItemsReport_StoreReport_EanNo() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='eanRadio']")).click();
		driver.findElement(By.xpath("//*[@id='reset']")).sendKeys("9316203000442");
		driver.findElement(By.xpath("//*[@id='activityComponent']/table[2]/tbody/tr[4]/td[2]/input")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/previewItemReport?isCentral=no&ean9316203000442");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
}
	@Test(priority=6)//
	public void Reporting_ActivityReports_ItemsReport_CentralReport_AricleNo() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='activity']/table/tbody/tr[1]/td[3]/input")).click();
		driver.findElement(By.xpath("//*[@id='artRadio']")).click();
		driver.findElement(By.xpath("//*[@id='resetArt']")).sendKeys("891713");
		driver.findElement(By.xpath("//*[@id='activityComponent']/table[2]/tbody/tr[4]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/previewItemReport?isCentral=yes&articleNo891713");
		driver.navigate().back();
	}
	@Test(priority=7)//
	public void Reporting_ActivityReports_ItemsReport_CentralReport_EanNo() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='eanRadio']")).click();
		driver.findElement(By.xpath("//*[@id='reset']")).sendKeys("9316203000442");
		driver.findElement(By.xpath("//*[@id='activityComponent']/table[2]/tbody/tr[4]/td[2]/input")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/previewItemReport?isCentral=yes&ean9316203000442");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
}
	@Test(priority=8)//
	public void Reporting_ActivityReports_StatusReport_StoreReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='activity']/table/tbody/tr[2]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/statusReport?isCentral=no");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
}
	@Test(priority=9)//
	public void Reporting_ActivityReports_PendingLbyCancellationsReport_StoreReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='activity']/table/tbody/tr[3]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/pendingLaybyCancelReport?isCentral=no");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
}
	@Test(priority=10)//
	public void Reporting_ActivityReports_PendingLbyCancellationsReport_CentralReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='activity']/table/tbody/tr[3]/td[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/pendingLaybyCancelReport?isCentral=yes");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
	
}
	@Test(priority=11)//
	public void Reporting_ActivityReports_LocationsReport_StoreReport() throws InterruptedException{	
		driver.findElement(By.xpath("//*[@id='activity']/table/tbody/tr[4]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/locationsReport?isCentral=no");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().back();
}
}


