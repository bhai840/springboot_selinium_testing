package au.wow.ngbomain.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import com.google.common.base.Splitter;

import au.wow.ngbo.utils.TestBase;

public class CommonFunctions extends TestBase{
	List<List<Object>> results;
	
	/**
	 * Returns promotion weekdate to return the articles from DB 
	 * @param promofor
	 * @return promotion weekdate
	 */
	public String getWeekDateForPromotion(String promofor){
		String returndate=null;
		Calendar cal=null;
		switch (promofor) {
		case "Current Week":
			returndate=formatDate(new Date());
			break;
		case "Next Week":
			returndate=formatDate(dateAdd().getTime());
			break;
		case "Two Weeks Out":
			cal = dateAdd();
			cal.add(Calendar.DATE, 7);
			returndate=formatDate(cal.getTime());
			break;
		case "Three Weeks Out":
			cal = dateAdd();
			cal.add(Calendar.DATE, 14);
			returndate=formatDate(cal.getTime());
			break;
		case "Four Weeks Out":
			cal = dateAdd();
			cal.add(Calendar.DATE, 21);
			returndate=formatDate(cal.getTime());
			break;
		case "Five Weeks Out":
			cal = dateAdd();
			cal.add(Calendar.DATE, 28);
			returndate=formatDate(cal.getTime());
			break;
		default:
			break;
		}
		System.out.println("Before Passing to query: " + returndate);
		return returndate;
	}
	
	/**
	 * Calculating weekday and adding days to retrieve the nearest wednesday
	 * @return date after adding x days
	 */
	
	public String getCurrentDate(){ //meenu				
		String returndate=formatDate(new Date());
		System.out.println("Before Passing to query: " + returndate);
		return returndate;
	}
	
	public String getMondayDate(){ //meenu				
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.add(Calendar.DATE,7);
		DateFormat df=new SimpleDateFormat("dd/mm/yyyy");
		System.out.println(df.format(c.getTime()));
		String da = df.format(c.getTime()).toString();
		return da;
	}
	
	public String getUpcomingSundayDate(){ //meenu				
		DateFormat df=new SimpleDateFormat("dd/mm/yyyy");
		Calendar c=Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
		c.add(Calendar.DATE,7);
		System.out.println(df.format(c.getTime()));
		String da = df.format(c.getTime()).toString();
		return da; 
	}
	
	public String getBeforeDateFromCurrentDate(){ //meenu	
		String output=null;
		
		String returndate=formatDate(new Date());
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		output = formatDate(cal.getTime()).toString();
		return output;
	}
	
