package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {
    @FindBy(id = "register_form")
    WebElement registerForm;
    
    @FindBy(id = "id_registration-email")
    WebElement registrationEmail;
    
    @FindBy(id = "id_registration-password1")
    WebElement registrationPassword;

    @FindBy(id = "id_registration-password2")
    WebElement registrationConfirmPassword;

    @FindBy(name = "registration_submit")
    WebElement registrationSubmitButton;

    @FindBy(className = "alert-danger")
    WebElement errorMessage;
    
    @FindBy(id = "id_login-username")
    WebElement loginEmail;

    @FindBy (id = "id_login-password")
    WebElement loginPassword;

//    @FindBy (name = "login_submit")
    @FindBy (xpath = "//button[contains(text(),'Log In')]")
    WebElement logInButton;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilLoginPageIsLoaded() {
        waitUntilElementVisible(registerForm, 30);
    }

    public void inputEmailForRegister(String emailValid) {
        inputText(registrationEmail, emailValid);
    }

    public void inputPasswordForRegister(String passwordValid) {
        inputText(registrationPassword, passwordValid);
    }

    public void confirmPassword(String passwordValid) {
        inputText(registrationConfirmPassword, passwordValid);
    }

    public void clickOnRegisterButton() {
        registrationSubmitButton.click();
    }

    public boolean errorMessageIsDisplayed() {
        return errorMessage.isDisplayed();
    }

    public void inputEmailForLogin(String emailValid) {
        inputText(loginEmail, emailValid);
    }

    public void inputPasswordForLogin(String passwordValid) {
        inputText(loginPassword, passwordValid);
    }

    public void clickOnLogInButton() {
        logInButton.click();
    }
}
