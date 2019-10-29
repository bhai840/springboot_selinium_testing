package au.wow.ngbo.utils;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import bsh.commands.dir;

public class HTMLReport {

	public static BufferedWriter writer;
	public static String StoreNo;
	public static int reCount=2;
	public static boolean f=false;
	public static int inSum1 = 0;
	public static int totScripts = 0;
	public static int totPass = 0;
	public static int totFail = 0;
	public static String manualCount = "0";
	public static File reportPath;
	public static String moduledesc;
	public static String dtmoduledesc;
	public static int strStepNo=0;
	public static int inSumPass =0;
	public static int inSumFail=0;
	public static int inSumStep=0;
	public static int inSumStep1=0;
	
	public static String manualTestCaseCount = "0";
	
	public static int inPassCnt;
	public static int inFailCnt =0;
	public static String stStartSuite;
	public static Date dateex;
	public static Date testcasesttime;
	public static String store,user,pwd,eng1,database1,host1;
	public static boolean bwsStrore;
	
	public static Multimap<String, HashMap<String, Multimap<String, String>>> moduleName = ArrayListMultimap
			.create();
	
	public static String BigWOpticalsMC = "0";
	public static int BigWOpticalsPrecount2 = -1;
	public static String BigWOpticalstestname;
	public static String BigWOpticalstestdesc;
	public static String BigWOpticalsStdateex;
	public static String BigWOpticalsenddateex;
	public static String BigWOpticalsStartdat;
	public static String BigWOpticalsEndDate;
	public static Multimap<String, String> BigWOpticalsTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> BigWOpticalsScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> BigWOpticalsModules = new HashMap<String, Multimap<String, String>>();

