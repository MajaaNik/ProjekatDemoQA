package Tests;

import Base.BaseTest;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SidebarPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public Homepage homepage;
    public SidebarPage sidebarPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeMethod
    public void pageSetUp() {
        homepage= new Homepage();
        sidebarPage=new SidebarPage();
        loginPage=new LoginPage();
        profilePage=new ProfilePage();
        driver.manage().window().maximize();
        driver.get(homeURL);

    }

    @Test(priority = 10)
    public void userCanLogInWithValidCredentials() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        homepage.clickOnBookStoreApplication();
        sidebarPage.clickOnButton("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(profilePage.usernameName);
        Assert.assertTrue(profilePage.usernameName.isDisplayed());
        Assert.assertEquals(profilePage.usernameName.getText(), validUsername);

    }
     @Test
    public void userCannotLoginWithInvalidUsername(){
         String invalidUsername = excelReader.getStringData("Login", 1, 2);
         String validPassword = excelReader.getStringData("Login", 1, 1);
         String expectedURL="https://demoqa.com/login";
         homepage.clickOnBookStoreApplication();
         sidebarPage.clickOnButton("Login");
         loginPage.insertUsername(invalidUsername);
         loginPage.insertPassword(validPassword);
         loginPage.clickOnLoginButton();
         Assert.assertEquals(expectedURL,"https://demoqa.com/login");

     }
     @Test
    public void userCannotLoginWithInvalidPassword(){
         String validUsername = excelReader.getStringData("Login", 1, 0);
         String validPassword = excelReader.getStringData("Login", 1, 3);
         String expectedURL="https://demoqa.com/login";
         homepage.clickOnBookStoreApplication();
         sidebarPage.clickOnButton("Login");
         loginPage.insertUsername(validUsername);
         loginPage.insertPassword(validPassword);
         loginPage.clickOnLoginButton();
         Assert.assertEquals(expectedURL,"https://demoqa.com/login");
     }




}
