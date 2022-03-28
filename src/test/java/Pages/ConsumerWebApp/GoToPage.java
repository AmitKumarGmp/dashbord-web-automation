package Pages.ConsumerWebApp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import TestNGListeners.ApcoaListeners;

public class GoToPage{
	WebDriver driver;
	
	@FindBy(xpath="(//*[name()='svg'][@height='16'])[1]")
	WebElement name;
	
	@FindBy(xpath="//span[text()='My Profile']")
	WebElement profile;
	
	public GoToPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void name() {
		name.click();
	
	}
	public void profile() {
		profile.click();
	
	}

}

