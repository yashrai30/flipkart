package testcases;

import org.testng.annotations.Test;

import pageObject.searchProduct;

public class TC8_AddtoCart extends BaseClass {
	
	@Test(enabled=true)
	public void searchProduct() {
		searchProduct sp = new searchProduct(driver);
		sp.setTextInsearchBox("Iphone-15");
		sp.clickSearchButton();
		sp.clickProduct();
		sp.addTocart();
}
	
}
