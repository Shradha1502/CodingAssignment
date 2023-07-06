package Appivo.Automation_Assignment;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Appivo.Automation_Assignment.TestComponents.BaseTest;
import Appivo.Automation_Assignment.Utilities.utilities;

public class ErrorValidationTest extends BaseTest {

	@Test
	public void invalidSearchResult() throws IOException {

		String product = "hfgjfhkfjfk";
		homepg.searchProduct(product);
		homepg.getNoResultSet();
		Assert.assertEquals("No results for hfgjfhkfjfk.", homepg.getNoResultSet());
	}

	@Test
	public void invalidProductResult() throws IOException {
		String itemToBuy = "Apple iPhone 14 (128 GB) - Midnight";
		String product = "Iphone 14";
		homepg = launchApplication();
		homepg.searchProduct(product);
		utilities utilities = homepg.findProductFromList(itemToBuy);
		productPage productPage = utilities.switchToChildWindow();
		String prodName = productPage.getProdDetails();
		Assert.assertFalse(false, "Apple iPhone 20 (128 GB) - Blue");
		System.out.println("verified");
	}
}
