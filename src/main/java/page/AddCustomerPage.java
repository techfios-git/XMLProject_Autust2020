package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULLNAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='city']") WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='state']") WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='zip']") WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]") WebElement COUNTRY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='submit']") WebElement SUBMIT_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/a") WebElement AUTO_LOGIN_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER_PAGE_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='foo_filter']") WebElement SEARCH_BAR_ON_LIST_CUSTOMER_PAGE_LOCATOR;
	
	

	// Interactive Methods
	
	public void clickOnAddCustomerOnListCustomerPage() {
		ADD_CUSTOMER_ON_LIST_CUSTOMER_PAGE_LOCATOR.click();
	}
	
	String enteredName;
	public void insertfullName(String fullName) {
		waitForElement(driver, 2, FULLNAME_FIELD_LOCATOR);
		int genNum = randomGenerator(999);
		enteredName = fullName + genNum;
		FULLNAME_FIELD_LOCATOR.sendKeys(enteredName);
	}
	
	public void insertEnteredNameInSearchBarOnListCustomerPage() {
		SEARCH_BAR_ON_LIST_CUSTOMER_PAGE_LOCATOR.sendKeys(enteredName);
	}

	public void insertCompanyName(String companyName) {
		selectDropDown(COMPANY_FIELD_LOCATOR, companyName);
	}

	public void insertEmailAddress(String email) {
		int genNum = randomGenerator(999);
		EMAIL_FIELD_LOCATOR.sendKeys(genNum + email);
	}
	
	public void insertPhoneNumber(String phone) {
		int genNum = randomGenerator(999);
		PHONE_FIELD_LOCATOR.sendKeys(phone + genNum);;
	}
	
	public void insertAddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}
	
	public void insertCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}
	
	public void insertState(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}
	
	public void insertZip(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}
	
	public void enterCountryName(String countryName) {
		selectDropDown(COUNTRY_FIELD_LOCATOR, countryName);
	}
	
	public void clickSubmitButton() {
		SUBMIT_BUTTON_LOCATOR.click();
		waitForElement(driver, 10, AUTO_LOGIN_BUTTON_LOCATOR);
	}
	
	public void clickOnListCustomerButton() {
		LIST_CUSTOMER_FIELD_LOCATOR.click();
	}
	
	//Log4j //listener
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	
	public void verifyEnteredNameAndDelete() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
			/*System.out.println(name);
			Assert.assertEquals(name, enteredName, "Entered name doesnot exist!!");
			break;*/
			
			if(name.contains(enteredName)) {
				System.out.println("entered name exist");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
			}
		}
	}
	
	public void verifyEnteredNameAndViewProfile() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
			/*System.out.println(name);
			Assert.assertEquals(name, enteredName, "Entered name doesnot exist!!");
			break;*/
			
			if(name.contains(enteredName)) {
				System.out.println("entered name exist");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[1]")).click();
			}
		}
	}
	

}
