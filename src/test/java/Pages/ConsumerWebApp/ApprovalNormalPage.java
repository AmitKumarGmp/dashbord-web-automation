package Pages.ConsumerWebApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import ConsumerWebApp.ObjectMapper.PermitMapper;
import TestNGListeners.ApcoaListeners;

public class ApprovalNormalPage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Choose Parking']")
	WebElement text;

	@FindBy(xpath = "//p[text()='Continue']")
	WebElement continuele;

	@FindBy(xpath = "//span[text()='Agree']")
	WebElement tap;

	@FindBy(name = "rnr")
	WebElement agree;

	@FindBy(xpath = "//span[text()='Payment Summary']//following::h5[@class='MuiTypography-root MuiTypography-h5']")
	WebElement total;

	@FindBy(xpath = "//span[(text()='Send for approval')]")
	WebElement approval;

	@FindBy(xpath = "//span[text()='Go to My Permits']")
	WebElement mypermits;

	@FindBy(xpath = "//h5[@class='MuiTypography-root MuiTypography-h5']")
	WebElement total_2;

	public ApprovalNormalPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateText() {
		ApcoaListeners.logInfo("Checking the text");
		return text.isDisplayed();
	}

	public void selectPermit(PermitMapper permitmapper) throws Exception {

		try {
			ApcoaListeners.logInfo("Selecting permit for approval");
			String permit_name = permitmapper.getPermitname();
			driver.findElement(By.xpath("//p[contains(text(),'" + permit_name + "')]")).click();
			ApcoaListeners.logInfo("Permit for approval :" + permit_name);

		} catch (Exception e) {

			ApcoaListeners.logInfo("Selecting permit for approval");
			driver.findElement(By.xpath("(//input[@aria-label='A'])[1]")).click();
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			String permit_name = permitmapper.getPermitname();
			driver.findElement(By.xpath("//p[contains(text(),'" + permit_name + "')]")).click();
			ApcoaListeners.logInfo("Permit for approval :" + permit_name);

		}
	}

	public void clicks() {
		ApcoaListeners.logInfo("Going to click Continue");
		continuele.click();
		ApcoaListeners.logInfo("Going to click Agree");
		tap.click();
	}

	public String validateAmount() {
		ApcoaListeners.logInfo("Geting the total price of the permit");
		return total.getText();
	}

	public void approve() {
		ApcoaListeners.logInfo("Going to Send for Approval");
		approval.click();
		ApcoaListeners.logInfo("Going to Mypermit page");
		mypermits.click();
		ApcoaListeners.logInfo("Checking permit details");

	}

	public void check() {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector("div[id='scrollBox']>div:first-of-type"));
		action.doubleClick(ele).perform();
		ApcoaListeners.logInfo("Working");
	}

	public String verifyAmount() {
		ApcoaListeners.logInfo("Geting the total price of the permit");
		return total_2.getText();
	}

}
