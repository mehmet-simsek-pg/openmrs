package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{

    @FindBy(xpath = "//div[@class='-esm-login__login__center___+yhR+']")
    private WebElement openMRSText;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//button[@class='-esm-login__login__continueButton___VnN+0 cds--btn cds--btn--primary']")
    private WebElement continueBtn;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='-esm-login__login__continueButton___VnN+0 cds--btn cds--btn--primary']")
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

    public void checkPageUsername() {
        verifyDisplayed(usernameInput, "The login page did not open (username field not found).");
        verifyDisplayed(openMRSText, "The login page did not open (login text not found)");
        verifyDisplayed(continueBtn,"contınue button is not visible");
        LOGGER.info("Login page 1 verified");
    }
    public void checkPagePassword() {
        verifyDisplayed(passwordInput, "The login page did not open (password field not found).");
        verifyDisplayed(loginBtn,      "The login page did not open (login button not found).");
        LOGGER.info("Login page 2 verified");
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

    public void enterUsername(final String username) {
        sendKeysToElement(usernameInput, username);
        LOGGER.info("Username entered");

    }
    public void enterPassword(final String password) {
        sendKeysToElement(passwordInput, password);
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
