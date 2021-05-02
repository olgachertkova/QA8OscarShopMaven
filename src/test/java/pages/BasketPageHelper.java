package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPageHelper extends PageBase {

    @FindBy(css = ".basket-items h3 a")
    WebElement productNameInBasket;

    public BasketPageHelper(WebDriver driver) {
        super(driver);
    }

    public String getProductNameInBasket() {
       return productNameInBasket.getText();
    }
}
