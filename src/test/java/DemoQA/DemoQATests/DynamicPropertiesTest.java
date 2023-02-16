package DemoQA.DemoQATests;

import DemoQA.DemoQABase.BaseTest;
import DemoQA.DemoQAPages.DynamicPropertiesPage;
import DemoQA.DemoQAPages.ElementsElementsPage;
import DemoQA.DemoQAPages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicPropertiesTest extends BaseTest {
    public DynamicPropertiesTest(){PageFactory.initElements(driver, this);}

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
    }

    public void goToDynamicPropertiesPage() {

        homePage.clickOnElements();
        scrollToElement(elementsElementsPage.DynamicPropertiesButton);
        elementsElementsPage.clickOnDynamicProperties();

        String expectedURL = excelReader.getData("URL", 1, 16);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test(priority = 10)
    public void verifyThatVisibleAfter5SecondsButtonAppearsAfter5Seconds() throws InterruptedException {
        goToDynamicPropertiesPage();
        Thread.sleep(5000);
        Assert.assertTrue(isDisplayed(dynamicPropertiesPage.VisibleAfter5SecButton));
    }

    @Test(priority = 20)
    public void verifyThatVisibleAfter5SecondsButtonDoesNotAppearInLessThan5Seconds() throws InterruptedException {
        goToDynamicPropertiesPage();
        Thread.sleep(4000);
        Assert.assertFalse(isDisplayed(dynamicPropertiesPage.VisibleAfter5SecButton));
    }

    @Test(priority = 30)
    public void verifyThatColorChangeButtonChangesColorAfter5Seconds() throws InterruptedException {
        goToDynamicPropertiesPage();
        Thread.sleep(5000);
        Assert.assertTrue(isDisplayed(dynamicPropertiesPage.ColorChangeButtonAfterColorChange));
    }

    @Test(priority = 40)
    public void verifyThatColorChangeButtonDoesNotChangeColorInLessThan5Seconds() throws InterruptedException {
        goToDynamicPropertiesPage();
        Thread.sleep(4000);
        Assert.assertTrue(isDisplayed(dynamicPropertiesPage.ColorChangeButton));
        Assert.assertFalse(isDisplayed(dynamicPropertiesPage.ColorChangeButtonAfterColorChange));
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
