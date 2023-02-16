package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() { PageFactory.initElements(driver, this); }

    @FindBy(id = "searchBox")
    public WebElement SearchBox;

    @FindBy(id = "addNewRecordButton")
    public WebElement AddButton;

    @FindBy(id = "firstName")
    public WebElement FirstName;

    @FindBy(id = "lastName")
    public WebElement LastName;

    @FindBy(id = "userEmail")
    public WebElement Email;

    @FindBy(id = "age")
    public WebElement Age;

    @FindBy(id = "salary")
    public WebElement Salary;

    @FindBy(id = "department")
    public WebElement Department;

    @FindBy(id = "submit")
    public WebElement SubmitButton;

    @FindBy(className = "was-validated")
    public WebElement InvalidDataCrossMark;

    @FindBy(className = "modal-content")
    public WebElement RegistrationForm;

    @FindBy(css="span[title='Delete']")
    public WebElement DeleteButton;

    //-----------------------------------

    public void clickOnAddButton() {

        AddButton.click();
    }

    public void insertFirstName(String firstName){
        FirstName.clear();
        FirstName.sendKeys(firstName);
    }

    public void insertLastName(String lastName){
        LastName.clear();
        LastName.sendKeys(lastName);
    }

    public void insertEmail (String email) {
        Email.clear();
        Email.sendKeys(email);
    }

    public void insertAge(String age){
        Age.clear();
        Age.sendKeys(age);
    }

    public void insertSalary (String salary){
        Salary.clear();
        Salary.sendKeys((salary));
    }

    public void insertDepartment(String department) {
        Department.clear();
        Department.sendKeys(department);
    }

    public void clickOnSubmitButton () {

        SubmitButton.click();
    }




}
