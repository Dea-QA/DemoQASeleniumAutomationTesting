package DemoQA.DemoQAPages;

import DemoQA.DemoQABase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownloadPage extends BaseTest {
    public UploadAndDownloadPage (){PageFactory.initElements(driver, this);}

    @FindBy(id = "downloadButton")
    public WebElement DownloadButton;

    @FindBy(id = "uploadFile")
    public WebElement ChooseFileButton;

    @FindBy(id = "uploadedFilePath")
    public WebElement UploadedFilePathInfo;


    //---------------------------------

    public void clickOnDownloadButton(){

        DownloadButton.click();
    }

    public String getPathFromAHrefDownload(){

        return DownloadButton.getAttribute("href");
    }

    public void uploadImage(){
        ChooseFileButton.sendKeys("/home/dea/IdeaProjects/DemoQA/src/test/java/DemoQA/sampleFile.jpeg");  //copy absolute path (necessary for upload)
    }

    public String getUploadedFilePathText(){

        return UploadedFilePathInfo.getText();
    }




}
