package au.wow.ngbo.utils;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class BasePage extends HTMLReport{

	private Logger log;
	private static Logger logg;
	private TestContext context;
	
	public static WebDriver driver;	
	public TestStatus status;
	public XMLDataReader testdata;
	public static String className;
	public static String methodName;
	public static Multimap<String, String> extentList = ArrayListMultimap.create();
	public static boolean  isFailure=false;
	
	public static ArrayList<String> classList = new ArrayList<String>();
	public static HashMap<String, Integer> tcCt = new HashMap<String, Integer>();
	
	
	
	public static String startTime ="";
	public static String endTime ="";
	public static HashMap<String, Integer> sceCtMap = new HashMap<String, Integer>();
	public static HashMap<String, Integer> extMap = new HashMap<String, Integer>();	
	
	
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}

	protected void setContext(TestContext context){
		this.context=context;
	}
	
	public void waituntilClickable(WebElement element,long timeout, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void setLogger(Logger log){
		this.log=log;
	}

	protected void setTestStatus(TestStatus status){
		this.status=status;
	}

	protected void setTestData(XMLDataReader testdata){
		this.testdata=testdata;
	}

	public WebDriver getDriver(){
		return driver;
	}

	protected TestContext getContext(){
		return context;
	}

	protected Logger getLogger(){
		return log;
	}

	protected TestStatus getStatus(){
		return status;
	}

	protected XMLDataReader getTestData(){
		return testdata;
	}
	
	public WebElement prepareWebElementWithDynamicXpathWithInt(String xpathValue, int i,WebDriver driver) { //meenu
		return driver.findElement(By.xpath(xpathValue.replace("dynamic", ""+i)));		
	}
	
	public List<WebElement> prepareWebElementWithDynamicXpathWithIntList(String xpathValue, int i,WebDriver driver) { //meenu
		return driver.findElements(By.xpath(xpathValue.replace("dynamic", ""+i)));		
	}
	
	public WebElement prepareWebElementWithDynamicXpathWithString(String xpathValue, String s,WebDriver driver) {
		return driver.findElement(By.xpath(xpathValue.replace("dynamic",s)));
	}

	public WebElement prepareWebElementWithDynamicXpathWithStringInt(String xpathValue, String s,int i,WebDriver driver) { //meenu
		return driver.findElement(By.xpath(xpathValue.replace("dynamic",s).replace("value",""+i)));
	}

	public WebElement prepareWebElementWithDynamicXpathWithIntInt(String xpathValue, int j,int i,WebDriver driver) { //meenu
		return driver.findElement(By.xpath(xpathValue.replace("dynamic",""+j).replace("value",""+i)));
	}
	
	public WebElement prepareWebElementWithDynamicXpathWithIntIntInt(String xpathValue, int j,int i,int k,WebDriver driver) { //meenu
		return driver.findElement(By.xpath(xpathValue.replace("dynamic",""+j).replace("value",""+i).replace("val",""+k)));
	}
	
	public WebElement prepareWebElementWithDynamicXpathStringInt(String xpathValue, String i,String dataType,WebDriver driver) throws AWTException  
	{


		if(dataType.equalsIgnoreCase("int"))
		{
			return driver.findElement(By.xpath(xpathValue.replace("dynamic", ""+Integer.parseInt(i))));
		}
		else
		{
			char ch='"';
			/*String temp=xpathValue.replace("'dynamic'","\""+i+"\"");*/

			String temp=xpathValue.replace("dynamic",i.trim());
			WebElement element=driver.findElement(By.xpath(temp));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			if(!(element.isDisplayed()))
			{
				scrollToElementAndClickIfReqd(je, element, "scroll", "null",driver);
			}
			return element;
		}
	}
	
	public void scrollToElementAndClickIfReqd(JavascriptExecutor je,WebElement element,String functionality_str,String AJAX_str, WebDriver driver) throws AWTException  
	{
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		switch(functionality_str)
		{
		case("scroll"):
		{
			break;
		}

		case("click"):
		{
			String elementname = getElementLocator(element);
			click(element);
			break;
		}
		//RA-->Robot Action
		case("clickRA"):
		{
			waitFor(5);
			waitForElement(element,driver);
			org.openqa.selenium.Point coordinates = element.getLocation();
			Robot robot = new Robot();
			robot.mouseMove(coordinates.getX(), coordinates.getY() + 100);
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
			break;
		}
		default:
		{
			//System.out.println("Invalid entry");
			break;
		}


		}

		if(AJAX_str.equalsIgnoreCase("AJAX"))
		{
			waitForJSandJQueryToLoad(driver);
		}

	}
	

	/**
	 * Initialize the elements of the specified page class along with the objects of framework libraries
	 * @param driver
	 * @param context
	 * @param log
	 * @param status
	 * @param testdata
	 * @param pageClassToProxy
	 * @return specifiedPage
	 */
	public <T extends BasePage> T createPage(WebDriver driver, TestContext context, Logger log, TestStatus status, XMLDataReader testdata, Class<T> pageClassToProxy){
		T page = PageFactory.initElements(driver, pageClassToProxy);
		page.setDriver(driver);
		page.setContext(context);
		page.setLogger(log);
		page.setTestStatus(status);
		page.setTestData(testdata);
		return page;
	}

	/**
	 * Initialize the elements of the specified page class
	 * @param pageClassToProxy
	 * @return specifiedPage
	 */
	public <T extends BasePage> T createPage(Class<T> pageClassToProxy){
		T page = createPage(getDriver(),getContext(), getLogger(),getStatus(), getTestData(),pageClassToProxy);
		page.setContext(context);
		page.setLogger(log);
		page.setTestStatus(status);
		page.setTestData(testdata);
		return page;
	}
	
	/**
	 * Performs vertical scrolling in the browser/window
	 */
	public void verticalScrollLong(WebDriver driver){
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,900)");
	}	
	public void verticalScroll(WebDriver driver){
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
	}
	
	public void scrollUp(WebDriver driver){
		((JavascriptExecutor)driver).executeScript("scrollBy(0, -1000);");
		
	}
	
	public void scrollToElement(WebElement element){
		
	}

	/**
	 * Waits for a page to be loaded
	 */
	public void waitForPageToLoad(WebDriver driver){
		new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				return (((JavascriptExecutor)arg0).executeScript("return document.readyState").equals("complete"));
			}
		});
	}

	/**
	 * Waits for a specified element to be visible
	 * @param element
	 */
	public void waitForElement(WebElement element, WebDriver driver){
		//try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		/*}catch(Exception e){
			String elementname = getElementLocator(element);
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("TimeOut Exception occurred while waiting for the element: " + elementname);
			}
		}*/
	}
	
	/**
	 * Waits for a specified locator to be invisible
	 * @param element
	 */
	public void waitForInvisibilityOfElement(By element,WebDriver driver){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		}catch(Exception e){
//			String elementname = getElementLocator(element);
			try {
				throw new CustomException(e, getLogger(), element.toString());
			} catch (CustomException e1) {
				getLogger().error("TimeOut Exception occurred while waiting for the element: " + element.toString());
			}
		}
	}

	
	/**
	 * Waits for a specified locator to be Cllickable
	 * @param lnkReports
	 */
	public void waitForClickOfElement(WebElement lnkReports,WebDriver driver){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(lnkReports));
		}catch(Exception e){
//			String elementname = getElementLocator(element);
			try {
				throw new CustomException(e, getLogger(), lnkReports.toString());
			} catch (CustomException e1) {
				getLogger().error("TimeOut Exception occurred while waiting for the element: " + lnkReports.toString());
			}
		}
	}
	
	
	
	

	/**
	 * Waits for a specified page to be displayed
	 * @param page
	 */
	public void waitForPage(String page,WebDriver driver){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleContains(page));
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), page);
			} catch (CustomException e1) {
				getLogger().error("TimeOut Exception occurred while waiting for the page: " + page);
			}
		}
	}

	/**
	 * Waits for a specified number of seconds
	 * @param seconds
	 */
	public void waitFor(double seconds){
		try {
			Thread.sleep((long)seconds*1000);
		} catch (InterruptedException e) {
			log.error("Interruption occured during waiting",e);
		}
	}
	
	public static void waitForr(double seconds){ //meenu
		try {
			Thread.sleep((long)seconds*1000);
		} catch (InterruptedException e) {
			logg.error("Interruption occured during waiting",e);
		}
	}
	
