/**
 * This class forms the base class for all the tests
 * It creates driver, initializes the other framework libraries.
 * It also has configuration methods to run before starting the test
 */

package au.wow.ngbo.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.xml.sax.SAXException;

import com.google.common.collect.Multimap;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners({au.wow.ngbo.utils.TestBaseListener.class})
public class TestBase extends BasePage{
	
	
	//Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static WebDriver driver1;
	public static TestContext context;	
	public static Logger log;
	
	protected CustomExtentReports customreport;
	public TestStatus status;
	public static DesiredCapabilities capabilities = null;
	static int first=0;
	
	public static WebDriver getDriver1(){
		if(first==0){
		context = new TestContext(log, System.getProperty("user.dir") + "\\TestData\\config.properties");
		first++;
		}
		if(TestContext.getStringProperty("isDocketRun").equalsIgnoreCase("true")){
			return driver.get();
		}else{
			return driver1;
		}
	}
	
	public Logger getLogger(){
		return log;
	}
	
	public TestStatus getTestStatus(){
		return status;
	}
	
	public TestContext getContext(){
		return context;
	}
	
	/**
	 * Creates the driver object
	 * @param URL
	 * @param browser
	 */
	public void createWebDriver(String URL){
		capabilities=new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\drivers\\chromedriver.exe");
		capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		driver1 = new ChromeDriver(capabilities);
		getDriver1().get(URL);
		waitFor(1);
		getDriver1().manage().window().maximize();
		//ChromeOptions.addArguments("start-maximized");
		getDriver1().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void createDocketDriver(String URL) throws MalformedURLException{
		//Set DesiredCapabilities
    	capabilities = new DesiredCapabilities();
		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("platform", "LINUX");
        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL(TestContext.getStringProperty("docketURL")), capabilities));
        getDriver1().get(URL);
        getDriver1().manage().window().maximize();
        getDriver1().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	public WebDriver createDriver(String URL, String browser,String cName,String mName,ExtentTest extLogger,WebDriver driver) //throws MalformedURLException {
		{

		switch (browser) {
		case "chrome":
			try {				
				if(TestContext.getStringProperty("isDocketRun").equalsIgnoreCase("true")){	
					createDocketDriver(URL);					
			
				}else{
					createWebDriver(URL);
				}
				

			} catch (Exception e) {
				if(null==driver){
					String val="In Local";
					if(getContext().getStringProperty("isDocketRun").equalsIgnoreCase("true")){val = "In Docker";}
				BasePage.htmlToExtent(cName, mName, extLogger, driver, "Driver launching issue "+val+";;;Warning");}
				e.printStackTrace();
				Assert.fail("Unable to launch the browser\n",
						e.fillInStackTrace());
			}
			break;

		}
		return getDriver1();
	}
	
	public void removeDriver(){
		if(TestContext.getStringProperty("isDocketRun").equalsIgnoreCase("true")){
			 driver.remove();
			}
	}
	
	
	
	/**
	 * Creates the object to read the config.properties file
	 */
	public void initializeTestcontext(){
		context = new TestContext(log, System.getProperty("user.dir") + "\\TestData\\config.properties");
	}
	
	/**
	 * Initializes the test status object
	 */
	public void initializeTestStatus(){
		status = new TestStatus(customreport);
	}
	
	/**
	 * Closes all the browser instances
	 * @param driver2 
	 */
	public void closeDriver(WebDriver driver2){		
		System.out.println("close driver");		
		driver2.close();
			
		
	}
	
	/**
	 * Archives the previous run results
	 */
	public void archiveTestOutput(){
		TestResultsArchiver testarchive = new TestResultsArchiver(log);
		testarchive.copyDir();
	}
	
	
	/**
	 * @throws IOException 
	 * @throws ParseException 
	 * 
	 */
	
	public File fnReportFolder() {
		File f = new File(
				"C:\\SCAutomation\\NGBOProject\\ArchiveResults\\Reports");
		f.mkdirs();
		for (File file : f.listFiles()) {
			if (!file.isDirectory())
				file.delete();
		}
		File f1 = new File(getContext().getStringProperty("reportPath"));
		f1.mkdirs();
		for (File file1 : f1.listFiles()) {
			if (!file1.isDirectory())
				file1.delete();
		}
		File f2 = new File(getContext().getStringProperty("reportPath")
				+ "\\Screenshots");
		f2.mkdirs();
		for (File file1 : f2.listFiles()) {
			if (!file1.isDirectory())
				file1.delete();
		}
		return f1;
	}
	
