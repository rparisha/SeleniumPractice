package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.DriverFactory;
import utils.ExtentManager;

public class BaseTest {
	
	protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass 
    public void setUp() {
        driver = DriverFactory.getDriver();
        extent = ExtentManager.getInstance();
    }

    @AfterClass
    public void tearDown() {
        //DriverFactory.quitDriver();
       
    }

}
