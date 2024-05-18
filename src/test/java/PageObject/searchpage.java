package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchpage 
{
  WebDriver ldriver;
  
  public searchpage(WebDriver rDriver)
	{
		ldriver = rDriver;

		PageFactory.initElements(rDriver, this);
	}
  
  @FindBy (id = "SearchEmail") WebElement email1;
  @FindBy (id = "search-customers") WebElement searchbutton1;
  @FindBy (xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']") WebElement Searchresult;
  
  
  
  public void enteremailadd (String emailadd)   // to enter email
  {
	 email1.sendKeys(emailadd);
  }
  public void clickonsearchbutton ()    // to search email
  {
	  searchbutton1.click();
  }

  
  
  
  
  
}
