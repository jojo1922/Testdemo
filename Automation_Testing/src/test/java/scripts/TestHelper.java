package scripts;

import java.io.File;
import java.io.FileNotFoundException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;

import utilities.ExcelUtillity;
import utilities.GenericUtility;
import utilities.NotepadUtility;

public class TestHelper {

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws FileNotFoundException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		String path = "D:\\AutomationTest-master\\src\\test\\resources\\qaenvironment";
		String url = NotepadUtility.ReadNotepad(path);
		driver.get(url);

	}


	
	@AfterMethod
    public void tearDown (ITestResult result)
    {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
               

                //Move image file to new destination

                    File DestFile=new File("./target/" + result.getName() + ".png");

                    //Copy file at destination

                    FileUtils.copyFile(source, DestFile);
                //GenericUtility.copyFileUsingStream(source, new File("./target + result.getName() + ".png"));
                   
                System.out.println("Screenshot taken");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        //closeBrowser();
    }

    public void closeBrowser() {
        driver.quit();
    }
	
	
	

}
