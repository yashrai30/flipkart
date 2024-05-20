package pageObject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class resultPage {
WebDriver ldriver;
	
	public resultPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
}
	@FindBy  (xpath="//*[@class='Pke_EE']") 
	WebElement textbox_search;
	@FindBy  (xpath="//*[@class='_2iLD__']")
	WebElement search_button;
	@FindBy(xpath="//*[@class='BUOuZu']") 
	WebElement heading;
	@FindBy(xpath="//*[@class=\"sHCOk2\"]/div[2]") 
	WebElement popularity;
	@FindBy(xpath="//*[@class=\"sHCOk2\"]/div[2]") 
	WebElement priceLtoH;
	@FindBy(xpath="//*[@class=\"sHCOk2\"]/div[2]") 
	WebElement priceHtoL;
	
	
		
	public String getHeading() {
        WebDriverWait wait = new WebDriverWait(ldriver,Duration.ofSeconds (5));
        wait.until(ExpectedConditions.visibilityOf(heading));
        return heading.getText();
    }
				
	public void setTextInsearchBox (String product) {
	textbox_search.sendKeys(product);
	}
	
	public void clickSearchButton() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (5)); 
	 search_button.submit();
	}
	
	public void filterByPopularity() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (15));
	wait.until(ExpectedConditions.elementToBeClickable(popularity));
	 popularity.click();
	}
	
	public void filterBypriceLtoH() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (15)); 
	wait.until(ExpectedConditions.elementToBeClickable(priceHtoL));
	priceLtoH.click();
	}
	
	public void filterBypriceHtoL() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (15)); 
	 wait.until(ExpectedConditions.elementToBeClickable(priceLtoH));
	priceHtoL.click();
	}
	
	  public boolean isFilterApplied(String filterType) {
		  WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (15));
	        switch (filterType) {
	            case "Popularity":
	                return wait.until(ExpectedConditions.visibilityOf(popularity)).isDisplayed();
	            case "Price -- High to Low":
	                return wait.until(ExpectedConditions.visibilityOf(priceHtoL)).isDisplayed();
	            case "Price -- Low to High":
	                return wait.until(ExpectedConditions.visibilityOf(priceLtoH)).isDisplayed();
	            default:
	                return false;
	        }
	    }

}
