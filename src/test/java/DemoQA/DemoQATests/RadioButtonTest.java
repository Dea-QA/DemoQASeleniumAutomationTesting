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

public class RadioButtonTest extends BaseTest {
    public RadioButtonTest() {PageFactory.initElements(driver, this);}

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        radioButtonPage = new RadioButtonPage();
    }

    public void goToRadioButtonPage() {

        homePage.clickOnElements();
        elementsElementsPage.clickOnRadioButton();

        String expectedURL = excelReader.getData("URL", 1, 10);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 10)
    public void userCanSelectYesRadioButton(){
        goToRadioButtonPage();
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertTrue(isDisplayed(radioButtonPage.ButtonIsSelectedNotification));

    }

    @Test (priority = 20)
    public void userCanSelectRadioButtonImpressive(){
        goToRadioButtonPage();
        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(isDisplayed(radioButtonPage.ButtonIsSelectedNotification));

    }

    @Test (priority = 30)
    public void userCannotSelectNoRadioButton(){
        goToRadioButtonPage();
        radioButtonPage.clickOnNoRadioButton();
        Assert.assertFalse(isDisplayed(radioButtonPage.ButtonIsSelectedNotification));

    }

    @Test(priority = 40)
    public void userCannotUnselectYesRadioButton(){
        goToRadioButtonPage();
        radioButtonPage.clickOnYesRadioButton();
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertTrue(isDisplayed(radioButtonPage.ButtonIsSelectedNotification));

    }

    @Test(priority = 50)
    public void userCannotUnselectImpressiveRadioButton(){
        goToRadioButtonPage();
        radioButtonPage.clickOnImpressiveRadioButton();
        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(isDisplayed(radioButtonPage.ButtonIsSelectedNotification));

    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }



}