	public String addDaystoCurrentDate(int i) throws ParseException{ //meenu
		String output=null;
		Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());		
		c.add(Calendar.DATE, i); 
		output = formatDate(c.getTime()).toString();
		String[] datee = splitString(output, "/");
		if(datee[0].length()==1)
		{
			datee[0] = "0"+datee[0];
		}
		if(datee[1].length()==1)
		{
			datee[1] = "0"+datee[1];
		}
		output = datee[0]+"/"+datee[1]+"/"+datee[2];
		System.out.println(output);
		return output;
	}
	
	public Calendar dateAdd(){
		Calendar date = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		int currWeekDay = date.get(Calendar.DAY_OF_WEEK);
		System.out.println("Current Week day is"+currWeekDay);
		int diff = currWeekDay - Calendar.WEDNESDAY;
		int add = 0;
		System.out.println("diff>>>>>>>>>" + diff);
		if(diff<0){
			add = -diff;
		}else if(diff>0){
			add=7-diff;
		}else if(diff==0){
			add=7;
		}
		date.add(Calendar.DATE, add);
		System.out.println("After adding: " + date.toString());
		return date;
	}
	
	public Calendar dateAddTue(){
		Calendar date = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		int currWeekDay = date.get(Calendar.DAY_OF_WEEK);
		System.out.println("Current Week day is"+currWeekDay);
		int diff = currWeekDay - Calendar.TUESDAY;
		int add = 0;
		System.out.println("diff>>>>>>>>>" + diff);
		if(diff<0){
			add = -diff;
		}else if(diff>0){
			add=7-diff;
		}else if(diff==0){
			add=7;
		}
		date.add(Calendar.DATE, add);
		System.out.println("After adding: " + date.toString());
		return date;
	}
	
	
	/**
	 * Formats the given date to dd/MM/yyyy format
	 * @param date
	 * @return
	 */
	public String formatDate(Date date){		
		return new SimpleDateFormat("dd/MM/yyyy").format(date);

	}
	
	public String AddDate(Date nDate,int daytoAdd) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(nDate); // Now use today date.
		c.add(Calendar.DATE, daytoAdd); // Adding 5 days
		return sdf.format(c.getTime());
	}
	/**
	 * Retrieves article num from RC DB
	 * @param query
	 * @return Articlenumber
	 * @throws SQLException 
	 */
	/*public String getTestDataFromDB(String query) throws SQLException{
		log.info("--------------Query the tables for the article-----------");
		results = sql.executeQuery(getContext(), query);
		if(results!=null){
			return (String) results.get(0).get(0);
		}else{
			throw new SkipException("No data available in RC for the matching criteria");
		}
	}*/

	public Date ConvertdateFormat(String inVendorNum) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		Date dtrosterdate = df.parse(inVendorNum);
		return dtrosterdate;
	}
	
	public String ConvertdateFormat() throws ParseException { //meenu
		String dates = getCurrentDate();
		if(dates.contains("/"))
		{
			String[] dt=dates.split("/");
			String date=dt[0];
			String month = dt[1];
			String year=dt[2];
			dates=dt[2]+"-"+dt[1]+"-"+dt[0];
		}
		return dates;
	}
	
	public String ConvertdateFormat(int i) throws ParseException { //meenu
		String dates = addDaystoCurrentDate(i);
		if(dates.contains("/"))
		{
			String[] dt=dates.split("/");
			String date=dt[0];
			String month = dt[1];
			String year=dt[2];
			dates=dt[2]+"-"+dt[1]+"-"+dt[0];
		}
		return dates;
	}
	public String ConvertdateFormatfordb(int i) throws ParseException { //pavi
		String dates = addDaystoCurrentDate(i);
		if(dates.contains("/"))
		{
			String[] dt=dates.split("/");
			String date=dt[0];
			String month = dt[1];
			String year=dt[2];
			dates=dt[2]+dt[1]+dt[0];
		}
		return dates;
	} 
	
	public Date ConvertdateFormatddmmyy(String from_date) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dtrosterdate = df.parse(from_date);
		return dtrosterdate;
	}

	public String getWeekDateForPromotionTue(String promofor){
		String returndate=null;
		Calendar cal=null;
		switch (promofor) {
		case "Current Week":
			returndate=formatDate(new Date());
			break;
		case "Next Week":
			returndate=formatDate(dateAddTue().getTime());
			break;
		case "Two Weeks Out":
			cal = dateAdd();
			cal.add(Calendar.DATE, 7);
			returndate=formatDate(cal.getTime());
			break;
		case "Three Weeks Out":
			cal = dateAdd();
			cal.add(Calendar.DATE, 14);
			returndate=formatDate(cal.getTime());
			break;
		case "Four Weeks Out":
			cal = dateAdd();
			cal.add(Calendar.DATE, 21);
			returndate=formatDate(cal.getTime());
			break;
		case "Five Weeks Out":
			cal = dateAdd();
			cal.add(Calendar.DATE, 28);
			returndate=formatDate(cal.getTime());
			break;
		default:
			break;
		}
		System.out.println("Before Passing to query: " + returndate);
		return returndate;
	}
	
	/**
	 * @param results
	 * @return
	 */
	public int RandomFromDB(List<List<Object>> results) {
		int max = results.size();
		int min=1;
		Random rand=new Random();
		int num = rand.nextInt((max+1) - min) + min;
		return num-1;
	}
	
	
	
	public Object[] fnVendorWarHouNumber(List<List<Object>> results, String stVenWar) throws IOException{
		List<Object> result=null;
		for(int i=0;i<=results.size()-1;i++)
		{
			if(results.get(i).get(4).toString().length()>=7 && stVenWar.equalsIgnoreCase("Vendor") &&
					results.get(i).get(4).toString().length()!=1)
			{
				result = results.get(i);

				Report_AddStep("testcase", "Vendor Details "+ result,"","", "Pass");
				System.out.println("Into vendor functionality");
				break;
			}
			else if(results.get(i).get(4).toString().length()<=5 && stVenWar.equalsIgnoreCase("WareHouse") &&
					results.get(i).get(4).toString().length()!=1)
			{
				result =results.get(i);
				Report_AddStep("testcase", "WareHouse Details "+ result,"","", "Pass");
				break;
			}
			else{
				result = results.get(i);
			}
		}
		return result.toArray();
	}
	
	
	public List<WebElement> prepareWebElementWithDynamicXpath (String xpathValue, String substitutionValue ) {
		return getDriver1().findElements(By.xpath(xpathValue.replace("dynamic", substitutionValue)));
	}
	
	public WebElement prepareWebElementWithDynamicXpathWithInt(String xpathValue, int i) {
		return getDriver1().findElement(By.xpath(xpathValue.replace("dynamic", ""+i)));

	}
	
	public String ConvertdateFormatWithoutHiphen() throws ParseException { //meenu
		String dates = getCurrentDate();
		if(dates.contains("/"))
		{
			String[] dt=dates.split("/");
			String date=dt[0];
			String month = dt[1];
			String year=dt[2];
			dates=dt[2]+dt[1]+dt[0];
		}
		return dates;
	}
	
	public String ConvertdateFormatWithoutHiphen1() throws ParseException { //meenu
		String dates = getBeforeDateFromCurrentDate();
		if(dates.contains("/"))
		{
			String[] dt=dates.split("/");
			String date=dt[0];
			String month = dt[1];
			String year=dt[2];
			dates=dt[2]+dt[1]+dt[0];
		}
		return dates;
	}
	
	public String ConvertdateFormat1(int i) throws ParseException { 
		String dates = addDaystoCurrentDate(i);
		if(dates.contains("/"))
		{
			String[] dt=dates.split("/");
			String date=dt[0];
			String month = dt[1];
			String year=dt[2];
			dates=dt[2]+dt[1]+dt[0];
		}
		return dates;
	}
	
	public String weekStartFormatWithoutHiphen(String stDate) throws ParseException { //meenu
//		String dates = getMondayDate();
		if(stDate.contains("-"))
		{
			String[] dt=stDate.split("-");
			String date=dt[0];
			String month = dt[1];
			String year=dt[2];
			stDate=dt[0]+dt[1]+dt[2];
		}
		return stDate;
	}
	
	public String weekUpcomingSundayFormatWithoutHiphen(String edDate) throws ParseException { //meenu
//		String dates = getUpcomingSundayDate();
		if(edDate.contains("-"))
		{
			String[] dt=edDate.split("-");
			String date=dt[0];
			String month = dt[1];
			String year=dt[2];
			edDate=dt[0]+dt[1]+dt[2];
		}
		return edDate;
	}
	
	public String ConvertdateFormatRTV(int i) throws ParseException { 
		String dates = addDaystoCurrentDate(i);
//		if(dates.contains("/"))
//		{
//			String[] dt=dates.split("/");
//			String date=dt[0];
//			String month = dt[1];
//			String year=dt[2];
//			dates=dt[2]+dt[1]+dt[0];
//		}
		return dates;
	}
	
}




