package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
WebDriver ldriver;
	
	public homePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	
	String text = ldriver.getTitle();
	String title = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	
	if (title.equals(text)) {
	    System.out.println("Flipkart home page displayed");
	} else {
	    System.out.println("Web page displayed is incorrect");
	}
}
	@FindBy(xpath="//*[@class='-dOa_b L_FVxe']") 
	WebElement login_button;
			
	//ACTIONS
	public void clickLoginButton() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (3)); 
	 login_button.click();
	}
	
}
