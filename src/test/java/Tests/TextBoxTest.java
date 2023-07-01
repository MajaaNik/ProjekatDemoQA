package Tests;

import Base.BaseTest;
import Pages.Homepage;
import Pages.SidebarPage;
import Pages.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    public Homepage homepage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;



       @BeforeMethod
     public void pageSetUp()  {
           homepage=new Homepage();
           sidebarPage=new SidebarPage();
           textBoxPage=new TextBoxPage();
           driver.manage().window().maximize();
           driver.get(homeURL);

       }

       @Test
    public void userCanSubmitWithValidCredentials(){
           String fullName= excelReader.getStringData("TextBox", 1, 0);
           String validEmail=excelReader.getStringData("TextBox", 1, 1);
           String currentAddress=excelReader.getStringData("TextBox",1,2);
           String permanentAddress=excelReader.getStringData("TextBox",1,3);
           String expectedText=excelReader.getStringData("TextBox",1,5);
           homepage.clickOnElements();
           sidebarPage.clickOnButton("Text Box");
           textBoxPage.insertFullName(fullName);
           textBoxPage.insertEmail(validEmail);
           textBoxPage.insertCurrentAddress(currentAddress);
           textBoxPage.insertPermanentAddress(permanentAddress);
           scrollIntoView(textBoxPage.submitButton);
           textBoxPage.clickOnSubmitButton();
           Assert.assertTrue(textBoxPage.submitButton.isDisplayed());
           Assert.assertTrue(textBoxPage.fullNameField.isDisplayed());
           Assert.assertTrue(textBoxPage.emailField.isDisplayed());
           Assert.assertTrue(textBoxPage.currentAddressField.isDisplayed());
           Assert.assertTrue(textBoxPage.permanentAddressField.isDisplayed());
           Assert.assertTrue(textBoxPage.text.isDisplayed());
           Assert.assertEquals(textBoxPage.text.getText(),expectedText);


       }
       @Test
       public void userCannotSubmitWithInvalidEmail(){
           String fullName=excelReader.getStringData("TextBox", 1,0);
           String invalidEmail=excelReader.getStringData("TextBox",1,4);
           String currentAddress=excelReader.getStringData("TextBox",1,2);
           String permanentAddress=excelReader.getStringData("TextBox",1,3);
           homepage.clickOnElements();
           sidebarPage.clickOnButton("Text Box");
           textBoxPage.insertFullName(fullName);
           textBoxPage.insertEmail(invalidEmail);
           textBoxPage.insertCurrentAddress(currentAddress);
           textBoxPage.insertPermanentAddress(permanentAddress);
           scrollIntoView(textBoxPage.submitButton);
           textBoxPage.clickOnSubmitButton();

       }

}
