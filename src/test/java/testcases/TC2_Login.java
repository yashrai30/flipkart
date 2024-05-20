package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.loginPage;


public class TC2_Login extends BaseClass{
	
	@Test(priority = 2, groups = {"sanity"}, enabled = true)
	public void validloginProcess() throws IOException {
	
	loginPage lp = new loginPage(driver);
	lp.clickLoginButton();
	lp.setText("6267305351");
	logger.info("text set");
	lp.clickSubmitButton();
	logger.info("clicked submit");
	
	 boolean isVisible = lp.isVerifyButtonVisible();
     if (!isVisible) {
    	 captureScreenShot(driver,"VerifyButtonNotVisible");
         logger.error("Verify button is not visible. Screenshot taken.");
     }
     logger.info("Verify button is visible");
     Assert.assertFalse(isVisible, "Verify button is visible");
}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	@Test(priority = 3, groups = {"regression"}, enabled = true)
	public void invalidloginProcess() throws IOException {
	
	loginPage lp = new loginPage(driver);
	lp.changeButton();
	lp.clearText();
	logger.info("clear text");
	lp.setText("8989898989");
	logger.info("set invalid text");
	lp.clickSubmitButton();
	logger.info("clicked submit");
	

	 boolean isVisible = lp.issignUpButtonVisible();
    if (!isVisible) {
   	 captureScreenShot(driver,"SignUpButtonNotVisible");
        logger.error("SignUp button is not visible. Screenshot taken.");
    }
    logger.info("SignUp button is visible");
    Assert.assertTrue(isVisible, "SignUp button is visible");
    captureScreenShot(driver,"SignUpButtonNotVisible");
}

}