	public static String LaybyMC = "0";
	public static int LaybyPrecount2 = -1;
	public static String Laybytestname;
	public static String Laybytestdesc;
	public static String LaybyStdateex;
	public static String Laybyenddateex;
	public static String LaybyStartdat;
	public static String LaybyEndDate;
	public static Multimap<String, String> LaybyTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> LaybyScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> LaybyModules = new HashMap<String, Multimap<String, String>>();
	/*public static String ReceiveArtMC = "0";
	public static int ReceiveArtpreCount2 = -1;
	public static String ReceiveArttestname;
	public static String ReceiveArttestdesc;
	public static String ReceiveArtStdateex;
	public static String ReceiveArtenddateex;
	public static String ReceiveArtStartdat;
	public static String ReceiveArtMEndDate;
	public static Multimap<String, String> ReceiveArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> ReceiveArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> ReceiveArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String ORArtMC = "0";
	public static int ORArtpreCount2 = -1;
	public static String ORArttestname;
	public static String ORArttestdesc;
	public static String ORArtStdateex;
	public static String ORArtenddateex;
	public static String ORArtStartdat;
	public static String ORArtMEndDate;
	public static Multimap<String, String> ORArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> ORArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> ORArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String overstockArtMC = "0";
	public static int overstockArtpreCount2 = -1;
	public static String overstockArttestname;
	public static String overstockArttestdesc;
	public static String overstockArtStdateex;
	public static String overstockArtenddateex;
	public static String overstockArtStartdat;
	public static String overstockArtMEndDate;
	public static Multimap<String, String> overstockArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> overstockArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> overstockArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String enhancedArtMC = "0";
	public static int enhancedArtpreCount2 = -1;
	public static String enhancedArttestname;
	public static String enhancedArttestdesc;
	public static String enhancedArtStdateex;
	public static String enhancedArtenddateex;
	public static String enhancedArtStartdat;
	public static String enhancedArtMEndDate;
	public static Multimap<String, String> enhancedArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> enhancedArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> enhancedArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String enhancedArtMC1 = "0";
	public static int enhancedArtpreCount21 = -1;
	public static String enhancedArttestname1;
	public static String enhancedArttestdesc1;
	public static String enhancedArtStdateex1;
	public static String enhancedArtenddateex1;
	public static String enhancedArtStartdat1;
	public static String enhancedArtMEndDate1;
	public static Multimap<String, String> enhancedArtTime1 = ArrayListMultimap
			.create();
	public static Multimap<String, String> enhancedArtScenarios1 = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> enhancedArtModules1 = new HashMap<String, Multimap<String, String>>();
	
	public static String sampleArtMC = "0";
	public static int sampleArtpreCount2 = -1;
	public static String sampleArttestname;
	public static String sampleArttestdesc;
	public static String sampleArtStdateex;
	public static String sampleArtenddateex;
	public static String sampleArtStartdat;
	public static String sampleArtMEndDate;
	public static Multimap<String, String> sampleArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> sampleArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> sampleArtModules = new HashMap<String, Multimap<String, String>>();

	public static String OrdRecArtMC = "0";
	public static int OrdRecArtpreCount2 = -1;
	public static String OrdRecArttestname;
	public static String OrdRecArttestdesc;
	public static String OrdRecArtStdateex;
	public static String OrdRecArtenddateex;
	public static String OrdRecArtStartdat;
	public static String OrdRecArtMEndDate;
	public static Multimap<String, String> OrdRecArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> OrdRecArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> OrdRecArtModules = new HashMap<String, Multimap<String, String>>();
	

	public static String AdjLogArtMC = "0";
	public static int AdjLogArtpreCount2 = -1;
	public static String AdjLogArttestname;
	public static String AdjLogArttestdesc;
	public static String AdjLogArtStdateex;
	public static String AdjLogArtenddateex;
	public static String AdjLogArtStartdat;
	public static String AdjLogArtMEndDate;
	public static Multimap<String, String> AdjLogArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> AdjLogArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> AdjLogArtModules = new HashMap<String, Multimap<String, String>>();

	public static String stockAdjArtMC = "0";
	public static int stockAdjArtpreCount2 = -1;
	public static String stockAdjArttestname;
	public static String stockAdjArttestdesc;
	public static String stockAdjArtStdateex;
	public static String stockAdjArtenddateex;
	public static String stockAdjArtStartdat;
	public static String stockAdjArtMEndDate;
	public static Multimap<String, String> stockAdjArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> stockAdjArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> stockAdjArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String DSCandPLUArtMC = "0";
	public static int DSCandPLUArtpreCount2 = -1;
	public static String DSCandPLUArttestname;
	public static String DSCandPLUArttestdesc;
	public static String DSCandPLUArtStdateex;
	public static String DSCandPLUArtenddateex;
	public static String DSCandPLUArtStartdat;
	public static String DSCandPLUArtMEndDate;
	public static Multimap<String, String> DSCandPLUArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> DSCandPLUArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> DSCandPLUArtModules = new HashMap<String, Multimap<String, String>>();
	
	
	Display
	public static String instoreDisplayMC = "0";
	public static int instoreDisplaypreCount2 = -1;
	public static String instoreDisplaytestname;
	public static String instoreDisplaytestdesc;
	public static String instoreDisplayStdateex;
	public static String instoreDisplayenddateex;
	public static String instoreDisplayStartdat;
	public static String instoreDisplayMEndDate;
	public static Multimap<String, String> instoreDisplayTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> instoreDisplayScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> instoreDisplaytModules = new HashMap<String, Multimap<String, String>>();
	
	clearance
	public static String inStoreArtMC = "0";
	public static int inStoreArtpreCount2 = -1;
	public static String inStoreArttestname;
	public static String inStoreArttestdesc;
	public static String inStoreArtStdateex;
	public static String inStoreArtenddateex;
	public static String inStoreArtStartdat;
	public static String inStoreArtMEndDate;
	public static Multimap<String, String> inStoreArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> inStoreArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> inStoreArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String inStore1ArtMC = "0";
	public static int inStore1ArtpreCount2 = -1;
	public static String inStore1Arttestname;
	public static String inStore1Arttestdesc;
	public static String inStore1ArtStdateex;
	public static String inStore1Artenddateex;
	public static String inStore1ArtStartdat;
	public static String inStore1ArtMEndDate;
	public static Multimap<String, String> inStore1ArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> inStore1ArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> inStore1ArtModules = new HashMap<String, Multimap<String, String>>();
	
	
	
	
	competition
	public static String inStoreCompArtMC = "0";
	public static int inStoreCompArtpreCount2 = -1;
	public static String inStoreCompArttestname;
	public static String inStoreCompArttestdesc;
	public static String inStoreCompArtStdateex;
	public static String inStoreCompArtenddateex;
	public static String inStoreCompArtStartdat;
	public static String inStoreCompArtMEndDate;
	public static Multimap<String, String> inStoreCompArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> inStoreCompArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> inStoreCompArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String inStoreComp1ArtMC = "0";
	public static int inStoreComp1ArtpreCount2 = -1;
	public static String inStoreComp1Arttestname;
	public static String inStoreComp1Arttestdesc;
	public static String inStoreComp1ArtStdateex;
	public static String inStoreComp1Artenddateex;
	public static String inStoreComp1ArtStartdat;
	public static String inStoreComp1ArtMEndDate;
	public static Multimap<String, String> inStoreComp1ArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> inStoreComp1ArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> inStoreComp1ArtModules = new HashMap<String, Multimap<String, String>>();
	
	
	other markdown-advertised
	public static String inStoreOMAArtMC = "0";
	public static int inStoreOMAArtpreCount2 = -1;
	public static String inStoreOMAArttestname;
	public static String inStoreOMAArttestdesc;
	public static String inStoreOMAArtStdateex;
	public static String inStoreOMAArtenddateex;
	public static String inStoreOMAArtStartdat;
	public static String inStoreOMAArtMEndDate;
	public static Multimap<String, String> inStoreOMAArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> inStoreOMAArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> inStoreOMAArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String inStoreOMA1ArtMC = "0";
	public static int inStoreOMA1ArtpreCount2 = -1;
	public static String inStoreOMA1Arttestname;
	public static String inStoreOMA1Arttestdesc;
	public static String inStoreOMA1ArtStdateex;
	public static String inStoreOMA1Artenddateex;
	public static String inStoreOMA1ArtStartdat;
	public static String inStoreOMA1ArtMEndDate;
	public static Multimap<String, String> inStoreOMA1ArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> inStoreOMA1ArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> inStoreOMA1ArtModules = new HashMap<String, Multimap<String, String>>();
	
	
	
	other markdown-local marketing
	public static String inStoreOMLArtMC = "0";
	public static int inStoreOMLArtpreCount2 = -1;
	public static String inStoreOMLArttestname;
	public static String inStoreOMLArttestdesc;
	public static String inStoreOMLArtStdateex;
	public static String inStoreOMLArtenddateex;
	public static String inStoreOMLArtStartdat;
	public static String inStoreOMLArtMEndDate;
	public static Multimap<String, String> inStoreOMLArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> inStoreOMLArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> inStoreOMLArtModules = new HashMap<String, Multimap<String, String>>();
	
	other markdown-Special Activity
	public static String inStoreOMSArtMC = "0";
	public static int inStoreOMSArtpreCount2 = -1;
	public static String inStoreOMSArttestname;
	public static String inStoreOMSArttestdesc;
	public static String inStoreOMSArtStdateex;
	public static String inStoreOMSArtenddateex;
	public static String inStoreOMSArtStartdat;
	public static String inStoreOMSArtMEndDate;
	public static Multimap<String, String> inStoreOMSArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> inStoreOMSArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> inStoreOMSArtModules = new HashMap<String, Multimap<String, String>>();
	
	
	public static String InventoryArtMC = "0";
	public static int InventoryArtpreCount2 = -1;
	public static String InventoryArttestname;
	public static String InventoryArttestdesc;
	public static String InventoryArtStdateex;
	public static String InventoryArtenddateex;
	public static String InventoryArtStartdat;
	public static String InventoryArtMEndDate;
	public static Multimap<String, String> InventoryArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> InventoryArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> InventoryArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String stockTakeArtMC = "0";
	public static int stockTakeArtpreCount2 = -1;
	public static String stockTakeArttestname;
	public static String stockTakeArttestdesc;
	public static String stockTakeArtStdateex;
	public static String stockTakeArtenddateex;
	public static String stockTakeArtStartdat;
	public static String stockTakeArtMEndDate;
	public static Multimap<String, String> stockTakeArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> stockTakeArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> stockTakeArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String stockTransArtMC = "0";
	public static int stockTransArtpreCount2 = -1;
	public static String stockTransArttestname;
	public static String stockTransArttestdesc;
	public static String stockTransArtStdateex;
	public static String stockTransArtenddateex;
	public static String stockTransArtStartdat;
	public static String stockTransArtMEndDate;
	public static Multimap<String, String> stockTransArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> stockTransArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> stockTransArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String orderEnqArtMC = "0";
	public static int orderEnqArtpreCount2 = -1;
	public static String orderEnqArttestname;
	public static String orderEnqArttestdesc;
	public static String orderEnqArtStdateex;
	public static String orderEnqArtenddateex;
	public static String orderEnqArtStartdat;
	public static String orderEnqArtMEndDate;
	public static Multimap<String, String> orderEnqArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> orderEnqArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> orderEnqArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String gapScanArtMC = "0";
	public static int gapScanArtpreCount2 = -1;
	public static String gapScanArttestname;
	public static String gapScanArttestdesc;
	public static String gapScanArtStdateex;
	public static String gapScanArtenddateex;
	public static String gapScanArtStartdat;
	public static String gapScanArtMEndDate;
	public static Multimap<String, String> gapScanArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> gapScanArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> gapScanArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String ltoLocArtMC = "0";
	public static int ltoLocArtpreCount2 = -1;
	public static String ltoLocArttestname;
	public static String ltoLocArttestdesc;
	public static String ltoLocArtStdateex;
	public static String ltoLocArtenddateex;
	public static String ltoLocArtStartdat;
	public static String ltoLocArtMEndDate;
	public static Multimap<String, String> ltoLocArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> ltoLocArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> ltoLocArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String ltoReportArtMC = "0";
	public static int ltoReportArtpreCount2 = -1;
	public static String ltoReportArttestname;
	public static String ltoReportArttestdesc;
	public static String ltoReportArtStdateex;
	public static String ltoReportArtenddateex;
	public static String ltoReportArtStartdat;
	public static String ltoReportArtMEndDate;
	public static Multimap<String, String> ltoReportArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> ltoReportArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> ltoReportArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String oocReportArtMC = "0";
	public static int oocReportArtpreCount2 = -1;
	public static String oocReportArttestname;
	public static String oocReportArttestdesc;
	public static String oocReportArtStdateex;
	public static String oocReportArtenddateex;
	public static String oocReportArtStartdat;
	public static String oocReportArtMEndDate;
	public static Multimap<String, String> oocReportArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> oocReportArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> oocReportArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String RoutinesArtMC = "0";
	public static int RoutinesArtpreCount2 = -1;
	public static String RoutinesArttestname;
	public static String RoutinesArttestdesc;
	public static String RoutinesArtStdateex;
	public static String RoutinesArtenddateex;
	public static String RoutinesArtStartdat;
	public static String RoutinesArtMEndDate;
	public static Multimap<String, String> RoutinesArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> RoutinesArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> RoutinesArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String ReceivingArtMC = "0";
	public static int ReceivingArtpreCount2 = -1;
	public static String ReceivingArttestname;
	public static String ReceivingArttestdesc;
	public static String ReceivingArtStdateex;
	public static String ReceivingArtenddateex;
	public static String ReceivingArtStartdat;
	public static String ReceivingArtMEndDate;
	public static Multimap<String, String> ReceivingArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> ReceivingArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> ReceivingArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String GoodsSummaryArtMC = "0";
	public static int GoodsSummaryArtpreCount2 = -1;
	public static String GoodsSummaryArttestname;
	public static String GoodsSummaryArttestdesc;
	public static String GoodsSummaryArtStdateex;
	public static String GoodsSummaryArtenddateex;
	public static String GoodsSummaryArtStartdat;
	public static String GoodsSummaryArtMEndDate;
	public static Multimap<String, String> GoodsSummaryArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> GoodsSummaryArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> GoodsSummaryArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String LTOAddOrEditArtMC = "0";
	public static int LTOAddOrEditArtpreCount2 = -1;
	public static String LTOAddOrEditArttestname;
	public static String LTOAddOrEditArttestdesc;
	public static String LTOAddOrEditArtStdateex;
	public static String LTOAddOrEditArtenddateex;
	public static String LTOAddOrEditArtStartdat;
	public static String LTOAddOrEditArtMEndDate;
	public static Multimap<String, String> LTOAddOrEditArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> LTOAddOrEditArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> LTOAddOrEditArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String promoEndTypeArtMC = "0";
	public static int promoEndTypeArtpreCount2 = -1;
	public static String promoEndTypeArttestname;
	public static String promoEndTypeArttestdesc;
	public static String promoEndTypeArtStdateex;
	public static String promoEndTypeArtenddateex;
	public static String promoEndTypeArtStartdat;
	public static String promoEndTypeArtMEndDate;
	public static Multimap<String, String> promoEndTypeArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> promoEndTypeArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> promoEndTypeArtModules = new HashMap<String, Multimap<String, String>>();
	
	
	public static String rxSegmentArtMC = "0";
	public static int rxSegmentArtpreCount2 = -1;
	public static String rxSegmentArttestname;
	public static String rxSegmentArttestdesc;
	public static String rxSegmentArtStdateex;
	public static String rxSegmentArtenddateex;
	public static String rxSegmentArtStartdat;
	public static String rxSegmentArtMEndDate;
	public static Multimap<String, String> rxSegmentArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> rxSegmentArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> rxSegmentArtModules = new HashMap<String, Multimap<String, String>>();
	
	
	public static String orderUpdateArtMC = "0";
	public static int orderUpdateArtpreCount2 = -1;
	public static String orderUpdateArttestname;
	public static String orderUpdateArttestdesc;
	public static String orderUpdateArtStdateex;
	public static String orderUpdateArtenddateex;
	public static String orderUpdateArtStartdat;
	public static String orderUpdateArtMEndDate;
	public static Multimap<String, String>orderUpdateArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String>orderUpdateArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>>orderUpdateArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String ReturnToVendorArtMC = "0";
	public static int ReturnToVendorArtpreCount2 = -1;
	public static String ReturnToVendorArttestname;
	public static String ReturnToVendorArttestdesc;
	public static String ReturnToVendorArtStdateex;
	public static String ReturnToVendorArtenddateex;
	public static String ReturnToVendorArtStartdat;
	public static String ReturnToVendorArtMEndDate;
	public static Multimap<String, String> ReturnToVendorArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> ReturnToVendorArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> ReturnToVendorArtModules = new HashMap<String, Multimap<String, String>>();
	
	
	public static String orderCreateArtMC = "0";
	public static int orderCreateArtpreCount2 = -1;
	public static String orderCreateArttestname;
	public static String orderCreateArttestdesc;
	public static String orderCreateArtStdateex;
	public static String orderCreateArtenddateex;
	public static String orderCreateArtStartdat;
	public static String orderCreateArtMEndDate;
	public static Multimap<String, String>orderCreateArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String>orderCreateArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>>orderCreateArtModules = new HashMap<String, Multimap<String, String>>();
	
	public static String repairsSparesArtMC = "0";
	public static int repairsSparesArtpreCount2 = -1;
	public static String repairsSparesArttestname;
	public static String repairsSparesArttestdesc;
	public static String repairsSparesArtStdateex;
	public static String repairsSparesArtenddateex;
	public static String repairsSparesArtStartdat;
	public static String repairsSparesArtMEndDate;
	public static Multimap<String, String> repairsSparesArtTime = ArrayListMultimap
			.create();
	public static Multimap<String, String> repairsSparesArtScenarios = ArrayListMultimap
			.create();
	public static HashMap<String, Multimap<String, String>> repairsSparesArtModules = new HashMap<String, Multimap<String, String>>();
	*/
	
	
	
public static void Report_Header(String ReportType, File reportPath, String module, String dat) throws IOException{
	switch (ReportType){
	case "Summary":
		HR_Header_Summary(reportPath, ReportType, module, dat);
		break;
	case "testcase":
		HR_Header_TestCase(reportPath, module, dat);
		break;
	} 
}

public static void HR_Steps_TestCase(File f, String scnName,
		String ShortDesc, String act, String exp, String status)
		throws IOException {

	File file = new File(f + "\\" + scnName + ".html");
	writer = new BufferedWriter(new FileWriter(file, true));
	strStepNo = Func_LeftPad(strStepNo, 1);
	if (strStepNo % 2 == 0) {
		writer.write("<tr bgcolor = DCF0F0>"); // writer.write("<tr bgcolor = aliceblue>")
	} else {
		writer.write("<tr bgcolor = #CCFFFF>"); // writer.write("<tr bgcolor = Azure>")
	}

	writer.write("<td width=10%>");
	writer.write("<p align=center><font face=Verdana size=2>" + strStepNo
			+ "</td>");
	writer.write("<td width=60%>");
	writer.write("<p align=left><font face=Verdana size=2>" + ShortDesc
			+ "</td>");

	writer.write("<td width=10%>");
	writer.write("<p align=left><font face=Verdana size=2 word-wrap: break-word>"
			+ act + "</td>");

	writer.write("<td width=10%>");
	writer.write("<p align=left><font face=Verdana size=2 word-wrap: break-word>"
			+ exp + "</td>");
	writer.write("<td height=23 width=10%>");

	if (status.equals("Fail")) {
		inFailCnt = inFailCnt + 1;
		writer.write("<p align = center><b><a href='" + captureScreenShot()
				+ "'><font face= Verdana  size= 2 color= #FF0000>" + status
				+ "</font></b></td>");
	} else {
		inPassCnt = inPassCnt + 1;
		writer.write("<p align = center><b><font face= Verdana size= 2 color= #008000>"
				+ status + "</font></b></td>");
	}
	writer.write("</tr>");
	writer.close();
}

public static void Report_Footer(String ReportType, String sName,
		String mName, String stTime, String stEndTime,String manualTC) throws IOException,
		ParseException {
	switch (ReportType) {
	case "summary":
		HR_Footer_Summary(reportPath, mName, stTime, stEndTime,manualTC);
		break;
	case "testcase":
		HR_Footer_TestCase(reportPath, sName, mName, stTime, stEndTime);
		break;
	}
}

public static void HR_Footer_TestCase(File f, String scName,
		String modName, String stTime, String stEndTime)
		throws IOException, ParseException {

	File file = new File(f + "\\" + scName + ".html");
	writer = new BufferedWriter(new FileWriter(file, true));

	int strTotalSteps = strStepNo;
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 5 >");
	// Date dateendtime = new Date();

	writer.write("<p align=center><b><font color=#800080 size=2 face= Verdana> "
			+ "Test case Execution Time : "
			+ TimeDiff1(stTime, stEndTime)
			+ "&nbsp;");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("<tr bgcolor =aliceblue>");
	writer.write("<td colspan= 5 align=right>");
	writer.write("<table width=350 border=0 cellspacing =1 cellpadding=1>");	
	writer.write("<tr><td width=30% height=15 align=right><b><font color= green face= Verdana size=1>"
			+ "Total # of steps"
			+ "</td></font><td width=35% height=15><b><font color= #000080 face= Verdana size=1>: &nbsp;&nbsp;"
			+ Func_LeftPad(strTotalSteps, 0) + "</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= green face= Verdana size=1>"
			+ "# of steps Passed"
			+ "</font></td><td width=35% height=15><b><font color= green face= Verdana size=1>: &nbsp;&nbsp;"
			+ Func_LeftPad(inPassCnt, 0) + "</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #FF3333 face= Verdana size=1>"
			+ "# of steps Failed"
			+ "</font></td><td width=35% height=15><b><font color= ff3333 face= Verdana size=1>: &nbsp;&nbsp;"
			+ Func_LeftPad(inFailCnt, 0) + "</font></b></td></tr>");
	writer.write("</table>");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("</Body>");
	writer.write("<table align=center border=0 width=80% height=31>");

	writer.write("<td width=40% align=right><a href='./Summary_"
			+ modName
			+ ".html' style=text-decoration: none><font color= #000080 size=2 face= Verdana><b>"
			+ "�Summary Report" + "</b></a></font></td></tr>");

	writer.write("</table>");
	writer.write("</html>");
	writer.close();
}

public static void Main_Steps_Summary(File f, String stModName,String manualTC)
		throws IOException, ParseException {
	// Steps SUMMAY
	File file = new File(f + "\\Summary.html");
	writer = new BufferedWriter(new FileWriter(file, true));
	totPass = totPass + inSumPass;
	totFail = totFail + inSumFail;
	totScripts = totScripts + inSumStep1;
	inSum1 = Func_LeftPad(inSum1, 1);
	if (inSum1 % 2 == 0) {
		writer.write("<tr bgcolor = DCF0F0>"); // writer.write("<tr bgcolor = aliceblue>")
	} else {
		writer.write("<tr bgcolor = #CCFFFF>"); // writer.write("<tr bgcolor = Azure>")
	}
	writer.write("<td width=10%>");
	writer.write("<p align=center><font face=Verdana size=2>" + inSum1
			+ "</td>");
	writer.write("<td width=30%>");
	writer.write("<p align=left>&nbsp;<a href='"
			+ "./Summary_"
			+ stModName
			+ ".html'  style='text-decoration: none'><font color= #000080 size=2 face= Verdana><b>"
			+ stModName + "</b></font></a></td>");
	
	writer.write("<td width=10%>");
	writer.write("<p align=center><font face=Garamond size=3 color= #000080><b>"

			+ manualTC + "</b></td>");
	
	writer.write("<td width=20%>");
	writer.write("<p align=center><font face=Verdana size=2 color= #000080><b>"
			+ inSumStep1 + "</b></td>");
	writer.write("<td width=20%>");
	writer.write("<p align=center><font face=Verdana size=2 color= green><b>"
			+ Func_LeftPad(inSumPass, 0) + "</b></td>");
	writer.write("<td width=20%>");
	writer.write("<p align=center><font face=Verdana size=2 color= #FF3333><b>"
			+ Func_LeftPad(inSumFail, 0) + "</b></td>");
	writer.write("</tr>");
	writer.close();
}

public static void HR_Footer_Summary(File f, String mName, String stTime,
		String stEndTime,String manualTC) throws IOException, ParseException {
	int innerLoop;
	int strTotalTestCase;
	File file = new File(f + "\\Summary_" + mName + ".html");
	writer = new BufferedWriter(new FileWriter(file, true));

	//manualTestCaseCount = Integer.parseInt(manualTC);
	manualTestCaseCount = manualTC;
	
	// sumedDate = Now()
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 4 >");
	// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	// Date date2 = new Date();
	writer.write("<p align=center><b><font color=#800080 size=2 face= Verdana> "
			+ "Total Execution Time : "
			+ TimeDiff1(stTime, stEndTime)
			+ "&nbsp;");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("<tr bgcolor =aliceblue>");
	writer.write("<td colspan= 4 align=right>");
	writer.write("<table width=350 border=0 cellspacing =1 cellpadding=1>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #000080 face= Verdana size=1>"
			+ "Total Manual Test Cases"
			+ "</td></font><td width=35% height=15><b><font color= #000080 face= Verdana size=1>: &nbsp;&nbsp;"
			+ manualTestCaseCount + "</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #000080 face= Verdana size=1>"
			+ "Total # of Test Cases"
			+ "</td></font><td width=35% height=15><b><font color= #000080 face= Verdana size=1>: &nbsp;&nbsp;"
			+ inSumStep1 + "</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= green face= Verdana size=1>"
			+ "# of Test Cases Passed"
			+ "</font></td><td width=35% height=15><b><font color= green face= Verdana size=1>: &nbsp;&nbsp;"
			+ Func_LeftPad(inSumPass, 0) + "</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #FF3333 face= Verdana size=1>"
			+ "# of Test Cases Failed"
			+ "</font></td><td width=35% height=15><b><font color= ff3333 face= Verdana size=1>: &nbsp;&nbsp;"
			+ Func_LeftPad(inSumFail, 0) + "</font></b></td></tr>");
	writer.write("</table>");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("</blockquote>");
	writer.write("</Body>");
	writer.write("<table align=center border=0 width=80% height=31>");
	writer.write("<td width=40% align=right><a href='./Summary.html'><font color= #000080 size=2 face= Verdana><b>"
			+ "�Summary Report" + "</b></a></font></td></tr>");
	writer.write("</table>");

	writer.write("</HTML>");
	writer.close();
}
public static void Report_AddStep_Equal(String module, String actual,String expected,String message) throws IOException{
	if (actual.equalsIgnoreCase(expected)) {
		Report_AddStep("testcase", "Equal", actual, expected, "Pass");

	} else {
		Report_AddStep("testcase", "Equal", actual, expected, "Fail");
	}
}

public static void Report_AddStep_Contains(String module, String actual,String expected,String message) throws IOException{
	if (actual.contains(expected)) {
		Report_AddStep("testcase", "Contains", actual, expected, "Pass");

	} else {
		Report_AddStep("testcase", "Contains", actual, expected, "Fail");
	}
}


public static void Report_AddStep(String ReportType, String desc, String actual, String expected, String status) throws IOException{
switch(ReportType){
	case "summary":
		HR_Steps_Summary(reportPath, desc, actual, expected);
			  break;
	case "testcase":
			//  HR_Steps_TestCase(reportPath, actual, expected, desc, status);
			  break;
}
}

public static String TimeDiff1(String date2, String date22)
		throws ParseException {

	DateFormat df6 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date stTime1 = df6.parse(date2.toString());
	Date enTime1 = df6.parse(date22.toString());

	long diff = enTime1.getTime() - stTime1.getTime();

	long diffSeconds = diff / 1000 % 60;
	long diffMinutes = diff / (60 * 1000) % 60;
	long diffHours = diff / (60 * 60 * 1000) % 24;
	long diffDays = diff / (24 * 60 * 60 * 1000);

	System.out.print(diffDays + " days, ");
	System.out.print(diffHours + " hours, ");
	System.out.print(diffMinutes + " minutes, ");
	System.out.print(diffSeconds + " seconds.");
	return diffHours + " hours, " + diffMinutes + " minutes, "
			+ diffSeconds + " seconds.";
}

public static void Main_Footer_Summary(File f, String sumDat1)
		throws IOException, ParseException {
	int innerLoop;
	int strTotalTestCase;
	File file = new File(f + "\\Summary.html");
	writer = new BufferedWriter(new FileWriter(file, true));

	// sumedDate = Now()
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 6 >");
	Date dtSuiteAf = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String stafterSuite = dateFormat.format(dtSuiteAf);

	writer.write("<p align=center><b><font color=#800080 size=2 face= Verdana> "
			+ "Total Execution Time : "
			+ TimeDiff1(sumDat1, stafterSuite)
			+ "&nbsp;");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("<tr bgcolor =aliceblue>");
	writer.write("<td colspan= 6 align=right>");
	writer.write("<table width=350 border=0 cellspacing =1 cellpadding=1>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #000080 face= Verdana size=1>"
			+ "Total Manual Scripts "
			+ "</td></font><td width=35% height=15><b><font color= #000080 face= Verdana size=1>: &nbsp;&nbsp;"
			+ manualCount + "</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #000080 face= Verdana size=1>"
			+ "Total # of Scripts "
			+ "</td></font><td width=35% height=15><b><font color= #000080 face= Verdana size=1>: &nbsp;&nbsp;"
			+ totScripts + "</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= green face= Verdana size=1>"
			+ "# of Test Scripts Passed"
			+ "</font></td><td width=35% height=15><b><font color= green face= Verdana size=1>: &nbsp;&nbsp;"
			+ Func_LeftPad(totPass, 0) + "</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #FF3333 face= Verdana size=1>"
			+ "# of Test Scripts Failed"
			+ "</font></td><td width=35% height=15><b><font color= ff3333 face= Verdana size=1>: &nbsp;&nbsp;"
			+ Func_LeftPad(totFail, 0) + "</font></b></td></tr>");
	writer.write("</table>");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("</blockquote>");
	writer.write("</Body>");
	writer.write("</HTML>");
	writer.close();
}


public static void Main_Header_Summary(File f, String dateex)
		throws IOException, ParseException {
	if (!f.exists())
		f.mkdirs();
	File file = new File(f + "\\Summary.html");
	if (!file.exists())
		file.createNewFile();
	writer = new BufferedWriter(new FileWriter(file));
	// Set fleHtml =f.CreateTextFile(ReportPath + "Summary-Reports.html",
	// True);
	writer.write("<html>");
	writer.write("<head>");
	writer.write("<meta http-equiv= Content-Language content= en-us>");
	writer.write("<meta http-equiv= Content-Type content= text/html; charset=windows-1252>");
	writer.write("<title>Test Suite- " + dateex + "</title>");
	writer.write("</head>");
	writer.write("<body>");
	writer.write("<blockquote>");
	// writer.write("<p align=center><img src='" & Environment("LogoFile") &
	// "' alt= PRODUCT_LOGO></p>");
	writer.write("<table align=center border=1 bordercolor=#000000 id=table1 width=80% height=35>");
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 4>");
	writer.write("<p align=center><font color=#5B2C6F size=4 face= Verdana>Layby Automation Summary Report</font></p>");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("</table>");
	writer.write("<table align=center border=1 bordercolor=#000000 id=table2 width=80% height=35>");

	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 6 >");
	writer.write("<p align=center><b><font color=#5B2C6F size=2 face=Verdana>"
			+ "&nbsp;"
			+ "Start Date & Time :&nbsp;&nbsp;"
			+ dateex
			+ "&nbsp;");
	writer.write("</td>");
	writer.write("</tr>");
	
	//xmmni
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 6 >");
	writer.write("<p align=center><b><font color=#5B2C6F size=2 face=Verdana>"
			+ "&nbsp;"
			+ "Store :&nbsp;&nbsp;"
			+ 1786
			+ "&nbsp;");
	writer.write("</td>");
	writer.write("</tr>");

	writer.write("<tr bgcolor= #1560BD>");
	writer.write("<td width= 10%");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana  size= 2 >"
			+ "S.No" + "</b></td>");
	writer.write("<td width= 10%");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana  size=2>"
			+ "Module Name" + "</b></td>");
	writer.write("<td width=20%>");
	writer.write("<p align=center><b><font color = #FFFFFF face= Verdana size= 2>"
			+ "Manual test case count" + "</b></td>");
	writer.write("<td width=20%>");
	writer.write("<p align=center><b><font color = #FFFFFF face= Verdana size= 2>"
			+ "Total Scripts Executed" + "</b></td>");
	writer.write("<td width=20%>");
	writer.write("<p align=center><b><font color = #FFFFFF face= Verdana size= 2>"
			+ "Pass Count" + "</b></td>");
	writer.write("<td width=20%>");
	writer.write("<p align=center><b><font color = #FFFFFF face= Verdana size= 2>"
			+ "Fail Count" + "</b></td>");
	writer.write("</tr>");
	writer.close();
}



