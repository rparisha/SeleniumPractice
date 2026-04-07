package tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	    @Test(dataProvider="loginData", groups = "Smoke")
	    public void testValidLogin(String username, String password) {
	    	logger.info("Launching browser");
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        logger.info("Waiting to load the browser fully");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        logger.info("Home page loaded");
	        LoginPage loginPage = new LoginPage(driver);
	        logger.info("Providing Username and Password");
	        loginPage.login(username,password);
	        logger.info("Successfully logged in");

	        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"), "Login failed!");
	    }
	    
	    @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return new Object[][] {
	            {"Admin", "admin123"},
	            {"Admin", "wrongpass"},
	            {"InvalidUser", "admin123"}
	        };
	    }

}
