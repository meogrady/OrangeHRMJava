package pages;

import base.OrangeHRMBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMAssignLeave extends OrangeHRMBase {

    private WebDriver driver;

    By quickLaunchAssignLeave = By.cssSelector(".quickLaunch a");
    By assignLeaveHeaderText = By.cssSelector(".head h1");

    /**
     *
     * @param driver
     */
    public OrangeHRMAssignLeave (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement setQuickLaunchAssignLeave () {
        return driver.findElement(quickLaunchAssignLeave);
    }

    /**
     *
     * @return
     */
    public String getHeaderText () {
        return driver.findElement(assignLeaveHeaderText).getText();
    }
}