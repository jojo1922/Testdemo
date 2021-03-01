package utilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {

	public static String GetTitle(WebDriver driver ) {
		
		String title = driver.getTitle();
		 
	    
	     return title;
	    
	}
	
	
	
	public static  String GetCurrentDate() {
		//get current date time with Date()
		
//		System.out.println("Current date in different format");
//		 Date date = new Date();
		 
		 // Now format the date
		 //String date1= dateFormat.format(date);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		 String date = sdf.format(new Date());
		 return date;
		/// System.out.println(date); //Prints 26/10/2015
		 //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		 	// System.out.println(sdf.format(date));
		 // Print the Date
		 //System.out.println(date);
	
		
	}
	
	
	
	public static void HandledSleep(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public static WebElement IsElementLoaded(WebDriver driver, WebElement text, int time) {


		return new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf( (text)));
		
			
		}



	public static List<WebElement> IsElementsLoaded(WebDriver driver, List<WebElement> elements, int time) {
		// TODO Auto-generated method stub
		return new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements( (elements)));
	}



	public static boolean IsLoaded(WebDriver driver, WebElement text, int time) {
		// TODO Auto-generated method stub
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf( (text)));
		return true;
	}
	
	
	
	
	
	
}
