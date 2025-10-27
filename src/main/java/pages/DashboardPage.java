package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//header//*[name()='svg' and @aria-label='OpenMRS Logo']")
    private WebElement openMRSText;

    @FindBy(xpath = "//span[contains(@class, 'currentLocationText')]")
    private WebElement locationText;

    @FindBy(xpath = "//*[@id='single-spa-application:@openmrs/esm-primary-navigation-app-page-0']/div/header/div[3]/div[1]/div[1]/div/div/span/div/button/svg")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id='search-input-:rer:']")
    private WebElement sendKeySearchBox;

    @FindBy(xpath = "//div[@data-extension-id='add-patient-action']//button[@aria-label='Add patient']")
    private WebElement clickAddPatient;

    @FindBy(xpath = "//*[name()='svg' and .//*[name()='use' and contains(@href,'omrs-icon-user-avatar')]]")
    private WebElement myAccountLink ;

    @FindBy(xpath = "//button[@class='-esm-login__logout__logout___fmll0 cds--btn cds--btn--ghost']")
    private WebElement clickLogOut;

    @FindBy(xpath = "//*[name()='use' and contains(@href,'omrs-icon-switcher')]/parent::*")
    private WebElement appMenu ;

    @FindBy(xpath = "//a[contains(text(),'System Administration')]")
    private WebElement systemAdministration ;

    @FindBy(xpath = "//div[@data-extension-id='service-queues-dashboard-link']")
    private WebElement serviceQueues;

    @FindBy(xpath = "//div[@data-extension-id='clinical-appointments-dashboard-link']")
    private WebElement appointments;

    @FindBy(xpath = "//div[@data-extension-id='patient-lists-dashboard-link']")
    private WebElement patientLists;

    @FindBy(xpath = "//div[@data-extension-id='ward-dashboard-link']")
    private WebElement wards;

    @FindBy(xpath = "//div[@data-extension-id='laboratory-dashboard-link']")
    private WebElement laboratory;


    public DashboardPage(final WebDriver driver) {
        super(driver);
    }

    public void verifyOpenMRSText() {
        verifyDisplayed(openMRSText, "OpenMRS text is not displayed");
        LOGGER.info("OpenMRS text verified");
    }

    public void verifyLocationText() {
        verifyDisplayed(locationText, "Location text is not displayed");
        LOGGER.info("Location text verified");
    }

    public void clickSearchBox(){
        clickElement(searchBox);
        LOGGER.info("Search box clicked");
    }
    public void sendKeySearchBox(final String patient) {
        sendKeysToElement(sendKeySearchBox, patient);
        LOGGER.info("Patient name entered");
    }
    public void navbarClickAddPatient(){
        clickElement(clickAddPatient);
        LOGGER.info("Add patient clicked");
    }
    public void clickMyAccountLink(){
        clickElement(myAccountLink);
        LOGGER.info("My accoount clicked");
    }
    public void clickLogOut(){
        clickElement(clickLogOut);
        LOGGER.info("Logout clicked");
    }
    public void verifyAppMenu() {
        verifyDisplayed(appMenu, "App Menu is not displayed");
        LOGGER.info("App Menu verified");
    }
    public void clickAppMenu(){
        clickElement(appMenu);
        LOGGER.info("App Menu clicked");
    }
    public void clickSystemAdministration(){
        clickElement(systemAdministration);
        LOGGER.info("System Administration clicked");
    }
    public void clickServiceQueues(){
        clickElement(serviceQueues);
        LOGGER.info("Service Queues clicked");
    }
    public void clickAppointments(){
        clickElement(appointments);
        LOGGER.info("Appointments clicked");
    }
    public void clickPatientLists(){
        clickElement(patientLists);
        LOGGER.info("Patient lists clicked");
    }
    public void clickWards(){
        clickElement(wards);
        LOGGER.info("Wards clicked");
    }
    public void clickLaboratory(){
        clickElement(laboratory);
        LOGGER.info("Laboratory clicked");
    }

}