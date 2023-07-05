package Appivo.Automation_Assignment;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Appivo.Automation_Assignment.Utilities.utilities;

public class homePage extends utilities{
	WebDriver driver ;
	
	public homePage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="div.nav-search-field")
	WebElement searchBox;

	
	@FindBy(id="twotabsearchtextbox")
	WebElement toSearch;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> products;
	
	@FindBy(css=".s-no-outline .a-row")
	WebElement resultSet;
	
	
	public void searchProduct(String prod){
		searchBox.click();
		toSearch.sendKeys(Keys.chord(prod,Keys.ENTER));
	}
	
	public utilities findProductFromList(String itemToBuy) {
		for(WebElement prod : products) {
		  	if(prod.getText().equals(itemToBuy)) {
		  		prod.click();
		   		break;
		  	}
	}
		 utilities utilities = new utilities(driver);
		 return utilities;
}
	
	public String getNoResultSet() {
		return resultSet.getText();
	}
	
	public void goTo() {
		driver.get("https://amazon.in");
	}
}