/*	public String formatDate(String date, String format){		
		return new SimpleDateFormat(format).format(date);

	}*/
	
	/**
	 * Converts a date to a specified format
	 * @param date
	 * @param format
	 * @return formattedDate
	 */
	public String formatDate(Date date, String format){		
		return new SimpleDateFormat(format).format(date);

	}
	
	public String formatDate1(Date date){		
		return new SimpleDateFormat("dd/MM/yyyy").format(date);

	}
	
	/**
	 * Converts a string to date
	 * @param date
	 * @param format
	 * @return parsedDate
	 */
	public Date parseDate(String date, String format){ //refer
		Date returndate = null;	
//		String formattedDate = new SimpleDateFormat(format).format(date);
		try {
			returndate = new SimpleDateFormat(format).parse(date);			 
		} catch (ParseException e) {
			getStatus().fail("Error in parsing the date: " + date);
		}
		return returndate;
	}
	
	/*public LocalDate getFormattedDate(String pattern, String value)	throws IllegalArgumentException, DateTimeParseException 
	{
		return LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
	}*/
	
	/**
	 * Convert string to integer
	 * @param str
	 * @return integer value of specified string
	 */
	public int toInt(String str){
		return Integer.parseInt(str);
	}
	
	/**
	 * Convert string to double
	 * @param str
	 * @return double value of specified string
	 */
	public double toDouble(String str){
		return Double.parseDouble(str);
	}
	
/*	public Date parseAbbreviatedMonth(String date){
		Date formattedDate = parseDate(date, "dd MMM yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(formattedDate);
		return stringToDate(cal.getTime().toString(), toformat);
	}
*/

	// ================= Common Weblement methods============================
	public String getElementLocator(WebElement element){
		String name = element.toString();
		int index = name.lastIndexOf("->");
		return name.substring(index+2, (name.length()-1));
	}
	
	
	/**
	 * Enters the provided value in the textbox
	 * @param textbox - WebElement to which value is entered
	 * @param value - Value to be entered
	 */
	public void enterText(WebElement textbox, String value, WebDriver driver){
		String elementname = getElementLocator(textbox);
		try{
			setDriver(driver);
			textbox.clear();
			textbox.sendKeys(value);
			getLogger().info("The textbox: " + elementname
					+ " is set to value: " + value);
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in entering the value: " + value 
						+ " in textbox: " + elementname);
			}
		}
	}
	
	/**
	 * Gets the value of a html attribute for an element
	 * @param element - WebElement to be clicked
	 * @return String - value of a html attribute  
	 */
	public String getValueAttribute(WebElement element){
		String elementname = getElementLocator(element);
		String value=null;
		try{
			value=element.getAttribute("value");
			getLogger().info("Value attribute: " + value
					+ " from the element: " + elementname);
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in retrieving the value attribute from the element: " + elementname);
			}
		}
		return value;
	}
	
	/**
	 * Enters the value in a textbox character by character till autocomplete box is visible 
	 * @param element - WebElement to which the character is entered
	 * @param text - character to be entered
	 */
	public void typeTextInAutoComplete(WebElement element, String text){
		for(int i=0;i<text.length();i++){
			element.sendKeys(String.valueOf(text.charAt(i)));
			waitFor(1);
		}
	}
	
	/**
	 * Clicks on an Element(button, link)
	 * @param element - WebElement to be clicked
	 */
	public void click(WebElement element){
		String elementname = getElementLocator(element);
		try{
			element.click();
			//getLogger().info("The element: " + elementname + " is clicked");
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in clicking the element: " + elementname);
			}
		}
	}
	
	
	
	/**
	 * Retrieves the visible text of an element
	 * @param element 
	 * @return String  - visible text of an element
	 */
	public String getText(WebElement element){
		String elementname = getElementLocator(element);
		String text=null;
		try{
			text=element.getText().trim();
			System.out.println(text);
			
			
//			getLogger().info("Element's text: " + text);
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in retrieving the text from the element: " + elementname);
			}
		}
		return text;
	}
	
	
	/**
	 * Retrieves element text using JavascriptExecutor
	 * @param element 
	 * @return String  - visible text of an element
	 */
	public String getElementTextUsingJs(WebElement element,WebDriver driver){
		return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerText;", element);
	}
	
	/**
	 * Click using JavascriptExecutor
	 * @param element 
	 */
	public void clickElmentUsingJs(WebElement element,WebDriver driver){
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	public void enterElmentUsingJs(WebElement element, String longstring,WebDriver driver){
		((JavascriptExecutor)driver).executeScript("arguments[0].value = '" + longstring + "'", element);
	}
	
	/**
	 * Selects an option in dropdown using visibletext
	 * @param dropdown
	 * @param text
	 */
	public void selectByVisibleText(WebElement dropdown, String text){
		String elementname = getElementLocator(dropdown);
		try{
			Select select = new Select(dropdown);
			select.selectByVisibleText(text);
			getLogger().info("The option with text: " + text 
					+ " is selected in the dropdown: " +  elementname);
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in selecting the text: " + text 
						+ " from the dropdown: " + elementname);
			}
		}
	}
	
	
	/**
	 * Selects an option in dropdown using index
	 * @param dropdown
	 * @param index
	 */
	public void selectByIndex(WebElement dropdown, int index){
		String elementname = getElementLocator(dropdown);
		try{
			Select select = new Select(dropdown);
			select.selectByIndex(index);
			getLogger().info("The option at index: " + index 
					+ " is selected in the dropdown: " + elementname);
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in selecting the index: " + index 
						+ "from the dropdown: " + elementname);
			}
		}
	}


	/**
	 * Selects an option in dropdown using value
	 * @param dropdown
	 * @param value
	 */
	public void selectByValue(WebElement dropdown, String value){
		String elementname = getElementLocator(dropdown);
		try{
			Select select = new Select(dropdown);
			select.selectByValue(value);
			getLogger().info("The option with value: " + value 
					+ " is selected in the dropdown: " + elementname);
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in selecting the value: " + value 
						+ " from the dropdown: " + elementname);
			}
		}
	}

	/**
	 * Retrieves the List of options selected in a dropdown
	 * @param dropdown
	 * @return options
	 */
	public List<WebElement> getSelectedOptions(WebElement dropdown){
		String elementname = getElementLocator(dropdown);
		List<WebElement> options = new ArrayList<WebElement>();
		try{
			Select select = new Select(dropdown);
			options = select.getAllSelectedOptions();
			if(options.size()>0){
				getLogger().info("The following options are selected "
						+ options.toString() +" in dropdown: " + elementname);
			}else
				getLogger().info("No option is selected in the dropdown: " + elementname);
			
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in retrieving the selected options from the dropdown: " + elementname);
			}
		}
		return options;
	}
	
	
	/**
	 * Retrieves list of options available in a dropdown
	 * @param dropdown
	 * @return options
	 */
	public List<WebElement> getAllOptions(WebElement dropdown){
		String elementname = getElementLocator(dropdown);
		List<WebElement> options = new ArrayList<WebElement>();
		try{
			Select select = new Select(dropdown);
			options = select.getOptions();
			if(options.size()<0){
				getLogger().error("No option is listed in " + elementname);
			}	
			
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in retrieving the selected options from the dropdown: " + elementname);
			}
		}
		return options;
	}
	
	
	/**
	 * Retreives the list of values from a dropdown 
	 * @param dropdown
	 * @return options text
	 */
	public List<String> getOptionsText(WebElement dropdown){
		List<WebElement> options = getAllOptions(dropdown);
		List<String> text = new ArrayList<String>();
		if(options.size()>0){
			Iterator<WebElement> it = options.iterator();
			while(it.hasNext()){
				text.add(it.next().getText().trim());
			}
		}else{
			getLogger().error("Options list is empty");
		}
		getLogger().info("The following options are present "
				+ text + " in dropdown");
		return text;
			
	}

	/**
	 * Checks if an element is displayed
	 * @param element
	 * @return isElementDisplayed - true/false
	 */
	public boolean isDisplayed(WebElement element){
		boolean isElementDisplayed = false;
		String elementname = getElementLocator(element);
		try{
			isElementDisplayed = element.isDisplayed();
			if(isElementDisplayed){
				getLogger().info("Element: " + elementname + " is visible");
			}else
				getLogger().warn("Element: " + elementname + " is not visible");
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in checking the visibility of the element: " + elementname);
			}
		}	
		return isElementDisplayed;
	}
	
	protected List<List<Object>> replaceColumnValue(List<List<Object>> one,int row,int column,String value) throws IOException 
	{	
		String a="";String b="";int count=0;
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); count++;
			if(count==row+1){
			for(int i =0;i<elem.size();i++) {
				if(i==column){a=value;
					elem.set(i, a); break;
					}
			}
		}
	}
	return one;
	}

	/**
	 * Checks if an element is selected
	 * @param element
	 * @return isElementSelected - true/false
	 */
	public boolean isSelected(WebElement element){
		boolean isElementSelected = false;
		String elementname = getElementLocator(element);
		try{
			isElementSelected = element.isSelected();
			if(isElementSelected){
				getLogger().info("Element: " + elementname + " is selected");
			}else
				getLogger().warn("Element: " + elementname + " is not selected");

		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in checking the selected property of the element: " + elementname);
			}
		}
		return isElementSelected;

	}

	/**
	 * Checks if the element is enabled
	 * @param element
	 * @return isElementEnabled - true/false
	 */
	public boolean isEnabled(WebElement element){
		boolean isElementEnabled = false;
		String elementname = getElementLocator(element);
		try{
			isElementEnabled = element.isEnabled();
			if(isElementEnabled){
				getLogger().info("Element: " + elementname + " is enabled");
			}else
				getLogger().warn("Element: " + elementname + " is not enabled to perform operation");
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in checking the enabled property of the element: " + elementname);
			}
		}		
		return isElementEnabled;
	}

	/**
	 * Checks if the element is readonly
	 * @param element
	 * @return isReadOnly - true/false
	 */
	public boolean isReadOnly(WebElement element,WebDriver driver){
		String readonly = null;
		boolean isReadOnly=false;
		String elementname = getElementLocator(element);
		try{
			readonly=element.getAttribute("readonly");
			if(readonly==null){
				getLogger().info("Element: " + elementname + " has no such property");
			}else if(readonly.equalsIgnoreCase("readonly")){
				getLogger().info("Element: " + elementname + " is read only");
				isReadOnly=true;				
			}else
				getLogger().info("Element: " + elementname + " is not read only");
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in retrieving the readonly property of the element: " + elementname);
			}
		}			
		return isReadOnly;
	}

	/**
	 * Retrieves the tooltiptext of an element
	 * @param mouseoverelement - element to mouseover
	 * @param tooltip - element to get text 
	 * @return tooltiptext
	 */
	public String getTooltipText(WebElement mouseoverelement, WebElement tooltip,WebDriver driver){
		String tooltiptext=null;
		String elementname = getElementLocator(mouseoverelement);
		try{
			Actions action = new Actions(driver);
			action.moveToElement(mouseoverelement).perform();
			waitForElement(tooltip,driver);
			if(isDisplayed(tooltip)){
				tooltiptext=getText(tooltip);
				getLogger().info("Tooltip text: " + tooltiptext 
						+ " is displayed for the element: " + elementname);
			}else{
				getLogger().warn("MouseOver text is not displayed for the element: " + elementname);
			}
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in retrieving the tooltiptext of the element: " + elementname);
			}
		}		
		return tooltiptext;

	}

	/**
	 * Selects an element in a  radiogroup based on the text provided
	 * @param rb - radiogroup
	 * @param textToSelect
	 */
	public void selectRBWithText(List<WebElement> rb, String textToSelect){
		boolean found=false;
		try{
			for(WebElement element : rb){
				if(element.getText().contains(textToSelect)){
					element.click();
					found=true;
					break;
				}
			}
			if(found){
				getLogger().info(textToSelect + " is selected from the radiogroup");
			}else
				getLogger().warn(textToSelect + " is not present in the radiogroup");
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), rb.toString());
			} catch (CustomException e1) {
				getLogger().error("Error in clicking on radiobutton");
			}
		}	
	}
	
	/**
	 * Clicks on a checkbox element
	 * @param checkbox
	 */
	public void selectCheckBox(WebElement checkbox){
		String elementname = getElementLocator(checkbox);
		try{
			checkbox.click();
			getLogger().info("Checkbox: " + elementname + " is selected");
		}catch(Exception e){
			try {
				throw new CustomException(e, getLogger(), elementname);
			} catch (CustomException e1) {
				getLogger().error("Error in selecting the checkbox: " + elementname);
			}
		}		
	}
	
	public List<List<Object>> fnGetValuesFromTable(List<WebElement> objectTable, int RowNo) {
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
	           
	            if(RowNo==row_num){
	            	break;
	            }
	            row_num++;
        }
        return tableValues;
	}
	
	
	
	protected List<List<Object>> replacenullToZero(List<List<Object>> one) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			
			for(int i =0;i<elem.size();i++) {
				if(elem.get(i)!=null){
					if(elem.get(i).toString().contains("$")){
					String myRegex = "[$]";
					elem.set(i, elem.get(i).toString().replaceAll(myRegex, ""));
					}
					if(elem.get(i).toString().isEmpty()){
						elem.set(i, 0);
					}
				
				}
				if(elem.get(i)==null){
					elem.set(i, 0);
				}
				
				
			}
	}
	return one;
	}
	

	
