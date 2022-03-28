package Pages.ConsumerWebApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import TestNGListeners.ApcoaListeners;

public class ProfilePage{
	WebDriver driver;
	
	@FindBy(css="input[name='phoneNumber']")
	WebElement contactnumber;
	
	@FindBy(name="addressFirstLine")
	WebElement area;
	
	@FindBy(name="city")
	WebElement town;
	
	@FindBy(name="state")
	WebElement place;
	
	@FindBy(name="country")
	WebElement nation;
	
	@FindBy(name="zipCode")
	WebElement zipCode;
	
	public ProfilePage(WebDriver driver){
		this.driver = driver;
	}
	public void contactNumber() {
		ApcoaListeners.logInfo("Going to enter contact number");
		contactnumber.sendKeys("9999988888");
		ApcoaListeners.logInfo("Sucessfully Entered Contact number");
		ApcoaListeners.logInfo("Going to enter address");
		area.sendKeys("123Street");
		ApcoaListeners.logInfo("Sucessfully Entered address");
	}

	public void city() {
		ApcoaListeners.logInfo("Going to enter city");
		town.sendKeys("Bangalore");
		ApcoaListeners.logInfo("Sucessfully Entered city");
		ApcoaListeners.logInfo("Going to enter state");
		place.sendKeys("Karnataka");
		ApcoaListeners.logInfo("Sucessfully Entered state");
	}
	
	public void country() {
		ApcoaListeners.logInfo("Going to enter country");
		nation.sendKeys("India");
		ApcoaListeners.logInfo("Sucessfully Entered country");
		ApcoaListeners.logInfo("Going to enter zipcode");
		zipCode.sendKeys("536063");
		ApcoaListeners.logInfo("Sucessfully Entered zipcode");
	}

}
