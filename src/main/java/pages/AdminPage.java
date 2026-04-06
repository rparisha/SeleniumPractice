package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	
	private WebDriver driver;
	//PIM Page objects
	private By clickPIM   = By.xpath("//*[@id='app']//span[text()='PIM']");
    private By AddButton =  By.xpath("//button[normalize-space()='Add']");
    private By FirstName =  By.xpath("//input[@name='firstName']");
    private By LastName  =  By.xpath("//input[@name='lastName']");
    private By EmployeeId = By.xpath("//label[@class='oxd-label']/following::input[1]");
    private By SaveButton = By.xpath("//button[@type='submit']");
    
    //Admin page objects
    private By clickAdmin =        By.xpath("//*[@id='app']//span[text()='Admin']");
	private By AddButton1 =        By.xpath("//button[normalize-space()='Add']");
	private By UserRoleDropdown = By.xpath("//label[text()='User Role']/following::div[@class='oxd-select-text-input'][1]");
	private By StatusDropdown =   By.xpath("//label[text()='Status']/following::div[@class='oxd-select-text-input'][1]");
	private By EmployeeName  =    By.xpath("//*[@id=\"app\"]//input[@placeholder='Type for hints...']");
	private By UserName      =    By.xpath("//label[text()='Username']/following::input[1]");
	private By Password      =    By.xpath("//label[text()='Password']/following::input[1]");
	private By ConfirmPassword =  By.xpath("//label[text()='Confirm Password']/following::input[1]");
	private By SaveButton1    =    By.xpath("//*[@id='app']//button[@type='submit']");
	
	
	public AdminPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void addUser(String firstname, String lastname, String empid, String employee, String user, String password) throws Throwable {
        
		//PIM Page
		driver.findElement(clickPIM).click();
        driver.findElement(AddButton).click();
        driver.findElement(FirstName).sendKeys(firstname);
        driver.findElement(LastName).sendKeys(lastname);
        driver.findElement(EmployeeId).sendKeys(empid);
        driver.findElement(SaveButton).click();
				
		//Admin Page
		driver.findElement(clickAdmin).click();
        driver.findElement(AddButton1).click();
               
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(
        ExpectedConditions.elementToBeClickable(UserRoleDropdown)); 
        dropdown.click();
        
       //Select option for Admin
        WebElement option = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span[text()='Admin']")));
        option.click();
        
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown1 = wait1.until(
        ExpectedConditions.elementToBeClickable(StatusDropdown));
        dropdown1.click();
        
      //select option for Enabled
        WebElement option1= wait1.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span[text()='Enabled']")));
        option1.click();    
        
//        WebElement input = wait.until(
//        	    ExpectedConditions.visibilityOfElementLocated(
//        	        By.xpath("//input[@placeholder='Type for hints...']")));
//        input.sendKeys(employee);
//        
////        	 wait for suggestions
//        	wait.until(ExpectedConditions.visibilityOfElementLocated(
//        	    By.xpath("//div[@role='listbox']//span")));
//        	
//
////        	click required option
//        	wait.until(ExpectedConditions.elementToBeClickable(
//        	    By.xpath("//div[@role='listbox']//span[text()='+employee+']"))).click();
                
                          
        WebElement e = driver.findElement(EmployeeName);
        e.click();
        e.sendKeys("A");
        Thread.sleep(6000);
        e.sendKeys(Keys.ARROW_DOWN);
        e.sendKeys(Keys.ENTER);
    
        driver.findElement(UserName).sendKeys(user);
        driver.findElement(Password).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(ConfirmPassword).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(SaveButton1).click();
        
    }
	
	
}
