import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utility.BaseDriver;

public class BaseGUITest {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    public WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void init(String browser){
        driver  = BaseDriver.driver("https://o3.openmrs.org/openmrs/spa/login", browser);
        LOGGER.info("Web sitesi acildi");
    }

    @AfterClass
    public void quitTest() {
        driver.quit();
        LOGGER.info("Tarayici kapandi");
    }
}
