package tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.LogoutPage;

public class AdminTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	@Test(groups = "Sanity")
	public void addUser() throws Throwable {
		
		logger.info("Launching browser");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Login Page Opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        logger.info("Logged in Successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        logger.info("Click on PIM and Admin pages to add the user");
        AdminPage adminpage = new AdminPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        adminpage.addUser("Ram", "Lakshman", "012","A","Benjamin Franklin", "MyHRMORange@2026d");
        logger.info("User added successfully");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("saveSystemUser"), "User not added!");
        
        logger.info("Logging out");
        LogoutPage lp = new LogoutPage(driver);
        lp.Logout();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("auth"), "Logout did not happen");
			
	}
	
	
}
