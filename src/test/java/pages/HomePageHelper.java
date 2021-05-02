package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageHelper extends PageBase {
    @FindBy(name = "language")
    WebElement languageSelect;

    @FindBy(css = "button.btn.btn-default[type=\"submit\"]")
    WebElement submitLangButton;

    @FindBy(id = "login_link")
    WebElement loginLink;

    @FindBy(className = "dropdown-submenu")
    WebElement booksCategory;

    @FindBy(css = ".product_pod .image_container")
    List<WebElement> productImgList;

    @FindBy(className= "dropdown-submenu")
    WebElement booksSubmenu;

    @FindBy(className = "page-header")
    WebElement pageHeader;

    @FindBy(className = "product_pod")
    List<WebElement> booksList;

    @FindBy(className = "alert-success")
    WebElement alertRegistrationSuccess;

    @FindBy(css = "section.well .sub-header")
    WebElement welcomeMessage;

    @FindBy(className = "alert-success")
    WebElement welcomebackMessage;


    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public Boolean pageTitleIsCorrect(String title) {
        return title.contentEquals("Oscar - Sandbox");
    }

    public void selectLanguage(String lang) {
        selectInDropDownByValue(languageSelect, lang);
    }

    public void clickOnGoButton() {
        submitLangButton.click();
    }

    public String getLoginLinkText() {
        return loginLink.getText();
    }

    public boolean languageOnPageIsRussian() {
        return getLoginLinkText().contains("Войти");
    }

    public void selectBooksProductCategory() {
        booksCategory.click();

    }

    public void selectSecondProduct() {
        productImgList.get(1).click();
    }

    public boolean loginLinkIsDisplayed() {
        return loginLink.isDisplayed();
    }

    public void selectSubMenuBooks() {
        booksSubmenu.click();
    }

    public void waitUntilProductListIsDisplayed() {
        waitUntilElementVisible(pageHeader, 5);
    }

    public void selectProductInListByNumber(int i) {
        try {
            booksList.get(i-1).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Number of product must be > 0!!!");
        }
    }

    public void clickOnLoginOrRegisterButton() {
        loginLink.click();
    }

    public boolean successRegistrationMessageIsDisplayed() {
        return alertRegistrationSuccess.isDisplayed();

    }

    public void waitUntilHomePageIsLoaded() {
        waitUntilElementVisible(welcomeMessage, 60);
    }

    public boolean welcomeBackMessageIsDisplayed() {
        return welcomebackMessage.isDisplayed();
    }
}
