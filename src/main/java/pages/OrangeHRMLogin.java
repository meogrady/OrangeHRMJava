package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class OrangeHRMLogin extends base.OrangeHRMBase {

    private WebDriver driver;

    // By username = By.id("txtUsername");
    @FindBy(how = How.ID, using = "txtUsername")
    private WebElement username;

    // By password = By.id("txtPassword");
    @FindBy(how = How.ID, using = "txtPassword")
    private WebElement password;

    // By loginBtn = By.id("btnLogin");
    @FindBy(how = How.ID, using = "btnLogin")
    private WebElement loginBtn;



    /**
     * Creates a Login Page object that provides access to
     * Base page object methods.
     * @param driver The Login page's Selenium WebDriver
     */
    public OrangeHRMLogin (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Method sets the user's username in the User Name textbox.
     * @param uname The user's username defined at account setup.
     */
    public void setUserName (String uname) {
        username.sendKeys(uname);
    }

    /**
     * Method sets the user's username in the Password textbox.
     * @param psword The user's password defined at account setup.
     */
    public void setPassword (String psword) {
        password.sendKeys(psword);
    }

    /**
     * Method submits the user's credentials for authentication, and if
     * successful, logs user into the system and to the Home Page.
     */
    public void submitButton () {
        loginBtn.click();
    }

}