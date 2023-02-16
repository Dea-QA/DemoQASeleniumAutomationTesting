package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage extends BaseTest {

    public DynamicPropertiesPage (){PageFactory.initElements(driver,this);}


    @FindBy (id = "colorChange")
    public WebElement ColorChangeButton;

    @FindBy (id = "visibleAfter")
    public WebElement VisibleAfter5SecButton;

    @FindBy(css = ".mt-4.text-danger.btn.btn-primary")
    public WebElement ColorChangeButtonAfterColorChange;

}

