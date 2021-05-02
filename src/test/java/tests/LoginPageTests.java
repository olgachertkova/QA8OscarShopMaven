package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import tests.util.DataProviders;

import java.util.Random;

public class LoginPageTests extends TestBase {
    HomePageHelper homePageHelper;
    LoginPageHelper loginPageHelper;
    String emailValid = "olga4@yandex.ru";
    String emailInvalid = "olga4" + "@yandex.ru";

    String passwordValid = "qwe123123";

    @BeforeMethod(alwaysRun = true)
    public void initPage(){
        homePageHelper = PageFactory.initElements(driver, HomePageHelper.class);
        loginPageHelper = PageFactory.initElements(driver, LoginPageHelper.class);
    }

    @Test(enabled = false, priority = 1, groups = "smoke")
    public void registerTestPositive(){
        String email = generateRandomEmail(12);
        System.out.println(email);
        homePageHelper.clickOnLoginOrRegisterButton();
        loginPageHelper.waitUntilLoginPageIsLoaded();
        System.out.println(emailValid);
        loginPageHelper.inputEmailForRegister(email);
        loginPageHelper.inputPasswordForRegister(passwordValid);
        loginPageHelper.confirmPassword(passwordValid);
        loginPageHelper.clickOnRegisterButton();
        homePageHelper.waitUntilHomePageIsLoaded();
        Assert.assertTrue(homePageHelper.successRegistrationMessageIsDisplayed());

    }
    @Test(enabled = false, dataProviderClass = DataProviders.class, dataProvider = "usingCSVFile", priority = 3)
    public void registerTestPositiveUsingDataProviderCSVFile(String emailValid, String passwordValid){
        homePageHelper.clickOnLoginOrRegisterButton();
        loginPageHelper.waitUntilLoginPageIsLoaded();
        System.out.println(emailValid);
        loginPageHelper.inputEmailForRegister(emailValid);
        loginPageHelper.inputPasswordForRegister(passwordValid);
        loginPageHelper.confirmPassword(passwordValid);
        loginPageHelper.clickOnRegisterButton();
        homePageHelper.waitUntilHomePageIsLoaded();
        Assert.assertTrue(homePageHelper.successRegistrationMessageIsDisplayed());

    }

    @Test(enabled = false, dataProviderClass = DataProviders.class, dataProvider = "usingDataFile")
    public void registerTestPositiveUsingDataProviderDataFile(String emailValid, String passwordValid){
        homePageHelper.clickOnLoginOrRegisterButton();
        loginPageHelper.waitUntilLoginPageIsLoaded();
        System.out.println(emailValid);
        loginPageHelper.inputEmailForRegister(emailValid);
        loginPageHelper.inputPasswordForRegister(passwordValid);
        loginPageHelper.confirmPassword(passwordValid);
        loginPageHelper.clickOnRegisterButton();
        homePageHelper.waitUntilHomePageIsLoaded();
        Assert.assertTrue(homePageHelper.successRegistrationMessageIsDisplayed());

    }

    @Test(enabled = false, dataProviderClass = DataProviders.class, dataProvider = "randomUsers")
    public void registerTestPositiveUsingDataProviderRandomData(String emailValid, String passwordValid){
        System.out.println(emailValid);
        System.out.println(passwordValid);
        homePageHelper.clickOnLoginOrRegisterButton();
        loginPageHelper.waitUntilLoginPageIsLoaded();
        loginPageHelper.inputEmailForRegister(emailValid);
        loginPageHelper.inputPasswordForRegister(passwordValid);
        loginPageHelper.confirmPassword(passwordValid);
        loginPageHelper.clickOnRegisterButton();
        homePageHelper.waitUntilHomePageIsLoaded();
        Assert.assertTrue(homePageHelper.successRegistrationMessageIsDisplayed());

    }

    @Test(enabled = false, priority = 2)
    public void registerTestNegativeSameEmail(){
        homePageHelper.clickOnLoginOrRegisterButton();
        loginPageHelper.waitUntilLoginPageIsLoaded();
        loginPageHelper.inputEmailForRegister(emailInvalid);
        loginPageHelper.inputPasswordForRegister(passwordValid);
        loginPageHelper.confirmPassword(passwordValid);
        loginPageHelper.clickOnRegisterButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(loginPageHelper.errorMessageIsDisplayed());

    }

    @Test(priority = 1, groups = "smoke")
    @Parameters({"emailValid", "passwordValid"})
    public void loginTestPositive(String emailValid, String passwordValid){
        homePageHelper.clickOnLoginOrRegisterButton();
        loginPageHelper.waitUntilLoginPageIsLoaded();
        loginPageHelper.inputEmailForLogin(emailValid);
        loginPageHelper.inputPasswordForLogin(passwordValid);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        loginPageHelper.clickOnLogInButton();
        homePageHelper.waitUntilHomePageIsLoaded();
        Assert.assertTrue(homePageHelper.welcomeBackMessageIsDisplayed());

    }

    public String generateRandomEmail(int strLen){
        String randomStrings = "";
        Random random = new Random();
        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
        for(int i = 0; i < strLen; i++) {
            word[i] = (char)('a' + random.nextInt(26));
            randomStrings = randomStrings + word[i];
        }
        String randomEmail = randomStrings + "@.com";
        return randomEmail;
    }
    private String generateRandomName() {
        return "name" + (new Random()).nextInt()+"@gmail.com";
    }
}
