package test;
import base.BaseTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Before
    public  void beforClass()
    {
        setup();
        loginPage=new LoginPage(driver);
    }

    @Test
    public void login(){
        loginPage.login("tdz60898@eoopy.com","123456deneme");
    }
}
