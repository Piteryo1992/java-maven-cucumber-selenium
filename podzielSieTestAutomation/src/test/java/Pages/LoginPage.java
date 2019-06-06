package Pages;

import Base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseUtil {

    private BaseUtil base;

    public LoginPage(BaseUtil base) {
        this.base = base;
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='user-login']//button[contains(text(), 'Zaloguj się')]")
    private WebElement logInButton;

    public void insertEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void insertPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void logInButtonClick() throws InterruptedException {
        Thread.sleep(2000);
        logInButton.click();
    }
}