public static void HR_Steps_TestCase (File f, String act, String exp, String ShortDesc, String status) throws IOException
{
	
	File file = new File(f +"\\"+ moduledesc +".html");
	writer = new BufferedWriter(new FileWriter(file,true));
	strStepNo = Func_LeftPad(strStepNo, 1);
	if(strStepNo % 2 == 0){
		writer.write("<tr bgcolor = DCF0F0>");			//writer.write("<tr bgcolor = aliceblue>")
	}else{
		writer.write("<tr bgcolor = #CCFFFF>");					//writer.write("<tr bgcolor = Azure>")	
	}

	writer.write("<td width=10%>");
	writer.write("<p align=center><font face=Verdana size=2>"+  strStepNo + "</td>");	
	writer.write("<td width=60%>");
	writer.write("<p align=left><font face=Verdana size=2>" + ShortDesc + "</td>");
	
	writer.write("<td width=10%>");
	writer.write("<p align=left><font face=Verdana size=2>"+ act +"</td>");
	
	writer.write("<td width=10%>");
	writer.write("<p align=left><font face=Verdana size=2>"+ exp +"</td>");
	writer.write("<td height=23 width=10%>");
	
	if(status == "Fail"){ 
			inFailCnt = inFailCnt +1;
            writer.write("<p align = center><b><a href='"+ captureScreenShot() +"'><font face= Verdana  size= 2 color= #FF0000>" + status + "</font></b></td>");
	}else{
			inPassCnt = inPassCnt +1;
			writer.write("<p align = center><b><font face= Verdana size= 2 color= #008000>" + status + "</font></b></td>");
	}
	writer.write("</tr>");
	writer.close();
}


