package Pages.ConsumerWebApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtility.GenericMethods;
import ConsumerWebApp.ObjectMapper.PermitMapper;
import TestNGListeners.ApcoaListeners;

public class SelectParkingPage{
	WebDriver driver;
	
	public SelectParkingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void choosePermit(PermitMapper permitMapper) {
		ApcoaListeners.logInfo("Selecting parking");
		String parking_name = permitMapper.getCarparkname();
		driver.findElement(By.xpath("//h6[text()='"+parking_name+"']//following::span[text()='Choose Permit'][1]")).click();
		ApcoaListeners.logInfo(parking_name+" selected sucessfully");
	}
}
