package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseTest {

    public LinksPage (){

        PageFactory.initElements(driver,this);

    }

    @FindBy (id = "simpleLink")
    public WebElement HomeLink;

    @FindBy (id = "dynamicLink")
    public WebElement DynamicLink;

    @FindBy (id = "created")
    public WebElement CreatedLink;

    @FindBy (id = "no-content")
    public WebElement NoContentLink;

    @FindBy (id = "moved")
    public WebElement MovedLink;

    @FindBy (id = "bad-request")
    public WebElement BadRequestLink;

    @FindBy (id = "unauthorized")
    public WebElement UnauthorizedLink;

    @FindBy (id = "forbidden")
    public WebElement ForbiddenLink;

    @FindBy (id = "invalid-url")
    public WebElement NotFoundLink;

    @FindBy (id = "linkResponse")
    public WebElement LinkResponseNotification;


    public void clickOnHomeLink (){
        HomeLink.click(); }
    public void clickOnDynamicLink (){
        DynamicLink.click(); }
    public void clickOnCreatedLink (){
        CreatedLink.click(); }
    public void clickOnNoContentLink (){
        NoContentLink.click(); }
    public void clickOnMovedLink (){
        MovedLink.click(); }
    public void clickOnBadRequestLink (){

        BadRequestLink.click();
    }
    public void clickOnUnauthorizedLink (){

        UnauthorizedLink.click();
    }
    public void clickOnForbiddenLink (){

        ForbiddenLink.click();
    }
    public void clickOnNotFoundLink (){

        NotFoundLink.click();
    }

}