public static void HR_Steps_Summary(File f, String scName, String modName,
		String sumDesc) throws IOException {

	File file = new File(f + "\\Summary_" + modName + ".html");
	writer = new BufferedWriter(new FileWriter(file, true));

	inSumStep1 = Func_LeftPad(inSumStep1, 1);
	if (inSumStep1 % 2 == 0) {
		writer.write("<tr bgcolor = DCF0F0>"); // writer.write("<tr bgcolor = aliceblue>")
	} else {
		writer.write("<tr bgcolor = #CCFFFF>"); // writer.write("<tr bgcolor = Azure>")
	}
	writer.write("<td width=10%>");
	writer.write("<p align=center><font face=Verdana size=2>" + inSumStep1
			+ "</td>");
	writer.write("<td width=20%>");
	// ' writer.write("<p align=left>&nbsp;<a href='"+ ptMdlPath &
	// TestCaseNo &".html'><font color= #000080 size=2 face= Verdana>"&
	// TestCaseNo &"</font></a></td>")
	// f +"\\"+ Heading +".html"
	writer.write("<p align=left>&nbsp;<a href='" + "./" + scName
			+ ".html'><font color= #000080 size=2 face= Verdana>" + scName
			+ "</font></a></td>");
	writer.write("<td width=60%>");
	writer.write("<p align=left><font face=Verdana size=2>" + sumDesc
			+ "</td>");
	writer.write("<td height=23 width=10%>");

	if (inFailCnt != 0) {
		inSumFail = inSumFail + 1;
		writer.write("<p align = center><b><font face= Verdana  size= 2 color= #FF0000>"
				+ "FAIL" + "</font></b></td>");
	} else if (inPassCnt != 0) {
		inSumPass = inSumPass + 1;
		writer.write("<p align = center><b><font face= Verdana size= 2 color= #008000>"
				+ "PASS" + "</font></b></td>");
	}

	writer.write("</tr>");
	writer.close();
}

