import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PatientRegistrationPage;
import utility.BaseDriver;

public class BaseGUITest {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    public WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected PatientRegistrationPage regPage;

    @BeforeClass
    public void init(){
        driver  = BaseDriver.driver("https://o3.openmrs.org/openmrs/spa/login");
        LOGGER.info("Web sitesi acildi");

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        regPage = new PatientRegistrationPage(driver);
    }

    @AfterClass
    public void quitTest() {
        driver.quit();
        LOGGER.info("Tarayici kapandi");
    }
}
