package Pages.ConsumerWebApp;

import java.awt.Robot;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import CommonUtility.AutomationConfiguration;
import ConsumerWebApp.ObjectMapper.PermitMapper;
import TestNGListeners.ApcoaListeners;

public class buy3rdpartypermit {
	WebDriver driver;
	SoftAssert SA = new SoftAssert();




	@FindBy(xpath = "//a[@href='/admin/permit']")
	WebElement permitmanagment;

	@FindBy(xpath = "//a[@href='/admin/permit/create']")
	WebElement createpermitbutton;

	@FindBy(xpath = "//div[@id='parkingId']")
	WebElement selectparkingidinsession;

	

	@FindBy(xpath = "//div[@id='permit']")
	WebElement slectpermitdropdown;
	@FindBy(xpath = "//input[@id='parking']")
	WebElement searchparkingdropdown;

	@FindBy(xpath = "//div[@id='parking']")
	WebElement slectparkingdropdown;

	@FindBy(xpath = "//div[@id='paymentType']")
	WebElement slectpaymentdropdown;

	

	@FindBy(xpath = "//div[@id='userType']")
	WebElement selectusertype;

	@FindBy(xpath = "//li[text()='Consumer Id']")
	WebElement selectconsumerId;

	@FindBy(xpath = "//div[@id='searchType']")
	WebElement slectsearchtype;

	@FindBy(xpath = "//button[@class='ant-modal-close']")
	WebElement successbuttonafterbuypermit;

	@FindBy(xpath = "//span[@class='ant-modal-close-x']")
	WebElement successbuttonafterbuypermit2;

	@FindBy(xpath = "//div[@id='accessType']")
	WebElement accessmethodtype;
	
	@FindBy(xpath = "(//span[text()='Select']")
	WebElement xpath2_1;
	
	
//	@FindBy(xpath = "(//button[@class='ant-btn sc-cmTdod drDJGm ant-btn-primary'])")
//	WebElement xpath4;
	
	@FindBy(xpath = "(//input[@id='userData'])")
	WebElement xpath1;
	@FindBy(xpath = "(//span[@class='ant-input-suffix'])")
	WebElement xpath2;
	@FindBy(xpath = "((//input[@class='ant-checkbox-input'])[2]")
	WebElement xpath3;
	
	@FindBy(xpath = "(//button[@class='ant-btn sc-cmTdod drDJGm ant-btn-primary'])")
	WebElement xpath4;
	@FindBy(xpath = "(//button[@class='ant-btn sc-cmTdod drDJGm ant-btn-primary'])")
	WebElement xpath5;
	@FindBy(xpath = "(//input[@class='ant-calendar-picker-input ant-input'])")
	WebElement xpath6;
	@FindBy(xpath = "(//a[text()='Now'])")
	WebElement xpath7;
	

	public buy3rdpartypermit(WebDriver driver) {
		this.driver = driver;
	}

