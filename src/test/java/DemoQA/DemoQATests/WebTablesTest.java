package DemoQA.DemoQATests;

import DemoQA.DemoQABase.BaseTest;
import DemoQA.DemoQAPages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTablesTest extends BaseTest {
    public WebTablesTest() {PageFactory.initElements(driver, this);}

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        webTablesPage = new WebTablesPage();
    }
    public void goToWebTablesPage() {

        homePage.clickOnElements();
        elementsElementsPage.clickOnWebTables();

        String expectedURL = excelReader.getData("URL", 1, 11);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 10)
    public void verifyThatAddButtonIsClickable(){
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();
        waitForClickability(webTablesPage.SubmitButton);
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }


    @Test(priority = 20)
    public void UserCanSubmitRegistrationFormWithValidDataSuccessfully() {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }



    @Test (priority = 30)
    public void userCannotSubmitRegistrationFormWithFirstNameOnly () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.LastName.clear();
        webTablesPage.Email.clear();
        webTablesPage.Age.clear();
        webTablesPage.Salary.clear();
        webTablesPage.Department.clear();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 40)
    public void userCannotSubmitRegistrationFormWithLastNameOnly () {
        goToWebTablesPage();

        String lastName = excelReader.getData("WebTables", 1, 2);

        webTablesPage.clickOnAddButton();
        webTablesPage.FirstName.clear();
        webTablesPage.insertLastName(lastName);
        webTablesPage.Email.clear();
        webTablesPage.Age.clear();
        webTablesPage.Salary.clear();
        webTablesPage.Department.clear();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 50)
    public void userCannotSubmitRegistrationFormWithEmailOnly () {
        goToWebTablesPage();

        String email = excelReader.getData("WebTables", 1, 4);

        webTablesPage.clickOnAddButton();
        webTablesPage.FirstName.clear();
        webTablesPage.LastName.clear();
        webTablesPage.insertEmail(email);
        webTablesPage.Age.clear();
        webTablesPage.Salary.clear();
        webTablesPage.Department.clear();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 60)
    public void userCannotSubmitRegistrationFormWithAgeOnly () {
        goToWebTablesPage();

        String age = excelReader.getData("WebTables", 1, 6);

        webTablesPage.clickOnAddButton();
        webTablesPage.FirstName.clear();
        webTablesPage.LastName.clear();
        webTablesPage.Email.clear();
        webTablesPage.insertAge(age);
        webTablesPage.Salary.clear();
        webTablesPage.Department.clear();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 70)
    public void userCannotSubmitRegistrationFormWithSalaryOnly () {
        goToWebTablesPage();

        String salary = excelReader.getData("WebTables", 1, 8);

        webTablesPage.clickOnAddButton();
        webTablesPage.FirstName.clear();
        webTablesPage.LastName.clear();
        webTablesPage.Email.clear();
        webTablesPage.Age.clear();
        webTablesPage.insertSalary(salary);
        webTablesPage.Department.clear();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 80)
    public void userCanSubmitRegistrationFormWithLowercaseAlphabetCharactersInFirstNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 3, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 90)
    public void userCanSubmitRegistrationFormWithLowercaseAlphabetCharactersInLastNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 3, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 100)
    public void userCanSubmitRegistrationFormWithLowercaseAlphabetCharactersInDepartmentField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 3,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }


    @Test (priority = 110)
    public void userCanSubmitRegistrationFormWithUppercaseAlphabetCharactersInFirstNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 4, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 120)
    public void userCanSubmitRegistrationFormWithUppercaseAlphabetCharactersInLastNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 4, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 130)
    public void userCanSubmitRegistrationFormWithUppercaseAlphabetCharactersInDepartmentField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 4,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 140)
    public void userCanSubmitRegistrationFormWithNumericCharactersInFirstNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 5, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 150)
    public void userCanSubmitRegistrationFormWithNumericCharactersInLastNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 5, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 160)
    public void userCanSubmitRegistrationFormWithNumericCharactersInDepartmentField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 5,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 170)
    public void userCanSubmitRegistrationFormWithSpecialCharactersInFirstNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 6, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 180)
    public void userCanSubmitRegistrationFormWithSpecialCharactersInLastNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 6, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 190)
    public void userCanSubmitRegistrationFormWithSpecialCharactersInDepartmentField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 6,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        waitForClickability(webTablesPage.AddButton);
        Assert.assertTrue(isDisplayed(webTablesPage.AddButton));
        Assert.assertFalse(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertFalse(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertFalse(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 200)
    public void userCannotSubmitRegistrationFormWithEmptyFirstNameField () {
        goToWebTablesPage();

        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.FirstName.clear();
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 210)
    public void userCannotSubmitRegistrationFormWithEmptyLastNameField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.LastName.clear();
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 220)
    public void userCannotSubmitRegistrationFormWithEmptyEmailField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.Email.clear();
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 230)
    public void userCannotSubmitRegistrationFormWithEmptySalaryField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.Salary.clear();
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 240)
    public void userCannotSubmitRegistrationFormWithEmptyAgeField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.Age.clear();
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 250)
    public void userCannotSubmitRegistrationFormWithEmptyDepartmentField () {
        goToWebTablesPage();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);

        webTablesPage.clickOnAddButton();
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.Department.clear();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }

    @Test (priority = 260)
    public void userCannotSubmitRegistrationFormWithInvalidEmail () {
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String[] invalidEmails = excelReader.readColumn("WebTables", "Invalid Email");
        String age = excelReader.getData("WebTables", 1, 6);
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);
        for (int i = 1; i < invalidEmails.length; i++) {

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(invalidEmails[i]);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(department);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
            Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
            Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
        }
    }

    @Test (priority = 270)
    public void userCannotSubmitRegistrationFormWithInvalidAge () {
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1,4);
        String[] invalidAge = excelReader.readColumn("WebTables", "Invalid Age");
        String salary = excelReader.getData("WebTables", 1, 8);
        String department = excelReader.getData("WebTables", 1,10);
        for (int i = 1; i < invalidAge.length; i++) {

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(invalidAge[i]);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(department);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
            Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
            Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
        }
    }

    @Test (priority = 280)
    public void userCannotSubmitRegistrationFormWithInvalidSalary () {
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1, 4);
        String age = excelReader.getData("WebTables", 1, 6);
        String[] invalidSalary = excelReader.readColumn("WebTables", "Invalid Salary");
        String department = excelReader.getData("WebTables", 1,10);
        for (int i = 1; i < invalidSalary.length; i++) {

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(invalidSalary[i]);
            webTablesPage.insertDepartment(department);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
            Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
            Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
        }
    }

    @Test (priority = 290)
    public void userCannotSubmitRegistrationFormWithInvalidEmailAndSalary () {
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String[] invalidEmail = excelReader.readColumn("WebTables", "Invalid Email");
        String age = excelReader.getData("WebTables", 1, 6);
        String[] invalidSalary = excelReader.readColumn("WebTables", "Invalid Salary");
        String department = excelReader.getData("WebTables", 1,10);
        for (int i = 1; i < invalidSalary.length; i++) {

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(invalidEmail[i]);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(invalidSalary[i]);
            webTablesPage.insertDepartment(department);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
            Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
            Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
        }
    }

    @Test (priority = 300)
    public void userCannotSubmitRegistrationFormWithInvalidAgeAndSalary () {
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String email = excelReader.getData("WebTables", 1,4);
        String[] invalidAge = excelReader.readColumn("WebTables", "Invalid Age");
        String[] invalidSalary = excelReader.readColumn("WebTables", "Invalid Salary");
        String department = excelReader.getData("WebTables", 1,10);
        for (int i = 1; i < invalidSalary.length; i++) {

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(invalidAge[i]);
            webTablesPage.insertSalary(invalidSalary[i]);
            webTablesPage.insertDepartment(department);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
            Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
            Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
        }
    }

    @Test (priority = 310)
    public void userCannotSubmitRegistrationFormWithInvalidAgeAndEmail () {
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String[] invalidEmail = excelReader.readColumn("WebTables", "Invalid Email");
        String[] invalidAge = excelReader.readColumn("WebTables", "Invalid Age");
        String salary = excelReader.getData("WebTables", 1,8);
        String department = excelReader.getData("WebTables", 1,10);
        for (int i = 1; i < invalidAge.length; i++) {

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(invalidEmail[i]);
            webTablesPage.insertAge(invalidAge[i]);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(department);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
            Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
            Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
        }
    }
    @Test (priority = 320)
    public void userCannotSubmitRegistrationFormWithInvalidAgeEmailAndSalary () {
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getData("WebTables", 1, 0);
        String lastName = excelReader.getData("WebTables", 1, 2);
        String[] invalidEmail = excelReader.readColumn("WebTables", "Invalid Email");
        String[] invalidAge = excelReader.readColumn("WebTables", "Invalid Age");
        String[] invalidSalary = excelReader.readColumn("WebTables", "Invalid Salary");
        String department = excelReader.getData("WebTables", 1,10);
        for (int i = 1; i < invalidAge.length; i++) {

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(invalidEmail[i]);
            webTablesPage.insertAge(invalidAge[i]);
            webTablesPage.insertSalary(invalidSalary[i]);
            webTablesPage.insertDepartment(department);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
            Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
            Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
        }
    }

    @Test(priority = 330)
    public void userCannotSubmitRegistrationFormWithEmptyFields(){
        goToWebTablesPage();
        webTablesPage.clickOnAddButton();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(webTablesPage.InvalidDataCrossMark));
        Assert.assertTrue(isDisplayed(webTablesPage.RegistrationForm));
        Assert.assertTrue(isDisplayed(webTablesPage.SubmitButton));
    }


    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}




