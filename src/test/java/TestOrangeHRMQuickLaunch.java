import base.OrangeHRMBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestOrangeHRMQuickLaunch extends OrangeHRMBase {

    private WebDriver driver;

    @BeforeSuite
    public void setUpClass () { WebDriverManager.firefoxdriver().setup();}

    @BeforeMethod
    public void setUp () {
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait (10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testQuickLaunchAssignLeave () throws Exception{

        OrangeHRMLogin login = new OrangeHRMLogin(driver);
        OrangeHRMDash dash = new OrangeHRMDash(driver);
        OrangeHRMAssignLeave leave = new OrangeHRMAssignLeave(driver);

        // Login
        login.setUserName("Admin");
        login.setPassword("admin123");
        login.submitButton();

        // click 'Assign Leave"
        dash.navigateToQuickLaunchAssignLeave();

        // Verify unique text from AL page matches
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement assignLeaveElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quickLaungeContainer tr > td:nth-child(1) a")));
        assignLeaveElement.click();

        Assert.assertEquals(leave.getHeaderText(), "Assign Leave");
    }

    @Test
    public void testQuickLaunchLeaveList () {

        // login
        OrangeHRMLogin login = new OrangeHRMLogin(driver);
        OrangeHRMDash dash = new OrangeHRMDash(driver);
        OrangeHRMLeaveList list = new OrangeHRMLeaveList(driver);

        login.setUserName("Admin");
        login.setPassword("admin123");
        login.submitButton();

        // Click Leave List
        dash.navigateToQuickLaunchLeaveList();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement leaveListElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quickLaungeContainer tr > td:nth-child(2) a")));
        leaveListElement.click();

        // Verify successful navigation to page
        Assert.assertEquals(list.getHeaderText(), "Leave List");
    }

    @Test
    public void testQuickLaunchTimeSheets () {
        // login
        OrangeHRMLogin login = new OrangeHRMLogin(driver);
        OrangeHRMDash dash = new OrangeHRMDash(driver);
        OrangeHRMTimeSheets timeSheets = new OrangeHRMTimeSheets(driver);

        login.setUserName("Admin");
        login.setPassword("admin123");
        login.submitButton();

        // Click Leave List
        dash.navigateToQuickLaunchLeaveList();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement leaveListElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quickLaungeContainer tr > td:nth-child(3) a")));
        leaveListElement.click();

        // Verify page
        Assert.assertEquals(timeSheets.getTimeSheetsHeadText(), "Select Employee");
    }

}