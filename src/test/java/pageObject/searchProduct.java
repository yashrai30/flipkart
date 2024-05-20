package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchProduct {
	WebDriver ldriver;
	
	public searchProduct(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy  (xpath="//*[@class='Pke_EE']") 
	WebElement textbox_search;
	@FindBy  (xpath="//*[@class='_2iLD__']")
	WebElement search_button;
	@FindBy  (xpath="//*[@class='KzDlHZ']")
	WebElement product;
	@FindBy  (xpath="//*[@class='NwyjNT']")
	WebElement addTocart;
	
			
	//ACTIONS
	public void setTextInsearchBox (String product) {
	textbox_search.sendKeys(product);
	}
	public void clickSearchButton() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (5)); 
	 search_button.submit();
	}
	public void clickProduct() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (5)); 
		product.click();
		}
	public void addTocart() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds (15)); 
		addTocart.click();
		}
	
	
	
	}