public static void HR_Header_Summary(File f, String reportType,
		String string, String string2) throws IOException {
	inSumStep1 = 0;
	inSumPass = 0;
	inSumFail = 0;

	if (!f.exists())
		f.mkdirs();

	/*
	 * for (File file: f.listFiles()) { if (!file.isDirectory())
	 * file.delete(); }
	 */

	File file = new File(f + "\\Summary_" + string + ".html");
	if (!file.exists())
		file.createNewFile();
	writer = new BufferedWriter(new FileWriter(file));
	// Set fleHtml =f.CreateTextFile(ReportPath + "Summary-Reports.html",
	// True);
	writer.write("<html>");
	writer.write("<head>");
	writer.write("<meta http-equiv= Content-Language content= en-us>");
	writer.write("<meta http-equiv= Content-Type content= text/html; charset=windows-1252>");
	writer.write("<title>Test Suite- " + string2 + "</title>");
	writer.write("</head>");
	writer.write("<body>");
	writer.write("<blockquote>");
	// writer.write("<p align=center><img src='" & Environment("LogoFile") &
	// "' alt= PRODUCT_LOGO></p>");
	writer.write("<table align=center border=1 bordercolor=#000000 id=table1 width=80% height=35>");
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 4>");
	writer.write("<p align=center><font color=#000080 size=4 face= Verdana>Module : "
			+ string + "</font></p>");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("</table>");

	writer.write("<table align=center border=1 bordercolor=#000000 id=table2 width=80% height=35>");
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 4 >");
	writer.write("<p align=center><b><font color=#000080 size=2 face=Verdana>"
			+ "&nbsp;" + "Date & Time :&nbsp;&nbsp;" + string2 + "&nbsp;");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("<tr bgcolor= #1560BD>");
	writer.write("<td width= 10%");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana  size= 2 >"
			+ "S.No" + "</b></td>");
	writer.write("<td width= 20%");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana  size=2>"
			+ "Module Name" + "</b></td>");
	writer.write("<td width=60%>");
	writer.write("<p align=center><b><font color = #FFFFFF face= Verdana size= 2>"
			+ "Short Description" + "</b></td>");
	writer.write("<td width=10%>");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana size= 2>"
			+ "Status" + "</b></td>");
	writer.write("</tr>");
	//
	/*
	 * writer.write("</body>"); writer.write("</html>");
	 */
	writer.close();
}

