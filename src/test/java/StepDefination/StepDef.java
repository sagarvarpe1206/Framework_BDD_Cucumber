package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import PageObject.LoginPage;
import PageObject.customerpage;
import PageObject.searchpage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends Base    // CHILD CLASS
{
	
	@Before (order = 0)    // aapan 2-2 annotation taku shakto pan order set karavi lagel aani he annotion  aaplyala prtek scenario chya aadhi karayache asel tr vaprtat
	//@Before ("@Sanity")     -- mhnje only sanity chya scenario run hotana before cha block run hoil--- conditional hook aapan baki block la pan karu shkato he
	public void setup ()
	{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("setup exicuted");
	}
	
	/*  @Before  (order = 0)      ithe pan Before ahe pan varche aadhi hoil  (BLOCK ASA COMMENT KARTAT * VAPRUN)
	public void setup1 ()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("setup exicuted");
	} */
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() throws InterruptedException 
	{
		
		loginpg = new LoginPage(driver);
		cust_page =  new customerpage(driver);
		search1 = new searchpage(driver);

		driver.manage().window().maximize();

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url)
	{

		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) 
	{
		loginpg.enterEmail(emailadd);
		loginpg.enterPassword(password);

	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException 
	{
		loginpg.clickOnLoginButton();
		Thread.sleep(3000);
	}

	//////////////login feature //////////////////////

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		String actualTitle= driver.getTitle();
		if (actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() 
	{
		loginpg.clickOnLogOutButton();
	}

	@Then("close browser")
	public void close_browser() 
	{
		driver.close();
		//driver.quit();    --- added in teardown method
	}

	/////////////////////customer addition///////////////////////
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		cust_page.clickonCustomerbutton();
	}

	@When("click on customermenu item")
	public void click_on_customermenu_item() 
	{
		cust_page.clickoncustomerlink();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() 
	{
		cust_page.clickonaddnew();
	}

	@When("User enters the info")
	public void user_enters_the_info() throws InterruptedException 
	{
		//cust_page.EnterEmail("adminsagar178995@yourstore.com");
		cust_page.EnterEmail(Generatemailid() + "@gmail.com");    // new random mail created every time
		cust_page.EnterPassword("Test1");
		cust_page.EnterFirdtName("SAGAR");
		cust_page.EnterLastName("VARPE");
		cust_page.SelectGenderMale();
		cust_page.EnterDOB("12/06/1993");
		cust_page.EnterCompanyName("A2S ENGINEERING LIMITED");
		cust_page.SelectTaxCheckbox();
		Thread.sleep(2000);
		cust_page.EnterNewsLetter("Test store 2");
		cust_page.selectcustomerroles("Registered");
		cust_page.select_manager_of_vendor();
		cust_page.click_Active();
		cust_page.AdminComment("TEST TEST TEST TEST");
	}


	@When("Click on save button")
	public void click_on_save_button() 
	{
     cust_page.clickonsavebutton();
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String Expected) 
	{
	   String actaul =cust_page.validatesuccessmsgtext();
	   if (actaul.equals(Expected)) 
	    {
		System.out.println("customer added");
	    }
	   else
	   {
		   System.out.println("test fail");
	   }

	   }

	  ////////////////////search cust by email////////////////
	
	
	@When("User Enter email {string}")
	   public void user_enter_email(String mail)
	   {
	      search1.enteremailadd(mail);
	   }

	   @When("User click on search button")
	   public void user_click_on_search_button() 
	   {
	     search1.clickonsearchbutton();
	   }
	   
	   @After          // aadhi 1 order hoil mag 0 wali exicute hoil   aani he prtek scenario nanatr run hoto
	   public void teardown (Scenario SC) throws IOException
	   {
		   
		   if (SC.isFailed()==true)   // jar scenario fail zala tr -
		   {
			 //Convert web driver object to TakeScreenshot

				String fileWithPath = "D:\\sg\\work1\\cucumberframework_demo\\Screenshots\\FAILEDCASE.jpeg";
				TakesScreenshot scrShot =((TakesScreenshot)driver);

				//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

				//Move image file to new destination
				File DestFile=new File(fileWithPath);

				//Copy file at destination
				FileUtils.copyFile(SrcFile, DestFile);
		   }
		   
		   driver.quit();
		   System.out.println("teardown exicuted with order 1");
	   }
	   
	  /* @After (order = 1)          // ithe pan 2-2 after annotation ahe pan ithe exicution order reverse hote aani prtek scenario nanatr exicute honar
	   public void teardown1 ()
	   {
		   driver.quit();
		   System.out.println("teardown exicuted with order 0");
	   }*/
	   
	   @BeforeStep      // ha block scenariomadhil prtek step chya aadhi run hot rahato mhnje kahi special verification asel tr
	   public void beforestepdemo () 
	   {
		   System.out.println("this is exicuted before every step");
	   }
	   
	   @AfterStep            // // ha block scenariomadhil prtek step nanatr run hot rahato
	   public void afterstepdemo () 
	   {
		   System.out.println("this is exicuted after every steps");
	   }

}

