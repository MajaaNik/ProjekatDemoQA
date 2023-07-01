package Tests;

import Base.BaseTest;
import Pages.Homepage;
import Pages.LinksPage;
import Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LinksTest extends BaseTest {

    public Homepage homepage;
    public SidebarPage sidebarPage;
    public LinksPage linksPage;

    @BeforeMethod
    public void pageSetUp() {
        homepage = new Homepage();
        sidebarPage = new SidebarPage();
        linksPage = new LinksPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
        homepage.clickOnElements();
        sidebarPage.clickOnButton("Links");
    }

    @Test
    public void verifyThatHomeButtonRedirectsToTheCorrectPageinNewTab() {
        linksPage.clickOnHomeButton();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        Assert.assertTrue(homepage.cards.get(0).isDisplayed());
        Assert.assertTrue(homepage.cards.get(1).isDisplayed());
        driver.switchTo().window(tab.get(0));
    }

    @Test
    public void verifyThatLinkButtonRedirectsToTheCorrectPageInNewTab() {
        linksPage.clickOnHomeruButton();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        Assert.assertTrue(homepage.cards.get(0).isDisplayed());
        Assert.assertTrue(homepage.cards.get(1).isDisplayed());
    }

    @Test
    public void clickOnCreated() {
        linksPage.clickOnCreatedButton();
        waitForVisibility(linksPage.createdMessage);
        Assert.assertTrue(linksPage.createdMessage.isDisplayed());
        Assert.assertEquals(linksPage.createdMessage.getText(), "Link has responded with staus 201 and status text Created");
    }

    @Test
    public void clickOnContent() {
        waitForVisibility(linksPage.noContentButton);
        linksPage.clickOnNoContentButton();
        waitForVisibility(linksPage.contentMessage);
        Assert.assertTrue(linksPage.contentMessage.isDisplayed());
        Assert.assertEquals(linksPage.contentMessage.getText(), "Link has responded with staus 204 and status text No Content");
    }

    @Test
    public void clickOnMoved() {
        linksPage.clickOnMovedButton();
        waitForVisibility(linksPage.movedMessage);
        Assert.assertTrue(linksPage.movedMessage.isDisplayed());
        Assert.assertEquals(linksPage.movedMessage.getText(), "Link has responded with staus 301 and status text Moved Permanently");
    }

    @Test
    public void clickOnBadRequestO() {
        linksPage.clickOnBadRequestButton();
        waitForVisibility(linksPage.badRequestmessage);
        Assert.assertTrue(linksPage.badRequestmessage.isDisplayed());
        Assert.assertEquals(linksPage.badRequestmessage.getText(), "Link has responded with staus 400 and status text Bad Request");
    }

    @Test
    public void clickOnUnauthorized() {
        linksPage.clickOnUnauthorizedButton();
        waitForVisibility(linksPage.unauthorizedmessage);
        Assert.assertTrue(linksPage.unauthorizedmessage.isDisplayed());
        Assert.assertEquals(linksPage.unauthorizedmessage.getText(), "Link has responded with staus 401 and status text Unauthorized");
    }

    @Test
    public void clickOnForbidden() {
        linksPage.clickOnForbiddenButton();
        waitForVisibility(linksPage.forbiddenMessage);
        Assert.assertTrue(linksPage.forbiddenMessage.isDisplayed());
        Assert.assertEquals(linksPage.forbiddenMessage.getText(), "Link has responded with staus 403 and status text Forbidden");

    }
    @Test
    public void clickOnNotFound(){
        linksPage.clickOnNotFoundButton();
        waitForVisibility(linksPage.notFoundmessage);
        Assert.assertTrue(linksPage.notFoundmessage.isDisplayed());
        Assert.assertEquals(linksPage.notFoundmessage.getText(),"Link has responded with staus 404 and status text Not Found");

    }
}

