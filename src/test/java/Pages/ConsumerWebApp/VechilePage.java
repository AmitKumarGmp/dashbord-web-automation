package Pages.ConsumerWebApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import TestNGListeners.ApcoaListeners;

public class VechilePage {
	WebDriver driver;

	@FindBy(xpath = "//p[text()='Vehicle(s)']")
	WebElement vehicle;

	@FindBy(xpath = "//span[text()='Add a Vehicle']")
	WebElement addVehicle;

	@FindBy(xpath = "//li[@data-value='Alabama']")
	WebElement state;

	@FindBy(id = "mui-component-select-state")
	WebElement dropdown;

	@FindBy(name = "vehicleNumber")
	WebElement vehicleNumber;

	@FindBy(name = "displayName")
	WebElement nickName;

	public VechilePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addVechile() {
		ApcoaListeners.logInfo("Clicking on Add vechile ");
		vehicle.click();
		addVehicle.click();
		dropdown.click();
		state.click();
		vehicleNumber.sendKeys("BT2000");
		nickName.sendKeys("Car");

	}
}