	public void function_to_scroll_permit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("function_to_scroll_permit");
		List<WebElement> brand_with_role  = driver.findElements(By.xpath("//ul[@role='listbox']"));
		System.out.println(brand_with_role.size());
		WebElement parking_ul=brand_with_role.get(0);
		WebElement permit_ul=brand_with_role.get(1);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", permit_ul);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", permit_ul);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", permit_ul);
			System.out.println(permit_ul.getText());
			System.out.println("working with 1");
		}
		catch(Exception e) {
			System.out.println("not working with 1");
		}
		
		
		try {
			
			JavascriptExecutor executor = (JavascriptExecutor)AutomationConfiguration.Driver;
			//executor.executeScript("document.querySelector(\"ul.ant-select-dropdown-menu\").scrollTop=400");
			executor.executeScript("document.querySelector(permit_ul).scrollTop=400");
			System.out.println("second  working");
			
		}
		catch (Exception e) {
			System.out.println("second not working");
		}
		try {
				WebElement ele = driver.findElement(By.xpath("//li[contains(text(),'gmp')]"));
				JavascriptExecutor executor = (JavascriptExecutor)AutomationConfiguration.Driver;
				executor.executeScript("arguments[0].click();", ele);
		}
		catch (Exception e) {
			JavascriptExecutor executor1 = (JavascriptExecutor)AutomationConfiguration.Driver;
			executor1.executeScript("document.querySelector(\"ul.ant-select-dropdown-menu\").scrollTop=800");
			executor1.executeScript("document.querySelector(\"ul.ant-select-dropdown-menu\").scrollTop=800");
			executor1.executeScript("document.querySelector(\"ul.ant-select-dropdown-menu\").scrollTop=800");
		}
		try {
			WebElement l=driver.findElement(By.xpath("//*[text()='Select parking to view permits']"));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
			System.out.println("3 working");
		}
		catch (Exception e) {
			System.out.println("3 not working");
		}
		
	}
	public void ScollElement(String Xpath) {
		
		
		
		System.out.println("running scrool function");
		try {
			WebElement webElement = driver.findElement(By.xpath(Xpath));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
			System.out.println("first working");
			
		}
		catch (Exception e) {
			System.out.println("first not working");
		}
		try {
			
			JavascriptExecutor executor = (JavascriptExecutor)AutomationConfiguration.Driver;
			executor.executeScript("document.querySelector(\"ul.ant-select-dropdown-menu\").scrollTop=400");
			System.out.println("second  working");
			
		}
		catch (Exception e) {
			System.out.println("second not working");
		}
		try {
			
			WebElement element = driver.findElement(By.xpath(Xpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			System.out.println("third  working");
			
		}
		catch (Exception e) {
			System.out.println("third not working");
		}
		
	}
	
	public void ScrollParking() {
		JavascriptExecutor executor = (JavascriptExecutor)AutomationConfiguration.Driver;
		executor.executeScript("document.querySelector(\"ul.ant-select-dropdown-menu\").scrollTop=400");
	}
	public void ScrollPermit() {
		List<WebElement> permit_list = driver.findElements(By.xpath("//li[@role='option']"));
		int n=permit_list.size();
		WebElement LastElement=permit_list.get(n-1);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", LastElement);
	}


	public void selectpaymentmethod(String Brand) {
		try {Thread.sleep(1000);}catch (InterruptedException e) {}
		List<WebElement> brand = driver.findElements(By.xpath("//li[@role='option']"));
		
		for (WebElement brandlist : brand) {

			String brandName = brandlist.getText();// store all text from dropdown
			if (brandName.length() > 1) {
				if (brandName.equals(Brand))// search for the value to click
				{
					brandlist.click();
				}
			}
		}
		
	}
	
	public void selectpermit(String Brand) {
		System.out.println("selectpermit function ");
		try {Thread.sleep(2000);}catch (InterruptedException e) {}
		
		List<WebElement> permit_list = driver.findElements(By.xpath("//li[@role='option']"));
		System.out.println(permit_list.size());
		System.out.println("print permit name brand_with_class");
		for(WebElement i:permit_list) {
			System.out.println(i.getText()+" ");
		}
		int loop=10;
		int is_found=0;
		while(loop>0 && is_found==0) {
			List<WebElement> permit_list_here = driver.findElements(By.xpath("//li[@role='option']"));
			for (WebElement brandlist : permit_list_here) {
				String brandName = brandlist.getText();// store all text from dropdown
				if (brandName.length() > 1) {
					if (brandName.contains(Brand))// search for the value to click
					{
						brandlist.click();
						is_found=1;
						break;
					}
				}
			}
			if(is_found==0) {
				ScrollPermit();
			}
		}
		if(is_found==0) {
			ApcoaListeners.logInfo(Brand+"permit not found");
		}
		
	}
	
	public void selectparking(String Brand) {
			System.out.print("select parking function");
			try {Thread.sleep(2000);}catch (InterruptedException e) {}
			int loop=10;
			int is_found=0;
			while(loop>0 && is_found==0) {
				List<WebElement> brand_with_role_here  = driver.findElements(By.xpath("//li[@role='option']"));
				for(WebElement i:brand_with_role_here) {
					System.out.println(i.getText()+" ");
					if(i.getText().equalsIgnoreCase(Brand)) {
						i.click();
						is_found=1;
						break;
					}
				}
				if(is_found==0)
					ScrollParking();
			}
			if(is_found==0) {
				ApcoaListeners.logInfo(Brand+"parking not found");
			}
			SA.assertNotEquals(is_found, 0);

		
	}

	public void buy3rdpartypermit(String consumerId,String ParkingName,String PermitName) {
		
		//clicking on permit managment button
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,permitmanagment,20);
		permitmanagment.click();
		
		//clicking on create new permit button
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,createpermitbutton,20);
		createpermitbutton.click();
		
		
		
		// select parking
		// clicking on select parking dropdown
		slectparkingdropdown.click();
		// selectintg desirec permit
		selectparking(ParkingName);
		
		
		
		
		// select permit dropdown
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,slectpermitdropdown,20);
		slectpermitdropdown.click();
		
		// click on select permit
		selectpermit(PermitName);
		
		
		// select conusumer userid as input
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,selectusertype,20);
		selectusertype.click();
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,selectconsumerId,20);
		selectconsumerId.click();

		// enter conusemr user id
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,xpath1,20);
		xpath1.sendKeys(consumerId);
		
		// click enter after enterint userid
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,xpath2,20);
		xpath2.click();
		
		// select the conseumer id
		
		try {Thread.sleep(1000);}catch (InterruptedException e) {}
		
		 List<WebElement> brand = driver.findElements(By.xpath("//button[@class='ant-btn ant-btn-link']"));
		 // clicking on select button after entering user id
		 brand.get(1).click();
		 try {Thread.sleep(3000);}catch (InterruptedException e) {}
		 
		

		// slect the car for the user
		 
		 List<WebElement> allvehicle = driver.findElements(By.xpath("//input[@class='ant-checkbox-input']"));
		 int allvehicle_size=allvehicle.size();
		 System.out.println(allvehicle_size);
		 allvehicle.get(1).click();
		 
		
		// confirm and procees button
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,xpath4,20);
		xpath4.click();
		// proccet to payment button
		try {Thread.sleep(1000);}catch (InterruptedException e) {}
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,xpath5,20);
		xpath5.click();

		// slect payment method
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,slectpaymentdropdown,20);
		slectpaymentdropdown.click();

		// slect payment method == External Party Payment
		selectpaymentmethod("External Party Payment");

		// clicking on date picker
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,xpath6,20);
		xpath6.click();
		// slectint date == today
		try {Thread.sleep(3000);}catch (InterruptedException e) {}
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,xpath7,20);
		xpath7.click();

		// clicking on ok after buy permit pop
		this.driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-block'])")).click();
		try {Thread.sleep(3000);}catch (InterruptedException e) {}
		try {
			Robot robot = new Robot();
			robot.mouseMove(10, 5);
			Actions actions = new Actions(this.driver);
			actions.click().build().perform();
		} catch (Exception e) {}

		//		// session creation part coding#################################################
		//
		//		try {
		//			Thread.sleep(1500);
		//		} catch (Exception e) {
		//
		//		}
		//		// clicing on cosumer support
		//		List<WebElement> brand1 = this.driver.findElements(By.xpath("//div[@class='ant-menu-submenu-title']"));
		//		int ok1 = 0;
		//		for (WebElement brandlist : brand1) {
		//			if (ok1 == 1) {
		//				brandlist.click();
		//			}
		//
		//			ok1 += 1;
		//		}
		//
		//		try {
		//			Thread.sleep(1500);
		//		} catch (Exception e) {
		//
		//		}
		//		// clicking on users
		//		this.driver.findElement(By.xpath("(//a[@href='/admin/consumers'])")).click();
		//		try {
		//			Thread.sleep(1500);
		//		} catch (Exception e) {
		//
		//		}
		//		// entering cosumer user id
		//		this.driver.findElement(By.xpath("(//input[@id='consumerId'])")).sendKeys("106811");
		//		try {
		//			Thread.sleep(1500);
		//		} catch (Exception e) {
		//
		//		}
		//		// hiting enter after entering user id
		//		this.driver.findElement(By.xpath("(//button[@class='ant-btn sc-dnqmqq iPGAyJ ant-btn-primary'])")).click();
		//		//
		//		try {
		//			Thread.sleep(1500);
		//		} catch (Exception e) {
		//
		//		}
		//		// directaly going to start sessino page
		//		// this.driver.findElement(By.xpath("(//a[@href='/admin/consumers/106811'])")).click();
		//		this.driver.findElement(By.linkText("106811")).click();
		//
		//		try {
		//			Thread.sleep(2500);
		//		} catch (Exception e) {
		//
		//		}
		//		this.driver.findElement(By.xpath("(//a[@href='/admin/consumers/106811/start-session'])")).click();
		//		try {
		//			Thread.sleep(5000);
		//		} catch (Exception e) {
		//
		//		}
		//		// selecting parking in start sessin page
		//
		//		selectparkingidinsession.click();
		//		try {
		//			Thread.sleep(3500);
		//		} catch (Exception e) {
		//
		//		}
		//		// selecting parking == for elite parking
		//		selectparking("GMP [enable working]");
		//		// adding comm
		//		this.driver.findElement(By.xpath("(//input[@class='ant-input'])")).sendKeys("ok sending this commnent");
		//		try {
		//			Thread.sleep(1500);
		//		} catch (Exception e) {
		//
		//		}
		//		accessmethodtype.click();
		//		try {
		//			Thread.sleep(1500);
		//		} catch (Exception e) {
		//
		//		}
		//		List<WebElement> brand3 = this.driver.findElements(By.xpath("//li[@role='option']"));
		//		for (WebElement brandlist : brand3) {
		//			String brandName = brandlist.getText();
		//			System.out.print(brandName);
		//			if (brandName.contains("LPR")) {
		//				brandlist.click();
		//			}
		//		}
		//		try {
		//			Thread.sleep(2500);
		//		} catch (Exception e) {
		//
		//		}
		//		// clicking on start session button
		//		this.driver.findElement(By.xpath("(//button[@class='ant-btn sc-cmTdod drDJGm ant-btn-primary'])")).click();

	}
}
