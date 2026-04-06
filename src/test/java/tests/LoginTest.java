package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {
	    @Test
	    public void testValidLogin() {
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("Admin", "admin123");

	        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"), "Login failed!");
	    }

}
