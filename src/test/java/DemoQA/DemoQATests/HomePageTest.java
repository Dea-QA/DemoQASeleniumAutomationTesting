package DemoQA.DemoQATests;

import DemoQA.DemoQABase.BaseTest;
import DemoQA.DemoQAPages.HomePage;
import DemoQA.DemoQAPages.SeleniumTrainingPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends BaseTest {
    public HomePageTest() { PageFactory.initElements(driver, this); }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        seleniumTrainingPage = new SeleniumTrainingPage();
    }

    @Test (priority = 10)
    public void verifyThatClickOnElementsOpensElementsPage() {
        homePage.clickOnElements();
        String expectedURL = excelReader.getData("URL", 1, 1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 20)
    public void verifyThatClickOnFormsOpensFormsPage() {
        homePage.clickOnForms();
        String expectedURL = excelReader.getData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 30)
    public void verifyThatClickOnAlertsOpensAlertsPage() {
        homePage.clickOnAlerts();
        String expectedURL = excelReader.getData("URL", 1, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 40)
    public void verifyThatClickOnWidgetsOpensWidgetsPage() {
        homePage.clickOnWidgets();
        String expectedURL = excelReader.getData("URL", 1, 4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 50)
    public void verifyThatClickOnInteractionsOpensInteractionsPage() {
        homePage.clickOnInteractions();
        String expectedURL = excelReader.getData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 60)
    public void verifyThatClickOnBookstoreOpensBookstorePage() throws InterruptedException {
        scrollToElement(homePage.BookstoreButton);
        homePage.clickOnBookstore();
        Thread.sleep(4000);
        String expectedURL = excelReader.getData("URL", 1, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 70)
    public void verifyThatClickOnSeleniumSectionOpensSeleniumTrainingPage() {
        homePage.clickOnSeleniumSection();
        seleniumTrainingPage.newTab();
        waitForVisibility(seleniumTrainingPage.GoToRegistrationButton);
        String expectedURL = excelReader.getData("URL", 1, 7);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(seleniumTrainingPage.GoToRegistrationButton));
    }


    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
