package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTrainingPage extends BaseTest {

    public SeleniumTrainingPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-primary-shadow.btn-block")
    public WebElement GoToRegistrationButton;




}

