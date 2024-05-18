Feature: Customers

Background:
  Given User Launch Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
	
		@Regression
 Scenario: Add new customer
	When User click on customers Menu 
	And click on customermenu item
	And click on Add new button
	And User enters the info
	And Click on save button
  Then User can view confirmation message "The new customer has been added successfully." 
  And close browser
	
	@Regression
	Scenario: Search customer
	When User click on customers Menu 
	And click on customermenu item
	And User Enter email "adminsagar17845@yourstore.com"
	And User click on search button
	And close browser

	
	
