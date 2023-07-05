package Appivo.Automation_Assignment.Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Appivo.Automation_Assignment.homePage;
import Appivo.Automation_Assignment.productPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class utilities {

	
	WebDriver driver;
	public utilities(WebDriver driver) {
		this.driver =  driver;
	}

		public productPage switchToChildWindow() {
			 Set<String>s=driver.getWindowHandles();
				Iterator<String> I1= s.iterator();
				while(I1.hasNext())
				{
				String child_window=I1.next();
				driver.switchTo().window(child_window);
				}
				productPage productPage = new productPage(driver);
				return productPage;
			
		}
	
		 
}