	/**
	 * Executes after each test method. Closes the browser created for each method
	 * @throws ParseException 
	 * @throws IOException 
	 */
	
	public void fnHTMLReportFlush(
			HashMap<String, Multimap<String, String>> SUmodules1,
			Multimap<String, String> SUscenarios1,
			Multimap<String, String> oRTimeNew, String Stdateex,
			String enddateex,String manualTC) throws IOException, ParseException {
		String stsumDesc = "";
		for (Entry<String, Multimap<String, String>> entry : SUmodules1
				.entrySet()) {
			String stModuleName = entry.getKey();
			// System.out.println(stModuleName);
			Report_Header("Summary",
					new File(getContext().getStringProperty("reportPath")),
					stModuleName, Stdateex);
			// waitFor(1);
			Multimap<String, String> value = entry.getValue();
			Set keySet = value.keySet();
			Iterator keyIterator = keySet.iterator();

			Set keySet1 = oRTimeNew.keySet();
			Iterator keyIteratorNew = keySet1.iterator();

			while (keyIterator.hasNext()) {
				String stScenarioName = (String) keyIterator.next();
				// System.out.println(stScenarioName);

				String stSceNameTime = (String) keyIteratorNew.next();
				// System.out.println(stSceNameTime);
				String stTime = oRTimeNew.get(stSceNameTime).toString();
				// System.out.println(stTime);
				stsumDesc = stTime.split(";")[0];

				waitFor(1);
				Report_Header("testcase", new File(getContext()
						.getStringProperty("reportPath")), stScenarioName,
						stTime.split(";")[1]);

				String stSteps1 = SUscenarios1.get(stScenarioName).toString();
				// .out.println(stSteps1);

				Iterator keyIterator1 = SUscenarios1.get(stScenarioName)
						.iterator();
				while (keyIterator1.hasNext()) {
					String stSteps = (String) keyIterator1.next();
					// System.out.println(stSteps);
					waitFor(1);
					HR_Steps_TestCase(
							new File(getContext().getStringProperty(
									"reportPath")), stScenarioName,
							stSteps.split(";")[0].replace("[", ""),
							stSteps.split(";")[1], stSteps.split(";")[2],
							stSteps.split(";")[3].replace("]", ""));

				}
				// waitFor(1);
				Report_Footer("testcase", stScenarioName, stModuleName,
						stTime.split(";")[1], stTime.split(";")[2],manualTC);
				// waitFor(1);
				Report_AddStep("summary", stScenarioName, stModuleName,
						stsumDesc.replace("[", ""), "Pass");

			}
			// waitFor(1);
			Report_Footer("summary", "", stModuleName, Stdateex, enddateex,manualTC);
			//Report_Footer("summary", "", stModuleName, Stdateex.split(";")[1], enddateex.split(";")[2]);
			// waitFor(1);
			Main_Steps_Summary(
					new File(getContext().getStringProperty("reportPath")),
					stModuleName,manualTC);
			// waitFor(1);
		}

	}
	
	/**
	 * @throws ParseException 
	 * @throws IOException 
	 * 
	 */
	@AfterSuite(alwaysRun=true)
	public void flushReports1() throws IOException, ParseException{
		
		System.out.println("aftersuite");	
		
        endTime=getDateAndTime();
		try {
			SummaryCreation.create();
		} catch (SAXException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

	/**
	 * Executes before the test suite is started
	 * @throws IOException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@BeforeSuite(alwaysRun=true)
	public void onStart() throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{	
		int befo = 1;
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		waitFor(1);
		System.out.println("testbase - beforesuite");
		startTime= getDateAndTime();
		//archiveTestOutput();
		//db connectivity
		System.setProperty("java.library.path", System.getProperty("user.dir") + "\\lib\\jdbc\\dblg64" );
		Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
		fieldSysPath.setAccessible(true);
		fieldSysPath.set(null, null);
		
		initializeTestcontext();
		
		Date dtSuiteSt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		stStartSuite = dateFormat.format(dtSuiteSt);
		System.out.println("completion");
	}

	 public String getResultStatusName(int status) {
	    	String resultName = null;
	    	if(status==1)
	    		resultName = "Pass";
	    	if(status==2)
	    		resultName = "Fail";
	    	if(status==3)
	    		resultName = "Fail";
			return resultName;
	    }
	
	
}
