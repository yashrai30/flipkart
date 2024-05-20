package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registerPage {
WebDriver ldriver;
	
	public registerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
}
	@FindBy(xpath="//*[@class='azBkHf']") 
	WebElement createAcc_link;
	@FindBy(xpath="//*[@class='r4vIwl BV+Dqf']") 
	WebElement enterNumber;
	@FindBy(xpath="//*[@class='QqFHMw twnTnD _7Pd1Fp']") 
	WebElement submit;
			
	//ACTIONS
	public void clickCreateAccButton() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (3)); 
	createAcc_link.click();
	}
			
	public void setText(String mobile) {
		enterNumber.sendKeys(mobile);
	}
	
	public void clickSubmitButton() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (3)); 
	submit.submit();
	}
	

}


