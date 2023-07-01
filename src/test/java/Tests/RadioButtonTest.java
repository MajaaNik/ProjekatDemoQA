package Tests;

import Base.BaseTest;
import Pages.Homepage;
import Pages.RadioButtonPage;
import Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    public Homepage homepage;
    public SidebarPage sidebarPage;
    public RadioButtonPage radioButtonPage;


    @BeforeMethod
    public void pageSetUp(){
        homepage=new Homepage();
        sidebarPage=new SidebarPage();
        radioButtonPage=new RadioButtonPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
        homepage.clickOnElements();
        sidebarPage.clickOnButton("Radio Button");
    }

    @Test
    public void clicOnYes(){
        homepage.clickOnElements();
        sidebarPage.clickOnButton("Radio Button");
        scrollIntoView(radioButtonPage.yesRadio);
        radioButtonPage.clickOnYesRadio();
        Assert.assertTrue(radioButtonPage.yesRadio.isSelected());
        Assert.assertEquals(radioButtonPage.message.getText(), "Yes");

    }
    @Test
    public void clickOnImpressive(){
        homepage.clickOnElements();
        sidebarPage.clickOnButton("Radio Button");
        scrollIntoView(radioButtonPage.impressiveRadio);
        radioButtonPage.clickOnImpressiveRadio();
        Assert.assertTrue(radioButtonPage.impressiveRadio.isSelected());
        Assert.assertEquals(radioButtonPage.message.getText(),"Impressive");
    }

    @Test
    public void clickOnNo(){
        homepage.clickOnElements();
        sidebarPage.clickOnButton("Radio Button");
        scrollIntoView(radioButtonPage.noRadio);
        radioButtonPage.clickOnNoRadio();
        Assert.assertFalse(radioButtonPage.noRadio.isSelected());
        Assert.assertFalse(radioButtonPage.elementIsPresent(radioButtonPage.message));
    }


}
