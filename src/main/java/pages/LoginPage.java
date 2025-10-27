package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//div[@class='-esm-login__login__center___+yhR+']")
    private WebElement openMRSText;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//button[contains(@class,'-esm-login')]")
    private WebElement continueBtn;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'-esm-login')]")
    private WebElement loginBtn;

    @FindBy(xpath = "//p[@class='-esm-login__location-picker__welcomeTitle___iI+4Z']")
    private WebElement welcomeAdminText;

    @FindBy(xpath = "//span[@class='cds--radio-button__label-text']/span")
    private WebElement outpatientClinicSelectBtn;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement confirmBtn;

    @FindBy(xpath = "//div[@class='cds--inline-notification__subtitle']")
    private WebElement invalidMessage;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void verifyLoginPage() {
        verifyDisplayed(openMRSText, "Login page did not open");
    }

    public void checkPageLocation() {
        verifyDisplayed(outpatientClinicSelectBtn, "OutpatientClinic Selection is not visible.");
        verifyDisplayed(welcomeAdminText, "The welcome admin text is not visible. ");
        verifyDisplayed(confirmBtn,"confirm button is not visible");
        LOGGER.info("Location page verified");
    }
    public void checkPage() {
        verifyDisplayed(invalidMessage, "Invalid login message not displayed");
        LOGGER.info("Invalid message verified");
    }

    public void fillLoginMask(final String username, final String password) {
        sendKeysToElement(usernameInput, username);
        Assert.assertEquals(username, usernameInput.getAttribute("value"), "Username not entered");
        LOGGER.info("Username entered");

        clickElement(continueBtn);
        LOGGER.info("Continue button clicked");

        sendKeysToElement(passwordInput, password);
        Assert.assertEquals(password, passwordInput.getAttribute("value"), "Password not entered");
        LOGGER.info("Password entered");
    }

    public void outpatientClinic() {
        verifyDisplayed(outpatientClinicSelectBtn, "The ‘Inpatient Ward’ location is not visible.");
        clickElement(outpatientClinicSelectBtn);
        LOGGER.info("'Inpatient Ward' location selected");
    }

    public void clickLoginBtn(){
        clickElement(loginBtn);
        LOGGER.info("Login button clicked");
    }
    public void checkInvalidCredentialsMessage() {
        verifyDisplayed(invalidMessage, "The invalid username/password warning is not visible.");
        LOGGER.info("Invalid credentials message visible");
    }

    public void clickContinueBtn(){
        clickElement(continueBtn);
        LOGGER.info("Contınue button clicked");
    }

    public void clickConfirmBtn(){
        clickElement(confirmBtn);
        LOGGER.info("confırm button clicked");
    }

}
