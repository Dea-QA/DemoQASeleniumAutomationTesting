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

public class UploadAndDownloadTest extends BaseTest {
    public UploadAndDownloadTest (){PageFactory.initElements(driver, this);}


    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
    }

    public void goToUploadAndDownloadPage() {

        homePage.clickOnElements();
        scrollToElement(elementsElementsPage.UploadAndDownloadButton);
        elementsElementsPage.clickOnUploadAndDownload();
        String expectedURL = excelReader.getData("URL", 1, 15);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 10)
    public void userCanDownloadImage(){
        goToUploadAndDownloadPage();
        uploadAndDownloadPage.clickOnDownloadButton();
        String expectedAHrefPath = excelReader.getData("UploadAndDownload",1,0);
        Assert.assertEquals(uploadAndDownloadPage.getPathFromAHrefDownload(), expectedAHrefPath);

    }

    @Test(priority = 20)
    public void UploadImage(){
        goToUploadAndDownloadPage();
        uploadAndDownloadPage.uploadImage();
        //System.out.println(uploadAndDownloadPage.ChooseFileButton.getText());
        Assert.assertTrue(isDisplayed(uploadAndDownloadPage.UploadedFilePathInfo));

    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
