package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement  loginlink;
	
	
	public void clickMyaccount()
	{
		lnkMyaccount.click();
		
	}
	public void clickRegister() {
		
		lnkRegister.click();
	}
	
	public void clickLogin() {
		loginlink.click();
	}
	
	
	
	
	
}

	


