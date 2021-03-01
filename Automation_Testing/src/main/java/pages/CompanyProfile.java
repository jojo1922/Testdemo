package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class CompanyProfile {

	WebDriver driver;

	@FindBy(xpath = "//h1")
	WebElement welcometext;

	@FindBy(xpath = "//input[@id=\"company-company_name\"]")
	WebElement companyname;

	@FindBy(xpath = "//input[@id=\"company-company_email\"]")
	WebElement companyemail;

	@FindBy(xpath = "//textarea[@id=\"company-company_address\"]")
	WebElement companyaddress;

	@FindBy(xpath = "//form/div[4]/div/div/span[1]/i")
	WebElement calender;

	@FindBy(xpath = "/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]")
	WebElement year;

	@FindBy(xpath = "/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")
	WebElement yearpicker1;

	@FindBy(xpath = "/html/body/div[2]/div[3]/table/thead/tr[2]/th[3]")
	WebElement yearpicker2;

	@FindBy(xpath = "/html/body/div[2]/div[3]/table/tbody/tr/td/span[2]")
	WebElement yearpicker3;
	@FindBy(xpath = "	//button[@type=\"submit\"]")
	WebElement savebutton;
	@FindBy(xpath = "//p[contains(text(),'Company Name cannot')]")
	WebElement validationmessage;

	@FindBy(xpath = "//input[@id=\"company-started_at\"]")
	WebElement companystartdate;

	@FindBy(xpath = "/html/body/div/div/section[1]/ul/li")
	List<WebElement> companyprofilepath;

	@FindBy(xpath = "//section//a[@href=\"/erp/branch/create\"]")
	WebElement branchtab;

	public CompanyProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Branches clickOnBranchTab() {
		branchtab.click();
		branchtab.sendKeys(Keys.ENTER);

		return new Branches(driver);
	}

	public String getCompanyPageWelcomeText() {

		PageUtility.IsElementLoaded(driver, welcometext, 50);
		// System.out.println("Heading of Company Page is " + welcometext.getText());
		return welcometext.getText();
	}

	public CompanyProfile enterNewCompanyDetails(String cname, String cemail, String caddr) {

		companyname.clear();
		companyname.sendKeys(cname);
		companyemail.clear();
		companyemail.sendKeys(cemail);
		companyaddress.clear();
		companyaddress.sendKeys(caddr);
		companystartdate.clear();
		companystartdate.sendKeys(PageUtility.GetCurrentDate());
//		calender.click();
//		year.click();
//		yearpicker1.click();
//		for(int i=0;i<5;i++) {
//			PageUtility.IsElementLoaded(driver,yearpicker2, 30);
//		yearpicker2.click();
//			
//		}
//		yearpicker3.click();
		savebutton.click();
		PageUtility.IsElementLoaded(driver, branchtab, 30);

		return this;

	}

	public String getCompanyNameValidationMessage() {
		companyname.clear();
		PageUtility.IsElementLoaded(driver, validationmessage, 50);
		return validationmessage.getText();

	}

	public String[] getCompanyProfilePath() {

		String[] comprofilepath = new String[companyprofilepath.size()];
		// String[] act = null;
		int i = 0;
		for (WebElement webElement : companyprofilepath) {
			comprofilepath[i++] = webElement.getText();

		}
		return comprofilepath;

	}

}