public static void HR_Header_TestCase(File f, String Heading,
		String dateFrom) throws IOException {
	strStepNo = 0;
	inPassCnt = 0;
	inFailCnt = 0;
	if (!f.exists())
		f.mkdirs();
	File file = new File(f + "\\" + Heading + ".html");
	if (!file.exists())
		file.createNewFile();
	writer = new BufferedWriter(new FileWriter(file));
	writer.write("<html>");
	writer.write("<head>");
	writer.write("<meta http-equiv= Content-Language content= en-us>");
	writer.write("<meta http-equiv= Content-Type content= text/html; charset=windows-1252>");
	writer.write("<title>Test Suite- " + dateFrom + "</title>");
	writer.write("</head>");
	writer.write("<body>");
	writer.write("<blockquote>");
	// 'writer.write("<p align=center><img src='" & Environment("LogoFile")
	// & "' alt= PRODUCT_LOGO></p>")
	writer.write("<table align=center border=1 bordercolor=#000000 id=table1 width=80% height=35>");
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 4>");
	writer.write("<p align=center><font color=#000080 size=4 face= Verdana>"
			+ Heading + "</font></p>");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("</table>");
	writer.write("<table align=center border=1 bordercolor=#000000 id=table2 width=80% height=35>");
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 4 >");
	writer.write("<p align=center><b><font color=#000080 size=2 face=Verdana>"
			+ "&nbsp;" + "Date & Time :&nbsp;&nbsp;" + dateFrom + "&nbsp;");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("<tr bgcolor= #1560BD>");
	writer.write("<td width= 10%");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana  size= 2 >"
			+ "S.No" + "</b></td>");
	/*
	 * writer.write("<td width= 20%"); writer.write(
	 * "<p align= center><b><font color = #FFFFFF face= Verdana  size=2>" +
	 * "Test Case #" + "</b></td>");
	 */
	writer.write("<td width=60%>");
	writer.write("<p align=center><b><font color = #FFFFFF face= Verdana size= 2>"
			+ "Short Description" + "</b></td>");
	writer.write("<td width= 10%");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana  size=2>"
			+ "Act(Appln)" + "</b></td>");
	writer.write("<td width= 10%");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana  size=2>"
			+ "Exp(DB)" + "</b></td>");
	writer.write("<td width=10%>");
	writer.write("<p align= center><b><font color = #FFFFFF face= Verdana size= 2>"
			+ "Status" + "</b></td>");
	writer.write("</tr>");
	writer.write("</blockquote>");
	writer.write("</body>");
	writer.write("</html>");
	writer.close();
}

