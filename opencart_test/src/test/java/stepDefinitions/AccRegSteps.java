package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PageAccoutregistration;

public class AccRegSteps 
{WebDriver driver;
 HomePage hp;
 LoginPage lp;
 PageAccoutregistration regpage;
@Given("the user navigates to Register Account page")
public void the_user_navigates_to_register_account_page() 
{
	hp=new HomePage(BaseClass.getDriver());
	hp.clickMyaccount();
	hp.clickRegister();
	
}

@When("the user enters the details into below fields")
public void the_user_enters_the_details_into_below_fields(DataTable dataTable) 
{
	Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
	regpage=new PageAccoutregistration(BaseClass.getDriver());
	regpage.setFirstname(dataMap.get("firstName"));
	regpage.setLastname(dataMap.get("lastName"));
	regpage.setEmail(BaseClass.randomAlphaNumeric()+"gmail.com");
	regpage.setTelephone(dataMap.get("telephone"));
	regpage.setpassword(dataMap.get("password"));
	regpage.setConfirmPassword(dataMap.get("password"));

}
			
@When("the user selects Privacy Policy")
public void the_user_selects_privacy_policy() 
{
	regpage.setPrivacyPolicy();
    
}

@When("the user clicks on Continue button")
public void the_user_clicks_on_continue_button() 
{
	regpage.ClickContinue();
}

@Then("the user account should get created successfully")
public void the_user_account_should_get_created_successfully()
{
	String confmsg=regpage.getConformationmsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
    
}




}
