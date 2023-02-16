package DemoQA.DemoQABase;

import DemoQA.DemoQAPages.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class BaseTest {
    public static WebDriver driver;

    public WebDriverWait wdwait;

    public ExcelReader excelReader;

    public String HomePageURL;

    public HomePage homePage;
    public SeleniumTrainingPage seleniumTrainingPage;

    public ElementsElementsPage elementsElementsPage;
    public TextBoxPage textBoxPage;
    public WebTablesPage webTablesPage;
    public RadioButtonPage radioButtonPage;
    public CheckBoxPage checkBoxPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public DynamicPropertiesPage dynamicPropertiesPage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/DemoQA/TestData.xlsx");
        HomePageURL = excelReader.getData("URL", 1, 0);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForVisibility (WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));}
    public void waitForClickability (WebElement element){
            wdwait.until(ExpectedConditions.elementToBeClickable(element));}

    public void newTab () {
        ArrayList<String> tabsList  = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));}


    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
        }

    }

