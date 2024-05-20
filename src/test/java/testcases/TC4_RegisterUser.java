package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.loginPage;
import pageObject.registerPage;

public class TC4_RegisterUser extends BaseClass{
	
	@Test(priority = 4, groups = {"sanity"}, enabled = true)
	public void loginProcess() {
	
	loginPage lp = new loginPage(driver);
	lp.clickLoginButton();
	registerPage rp = new registerPage(driver);
	rp.clickCreateAccButton();
	rp.setText("8989450481");
	rp.clickSubmitButton();
	String actualUrl = driver.getCurrentUrl();
	String expectedUrl = "https://www.flipkart.com/account/login?signup=true";
	logger.info("Actual URL: " + actualUrl);
    Assert.assertEquals(actualUrl, expectedUrl, "Current URL does not match the expected URL");
	
}
}
