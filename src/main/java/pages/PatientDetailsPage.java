package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientDetailsPage extends BasePage{

    @FindBy (xpath = "//div[@class='cds--tab--list']/button[3]")
    private WebElement myListButton;

    @FindBy(xpath = "//*[@id=\"single-spa-application:@openmrs/esm-home-app-page-0\"]/main/div/section/div[2]/div/main/section/div[2]/div[2]/section/div/table/tbody/tr[5]/td[1]/a")
    private WebElement barisCansizButton;

    @FindBy(xpath = "//div[@class='E6QoCxKy3JK7VOI-2yhNXA==']/p[@class='P5kBN-q2g2nkNYCgydQ1vg==']")
    private WebElement verifyPatientList;

    @FindBy(xpath = "//*[@id=\"single-spa-application:@openmrs/esm-home-app-page-0\"]/main/div/section/div[2]/div/main/section[2]/div/div[2]/section/div/table/tbody/tr[1]/td[1]/a")
    private WebElement verifyPatient1;

    @FindBy(xpath = "//*[@id=\"single-spa-application:@openmrs/esm-home-app-page-0\"]/main/div/section/div[2]/div/main/section[2]/div/div[2]/section/div/table/tbody/tr[2]/td[1]/a")
    private WebElement verifyPatient2;

    @FindBy(xpath = "//*[@id=\"single-spa-application:@openmrs/esm-home-app-page-0\"]/main/div/section/div[2]/div/main/section[2]/div/div[2]/section/div/table/tbody/tr[3]/td[1]/a")
    private WebElement verifyPatient3;

    @FindBy(xpath = "//*[@id=\"single-spa-application:@openmrs/esm-home-app-page-0\"]/main/div/section/div[2]/div/main/section[2]/div/div[2]/section/div/table/tbody/tr[4]/td[1]/a")
    private WebElement verifyPatient4;

    public void verifyPatientLists(){
        verifyDisplayed(verifyPatient1,"The patient did not appear on the page.");
        verifyDisplayed(verifyPatient2,"The patient did not appear on the page.");
        verifyDisplayed(verifyPatient3,"The patient did not appear on the page.");
        verifyDisplayed(verifyPatient4,"The patient did not appear on the page.");
    }
    public void clickMyListButton() {
        clickElement(myListButton);
    }


    public void verifyList(){
        verifyDisplayed(barisCansizButton,"The list didn't appear.");
    }

    public void verifyPatientList(){
        verifyDisplayed(verifyPatientList,"The patient list text is not visible.");
    }

    public PatientDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBarisCansizBtn(){
        clickElement(barisCansizButton);
    }
}