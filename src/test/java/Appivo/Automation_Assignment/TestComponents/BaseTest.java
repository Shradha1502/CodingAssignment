package Appivo.Automation_Assignment.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Appivo.Automation_Assignment.homePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public homePage homepg;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\Appivo\\Automation_Assignment\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ((browserName.equalsIgnoreCase("edge"))) {
			System.setProperty("webdriver.edge.driver", "local path of edge driver");
			driver = new EdgeDriver();
		} else if ((browserName.equalsIgnoreCase("firefox"))) {
			System.setProperty("webdriver.gecko.driver", "local path of firefox driver");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
	}

	@BeforeMethod
	public homePage launchApplication() throws IOException {
		WebDriver driver = initializeDriver();
		homepg = new homePage(driver);
		homepg.goTo();
		return homepg;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