public static int Func_LeftPad (int strText, int intLen)						// Padding a given character to String
{

	int a =  strText+ intLen;
	return a;
}

public static void HR_Footer_TestCase(File f) throws IOException, ParseException{

	File file = new File(f +"\\"+ moduledesc +".html");
		writer = new BufferedWriter(new FileWriter(file,true));

	int strTotalSteps= strStepNo;
	writer.write("<tr bgcolor = aliceblue>");
	writer.write("<td COLSPAN = 5 >");
	Date dateendtime = new Date();
	writer.write("<p align=center><b><font color=#800080 size=2 face= Verdana> " + "Test case Execution Time : "  + TimeDiff(testcasesttime, dateendtime) + "&nbsp;");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("<tr bgcolor =aliceblue>");
	writer.write("<td colspan= 5 align=right>");
	writer.write("<table width=350 border=0 cellspacing =1 cellpadding=1>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #000080 face= Verdana size=1>" + "Total # of steps" +"</td></font><td width=35% height=15><b><font color= #000080 face= Verdana size=1>: &nbsp;&nbsp;"+ Func_LeftPad(strTotalSteps,0) +"</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= green face= Verdana size=1>"+ "# of steps Passed"+"</font></td><td width=35% height=15><b><font color= green face= Verdana size=1>: &nbsp;&nbsp;"+ Func_LeftPad(inPassCnt ,0) +"</font></td></b></tr>");
	writer.write("<tr><td width=30% height=15 align=right><b><font color= #FF3333 face= Verdana size=1>" + "# of steps Failed"+"</font></td><td width=35% height=15><b><font color= ff3333 face= Verdana size=1>: &nbsp;&nbsp;"+ Func_LeftPad(inFailCnt ,0) +"</font></b></td></tr>");
	writer.write("</table>");
	writer.write("</td>");
	writer.write("</tr>");
	writer.write("</Body>");
	writer.write("<table align=center border=0 width=80% height=31>");
	  
	writer.write("<td width=40% align=right><a href='./Summary.html'><font color= #000080 size=2 face= Verdana><b>" + "�Summary Report" + "</b></a></font></td></tr>");
	
	writer.write("</table>");
	writer.write("</html>");
	writer.close();
}