protected List<List<Object>> replacesymbol(List<List<Object>> one) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			
			for(int i =0;i<elem.size();i++) {
				if(elem.get(i)!=null){
					if(elem.get(i).toString().contains("$")){
					String myRegex = "[,]";
					elem.set(i, elem.get(i).toString().replaceAll(myRegex, ""));
					}
				}		
			}
	}
	return one;
	}

protected List<List<Object>> replaceCPBDuom(List<List<Object>> one,int position) throws IOException {
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<elem.size();i++) {
			if(i==position){				
				String s = elem.get(i).toString();
						if(s.equals("EA")){}else{
							s="EA";
						}
				elem.set(i, s);
			}
		}
			
}
return one;
}

protected List<List<Object>> replaceDecimalValue(List<List<Object>> one,int position) throws IOException {
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		
		for(int i =0;i<elem.size();i++) {
			if(i==position){	
			if(elem.get(i)!=null){
				if(elem.get(i).toString().startsWith("."))
				{
				String s = "0"+elem.get(i).toString();
				elem.set(i, s);
				}
				if(elem.get(i).toString().isEmpty()){
					elem.set(i, 0);
				}
			
			}
			if(elem.get(i)==null){
				elem.set(i, 0);
			}
		}
			
		}
}
return one;
}
	
protected List<List<Object>> replaceplussymbol(List<List<Object>> one, String symbol) throws IOException {     //pavi
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		
		for(int i =0;i<elem.size();i++) {
			if(elem.get(i)!=null){
				if(elem.get(i).toString().contains(symbol)){
				String myRegex = "[-+^:,]";
				elem.set(i, elem.get(i).toString().replaceAll(myRegex, ""));
				}
			}		
		}
	}
return one;
}
protected List<List<Object>> replacenullToZeropointzero(List<List<Object>> one) throws IOException {   //pavi
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		
		for(int i =0;i<elem.size();i++) {
			if(elem.get(i)!=null){
				if(elem.get(i).toString().contains("$")){
				String myRegex = "[$]";
				elem.set(i, elem.get(i).toString().replaceAll(myRegex, ""));
				}
				if(elem.get(i).toString().isEmpty()){
					elem.set(i, 0);
				}
				if(elem.get(i)=="  ")
				{
					elem.set(i, 0);
				}
			
			}
			if(elem.get(i)==null){
				String a ="0.00";
				elem.set(i,a);
			}
			
			
		}
}
return one;
}

