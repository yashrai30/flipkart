package testcases;

import org.testng.annotations.Test;

public class TC1_Launch extends BaseClass{
	
	@Test(priority = 1, groups = {"sanity", "regression"}, enabled = true)
	public void LaunchWebandVerfiy(){
		driver.get(url);
		logger.info("Web page opened");
	}

}
