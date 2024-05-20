package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.resultPage;

public class TC6_ValidateResultPage extends BaseClass {
	
	 @Test(priority = 6, groups = {"regression"}, enabled = true)
	    public void searchGenre() {
	        resultPage sp = new resultPage(driver);
	        sp.setTextInsearchBox("Electronics");
	        sp.clickSearchButton();
	        String heading = sp.getHeading();
	        Assert.assertTrue(heading.contains("Electronics"), "Heading does not contain 'Electronics'");
	        logger.info("Expected page result");
	    }

}