protected List<List<Object>> SHUOMDays(List<List<Object>> one,String OMval) throws IOException {
		int OM=Integer.parseInt(OMval);
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			for(int i =0;i<elem.size();i++) {
				if(elem.get(i)!=null){
					String value = elem.get(i).toString();
					double d = Double.parseDouble(value);
					double val = (d) / OM;
					val=round(val, 3);
					//val =(Integer.parseInt(value)/OM);
					value=""+val;
					if(value.equals("0.0")){value="0";}
					elem.set(i, value);
				}
				if(elem.get(i)==null){
					elem.set(i, 0);
				}
			}
	}
	return one;
	}

public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}

protected List<List<Object>> replacevalueSH(List<List<Object>> one) throws IOException {
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		
		for(int i =0;i<elem.size();i++) {
			if(elem.get(i)!=null){
				
				if(elem.get(i).toString().equals("Y"))
				{
					elem.set(i, "*");
				}
				if(elem.get(i).toString().equals("N"))
				{
					elem.set(i, "0");
				}
			}
			if(elem.get(i)==null){
				elem.set(i, 0);
			}
		}
}
return one;
}

protected List<List<Object>> roundOff(List<List<Object>> one,int decimalPlaces) throws IOException {
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<elem.size();i++) {
			if(elem.get(i)!=null){
				if(elem.get(i).toString().contains(".")){
					String value = elem.get(i).toString();
					double d = Double.parseDouble(value);
					double val = round(d,decimalPlaces);
					value=""+val;
					if(value.equals("0.0")){value="0";}
					if(value.contains(".")){
					value = value.replaceAll("\\.?0+$","");}
					elem.set(i, value);
				}
			}
			if(elem.get(i)==null){
				elem.set(i, 0);
			}
		}
}
return one;
}


protected List<List<Object>> decimalRound(List<List<Object>> one) throws IOException {
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =3;i<elem.size();i++) {
			if(elem.get(i)!=null){
				if(elem.get(i).toString().contains(".")){
					String valuetemp = elem.get(i).toString();
					String dValue = valuetemp.substring(0,valuetemp.indexOf(" "));
					float d = Float.parseFloat(dValue);
					//double d = Double.parseDouble(value);
					String value=String.format("%.03f", d);
					if(value.equals("0.0")){value="0";}
					value = value+" "+valuetemp.substring(valuetemp.indexOf(" ")+1);
					elem.set(i, value);
				}
			}
			if(elem.get(i)==null){
				elem.set(i, 0);
			}
		}
}
return one;
}


protected List<List<Object>> roundOff(List<List<Object>> one,int position,int decimalPlaces) throws IOException {
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<elem.size();i++) {
			if(i==position){
			if(elem.get(i)!=null){
				if(elem.get(i).toString().contains(" ")){
					String[] h=splitString(elem.get(i).toString(), " ");
				if(h[0].contains(".")){
					String value = h[0];
					double d = Double.parseDouble(value);
					double val = round(d,decimalPlaces);
					value=""+val;
					if(value.equals("0.0")){value="0";}
					if(value.contains(".")){
					value = value.replaceAll("\\.?0+$","");}
					elem.set(i, value);
				}}
			}
			if(elem.get(i)==null){
				elem.set(i, 0);
			}}
		}
}
return one;
}


protected List<List<Object>> replaceblankspaceToZero(List<List<Object>> one) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			
			for(int i =0;i<elem.size();i++) {
				if(elem.get(i)!=" "){
					if(elem.get(i).toString().contains("$")){
					String myRegex = "[$]";
					elem.set(i, elem.get(i).toString().replaceAll(myRegex, ""));
					}
					if(elem.get(i).toString().isEmpty()){
						elem.set(i, 0);
					}
				
				}
				if(elem.get(i)==" "){
					elem.set(i, 0);
				}
				
				
			}
	}
	return one;
	}
	
	
	
	
	
	
	protected List<List<Object>> removeExtraSpaces(List<List<Object>> one,int position) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			for(int i =0;i<elem.size();i++) {
				if(i==position){
					String s = elem.get(i).toString().replaceAll("\\s{2,}"," ");
					elem.set(i, s);
				}
			}
				
	}
	return one;
	}
	


protected List<List<Object>> removeextraspaces(List<List<Object>> one) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			
			for(int i =0;i<elem.size();i++) {
				String s = elem.get(i).toString().replaceAll("\\s{2,}","");
				elem.set(i, s);
					}				
				}
	return one;
	}

protected List<List<Object>> removeNewLines(List<List<Object>> one) throws IOException {
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		
		for(int i =0;i<elem.size();i++) {
			String s = elem.get(i).toString().replaceAll("\\s+"," ").trim();
			elem.set(i, s);
				}				
			}
return one;
}

protected List<List<Object>> removemultiplespaces(List<List<Object>> one, int position) throws IOException {
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		
		for(int i =0;i<elem.size();i++) {
			if(i==position){
			String s = elem.get(i).toString().replaceAll("  "," ");
			elem.set(i, s);
			}
				}				
			}
return one;
}

protected List<List<Object>> removeMoreThanSingleSpace(List<List<Object>> one, int position) throws IOException {
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		
		for(int i =0;i<elem.size();i++) {
			if(i==position){
			String s = elem.get(i).toString().replaceAll("\\s{2,}"," ");
			elem.set(i, s);
			}
				}				
			}
return one;
}

	protected List<List<Object>> removeLeadingZero(List<List<Object>> one,int position) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			for(int i =0;i<elem.size();i++) {
				if(i==position){
					String s1 = elem.get(i).toString().replaceFirst("^0+(?!$)", "");
					elem.set(i, s1);
					}
			}
	}
	return one;
	}
	
protected List<List<Object>> removeLastZero(List<List<Object>> one,int position) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			for(int i =0;i<elem.size();i++) {
				if(i==position){
					String v = elem.get(i).toString();
					if(v.contains(".")){
					String s1 = elem.get(i).toString().replaceAll("\\.?0+$","");
					elem.set(i, s1);}
					}
			}
	}
	return one;
	}

protected List<List<Object>> editColumn(List<List<Object>> one,int position) throws IOException {
	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<elem.size();i++) {
			if(i==position){
				String v = elem.get(i).toString();
				if(v.equals("0 KG (0 EA)")){
				String s1 ="0 KG";
				elem.set(i, s1);}
				}
		}
}
return one;
}
	
/*protected List<List<Object>> removeLastZero1(List<List<Object>> one,int position) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			for(int i =0;i<elem.size();i++) {
				if(i==position && elem.get(position)!=null){
					String v = elem.get(i).toString();
					if(v.contains(".")){
					String s1 = elem.get(i).toString().replaceAll("\\.?0+$","");
					elem.set(i, s1);
					}
					}
				else if(elem.get(position)==null){
					elem.set(position, "");
					;
				}
			}
			
	}
	return one;
	}*/

protected List<List<Object>> appendValues(List<List<Object>> one,int position,String artname) throws IOException 
{	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<elem.size();i++) {
			if(i==position){
				String s1 = elem.get(i).toString().replace("+", " , ");
				if(s1.contains("KG"))
				{
					String[]p = splitString(s1, "KG");
					if(p[0].contains(".")){
						p[0]=p[0].trim().replaceAll("\\.?0+$","");}else{p[0]=p[0].trim();}
					if(p.length>1){
					if(p[1].isEmpty()){
						s1=p[0]+" KG";
					}else{
						s1=p[0]+" KG"+p[1];
					}}else{
						if(p.length==1){
					s1=p[0]+" KG";}else{
						s1=p[0]+" KG"+p[1];
					}}
				}
				if(s1.contains("CAR"))
				{
					if(s1.contains(",")){}else
					{
						String[]p = splitString(s1, "CAR");
						if(p[0].contains(".")){
							p[0]=p[0].trim().replaceAll("\\.?0+$","");}else{p[0]=p[0].trim();}
						if(p.length>1){
						if(p[1].isEmpty()){
							s1=p[0]+" CAR";
						}else{
							s1=p[0]+" CAR"+p[1];
						}}else{
							if(p.length==1){
						s1=p[0]+" CAR";}else{
							s1=p[0]+" CAR"+p[1];
						}}
					}
				}
				elem.set(i, s1);
				}
		}
}
	if(artname.equals("RandomWeighted") || artname.equals("Weighted") || artname.equals("multi location"))
	{
		
	}
