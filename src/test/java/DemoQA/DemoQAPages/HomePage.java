package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    List<WebElement> cards;

    public HomePage() {PageFactory.initElements(driver, this);}


    @FindBy(className = "banner-image")
    public WebElement SeleniumTrainingSection;

    @FindBy(css = ".avatar.mx-auto.white")
    public WebElement BookstoreButton;


    @FindBy(className = "card-body")
    public List<WebElement> getCards;     //list of web elements with the classname "card-body" (Elements, Forms, Widgets, etc.)

    //----------------------------------

    public void clickOnElements() {
        for (int i = 0; i < getCards.size(); i++) {
            if (getCards.get(i).getText().equals("Elements")) {
                getCards.get(i).click();
                break;
            }
        }
    }
    public void clickOnForms() {
        for (int i = 0; i < getCards.size(); i++) {
            if (getCards.get(i).getText().equals("Forms")) {
                getCards.get(i).click();
                break;
            }
        }
    }

    public void clickOnAlerts() {
        for (int i = 0; i < getCards.size(); i++) {
            if (getCards.get(i).getText().equals("Alerts, Frame & Windows")) {
                getCards.get(i).click();
                break;
            }
        }
    }

    public void clickOnWidgets() {
        for (int i = 0; i < getCards.size(); i++) {
            if (getCards.get(i).getText().equals("Widgets")) {
                getCards.get(i).click();
                break;
            }
        }
    }

    public void clickOnInteractions() {
        for (int i = 0; i < getCards.size(); i++) {
            if (getCards.get(i).getText().equals("Interactions")) {
                getCards.get(i).click();
                break;
            }
        }
    }

    public void clickOnBookstore() {
        for (int i = 0; i < getCards.size(); i++) {
            if (getCards.get(i).getText().equals("Book Store Application")) {

                getCards.get(i).click();
                break;
            }
        }
    }


    public void clickOnSeleniumSection(){ SeleniumTrainingSection.click(); }


}
