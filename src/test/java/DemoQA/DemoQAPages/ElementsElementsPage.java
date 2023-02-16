package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsElementsPage extends BaseTest {

    List<WebElement> elementsElements;

    public ElementsElementsPage() { PageFactory.initElements(driver, this);
    }

    @FindBy(id = "item-0")
    public WebElement TextBoxButton;


    @FindBy(id = "item-1")
    public WebElement CheckBoxButton;

    @FindBy(id = "item-2")
    public WebElement RadioButtonButton;
    @FindBy(id = "item-3")
    public WebElement WebTablesButton;
    @FindBy(id = "item-4")
    public WebElement ButtonsButton;
    @FindBy(id = "item-5")
    public WebElement LinksButton;
    @FindBy(id = "item-6")
    public WebElement BrokenLinksImagesButton;

    @FindBy(id = "item-7")
    public WebElement UploadAndDownloadButton;
    @FindBy(id = "item-8")
    public WebElement DynamicPropertiesButton;

    @FindBy (className = "text")
    public List<WebElement> getElementsElements;   //list of web elements with the classname "text" (Text Box, Check Box, etc.)


    //----------------------------------

    public void clickOnTextBox() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Text Box")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }
    public void clickOnCheckBox() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Check Box")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }

    public void clickOnRadioButton() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Radio Button")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }

    public void clickOnWebTables() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Web Tables")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }

    public void clickOnButtons() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Buttons")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }

    public void clickOnLinks() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Links")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }

    public void clickOnBrokenLinksImages() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Broken Links - Images")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }

    public void clickOnUploadAndDownload() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Upload and Download")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }

    public void clickOnDynamicProperties() {
        for (int i = 0; i < getElementsElements.size(); i++) {
            if (getElementsElements.get(i).getText().equals("Dynamic Properties")) {
                getElementsElements.get(i).click();
                break;
            }
        }
    }



}