return one;
}


	

protected List<List<Object>> appendTwoColumns(List<List<Object>> one,int row,int column1,int column2) throws IOException 
{	
	String a="";String b="";int count=0;
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); count++;
		if(count==row+1){
		for(int i =0;i<elem.size();i++) {
			if(i==column1){a=elem.get(column1).toString();
			b=elem.get(column2).toString();
				String s1 = a+" ("+b+")";
				elem.set(i, s1); break;
				}
		}
	}
}
return one;
}

protected List<List<Object>> commaSpaces(List<List<Object>> one,int position) throws IOException 
{	
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<elem.size();i++) {
			if(i==position){
				String s1 = elem.get(i).toString().replace(",", ", ");
				elem.set(i, s1);
				}
		}
}
return one;
}

protected List<List<Object>> removeColumnForSpecificRow(List<List<Object>> one,int row,String column) throws IOException 
{	int count=0;
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {count++;
		List<Object> elem = it.next(); 
		if(row==count){
			 String[] spInd = column.split(",");
		        for (int i = 0; i < spInd.length; i++) {
		        	elem.remove(Integer.parseInt(spInd[i]));
				}			
		}
		}
return one;
}
	
protected List<List<Object>> changeAlphacase(List<List<Object>> one,int position) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			for(int i =0;i<elem.size();i++) {
				if(i==position){
					String s1 = elem.get(i).toString().toLowerCase();
					elem.set(i, s1);
					}
			}
	}
	return one;
	}
	
	protected List<List<Object>> replaceElement(List<List<Object>> one) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			for(int i =0;i<elem.size();i++) {
				if(i==3){
					if(elem.get(i)==null){
						elem.set(i, "0.00");
					}
					else{
					String price = elem.get(i).toString();
					String pri = decimalFormat(price);
				     elem.set(i,pri);
					}
				}
				if(i==4){
				elem.set(4, "0.00");
				}
				if(i==5){
					Collections.replaceAll(elem, "ZDIS", "IS");
				}
			}
				
	}
	return one;
	}

	
	protected List<List<Object>> replaceElementNew(List<List<Object>> one,int pos) throws IOException {

	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<elem.size();i++) {
			if(i==pos){
				if(elem.get(i)==null){
					elem.set(i, "0.00");
				}
				else{
					String price = elem.get(i).toString();
					String pri=null;
					if(price.equals("0"))
					{
						pri="0.00";
					}
					else
					{
					pri = decimalFormat(price);
					}
					elem.set(i,pri);
				}
			}

		}

	}
	return one;
}

/*protected List<List<Object>> replaceStringtoInt(List<List<Object>> one,int pos) throws IOException {

	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<=elem.size();i++) {
			if(i==pos){
				String val = elem.get(i).toString();
				int a = Integer.parseInt(val);
				val=""+a;
				elem.set(i, val);
				}
			}
		}	
	return one;
}*/
	
	/*protected void ElementContainsTemp(List<List<Object>> one, List<List<Object>> two) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			for (Iterator<List<Object>> it1 = one.iterator(); it1.hasNext();) {
		        List<Object> elem = it.next();
		        List<Object> elem1 = it1.next();
		        int j = elem.size();
		        int k = elem1.size(),count = 0;
		        if(j==k){
		        if(elem.equals(elem1)){
		            Report_AddStep("testcase", "Application list matches with DB list", elem+"", elem1+"", "Pass");
		           }else{
		            Report_AddStep("testcase", "Application list mismatches with DB list", elem+"", elem1+"", "Fail");
		           }
		        }
		        }
			}
		 }*/
	
	protected void ElementContainsTemp(Multimap<String, String> scenarios,
			String testname, List<List<Object>> one, List<List<Object>> two) throws IOException {
			
			for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
				for (Iterator<List<Object>> it1 = two.iterator(); it1.hasNext();) {
			        List<Object> elem = it.next();
			        List<Object> elem1 = it1.next();
			        int j = elem.size();
			        int k = elem1.size(),count = 0;
			        if(j==k){
			        if(elem.equals(elem1)){
			        	scenarios.put(testname, "Application list matches with DB list;"
								+ elem + "" + ";" + elem1 + "" + ";Pass");
			            //Report_AddStep("testcase", "Application list matches with DB list", elem+"", elem1+"", "Pass");
			           }else{
			        	   scenarios.put(testname,
									"Application list not matches with DB list;" + elem + ""
											+ ";" + elem1 + "" + ";Fail");
			            //Report_AddStep("testcase", "Application list mismatches with DB list", elem+"", elem1+"", "Fail");
			           }
			        }
			        }
				}
			 }

/*protected void ElementContainsTempST(List<List<Object>> one, List<List<Object>> two) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			for (Iterator<List<Object>> it1 = one.iterator(); it1.hasNext();) {
		        List<Object> elem = it.next();
		        List<Object> elem1 = it1.next();
		        int j = elem.size();
		        int k = elem1.size(),count = 0;
		        if(j==k){
		        	System.out.println(elem);
		        	System.out.println(elem1);
		        if(elem.equals(elem1)){
		            Report_AddStep("testcase", "Application list matches with DB list", elem+"", elem1+"", "Pass");
		           }else{
		            Report_AddStep("testcase", "Application list mismatches with DB list", elem+"", elem1+"", "Fail");
		           }
		        }
		        }
			}
		 }*/

			
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
	
	public List<List<Object>> getValuesFromTables(List<WebElement> objectTable) { 
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
	            	if(tdElement.getText().isEmpty()){}else{
	            	//System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
	            	row.add(tdElement.getText());	            	
					col_num++;}
				}
	            
	            tableValues.add(row);
            row_num++;
        }

        for(int i=tableValues.size()-1;i>=0;i--)
        {
        	if(tableValues.get(i).isEmpty())
        	{
        		tableValues.remove(i);
        	}
        }
        return tableValues;
	}
	
	public List<List<Object>> getValuesFromTableST(List<WebElement> objectTable) { 
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
	            int count = td_collection.size();
	            row = new ArrayList<>(td_collection.size());
	            if(count==1)
	            {	            	
	            }
	            else
	            {
	            for(WebElement tdElement : td_collection)
	            {
	            	count++;
	            	//System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
	            	row.add(tdElement.getText());	            	
					col_num++;
				}
	            tableValues.add(row);
	            }
            row_num++;
        }
       
        return tableValues;
	}
	
	public List<List<Object>> convertDateFormat(List<WebElement> objectTable,int index) { //meenu    convert dd/mm/yyy -> yyyy-mm-dd
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
	            	String n= (row).toString();
	            	if(n.contains("/"))
		        	{            		
		        		String[] delRep = n.split("/");
						String year = delRep[2];
						String[] yr = delRep[2].split("]");
						year = yr[0];
						String month = delRep[1];
						String date = delRep[0];
						if(delRep[0].contains("["))
						{
							delRep[0]=delRep[0].substring(1);
						}
						String a = year+"-"+delRep[1]+"-"+ delRep[0];
		        		row.set(index,a);
		        	}
					col_num++;
				}	            
	            tableValues.add(row);
            row_num++;
            }       
        return tableValues;
        }
	
	
	
	
	public void fnClickFromTable(List<WebElement> objectTable,  String Source, int Col) {
		List<List<Object>> tableValues = new ArrayList<List<Object>>();
		List<Object> row = null;
		List<WebElement> tr_collection = objectTable;
		int row_Count = objectTable.size();
		System.out.println("Number Of Rows = " + row_Count);
		int row_num, col_num;
        row_num=1;
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            System.out.println("NUMBER OF COLUMNS="+td_collection.size());
	            col_num=0;
	            row = new ArrayList<>(td_collection.size());
	            for(WebElement tdElement : td_collection)
	            {
	            	if (tdElement.getText().toString().equalsIgnoreCase(Source)){
	            		
	            		//System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
	            		//row.add(tdElement.getText());
	            	}
					col_num++;
				}
	            
	            tableValues.add(row);
	            
            row_num++;
        }
	}	
	
	
	public String TimeDiff(String DBTime, String TimeDiff) throws ParseException {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date1 = timeFormat.parse(DBTime);
		Date date2 = timeFormat.parse(TimeDiff);

		long sum = date1.getTime()- date2.getTime();

		String date3 = timeFormat.format(new Date(sum));
		System.out.println("The sum is "+date3);
		return date3;
	}
	
	public boolean waitForFrameToLoad(WebDriver driver)
	{	
		 WebDriverWait wait = new WebDriverWait(driver, 100);
		 driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@id='ifamemobile']")));
		    // wait for jQuery to load
		    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		      @Override
		      public Boolean apply(WebDriver driver) {
		        try {
		          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
		        }
		        catch (Exception e) {
		          // no jQuery present
		          return true;
		        }
		      }
		    };
		    // wait for Javascript to load
		    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
		      @Override
		      public Boolean apply(WebDriver driver) {
		        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
		        .toString().equals("complete");
		      }
		    };

		  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
	public boolean waitForJSandJQueryToLoad(WebDriver driver1) {
        
	    WebDriverWait wait = new WebDriverWait(driver1, 100);
	   
	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver1) {
	        try {
	        	 setDriver(driver1);
	          return ((Long)((JavascriptExecutor)driver1).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          // no jQuery present
	          return true;
	        }
	      }
	    };
	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver1) {
	    	  setDriver(driver1);
	        return ((JavascriptExecutor)driver1).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}


	public void scrolltoElement(WebElement element,WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		String elementname = getElementLocator(element);
		je.executeScript("arguments[0].scrollIntoView();",element);
	}
	
