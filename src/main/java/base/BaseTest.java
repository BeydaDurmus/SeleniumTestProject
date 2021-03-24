package base;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.BeforeClass;
import java.util.concurrent.TimeUnit;

import static base.Constants.BASE_URL;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void setup(){
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");

        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        openBrowser();

    }
    public void openBrowser() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public void downScroll() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)");
    }

    public void closeBrowser(){
        driver.close();
    }
}
