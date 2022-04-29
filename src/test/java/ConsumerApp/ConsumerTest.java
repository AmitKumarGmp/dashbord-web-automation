/*
-------------------------------------------------------------
Author Name: Hemant Rautela

Date:13-Jan-2022

Purpose /Description: Implementation of Data Providers and Test cases for the  
                     automation of Consumer Web Portals.
	
-------------------------------------------------------------

 */

package ConsumerApp;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import CommonUtility.AutomationConfiguration;
import CommonUtility.CreateSession;
import ConsumerWebApp.ObjectMapper.LocationMapper;
import ConsumerWebApp.ObjectMapper.LoginMapper;
import ConsumerWebApp.ObjectMapper.ProfileMapper;
import ConsumerWebApp.ObjectMapper.PermitMapper;
import ConsumerWebApp.ObjectMapper.UrlMapper;
import DataDriven.ExcelDriven;
import Pages.ConsumerWebApp.ApprovalConveniencePage;
import Pages.ConsumerWebApp.ApprovalDiscountPage;
import Pages.ConsumerWebApp.ApprovalDocumentPage;
import Pages.ConsumerWebApp.ApprovalNormalPage;
import Pages.ConsumerWebApp.ApprovalVatPage;
import Pages.ConsumerWebApp.ChooseLocationPage;
import Pages.ConsumerWebApp.DirectConveniencePage;
import Pages.ConsumerWebApp.DirectDiscountPage;
import Pages.ConsumerWebApp.DirectNormalPage;
import Pages.ConsumerWebApp.DirectVatPage;
import Pages.ConsumerWebApp.GoToPage;
import Pages.ConsumerWebApp.HomePage;
import Pages.ConsumerWebApp.LoginPage;
import Pages.ConsumerWebApp.buy3rdpartypermit;
import Pages.ConsumerWebApp.PaymentPage;
import Pages.ConsumerWebApp.ProfilePage;
import Pages.ConsumerWebApp.SelectParkingPage;
import Pages.ConsumerWebApp.VechilePage;
import junit.framework.Assert;

public class ConsumerTest {

	@Parameters({ "Runner" ,"consumerId","ParkingName","PermitName"})
	@BeforeSuite
	public void initializeDriver(String runner,String consumerId,String ParkingName,String PermitName) throws IOException {
		System.err.close();
		System.setErr(System.out);
		System.out.println(runner);
		AutomationConfiguration.Runner = runner;
		AutomationConfiguration.consumerId = consumerId;
		AutomationConfiguration.ParkingName=ParkingName;
		AutomationConfiguration.PermitName=PermitName;
		CreateSession.readConfigFile("/src/test/java/resources/configConsumerApp.properties");

	}

	/***
	 * Provides the data for login (email & password)
	 */

