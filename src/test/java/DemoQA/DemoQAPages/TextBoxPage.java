package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {


    public TextBoxPage() { PageFactory.initElements(driver, this); }

    @FindBy (id = "userName")
    public WebElement FullNameField;

    @FindBy(id = "userEmail")
    public WebElement EmailField;

    @FindBy (id = "currentAddress")
    public WebElement CurrentAddressField;

    @FindBy (id = "permanentAddress")
    public WebElement PermanentAddressField;

    @FindBy (id = "submit")
    public  WebElement SubmitButton;

    //-------text appearing after click on submit button-------

    @FindBy(id = "name")
    public WebElement NameText;

    @FindBy(id = "email")
    public WebElement EmailText;

    @FindBy (css = ".mr-sm-2.field-error.form-control")
    public WebElement InvalidEmailNotification;

    @FindBy(id = "output")
    public WebElement CurrentAddressText;

    @FindBy(id = "output")
    public WebElement PermanentAddressText;

    @FindBy(css = ".border.col-md-12.col-sm-12")
    public WebElement DataSubmittedTextNotification;

    //-----------------------------------------------


    public void insertFullName(String fullName) {
        FullNameField.clear();
        FullNameField.sendKeys(fullName);
    }

    public void insertEmail(String email) {
        EmailField.clear();
        EmailField.sendKeys(email);
    }

    public void insertCurrentAddress(String currentAddress) {
        CurrentAddressField.clear();
        CurrentAddressField.sendKeys(currentAddress);
    }

    public void insertPermanentAddress(String permanentAddress) {
        PermanentAddressField.clear();
        PermanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton() {

        SubmitButton.click();
    }

    public String getFullName (){
        return NameText.getText(); }

    public String getEmail () {
        return EmailText.getText(); }

    public String getCurrentAddress () {
        return CurrentAddressText.getText(); }

    public String getPermanentAddress () {
        return PermanentAddressText.getText(); }

}
