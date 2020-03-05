package pages;

import base.OrangeHRMBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMTimeSheets extends OrangeHRMBase {

    private WebDriver driver;

    By quickLaunchTimeSheets = By.cssSelector(".quickLaunch a");
    By timeSheetsHeaderText = By.cssSelector("#content h1");

    public OrangeHRMTimeSheets (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement setQuickLaunchTimeSheets () {return driver.findElement(quickLaunchTimeSheets);}

    public String getTimeSheetsHeadText () {
        return driver.findElement(timeSheetsHeaderText).getText();
    }
}