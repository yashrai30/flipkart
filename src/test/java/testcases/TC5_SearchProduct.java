package testcases;

import org.testng.annotations.Test;

import pageObject.searchProduct;

public class TC5_SearchProduct extends BaseClass{
	
	@Test(priority = 5, groups = {"regression"}, enabled = true)
	public void searchProduct() {
		searchProduct sp = new searchProduct(driver);
		sp.setTextInsearchBox("Iphone-15");
		sp.clickSearchButton();
}
}