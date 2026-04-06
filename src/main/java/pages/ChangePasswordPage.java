package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {
	
	private WebDriver driver;
	
	private By Profile            = By.xpath("//li[@class='oxd-userdropdown']//p");
	private By ChangePasswordLink = By.xpath("//ul[@class='oxd-dropdown-menu']//a[text()='Change Password']"); 
	private By CurrentPassword    = By.xpath("//label[text()='Current Password']/following::input[1]");
	private By NewPassword        = By.xpath("//label[text()='Password']/following::input[1]");
	private By ConfirmPassword    = By.xpath("//label[text()='Confirm Password']/following::input[1]");
	private By ClickSave          = By.xpath("//button[@type='submit']");
	
	public ChangePasswordPage (WebDriver driver)  {
		
		this.driver = driver;		
	}
	
	public void ChangePassword(String currentpassword, String newpassword, String confirmpassword) {
		
		driver.findElement(Profile).click();
		driver.findElement(ChangePasswordLink).click();
		driver.findElement(CurrentPassword).sendKeys(currentpassword);
		driver.findElement(NewPassword).sendKeys(newpassword);
		driver.findElement(ConfirmPassword).sendKeys(confirmpassword);
		driver.findElement(ClickSave).click();
	}
	

}
