package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage extends BaseTest {

    public Homepage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".card.mt-4.top-card")
    public List<WebElement> cards;


    public void clickOnBookStoreApplication() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Book Store Application")) {
                scrollIntoView(cards.get(i));
                cards.get(i).click();
                break;
            }
        }
    }
    public void clickOnElements(){
        for(int i=0; i< cards.size(); i++){
            if(cards.get(i).getText().equals("Elements")){
                scrollIntoView(cards.get(i));
                cards.get(i).click();
                break;
            }
        }
    }
    public void clickOnAlerts(){
        for(int i=0; i< cards.size(); i++){
            if(cards.get(i).getText().equals("Alerts, Frame & Windows")){
                scrollIntoView(cards.get(i));
                cards.get(i).click();
                break;
            }
        }
    }
}
