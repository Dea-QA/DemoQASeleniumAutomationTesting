package DemoQA.DemoQATests;

import DemoQA.DemoQABase.BaseTest;
import DemoQA.DemoQAPages.ButtonsPage;
import DemoQA.DemoQAPages.HomePage;
import DemoQA.DemoQAPages.ElementsElementsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsElementsPageTest extends BaseTest {
    public ElementsElementsPageTest() {
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        buttonsPage = new ButtonsPage();
    }

    @Test (priority = 10)
    public void verifyThatTextBoxButtonIsClickable() {
        homePage.clickOnElements();
        elementsElementsPage.clickOnTextBox();
        String expectedURL = excelReader.getData("URL", 1, 8);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.TextBoxButton));
    }

    @Test (priority = 20)
    public void verifyThatCheckBoxButtonIsClickable() {
        homePage.clickOnElements();
        elementsElementsPage.clickOnCheckBox();
        String expectedURL = excelReader.getData("URL", 1, 9);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.CheckBoxButton));
    }

    @Test (priority = 30)
    public void verifyThatRadioButtonButtonIsClickable() {
        homePage.clickOnElements();
        elementsElementsPage.clickOnRadioButton();
        String expectedURL = excelReader.getData("URL", 1, 10);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.RadioButtonButton));

    }

    @Test (priority = 40)
    public void verifyThatWebTablesButtonIsClickable() {
        homePage.clickOnElements();
        elementsElementsPage.clickOnWebTables();
        String expectedURL = excelReader.getData("URL", 1, 11);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.WebTablesButton));
    }

    @Test (priority = 50)
    public void verifyThatButtonsButtonIsClickable() {
        homePage.clickOnElements();
        elementsElementsPage.clickOnButtons();
        String expectedURL = excelReader.getData("URL", 1, 12);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.ButtonsButton));
    }

    @Test (priority = 60)
    public void verifyThatLinksButtonIsClickable() {
        homePage.clickOnElements();
        elementsElementsPage.clickOnLinks();
        String expectedURL = excelReader.getData("URL", 1, 13);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.LinksButton));

    }

    @Test (priority = 70)
    public void verifyThatBrokenLinksImagesButtonIsClickable() {
        homePage.clickOnElements();
        elementsElementsPage.clickOnBrokenLinksImages();
        String expectedURL = excelReader.getData("URL", 1, 14);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.BrokenLinksImagesButton));

    }
    @Test (priority = 80)
    public void verifyThatUploadAndDownloadButtonIsClickable() {
        homePage.clickOnElements();
        scrollToElement(elementsElementsPage.UploadAndDownloadButton);
        elementsElementsPage.clickOnUploadAndDownload();
        String expectedURL = excelReader.getData("URL", 1, 15);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.UploadAndDownloadButton));
    }


    @Test (priority = 90)
    public void verifyThatDynamicPropertiesIsClickable() throws InterruptedException {
        homePage.clickOnElements();
        scrollToElement(elementsElementsPage.DynamicPropertiesButton);
        elementsElementsPage.clickOnDynamicProperties();
        String expectedURL = excelReader.getData("URL", 1, 16);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(elementsElementsPage.DynamicPropertiesButton));

    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}