public List<List<Object>> removeAndReplaceIndex(List<List<Object>> listone, String index) throws NumberFormatException, ParseException {
		
		for (Iterator<List<Object>> it = listone.iterator(); it
		            .hasNext();) {
		        List<Object> elem = it.next();
		        if (elem.isEmpty()) {
		            it.remove();
		        }
		        	String[] spInd = index.split(",");
		        //for (int i = 0; i < spInd.length; i++) {
		        	if(spInd[1].contains("divided")){
		        		String[] delRep = spInd[1].split("del");
		        		String elem1 = elem.get(Integer.parseInt(spInd[0])).toString();
		        		if(elem1.equalsIgnoreCase("nullvalue"))
		        		{
		        			elem.set(Integer.parseInt(spInd[0]), elem1);	
		        		}
		        		//String elem1 = elem.get(Integer.parseInt(spInd[0])).toString();
		        		else
		        		{
		        		elem.set(Integer.parseInt(spInd[0]), Integer.parseInt(elem1)/Integer.parseInt(delRep[1]));
		        		}
		        	}
		        	else if(spInd[1].equals("dateformat")){
		        		String elem1 = elem.get(Integer.parseInt(spInd[0])).toString();
			        	//String repElem = elem1.replace(delRep[0], delRep[1]);
			        	elem.set(Integer.parseInt(spInd[0]), formatDate(ConvertdateFormat(elem1),""));
		        	}
		        	
		        	else if(spInd[1].equals("dateformatHH:mm")){
		        		String elem1 = elem.get(Integer.parseInt(spInd[0])).toString();
			        	//String repElem = elem1.replace(delRep[0], delRep[1]);
			        	elem.set(Integer.parseInt(spInd[0]), formatDate(ConvertdateFormat(elem1),"HH:mm"));
		        	}
		        	else if(spInd[1].equals("splitspaces")){
		        		String elem1 = elem.get(Integer.parseInt(spInd[0])).toString();
			        	//String repElem = elem1.replace(delRep[0], delRep[1]);
			        	elem.set(Integer.parseInt(spInd[0]),elem1.substring(0, elem1.indexOf(" ")));
		        	}
		        	else{
			        	String[] delRep = spInd[1].split("del");
			        	String elem1 = (String) elem.get(Integer.parseInt(spInd[0]));
			        	String repElem = elem1.replace(delRep[0], delRep[1]);
			        	elem.set(Integer.parseInt(spInd[0]), repElem);
		        	}
		        	//elem.remove(Integer.parseInt(spInd[i]));
				//}
		        
		        System.out.println(elem);
		    }
		
		return listone;
	}
	
public Date ConvertdateFormat(String inVendorNum) throws ParseException {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	Date dtrosterdate = df.parse(inVendorNum);
	return dtrosterdate;
}

protected List<List<Object>> removeLastZero1(List<List<Object>> one,int position) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			List<Object> elem = it.next(); 
			for(int i =0;i<elem.size();i++) {
				if(i==position && elem.get(position)!=null){
					String v = elem.get(i).toString();
					if(v.contains(".")){
					String s1 = elem.get(i).toString().replaceAll("\\.?0+$","");
					elem.set(i, s1);
					}
					}
				else if(elem.get(position)==null){
					elem.set(position, "");
					;
				}
			}
			
	}
	return one;
	}

public int ConvertdatetimeFormat() throws ParseException {
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String dtrosterdate = sdf.format(date);	
	int hr = 0;
	if(dtrosterdate.contains(" "))
	{
		String[] dt=dtrosterdate.split(" ");
		String hms=dt[1];
		String[] time=hms.split(":");
		String hour = time[0];
		hr=Integer.parseInt(hour);
		hr=hr-1;
	}
	return hr;
}

	protected List<List<Object>> removeIndex(List<List<Object>> listone, String index) {
		
		for (Iterator<List<Object>> it = listone.iterator(); it
		            .hasNext();) {
		        List<Object> elem = it.next();
		        if (elem.isEmpty()) {
		            it.remove();
		        }
		        String[] spInd = index.split(",");
		        for (int i = 0; i < spInd.length; i++) {
		        	elem.remove(Integer.parseInt(spInd[i]));
				}
		        
		        System.out.println(elem);
		    }
		
		return listone;
	}
	
/*protected List getIndex(List<List<Object>> listone, String index) {
	List al = new ArrayList();
		for (Iterator<List<Object>> it = listone.iterator(); it
		            .hasNext();) {
		        List<Object> elem = it.next();
		        if (elem.isEmpty()) {
		            it.remove();
		        }
		        String[] spInd = index.split(",");
		        for (int i = 0; i < spInd.length; i++) {
		        	elem.get(Integer.parseInt(spInd[i]));
		        	al.add(elem);
				}
		        
		        System.out.println(elem);
		    }
		
		return al;
	}*/

protected List getIndex(List<List<Object>> one,int position) throws IOException {
	List al = new ArrayList();
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		for(int i =0;i<elem.size();i++) {
			if(i==position){
				String s = elem.get(i).toString();
				if(s.isEmpty()){}else{
				al.add(elem.get(i).toString());}
			}
		}
			
}
return al;
}
	
	/*public void ElementContains1(List<List<Object>> one, List<List<Object>> two) throws IOException {

		int count = 0;
		List<Object> elem2 = null;
		List<Object> elem3 = null;
		String[] elem1 = null;
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			boolean flag=false;
			elem2 = it.next();
			String[] a = new String[elem2.size()];
			elem0 = elem2.toArray(a);

			List<String> elem0 = new ArrayList<>(elem2.size());
			for (Object object : elem2) {
				elem0.add(Objects.toString(object, null));
			}



			for (Iterator<List<Object>> it1 = two.iterator(); it1.hasNext();) {
				elem3 = it1.next();

				List<String> strings = new ArrayList<>(elem3.size());
				for (Object object : elem3) {
					strings.add(Objects.toString(object, null));
				}
				String[] b = new String[strings.size()];
				elem1 = strings.toArray(b);

				//String[] b = new String[elem3.size()];
				//elem1 = elem3.toArray(b);

				if(Arrays.asList(elem0).contains(Arrays.asList(elem1))){
					flag=true;
					count=count+1;
					break;
				}
			}
			if(flag){
				//scenarios.put(testname,"Application list matches with DB list;"+ elem2+"" +";"+ elem3+""+ ";Pass");
				Report_AddStep("testcase", "Application list matches with DB list", elem2+"", elem3+"", "Pass");
			}else{
				//scenarios.put(testname,"Application list not matches with DB list;"+ elem2+"" +";"+ elem3+""+ ";Fail");
				Report_AddStep("testcase", "Application list NOT matches with DB list", elem2+"",elem3+ "", "Fail");
			}
		}
		if(count==one.size()){
			//scenarios.put(testname,"Application list matches with DB list;"+ "Count :"+count +";"+ "Count : "+one.size() +";Pass");
			Report_AddStep("testcase", "Application list matches with DB list", "Count : " + count,"Count : " + one.size(), "Pass");
		}else{
			//scenarios.put(testname,"Application list NOT matches with DB list;"+ "Count :"+count +";"+ "Count : "+one.size() +";Fail");
			Report_AddStep("testcase", "Application list NOT matches with DB list", "Count : " + count,"Count : " + one.size(), "Fail");
		}


	}*/

