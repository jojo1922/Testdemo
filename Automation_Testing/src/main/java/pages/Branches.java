package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Branches {

	WebDriver driver;

	@FindBy(xpath = "//h1")
	WebElement welcometext;
	@FindBy(xpath = "//th")
	List<WebElement> tablehead;

	@FindBy(xpath = "/html/body/div/div/section[1]/ul/li")
	List<WebElement> branchpath;

	@FindBy(xpath = "//table/tbody/tr/td[2]")
	List<WebElement> companyid;

	@FindBy(xpath = "	//tbody/tr[1]/td[5]/a[2]/span")
	WebElement updatebranch;

	@FindBy(xpath = "/html/body/div/div/section[2]/div[2]/div/div/form/div/label")
	List<WebElement> editbranchformelements;

	@FindBy(xpath = " /html/body/div/div/section[1]/h1")
	WebElement headerbranchmessage;

	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	WebElement brnchnamemsge;

	@FindBy(xpath = "//input[@id=\"branch-branch_name\"]")
	WebElement branchname;
	@FindBy(xpath = "//input[@id=\"branch-email\"]")
	WebElement email;
	@FindBy(xpath = "//input[@id=\"branch-phone\"]")
	WebElement phone;
	@FindBy(xpath = "//input[@id=\"branch-mobile\"]")
	WebElement mobile;
	@FindBy(xpath = "//input[@id=\"branch-gst_no\"]")
	WebElement gstno;
	@FindBy(xpath = "//input[@id=\"branch-address1\"]")
	WebElement address1;
	@FindBy(xpath = "//input[@id=\"branch-address2\"]")
	WebElement address2;
	@FindBy(xpath = "//input[@id=\"branch-state\"]")
	WebElement state;
	@FindBy(xpath = "//input[@id=\"branch-pincode\"]")
	WebElement pinnumber;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement submitupdation;

	@FindBy(xpath = "//div[2]/div/div/table/tbody/tr/td[1]")
	List<WebElement> updatedbranchformelements;

	public Branches(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getUpdatedBranchDetails() {
		List<String> myAlist = new ArrayList<String>();

		PageUtility.IsElementsLoaded(driver, updatedbranchformelements, 30);

		for (WebElement webElement : updatedbranchformelements) {

			String name = webElement.getText();
			myAlist.add(name);
			// System.out.println(name);
		}

		myAlist.subList(10, 15).clear();
		System.out.println(myAlist);
		return myAlist;

	}

	public Branches ClickonSaveButtoninUpdateBranchPage() {
		submitupdation.submit();
		return this;
	}

	public Branches enterUpdatedDetails(String bname, String mail, String phn, String mob, String gst, String add1,
			String add2, String ste, String pin) {

		branchname.clear();
		branchname.sendKeys(bname);
		email.clear();
		email.sendKeys(mail);
		phone.clear();
		phone.sendKeys(phn);
		mobile.clear();
		mobile.sendKeys(mob);
		gstno.clear();
		gstno.sendKeys(gst);
		address1.clear();
		address1.sendKeys(add1);
		address2.clear();
		address2.sendKeys(add2);
		state.clear();
		state.sendKeys(ste);
		pinnumber.clear();
		pinnumber.sendKeys(pin);
		return this;
	}

	public String getExpectedCoresspondingBranchNameHeader() {

		return PageUtility.IsElementLoaded(driver, headerbranchmessage, 30).getText();

	}

	public String getActualCoresspondingBranchNameHeader() {
		String expectednme = "Update Branch: " + PageUtility.IsElementLoaded(driver, brnchnamemsge, 30).getText();
		return expectednme;
	}

	public String[] getUpdateBarnchFormFields() {

		String[] updateformfields = new String[editbranchformelements.size()];
		// String[] act = null;
		int i = 0;
		for (WebElement webElement : editbranchformelements) {
			updateformfields[i++] = webElement.getText();

		}
		return updateformfields;

	}

	public Branches clickOnupdateBranchDetails() {
		updatebranch.click();
		return this;
	}

	public String[] getCompanyid() {

		String[] compyid = new String[companyid.size()];
		// String[] act = null;
		int i = 0;
		for (WebElement webElement : companyid) {
		compyid[i++] = webElement.getText();

		}
		return compyid;

	}

	public String getBranchPageWelcomeText() {
		// System.out.println("hello world");
		PageUtility.IsElementLoaded(driver, welcometext, 50);
		System.out.println("Heading of Company Page is " + welcometext.getText());
		return welcometext.getText();
	}

	public String[] gettableheaders() {

		String[] act = new String[tablehead.size()];
		// String[] act = null;
		int i = 0;
		for (WebElement webElement : tablehead) {
		act[i++] = webElement.getText();

		}
		return act;

	}

	public String[] getBranchPath() {

		String[] branpath = new String[branchpath.size()];
		// String[] act = null;
		int i = 0;
		for (WebElement webElement : branchpath) {
		branpath[i++] = webElement.getText();

		}
		return branpath;

	}

}
