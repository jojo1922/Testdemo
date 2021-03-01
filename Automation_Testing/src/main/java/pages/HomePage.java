package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PageUtility;

public class HomePage {
	String name;
	WebDriver driver;

	@FindBy(xpath = "/html/body/div/div/section[1]/h1")
	WebElement dashboardtext;

	@FindBy(xpath = "/html/body/div/header/nav/div/ul/li[6]/a")
	WebElement dropdownmenu;

	@FindBy(xpath = "/html/body/div/header/nav/div/ul/li[6]/ul/li[1]/a ")
	WebElement companyprofile;

	@FindBy(xpath = "/html/body/div/header/nav/div/ul/li[6]/ul/li[2]/a")
	WebElement branches;

//	@FindBy(xpath = "/html/body/div/header/nav/div/ul/li[6]/ul")
//	List<WebElement> dropdownvalues;

	@FindAll(@FindBy(how = How.XPATH, using = "/html/body/div/header/nav/div/ul/li[6]/ul "))
	List<WebElement> dropdownvalues;

	
	@FindBy(xpath = "/html/body/div/header/nav/div/ul/li[8]/a/i\r\n")
	WebElement profileicon;
	@FindBy(xpath = " //a[@href=\"/erp/logout\"]")
	WebElement logout;
	
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public Login ClickOnLogout() {

		logout.click();

		return new Login(driver);

	}
	public HomePage ClickOnProfileIcon() {

		profileicon.click();

		return this;

	}
	
	
	
	public String getWelcomeText() {

		PageUtility.IsElementLoaded(driver, dashboardtext, 30);
		// System.out.println("value in dashboard is " + dashboardtext.getText());
		return dashboardtext.getText();
	}

	public CompanyProfile ClickOnCompanyProfileLink() {

		companyprofile.click();

		return new CompanyProfile(driver);

	}

	public Branches ClickOnBranchesLink() {

		branches.click();

		return new Branches(driver);

	}

	public HomePage ClickonCompanyIcon() {
		
		PageUtility.IsElementLoaded(driver, dashboardtext, 30);
		//System.out.println("hello");
		dropdownmenu.click();
		return this;
	}

	public String getCompanyProfileTextFromDropdown() {
		return companyprofile.getText();
	}

	public String getBranchTextFromDropdown() {

		return branches.getText();
	}

}
