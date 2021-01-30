package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	
	WebDriver driver;
	
	
	/*String userName = null;
	String password = null;
	String fullName = null;
	String companyName = null;
	String email = null;
	String phone = null;
	String address = null;
	String city = null;
	String country = null;
	String state = null;
	String zip = null;*/
	
	
	//@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String state, String zip, String country) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardHeader();
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertfullName(fullName);;
		addCustomerPage.insertCompanyName(companyName);
		addCustomerPage.insertEmailAddress(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.enterCountryName(country);
		addCustomerPage.clickSubmitButton();
		
		addCustomerPage.clickOnListCustomerButton();
		addCustomerPage.verifyEnteredNameAndDelete();
		
	}
	
	@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToAddCustomerFromListCusterPageAndViewProfile(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String state, String zip, String country) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardHeader();
		dashboardPage.clickOnCustomerButton();
			
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickOnListCustomerButton();
		addCustomerPage.clickOnAddCustomerOnListCustomerPage();
		addCustomerPage.insertfullName(fullName);;
		addCustomerPage.insertCompanyName(companyName);
		addCustomerPage.insertEmailAddress(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.enterCountryName(country);
		addCustomerPage.clickSubmitButton();
		
		addCustomerPage.clickOnListCustomerButton();
		addCustomerPage.insertEnteredNameInSearchBarOnListCustomerPage();
		addCustomerPage.verifyEnteredNameAndViewProfile();
		
	}

}
