package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {
    public RadioButtonPage(){PageFactory.initElements(driver,this);}

    @FindBy(css = ".custom-control-label.disabled")
    public WebElement NoRadioButton;

    @FindBy(className = "mt-3")
    public WebElement ButtonIsSelectedNotification;

    @FindBy(css = ".custom-control.custom-radio.custom-control-inline")
    public List<WebElement> getRadioButtons;

    //----------------------------------

    public void clickOnYesRadioButton() {
        for (int i = 0; i < getRadioButtons.size(); i++) {
            if (getRadioButtons.get(i).getText().equals("Yes")) {
                getRadioButtons.get(i).click();
                break;
            }
        }
    }

    public void clickOnImpressiveRadioButton() {
        for (int i = 0; i < getRadioButtons.size(); i++) {
            if (getRadioButtons.get(i).getText().equals("Impressive")) {
                getRadioButtons.get(i).click();
                break;
            }
        }
    }

    public void clickOnNoRadioButton() {
        for (int i = 0; i < getRadioButtons.size(); i++) {
            if (getRadioButtons.get(i).getText().equals("No")) {
                getRadioButtons.get(i).click();
                break;
            }
        }
    }




}
