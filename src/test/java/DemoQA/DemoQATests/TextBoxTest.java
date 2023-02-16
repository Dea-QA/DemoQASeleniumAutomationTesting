package DemoQA.DemoQATests;

import DemoQA.DemoQABase.BaseTest;
import DemoQA.DemoQAPages.HomePage;
import DemoQA.DemoQAPages.ElementsElementsPage;
import DemoQA.DemoQAPages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest extends BaseTest {

    public TextBoxTest() {
        PageFactory.initElements(driver, this);}

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        textBoxPage = new TextBoxPage();


    }

    public void goToTextBoxPage() {

        homePage.clickOnElements();
        elementsElementsPage.clickOnTextBox();

        String expectedURL = excelReader.getData("URL", 1, 8);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


    }

    @Test (priority = 10)
    public void UserCanSubmitValidDataSuccessfully() {
      goToTextBoxPage();

      String fullName = excelReader.getData("TextBox", 1, 0);
      String email = excelReader.getData("TextBox", 1, 1);
      String currentAddress = excelReader.getData("TextBox", 1, 2);
      String permanentAddress = excelReader.getData("TextBox", 1,3);

      textBoxPage.insertFullName(fullName);
      textBoxPage.insertEmail(email);
      textBoxPage.insertCurrentAddress(currentAddress);
      textBoxPage.insertPermanentAddress(permanentAddress);
      scrollToElement(textBoxPage.SubmitButton);
      textBoxPage.clickOnSubmitButton();
      Assert.assertTrue(isDisplayed(textBoxPage.DataSubmittedTextNotification));

      Assert.assertTrue(textBoxPage.getFullName().contains("Name:Full Name"));
      Assert.assertTrue(textBoxPage.getEmail().contains("Email:name@email.com"));
      Assert.assertTrue(textBoxPage.getCurrentAddress().contains("Current Address :Address 1"));
      Assert.assertTrue(textBoxPage.getPermanentAddress().contains("Permananet Address :Address 2"));

    }

    @Test (priority = 20)
    public void userCanSubmitDataUsingFirstNameOrSurnameOnly () {
        goToTextBoxPage();

        String fullName = excelReader.getData("TextBox", 2, 0);
        String email = excelReader.getData("TextBox", 1, 1);
        String currentAddress = excelReader.getData("TextBox", 1, 2);
        String permanentAddress = excelReader.getData("TextBox", 1,3);

        textBoxPage.insertFullName(fullName);
        textBoxPage.insertEmail(email);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(textBoxPage.DataSubmittedTextNotification));

        Assert.assertTrue(textBoxPage.getFullName().contains("Name:Name"));
        Assert.assertTrue(textBoxPage.getEmail().contains("Email:name@email.com"));
        Assert.assertTrue(textBoxPage.getCurrentAddress().contains("Current Address :Address 1"));
        Assert.assertTrue(textBoxPage.getPermanentAddress().contains("Permananet Address :Address 2"));
    }

    @Test (priority = 30)
    public void userCanSubmitOnlyName () {
        goToTextBoxPage();

        String fullName = excelReader.getData("TextBox", 2, 0);

        textBoxPage.insertFullName(fullName);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getFullName(), "Name:Name");

    }

    @Test (priority = 40)
    public void userCanSubmitOnlyEmail () {
        goToTextBoxPage();

        String email = excelReader.getData("TextBox", 1, 1);

        textBoxPage.insertEmail(email);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getEmail(), "Email:name@email.com");

    }

    @Test (priority = 50)
    public void userCanSubmitCurrentAddressOnly () {
        goToTextBoxPage();

        String currentAddress = excelReader.getData("TextBox", 1, 2);

        textBoxPage.insertCurrentAddress(currentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getCurrentAddress(), "Current Address :Address 1");

    }

    @Test (priority = 60)
    public void userCanSubmitPermanentAddressOnly () {
        goToTextBoxPage();

        String permanentAddress = excelReader.getData("TextBox", 1,3);

        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getPermanentAddress(), "Permananet Address :Address 2");

    }

    @Test (priority = 70)
    public void userCanSubmitLowercaseAlphabetCharactersInFulNameField () {
        goToTextBoxPage();

        String fullName = excelReader.getData("TextBox", 3, 0);

        textBoxPage.insertFullName(fullName);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getFullName(), "Name:full name");

    }

    @Test (priority = 80)
    public void userCanSubmitUppercaseAlphabetCharactersInFulNameField () {
        goToTextBoxPage();

        String fullName = excelReader.getData("TextBox", 4, 0);

        textBoxPage.insertFullName(fullName);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getFullName(), "Name:FULL NAME");

    }

    @Test (priority = 90)
    public void userCanSubmitNumericCharactersOnlyInTheFullNameField () {
        goToTextBoxPage();

        String fullName = excelReader.getData("TextBox", 5, 0);

        textBoxPage.insertFullName(fullName);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getFullName(), "Name:123");

    }

    @Test (priority = 100)
    public void UserCanSubmitSpecialCharactersOnlyInTheFulNameField () {
        goToTextBoxPage();

        String fullName = excelReader.getData("TextBox", 6, 0);

        textBoxPage.insertFullName(fullName);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getFullName(), "Name:/()=?");

    }

    @Test (priority = 110)
    public void userCanSubmitDataWithEmptyFullNameField () {
        goToTextBoxPage();

        String email = excelReader.getData("TextBox", 1, 1);
        String currentAddress = excelReader.getData("TextBox", 1, 2);
        String permanentAddress = excelReader.getData("TextBox", 1,3);

        textBoxPage.FullNameField.clear();
        textBoxPage.insertEmail(email);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(textBoxPage.DataSubmittedTextNotification));


      Assert.assertTrue(textBoxPage.getEmail().contains("Email:name@email.com"));
      Assert.assertTrue(textBoxPage.getCurrentAddress().contains("Current Address :Address 1"));
      Assert.assertTrue(textBoxPage.getPermanentAddress().contains("Permananet Address :Address 2"));

    }


    @Test (priority =120)
    public void userCanSubmitLowercaseAlphabetCharactersInTheCurrentAddressField () {
        goToTextBoxPage();

        String currentAddress = excelReader.getData("TextBox", 3, 2);

        textBoxPage.insertCurrentAddress(currentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getCurrentAddress(), "Current Address :address");

    }

    @Test (priority = 130)
    public void userCanSubmitUppercaseAlphabetCharactersInTheCurrentAddressField () {
        goToTextBoxPage();

        String currentAddress = excelReader.getData("TextBox", 4, 2);

        textBoxPage.insertCurrentAddress(currentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getCurrentAddress(), "Current Address :ADDRESS 1");

    }


    @Test (priority = 140)
    public void userCanSubmitNumericCharactersOnlyInTheCurrentAddressField () {
        goToTextBoxPage();

        String currentAddress = excelReader.getData("TextBox", 5, 2);

        textBoxPage.insertCurrentAddress(currentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getCurrentAddress(), "Current Address :123");

    }


    @Test (priority = 150)
    public void UserCanSubmitSpecialCharactersOnlyInTheCurrentAddressField () {
        goToTextBoxPage();

        String currentAddress = excelReader.getData("TextBox", 6, 2);

        textBoxPage.insertCurrentAddress(currentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getCurrentAddress(), "Current Address :/()=?");

    }


    @Test (priority = 160)
    public void userCanSubmitDataWithEmptyCurrentAddressField () {
        goToTextBoxPage();

        String fullName = excelReader.getData("TextBox", 1, 0);
        String email = excelReader.getData("TextBox", 1, 1);
        String permanentAddress = excelReader.getData("TextBox", 1,3);

        textBoxPage.insertFullName(fullName);
        textBoxPage.insertEmail(email);
        textBoxPage.CurrentAddressField.clear();
        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(textBoxPage.DataSubmittedTextNotification));


       Assert.assertTrue(textBoxPage.getFullName().contains("Name:Full Name"));
       Assert.assertTrue(textBoxPage.getEmail().contains( "Email:name@email.com"));
       Assert.assertTrue(textBoxPage.getPermanentAddress().contains( "Permananet Address :Address 2"));

    }

    @Test (priority =170)
    public void userCanSubmitLowercaseAlphabetCharactersInThePermanentAddressField () {
        goToTextBoxPage();

        String permanentAddress = excelReader.getData("TextBox", 3, 3);

        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getPermanentAddress(), "Permananet Address :address");

    }

    @Test (priority = 180)
    public void userCanSubmitUppercaseAlphabetCharactersInThePermanentAddressField () {
        goToTextBoxPage();

        String permanentAddress = excelReader.getData("TextBox", 4, 3);

        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getPermanentAddress(), "Permananet Address :ADDRESS 2");

    }


    @Test (priority = 190)
    public void userCanSubmitNumericCharactersOnlyInThePermanentAddressField () {
        goToTextBoxPage();

        String permanentAddress = excelReader.getData("TextBox", 5, 3);

        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getPermanentAddress(), "Permananet Address :123");

    }

    @Test (priority = 200)
    public void UserCanSubmitSpecialCharactersOnlyInThePermanentAddressField () {
        goToTextBoxPage();

        String permanentAddress = excelReader.getData("TextBox", 6, 2);

        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getPermanentAddress(), "Permananet Address :/()=?");

    }

    @Test (priority = 210)
    public void userCanSubmitDataWithEmptyPermanentAddressField () {
        goToTextBoxPage();

        String fullName = excelReader.getData("TextBox", 1, 0);
        String email = excelReader.getData("TextBox", 1, 1);
        String currentAddress = excelReader.getData("TextBox", 1,2);

        textBoxPage.insertFullName(fullName);
        textBoxPage.insertEmail(email);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.PermanentAddressField.clear();
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(textBoxPage.DataSubmittedTextNotification));

       Assert.assertTrue(textBoxPage.getFullName().contains( "Name:Full Name"));
       Assert.assertTrue(textBoxPage.getEmail().contains("Email:name@email.com"));
       Assert.assertTrue(textBoxPage.getCurrentAddress().contains("Current Address :Address 1"));
    }

    @Test (priority = 220)
    public void userCannotSubmitInvalidEmail() {
       goToTextBoxPage();
        String[] invalidEmails = excelReader.readColumn("TextBox", "Invalid Email");  //Array stringova u koloni
        for (int i = 0; i < invalidEmails.length; i++) {
            textBoxPage.insertEmail(invalidEmails[i]);
            textBoxPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(textBoxPage.InvalidEmailNotification));
        }
      //  System.out.println(Arrays.toString(invalidEmails));
    }

    @AfterMethod
    public void tearDown() {
       driver.manage().deleteAllCookies();
       driver.quit();
    }

}





