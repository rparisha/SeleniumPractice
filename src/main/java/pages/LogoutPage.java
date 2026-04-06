package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	
	private WebDriver driver;
	
	private By Profile = By.xpath("//li[@class='oxd-userdropdown']//p");
	private By Logout  = By.xpath("//ul[@class='oxd-dropdown-menu']//a[text()='Logout']");
	
	
	public LogoutPage (WebDriver driver) {
		this.driver = driver;		
	}
	
	public void Logout() {
		
		driver.findElement(Profile).click();
		driver.findElement(Logout).click();
	}
			
			
			
	

}
