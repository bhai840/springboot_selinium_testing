package laybymgmt;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class overallcode {

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
	@Test(priority=2)//enter credentials
	public void Useridpassword(){
		driver.findElement(By.id("userName")).sendKeys("1234567");
		driver.findElement(By.id("password")).sendKeys("test1234");
		driver.findElement(By.id("Login")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/validateUser");
	}
	@Test(priority=3)//login to store
	public void Verifystoreselection(){
		driver.findElement(By.id("userStoresDropDown")).sendKeys("0871");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/showLayByHome?usrSelectedStoreId=871");
	}
	@Test(priority=4)//selection of layby managment
	public void Islaybyenabled(){
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Lay-by')]")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/searchLaybyEDR");
	}
	@Test(priority=5)
	public void SearchusingEDR(){
		driver.findElement(By.xpath("//*[@id='searchLaybyEDR']/table/tbody/tr[1]/td[1]/div/font[2]")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/searchLaybyEDR");
	}
	@Test(priority=6)//search using edr no
	public void LbymgmtEDR(){
		driver.findElement(By.id("edrNo")).sendKeys("9361006979297");
		driver.findElement(By.xpath("//*[@id='searchLaybyEDR']/table/tbody/tr[6]/td/input")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/getSearchResultsByEDR");		
	}

	@Test(priority=7)//in search results validating update option 
	public void LbymgmtEDR_update(){
		driver.findElement(By.xpath("//*[@id='searchResults']/div[2]/table/tbody/tr[2]/td[3]/input[1]")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/showupdatecustomer?source=customerid&custId=28008");
	}
	@Test(priority=8)//validation of reset button inside update
	public void LbymgmtEDR_update_reset(){
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("Reset");
		driver.findElement(By.xpath("//*[@id='resetForm']")).click();
		driver.switchTo().alert().accept();
	}
	@Test(priority=9)//validation of update button inside update
	public void LbymgmtEDR_update_update(){
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("update");
		driver.findElement(By.xpath("//*[@id='submitcustomerdetails']/div[2]/input[1]")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		//Robot Class to Hit Enter Key
		try{
			//Creating object for Robot Class
			Robot r = new Robot();
			//Presses the Enter Key
			r.keyPress(KeyEvent.VK_ENTER); 

			//Releases the Enter Key
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).clear();
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("Deep");
		driver.findElement(By.xpath("//*[@id='submitcustomerdetails']/div[2]/input[1]")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		//Robot Class to Hit Enter Key
		try{
			//Creating object for Robot Class
			Robot r = new Robot();
			//Presses the Enter Key
			r.keyPress(KeyEvent.VK_ENTER); 

			//Releases the Enter Key
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/updatecustomerdata");
	}
	@Test(priority=10)//validation of cancel button inside update
	public void LbymgmtEDR_update_Cancel(){
		driver.findElement(By.id("cancel")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/getSearchResultsByEDRCust?custEdr=9361006979297&custId=28008");
		driver.navigate().back();
	}
	@Test(priority=11)//validation of Layby enquiry button inside update
	public void LbymgmtEDR_update_Laybyenquiry(){
		driver.findElement(By.xpath("//*[@id='searchResults']/div[2]/table/tbody/tr[2]/td[3]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='laybyEnquiry']")).click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/laybyenquiry?custId=28008");	
		JavascriptExecutor js = (JavascriptExecutor) driver ;//scroll down the entire page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//*[@id='cancel']")).click();
	}
	@Test(priority=12)//validation of Layby enquiry
	public void LbymgmtEDR_Laybyenquiry(){
		driver.findElement(By.xpath("//*[@id='laybyEnquiry']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/laybyenquiry?custId=28008");
		JavascriptExecutor js = (JavascriptExecutor) driver ;//scroll down the entire page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//*[@id='cancel']")).click();
		driver.findElement(By.xpath("//*[@id='searchResults']/a")).click();
	}

	@Test(priority=13)//**************LBYMgmt_Customer_details_page_validation*************
	public void LbymgmtCustdet(){
		driver.findElement(By.xpath("//*[@id='searchLaybyEDR']/table/tbody/tr[1]/td[1]/div/font[3]/input")).click();
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("deep");
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("kumar");
		driver.findElement(By.xpath("//*[@id='mobilePhoneNo']")).sendKeys("9991");
		driver.findElement(By.xpath("//*[@id='searchLaybyCustomerDet']/table/tbody/tr[16]/td/input")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/getSearchResultsByCustomerDet");
	}
	//*************************************************************************
	@Test(priority=14)//in search results validating update option 
	public void LbymgmtCustdet_update(){
		driver.findElement(By.xpath("//*[@id='searchResults']/div[2]/table/tbody/tr[2]/td[3]/input[1]")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/showupdatecustomer?source=customerid&custId=28008");
	}
	@Test(priority=15)//validation of reset button inside update
	public void LbymgmtCustdet_update_reset(){
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("Reset");
		driver.findElement(By.xpath("//*[@id='resetForm']")).click();
		driver.switchTo().alert().accept();
	}
	@Test(priority=16)//validation of update button inside update
	public void LbymgmtCustdet_update_update(){
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("update");
		driver.findElement(By.xpath("//*[@id='submitcustomerdetails']/div[2]/input[1]")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		//Robot Class to Hit Enter Key
		try{
			//Creating object for Robot Class
			Robot r = new Robot();
			//Presses the Enter Key
			r.keyPress(KeyEvent.VK_ENTER); 

			//Releases the Enter Key
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).clear();
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("Deep");
		driver.findElement(By.xpath("//*[@id='submitcustomerdetails']/div[2]/input[1]")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		//Robot Class to Hit Enter Key
		try{
			//Creating object for Robot Class
			Robot r = new Robot();
			//Presses the Enter Key
			r.keyPress(KeyEvent.VK_ENTER); 

			//Releases the Enter Key
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/updatecustomerdata");
	}
	@Test(priority=17)//validation of cancel button inside update
	public void LbymgmtCustdet_update_Cancel(){
		driver.findElement(By.id("cancel")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/getSearchResultsByEDRCust?custEdr=9361006979297&custId=28008");
		driver.navigate().back();
	}
	@Test(priority=18)//validation of Layby enquiry button inside update
	public void LbymgmtCustdet_update_Laybyenquiry(){
		driver.findElement(By.xpath("//*[@id='searchResults']/div[2]/table/tbody/tr[2]/td[3]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='laybyEnquiry']")).click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/laybyenquiry?custId=28008");	
		JavascriptExecutor js = (JavascriptExecutor) driver ;//scroll down the entire page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//*[@id='cancel']")).click();
	}
	@Test(priority=19)//validation of Layby enquiry 
	public void LbymgmtCustdet_Laybyenquiry(){
		driver.findElement(By.xpath("//*[@id='laybyEnquiry']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/laybyenquiry?custId=28008");
		JavascriptExecutor js = (JavascriptExecutor) driver ;//scroll down the entire page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//*[@id='cancel']")).click();
		driver.findElement(By.xpath("//*[@id='searchResults']/a")).click();
	}
	@Test(priority=20)//Validation of Layby_Enquiry 
	public void Lbymgmt_Lbyid(){
		driver.findElement(By.xpath("//*[@id='searchLaybyCustomerDet']/table/tbody/tr[1]/td[1]/div/font[4]/input")).click();
		driver.findElement(By.xpath("//*[@id='laybyid']")).sendKeys("26087100430187");
		driver.findElement(By.xpath("//*[@id='searchLaybyLaybyid']/table/tbody/tr[7]/td/input")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/viewLaybyDetails?source=laybyid");
		driver.findElement(By.xpath("//*[@id='updateCustomer']")).click();
	}
	@Test(priority=21)//Validation of reset button inside update
	public void Lbymgmt_Lbyid_update_reset(){
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("Reset");
		driver.findElement(By.xpath("//*[@id='resetForm']")).click();
		driver.switchTo().alert().accept();
	}

	@Test(priority=22)//Validation of update button inside update
	public void Lbymgmt_Lbyid_update_update(){
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("update");
		driver.findElement(By.xpath("//*[@id='submitcustomerdetails']/div[2]/input[1]")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		//Robot Class to Hit Enter Key
		try{
			//Creating object for Robot Class
			Robot r = new Robot();
			//Presses the Enter Key
			r.keyPress(KeyEvent.VK_ENTER); 

			//Releases the Enter Key
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).clear();
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys("Deep");
		driver.findElement(By.xpath("//*[@id='submitcustomerdetails']/div[2]/input[1]")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		//Robot Class to Hit Enter Key
		try{
			//Creating object for Robot Class
			Robot r = new Robot();
			//Presses the Enter Key
			r.keyPress(KeyEvent.VK_ENTER); 

			//Releases the Enter Key
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/updatecustomerdata");
	}
	@Test(priority=23)//validation of cancel button inside update
	public void Lbymgmt_Lbyid_update_Cancel(){
		driver.findElement(By.xpath("//*[@id='cancel']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/viewLaybyDetails?laybyId=26087100430187");
		driver.navigate().back();
	}
	@Test(priority=24)//validation of Layby enquiry button inside update
	public void Lbymgmt_Lbyid_update_Laybyenquiry(){
		//driver.findElement(By.xpath("//*[@id='searchResults']/div[2]/table/tbody/tr[2]/td[3]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='updateCustomer']")).click();
		driver.findElement(By.xpath("//*[@id='laybyEnquiry']")).click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getCurrentUrl(),"http://ncdllbaasd0001.wowcorp.com.au:8180/layby/laybyenquiry?custId=28008");	
		JavascriptExecutor js = (JavascriptExecutor) driver ;//scroll down the entire page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//*[@id='cancel']")).click();
	}
}