public void ElementContains1(String cName,String mName,ExtentTest extLogger,WebDriver driver, List<List<Object>> one, List<List<Object>> two)
		throws IOException {
	htmlToExtent(cName,mName,extLogger,driver,"Application list and DB list;" + one + ""+ ";" + two + "" + ";Info");
	//added
	List<List<Object>> a = null;List<List<Object>> c = null;
	int size = one.size();int size1=two.size();
	if(size==size1 || size>size1){
		a=two;c=one;
	}else if(size<size1){
		a=one;c=two;
	}

	int count = 0;
	List<Object> elem2 = null;
	List<Object> elem3 = null;
	String[] elem1 = null;
	for (Iterator<List<Object>> it = a.iterator(); it.hasNext();) {
		boolean flag = false;
		elem2 = it.next();
		/*
		 * String[] a = new String[elem2.size()]; elem0 = elem2.toArray(a);
		 */

		List<String> elem0 = new ArrayList<>(elem2.size());
		for (Object object : elem2) {
			elem0.add(Objects.toString(object, null));
		}

		for (Iterator<List<Object>> it1 = c.iterator(); it1.hasNext();) {
			elem3 = it1.next();

			List<String> strings = new ArrayList<>(elem3.size());
			for (Object object : elem3) {
				strings.add(Objects.toString(object, null));
			}
			String[] b = new String[strings.size()];
			elem1 = strings.toArray(b);

			// String[] b = new String[elem3.size()];
			// elem1 = elem3.toArray(b);

			if (Arrays.asList(elem0).contains(Arrays.asList(elem1))) {
				flag = true;
				count = count + 1;
				break;
			}
		}
		if (flag) {
			htmlToExtent(cName,mName,extLogger,driver,
					"Application list matches with DB list;" + elem2 + ""
							+ ";" + elem3 + "" + ";Pass");
			// Report_AddStep("testcase",
			// "Application list matches with DB list", elem2+"", elem3+"",
			// "Pass");
		} else {
			htmlToExtent(cName,mName,extLogger,driver,
					"Application list not matches with DB list;" + elem2
					+ "" + ";" + elem3 + "" + ";Fail");
			// Report_AddStep("testcase",
			// "Application list NOT matches with DB list", elem2+"",elem3+
			// "", "Fail");
		}
	}
	if (count == a.size()) {
		htmlToExtent(cName,mName,extLogger,driver, "Application list matches with DB list;"
				+ "Count :" + count + ";" + "Count : " + a.size()
				+ ";Info");
		// Report_AddStep("testcase",
		// "Application list matches with DB list", "Count : " +
		// count,"Count : " + one.size(), "Pass");
	} else {
		htmlToExtent(cName,mName,extLogger,driver,
				"Application list NOT matches with DB list;" + "Count :"
						+ count + ";" + "Count : " + a.size() + ";Info");
		// Report_AddStep("testcase",
		// "Application list NOT matches with DB list", "Count : " +
		// count,"Count : " + one.size(), "Fail");
	}

}

public void ElementContains(String cName,
		String mName, ExtentTest extLogger, WebDriver driver,List<List<Object>> one, List<List<Object>> two)
		throws IOException {
	int count = 0;
	List<Object> elem2 = null;
	List<Object> elem3 = null;
	String[] elem1 = null;
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		boolean flag = false;
		elem2 = it.next();
		/*
		 * String[] a = new String[elem2.size()]; elem0 = elem2.toArray(a);
		 */

		List<String> elem0 = new ArrayList<>(elem2.size());
		for (Object object : elem2) {
			elem0.add(Objects.toString(object, null));
		}

		for (Iterator<List<Object>> it1 = two.iterator(); it1.hasNext();) {
			elem3 = it1.next();

			List<String> strings = new ArrayList<>(elem3.size());
			for (Object object : elem3) {
				strings.add(Objects.toString(object, null));
			}
			String[] b = new String[strings.size()];
			elem1 = strings.toArray(b);

			// String[] b = new String[elem3.size()];
			// elem1 = elem3.toArray(b);

			if (Arrays.asList(elem0).contains(Arrays.asList(elem1))) {
				flag = true;
				count = count + 1;
				break;
			}
		}
		if (flag) {
			htmlToExtent(cName,mName,extLogger,driver,
					"Application list matches with DB list;" + elem2 + ""
							+ ";" + elem3 + "" + ";Pass");
			// Report_AddStep("testcase",
			// "Application list matches with DB list", elem2+"", elem3+"",
			// "Pass");
		} else {
			htmlToExtent(cName,mName,extLogger,driver,
					"Application list not matches with DB list;" + elem2
							+ "" + ";" + elem3 + "" + ";Fail");
			// Report_AddStep("testcase",
			// "Application list NOT matches with DB list", elem2+"",elem3+
			// "", "Fail");
		}
	}
	if (count == one.size()) {
		htmlToExtent(cName,mName,extLogger,driver,"Application list matches with DB list;"
				+ "Count :" + count + ";" + "Count : " + one.size()
				+ ";Pass");
		// Report_AddStep("testcase",
		// "Application list matches with DB list", "Count : " +
		// count,"Count : " + one.size(), "Pass");
	} else {
		htmlToExtent(cName,mName,extLogger,driver,
				"Application list NOT matches with DB list;" + "Count :"
						+ count + ";" + "Count : " + one.size() + ";Info");
		// Report_AddStep("testcase",
		// "Application list NOT matches with DB list", "Count : " +
		// count,"Count : " + one.size(), "Fail");
	}

}


/*protected void ElementContains(List<List<Object>> one, List<List<Object>> two) throws IOException {
		
		for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
			for (Iterator<List<Object>> it1 = two.iterator(); it1.hasNext();) {
		        List<Object> elem = it.next(); //db
		        List<Object> elem1 = it1.next(); //appln
		        int j = elem.size();
		        int k = elem1.size(),count = 0;
		        if(j==k){
		      for(int i =0;i<elem.size();i++) {
		    		  if(elem.get(i).toString().equals(elem1.get(i).toString())){
		    			  count++;
		    		  }
		      }
		        }
		      if(count==k){
		    	  Report_AddStep("testcase", "Application list matches with DB list", elem+"", elem1+"", "Pass");
	           }else{
	            Report_AddStep("testcase", "Application list mismatches with DB list", elem+"", elem1+"", "Fail");
	           }
		      
		      
		        }
		        if(elem.contains(elem1)){
		            Report_AddStep("testcase", "", elem+"", elem1+"", "Pass");
		           }else{
		            Report_AddStep("testcase", "", elem+"", elem1+"", "Fail");
		           }
			}
		 }*/
	
	protected List<List<Object>> removeEmptyArray(List<List<Object>> listone) {
		
		for (Iterator<List<Object>> it = listone.iterator(); it
		            .hasNext();) {
		        List<Object> elem = it.next();
		        if (elem.isEmpty()) {
		            it.remove();
		        }
		        elem.remove("");
		        System.out.println(elem);
		    }
		
		return listone;
	}
	
