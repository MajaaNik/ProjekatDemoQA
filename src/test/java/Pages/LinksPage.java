package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseTest {

    public LinksPage(){
            PageFactory.initElements(driver, this);
    }

    @FindBy(id="simpleLink")
    public WebElement homeButton;

    @FindBy(id="dynamicLink")
    public WebElement homeruButton;

    @FindBy(id="created")
    public WebElement createdButton;

    @FindBy(id="no-content")
    public WebElement noContentButton;

    @FindBy(id="moved")
    public WebElement movedButton;

    @FindBy(id="bad-request")
    public WebElement badRequestButton;

    @FindBy(id="unauthorized")
    public WebElement unauthorized;

    @FindBy(id="forbidden")
    public WebElement forbidden;

    @FindBy(id="invalid-url")
    public WebElement notFound;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[10]")
    public WebElement createdMessage;

    @FindBy(xpath ="/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[10]")
    public WebElement contentMessage;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[10]")
    public WebElement movedMessage;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[10]")
    public WebElement badRequestmessage;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[10]")
    public WebElement unauthorizedmessage;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[10]")
    public WebElement forbiddenMessage;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[10]")
    public WebElement notFoundmessage;

    public void clickOnHomeButton(){
        homeButton.click();
    }
    public void clickOnHomeruButton(){
        homeruButton.click();
    }
    public void clickOnCreatedButton(){
        createdButton.click();
    }
    public void clickOnNoContentButton(){
        noContentButton.click();
    }
    public void clickOnMovedButton(){
        movedButton.click();
    }
    public void clickOnBadRequestButton(){
        badRequestButton.click();
    }
    public void clickOnUnauthorizedButton(){
        unauthorized.click();
    }
    public void clickOnForbiddenButton(){
        forbidden.click();
    }
    public void clickOnNotFoundButton(){
        notFound.click();
    }
}
