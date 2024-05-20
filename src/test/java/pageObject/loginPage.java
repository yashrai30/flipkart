package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
WebDriver ldriver;
	
	public loginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	
	String text = ldriver.getCurrentUrl();
	String url = "https://www.flipkart.com/account/login?ret=/";
	
	if (url.equals(text)) {
	    System.out.println("Login page displayed");
	} else {
	    System.out.println("Web page displayed is incorrect");
	}
}
	@FindBy(xpath="//*[@class='r4vIwl BV+Dqf']") 
	WebElement credential_bar;
	@FindBy(xpath="//*[@class='QqFHMw twnTnD _7Pd1Fp']") 
	WebElement submit;
	@FindBy(xpath="//*[@class='-dOa_b L_FVxe']") 
	WebElement login_button;
	@FindBy(xpath="//*[@class='QqFHMw llMuju M5XAsp']") 
	WebElement verify_button;
	@FindBy(xpath="//*[@class='QqFHMw twnTnD _7Pd1Fp']") 
	WebElement signupButton;
	@FindBy(xpath="//*[@class='azBkHf']") 
	WebElement changeButton;
	
	//ACTIONS
	public void clickLoginButton() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (5)); 
	 login_button.click();;
	}
	public void changeButton() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (5)); 
	 changeButton.click();;
	}
			
	public void setText(String credential) {
	credential_bar.sendKeys(credential);
	}
	
	public void clearText() {
		credential_bar.clear();
		}
	
	public void clickSubmitButton() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (5)); 
	submit.submit();
	}
	
		
	public boolean isVerifyButtonVisible() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (5));
        try {
            wait.until(ExpectedConditions.visibilityOf(verify_button));
            return verify_button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
	
	public boolean issignUpButtonVisible() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (5));
        try {
            wait.until(ExpectedConditions.visibilityOf(signupButton));
            return signupButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }	
}

