package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.Constants.BASE_URL;

public class BasketPage {
    WebDriver driver;
    WebDriverWait wait;
    String basketUrl=BASE_URL+"sepetim";
    Select amount;
    public BasketPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,5);
        driver.get(basketUrl);
    }

    public void addToBasket(){
        amount=new Select(driver.findElement(By.xpath("//div[@class='products-container']//div//select[@class='amount']")));
        amount.selectByIndex(1);
    }

    public Integer currentProductCount(){
       String productCount= amount.getFirstSelectedOption().getText();
       return Integer.valueOf(productCount);
    }

    public  void removeBasket(){
        WebElement removeIcon = driver.findElement(By.xpath("//div[@class='products-container']//div[@class='row']/a"));
        removeIcon.click();
    }

    public String emptyBasketMessage() throws InterruptedException {
            WebElement message=driver.findElement(By.xpath("//div[@class='products-container']//h2"));
            //message.isDisplayed();
            Thread.sleep(500);
            return message.getText();
    }
}
