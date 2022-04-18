package Pages.ConsumerWebApp;

import java.math.BigInteger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestNGListeners.ApcoaListeners;

public class PaymentPage {
	WebDriver driver;

	@FindBy(xpath = "//p[text()='Payment method']")
	WebElement payment;

	@FindBy(xpath = "//p[text()='Add a payment method']")
	WebElement addPayment;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "fullName")
	WebElement name;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(xpath = "//button[@role='link']")
	WebElement button;

	@FindBy(id = "ccnumber")
	WebElement card;

	@FindBy(id = "zip")
	WebElement zipcode;

	@FindBy(id = "ccexp")
	WebElement expire;

	@FindBy(css = "input[placeholder='Enter your card number']")
	WebElement creditCard;

	@FindBy(className = "card-expiration")
	WebElement expiration;

	@FindBy(className = "card-cvv")
	WebElement cvv;

	@FindBy(name = "displayName")
	WebElement nickName;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addCard() {
		ApcoaListeners.logInfo("Clicking on Add vechile ");
		payment.click();
		addPayment.click();
		email.sendKeys("testing@yopmail.com");
		name.sendKeys("Test test");
		address.sendKeys("123Street");
		country.sendKeys("India");
		city.sendKeys("Bangalore");
		state.sendKeys("Karnataka");
		zipcode.sendKeys("263002");
		button.click();
		// card.click();
		// card.sendKeys(String.valueOf(cardNumber));

	}

	// public void creditCard() {
	// BigInteger bigInt = new BigInteger(cardNumber);
	// ApcoaListeners.logInfo("Clicking on Add vechile ");
	// creditCard.click();
	// creditCard.sendKeys(cardNumber);
	// expiration.sendKeys("923");
	// WebDriverWait wait = new WebDriverWait(driver,30);
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter
	// your card number']")));
	// creditCard.sendKeys(cardNumber);
	// double cardNum= 4111111111111111;
	// JavascriptExecutor js= (JavascriptExecutor)driver;
	// WebElement cardNum= driver.findElement(By.id("ccnumber"));
	// js.executeScript
	// ("document.getElementById('ccnumber').value=4111111111111111");

	// long cardNum= 4111111111111111L;
	// WebElement inputField= driver.findElement(By.id("ccnumber"));
	// JavascriptExecutor js= (JavascriptExecutor) driver;
	//// js.executeScript("document.getElementById('ccnumber').click()");
	//// js.executeScript("arguments[0].value = arguments[1]; ", cardNum,
	// inputField);
	// js.executeScript("document.getElementById('ccnumber').setAttribute('value',4111111111111111)");
	// }

	// public void enterCardDetails() {
	// long cardNumber=4111111111111111;
	// for (int i = 0; i < cardNumber.length(); i++) {
	// char c = cardNumber.charAt(i);
	// String s = new StringBuilder().append(c).toString();
	// driver.findElement(By.id("ccnumber")).sendKeys(s);
	// }
	// }

}