protected List<List<Object>> removeEmptyRow(List<List<Object>> listone) {
		
		for (Iterator<List<Object>> it = listone.iterator(); it
		            .hasNext();) {
			int count=0;
		        List<Object> elem = it.next();
		        for(int i=0;i<elem.size();i++)
		        {
					if(elem.get(i).toString().isEmpty()){
						count++;
					}
		        }
		        if (count == elem.size()) {
		            it.remove();
		        }
		        //elem.remove("");
		        System.out.println(elem);
		    }
		
		return listone;
	}
	
	public int doubleToInt(String value){     //pavi
		double d= Double.parseDouble(value);
		int num = (int)d;
		return num;
		
	}
	public List<List<Object>> doubleToInt1(List<List<Object>> one,int position){
	for (Iterator<List<Object>> it = one.iterator(); it.hasNext();) {
		List<Object> elem = it.next(); 
		
		
		for(int i =0;i<elem.size();i++) {
			if(i==position){
			String s = elem.get(i).toString();
			if(s.contains("."))
			{
				double d= Double.parseDouble(s);
				int num = (int)d;
				elem.set(i, num);
			}
			}
			
			}				
			}
return one;
	}
	
	
	 public static boolean isDialogPresent(WebDriver driver) {
	        try {
	            driver.getTitle();
	            return true;
	        } catch (UnhandledAlertException e) {
	            // Modal dialog showed
	            return false;
	        }
	    }
	 

		public String[] splitString(String text,String split){
			String[] parts = text.split(split);
			return parts;
			
		}
		
		public String decimalFormat(String text){
			double d1= Double.parseDouble(text);
			DecimalFormat format = new DecimalFormat("0.#");
			System.out.println("soh decimal::::"+format.format(d1));
			return format.format(d1);
			
		}

public String decimalFormat1(String text){
			double d1= Double.parseDouble(text);
			DecimalFormat format = new DecimalFormat("0.#####");
			System.out.println("soh decimal::::"+format.format(d1));
			return format.format(d1);
			
		}

public String ThreedecimalFormat(String text){
	double d1= Double.parseDouble(text);
	DecimalFormat format = new DecimalFormat("0.###");
	System.out.println("soh decimal::::"+format.format(d1));
	return format.format(d1);
	
}
	
	public List<List<Object>> StringToListCreation(String str1){
		List<Object> listm = new ArrayList<>();
		String[] lisStrings = str1.split(":");
		for (int i = 0; i < lisStrings.length; i++) {
			listm.add(lisStrings[i]);
		}
		List<List<Object>> list5 = new ArrayList<List<Object>>();
		list5.add(listm);
		return list5;
	}
	
	public void verticalinternalscroll(WebElement element,WebDriver driver){ 
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public boolean isDecimalEquals(String string1, String string2){
		boolean isequal = false;
		Float a = Float.parseFloat(string1);
		Float b = Float.parseFloat(string2);
		Float c = a-b;
		/*long factor = (long) Math.pow(10, 1);
	    c = c * factor;
	    long tmp = Math.round(c);*/
		String temp = String.valueOf(c);
		if(temp.equals("0") || temp.equals("0.0")|| temp.equals("0.00")||temp.equals("0.000") || c<=0.5)
			isequal = true;
		else
			isequal = false;
			
		return isequal;
	}
	
	
	 
	public void scrolltoParticularElement(JavascriptExecutor je,WebElement element) {

	je.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public int generateRandomNumber(int min, int max)
	{
		Random random = new Random();
		int randomNumber = random.nextInt(max + 1 - min) + min;
		return randomNumber;
	}
	
	public List<Integer> generateMultiplRandomNumber(int min, int max, int multiple)
	{
		 ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i=min; i<=max; i++) {
	            list.add(new Integer(i));
	        }
	        Collections.shuffle(list);
	        for (int i=0; i<multiple; i++) {
	            System.out.println(list.get(i));
	        }
	        
	        return list;

	}

	public List<WebElement> prepareListWebElementWithDynamicXpathWithString(String xpathValue, String s,WebDriver driver) {
		return driver.findElements(By.xpath(xpathValue.replace("dynamic",s)));
	}
	
	/***** Extent Report Starts*************/
	  
	 public static String captureScreenshot(WebDriver driver){	
		
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String imgName= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			String ssLoc=TestContext.getStringProperty("reportPath")+"//screenshots//"+imgName+".png";		
			try {
				
				FileUtils.copyFile(scrFile, new File(ssLoc));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			ssLoc="./"+"Screenshots//"+imgName+".png";
			return ssLoc;
		}
		
		 
	 
	public static Multimap<String, String> writeExtentReportStep1(String status,String desc,String methodName, ExtentTest extLogger,String cName,String mName,WebDriver driver){
		 if(status.equalsIgnoreCase("Pass")){
			 extLogger.log(LogStatus.PASS,desc);
		 }else if (status.equalsIgnoreCase("Warning")){
			 extLogger.log(LogStatus.WARNING,desc);
			 if(extentList.get(cName).isEmpty()){
				 extentList.put(cName, mName);
			 }else if(!checkList(extentList.get(cName),mName)){
				 extentList.put(cName, mName);
			 }
		 }else if (status.equalsIgnoreCase("Fail")){
			 extLogger.log(LogStatus.FAIL,desc+extLogger.addScreenCapture(captureScreenshot(driver)));
			 if(extentList.get(cName).isEmpty()){
				 extentList.put(cName, mName);
			 }else if(!checkList(extentList.get(cName),mName)){
				 extentList.put(cName, mName);
			 }
		 }else if(status.equalsIgnoreCase("INFO")){
			 if(desc.equals("Iteration terminated due to error"))
			 {
				// extLogger.log(LogStatus.INFO,desc+extLogger.addScreenCapture(captureScreenshot(driver)));
			 }else{
			 extLogger.log(LogStatus.INFO,desc);}
		 }
		 return extentList;
	 }

	 
	 public static void htmlToExtent(String cName,String mName,ExtentTest extLogger,WebDriver driver,String value){
		
		 String[] valueList=value.split(";");
		 String desc="";
		 if(!valueList[1].isEmpty()){
			 desc=valueList[0]+"<br />Db Value: <br />"+ valueList[1]+"<br />Application Value: <br />"+valueList[2];
		 }else{
			 desc=valueList[0];
		 }
		
		 writeExtentReportStep1(valueList[3],desc,methodName,extLogger,cName,mName,driver); 
		 
		 
	 }
	 
	public String getDateAndTime(){		
			return (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
			
		}
	
	public static boolean checkList(Collection<String> collection, String searchValue){
		for(String str: collection)
		{ if(str.trim().contains(searchValue)) 
		return true; 
		} return false;
	}
	
	public static boolean writeException(String cName,String mName, ExtentTest extLogger,WebDriver driver,Exception e){
		boolean isSuccess=false;
		Error e1 = new Error(e.getMessage());
	    e1.setStackTrace(e.getStackTrace());
		htmlToExtent(cName,mName,extLogger,driver,"Exception Occured :" +e.getClass().getSimpleName()+";;;FAIL");	
		htmlToExtent(cName,mName,extLogger,driver,"Still some scripts needs to be executed;;;Info");
		isSuccess=true;
		e.printStackTrace();
		return isSuccess;
	}

	 /***** Extent Report ends*************/

public String doubleToString(Double value, Double value1){   
String NewValue = Double.toString((value*value1));
return NewValue;
}

public String formatDatewithValueadded(Date date, String format, int days){
	Calendar Cal = Calendar.getInstance();
	Cal.add(Calendar.DATE, days);
	Date newDate = Cal.getTime();
	return new SimpleDateFormat(format).format(newDate);
	}

public String getHiddenTextUsingJs(WebDriver driver1,WebElement element)
{
JavascriptExecutor js = (JavascriptExecutor)driver1;
String SalesOrg = js.executeScript("return arguments[0].value;", element).toString();
return SalesOrg;
}
}










