import data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_404  extends BaseGUITest{

    @Test(priority = 1, description = "Navigate to login page")
    @Description("Navigate to login")
    @Severity(SeverityLevel.CRITICAL)
    public void navigateLoginPage() {
        // Nothing to do
    }

    @Parameters({"username", "password"})
    @Test(priority = 2, description = "Enter username and password")
    @Description("Fill login mask")
    @Severity(SeverityLevel.BLOCKER)
    public void fillLoginMask(String username, String password) {
        loginPage.fillLoginMask(username, password);
        LOGGER.info("Username and password entered");
    }

    @Test(priority = 3, description = "Click login button")
    @Description("Login button click")
    @Severity(SeverityLevel.BLOCKER)
    public void clickLoginButton() {
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");
    }

    @Test(priority = 4, description = "Verify home page")
    @Description("Dashboard open")
    public void checkHomePage() {
        dashboardPage.verifyOpenMRSText();
        LOGGER.info("Dashboard opened");
    }

    @Test(priority = 5, description = "Navigate to Add Patient page from Dashboard")
    @Description("Add patient button clicked")
    public void navigateAddPatient() {
        dashboardPage.navbarClickAddPatient();
        LOGGER.info("Add patient button clicked");
    }

    @Test(priority = 6, description = "Fill and Submit Patient Registration Form",
            dataProvider = "patient info", dataProviderClass = TestData.class)
    @Description("Patient info added")
    public void fillAndSubmitForm(String firstName, String familyName, int gender, String birthdate, String address) {
        regPage.verifyPage();
        LOGGER.info("Patient Registration page opened");

        regPage.fillAndSubmitRegistrationForm(
                firstName,
                familyName,
                gender,
                birthdate,
                address
        );

        LOGGER.info("The record has been created.");
    }
}
