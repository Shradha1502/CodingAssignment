package Appivo.Automation_Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Appivo.Automation_Assignment.Utilities.utilities;

public class productPage extends utilities {
	WebDriver driver;
	String productName;

	public productPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "productTitle")
	WebElement prodName;

	public String getProdDetails() {
		productName = prodName.getText();
		return productName;
	}

}
