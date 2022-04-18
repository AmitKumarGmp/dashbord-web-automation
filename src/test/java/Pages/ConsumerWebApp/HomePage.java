package Pages.ConsumerWebApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import TestNGListeners.ApcoaListeners;

public class HomePage {

	WebDriver driver;

	@FindBy(id = "headingTextBig")
	WebElement text;

	@FindBy(xpath = "//p[contains(text(),'Login')]")
	WebElement login;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateText() {
		ApcoaListeners.logInfo("Checking the text");
		return text.isDisplayed();
	}

	public void clickLogin() {
		ApcoaListeners.logInfo("Going to click login button");
		login.click();
		ApcoaListeners.logInfo("Login button clicked sucessfully");
	}

}
