package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;

    public ExcelReader excelReader;

    public String homeURL;


    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader=new ExcelReader("src/test/java/TestData.xlsx");
        homeURL= excelReader.getStringData("URL", 1,0);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForURL(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) {
        boolean nonexistingElement = false;
        try {
            nonexistingElement = element.isDisplayed();
        } catch (Exception e) {
        }
        return nonexistingElement;
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }
    public boolean alertIsPresent(){
        try{
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e){
            return false;
        }
    }




}
