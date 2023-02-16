package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinksImagesPage extends BaseTest {

    public BrokenLinksImagesPage (){PageFactory.initElements(driver,this);}

    @FindBy (css = "img[src='/images/Toolsqa.jpg']")
    public WebElement ToolsQAImage;

    @FindBy (css ="img[src='/images/Toolsqa_1.jpg']" )
    public WebElement BrokenImageIcon;

    @FindBy (css ="a[href='http://demoqa.com']" )
    public WebElement ValidLink;

    @FindBy (css ="a[href='http://the-internet.herokuapp.com/status_codes/500']" )
    public WebElement BrokenLink;

    @FindBy(className = "example")
    public WebElement BrokenLinkPageText;

    //------------------------------


    public void clickOnValidLink (){

        ValidLink.click();
    }
    public void clickOnBrokenLink (){

        BrokenLink.click();
    }
    public String getUrLFromImageSrcToolsQAImage(){

        return ToolsQAImage.getAttribute("src");
    }
    public String getUrlFromImageSrcBrokenImage(){


        return BrokenImageIcon.getAttribute("src");
    }

}