public static String TimeDiff(Date date2 , Date date22) throws ParseException{
		long diff = date22.getTime() - date2.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
		return diffHours + " hours, " + diffMinutes + " minutes, " +  diffSeconds + " seconds.";
}


public static String captureScreenShot() throws IOException {
	String time = null;
	  try{
		  
	       // Thread.sleep(10000);
	        long id = Thread.currentThread().getId();
	        BufferedImage image = new Robot().createScreenCapture(new Rectangle(
	            Toolkit.getDefaultToolkit().getScreenSize()));
	        time= GetTimeStampValue();
	        ImageIO.write(image, "png", new File(reportPath+"\\Screenshots\\"+time+".png"));
	    }
	    catch( Exception e ) {
	        e.printStackTrace();
	    }
	  	return "./Screenshots/"+time+".png";
	  }

public static  String GetTimeStampValue()throws IOException{
  Calendar cal = Calendar.getInstance();       
  Date time=cal.getTime();
  String timestamp=time.toString();
  System.out.println(timestamp);
  String systime=timestamp.replace(":", "-");
  systime=systime.replace(" ", "");
  System.out.println(systime);
  return systime;
}

}
/*manual_stockAdj = 
manual_DSCandPLU = 
manual_Inventory = 
manual_stockTake = 
manual_stockTrans = 
manual_Receiving = 
manual_ltoLoc = 
manual_gapScan = 
manual_ltoReport = 
manual_oocReport = 
manual_Routines = */
