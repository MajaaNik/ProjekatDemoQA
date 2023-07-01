package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {
    public TextBoxPage() {
    PageFactory.initElements(driver, this);
}
    @FindBy(css=".mr-sm-2.form-control")
    public WebElement fullNameField;

    @FindBy(id="userEmail")
    public WebElement emailField;

    @FindBy(id="currentAddress")
    public WebElement currentAddressField;

    @FindBy(id="permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(id="submit")
    public  WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"output\"]/div")
    public WebElement text;


    public void insertFullName(String fullName){
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void insertEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void insertCurrentAddress(String currentAddress){
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }

    public void insertPermanentAddress(String permanentAddress){
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

}
