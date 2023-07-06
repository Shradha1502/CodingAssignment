package Appivo.Automation_Assignment;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Appivo.Automation_Assignment.TestComponents.BaseTest;
import Appivo.Automation_Assignment.Utilities.utilities;

public class StandAloneTest extends BaseTest {

	@Test
	public void standAlone() throws IOException {

		String itemToBuy = "Apple iPhone 14 (128 GB) - Midnight";
		String product = "Iphone 14";
		homepg = launchApplication();
		homepg.searchProduct(product);
		utilities utilities = homepg.findProductFromList(itemToBuy);
		productPage productPage = utilities.switchToChildWindow();
		String prodName = productPage.getProdDetails();
		Assert.assertEquals(prodName, itemToBuy);
		System.out.println("verified");

	}
}
