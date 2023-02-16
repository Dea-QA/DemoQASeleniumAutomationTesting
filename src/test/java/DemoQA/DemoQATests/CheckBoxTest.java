package DemoQA.DemoQATests;

import DemoQA.DemoQABase.BaseTest;
import DemoQA.DemoQAPages.CheckBoxPage;
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

public class CheckBoxTest extends BaseTest {
    public CheckBoxTest(){PageFactory.initElements(driver,this);}

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomePageURL);
        homePage = new HomePage();
        elementsElementsPage = new ElementsElementsPage();
        checkBoxPage = new CheckBoxPage();
    }

    public void goToCheckBoxPage() {

        homePage.clickOnElements();
        elementsElementsPage.clickOnCheckBox();

        String expectedURL = excelReader.getData("URL", 1, 9);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 10)
    public void verifyThatPlusIconIsClickable(){
        goToCheckBoxPage();
        checkBoxPage.clickOnPlusIcon();
        Assert.assertTrue(isDisplayed(checkBoxPage.CheckBox));
        Assert.assertTrue(isDisplayed(checkBoxPage.CollapseArrow));

    }

    @Test(priority = 20)
    public void verifyThatMinusIsClickable(){
        goToCheckBoxPage();
        checkBoxPage.clickOnPlusIcon();
        checkBoxPage.clickOnMinusIcon();
        Assert.assertTrue(isDisplayed(checkBoxPage.HomeExpandArrow));
        Assert.assertFalse(isDisplayed(checkBoxPage.CollapseArrow));

    }

    @Test(priority = 30)
    public void userCanCheckHomeFolderIcon(){
        goToCheckBoxPage();
        checkBoxPage.clickOnCheckBox();
        Assert.assertTrue(isDisplayed(checkBoxPage.SelectionTextResults));
    }

    @Test(priority = 40)
    public void userCanUncheckHomeFolderIcon(){
        goToCheckBoxPage();
        checkBoxPage.clickOnCheckBox();
        checkBoxPage.clickOnUncheckBox();
        Assert.assertFalse(isDisplayed(checkBoxPage.SelectionTextResults));

    }

    @Test(priority = 50)
    public void userCanExpandHomeFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        Assert.assertTrue(isDisplayed(checkBoxPage.DesktopFolderIcon));

    }

    @Test(priority = 60)
    public void userCanCheckAndExpandHomeFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnHomeFolder();
        Assert.assertTrue(isDisplayed(checkBoxPage.SelectionTextResults));
        String expectedTextResult = excelReader.getData("CheckBoxSelectionTextResults", 1,0);
        Assert.assertEquals(checkBoxPage.SelectionTextResults.getText(), expectedTextResult);

    }

    @Test(priority = 70)
    public void userCanUncheckAndCollapseHomeFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnHomeFolder();
        checkBoxPage.clickOnHomeFolder();
        Assert.assertFalse(isDisplayed(checkBoxPage.SelectionTextResults));

    }

    @Test(priority = 80)
    public void userCanCheckDesktopFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDesktopFolder();
        Assert.assertTrue(isDisplayed(checkBoxPage.SelectionTextResults));
        String expectedTextResult = excelReader.getData("CheckBoxSelectionTextResults", 1,1);
        Assert.assertEquals(checkBoxPage.SelectionTextResults.getText(), expectedTextResult);

    }

    @Test(priority = 90)
    public void userCanUncheckDesktopFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDesktopFolder();
        checkBoxPage.clickOnDesktopFolder();
        Assert.assertFalse(isDisplayed(checkBoxPage.SelectionTextResults));

    }

    @Test(priority = 100)
    public void userCanExpandDesktopFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDesktopFolderArrow();
        Assert.assertTrue(isDisplayed(checkBoxPage.DesktopFolderIcon));
        String expectedFileName = excelReader.getData("CheckBoxFoldersAndFilesNames", 2, 0);
        Assert.assertEquals(checkBoxPage.IconsTitles.get(2).getText(), expectedFileName);


    }

    @Test(priority = 110)
    public void userCanCheckDocumentsFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDocumentsFolder();
        Assert.assertTrue(isDisplayed(checkBoxPage.SelectionTextResults));
        String expectedTextResult = excelReader.getData("CheckBoxSelectionTextResults", 1,2);
        Assert.assertEquals(checkBoxPage.SelectionTextResults.getText(), expectedTextResult);

    }

    @Test(priority = 120)
    public void userCanUncheckDocumentsFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDocumentsFolder();
        checkBoxPage.clickOnDocumentsFolder();
        Assert.assertFalse(isDisplayed(checkBoxPage.SelectionTextResults));

    }

    @Test(priority = 130)
    public void userCanExpandDocumentsFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDocumentsFolderArrow();
        Assert.assertTrue(isDisplayed(checkBoxPage.IconsBoxes.get(4)));
        Assert.assertTrue(isDisplayed(checkBoxPage.IconsBoxes.get(5)));

    }

    @Test(priority = 140)
    public void userCanExpandWorkSpaceFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDocumentsFolderArrow();
        checkBoxPage.clickOnWorkSpaceArrow();
        String expectedFileName = excelReader.getData("CheckBoxFoldersAndFilesNames", 7, 0);
        Assert.assertEquals(checkBoxPage.IconsTitles.get(5).getText(), expectedFileName);
    }

    @Test(priority = 150)
    public void userCanExpandOfficeFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDocumentsFolderArrow();
        checkBoxPage.clickOnOfficeArrow();
        String expectedFileName = excelReader.getData("CheckBoxFoldersAndFilesNames", 13, 0);
        Assert.assertEquals(checkBoxPage.IconsTitles.get(8).getText(), expectedFileName);

    }

    @Test(priority = 160)
    public void userCanExpandDownloadsFolder() {
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDownloadsArrow();
        Assert.assertTrue(isDisplayed(checkBoxPage.IconsBoxes.get(4)));
        Assert.assertTrue(isDisplayed(checkBoxPage.IconsBoxes.get(5)));

    }

    @Test(priority = 170)
    public void userCanCheckDownloadsFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDownloadsFolder();
        Assert.assertTrue(isDisplayed(checkBoxPage.SelectionTextResults));
        String expectedTextResult = excelReader.getData("CheckBoxSelectionTextResults", 1,3);
        Assert.assertEquals(checkBoxPage.SelectionTextResults.getText(), expectedTextResult);
    }

    @Test(priority = 180)
    public void userCanUncheckDownloadsFolder(){
        goToCheckBoxPage();
        checkBoxPage.clickOnHomeExpandArrow();
        checkBoxPage.clickOnDownloadsFolder();
        checkBoxPage.clickOnDownloadsFolder();
        Assert.assertFalse(isDisplayed(checkBoxPage.SelectionTextResults));

    }

    //...

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}