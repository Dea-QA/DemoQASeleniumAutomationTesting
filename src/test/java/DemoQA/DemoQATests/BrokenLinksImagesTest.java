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

public class BrokenLinksImagesTest extends BaseTest {
    public BrokenLinksImagesTest(){ PageFactory.initElements(driver, this);}

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();
    }

    public void goToBrokenLinksImagesPage() {

        homePage.clickOnElements();
        elementsElementsPage.clickOnBrokenLinksImages();

        String expectedURL = excelReader.getData("URL", 1, 14);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test(priority = 10)
    public void verifyThatClickOnValidLinkOpensToolsQAPage(){
        goToBrokenLinksImagesPage();
        brokenLinksImagesPage.clickOnValidLink();
        String expectedURL = excelReader.getData("BrokenLinksImages", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(brokenLinksImagesPage.ToolsQAImage));
    }

    @Test(priority = 20)
    public void verifyThatClickOnBrokenLinkOpensPageWith500StatusCode(){
        goToBrokenLinksImagesPage();
        brokenLinksImagesPage.clickOnBrokenLink();
        String expectedURL = excelReader.getData("BrokenLinksImages", 1, 3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(isDisplayed(brokenLinksImagesPage.BrokenLinkPageText));
    }
    @Test(priority = 30)
    public void ValidImage(){
        goToBrokenLinksImagesPage();
        Assert.assertTrue(isDisplayed(brokenLinksImagesPage.ToolsQAImage));
        String expectedURL = excelReader.getData("BrokenLinksImages", 1, 0);
        Assert.assertEquals(brokenLinksImagesPage.getUrLFromImageSrcToolsQAImage(), expectedURL);

    }

    @Test(priority = 40)
    public void BrokenImage(){
        goToBrokenLinksImagesPage();
        waitForClickability(brokenLinksImagesPage.BrokenImageIcon);
        Assert.assertTrue(isDisplayed(brokenLinksImagesPage.BrokenImageIcon));
        String expectedURL = excelReader.getData("BrokenLinksImages", 1, 1);
        Assert.assertEquals(brokenLinksImagesPage.getUrlFromImageSrcBrokenImage(), expectedURL);

    }


    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
