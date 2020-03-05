package pages;

import base.OrangeHRMBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMLeaveList extends OrangeHRMBase {

    private WebDriver driver;
    By leaveListHeaderText = By.cssSelector(".head h1");

    public OrangeHRMLeaveList (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getHeaderText () {
        return driver.findElement(leaveListHeaderText).getText();
    }
}