package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManagePatientsPage extends BasePage {

    @FindBy(id = "inputNode")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"openmrsSearchTable\"]/tbody/tr")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//*[@id=\"content\"]/form[2]/fieldset/input[1]")
    private WebElement deleteReasonInput;

    @FindBy(xpath = "//input[@value='Delete Patient']")
    private WebElement deletePatientButton;

    @FindBy(id = "info-message")
    private WebElement successMessage;

    public ManagePatientsPage(WebDriver driver) {
        super(driver);
    }

    public void searchAndSelectPatient(String patientNameOrId) {
        sendKeysToElement(searchInput, patientNameOrId);
        LOGGER.info("Hasta arandı: " + patientNameOrId);

        clickElement(firstSearchResult);
        LOGGER.info("Arama sonucundaki ilk hasta seçildi.");
    }

    public void enterDeletionReason(String reason) {
        sendKeysToElement(deleteReasonInput, reason);
        LOGGER.info("Silme nedeni girildi: " + reason);
    }

    public void clickDeletePatient() {
        clickElement(deletePatientButton);
        LOGGER.info("'Delete Patient' butonuna tıklandı.");
    }

    public String getSuccessMessageText() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        String message = successMessage.getText();
        LOGGER.info("Başarı mesajı okundu: " + message);
        return message;
    }
}