	@DataProvider
	public LoginMapper[] getLoginData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		System.out.print(AutomationConfiguration.Runner);
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner, "Login");
		ObjectMapper mapper = new ObjectMapper();
		LoginMapper[] login = new LoginMapper[1];
		login[0] = mapper.readValue(data, LoginMapper.class);
		return login;
	}

	/***
	 * Provides the URL
	 */

	@DataProvider
	public UrlMapper[] getUrlData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner, "URL");
		ObjectMapper mapper = new ObjectMapper();
		UrlMapper[] url = new UrlMapper[1];
		url[0] = mapper.readValue(data, UrlMapper.class);
		return url;
	}

	/***
	 * Provides the Location data
	 */

	@DataProvider
	public LocationMapper[] getLocationData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner, "Location");
		ObjectMapper mapper = new ObjectMapper();
		LocationMapper[] LocationData = new LocationMapper[1];
		LocationData[0] = mapper.readValue(data, LocationMapper.class);
		return LocationData;
	}

	/***
	 * Provides the My_Profile details
	 */

	@DataProvider
	public ProfileMapper[] getProfileData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner, "Myprofile");
		ObjectMapper mapper = new ObjectMapper();
		ProfileMapper[] ProfileData = new ProfileMapper[1];
		ProfileData[0] = mapper.readValue(data, ProfileMapper.class);
		return ProfileData;
	}

	/***
	 * Provides the permit to send for approval
	 */

	@DataProvider
	public PermitMapper[] getNormalApprovalData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner, "ApprovalNormal");
		ObjectMapper mapper = new ObjectMapper();
		PermitMapper[] ApprovalData = new PermitMapper[1];
		ApprovalData[0] = mapper.readValue(data, PermitMapper.class);
		return ApprovalData;
	}

	@DataProvider
	public PermitMapper[] getDocumentApprovalData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner,
				"ApprovalDocument");
		ObjectMapper mapper = new ObjectMapper();
		PermitMapper[] ApprovalData = new PermitMapper[1];
		ApprovalData[0] = mapper.readValue(data, PermitMapper.class);
		return ApprovalData;
	}

	/***
	 * Provides the permit to send for approval
	 */

	@DataProvider
	public PermitMapper[] getVatApprovalData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner, "ApprovalVat");
		ObjectMapper mapper = new ObjectMapper();
		PermitMapper[] ApprovalData = new PermitMapper[1];
		ApprovalData[0] = mapper.readValue(data, PermitMapper.class);
		return ApprovalData;
	}

	/***
	 * Provides the permit to send for approval
	 */

	@DataProvider
	public PermitMapper[] getConvenienceApprovalData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner,
				"ApprovalConvenience");
		ObjectMapper mapper = new ObjectMapper();
		PermitMapper[] ApprovalData = new PermitMapper[1];
		ApprovalData[0] = mapper.readValue(data, PermitMapper.class);
		return ApprovalData;
	}

	/***
	 * Provides the permit for direct buy
	 */

	@DataProvider
	public PermitMapper[] getNormalDirectData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner, "DirectNormal");
		ObjectMapper mapper = new ObjectMapper();
		PermitMapper[] DirectData = new PermitMapper[1];
		DirectData[0] = mapper.readValue(data, PermitMapper.class);
		return DirectData;
	}

	/***
	 * Provides the permit for direct buy
	 */

	@DataProvider
	public PermitMapper[] getVatDirectData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner, "DirectVat");
		ObjectMapper mapper = new ObjectMapper();
		PermitMapper[] DirectData = new PermitMapper[1];
		DirectData[0] = mapper.readValue(data, PermitMapper.class);
		return DirectData;
	}

	/***
	 * Provides the permit for direct buy
	 */

	@DataProvider
	public PermitMapper[] getConvenienceDirectData() throws Exception {
		String excelfilepath = System.getProperty("user.dir") + "/src/test/java/resources/ConsumerApp.xlsx";
		ExcelDriven.readExcelFile(excelfilepath, "ConsumerApp");
		String data = ExcelDriven.readDataRowandColumn("ConsumerApp", AutomationConfiguration.Runner,
				"DirectConvenience");
		ObjectMapper mapper = new ObjectMapper();
		PermitMapper[] DirectData = new PermitMapper[1];
		DirectData[0] = mapper.readValue(data, PermitMapper.class);
		return DirectData;
	}

	/***
	 * Test for URL
	 */
	@Test(priority = 0, dataProvider = "getUrlData")
	public void gotoUrl(UrlMapper urlMapper) {
		AutomationConfiguration.Driver.get(urlMapper.getUrl());
//		AutomationConfiguration.Driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

	/***
	 * Test for home page
	 */
	// @Test(priority=1)
	// public void home() throws InterruptedException{
	// Thread.sleep(2000);
	// HomePage login = new HomePage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,login);
	// login.validateText();
	// login.clickLogin();
	// }

	/***
	 * Test for login credentials
	 */
	@Test(priority = 2, dataProvider = "getLoginData")
	public void login(LoginMapper loginMapper) throws InterruptedException {
		Thread.sleep(2000);
		LoginPage login = new LoginPage(AutomationConfiguration.Driver);
		PageFactory.initElements(AutomationConfiguration.Driver, login);
		login.enterCredentials(loginMapper.getUseremail(), loginMapper.getPassword());
		login.clickLoginBtn();
	}

	/***
	 * buy permit with third party payment method
	 */

	@Test(priority = 3, dataProvider = "getLoginData")
	public void buy3rdpartypermit(LoginMapper buy3rdpartypermit) throws InterruptedException {
		Thread.sleep(2000);
		buy3rdpartypermit buy3rdpermit = new buy3rdpartypermit(AutomationConfiguration.Driver);
		PageFactory.initElements(AutomationConfiguration.Driver, buy3rdpermit);
		buy3rdpermit.buy3rdpartypermit(AutomationConfiguration.consumerId,AutomationConfiguration.ParkingName,AutomationConfiguration.PermitName);

	}

	// @Test(priority=3)
	// public void goTo() throws InterruptedException{
	// GoToPage goto_ = new GoToPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,goto_);
	// goto_.name();
	// Thread.sleep(2000);
	// goto_.profile();
	//
	// }
	//
	// @Test(priority=4)
	// public void Profile() throws InterruptedException{
	// ProfilePage details = new ProfilePage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,details);
	// details.contactNumber();
	// details.city();
	// details.country();
	// }
	//
	// @Test(priority=5)
	// public void addVechile() throws InterruptedException{
	// VechilePage car = new VechilePage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,car);
	// car.addVechile();
	// }
	//
	//// @Test(priority=6,dataProvider="getLocationData")
	//// public void documentLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	//// ChooseLocationPage choose = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver,choose);
	//// choose.enterLocation(locationMapper.getLocation());
	//// }
	////
	//// /***
	//// * Test for selecting approval permit
	//// *
	//// */
	//// @Test(priority=7,dataProvider="getDocumentApprovalData")
	//// public void documentApproval(PermitMapper permitMapper) throws Exception{
	////
	//// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	//// parking.choosePermit(permitMapper);
	////
	//// ApprovalDocumentPage send = new
	// ApprovalDocumentPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver,send);
	//// boolean flag =send.validateText();
	//// Assert.assertTrue(flag);
	//// send.selectPermit(permitMapper);
	//// send.clicks();
	//// Thread.sleep(3000);
	//// send.uploadDocument();
	//// String cost = send.validateAmount();
	//// Thread.sleep(2000);
	//// send.approve();
	//// Thread.sleep(3000);
	//// send.check();
	//// Thread.sleep(2000);
	//// String price = send.verifyAmount();
	//// Assert.assertEquals(cost,price);
	//// }
	//
	//
	// /***
	// * Test for Location
	// */
	// @Test(priority=6,dataProvider="getLocationData")
	// public void normalLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	// ChooseLocationPage choose = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,choose);
	// choose.enterLocation(locationMapper.getLocation());
	//
	// }
	//
	// /***
	// * Test for selecting approval permit
	// */
	// @Test(priority=7,dataProvider="getNormalApprovalData")
	// public void normalApproval(PermitMapper permitMapper) throws Throwable{
	//
	// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	// parking.choosePermit(permitMapper);
	//
	// ApprovalNormalPage send = new
	// ApprovalNormalPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,send);
	// boolean flag =send.validateText();
	// Assert.assertTrue(flag);
	// send.selectPermit(permitMapper);
	// send.clicks();
	// Thread.sleep(2000);
	// String cost = send.validateAmount();
	// Thread.sleep(3000);
	// send.approve();
	// Thread.sleep(3000);
	// send.check();
	// Thread.sleep(2000);
	// String price = send.verifyAmount();
	// Assert.assertEquals(cost,price);
	// }
	//
	// /***
	// * Test for Location
	// */
	// @Test(priority=8,dataProvider="getLocationData")
	// public void vatApprovalLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	// ChooseLocationPage choose = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,choose);
	// choose.enterLocation(locationMapper.getLocation());
	// }
	// /***
	// * Test for selecting approval permit
	// */
	// @Test(priority=9,dataProvider="getVatApprovalData")
	// public void vatApproval(PermitMapper permitMapper) throws
	// InterruptedException, AWTException{
	//
	// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	// parking.choosePermit(permitMapper);
	//
	// ApprovalVatPage send = new ApprovalVatPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,send);
	// boolean flag =send.validateText();
	// Assert.assertTrue(flag);
	// send.selectPermit(permitMapper);
	// send.clicks();
	// Thread.sleep(2000);
	// String cost = send.validateAmount();
	// Thread.sleep(3000);
	// send.approve();
	// Thread.sleep(3000);
	// send.check();
	// Thread.sleep(2000);
	// String price = send.verifyAmount();
	// Assert.assertEquals(cost,price);
	// }
	//
	// /***
	// * Test for Location
	// */
	// @Test(priority=10,dataProvider="getLocationData")
	// public void vatConveniencelLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	// ChooseLocationPage choose = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,choose);
	// choose.enterLocation(locationMapper.getLocation());
	// }
	// /***
	// * Test for selecting approval permit
	// */
	// @Test(priority=11,dataProvider="getConvenienceApprovalData")
	// public void convenienceApproval(PermitMapper permitMapper) throws
	// InterruptedException{
	//
	// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	// parking.choosePermit(permitMapper);
	//
	// ApprovalConveniencePage send = new
	// ApprovalConveniencePage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,send);
	// boolean flag =send.validateText();
	// Assert.assertTrue(flag);
	// send.selectPermit(permitMapper);
	// send.clicks();
	// Thread.sleep(2000);
	// String cost = send.validateAmount();
	// Thread.sleep(3000);
	// send.approve();
	// Thread.sleep(3000);
	// send.check();
	// Thread.sleep(2000);
	// String price = send.verifyAmount();
	// Assert.assertEquals(cost,price);
	// }
	//
	//// /***
	//// * Test for Location
	//// */
	//// @Test(priority=14,dataProvider="getLocationData")
	//// public void discountApprovalLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	//// ChooseLocationPage choose = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver,choose);
	//// choose.enterLocation(locationMapper.getLocation());
	//// }
	//// /***
	//// * Test for selecting approval permit
	//// */
	//// @Test(priority=15,dataProvider="getNormalApprovalData")
	//// public void discountApproval(PermitMapper permitMapper) throws
	// InterruptedException{
	////
	//// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	//// parking.choosePermit(permitMapper);
	////
	//// ApprovalDiscountPage send = new
	// ApprovalDiscountPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver,send);
	//// boolean flag =send.validateText();
	//// Assert.assertTrue(flag);
	//// send.selectPermit(permitMapper);
	//// send.clicks();
	//// send.enterDiscount(permitMapper.getApprovalcode());
	//// String cost = send.validateAmount();
	//// send.approve();
	//// Thread.sleep(3000);
	//// send.check();
	//// Thread.sleep(2000);
	//// String price = send.verifyAmount();
	//// Assert.assertEquals(cost,price);
	////
	//// }
	//
	// /***
	// * Test for selecting location for direct buy permit
	// */
	// @Test(priority=12,dataProvider="getLocationData")
	// public void normaLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	// ChooseLocationPage clicks = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,clicks);
	// clicks.enterLocation(locationMapper.getLocation());
	// }
	// /***
	// * Test for selecting direct buy permit
	// */
	// @Test(priority=13,dataProvider="getNormalDirectData")
	// public void normalPermit(PermitMapper permitMapper) throws
	// InterruptedException{
	//
	// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	// parking.choosePermit(permitMapper);
	//
	// DirectNormalPage buy = new DirectNormalPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,buy);
	// boolean flag =buy.validateText();
	// Assert.assertTrue(flag);
	// buy.buyPermit(permitMapper);
	// buy.clicks();
	// Thread.sleep(2000);
	// String cost = buy.validateAmount();
	// Thread.sleep(3000);
	// buy.directBuy();
	// buy.active();
	// Thread.sleep(3000);
	// buy.check();
	// Thread.sleep(2000);
	// String price = buy.verifyAmount();
	// Assert.assertEquals(cost,price);
	// }
	//
	// /***
	// * Test for selecting location for direct buy permit
	// */
	// @Test(priority=14,dataProvider="getLocationData")
	// public void vatLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	// ChooseLocationPage clicks = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,clicks);
	// clicks.enterLocation(locationMapper.getLocation());
	// }
	// /***
	// * Test for selecting direct buy permit
	// */
	// @Test(priority=15,dataProvider="getVatDirectData")
	// public void vatPermit(PermitMapper permitMapper) throws InterruptedException{
	//
	// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	// parking.choosePermit(permitMapper);
	//
	// DirectVatPage buy = new DirectVatPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,buy);
	// boolean flag =buy.validateText();
	// Assert.assertTrue(flag);
	// buy.buyPermit(permitMapper);
	// buy.clicks();
	// Thread.sleep(2000);
	// String cost = buy.validateAmount();
	// Thread.sleep(3000);
	// buy.directBuy();
	// buy.active();
	// Thread.sleep(3000);
	// buy.check();
	// Thread.sleep(2000);
	// String price = buy.verifyAmount();
	// Assert.assertEquals(cost,price);
	// }
	//
	// /***
	// * Test for selecting location for direct buy permit
	// */
	// @Test(priority=16,dataProvider="getLocationData")
	// public void convenienceLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	// ChooseLocationPage clicks = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,clicks);
	// clicks.enterLocation(locationMapper.getLocation());
	// }
	// /***
	// * Test for selecting direct buy permit
	// */
	// @Test(priority=17,dataProvider="getConvenienceDirectData")
	// public void conveniencePermit(PermitMapper permitMapper) throws
	// InterruptedException{
	//
	// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	// parking.choosePermit(permitMapper);
	//
	// DirectConveniencePage buy = new
	// DirectConveniencePage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,buy);
	// boolean flag =buy.validateText();
	// Assert.assertTrue(flag);
	// buy.buyPermit(permitMapper);
	// buy.clicks();
	// Thread.sleep(2000);
	// String cost = buy.validateAmount();
	// Thread.sleep(3000);
	// buy.directBuy();
	// buy.active();
	// Thread.sleep(3000);
	// buy.check();
	// Thread.sleep(2000);
	// String price = buy.verifyAmount();
	// Assert.assertEquals(cost,price);
	// }
	//
	// @Test(priority=17,dataProvider="getLocationData")
	// public void autoLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	// ChooseLocationPage clicks = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,clicks);
	// clicks.enterLocation(locationMapper.getLocation());
	// }
	// /***
	// * Test for selecting direct buy permit
	// */
	// @Test(priority=18,dataProvider="getConvenienceDirectData")
	// public void autoPermit(PermitMapper permitMapper) throws
	// InterruptedException{
	//
	// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	// parking.choosePermit(permitMapper);
	//
	// DirectConveniencePage buy = new
	// DirectConveniencePage(AutomationConfiguration.Driver);
	// PageFactory.initElements(AutomationConfiguration.Driver,buy);
	// boolean flag =buy.validateText();
	// Assert.assertTrue(flag);
	// buy.buyPermit(permitMapper);
	// buy.clicks();
	// Thread.sleep(2000);
	// String cost = buy.validateAmount();
	// Thread.sleep(3000);
	// buy.directBuy();
	// buy.active();
	// Thread.sleep(3000);
	// buy.check();
	// Thread.sleep(2000);
	// String price = buy.verifyAmount();
	// Assert.assertEquals(cost,price);
	// }
	//
	//// /***
	//// * Test for Location
	//// */
	//// @Test(priority=22,dataProvider="getLocationData")
	//// public void discountDirectLocation(LocationMapper locationMapper) throws
	// InterruptedException{
	//// ChooseLocationPage choose = new
	// ChooseLocationPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver,choose);
	//// choose.enterLocation(locationMapper.getLocation());
	//// }
	//// /***
	//// * Test for selecting approval permit
	//// */
	//// @Test(priority=23,dataProvider="getNormalDirectData")
	//// public void directDiscount(PermitMapper permitMapper) throws
	// InterruptedException{
	////
	//// SelectParkingPage parking = new
	// SelectParkingPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver, parking);
	//// parking.choosePermit(permitMapper);
	////
	//// DirectDiscountPage buy = new
	// DirectDiscountPage(AutomationConfiguration.Driver);
	//// PageFactory.initElements(AutomationConfiguration.Driver,buy);
	//// boolean flag =buy.validateText();
	//// Assert.assertTrue(flag);
	//// buy.buyPermit(permitMapper);
	//// buy.clicks();
	//// buy.enterDiscount(permitMapper.getDirectcode());
	//// String cost = buy.validateAmount();
	//// buy.directBuy();
	//// buy.active();
	//// Thread.sleep(3000);
	//// buy.check();
	//// Thread.sleep(2000);
	//// String price = buy.verifyAmount();
	//// Assert.assertEquals(cost,price);
	//// }
	//
}