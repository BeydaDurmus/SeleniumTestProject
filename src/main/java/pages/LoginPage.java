package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.Constants.BASE_URL;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //String loginUrl=BASE_URL+"uye-girisi";

    public void login(String username,String password){
        String loginUrl=BASE_URL+"uye-girisi";
        driver.get(loginUrl);

        WebElement userInput= driver.findElement(By.id("L-UserNameField"));
        userInput.sendKeys(username);

        WebElement userPasswordInput = driver.findElement(By.id("L-PasswordField"));
        userPasswordInput.sendKeys(password);

        WebElement loginButton=driver.findElement(By.id("gg-login-enter"));
        loginButton.click();
    }

    public String getUserName(){
        WebElement user=driver.findElement(By.xpath("//div[@title='Hesabım']//span"));
       return user.getText();
    }

}
