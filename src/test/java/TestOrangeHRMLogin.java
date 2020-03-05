import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.OrangeHRMDash;
import pages.OrangeHRMLogin;


public class TestOrangeHRMLogin {

    private WebDriver driver;

    @BeforeSuite
    public void setUpClass () {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeTest
    public void setUp () {
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterTest
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testOrangeHRMLogin () throws Exception {

        OrangeHRMLogin login = new OrangeHRMLogin(driver);
        OrangeHRMDash dash = new OrangeHRMDash(driver);

        login.setUserName("Admin");
        login.setPassword("admin123");
        login.submitButton();

        // Wait for assignLeave element to appear on page
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement assignLeaveElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("welcome")));
        assignLeaveElement.click();

        Assert.assertEquals(dash.getWelcome(), "Welcome Admin");
    }
}