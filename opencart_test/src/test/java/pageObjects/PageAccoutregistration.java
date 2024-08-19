package pageObjects;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAccoutregistration extends BasePage {
	public PageAccoutregistration(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	
	WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconformation;
	
	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	public void setpassword(String pwd) { 
		txtpassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	public void setPrivacyPolicy() {
		//chkPolicy.click();
		
		 Actions act=new Actions(driver) ;  
	     act.moveToElement(chkPolicy).click().perform(); 
			/*
			 * JavascriptExecutor js =(JavascriptExecutor)driver;
			 * js.executeScript("argument[0].click();",chkPolicy);
			 */
	}
	
	public void ClickContinue() {
          // btncontinue.click();
		
		//btncontinue.submit();
           
        Actions act=new Actions(driver) ;  
       act.moveToElement(btncontinue).click().perform();   
       //JavascriptExecutor  js =(JavascriptExecutor)driver; 
       //js.executeScript("argument[0].click();",btncontinue);
           
           
		
		
	}
	public String getConformationmsg() {
		try {
		return (msgconformation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
