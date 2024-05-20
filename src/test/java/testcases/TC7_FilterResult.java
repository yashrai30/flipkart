package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.resultPage;

public class TC7_FilterResult extends BaseClass {
	
	 @Test(priority = 7, groups = {"regression"}, enabled = true)
	    public void filterResult() {
	        resultPage sp = new resultPage(driver);
	        sp.setTextInsearchBox("Electronics");
	        sp.clickSearchButton();
	        
	        sp.filterByPopularity();
	        logger.info("Filtered by popularity");
	        Assert.assertTrue(sp.isFilterApplied("Popularity"), "Popularity filter was not applied");

	        sp.filterBypriceHtoL();
	        logger.info("Filtered by Price -- High to Low");
	        Assert.assertTrue(sp.isFilterApplied("Price -- High to Low"), "Price High to Low filter was not applied");

	        sp.filterBypriceLtoH();
	        logger.info("Filtered by Price -- Low to High");
	        Assert.assertTrue(sp.isFilterApplied("Price -- Low to High"), "Price Low to High filter was not applied");
	    }
}

