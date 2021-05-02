package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageHelper;
import pages.ProductPageHelper;

public class HomePageTests extends TestBase {
    HomePageHelper homePageHelper;
    ProductPageHelper productPageHelper;

    @BeforeMethod(alwaysRun = true)
    public void initPage(){
        homePageHelper = PageFactory.initElements(driver, HomePageHelper.class);
        productPageHelper = PageFactory.initElements(driver, ProductPageHelper.class);
    }

    @Test(priority = 1)
    public void homePageTitleTest(){
        String title = homePageHelper.getHomePageTitle();
        Assert.assertTrue(homePageHelper.pageTitleIsCorrect(title));
    }

    @Test(priority = 1, groups = "smoke")
    public void loginLinkIsDisplayedTest(){
        Assert.assertTrue(homePageHelper.loginLinkIsDisplayed());
    }

    @Test(priority = 1, groups = "smoke")
    public void changeLanguageTest() {
        homePageHelper.selectLanguage("ru");
        homePageHelper.clickOnGoButton();
        Assert.assertTrue(homePageHelper.languageOnPageIsRussian());
    }

    @Test(priority = 1)
    public void changeLangWithOutClickOnGoButton(){
        homePageHelper.selectLanguage("ru");
        Assert.assertFalse(homePageHelper.languageOnPageIsRussian());
    }

    @Test(priority = 1, groups = "smoke")
    public void userCanChooseProduct(){
        homePageHelper.selectBooksProductCategory();
        homePageHelper.selectSecondProduct();
        Assert.assertTrue(productPageHelper.productPageIsDisplayed());
    }




}
