package test;

import base.BaseTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.BasketPage;
import pages.LoginPage;
import pages.SearchPage;

import static base.Constants.*;

public class TestiniumTest extends BaseTest {
        protected static WebDriver driver;
        LoginPage loginPage;
        BasketPage basketPage;
        SearchPage searchPage;

    @BeforeClass
    public static void beforeClass(){
        setup();
        driver=BaseTest.driver;
        System.out.println("Testler başladı.");
    }

    @AfterClass
    public static void  afterClass(){
        closeBrowser();
        System.out.println("Testler sonlandı.");
    }

    @Test
    public void login(){
        loginPage=new LoginPage(driver);
        loginPage.login(EMAIL,PASSWORD);
        Assert.assertEquals("Giriş yapan kullanıcının adı kontrol edildi.",ACTIVE_USERNAME,loginPage.getUserName());

    }

    @Test
    public void search(){
        searchPage=new SearchPage(driver);

        searchPage.search("bilgisayar");
        downScroll();
        searchPage.selectSearchPage();

        Assert.assertTrue("2.sayfaya gidilmesi  URL'den kontol edildi.",driver.getCurrentUrl().contains("sf="+SEARCH_PAGE_INDEX));
        //Assert.assertTrue("Pagination'daki seçili item sayfa numarası kontrol edildi.",searchPage.getPaginationClass().contains("selected"));

        searchPage.selectSearchProduct();
        Float price=searchPage.getProductPrice();

        searchPage.addCartProduct();
        Float basketPrice=searchPage.getBasketPrice();

        Assert.assertEquals("Ürün fiyatı ve sepette tutarı kontrol edildi.",price,basketPrice);

    }

    @Test()
    public void basket() throws InterruptedException {
        basketPage= new BasketPage(driver);

        basketPage.addToBasket();
        Assert.assertTrue("Sepette ürün adedinin arttırılması kontrol edildi.",basketPage.currentProductCount()==2);

        basketPage.removeBasket();
        String basket=basketPage.emptyBasketMessage();
        Assert.assertEquals("Ürünün sepetten silinmesi kontrol edildi.",EMPTY_BASKET_MESSAGE,basket);
    }
}
