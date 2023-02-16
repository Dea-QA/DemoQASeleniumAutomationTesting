package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage (){PageFactory.initElements(driver,this);}

    @FindBy(css = ".rct-collapse.rct-collapse-btn")
    public WebElement HomeExpandArrow;


    @FindBy(css = ".rct-icon.rct-icon-expand-close")
    public List<WebElement> ExpandArrows;

    @FindBy(css=".rct-icon.rct-icon-expand-open")
    public WebElement CollapseArrow;

    @FindBy(css = ".rct-icon.rct-icon-uncheck")
    public WebElement CheckBox;

    @FindBy(css = ".rct-icon.rct-icon-check")
    public WebElement UncheckBox;

    @FindBy (css = ".rct-icon.rct-icon-expand-all")
    public WebElement PlusIcon;

    @FindBy (css = ".rct-option.rct-option-collapse-all")
    public WebElement MinusIcon;

    @FindBy (css = ".rct-node.rct-node-parent.rct-node-collapsed")
    public WebElement DesktopFolderIcon;

    @FindBy (id = "result")
    public WebElement SelectionTextResults;

    @FindBy (className = "rct-title")
    public List <WebElement> IconsTitles;

    @FindBy(className = "tree-node-classified")
    public WebElement ClassifiedIcon;

    @FindBy(className = "rct-checkbox")
    public List<WebElement> IconsBoxes;

    //--------------------------------------

    public void clickOnDownloadsArrow(){
        ExpandArrows.get(2).click();
    }

    public void clickOnMinusIcon (){

        MinusIcon.click();
    }

    public void clickOnHomeExpandArrow (){
        HomeExpandArrow.click();

    }

    public void clickOnCheckBox () {
        CheckBox.click();
    }

    public void clickOnUncheckBox(){
        UncheckBox.click();
    }

    public void clickOnHomeFolder() {
        for (int i = 0; i < IconsTitles.size(); i++) {
            if (IconsTitles.get(i).getText().equals("Home")) {
                IconsTitles.get(i).click();
                break;
            }
        }
    }

    public void clickOnDesktopFolder() {
        for (int i = 0; i < IconsTitles.size(); i++) {
            if (IconsTitles.get(i).getText().equals("Desktop")) {
                IconsTitles.get(i).click();
                break;
            }
        }
    }

    public void clickOnDocumentsFolder() {
        for (int i = 0; i < IconsTitles.size(); i++) {
            if (IconsTitles.get(i).getText().equals("Documents")) {
                IconsTitles.get(i).click();
                break;
            }
        }
    }

    public void clickOnDownloadsFolder() {
        for (int i = 0; i < IconsTitles.size(); i++) {
            if (IconsTitles.get(i).getText().equals("Downloads")) {
                IconsTitles.get(i).click();
                break;
            }
        }
    }

    public void clickOnDesktopFolderArrow() {
        ExpandArrows.get(0).click();
    }

    public void clickOnDocumentsFolderArrow(){
        ExpandArrows.get(1).click();
    }

    public void clickOnWorkSpaceArrow(){
        ExpandArrows.get(1).click();
    }

    public void clickOnOfficeArrow(){
        ExpandArrows.get(2).click();
    }

    public void clickOnPlusIcon (){
        PlusIcon.click();

    }
}
