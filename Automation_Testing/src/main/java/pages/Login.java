package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.ExcelUtillity;
import utilities.PageUtility;

public class Login {
	WebDriver driver;

//	 @FindBy(xpath = "//span")
//	 WebElement textvalue;

	@FindBy(xpath = "//input[@id=\"loginform-username\"] ")
	WebElement username;

	@FindBy(xpath = "//input[@id=\"loginform-password\"] ")
	WebElement password;

	@FindBy(xpath = "//button[@name=\"login-button\"] ")
	WebElement loginButton;

	@FindBy(xpath = "//form/div[1]/p ")
	WebElement errormessage;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getErrorMessage() {
		PageUtility.IsElementLoaded(driver, errormessage, 50);
		System.out.println("Error Message is  " + errormessage.getText());
		return errormessage.getText();

	}

	public boolean getData() {
		// getErrorMessage();

		return true;
	}

	public Login IsLogged(String path, String Sheet, int i) throws EncryptedDocumentException, IOException {
		String expterrormesssage = "Please fix the following errors:";
		// driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		// PageUtility.IsLoaded(driver, errormessage, 50)
		SoftAssert softAssert = new SoftAssert();
		// String acterrormessage = getErrorMessage();
		System.out.println("Actual error mesage is " + getErrorMessage());
		// softAssert.assertEquals(getErrorMessage(), expterrormesssage, "Not Logged
		// in");
		softAssert.assertTrue(getErrorMessage().equals(expterrormesssage));
		// softAssert.assertEquals("Hello", "Hello", "First soft assert failed");
		// softAssert.assertTrue(getData());
		// PageUtility.IsLoaded(driver, errormessage, 50);
		// System.out.println( " ne wtwxt is "+ errormessage.getText());

		if (getErrorMessage().equals(expterrormesssage)) {
			ExcelUtillity.ExcelWrite(path, Sheet, i, 2, "Fail");
			return this;
		} else {
			return this;
		}

	}

	public HomePage LogIn(String uname, String pwd) {
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);

	}

	//
//	public String readActualText() {
//		System.out.println("ccccccccccccccce");
//		//System.out.println( dashboardtext.getText());
//		return textvalue.getText();
//
//	}
//	

//	public void IsLoaded() {
//	System.out.println("Page title");
//	String expectedtitle = "Sign In";
//	String actualtitle =PageUtility.GetTitle(driver);
//	System.out.println("Actual title is" +PageUtility.GetTitle(driver) );
//	
//	assertEquals(actualtitle, expectedtitle, "Not logged in ...");
//}
//

}
