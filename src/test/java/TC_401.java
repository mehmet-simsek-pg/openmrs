import data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class TC_401 extends BaseGUITest{

    /**
     * Login Error Validation
     * */

    @Test(priority = 1, description = "Verify not login with invalid credentials",
            dataProvider = "invalid login credentials",
            dataProviderClass = TestData.class)
    @Description("Verify not login with wrong credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void checkLoginWithInvalidData(String username, String password) {
        loginPage.fillLoginMask(username, password);
        LOGGER.info("Username and password entered");

        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked");

        loginPage.checkInvalidCredentialsMessage();
        LOGGER.info("Invalid message displayed");

        BaseDriver.threadWait(2);
    }
}
