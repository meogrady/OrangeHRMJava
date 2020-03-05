package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Element;


public class OrangeHRMBase {

    private WebDriver driver;
    private WebDriverWait wait;
    private String BaseURL;
    private String PageURL;

    /**
     * Creates a base object that provides a repository for common methods.
     * @param driver Driver provided by the subclass class.
     */
    public OrangeHRMBase (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        BaseURL = "https://opensource-demo.orangehrmlive.com";
    }

    public OrangeHRMBase () {
        // TODO
    }

    /**
     * Navigate to the specified page indicated by the pageURL parameter.
     * @param pageURL The page in which to navigate.
     */
    public void navigateToPage (String pageURL) {
        driver.get(pageURL);
    }

    /**
     * Explicitly wait for element <code>locator</code> to be visible on the page.
     * @param locator The element to be visible.
     */
    public void elementIsVisible (String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    /**
     * Explictly wait for element <code>locator</code> to be on the page and clickable
     * @param locator The element to be clickable.
     */
    public void elementIsClickable (String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
    }

}