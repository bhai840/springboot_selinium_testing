package au.wow.ngbomain.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineBookingobjects {

	@FindBy(xpath ="//span[text()='Continue']")
	public WebElement CentralManagement;
	


	@FindBy(xpath ="//*[@id=\\\"cssmenu\\\"]/ul/li[3]/a")
	public WebElement StockArrival;

	@FindBy(xpath ="//*[@id=\\\"cssmenu\\\"]/ul/li[3]/ul/li[1]/a")
	public WebElement NotPresent;

	@FindBy(xpath ="//*[@id=\\\"stockArrival2\\\"]")
	public WebElement Article;

	@FindBy(xpath ="//*[@id=\"articleNumber\"]")
	public WebElement Articlenum;


	@FindBy(xpath ="(//*[contains(@class,'apptTimeBtn') and contains(text(),'12:30pm')])[1]")
	public WebElement TimeSlot;
	
	@FindBy(xpath ="(//*[@class='bk-dr-name bk-prac-only'])")
	public WebElement BookAppointmentPage;

	@FindBy(xpath ="//*[@id='booking-continue']")
	public WebElement BookThisAppointmentButton;



	@FindBy(xpath ="(//a[contains(@href,'https://baileynelson.com.au/pages/')])[1]")
	public WebElement Direct;

	/*@FindBy(xpath ="//a[contains(@href,'https://baileynelson.com.au/pages/') and @id='bailey-nelson-book-an-eye-test']")
	public WebElement Direct;*/

	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Myself')])[1]")
	public WebElement Myself;

	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'First Time')])[1]")
	public WebElement FirstTime;

	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Return Patient')])[1]")
	public WebElement ReturnPatient;


	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Bulk Billed Eye Exam')])[1]")
	public WebElement BulkBilledEye;
	
	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Bulk Billed Eye Exam')])[2]")
	public WebElement BulkBilledEyeReturn;
	

	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Contact Lens Fit')])[1]")
	public WebElement ContactLensFit;
	
	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Contact Lens Fit')])[2]")
	public WebElement ContactLensFitReturn;
	
	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Contact Lens Aftercare - $35.00')])[1]")
	public WebElement ContactLensAftercare;
	
	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Contact Lens Aftercare - $35.00')])[2]")
	public WebElement ContactLensAftercareReturn;
	
	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Bulk Billed Eye Exam with Ultra-wide Retinal Photography - $50.00')])[1]")
	public WebElement BBUltrawide;
	

	//@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Bulk Billed Eye Exam')])[2]")
	//public WebElement BulkBilledEyeReturn;

	@FindBy(xpath ="(//*[@class='continue-button btn-icon btn-icon-down'])[1]")
	public WebElement Continue;

	@FindBy(xpath ="//*[@id='firstname']")
	public WebElement MyFirstName;
	
	@FindBy(xpath ="//*[@id='booker_firstname']")
	public WebElement BookerFirstName;

	@FindBy(xpath ="//*[@id='lastname']")
	public WebElement MyLastname;
	
	@FindBy(xpath ="//*[@id='booker_lastname']")
	public WebElement BookerLastname;
	

	@FindBy(xpath ="//*[@id='preferred_name']")
	public WebElement MyPreferredName;

	@FindBy(xpath ="//*[@id='mobile']")
	public WebElement MyMobileNumber;
	
	@FindBy(xpath ="//*[@id='booker_mobile']")
	public WebElement BookerMobileNumber;
	

	@FindBy(xpath ="//*[@id='email']")
	public WebElement MyEmailID;
	
	@FindBy(xpath ="//*[@id='booker_email']")
	public WebElement BookerEmailID;
	

	@FindBy(xpath ="//*[@id='address']")
	public WebElement StreetAddress;

	@FindBy(xpath ="//*[@id='suburb']")
	public WebElement MySubUrb;

	@FindBy(xpath ="//*[@class='scrolling-container']/following::ul/li[1]")
	public WebElement FirstEntry;

	////*[@class='scrolling-container']/following::ul/li[1]
	@FindBy(xpath ="(//*[@class='ui-menu-item'])[1]")
	public WebElement MyFirstSuburb;

	@FindBy(xpath ="//*[@id='birthday']")
	public WebElement BirthDate;

	@FindBy(xpath ="//*[@id='validation-modal']/div")
	public WebElement ValidationMessage1;

	@FindBy(xpath ="(//*[@class='book-appointment'])[1]")
	public WebElement BookAppointment;
	
	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Someone else')])[1]")
	public WebElement SomeoneElse;
	
	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Me')])[1]")
	public WebElement CommunicationMe;
	
	//@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Patient')])")
	//public WebElement CommunicationPatient;
	
	@FindBy(xpath ="//*[@value='patient']")
	public WebElement CommunicationPatient;
	
	@FindBy(xpath ="(//*[contains(@class,'togglebutton') and contains(text(),'Both')])[1]")
	public WebElement CommunicationBoth;

	@FindBy(xpath ="//*[@id='firstname']/div")
	public WebElement PatientFirstName;

	@FindBy(xpath ="//*[@id='lastname']/div")
	public WebElement PatientLastName;
	
	@FindBy(xpath ="//*[@id='preferred_name']/div")
	public WebElement PatientPreferredName;
	
	@FindBy(xpath ="(//*[@class='book-appointment'])")
	public WebElement ConfirmBookAppointment;
	
	@FindBy(xpath ="(//*[@class='bk-alert'])")
	public WebElement AlertMessage;

	@FindBy(xpath ="(//*[@id='validation-modal']/div[1]/div[2]/button")
	public WebElement OkGotIt;
	
	@FindBy(xpath ="(//*[contains(@class,'errors') and contains(text(),'Please enter a valid Australian mobile number (04XX XXX XXX) and email address.')])")
	public WebElement PhoneNoErrorMsg;

	//@FindBy(xpath ="(//div[@class='box-border clearfix form-section about-section'])")
	//public WebElement PhoneNoErrorMsg;
	
	//driver.FindElement(By.XPath("//div[@class='item-inner']/span[@class='title']"));
	
	//@FindBy(xpath ="(//*[contains(@id='validation-modal') and contains(@class='dialog') and contains(text(),'Ok, got it')])")
	//public WebElement OkGotIt;
	
	//(xpath ="(//*[contains(@id='validation-modal') and contains(@class='dialog-buttons') and contains(text(),'Ok, got it')])")
	//@FindBy(xpath ="//*[@id='validation-modal']")
	//public WebElement OkGotIt;

	

	//*[@id="validation-modal"]/div



















	@FindBy(xpath ="//*[@class='btn btn--large btn--square uppercase book-appointment small--hide medium--hide']")
	public List<WebElement> StoresList;


	@FindBy(xpath ="//*[@id='autocomplete']")
	public WebElement PostCode1;

	@FindBy(xpath ="//*[contains(text(),'Username: ')]/a")
	public WebElement username;

	@FindBy(linkText ="Orders")
	public WebElement Orders;

	@FindBy(id ="article_search_result_table")
	public WebElement table;


	//*[@id="autocomplete"]

	@FindBy(xpath ="//*[contains(text(),'3200')]")
	public List<WebElement> check;

	@FindBy(xpath ="//*[@class='btn btn--large btn--square uppercase book-appointment small--hide medium--hide']")
	public List<WebElement> StoresList1;

	public static final String artTable="//*[@id='article_search_result_table']/tbody/tr[dynamic]/td[1]";

	public static final String artClickTable="//*[@id='article_search_result_table']/tbody/tr[dynamic]/td[4]/input";

	@FindBy(xpath ="//*[@id='orders']/ul/li[2]/a")
	public WebElement orderEnquiry;

	@FindBy(xpath ="//*[@href='#create-tab']")
	public WebElement createOrder;

	@FindBy(xpath ="//*[@id='md_addActionBtn']")
	public WebElement addArticle;

	@FindBy(xpath ="//*[@name='iv_article']")
	public WebElement articleSearch;

	@FindBy(xpath ="//*[@name='oredrQty']")
	public WebElement orderQty;

	@FindBy(xpath ="//*[@name='deliveryDate']")
	public WebElement deliveryDate;

	@FindBy(xpath ="//*[@id='multiplePOS']/input")
	public WebElement enterStore;

	@FindBy(xpath ="//*[@class='advancedSearch verifyStore']")
	public WebElement searchAdd;

	@FindBy(xpath ="//*[contains(text(),'Site: 3200-Test Stores 3200')]/preceding::td[1]/span/a")
	public WebElement expandStore;

	@FindBy(xpath ="(//*[@id='searchAndAdd']/a)[1]")
	public WebElement addArt;

	@FindBy(xpath ="//*[@id='articleSearchTbody']/tr[2]/td[4]/input")
	public WebElement checkArt;

	@FindBy(xpath ="//*[contains(@class,'expander expand-article')]")
	public List<WebElement> totalExpand;

	public static final String ArtDetails="(//*[contains(@class,'expander expand-article')])[dynamic]/following::td[value]";

	@FindBy(xpath ="(//*[@data_supplier_no='3200' and contains(@class,'groupByTr2 collapsed article-content')]/preceding::label[@class='deleteRecord'])")
	public List<WebElement> IBTartList;

	@FindBy(xpath ="(//*[@data_supplier_no='3200' and contains(@class,'groupByTr2 collapsed article-content')]/preceding::label[@class='deleteRecord'])[1]")
	public WebElement IBTartDelete;

	@FindBy(xpath ="//*[@id='okBtn' and text()='Yes']")
	public WebElement acceptIBT;

	@FindBy(xpath ="//*[@data_supplier_no='3200' and contains(@class,'groupByTr2 collapsed article-content')]/td[9]")
	public WebElement IBTartDeleteLast;




	@FindBy(xpath ="//*[@class='textbox textboxDefaultText  inputDate delivery_date_valid editDateCell hasDatepicker']")
	public List<WebElement> ArtdeliveryDate;

	public static final String deliveryDateList="(//*[@class='textbox textboxDefaultText  inputDate delivery_date_valid editDateCell hasDatepicker'])[dynamic]";

	@FindBy(xpath ="(//*[@class='textbox textboxDefaultText  inputDate delivery_date_valid editDateCell hasDatepicker'])[1]")
	public WebElement deliveryDatecheck;

	public static final String ArtdeliveryDateList="(//*[@class='tbody'])[dynamic]/tr/td/input[@class='textbox textboxDefaultText  inputDate delivery_date_valid editDateCell hasDatepicker']";	

	@FindBy(xpath ="//*[@id='validationStatus']")
	public List<WebElement> status;

	@FindBy(xpath ="//*[@class='deleteRecord']")
	public List<WebElement> delRecord;

	public static final String delRecordList="(//*[@class='deleteRecord'])[dynamic]";

	public static final String statusList="(//*[@id='validationStatus'])[dynamic]/label";

	@FindBy(xpath ="//*[@id='all1']")
	public WebElement SOS_All;

	@FindBy(xpath ="//*[@id='warehouse1']")
	public WebElement SOS_warehouse;

	@FindBy(xpath ="//*[@id='vendor1']")
	public WebElement SOS_vendor;

	@FindBy(xpath ="//*[@id='mo_wareHouseDropDown']")
	public WebElement warehouse_DD;

	@FindBy(xpath ="//*[@id='vendorText']")
	public WebElement vendor_TB;

	@FindBy(xpath ="//*[@id='verifySupplier1']")
	public WebElement vendorVerify;

	@FindBy(xpath ="(//*[@class='formActions'])[1]/label[1]")
	public WebElement searchAnddAdd;

	@FindBy(xpath ="(//*[@class='formActions'])[1]/label[2]")
	public WebElement close;

	@FindBy(xpath ="//*[@class='grpTbody']/tr")
	public List<WebElement> totalArt;

	public static final String artList="//*[@class='grpTbody']/tr[dynamic]/td/table/tbody/tr";	

	public static final String Articleexpand="//*[@class='grpTbody']/tr[dynamic]/td[1]";

	@FindBy(xpath ="//*[@href='#over-due-tab']")
	public WebElement overDuetab;

	@FindBy(xpath ="//*[@href='#fully-rece-tab']")
	public WebElement fullyReceivedtab;

	@FindBy(xpath ="//*[@href='#ready-rece-tab']")
	public WebElement readyToReceivetab;

	@FindBy(xpath ="//*[@href='#open-tab']")
	public WebElement openOrderstab;

	@FindBy(xpath ="//*[@id='article_search_result_table']")
	public List<WebElement> warehouseArtTable;

	@FindBy(xpath ="//*[@class='lastColumn centerValue header']")
	public List<WebElement> warehouseArtSelect;

	public static final String selectWarehouseArt="(//*[@class='lastColumn centerValue header'])[dynamic]/input";

	@FindBy(xpath ="//*[@class='ContentTable verifyVendorContent']")
	public List<WebElement> vendorArtTable;

	@FindBy(xpath ="//*[@class='linkBtn linkBtn1']")
	public List<WebElement> vendorArtSelect;

	public static final String selectvendorArt="(//*[@class='linkBtn linkBtn1'])[dynamic]";

	@FindBy(xpath ="//*[@class='lookupActionWrapper']/label[1]/label")
	public WebElement ArtAdvancedSearch;

	@FindBy(xpath ="//*[@id='fromDate']")
	public WebElement advFromDate;

	@FindBy(xpath ="//*[@id='toDate']")
	public WebElement advToDate;

	@FindBy(xpath ="//*[@id='orderType']")
	public WebElement advOrderType;

	@FindBy(xpath ="//*[@id='orderStatus']")
	public WebElement advOrderStatus;

	@FindBy(xpath ="//*[@id='departmentInEnq']")
	public WebElement advDept;

	@FindBy(xpath ="//*[@id='depH']")
	public WebElement advDeptsubCat;

	@FindBy(xpath ="//*[@id='all']")
	public WebElement advAll;

	@FindBy(xpath ="//*[@id='warehouse']")
	public WebElement advwarehouse;

	@FindBy(xpath ="//*[@id='vendor']")
	public WebElement advvendor;

	@FindBy(xpath="//*[@class='department']")
	public List<WebElement> advdepartment;

	public static final String advdepartmentlist="//*[@id='deptlst']/li[dynamic]/label";

	@FindBy(xpath="//*[@class='category']")
	public List<WebElement> advcategory;

	public static final String adv="//*[@id='categoryLst']/li[dynamic]/label";

	@FindBy(xpath="//*[@class='subCat']")
	public List<WebElement> advsubCat1;

	public static final String advsubCatlist="//*[@id='subCategoryLst']/li[dynamic]/label";

	@FindBy(xpath ="(//*[@class='actionBtn goButton'])[1]")
	public WebElement Go;

	@FindBy(xpath ="(//*[@class='actionBtn goButton'])[2]")
	public WebElement advGo;

	@FindBy(xpath ="(//*[@id='addtolist'])[2]")
	public WebElement addToList;

	@FindBy(xpath="//*[@class='actionBtn validateRoaster']")
	public List<WebElement> validate;

	public static final String validateList="(//*[@class='actionBtn validateRoaster'])[dynamic]";

	@FindBy(xpath="//*[@class='actionBtn save']")
	public List<WebElement> save;

	public static final String saveList="(//*[@class='actionBtn save'])[dynamic]";

	@FindBy(xpath ="//*[@class='actionBtn validateAll']")
	public WebElement validateAll;

	@FindBy(xpath ="//*[@id='noValidRostrSeltn']")
	public List<WebElement> emergencycheck;

	@FindBy(xpath ="//*[@id='noValidRostrSeltn']/input[2]")
	public WebElement emergencyclick;	

	@FindBy(xpath ="//*[@id='validRostrSeltn']/input")
	public List<WebElement> availablecheck;	

	@FindBy(xpath ="//*[@id='validRostrSeltn']/input")
	public WebElement availableclick;	

	@FindBy(xpath ="//*[@id='submitDeliveryDateList']")
	public WebElement procToCreate;	

	@FindBy(xpath ="//*[@class='actionBtn submitAll']")
	public WebElement createAll;

	@FindBy(xpath ="//*[@id='over_due_tbl_table']")
	public WebElement orderEnqTable;

	@FindBy(xpath ="//*[@id='advLink1']/label")
	public WebElement advanceSearch;

	@FindBy(xpath ="//*[@id='errorWrapper']")
	public WebElement advSrherrormsg;

	@FindBy(xpath ="//*[@id='errorWrapper']")
	public List<WebElement> advSrherrormsglist;

	@FindBy(xpath ="//*[@class='close']")
	public WebElement advSrherrormsgclse;

	@FindBy(xpath ="//*[@id='dialog-alert-conf']")
	public WebElement advDeldatealert;

	@FindBy(xpath ="//*[@id='yes']/label")
	public WebElement advDeldatealertOK;

	@FindBy(xpath ="//*[@id='okBtn']")
	public WebElement advDeldatealertOKK;

	@FindBy(xpath ="//*[@id='fully_rece_tbl_table']")
	public WebElement orderEnqrcvdTable;

	@FindBy(xpath ="//*[@class='tableTitle']/h4/strong")
	public WebElement ListofOrders;

	@FindBy(xpath ="//*[@class='tableTitle']/h4")
	public WebElement ListofOrdersfuture;

	@FindBy(xpath ="//*[@id='warehouseDrpdwn']")
	public WebElement advWarehouseDD;

	@FindBy(xpath ="//*[@id='supplier']")
	public WebElement advvendor_TB;

	@FindBy(xpath ="//*[@id='verifySupplier']")
	public WebElement advvendorVerify;

	@FindBy(xpath ="//*[@class='order-tabs ui-state-default ui-corner-top']/a")
	public List<WebElement> totaltabs;

	public static final String totaltabsList="(//*[@class='order-tabs ui-state-default ui-corner-top']/a)[dynamic]";

	@FindBy(xpath ="//*[@class='order-tabs ui-state-default ui-corner-top ui-tabs-active ui-state-active loaded']/a")
	public WebElement firsttab;

	public static final String orderTable="(//*[@class='ContentTable actionRows'])[dynamic]";

	public static final String paginationList="(//*[@class='paginationWrapper compact-theme simple-pagination'])[dynamic]";

	public static final String paginationnumberList="(//*[@class='paginationWrapper compact-theme simple-pagination'])[dynamic]/ul/li[value]/a";

	@FindBy(xpath ="//*[@id='scrollWindow-orders']")
	public WebElement deldatestable;

	@FindBy(xpath ="//*[@class='err_msg']")
	public WebElement orderno;

	@FindBy(xpath ="//*[@class='err_msg']")
	public List<WebElement> ordernolist;

	@FindBy(xpath ="(//*[@class='content'])[1]/ol[@class='err_msg']/li")
	public WebElement orderenqerror;

	@FindBy(xpath ="(//*[@class='content'])[1]/ol[@class='err_msg']/li")
	public List<WebElement> orderenqerror1;

	public static final String errordesc="(//*[@class='content'])[dynamic]/ol[@class='err_msg']/li[value]";

	public static final String ordernodesc="(//*[@class='err_msg']/li)[dynamic]";

	@FindBy(xpath ="//*[@class='content']")
	public List<WebElement> errorOC;

	@FindBy(xpath ="//*[@class='err_msg']/li")
	public List<WebElement> ordererrmsg;

	@FindBy(xpath ="//*[@id='orderNo']")
	public WebElement enterArt;

	@FindBy(xpath ="//*[@id='order_status_tr_1_0']")
	public WebElement orderStatus;

	@FindBy(xpath ="(//*[@class='articleNo'])[1]") //changed
	public WebElement artNo;

	@FindBy(xpath ="//*[@class='articleNo']")
	public List<WebElement> artNoList;

	public static final String artNoListList="(//*[@class='articleNo'])[dynamic]";

	public static final String artNumberList="(//*[@class='tbody'])[dynamic]/tr[1]/td[2]";

	@FindBy(xpath ="//*[@class='close']")
	public List<WebElement> ordercloseList;

	public static final String orderclse="(//*[@class='close'])[dynamic]";
	/*@FindBy(xpath ="(//*[@class='close'])[2]")
	public WebElement orderclse;*/

	@FindBy(xpath ="//*[@id='dialog-confirmation']")
	public List<WebElement> allDDate;

	@FindBy(xpath ="//*[@class='warning' and @id='message']") 
	public WebElement warning;

	@FindBy(xpath ="//*[@id='cancel']")
	public WebElement allDDatecancel;

	@FindBy(xpath ="//*[@class='editNumCell textbox textboxDefaultText orderQty']")
	public List<WebElement> orderQtyno;

	public static final String orderQtynoList="(//*[@class='editNumCell textbox textboxDefaultText orderQty'])[dynamic]";

	@FindBy(xpath ="//*[@class='totalUnit']")
	public List<WebElement> totalOrderunit;

	public static final String totalOrderunitList="(//*[@class='totalUnit'])[dynamic]";

	@FindBy(xpath ="//*[@class='centerValue soh']")
	public List<WebElement> SOH;

	public static final String SOHList="(//*[@class='centerValue soh'])[dynamic]";

	@FindBy(xpath ="//*[@href='#ordersReceipt']")
	public WebElement orderonreceipt;

	@FindBy(xpath ="//*[@id='oor_articlesearchBox']")
	public WebElement orderonreceiptart;

	@FindBy(xpath ="	//*[@id='oor_searchBox']")
	public WebElement orderonreceiptart2;

	@FindBy(xpath ="//*[@id='oor_articleListTable']/tbody/tr")
	public List<WebElement> orderonreceiptartList;

	public static final String orderonreceiptartNo="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[2]";

	public static final String orderonreceiptSOH="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[5]";

	public static final String orderonreceiptOM="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[8]";

	public static final String orderonreceiptTotalUnit="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[10]/strong/i";

	public static final String orderonreceiptrcvdQty="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[6]/input[1]";

	public static final String orderonreceiptkgQty="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[6]/input[2]";

	public static final String orderonreceiptDate="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[11]/input";

	public static final String orderonreceiptDatemore="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[11]/label/a";

	public static final String orderonreceiptDatemoredate="//*[@id='oor_articleListTable']/tbody/tr[dynamic]/td[11]/span/input[1]";

	public static final String orderonreceiptDetails="//*[@id='orderOnReceiptDialogForm']/div[dynamic]/input";

	@FindBy(xpath ="//*[@id='proceedFin']")
	public WebElement finish;

	@FindBy(xpath ="//*[@id='oor_createOrder']")
	public WebElement submitOrder;	

	@FindBy(xpath ="(//*[@id='searchAndAdd'])[3]/a")
	public WebElement orderonreceiptartAdd;

	@FindBy(xpath ="//*[@id='ok']/label")
	public WebElement accept;

	@FindBy(xpath ="(//*[contains(text(),'and direct vendor')])[2]")
	public WebElement click;


	@FindBy(xpath ="//*[@id='stockManage']/a")
	public WebElement StockMange;

	@FindBy(xpath ="//*[@id='stockManage']/ul/li[4]/a")
	public WebElement StockTransfr;

	/*@FindBy(linkText ="Orders")
	public WebElement Orders;

	@FindBy(xpath ="//*[@id='orders']/ul/li[2]/a")
	public WebElement orderEnquiry;*/

	@FindBy(xpath ="//*[@id='multiplePOS']/input")
	public WebElement TargetSite;

	@FindBy(xpath ="//*[@id='multiplePOS']/label/label")
	public WebElement SearchAndAdd;

	@FindBy(xpath ="//*[@id='tableCreateAction']/div/div[4]/label[1]")
	public WebElement ClickCreate1;

	@FindBy(xpath ="//*[@id='errorWrapper']/div/div[1]/h4")
	public List<WebElement> DisplayError;

	@FindBy(xpath ="//*[@id='error_msg']/li")
	public WebElement DisplayErrormsg;

	@FindBy(xpath ="//*[@id='error_msg']/li/preceding::div[1]/a")
	public List<WebElement> DisplayErrormsgList;

	@FindBy(xpath ="//*[@id='error_msg']/li/preceding::div[1]/a")
	public WebElement DisplayErrormsgclose;	

	@FindBy(xpath ="//*[@class='ui-dialog-title' and text()='Temperature out of range!']")
	public WebElement Tempcheck;

	@FindBy(xpath ="//*[@class='ui-dialog-title' and text()='Temperature out of range!']/following::span[@id='yes']")
	public WebElement Tempchecknext;

	@FindBy(xpath ="//*[@id='expandAll']")
	public WebElement ClickExpand;

	@FindBy(xpath ="//*[@id='viewModeTable3']/tbody/tr[1]")
	public List<WebElement> SiteName;

	@FindBy(xpath ="(//*[@id='searchBox'])")
	public List<WebElement> enterArticle;

	@FindBy(xpath ="(//*[@id='searchBox'])")
	public WebElement enterArticle1;

	public static final String entArt="(//*[@id='searchBox'])[dynamic]";

	@FindBy(xpath ="(//*[@id='qty'])[1]")
	public WebElement enterQty;

	@FindBy(xpath ="(//*[@id='searchAndAdd']/a)[1]")
	public WebElement ClickSearch;

	@FindBy(xpath ="//*[@id='acceptQty']")
	public WebElement ClikAcceptQty;

	@FindBy(xpath ="//*[@id='acceptQty']")
	public List<WebElement> ClickAcceptQty;

	@FindBy(xpath ="//*[@id='articleSearchTbody']/tr[2]/td[4]/input")
	public WebElement clickArticleSearch;

	@FindBy(xpath ="//*[@id='addtolist']")
	public WebElement clickAddtoList;

	@FindBy(xpath ="(//*[@id='addtolist'])[2]")
	public WebElement clickAddtoList1;

	@FindBy(xpath ="//*[@id='createOrder']/a/label")
	public WebElement clickSubmit;

	@FindBy(xpath ="//*[@id='error_title']")
	public WebElement clickHelp;

	@FindBy(xpath ="//*[@id='error_title']")
	public List<WebElement> clickHelpsize;

	@FindBy(xpath ="(//*[@class='close'])[4]")
	public WebElement clickNote;

	@FindBy(xpath ="//*[@id='ibtNextBtn']/a")
	public List<WebElement> CheckclickNext;


	@FindBy(xpath ="//*[@id='ibtNextBtn']/a")
	public WebElement clickNext;

	@FindBy(xpath ="//*[@id='ibtNextBtn']")
	public WebElement checkNextbutton;

	@FindBy(xpath ="//*[@id='ibtFinishBtn']/a/label")
	public WebElement clickFinish;

	@FindBy(xpath ="//*[@id='error_title']")
	public List<WebElement> CheckSuccessmsg;

	@FindBy(xpath ="//*[@id='success_msg']")
	public WebElement clickMesg;

	@FindBy(xpath ="//*[@id='success_msg']")
	public WebElement Ordernum;

	@FindBy(xpath ="(//*[@id='temperature2'])[2]")
	public WebElement EnterFrozenTemp;



	@FindBy(xpath ="(//*[@id='temperature1'])[2]")
	public WebElement EnterChilledTemp;

	@FindBy(xpath ="//*[@id='stockTempDiv']/div[3]")
	public WebElement CheckFrozenTemp;

	@FindBy(xpath ="//*[@id='stockTempDiv']/div[2]")
	public WebElement CheckChilledTemp;

	@FindBy(xpath ="//*[@id='orders']/a")
	public WebElement ClckOrdrs;

	@FindBy(xpath ="//*[@id='orders']/ul/li[2]")
	public WebElement ClckOrderEnquiry;

	@FindBy(xpath ="(//*[@id='orderNo'])")
	public WebElement EnterOrderNo;

	@FindBy(xpath ="//*[@id='orderEnq']/label")
	public WebElement clckGo;

	@FindBy(xpath ="//*[@id='supplier_name_tr_1_0']")
	public WebElement clickStatus;

	@FindBy(xpath ="//*[@id='order_status_tr_1_0']")
	public WebElement checkStatus;


	@FindBy(xpath ="(//*[@class='close'])")
	public WebElement clicksubmittedstatus;

	@FindBy(xpath ="//*[@id='ibtCancelBtn']/a/label")
	public WebElement clickCancel;

	@FindBy(xpath ="//*[@id='yes']/label")
	public WebElement clickYes;

	@FindBy(xpath ="//*[@id='order_type_tr_1_0']")
	public WebElement CheckType;

	@FindBy(xpath ="//*[@id='commonCancelOrder']")
	public WebElement CheckIBTCancelbutton;

	@FindBy(xpath ="//*[@id='commonCancelOrder']/a")
	public WebElement ClickIBTCancelbutton;

	@FindBy(xpath ="//*[@id='cancelOrder']")
	public WebElement CheckVendorCancelbutton;

	@FindBy(xpath ="//*[@id='cancelOrder']/a")
	public WebElement ClickVendorCancelbutton;

	@FindBy(xpath ="//*[@id='message']")
	public WebElement Checkpopup;

	@FindBy(xpath ="//*[@id='yes']/label")
	public WebElement Clickpopup;

	@FindBy(xpath ="//*[@id='success_title']")
	public WebElement CheckSuccessStatus;

	@FindBy(xpath ="//*[@id='success_msg']/li")
	public WebElement Checksuccessmsg;

	@FindBy(xpath ="//*[@class='close']")
	public WebElement Clickclose;

	@FindBy(xpath ="//*[@id='success_title']")
	public WebElement CheckIBTSuccessStatus;

	@FindBy(xpath ="//*[@id='success_msg']/li")
	public WebElement CheckIBTsuccessmsg;

	@FindBy(xpath ="(//*[@class='close'])[3]")
	public WebElement ClickIBTclose;

	@FindBy(xpath ="//*[@class='title']")
	public WebElement msg;

	@FindBy(xpath ="//*[@id='errorWrapper']/div/div[1]/h4")
	public WebElement CheckError;

	@FindBy(xpath ="//*[@id='error_msg']")
	public WebElement CaptureErrorMsg;

	@FindBy(xpath ="//*[@class = 'close']")
	public WebElement clickClosebutton;

	@FindBy(xpath ="//*[@id='viewModeTable3']/tbody/tr[3]/th[2]")
	public WebElement SortArticles;

	@FindBy(xpath ="(//*[@class='title'])[7]")
	public WebElement CheckTitle;

	@FindBy(xpath ="(//*[@class = 'close'])[4]")
	public WebElement ClicksiteTitle;

	@FindBy(xpath ="(//*[@class='title'])[5]")
	public List<WebElement> Titlesize;

	@FindBy(xpath ="//*[@id='viewModeTable3']/tbody/tr[@class = 'collapsed groupByExpand2 expand-collapse']")
	public List<WebElement> checkstoresize;

	@FindBy(xpath ="//*[@id='viewModeTable3']/tbody/tr[@class='groupByTr2 collapsed article-content-row']")
	public List<WebElement> checkarticlessize;

	@FindBy(xpath ="//*[@id='viewModeTable3']/tbody/tr[@class='groupByTr2 collapsed article-content-row'][1]/td[9]/label")
	public WebElement deletearticle;

	@FindBy(xpath ="//*[@id='dialog-modal-alertBox']")
	public List<WebElement> checkAlert;

	@FindBy(xpath ="//*[@class = 'actionBtn yesBtn']")
	public WebElement clckYES;


	public static final String checksite= "//*[@id='viewModeTable3']/tbody/tr[@class = 'collapsed groupByExpand2 expand-collapse'][dynamic]/td[2]";
	public static final String clicksite= "//*[@id='viewModeTable3']/tbody/tr[@class = 'collapsed groupByExpand2 expand-collapse'][dynamic]/td[1]";


	public static final String checkArticle= "//*[@id='viewModeTable3']/tbody/tr[dynamic]/td[2]";
	public static final String checkSOH= "//*[@id='viewModeTable3']/tbody/tr[dynamic]/td[5]";
	public static final String checkOM= "//*[@id='viewModeTable3']/tbody/tr[dynamic]/td[7]";
	public static final String checkRecvdUnits= "//*[@id='viewModeTable3']/tbody/tr[dynamic]/td[8]/strong";








	@FindBy(xpath ="//*[@id='over_due_tbl_table']/tbody/tr")
	public List<WebElement> orderList;

	@FindBy(xpath ="//*[@id='over_due_tbl_table']/tbody/tr[1]/td[1]")
	public WebElement orderTableClick;

	public static final String vendorDetails= "//*[@class='articleInfoWrapper']/p/label[dynamic]/strong";

	@FindBy(xpath ="//*[@class='orderStatus']/strong")
	public WebElement Status;

	@FindBy(xpath ="//*[@id='tempCheckFlag']")
	public WebElement tempflagStatus;

	@FindBy(xpath ="//*[@class='articleDetails']/table/tbody/tr")
	public List<WebElement> vendorOrderTable;

	@FindBy(xpath ="//*[contains(text(),'Clear Group By')]")
	public WebElement clearGroupBy;

	public static final String artListTable1= "//*[@id='yet_to_received_item_table_table']/tbody/tr[dynamic]/td[value]";

	public static final String artListTableRW= "//*[@id='yet_to_received_item_table_table']/tbody/tr[dynamic]/td[value]/br";

	public static final String artListTabledisp= "//*[@id='yet_to_received_item_table_table']/tbody/tr[dynamic]/td[value]/a";

	public static final String finalartListTable1= "//*[@id='received_item_table_table']/tbody/tr[dynamic]/td[value]";

	public static final String finalartListTableRW= "//*[@id='received_item_table_table']/tbody/tr[dynamic]/td[value]/br";

	public static final String finalartListTabledisp= "//*[@id='received_item_table_table']/tbody/tr[dynamic]/td[value]/a";

	@FindBy(xpath ="//*[@id='yet_to_received_item_table_table']/tbody/tr")
	public List<WebElement> artListTable;	

	@FindBy(xpath ="//*[@id='received_item_table_table']/tbody/tr")
	public List<WebElement> finalartListTable;	

	@FindBy(xpath ="//*[@id='componentTable_table']/tbody/tr")
	public List<WebElement> displayArtTable;

	@FindBy(xpath ="//*[@id='openCmpntArticlesDisplay']/following::div[1]/span/label")
	public WebElement dispArtOK;

	@FindBy(xpath ="//*[@class='notepad']")
	public WebElement receiveOrder;

	@FindBy(xpath ="//*[contains(text(),'Resume Session')]")
	public List<WebElement> resumeSessionList;

	@FindBy(xpath ="//*[contains(text(),'Resume Session')]")
	public WebElement resumeSession;

	@FindBy(xpath ="//*[contains(text(),'New Session')]")
	public WebElement newSession;

	@FindBy(xpath ="//*[contains(text(),'Receive Line-by-line')]/preceding::input[1]")
	public WebElement receiveLBLCB;

	@FindBy(xpath ="//*[contains(text(),'Receive by Exception')]/preceding::input[1]")
	public WebElement receiveLBECB;

	@FindBy(xpath ="//*[@id='invoice']")
	public WebElement docket;

	@FindBy(xpath ="//*[@id='temperature1']")
	public WebElement ChilledTemp;

	@FindBy(xpath ="//*[@id='temperature1']/preceding::div[1]/following::div[1]")
	public WebElement ChilledTempPresence;

	@FindBy(xpath ="//*[@id='nextbtn']")
	public WebElement nextClick;

	@FindBy(xpath ="//*[contains(text(),'Receiving By Exception Confirmation')]")
	public WebElement exceptionError;

	@FindBy(xpath ="//*[@class='actionBtn' and text()='Proceed']")
	public WebElement exceptionProceed;

	@FindBy(xpath ="//*[@id='recvArticleTable']/tbody/tr")
	public List<WebElement> receiceTable;

	public static final String tablevalue="//*[@id='recvArticleTable']/tbody/tr[dynamic]/td[value]";

	public static final String tablevalue1="//*[@id='recvArticleTable']/tbody/tr[dynamic]/td[value]/strong";

	public static final String tablevalue2="//*[@id='recvArticleTable']/tbody/tr[dynamic]/td[value]/input[val]";

	public static final String tablevalue3="//*[@id='recvArticleTable']/tbody/tr[dynamic]/td[value]/a";

	@FindBy(xpath ="//*[@id='cmpnt_order_tbl_table']/tbody/tr")
	public List<WebElement> dispArtReceiveTable;

	public static final String DAtable="//*[@id='cmpnt_order_tbl_table']/tbody/tr[dynamic]/td[value]";

	public static final String DAtable1="//*[@id='cmpnt_order_tbl_table']/tbody/tr[dynamic]/td[value]/strong";

	public static final String DAtable2="//*[@id='cmpnt_order_tbl_table']/tbody/tr[dynamic]/td[value]/input";

	@FindBy(xpath ="//*[@id='cmpnt_order_tbl_table']/following::div[2]/span/label")
	public WebElement dispArtOK1;

	@FindBy(xpath ="//*[@id='discrepancyTable']/tbody/tr")
	public List<WebElement> finalArtList;

	public static final String finalArt="//*[@id='discrepancyTable']/tbody/tr[dynamic]/td[value]";

	public static final String finalArt1="//*[@id='discrepancyTable']/tbody/tr[dynamic]/td[value]/label";

	public static final String finalArt2="//*[@id='discrepancyTable']/tbody/tr[dynamic]/td[value]/input";

	@FindBy(xpath ="//*[@id='recvSummaryTable']/tbody/tr")
	public List<WebElement> receiveSumList;

	@FindBy(xpath ="(//*[@class='articleDetails'])[1]/table/tbody/tr")
	public List<WebElement> final_sum1;

	@FindBy(xpath ="(//*[@class='articleDetails'])[2]/table/tbody/tr")
	public List<WebElement> final_sum2;

	@FindBy(xpath ="(//*[@class='articleDetails'])[3]/table/tbody/tr")
	public List<WebElement> final_sum3;

	@FindBy(xpath ="(//*[@class='articleDetails'])[4]/table/tbody/tr")
	public List<WebElement> final_sum4;

	@FindBy(xpath ="//*[@id='discDetails']/tbody/tr")
	public List<WebElement> discSumList;

	@FindBy(xpath ="//*[@class='thumbUp' and text()='Submit']")
	public WebElement submit;

	@FindBy(xpath ="//*[@class='actionBtn' and text()='Continue']")
	public List<WebElement> continuesList;

	@FindBy(xpath ="//*[@class='actionBtn' and text()='Continue']")
	public WebElement continues;

	@FindBy(xpath ="//*[@id='success_msg']/li/preceding::a[1]")
	public WebElement sucClose;

	@FindBy(xpath ="//*[@id='temperature2']")
	public WebElement frozenTemp;

	@FindBy(xpath ="//*[@id='temperature2']/preceding::div[1]/following::div[1]")
	public WebElement frozenTempPresence;

	@FindBy(xpath ="(//*[contains(text(),'Temperature out of range!')])[2]/following::div[1]/span[2]")
	public WebElement frozenTempCheck;
}
