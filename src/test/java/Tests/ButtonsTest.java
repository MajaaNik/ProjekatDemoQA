package Tests;

import Base.BaseTest;
import Pages.ButtonsPage;
import Pages.Homepage;
import Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

  public Homepage homepage;
  public SidebarPage sidebarPage;
  public ButtonsPage buttonsPage;

  @BeforeMethod
  public void pageSetUp(){
      homepage=new Homepage();
      sidebarPage=new SidebarPage();
       buttonsPage=new ButtonsPage();
      driver.manage().window().maximize();
      driver.get(homeURL);
  }

  @Test
    public void userCanClickOnDoubleClik() {
    homepage.clickOnElements();
    sidebarPage.clickOnButton("Buttons");
    buttonsPage.doubleClickOnButton();
      Assert.assertTrue(buttonsPage.doubleClickMessage.isDisplayed());
      Assert.assertEquals(buttonsPage.doubleClickMessage.getText(),"You have done a double click");
  }

  @Test
    public void userCanClickOnRightClick(){
      homepage.clickOnElements();
      sidebarPage.clickOnButton("Buttons");
      buttonsPage.rightClickOnButton();
      Assert.assertTrue(buttonsPage.rightClickMessage.isDisplayed());
      Assert.assertEquals(buttonsPage.rightClickMessage.getText(),"You have done a right click");
  }

  @Test
  public void userCanClickOnClickMe(){
    homepage.clickOnElements();
    sidebarPage.clickOnButton("Buttons");
    buttonsPage.clickOnClickButton();
    Assert.assertTrue(buttonsPage.dynamicClickMessage.isDisplayed());
    Assert.assertEquals(buttonsPage.dynamicClickMessage.getText(),"You have done a dynamic click");

  }


}
