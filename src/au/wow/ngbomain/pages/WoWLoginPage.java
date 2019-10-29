/**
 * This class represents the login page of stores central application
 */

package au.wow.ngbomain.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.SkipException;

import au.wow.ngbo.utils.BasePage;

import com.google.common.collect.Multimap;
import com.relevantcodes.extentreports.ExtentTest;


public class WoWLoginPage extends BasePage{
		
	@FindBy(name = "username")
	private WebElement txtUserName;
	
	@FindBy(name = "password")
	private WebElement txtPassword;
	
	@FindBy(id = "signIn")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id='signIn']")
	private WebElement login;
	
//	textbox verifyN
	@FindBy(xpath = "//input[contains(@class,'verifyNm')]")
	private WebElement txtStore;
	
	@FindBy(xpath = "//label[contains(@class,'verify')]")
	private WebElement btnVerify;
	

	@FindBy(xpath="/html/body/div[9]/div[1]/button")
	private WebElement SecurityQusClose;
	
	@FindBy(id = "yes")
	private WebElement btnYes;
	
	@FindBy(xpath = "//a[contains(@class,'globalLinkAccountName')]")
	private WebElement gblMenuItem;
	
	@FindBy(linkText = "Logout")
	private WebElement lnkLogout;
	
	@FindBy(id = "dialog-passwordReminder")
	private WebElement notificationPopup;
	
	@FindBy(xpath = "//label[text()='No']")
	private WebElement btnNo;
	
	@FindBy(xpath ="(//*[contains(text(),'Proceed')])[1]")
	public WebElement proceed;
	
	@FindBy(xpath ="//*[@id='ipaddress']")
	public WebElement storeCheck;
	
	public static WebDriver driver;
	
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}
	
	
	public void validatePage(WebDriver driver){
		setDriver(driver);
		waitForPageToLoad(driver);
		waitForPage("Bailey Nelson - Book an Eye Test",driver);
		getLogger().info("Title of the page: " + driver.getTitle());
		if(driver.getTitle().trim().contentEquals("Bailey Nelson - Book an Eye Test")){
			getLogger().info("Application is launched successfully");
			
		}else
			throw new SkipException("Error in launching the application");
	}
	
	/**
	 * Enters the username and password 
	 */
	public void enterUserCredentials(WebDriver driver){
		validatePage(driver);
		setDriver(driver);
		driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username"));
		enterText(txtUserName, getContext().getStringProperty("username"),driver);

		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("password"),driver);
		setDriver(driver);
		click(btnLogin);
	}

	public void enterUserCredentialsRoutines(WebDriver driver){
		validatePage(driver);
		setDriver(driver);
		driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("usernameR"));
		enterText(txtUserName, getContext().getStringProperty("usernameR"),driver);

		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordR"),driver);
		setDriver(driver);
		click(btnLogin);
	}
	
	public void enterUserCredentialsample(WebDriver driver,String un,String pwd){
		validatePage(driver);
		setDriver(driver);
		driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username"));
		enterText(txtUserName, un,driver);
		waitFor(1);
		enterText(txtPassword, pwd,driver);
		setDriver(driver);
		click(btnLogin);
	}
	
	/*public InstoreCompetitionPage navToInstoreCompPromotiontester90(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreCompetitionPage.class);
	}
	
	public InstoreCompetitionPage1 navToInstoreCompPromotiontester901(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreCompetitionPage1.class);
	}
	
	public void enterUserCredentialsSTM(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for Stock Take Manager"));
		enterText(txtUserName, getContext().getStringProperty("usernameSTM"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordSTM"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}	
	
	public void enterUserCredentialsSTTM(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for Stock Take Team Member"));
		enterText(txtUserName, getContext().getStringProperty("usernameSTTM"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordSTTM"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}	
	
	public void enterUserCredentialsITUAdmin(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for IT User Admin"));
		enterText(txtUserName, getContext().getStringProperty("usernameITUA"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordITUA"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}	
	
	public void enterUserCredentialsDM(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for Department manager"));
		enterText(txtUserName, getContext().getStringProperty("usernameDM"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordDM"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public InstoreOMAPage navToInstoreOMAPromotiontester90(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreOMAPage.class);
	}
	
	
	public InstoreOMAPage1 navToInstoreOMAPromotiontester901(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreOMAPage1.class);
	}
	
	
	
	public InstoreOMLPage navToInstoreOMLPromotiontester90(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreOMLPage.class);
	}
	
	public InstoreOMSPage navToInstoreOMSPromotiontester90(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreOMSPage.class);
	}
	
	public void tester90Login(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return;
	}
	
	public void BRLogin(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return;
	}
	
	public InstoreClearancePage navToInstorePromotionSTM(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreClearancePage.class);
	}
	
	
 In-store promotions Page for Department Manager 
	
	public InstoreClearancePage1 navToInstorePromotionDM1(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage1.class);
	}
	
 In-store promotions Page for Team Member 
	
	public InstoreClearancePage1 navToInstorePromotionTM1(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage1.class);
	}
	
	
 In-store promotions Page for Customer Assistance 
	
	public InstoreClearancePage1 navToInstorePromotionCA1(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage1.class);
	}
	
	
 In-store promotions Page for Office Assistance 
	
	public InstoreClearancePage1 navToInstorePromotionOA1(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage1.class);
	}
	
 In-store promotions Page for Office Supervisor
	
	public InstoreClearancePage1 navToInstorePromotionOS1(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage1.class);
	}
	
 In-store promotions Page for Store Manager 
	
	public InstoreClearancePage1 navToInstorePromotionSM1(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage1.class);
	}
	
	public InstoreClearancePage1 navToInstorePromotionSTM1(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreClearancePage1.class);
	}
	
	public InstoreClearancePage1 navToInstorePromotiontester901(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreClearancePage1.class);
	}
	
	
 In-store promotions Page for Department Manager 
	
	public InstoreClearancePage navToInstorePromotionDM(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage.class);
	}
	
 In-store promotions Page for Team Member 
	
	public InstoreClearancePage navToInstorePromotionTM(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage.class);
	}
	
	
 In-store promotions Page for Customer Assistance 
	
	public InstoreClearancePage navToInstorePromotionCA(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage.class);
	}
	
	
 In-store promotions Page for Office Assistance 
	
	public InstoreClearancePage navToInstorePromotionOA(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage.class);
	}
	
 In-store promotions Page for Office Supervisor
	
	public InstoreClearancePage navToInstorePromotionOS(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage.class);
	}
	
 In-store promotions Page for Store Manager 
	
	public InstoreClearancePage navToInstorePromotionSM(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage.class);
	}
	
	public InstoreClearancePage navToInstorePromotiontester90(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreClearancePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndType(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeDM(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeOA(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeCA(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	
	public PromotionEndTypePage navToPromoEndTypeTM(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeServiceDesk(String storenum,WebDriver driver){
		enterUserCredentialsSDesk(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeServiceCash(String storenum,WebDriver driver){
		enterUserCredentialsSCash(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeBR(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeOS(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeSM(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeSSA(String storenum,WebDriver driver){
		enterUserCredentialsSSA(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeITS1(String storenum,WebDriver driver){
		enterUserCredentialsITS1(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeReport(String storenum,WebDriver driver){
		enterUserCredentialsReport(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeITS2(String storenum,WebDriver driver){
		enterUserCredentialsITS2(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeSS(String storenum,WebDriver driver){
		enterUserCredentialsSS(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeSTM(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeSTTM(String storenum,WebDriver driver){
		enterUserCredentialsSTTM(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeITUserAdmin(String storenum,WebDriver driver){
		enterUserCredentialsITUAdmin(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}
	
	public PromotionEndTypePage navToPromoEndTypeRO(String storenum,WebDriver driver){
		enterUserCredentialsRO(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(PromotionEndTypePage.class);
	}

	public void enterUserCredentialsTM(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for Team Member"));
		enterText(txtUserName, getContext().getStringProperty("usernameTM"),driver);

		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordTM"),driver);
        setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsSDesk(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for Service Desk Assistant"));
		enterText(txtUserName, getContext().getStringProperty("usernameSDesk"),driver);

		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordSDesk"),driver);
        setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsSCash(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for Service Cashier"));
		enterText(txtUserName, getContext().getStringProperty("usernameSCash"),driver);

		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordSCash"),driver);
        setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsCA(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for Customer Assistance"));
		enterText(txtUserName, getContext().getStringProperty("usernameCA"),driver);

		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordCA"),driver);
     setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsOA(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username for Office Assistance"));
		enterText(txtUserName, getContext().getStringProperty("usernameOA"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordOA"),driver);

		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsOS(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for Office Supervisor"));
		enterText(txtUserName, getContext().getStringProperty("usernameOS"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordOS"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsSM(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for Store manager"));
		enterText(txtUserName, getContext().getStringProperty("usernameSM"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordSM"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsSSA(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for supervsior"));
		enterText(txtUserName, getContext().getStringProperty("usernameSSA"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordSSA"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsITS1(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for IT Support 1"));
		enterText(txtUserName, getContext().getStringProperty("usernameITS1"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordITS1"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsReport(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for Reporting User"));
		enterText(txtUserName, getContext().getStringProperty("usernameReport"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordReport"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsITS2(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for IT SUpport level 2"));
		enterText(txtUserName, getContext().getStringProperty("usernameITS2"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordITS2"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsSS(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for Store Support"));
		enterText(txtUserName, getContext().getStringProperty("usernameSS"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordSS"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsRO(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for Read Only User"));
		enterText(txtUserName, getContext().getStringProperty("usernameRO"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordRO"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	public void enterUserCredentialsBR(WebDriver driver){
		validatePage(driver);
		//driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("username for Business Review"));
		enterText(txtUserName, getContext().getStringProperty("usernameBR"),driver);
		setDriver(driver);
		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordBR"),driver);
		setDriver(driver);
		btnLogin.click();
		//SecurityQusClose.click();
			
	}
	
	
	public InstoreCompetitionPage1 navToInstorePromotionDMComp1(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage1.class);
	}
	
	public InstoreCompetitionPage1 navToInstorePromotionTMComp1(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage1.class);
	}
	
	public InstoreCompetitionPage1 navToInstorePromotionOAComp1(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage1.class);
	}
	

	public InstoreCompetitionPage1 navToInstorePromotionCAComp1(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage1.class);
	}
	
	public InstoreCompetitionPage1 navToInstorePromotionSMComp1(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage1.class);
	}
	
	public InstoreCompetitionPage navToInstorePromotionSTMComp(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreCompetitionPage.class);
	}
	

	public InstoreCompetitionPage1 navToInstorePromotionBRComp1(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage1.class);
	}
	
	public InstoreCompetitionPage navToInstorePromotionDMComp(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage.class);
	}
	
	public InstoreCompetitionPage navToInstorePromotionTMComp(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage.class);
	}
	
	public InstoreCompetitionPage navToInstorePromotionOAComp(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage.class);
	}
	

	public InstoreCompetitionPage navToInstorePromotionCAComp(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage.class);
	}
	
	public InstoreCompetitionPage navToInstorePromotionSMComp(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage.class);
	}
	
	public InstoreCompetitionPage1 navToInstorePromotionSTMComp1(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreCompetitionPage1.class);
	}
	

	public InstoreCompetitionPage navToInstorePromotionBRComp(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage.class);
	}
	

	//--------------------------------------------------------------
	public InstoreOMAPage navToInstorePromotionDMOMA(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage.class);
	}
	
	public InstoreOMAPage navToInstorePromotionTMOMA(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage.class);
	}
	
	public InstoreOMAPage navToInstorePromotionCAOMA(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage.class);
	}
	
	public InstoreOMAPage navToInstorePromotionOAOMA(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage.class);
	}
	
	public InstoreOMAPage navToInstorePromotionOSOMA(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage.class);
	}
	
	public InstoreOMAPage navToInstorePromotionSMOMA(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage.class);
	}
	
	public InstoreOMAPage navToInstorePromotionSTMOMA(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreOMAPage.class);
	}
	

	public InstoreOMAPage navToInstorePromotionBROMA(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage.class);
	}
	
	public InstoreOMAPage1 navToInstorePromotionDMOMA1(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage1.class);
	}
	
	public InstoreOMAPage1 navToInstorePromotionTMOMA1(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage1.class);
	}
	
	public InstoreOMAPage1 navToInstorePromotionCAOMA1(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage1.class);
	}
	
	public InstoreOMAPage1 navToInstorePromotionOAOMA1(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage1.class);
	}
	
	public InstoreOMAPage1 navToInstorePromotionOSOMA1(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage1.class);
	}
	
	public InstoreOMAPage1 navToInstorePromotionSMOMA1(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage1.class);
	}
	
	public InstoreOMAPage1 navToInstorePromotionSTMOMA1(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreOMAPage1.class);
	}
	

	public InstoreOMAPage1 navToInstorePromotionBROMA1(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMAPage1.class);
	}
	
	//----------------------Display------------------------
	public InstoreDisplayPromoPage navToInstoreDisplayPromo(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreDisplayPromoPage.class);
	}
	
	public InstoreDisplayPromoPage navToInstoreDisplayPromotiontester90(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreDisplayPromoPage.class);
	}
	
	public InstoreDisplayPromoPage navToInstorePromotionDMDisplay(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreDisplayPromoPage.class);
	}
	
	public InstoreDisplayPromoPage navToInstorePromotionTMDisplay(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreDisplayPromoPage.class);
	}
	
	public InstoreDisplayPromoPage navToInstorePromotionCADisplay(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreDisplayPromoPage.class);
	}
	
	public InstoreDisplayPromoPage navToInstorePromotionOADisplay(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreDisplayPromoPage.class);
	}
	
	public InstoreDisplayPromoPage navToInstorePromotionOSDisplay(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreDisplayPromoPage.class);
	}
	
	public InstoreDisplayPromoPage navToInstorePromotionSMDisplay(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreDisplayPromoPage.class);
	}
	
	public InstoreDisplayPromoPage navToInstorePromotionSTMDisplay(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreDisplayPromoPage.class);
	}
	

	public InstoreDisplayPromoPage navToInstorePromotionBRDisplay(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreDisplayPromoPage.class);
	}
			
	//----------------------OML------------------------
		public InstoreOMLPage navToInstorePromotionDMOML(String storenum,WebDriver driver){
			enterUserCredentialsDM(driver);
			waitFor(2);  
			//enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
			
			return createPage(InstoreOMLPage.class);
		}
		
		public InstoreOMLPage navToInstorePromotionTMOML(String storenum,WebDriver driver){
			enterUserCredentialsTM(driver);
			waitFor(2);  
			//enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
			
			return createPage(InstoreOMLPage.class);
		}
		
		public InstoreOMLPage navToInstorePromotionCAOML(String storenum,WebDriver driver){
			enterUserCredentialsCA(driver);
			waitFor(2);  
			//enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
			
			return createPage(InstoreOMLPage.class);
		}
		
		public InstoreOMLPage navToInstorePromotionOAOML(String storenum,WebDriver driver){
			enterUserCredentialsOA(driver);
			waitFor(2);  
			//enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
			
			return createPage(InstoreOMLPage.class);
		}
		
		public InstoreOMLPage navToInstorePromotionOSOML(String storenum,WebDriver driver){
			enterUserCredentialsOS(driver);
			waitFor(2);  
			//enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
			
			return createPage(InstoreOMLPage.class);
		}
		
		public InstoreOMLPage navToInstorePromotionSMOML(String storenum,WebDriver driver){
			enterUserCredentialsSM(driver);
			waitFor(2);  
			//enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
			
			return createPage(InstoreOMLPage.class);
		}
		
		public InstoreOMLPage navToInstorePromotionSTMOML(String storenum,WebDriver driver){
			enterUserCredentialsSTM(driver);
			waitFor(3);
			enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
				
			return createPage(InstoreOMLPage.class);
		}
		

		public InstoreOMLPage navToInstorePromotionBROML(String storenum,WebDriver driver){
			enterUserCredentialsBR(driver);
			waitFor(3);
			enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
			
			return createPage(InstoreOMLPage.class);
		}
	//-------------------------------------------------------------------
	
	//---------------------OMS-------------------------
	
	public InstoreOMSPage navToInstorePromotionDMOMS(String storenum,WebDriver driver){
		enterUserCredentialsDM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMSPage.class);
	}
	
	public InstoreOMSPage navToInstorePromotionTMOMS(String storenum,WebDriver driver){
		enterUserCredentialsTM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMSPage.class);
	}
	
	public InstoreOMSPage navToInstorePromotionCAOMS(String storenum,WebDriver driver){
		enterUserCredentialsCA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMSPage.class);
	}
	
	public InstoreOMSPage navToInstorePromotionOAOMS(String storenum,WebDriver driver){
		enterUserCredentialsOA(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMSPage.class);
	}
	
	public InstoreOMSPage navToInstorePromotionOSOMS(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMSPage.class);
	}
	
	public InstoreOMSPage navToInstorePromotionSMOMS(String storenum,WebDriver driver){
		enterUserCredentialsSM(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMSPage.class);
	}
	
	public InstoreOMSPage navToInstorePromotionSTMOMS(String storenum,WebDriver driver){
		enterUserCredentialsSTM(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InstoreOMSPage.class);
	}
	

	public InstoreOMSPage navToInstorePromotionBROMS(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreOMSPage.class);
	}
	
	//--------------------------------------
	public InstoreClearancePage navToInstorePromotionBR(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage.class);
	}
	
	
	public InstoreClearancePage1 navToInstorePromotionBR1(String storenum,WebDriver driver){
		enterUserCredentialsBR(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreClearancePage1.class);
	}
	
	public InstoreCompetitionPage1 navToInstorePromotionOSComp1(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage1.class);
	}
	
	
	public InstoreCompetitionPage navToInstorePromotionOSComp(String storenum,WebDriver driver){
		enterUserCredentialsOS(driver);
		waitFor(2);  
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		
		return createPage(InstoreCompetitionPage.class);
	}
	
	public void enterUserCredentials1(WebDriver driver){
		validatePage(driver);
		driver.manage().deleteAllCookies();
		getLogger().info("Username: " + getContext().getStringProperty("un"));
		enterText(txtUserName, getContext().getStringProperty("un"),driver);

		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("pwd"),driver);
		waitFor(1);
		//txtPassword.sendKeys(Keys.ENTER);
		login.click();

		
	}
	
	*//**
	 * Inputs the store number
	 * @param storenum
	 *//*
	public void enterStoreNo(String storenum,WebDriver driver){
		
		new Actions(driver).moveToElement(txtStore).perform();
		//waitFor(1);
		waitFor(3);
		setDriver(driver);
		try{
			waitForElement(txtStore,driver);	
			txtStore.sendKeys(storenum);
			//enterElmentUsingJs(txtStore, storenum,driver);			
		}catch(Exception ex)
		{
			System.out.println("Exception : "+ex);
			enterElmentUsingJs(txtStore, storenum,driver);
		}
		//txtStore.sendKeys(storenum);
		setDriver(driver);
		waitForElement(btnVerify,driver);
		btnVerify.click();
		waitForElement(btnYes,driver);
		btnYes.click();
	}
	
	
	
	*//**
	 * Login into application and navigate to promotion search page	
	 * @param storenum
	 * @return PromotionSearchPage
	 *//*
	
	
	public ReceiveOrderPage navToReceive(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(ReceiveOrderPage.class);
	}
	
	
	public OrderingPage navToOrderEnqForCreation(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(OrderingPage.class);
	}
	
	public ReceivingSegmentPage navToOrderEnq(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(ReceivingSegmentPage.class);
	}
	
	
	public OrderUpdationPage navToOrderEnqForUpdation(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(OrderUpdationPage.class);
	}
	
	public GoodsSummaryReportPage navToGSRStockAdj(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(GoodsSummaryReportPage.class);
		
	}
	
	public StockAdjPage navToStockAdj(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(StockAdjPage.class);
		
	}
	
	public RepairsAndSparesPage navToRepairsSpares(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(RepairsAndSparesPage.class);
	}
	
	
	public GoodsMovementPage navToGoods(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(GoodsMovementPage.class);
	}

	public EnhancedArticleLookUpPage navToEnhancedarticle(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(EnhancedArticleLookUpPage.class);
	}
	
	public EnhancedArticleLookUpPage1 navToEnhancedarticle2(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(EnhancedArticleLookUpPage1.class);
	}
	
	public EnhancedArticleLookUpPage navToEnhancedarticlesample(String un,String pwd,String storenum,WebDriver driver,String cName,String mName,ExtentTest extLogger){
		try{
		enterUserCredentialsample(driver,un,pwd);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
		}catch(Exception e){
			htmlToExtent(cName,mName,extLogger,driver,"Exception Occured :" +e.getClass().getSimpleName()+";;;FAIL");
		}
		return createPage(EnhancedArticleLookUpPage.class);
	}


	public ReceivingPages navToReceiving(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(ReceivingPages.class);
	}

	public AdjustmentLogReportPage navToAdjustmentLog(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(AdjustmentLogReportPage.class);
	}

		public StockTakePage navToStocktake(String storenum,WebDriver driver){
			enterUserCredentials(driver);
			waitFor(3);
			enterStoreNo(storenum,driver);
			waitForPageToLoad(driver);
			waitFor(1);
			setDriver(driver);
			if (notificationPopup.isDisplayed()){
				btnNo.click();
			}
				
			return createPage(StockTakePage.class);
		}
		
		

public StockTransferPage navToStockTransfer(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(StockTransferPage.class);
	}
	
	public EnhancedArticleLookUpPage navToEnhancedarticle1(String storenum,WebDriver driver){
		enterUserCredentials1(driver);
		waitFor(3);
		//enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(EnhancedArticleLookUpPage.class);
	}
	
	

	
	public GapscanReportPage  navToGapscan(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(GapscanReportPage.class);
	}
	
	
public oocreportpages navToOocreport(String storenum,WebDriver driver) {
	// TODO Auto-generated method stub
	enterUserCredentials(driver);
	waitFor(3);
	enterStoreNo(storenum,driver);
	waitForPageToLoad(driver);
	waitFor(1);
	setDriver(driver);
	if (notificationPopup.isDisplayed()){
		btnNo.click();
	}
		
	return createPage(oocreportpages.class);
}

public ltoreportpage navtoltoreport(String storenum,WebDriver driver) {
	// TODO Auto-generated method stub
	enterUserCredentials(driver);
	waitFor(3);
	enterStoreNo(storenum,driver);
	waitForPageToLoad(driver);
	waitFor(1);
	setDriver(driver);
	if (notificationPopup.isDisplayed()){
		btnNo.click();
	}
		
	return createPage(ltoreportpage.class);
}
	
	
	public RoutinesPage navToRoutines(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(RoutinesPage.class);
	}
	
	public EnhancedArticleLookUpPage navToIBT(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(EnhancedArticleLookUpPage.class);
	}
	
	public DSCandPLUReportPage navToDSCAndPLUReport(String storenum,WebDriver driver){
		enterUserCredentialsRoutines(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		setDriver(driver);
		waitFor(1);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(DSCandPLUReportPage.class);
	}
	
	public DSCandPLUReportPage navToDSCAndPLU(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		setDriver(driver);
		waitFor(1);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(DSCandPLUReportPage.class);
	}
	
	public InventoryReportPage navToInventoryReport(String storenum,WebDriver driver){
		enterUserCredentialsRoutines(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(InventoryReportPage.class);
	}
	
	public LTOAddOrEditPage navToLTO(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(LTOAddOrEditPage.class);
	}
	
	*//**
	 * Validates the login page of the application
	 *//*
	public void validatePage(WebDriver driver){
		setDriver(driver);
		waitForPageToLoad(driver);
		waitForPage("Login to Store Central",driver);
		getLogger().info("Title of the page: " + driver.getTitle());
		if(driver.getTitle().trim().contentEquals("Login to Store Central")){
			getLogger().info("Application is launched successfully");
			
		}else
			throw new SkipException("Error in launching the application");
	}
	
	*//**
	 * Logout from the application
	 * @throws IOException 
	 *//*
	public void logoutFromAppl() throws IOException{
		scrolltoElement(gblMenuItem);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-150)");
		Actions action = new Actions(driver);
		action.moveToElement(gblMenuItem).click().perform();
		waitForElement(lnkLogout);
		click(lnkLogout);
		//Report_AddStep("testcase", "---------------Logged out of Application successfully--------------------","","", "Pass");
		
	}
	*/
	public String logoutFromAppl(Multimap<String, String> scenarios, String testname,WebDriver driver) throws IOException{
		waitFor(1);
		setDriver(driver);
		scrolltoElement(gblMenuItem,driver);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-150)");
		Actions action = new Actions(driver);
		action.moveToElement(gblMenuItem).click().perform();
		waitForElement(lnkLogout,driver);
		click(lnkLogout);
		return "-----------------Logout from Application------------------;;;Pass";
		
		//Report_AddStep("testcase", "---------------Logged out of Application successfully--------------------","","", "Pass");
		
	}
	
	public void Logout(Multimap<String, String> scenarios, String testname,WebDriver driver) throws IOException{
		setDriver(driver);
		scrolltoElement(gblMenuItem,driver);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-150)");
		Actions action = new Actions(driver);
		action.moveToElement(gblMenuItem).click().perform();
		waitForElement(lnkLogout,driver);
		click(lnkLogout);
		//scenarios.put(testname,"-----------------Logout from Application------------------;;;Pass");
		//Report_AddStep("testcase", "---------------Logged out of Application successfully--------------------","","", "Pass");
		
	}


	/*public OrderEnquiryPage navToOrderCreation(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}

		return createPage(OrderEnquiryPage.class);
	}*/
	
	public void logoutFromAppl1(Multimap<String, String> scenarios, String testname,WebDriver driver) throws IOException{
		//waitForElement(gblMenuItem);
		try{
			setDriver(driver);
			if(gblMenuItem.isDisplayed()){
				scrolltoElement(gblMenuItem,driver);
				((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-150)");
				Actions action = new Actions(driver);
				action.moveToElement(gblMenuItem).click().perform();
				waitForElement(lnkLogout,driver);
				click(lnkLogout);
				scenarios.put(testname,"-----------------Logout from Application------------------;;;Pass");
				}}
		catch(Exception e)				
				{
			//scenarios.put(testname,"-----------------Logout from Application------------------;;;Fail");
			//driver.quit();
			waitFor(5);
			driver.navigate().refresh();
			waitFor(5);
			scrolltoElement(gblMenuItem,driver);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-150)");
			Actions action = new Actions(driver);
			action.moveToElement(gblMenuItem).click().perform();
			waitForElement(lnkLogout,driver);
			click(lnkLogout);
			scenarios.put(testname,"-----------------Logout from Application------------------;;;Pass");
				}
			}
	
	/*public ReceivingOrderPage navToOrderEnquiry(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
		btnNo.click();
		}

		return createPage(ReceivingOrderPage.class);
		}
	
	public String logoutSADJ(Multimap<String, String> scenarios, String testname,WebDriver driver) throws IOException{
		setDriver(driver);
		scrolltoElement(gblMenuItem,driver);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-150)");
		Actions action = new Actions(driver);
		action.moveToElement(gblMenuItem).click().perform();
		waitForElement(lnkLogout,driver);
		click(lnkLogout);
		return "Pass";		
		
		
	}*/
	
	/*public ReturnToVendorPage navToReturnToVendor(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(ReturnToVendorPage.class);
	}*/

	/*public ReturnToVendorPage navToReturnToVendorRTV(String storenum,WebDriver driver){
		enterUserCredentialsAnotherUserRTV(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(ReturnToVendorPage.class);
	}
	
	public void enterUserCredentialsAnotherUserRTV(WebDriver driver){
		validatePage(driver);
		setDriver(driver);
		driver.manage().deleteAllCookies();
		setDriver(driver);
		getLogger().info("Username: " + getContext().getStringProperty("username"));
		enterText(txtUserName, getContext().getStringProperty("usernameRTV"),driver);

		waitFor(1);
		enterText(txtPassword, getContext().getStringProperty("passwordRTV"),driver);
		setDriver(driver);
		click(btnLogin);
	}
	
	public ReturnToVendorPage navToReturnToVendor(String storenum,WebDriver driver){
		enterUserCredentials(driver);
		waitFor(3);
		enterStoreNo(storenum,driver);
		waitForPageToLoad(driver);
		waitFor(1);
		setDriver(driver);
		if (notificationPopup.isDisplayed()){
			btnNo.click();
		}
			
		return createPage(ReturnToVendorPage.class);
	}
*/
		}



