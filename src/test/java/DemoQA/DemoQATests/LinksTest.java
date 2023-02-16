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

public class LinksTest extends BaseTest {
    public LinksTest () { PageFactory.initElements(driver, this);}

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        linksPage = new LinksPage();
    }

    public void goToLinksPage() {

        homePage.clickOnElements();
        elementsElementsPage.clickOnLinks();

        String expectedURL = excelReader.getData("URL", 1, 13);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 10)
    public void verifyThatClickOnHomeLinkOpensNewTab (){
        goToLinksPage();
        linksPage.clickOnHomeLink();
        linksPage.newTab();
        Assert.assertFalse(isDisplayed(linksPage.HomeLink));
        Assert.assertTrue(isDisplayed(homePage.SeleniumTrainingSection));
    }

    @Test(priority = 20)
    public void verifyThatClickOnDynamicLinkOpensNewTab (){
        goToLinksPage();
        linksPage.clickOnDynamicLink();
        linksPage.newTab();
        Assert.assertFalse(isDisplayed(linksPage.HomeLink));
        Assert.assertTrue(isDisplayed(homePage.SeleniumTrainingSection));
    }

    @Test(priority = 30)
    public void verifyThatClickOnCreatedLinkSendsApiCall (){
        goToLinksPage();
        linksPage.clickOnCreatedLink();
        waitForClickability(linksPage.LinkResponseNotification);
        Assert.assertTrue(isDisplayed(linksPage.LinkResponseNotification));
    }

    @Test(priority = 40)
    public void verifyThatClickOnNoContentLinkSendsApiCall (){
        goToLinksPage();
        linksPage.clickOnNoContentLink();
        waitForClickability(linksPage.LinkResponseNotification);
        Assert.assertTrue(isDisplayed(linksPage.LinkResponseNotification));
    }

    @Test(priority = 50)
    public void verifyThatClickOnMovedLinkSendsApiCall (){
        goToLinksPage();
        linksPage.clickOnMovedLink();
        waitForClickability(linksPage.LinkResponseNotification);
        Assert.assertTrue(isDisplayed(linksPage.LinkResponseNotification));
    }


    @Test(priority = 60)
    public void verifyThatClickOnBadRequestLinkSendsApiCall (){
        goToLinksPage();
        linksPage.clickOnBadRequestLink();
        waitForClickability(linksPage.LinkResponseNotification);
        Assert.assertTrue(isDisplayed(linksPage.LinkResponseNotification));
    }

    @Test(priority = 70)
    public void verifyThatClickOnUnauthorizedLinkSendsApiCall (){
        goToLinksPage();
        linksPage.clickOnUnauthorizedLink();
        waitForClickability(linksPage.LinkResponseNotification);
        Assert.assertTrue(isDisplayed(linksPage.LinkResponseNotification));
    }

    @Test(priority = 80)
    public void verifyThatClickOnForbiddenLinkSendsApiCall (){
        goToLinksPage();
        linksPage.clickOnForbiddenLink();
        waitForClickability(linksPage.LinkResponseNotification);
        Assert.assertTrue(isDisplayed(linksPage.LinkResponseNotification));
    }

    @Test(priority = 90)
    public void verifyThatClickOnNotFoundLinkSendsApiCall (){
        goToLinksPage();
        linksPage.clickOnNotFoundLink();
        waitForClickability(linksPage.LinkResponseNotification);
        Assert.assertTrue(isDisplayed(linksPage.LinkResponseNotification));
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
