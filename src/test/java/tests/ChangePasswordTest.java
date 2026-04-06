package tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ChangePasswordPage;
import pages.LoginPage;
import pages.LogoutPage;

public class ChangePasswordTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	@Test
	public void ChangePassword() {
		
		logger.info("Logging to the portal");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage lp = new LoginPage(driver);
		logger.info("Provide User Credentials");
		lp.login("Admin", "admin123");
		
		ChangePasswordPage cp = new ChangePasswordPage(driver);
		logger.info("Changing the password");
		cp.ChangePassword("admin123", "Rparisha@2026", "Rparisha@2026");
		
		String CurrentURL = driver.getCurrentUrl();
		System.out.println(CurrentURL);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("updatePassword"), "Password not changed successfully");
		
		LogoutPage lo = new LogoutPage(driver);
		logger.info("Clicking on Profile button and logging out");
		lo.Logout();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("auth"), "Logout did not happen");
		
		
	}

}
