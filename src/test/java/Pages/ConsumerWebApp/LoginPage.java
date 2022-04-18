package Pages.ConsumerWebApp;

import org.openqa.selenium.By;
import java.awt.Robot;

import java.awt.AWTException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import CommonUtility.GenericMethods;
import org.openqa.selenium.support.ui.Select;
import TestNGListeners.ApcoaListeners;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
//import antlr.collections.List;
import java.util.List;

import java.io.*;
import java.lang.Thread;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//h1[text()='Welcome Back']")
	WebElement text;

	@FindBy(id = "userName")
	WebElement emailele;

	@FindBy(id = "password")
	WebElement passwordele;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbtn;

	@FindBy(xpath = "//a[@href='/admin/permit']")
	WebElement permitmanagment;

	@FindBy(xpath = "//a[@href='/admin/permit/create']")
	WebElement createpermitbutton;

	@FindBy(xpath = "//div[@id='parkingId']")
	WebElement selectparkingidinsession;

	@FindBy(xpath = "//li[@id='7']")
	WebElement selectelitetestcarpark;
	@FindBy(xpath = "//li[@id='1']")
	WebElement selectapcoastagtestcarpart;

	@FindBy(xpath = "//li[@id='113']")
	WebElement selectgmpstagtestcarpart;

	@FindBy(xpath = "//li[@id='7']")
	WebElement selectgmpqatestcarpart;

	@FindBy(xpath = "//div[@id='permit']")
	WebElement slectpermitdropdown;
	@FindBy(xpath = "//input[@id='parking']")
	WebElement searchparkingdropdown;

	@FindBy(xpath = "//div[@id='parking']")
	WebElement slectparkingdropdown;

	@FindBy(xpath = "//div[@id='paymentType']")
	WebElement slectpaymentdropdown;

	@FindBy(xpath = "//li[@id='2']")
	WebElement selectpermitapcoastag;

	@FindBy(xpath = "//li[@id='0']")
	WebElement selectpermitgmpqa;

	@FindBy(xpath = "//li[@id='0']")
	WebElement selectpermitelite;

	@FindBy(xpath = "//li[@id='0']")
	WebElement slectpermitgmpstag;

	@FindBy(xpath = "//ul[@role='listbox']")
	WebElement scrollpermit;

	@FindBy(xpath = "//div[@id='userType']")
	WebElement selectusertype;

	@FindBy(xpath = "//li[@data-value='Consumer Id']")
	WebElement selectconsumerId;

	@FindBy(xpath = "//div[@id='searchType']")
	WebElement slectsearchtype;

	@FindBy(xpath = "//button[@class='ant-modal-close']")
	WebElement successbuttonafterbuypermit;

	@FindBy(xpath = "//span[@class='ant-modal-close-x']")
	WebElement successbuttonafterbuypermit2;

	@FindBy(xpath = "//div[@id='accessType']")
	WebElement accessmethodtype;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateText() {
		ApcoaListeners.logInfo("Checking the text");
		return text.isDisplayed();
	}

	public void enterCredentials(String email, String password) {
		ApcoaListeners.logInfo("Going to enter credentials");
		emailele.sendKeys(email);
		passwordele.sendKeys(password);
		System.out.println(email + password);
		ApcoaListeners.logInfo("Sucessfully Entered email: " + email);
		ApcoaListeners.logInfo("Sucessfully Entered password: " + password);
	}

	public void selectparking(String Brand) {
		System.out.println("upar ka chala upar ka");
		List<WebElement> brand = driver.findElements(By.xpath("//li[@class='ant-select-dropdown-menu-item']"));

		for (WebElement brandlist : brand) {

			String brandName = brandlist.getText();// store all text from dropdown
			System.out.println(brandName + "," + Brand);

			if (brandName.length() > 1) {
				if (brandName.equals(Brand))// search for the value to click

				{
					// System.out.println("mil gaya");
					// System.out.println(brandName);
					brandlist.click();// click
					break;

				}
			}
		}
	}

	public void selectpermit(String Brand) {

		List<WebElement> brand = driver.findElements(By.xpath("//li[@role='option']"));

		for (WebElement brandlist : brand) {

			String brandName = brandlist.getText();// store all text from dropdown
			// System.out.println(brandName);
			if (brandName.length() > 1) {
				if (brandName.contains(Brand))// search for the value to click

				{
					brandlist.click();
					break;
				}
			}
		}
	}

	public void selectpaymentmethod(String Brand) {

		List<WebElement> brand = driver.findElements(By.xpath("//li[@role='option']"));

		for (WebElement brandlist : brand) {

			String brandName = brandlist.getText();// store all text from dropdown
			// System.out.println(brandName);
			if (brandName.length() > 1) {
				if (brandName.contains(Brand))// search for the value to click

				{
					brandlist.click();
				}
			}
		}
	}

	public void sleep() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}

	public void clickLoginBtn() {
		ApcoaListeners.logInfo("Going to click Continure ");
		GenericMethods.explicitWait(this.driver, By.xpath("//button[@type='submit']"), 10);
		loginbtn.sendKeys(Keys.RETURN);
		ApcoaListeners.logInfo("Clicked on Continue Sucessfully");
		permitmanagment.click();
		createpermitbutton.click();

		// select permit master
		slectparkingdropdown.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		searchparkingdropdown.sendKeys("g");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		selectparking("GMP [enable working]");

		// select permit dropdown
		slectpermitdropdown.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}

		// click on permit
		selectpermit("3rd party payment");

		// select conusumer userid as input
		selectusertype.click();
		// selectconsumerId.click();
		selectpermit("Consumer Id");

		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		// enter conusemr user id
		this.driver.findElement(By.xpath("(//input[@id='userData'])")).sendKeys("106811");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		// click enter after enterint userid
		this.driver.findElement(By.xpath("(//span[@class='ant-input-suffix'])")).click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		// select the conseumer id
		List<WebElement> brand = driver.findElements(By.xpath("//button[@class='ant-btn ant-btn-link']"));
		int ok = 0;
		for (WebElement brandlist : brand) {
			if (ok == 1) {
				brandlist.click();
			}

			ok += 1;
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		// slect the car for the user
		this.driver.findElement(By.xpath("(//input[@class='ant-checkbox-input'])")).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}

		// confirm and procees button
		this.driver.findElement(By.xpath("(//button[@class='ant-btn sc-cmTdod drDJGm ant-btn-primary'])")).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		// proccet to payment button
		this.driver.findElement(By.xpath("(//button[@class='ant-btn sc-cmTdod drDJGm ant-btn-primary'])")).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		// slect payment method
		slectpaymentdropdown.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		// slect payment method == cash
		selectpaymentmethod("External Party Payment");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}

		// clicking on date picker
		this.driver.findElement(By.xpath("(//input[@class='ant-calendar-picker-input ant-input'])")).click();

		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		// slectint date == today
		this.driver.findElement(By.xpath("(//a[@class='ant-calendar-today-btn '])")).click();
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}

		// clicking on ok after buy permit pop
		this.driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-block'])")).click();
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		try {
			Robot robot = new Robot();
			robot.mouseMove(10, 5);
			Actions actions = new Actions(this.driver);
			actions.click().build().perform();
		} catch (Exception e) {

		}

		// session creation part coding#################################################

		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		// clicing on cosumer support
		List<WebElement> brand1 = this.driver.findElements(By.xpath("//div[@class='ant-menu-submenu-title']"));
		int ok1 = 0;
		for (WebElement brandlist : brand1) {
			if (ok1 == 1) {
				brandlist.click();
			}

			ok1 += 1;
		}

		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		// clicking on users
		this.driver.findElement(By.xpath("(//a[@href='/admin/consumers'])")).click();
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		// entering cosumer user id
		this.driver.findElement(By.xpath("(//input[@id='consumerId'])")).sendKeys("106811");
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		// hiting enter after entering user id
		this.driver.findElement(By.xpath("(//button[@class='ant-btn sc-dnqmqq iPGAyJ ant-btn-primary'])")).click();
		//
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		// directaly going to start sessino page
		// this.driver.findElement(By.xpath("(//a[@href='/admin/consumers/106811'])")).click();
		this.driver.findElement(By.linkText("106811")).click();

		try {
			Thread.sleep(2500);
		} catch (Exception e) {

		}
		this.driver.findElement(By.xpath("(//a[@href='/admin/consumers/106811/start-session'])")).click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		// selecting parking in start sessin page

		selectparkingidinsession.click();
		try {
			Thread.sleep(3500);
		} catch (Exception e) {

		}
		// selecting parking == for elite parking
		selectparking("GMP [enable working]");
		// adding comm
		this.driver.findElement(By.xpath("(//input[@class='ant-input'])")).sendKeys("ok sending this commnent");
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		accessmethodtype.click();
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		List<WebElement> brand3 = this.driver.findElements(By.xpath("//li[@role='option']"));
		for (WebElement brandlist : brand3) {
			String brandName = brandlist.getText();
			System.out.print(brandName);
			if (brandName.contains("LPR")) {
				brandlist.click();
			}
		}
		try {
			Thread.sleep(2500);
		} catch (Exception e) {

		}
		// clicking on start session button
		this.driver.findElement(By.xpath("(//button[@class='ant-btn sc-cmTdod drDJGm ant-btn-primary'])")).click();

	}

}
