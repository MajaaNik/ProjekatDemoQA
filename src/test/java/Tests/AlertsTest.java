package Tests;

import Base.BaseTest;
import Pages.AlertsPage;
import Pages.Homepage;
import Pages.SidebarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    public Homepage homepage;
    public SidebarPage sidebarPage;
    public AlertsPage alertsPage;

    @BeforeMethod
    public void pageSetUp(){
        homepage=new Homepage();
        sidebarPage=new SidebarPage();
        alertsPage=new AlertsPage();
        FluentWait wait= new FluentWait<>(driver);
        driver.manage().window().maximize();
        driver.get(homeURL);
        homepage.clickOnAlerts();
        sidebarPage.clickOnButton("Alerts");
    }
    @Test
    public void verifyThatAlertButtonOpensAlert(){
        alertsPage.clickOnAlertButton();
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(),"You clicked a button");
        driver.switchTo().alert().accept();

    }
    @Test
    public void verifyThatTimerAlertButtonOpensAlert(){
        alertsPage.clickOnTimerAlertButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(),"This alert appeared after 5 seconds");
        driver.switchTo().alert().accept();
    }
    @Test
    public void verifyThatConfirmAlertOpensAlertAndShowsOkMessage(){
        alertsPage.clickOnConfirmButton();
        driver.switchTo().alert().accept();
        Assert.assertTrue(alertsPage.confirmMessage.isDisplayed());
        Assert.assertEquals(alertsPage.confirmMessage.getText(),"You selected Ok");
    }
    @Test
    public void verifyThatConfirmAlertOpensAlertAndShowsCancelMessage(){
        alertsPage.clickOnConfirmButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(alertsPage.confirmMessage.isDisplayed());
        Assert.assertEquals(alertsPage.confirmMessage.getText(),"You selected Cancel");
    }


    @Test
    public void verifyThatPromtAlertOpensPromt(){
        alertsPage.clickOnPromtButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(),"Please enter your name");
        driver.switchTo().alert().accept();
    }






}
