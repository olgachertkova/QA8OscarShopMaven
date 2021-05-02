package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPageHelper;
import pages.HomePageHelper;
import pages.ProductPageHelper;

public class BasketPageTests extends TestBase {
    HomePageHelper homePageHelper;
    ProductPageHelper productPageHelper;
    BasketPageHelper basketPageHelper;

    @BeforeMethod(alwaysRun = true)
    public void initPage(){
        homePageHelper = PageFactory.initElements(driver, HomePageHelper.class);
        productPageHelper = PageFactory.initElements(driver, ProductPageHelper.class);
        basketPageHelper = PageFactory.initElements(driver, BasketPageHelper.class);
    }



    @Test(priority = 1, groups = "smoke")
    public void addToBasketTest(){
        homePageHelper.selectSubMenuBooks();
        homePageHelper.selectProductInListByNumber(1);
        String productName = productPageHelper.getProductName();
        productPageHelper.clickOnAddToBasketButton();
        productPageHelper.clickOnViewBasketButton();
        String productNameInBasket = basketPageHelper.getProductNameInBasket();

        Assert.assertEquals(productNameInBasket, productName);
    }
}
