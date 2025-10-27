package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PatientRegistrationPage extends BasePage {

    @FindBy(name = "givenName")
    private WebElement firstNameInput;

    @FindBy(name = "familyName")
    private WebElement familyNameInput;

    @FindBy(css = "input[name='gender']")
    private List<WebElement> genderSelect;

    @FindBy(css = "div[id='birthdate']>div")
    private WebElement birthdayInput;

    @FindBy(xpath = "div[id='birthdate']")
    private WebElement birthdateDaySpan;

    @FindBy(xpath = "//span[@data-type='month']")
    private WebElement birthdateMonthSpan;

    @FindBy(xpath = "//span[@data-type='year']")
    private WebElement birthdateYearSpan;

    @FindBy(css = "#address1")
    private WebElement addressInput;

    @FindBy(xpath = "//button[contains(text(), 'Register patient')]")
    private WebElement registerPatientButton;

    @FindBy(xpath = "//h4[text()='Create new patient']")
    private WebElement pageHeader;

    public PatientRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPage() {
        verifyDisplayed(pageHeader, "Patient Registration sayfası yüklenemedi (header bulunamadı).");
        LOGGER.info("Patient Registration sayfası doğrulandı.");
    }

    public void enterPatientName(String firstName, String familyName) {
        sendKeysToElement(firstNameInput, firstName);
        sendKeysToElement(familyNameInput, familyName);
        LOGGER.info("Hasta adı girildi: " + firstName + " " + familyName);
    }

    public void selectGender(final int gender) {
        clickElement(genderSelect.get(gender));
    }

    public void selectBirthday(final String birthDay) {
        sendKeysToElement(birthdayInput, birthDay);
    }
    public void selectPatientGender(String genderText) {
        try {
            String genderXPath = "//span[text()='" + genderText + "']";
            WebElement genderElement = driver.findElement(By.xpath(genderXPath));
            clickElement(genderElement);
            LOGGER.info("Cinsiyet seçildi: " + genderText);
        } catch (Exception e) {
            LOGGER.error("Cinsiyet seçimi (" + genderText + ") başarısız oldu. ", e);
            throw new RuntimeException("Cinsiyet elementi bulunamadı veya tıklanamadı: " + genderText, e);
        }
    }

    public void enterPatientBirthdate(String date) {
        try {
            String[] dateParts = date.split("-");
            String day = dateParts[0]; // "10"
            String month = dateParts[1]; // "01"
            String year = dateParts[2]; // "1990"

            sendKeysToElement(birthdateDaySpan, day);
            sendKeysToElement(birthdateMonthSpan, month);
            sendKeysToElement(birthdateYearSpan, year);
            LOGGER.info("Doğum tarihi 3 ayrı span'e girildi: " + date);
        } catch (Exception e) {
            LOGGER.error("Doğum tarihi (" + date + ") girilemedi. 3 span'li yapı için metot güncellendi ancak bir hata oluştu.", e);
            throw new RuntimeException("Doğum tarihi girilemedi. Lütfen formatı (GG-AA-YYYY) kontrol edin.", e);
        }
    }

    public void enterPatientAddress(String address) {
        sendKeysToElement(addressInput, address);
        LOGGER.info("Adres girildi: " + address);
    }

    public void clickRegisterPatientButton() {
        clickElement(registerPatientButton);
        LOGGER.info("'Register patient' butonuna tıklandı.");
    }

    public void fillAndSubmitRegistrationForm(String fName, String lName, int gender, String dob, String address) {
        LOGGER.info("Hasta kayıt formu dolduruluyor...");
        enterPatientName(fName, lName);
        selectGender(gender);
        selectBirthday(dob);
        enterPatientAddress(address);
        clickRegisterPatientButton();
        LOGGER.info("----Hasta kayıt formu gönderildi.----");
    }
}