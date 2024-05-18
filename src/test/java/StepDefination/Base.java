package StepDefination;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import PageObject.customerpage;
import PageObject.searchpage;
import ch.qos.logback.classic.Logger;

// this will be parent class for step defination
public class Base 
{
	public WebDriver driver;
	public LoginPage loginpg;
	public customerpage cust_page;
	public searchpage search1;

	// generate evry timr unique email id
	public String Generatemailid ()
	{
		return RandomStringUtils.randomAlphabetic(5);
		
	}
}
