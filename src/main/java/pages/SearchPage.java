package pages;

import base.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.PortUnreachableException;
import java.util.List;

import static base.Constants.*;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    String searchUrl=BASE_URL;
    WebElement paginationItem;
    public  SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,10);
        driver.get(searchUrl);
    }
    public  void search(String searchKey){

        WebElement searchInput=driver.findElement(By.name("k"));
        searchInput.sendKeys(searchKey);
        searchInput.submit();
    }

    public  void selectSearchPage(){
        List<WebElement> paginations = driver.findElements(By.xpath("//div[@id='best-match-right']/div/ul/li"));
        paginationItem=paginations.get(SEARCH_PAGE_INDEX-1);
        wait.until(ExpectedConditions.elementToBeClickable(paginationItem));
        paginationItem.click();
    }

    public String getPaginationClass(){
       return paginationItem.getAttribute("class");
    }
    public void selectSearchProduct(){
        List<WebElement> products=driver.findElements(By.xpath("//div[@id='best-match-right']//div/ul/li[contains(@class,'catalog-seem-cell')]"));
        wait.until(ExpectedConditions.elementToBeClickable(products.get(SEARCH_PRODUCT_INDEX)));
        products.get(SEARCH_PRODUCT_INDEX).click();
    }

    public Float getProductPrice(){
        WebElement productPrice=driver.findElement(By.id("sp-price-lowPrice"));
        String price= Helpers.stringToPrice(productPrice.getText());
        return Float.valueOf(price);
    }
    public void addCartProduct(){
        WebElement addCart=driver.findElement(By.xpath("//button[@id='add-to-basket']"));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, 350)");
        wait.until(ExpectedConditions.elementToBeClickable(addCart));
        addCart.click();
        driver.findElement(By.xpath("//div[@class='header-cart-data clearfix']")).isDisplayed();
    }

    public Float getBasketPrice(){
        WebElement basketPrice=driver.findElement(By.xpath("//div[@class='header-cart-data clearfix']//span[@class='product-new-price']"));
        String price= Helpers.stringToPrice(basketPrice.getText());
        return Float.valueOf(price);
    }

}
