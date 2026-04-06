package tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

public class AdminTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	@Test
	public void addUser() {
		
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
        adminpage.addUser("Sanju", "Samson", "090101", "Sanju", "Ranjith Parisha", "MyOrangeHRM@2026");
        logger.info("User added successfully");
        
        Assert.assertTrue(driver.getTitle().contains("viewSystemUsers"), "User not added!");
		
		
	}

}
