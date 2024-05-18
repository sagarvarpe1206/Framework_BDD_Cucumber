package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

public class customerpage 
{

	
	WebDriver ldriver;
	
	
	
	public customerpage (WebDriver rdrDriver)
	{
		ldriver=rdrDriver;
		
		PageFactory.initElements(rdrDriver, this);
	}
	
	@FindBy(xpath = "(//i[@class='right fas fa-angle-left '])[4]")
	WebElement Customerbutton;
	
	@FindBy (xpath = "(//a[@class='nav-link'])[22]") WebElement linkCustomer_menuitem;
	@FindBy (xpath = "//a[@class='btn btn-primary']") WebElement AddNewButton;
	@FindBy (xpath = "//input[@id='Email']") WebElement TxtEmail;
	@FindBy (xpath = "//input[@id='Password']") WebElement TxtPassword;
	@FindBy (xpath = "//input[@name='FirstName']") WebElement TxtFirstName;
	@FindBy (xpath = "//input[@name='LastName']") WebElement TxtLastName;
	@FindBy (xpath = "(//input[@name='Gender'])[1]") WebElement GendorRadioBtnMale;
	@FindBy (xpath = "(//input[@name='Gender'])[2]") WebElement GendorRadioBtnFemale;
	@FindBy (xpath = "//input[@name='DateOfBirth']") WebElement DOB;
	@FindBy (xpath = "//input[@name='Company']") WebElement CompanyName;
	@FindBy (xpath = "//input[@id='IsTaxExempt']") WebElement IsTaxExempt_checkbox;
	@FindBy (xpath = ("//input[@type='search']")) WebElement NewsLetter;
	@FindBy (xpath = "(//input[@class='select2-search__field'])[2]") WebElement CustomerRoles;
	@FindBy (xpath = "//select[@id='VendorId']") WebElement ManageofVendor ;
	@FindBy (xpath = "//input[@id='Active']") WebElement ActiveCheckBox;
	@FindBy (xpath = "//textarea[@id='AdminComment']") WebElement AdminComment;
	@FindBy (xpath = "(//button[@type='submit'])[2]") WebElement SaveButton;
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissable']" ) WebElement Successmassage;
	
	
	public void clickonCustomerbutton ()
	{
		Customerbutton.click();
	}
	
	public void clickoncustomerlink ()
	{
		linkCustomer_menuitem.click();
	}
	public void clickonaddnew ()
	{
		AddNewButton.click();
	}
	public void EnterEmail (String email)
	{
		TxtEmail.sendKeys(email);
	}
	public void EnterPassword (String password)
	{
		TxtPassword.sendKeys(password);
	}
	public void EnterFirdtName (String FirstName)
	{
		TxtFirstName.sendKeys(FirstName);
	}
	public void EnterLastName(String LastName)
	{
		TxtLastName.sendKeys(LastName);
	}
	public void SelectGenderMale()
	{
		GendorRadioBtnMale.click();
	}
	public void SelectGenderFemale()
	{
		GendorRadioBtnFemale.click();
	}
	public void EnterDOB (String dob)
	{
		DOB.sendKeys(dob);
	}
	public void EnterCompanyName(String Companyname)
	{
		CompanyName.sendKeys(Companyname);
	}
	public void SelectTaxCheckbox ()
	{
		IsTaxExempt_checkbox.click();
	}
	public void EnterNewsLetter (String newsletter)
	{
		NewsLetter.click();
		NewsLetter.sendKeys(newsletter);
		Actions act = new Actions(ldriver);
		act.sendKeys(Keys.ENTER);
	}
	public void selectcustomerroles (String role)
	{
		CustomerRoles.sendKeys(role);
		Actions act = new Actions(ldriver);
		act.sendKeys(Keys.ENTER);
	}
	public void select_manager_of_vendor ()
	{
		Select managerdrp = new Select(ManageofVendor);
		managerdrp.selectByIndex(1);
	}
	public void click_Active () 
	{
		ActiveCheckBox.click();
	}
	public void AdminComment (String comment)
	{
		AdminComment.sendKeys(comment);
	}
	public void clickonsavebutton()
	{
		SaveButton.click();
	}
	public String validatesuccessmsgtext ()
	{
		String actual=Successmassage.getText();
		return actual;
	}
	
	
}
