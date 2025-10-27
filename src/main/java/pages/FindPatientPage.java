package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindPatientPage extends BasePage{

    @FindBy(xpath = "//*[text()='Scarlett Johansson']")
    private WebElement patientName;
    @FindBy(css = "#omrs-left-nav-container > nav > div:nth-child(2) > div:nth-child(12) > div > a")
    private WebElement appointments;


    public void verifyPatientName(){
        verifyDisplayed(patientName, "Patient not found");
        LOGGER.info("Searched Patient is found");
    }

    public void appointments(){
        appointments.click();
        LOGGER.info("Appointments is clickable");

    }
    public FindPatientPage(WebDriver driver) {
        super(driver);
    }


}