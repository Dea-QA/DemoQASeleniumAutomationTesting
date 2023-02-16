package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ButtonsPage extends BaseTest {

    public ButtonsPage(){PageFactory.initElements(driver,this);}

    Actions action = new Actions(driver);

    @FindBy (id = "doubleClickBtn")
    public WebElement DoubleClickButton;

    @FindBy (id = "rightClickBtn")
    public WebElement RightClickButton;

    @FindBy (id = "doubleClickMessage")
    public WebElement DoubleClickNotification;

    @FindBy (id = "rightClickMessage")
    public WebElement RightClickNotification;

    @FindBy (id = "dynamicClickMessage")
    public WebElement ClickMeNotification;

    @FindBy (css = ".btn.btn-primary")
    public List<WebElement> buttons;

    //--------------------------------------
    public void doubleClickOnDoubleClickButton (){
        action.doubleClick(DoubleClickButton).perform();}
    public void rightClickOnRightclickButton(){
        action.contextClick(RightClickButton).perform();}
    public void clickOnClickMeButton (){
        buttons.get(2).click();}
}

