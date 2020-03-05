package pages;

import base.OrangeHRMBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;

public class OrangeHRMDash extends OrangeHRMBase {

    private WebDriver driver;
    private WebDriverWait wait;

    By welcome = By.id("welcome");
    By leaveList = By.cssSelector(".quickLaungeContainer td:nth-child(2) a");
    By assignLeave = By.cssSelector(".quickLaungeContainer td:nth-child(1) a");
    By timeSheet = By.cssSelector(".quickLaungeContainer td:nth-child(3) a");

    /**
     * Creates a Home Page object that provides access to
     * Base page object methods.
     * @param driver
     */
    public OrangeHRMDash(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Method gets the welcome message in top right corner of home page.
     * @return Returns text of welcome message element.
     */
    public String getWelcome () { return driver.findElement(welcome).getText();}


    /////// Quick Launch Section ///////

    public void navigateToQuickLaunchAssignLeave () throws Exception{
        driver.findElement(assignLeave).click();
    }

    public void navigateToQuickLaunchLeaveList () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(leaveList))
                .click();
    }

    public WebElement quickLaunchtimeSheet () {
        return driver.findElement(timeSheet);
    }

    ////// End //////

}