package au.wow.ngbomain.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaybyObjects {

	
	@FindBy(xpath ="//*[@id=\'userName\']")
	public WebElement UserName;
	
	@FindBy(xpath ="//*[@id=\'password\']")
	public WebElement Password;

	
	@FindBy(xpath ="//*[@id=\'Login\']")
	public WebElement Login;
	
	@FindBy(xpath ="/html/body/table[1]/tbody/tr[1]/td[3]/table/tbody/tr/td[3]/font/a")
	public WebElement Logout;
	

	@FindBy(xpath ="/html/body/div[1]/div[3]/div/button[1]/span")
	public WebElement Continue;
	
	@FindBy(xpath ="//*[@id=\"cssmenu\"]/ul/li[3]/a/span")
	public WebElement CentralManagement;

	@FindBy(xpath ="//*[@id=\"cssmenu\"]/ul/li[3]/ul/li[1]/a")
	public WebElement StockArrival;

	@FindBy(xpath ="//*[@id=\"stockStatus1\"]")
	public WebElement NotPresent;

	@FindBy(xpath ="//*[@id=\"stockStatus2\"]")
	public WebElement Oversell;
	
	@FindBy(xpath ="//*[@id=\"stockStatus3\"]")
	public WebElement Preorder;

	@FindBy(xpath ="//*[@id=\"stockArrival2\"]")
	public WebElement StockArticle;

	@FindBy(xpath ="//*[@id=\"articleNumber\"]")
	public WebElement StockArticlenum;

	@FindBy(xpath ="//*[@id=\"stockArrival1\"]")
	public WebElement StockEAN;

	@FindBy(xpath ="//*[@id=\"ean\"]")
	public WebElement StockEanNum;
	
	@FindBy(xpath ="//*[@id=\"txtQuantity\"]")
	public WebElement StockQuantity;
	
	@FindBy(xpath ="(//*[@id=\"allocationMode\"]/option[2]")
	public WebElement AutomaticStockAllocation;
	
	@FindBy(xpath ="//*[@id=\"allocationMode\"]/option[3]")
	public WebElement ManualStockAllocation;
	
	@FindBy(xpath ="//*[@id=\"stockArrivalForm\"]/table/tbody/tr[8]/td[1]/input[1]")
	public WebElement Retrieve;
	
	@FindBy(xpath ="//*[@id=\"stockAllocationCompleted1\"]")
			public WebElement StockAllocationCompleted;
		
	@FindBy(xpath ="//*[@id=\"cssmenu\"]/ul/li[3]/ul/li[2]/a")
	public WebElement ProductRecall;
	
	@FindBy(xpath ="//*[@id=\"productRecall1\"]")
	public WebElement ProductrecallEan;

	@FindBy(xpath ="//*[@id=\"ean\"]")
	public WebElement ProductrecallEanNum;

	@FindBy(xpath ="//*[@id=\"productRecall2\"]")
	public WebElement ProductrecallArticle;

	@FindBy(xpath ="//*[@id=\"articleNumber\"]")
	public WebElement ProductrecallArticleNum;

	@FindBy(xpath ="//*[@id=\"productRecall\"]/div/input")
	public WebElement RecallButton;
	
	@FindBy(xpath ="/html/body/div[3]/a[1]")
	public WebElement ItemReportLink;
	
	@FindBy(xpath ="//*[@id=\"id_paginator\"]/ul/li[6]/a")
	public WebElement Recalled;
	
	@FindBy(xpath ="//*[@id=\"activityComponent\"]/div[1]/input[2]")
	public WebElement ItemReportExport;
	
	@FindBy(xpath ="//*[@id=\"cssmenu\"]/ul/li[3]/ul/li[3]/a")
	public WebElement LocationConfiguration;

	//@FindBy(xpath ="//*[@id=\"majorLocationsForm\"]/div[2]/table/tbody/tr[4]/td/input[1]")
	@FindBy(xpath ="//input[contains(@value,'Add')]")
	public WebElement AddLocation;
	
	//*[@id="countStd"]
	
	//@FindBy(xpath ="//*[@id='majorLocationsForm']/div[2]/table/tbody/tr[2]/td[3]/input")
	@FindBy(xpath ="//input[contains(@value,'Update')]")
	public WebElement Update;
	
	//*[@id="majorLocationsForm"]/div[2]/table/tbody/tr[2]/td[3]/input
	
	@FindBy(xpath ="//*[@id=\"countStd\"]")
	public WebElement AddMinorLocation;
	//*[@id="countStd"]
	
	@FindBy(xpath ="//*[@id=\"majorLocationsForm\"]/div[2]/table/tbody/tr[3]/td[1]/a/img")
	public WebElement DeleteMajorLocation;
	
	
	//@FindBy(xpath ="//*[@id=\"majorLocationsForm\"]/div[2]/table/tbody/tr[4]/td/input[2]")
	@FindBy(xpath ="//input[contains(@value,'Reset')]")
	public WebElement ResetLocation;
	
	@FindBy(xpath ="//*[@id=\"majorLocationsForm\"]/div[2]/table/tbody/tr[4]/td/input[3]")
	public WebElement PrintLabelsLocation;
	
	@FindBy(xpath ="/html/body/table/tbody/tr/td[3]/a/input")
	public WebElement PrintLabelsButton;
	
	@FindBy(xpath ="/html/body/table/tbody/tr/td[1]/a")
	public WebElement PrintBackButton;
	
	
	@FindBy(xpath ="//*[@id=\"cssmenu\"]/ul/li[3]/ul/li[4]/a")
	public WebElement ProductConfiguration;
	
	@FindBy(xpath ="//*[@id=\"activeProdList\"]/tbody/tr[4]/td/input")
	public WebElement AddNewProduct;
	
	@FindBy(xpath ="//*[@id=\"activeProdList\"]/tbody/tr[6]/td/input")
	public WebElement AddPreorderProduct;
	
	@FindBy(xpath ="//*[@id=\"activeProdList\"]/tbody/tr[7]/td/input")
	public WebElement AddFinalisedDateProduct;
	
	@FindBy(xpath ="//*[@id=\"rdoLaybyType1\"]")
	public WebElement FixedDurationLayby;
	
	@FindBy(xpath ="//input[contains(@value,'Add')]")
	public WebElement AddButton;
	
	 //input[contains(@value,'Add')]

	@FindBy(xpath ="//*[@id=\"rdoLaybyType2\"]")
	public WebElement FixedFinalisationDateLayby;

	@FindBy(xpath ="//*[@id=\"createProductsForm\"]/table/tbody/tr[21]/td[1]/input")
	public WebElement SaveProduct;
	
	@FindBy(xpath ="//*[@id=\"cancel\"]")
	public WebElement CancelProduct;
	
	@FindBy(xpath ="//*[@id=\"activeProdList\"]/tbody/tr[4]/td[2]/a/img")
	public WebElement UpdateProduct;
	
	@FindBy(xpath ="//*[@id=\"createProductsForm\"]/table/tbody/tr[21]/td[1]/input")
	public WebElement UpdateProductButton;
	
	@FindBy(xpath ="//*[@id=\"laybyName\"]")
	public WebElement LaybyName;
	
	@FindBy(xpath ="//*[@id=\"laybyDuration\"]")
	public WebElement LaybyDuration;

	@FindBy(xpath ="//*[@id=\"fixedFinalizationDate\"]")
	public WebElement FixedFinalisationDate;

	@FindBy(xpath ="//*[@id=\"laybyEANField\"]")
	public WebElement LaybyfeeEan;

	@FindBy(xpath ="//*[@id=\"laybyFeeAmt\"]")
	public WebElement LaybyfeeAmount;

	@FindBy(xpath ="//*[@id=\"cancellationFeeEAN\"]")
	public WebElement CancellationEan;

	@FindBy(xpath ="//*[@id=\"cancellationFeeAmt\"]")
	public WebElement CancellationAmount;

	@FindBy(xpath ="//*[@id=\"minimumDeposit\"]")
	public WebElement MinDeposit;

	@FindBy(xpath ="//*[@id=\"minimumInterimPayment\"]")
	public WebElement MinInterimPayment;

	@FindBy(xpath ="//*[@id=\"reciptHeaderName\"]")
	public WebElement ReceiptHeader;

	@FindBy(xpath ="//*[@id=\"maximumExtensions\"]")
	public WebElement MaxExtension;

	@FindBy(xpath ="//*[@id=\"maximumDeferments\"]")
	public WebElement MaxDeferments;

	@FindBy(xpath ="//*[@id=\"scheduleRequired1\"]")
	public WebElement ScheduleRequiredYes;

	@FindBy(xpath ="//*[@id=\"scheduleRequired2\"]")
	public WebElement ScheduleReqNo;

	@FindBy(xpath ="//*[@id=\"preorder1\"]")
	public WebElement PreorderYes;

	@FindBy(xpath ="//*[@id=\"preorder2\"]")
	public WebElement PreorderNo;

	@FindBy(xpath ="//*[@id=\"startDate\"]")
	public WebElement LaybyStartDate;

	@FindBy(xpath ="//*[@id=\"endDate\"]")
	public WebElement LaybyEndDate;

	@FindBy(xpath ="//*[@id=\"gracePeriod\"]")
	public WebElement LaybyGracePeriod;

	@FindBy(xpath ="//*[@id=\"termsAndConditions\"]")
	public WebElement LaybyTC;

	@FindBy(xpath ="//*[@id=\"cssmenu\"]/ul/li[2]/a")
	public WebElement Layby;

	@FindBy(xpath ="//*[@id=\"cssmenu\"]/ul/li[2]/ul/li[1]/a")
	public WebElement Layby_Management;
	
	@FindBy(xpath ="//*[@id=\"majorLocationForm\"]/table[2]/tbody/tr[2]/td[3]/a")
	public WebElement ViewLocations;
	
	@FindBy(xpath ="//*[@id=\"locationsForm\"]/center/div/table[2]/tbody/tr/td[1]/input")
	
	public WebElement SaveMinorLocation;
	
	@FindBy(xpath ="/html/body/div[3]/div[3]/div/button[1]/span")
	public WebElement SaveMajorLocation;
	

	@FindBy(xpath ="//*[@id=\"cssmenu\"]/ul/li[2]/ul/li[2]/a")
	public WebElement ChangeLocationStatus;

	@FindBy(xpath ="//*[@id=\"searchLaybyEDR\"]/table/tbody/tr[1]/td[1]/div/font[2]/input")
	public WebElement LaybySearch_EDR;

	@FindBy(xpath ="//*[@id=\"edrNo\"]")
	public WebElement LaybySearch_EDRNum;

	@FindBy(xpath ="//*[@id=\"searchLaybyCustomerDet\"]/table/tbody/tr[1]/td[1]/div/font[3]/input")
	public WebElement Laby_CustomerDetails;

	@FindBy(xpath ="//*[@id=\"firstName\"]")
	public WebElement CustomerDetail_FirstName;

	@FindBy(xpath ="(//*[@id=\"lastName\"]")
	public WebElement CustomerDetail_LastName;

	@FindBy(xpath ="//*[@id=\"suburb\"]")
	public WebElement CustomerDetail_Suburb;

	@FindBy(xpath ="//*[@id=\"searchLaybyCustomerDet\"]/table/tbody/tr[16]/td/input")
	public WebElement CustomerDetail_Search;

	@FindBy(xpath ="//*[@id=\"searchLaybyLaybyid\"]/table/tbody/tr[1]/td[1]/div/font[4]/input")
	public WebElement LaybyID;

	@FindBy(xpath ="//*[@id=\"laybyid\"]")
	public WebElement LaybyIDNum;

	@FindBy(xpath ="//*[@id=\"searchLaybyLaybyid\"]/table/tbody/tr[7]/td/input")
	public WebElement Layby_Search;

	@FindBy(xpath ="//*[@id=\"ocb\"]")
	public WebElement UpdateMajor;
	
	//*[@id="majorLocationForm"]/table[2]/tbody/tr[2]/td[2]/a/img
	@FindBy(xpath ="//*[@id=\"majorLocationForm\"]/table[2]/tbody/tr[2]/td[2]/a")
	public WebElement UpdateMajorLocation;
	
	@FindBy(xpath ="//*[@id='cssmenu']/ul/li[4]/a")
	public WebElement Reporting;
	
	@FindBy(xpath ="//*[@id='cssmenu']/ul/li[4]/ul/li[1]/a")
	public WebElement EnquiryReport;
	
	@FindBy(xpath ="//*[@id=\"dateReportSearchForm\"]/div[1]/input[1]")
	public WebElement PrintEnquiryReport;
	
	@FindBy(xpath ="//*[@id=\"dateReportSearchForm\"]/div[1]/input[2]")
	public WebElement ExportEnquiryReport;
	
	@FindBy(xpath ="//*[@id=\"command\"]/table/tbody/tr[2]/td[2]/input")
	public WebElement ValueStoreReport;
	
	@FindBy(xpath ="//*[@id=\"reportEndDate\"]")
	public WebElement ValueReportEndDate;
	
	@FindBy(xpath ="//*[@id=\"valueReportSearchForm\"]/table[2]/tbody/tr[3]/td[3]/font/input")
	public WebElement ValueReportPreview;
	
	@FindBy(xpath ="//*[@id=\"command\"]/table/tbody/tr[3]/td[2]/input")
	public WebElement OutstandingBalanceStoreReport;
	
	@FindBy(xpath ="//*[@id=\"command\"]/table[2]/tbody/tr[1]/td[1]/input")
	public WebElement OutstandingBalancebutton;
	
	@FindBy(xpath ="//*[@id=\"command\"]/table[2]/tbody/tr[2]/td[1]/input")
	public WebElement TotalValuebutton;
	
	@FindBy(xpath ="//*[@id=\"command\"]/table[2]/tbody/tr[3]/td[1]/input")
	public WebElement OutstandingBalancepercentbutton;
	
	@FindBy(xpath ="//*[@id=\"outstandingBalance\"]")
	public WebElement OutstandingBalancefield;
	
	@FindBy(xpath ="//*[@id=\"totalValue\"]")
	public WebElement TotalValuefield;
	
	@FindBy(xpath ="//*[@id=\"outstandingPercent\"]")
	public WebElement OutstandingBalancepercentfield;
	
	@FindBy(xpath ="//*[@id=\"command\"]/table[2]/tbody/tr[5]/td/font/input")
	public WebElement OutstandingBalancepreview;
	
	
	@FindBy(xpath ="//*[@id='storeReport']")
	public WebElement StoreReport;
	
	
	@FindBy(xpath ="//*[@id='crStartDate']")
	public WebElement CreationStartDate;
	
	@FindBy(xpath ="//*[@id='crEndDate']")
	public WebElement CreationEndDate;
	
	@FindBy(xpath ="//*[@id='dateReportSearchForm']/table[2]/tbody/tr[4]/td[3]/font/input")
	public WebElement Preview;
	
	@FindBy(xpath=" //*[@id='dateReportSearchForm']/div[3]/table")
    public WebElement ArticleRecords1;
	

	@FindBy(xpath=" //*[@id='dateReportSearchForm']/div[3]/table")
    public List<WebElement> ArticleRecords;

	@FindBy(xpath="//a[text()='Create Product']")
    public  WebElement CreateProduct;
	
	@FindBy(id="productId")
    public  WebElement productId1;
	
	@FindBy(id="description")
    public  WebElement description1;
	
	@FindBy(id="price")
    public  WebElement price1;
	
	@FindBy(id="imageUrl")
    public  WebElement imageUrl1;
	
	@FindBy(xpath="//button[text()='Submit']")
    public  WebElement submit;
	
	@FindBy(xpath="//a[text()='Products']")
    public  WebElement Products1;
	
	
}
