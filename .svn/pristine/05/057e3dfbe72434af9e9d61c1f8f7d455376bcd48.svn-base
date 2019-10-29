/**
 * This class acts as a Listener. It is invoked before each test method
 * It performs the specified operations on Test start, test success, test failure and test skipped
 */
package au.wow.ngbo.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBaseListener extends TestListenerAdapter {

	private Logger log;
	private CustomExtentReports extreport;
	
	@Override
	public void onTestStart(ITestResult result) {
		super.onTestStart(result);
		log=LogManager.getLogger(result.getTestClass().getRealClass());
		log.info("====================================");
		log.info("\t\tTestStarted\t\t");
		log.info("====================================");
		log.info("Starting test: " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
		String filename = tr.getMethod().getMethodName();
//		System.out.println("Screenshot name: " + filename);
		log.error("Test "+ filename+" failed: " + tr.getThrowable().getLocalizedMessage());
		tr.setAttribute("isFail", "true");		
				
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		
		super.onTestSuccess(tr);
		log.info("====================================");
		log.info("\t\tTestCompleted\t\t");
		log.info("====================================");
		log.info("Test Success: " + tr.getMethod().getMethodName());
		extreport = (CustomExtentReports) tr.getTestContext().getAttribute("Customreports");
		ExtentTest test = extreport.getExtentTest();
		test.log(LogStatus.PASS, tr.getMethod().getMethodName()+ " Passed");
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSkipped(tr);
		tr.setAttribute("isFail", "true");	
		log.info("Test Skipped: " + tr.getMethod().getMethodName());
		
	}
	
	
	
	        
}
