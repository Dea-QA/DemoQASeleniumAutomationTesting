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

public class ButtonsTest extends BaseTest {
    public ButtonsTest(){PageFactory.initElements(driver, this);}


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

    public void goToButtonsPage() {

        homePage.clickOnElements();
        elementsElementsPage.clickOnButtons();

        String expectedURL = excelReader.getData("URL", 1, 12);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }


    @Test(priority = 10)
    public void userCanMakeDoubleClick() {
        goToButtonsPage();
        buttonsPage.doubleClickOnDoubleClickButton();
        Assert.assertTrue(isDisplayed(buttonsPage.DoubleClickNotification));
    }

    @Test(priority = 20)
    public void userCanMakeLeftClick() {
        goToButtonsPage();
        buttonsPage.clickOnClickMeButton();
        Assert.assertTrue(isDisplayed(buttonsPage.ClickMeNotification));
    }

    @Test(priority = 30)
    public void userCanMakeRightClick() {
        goToButtonsPage();
        buttonsPage.rightClickOnRightclickButton();
        //waitForVisibility(buttonsPage2.RightClickNotification);
        Assert.assertTrue(isDisplayed(buttonsPage.RightClickNotification));
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
