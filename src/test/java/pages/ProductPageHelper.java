package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageHelper extends PageBase {
    @FindBy(id = "product_description")
    WebElement productDescription;

    @FindBy(className = "btn-add-to-basket")
    WebElement addToBasketButton;

    @FindBy(id = "messages")
    WebElement messagesArea;

    @FindBy(css = "#messages .alert:nth-child(1)")
    WebElement firstMessage;

    @FindBy(css = ".product_main .price_color")
    WebElement productPrice;

    @FindBy(className = "basket-mini")
    WebElement basketTotal;

    @FindBy(css = ".btn-group a.btn.btn-default")
    WebElement viewBasketButton;

    @FindBy(css = ".product_main h1")
    WebElement productName;

    public ProductPageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean productPageIsDisplayed() {
        return productDescription.isDisplayed();
    }

    public void clickOnAddToBasketButton() {
        addToBasketButton.click();
    }

    public boolean successMessageIsDisplayed() {
        return messagesArea.isDisplayed();
    }

    public boolean messageContainsSuccessText() {
        return firstMessage.getText().contains("has been added to your basket");
    }

    public Double getProductPrice() {
        return Double.parseDouble(productPrice.getText().substring(1));
    }

    public Double getBasketTotal() {
        Double totalBasket = Double.parseDouble(basketTotal.getText().split(" ")[2].substring(1, 6));
        return totalBasket;

    }

    public void clickOnViewBasketButton() {
        viewBasketButton.click();
    }

    public String getProductName() {
        return productName.getText();
    }
}
