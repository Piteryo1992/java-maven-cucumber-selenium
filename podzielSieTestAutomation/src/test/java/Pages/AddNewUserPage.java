package Pages;

import Base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewUserPage extends BaseUtil {

    private BaseUtil base;

    public AddNewUserPage(BaseUtil base) {
        this.base = base;
    }

    @FindBy(id = "s_name")
    private WebElement userNameField;

    @FindBy(id = "s_email")
    private WebElement userEmailField;

    @FindBy(id = "s_password")
    private WebElement userPasswordField;

    @FindBy(id = "s_password2")
    private WebElement userPasswordRepeatField;

    @FindBy(xpath = "//*[@id=\"user-register\"]//button[contains(text(), \"Utwórz nowe konto\")]")
    private WebElement createAccountButton;

    public String addNewUserPageUrl =
            "http://serwer1925383.home.pl/osclass.3.8.0/index.php?page=register&action=register";

    public void createUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.sendKeys(userName);
    }

    public void createUserPassword(String password) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(userPasswordField));
        wait.until(ExpectedConditions.visibilityOf(userPasswordRepeatField));
        userPasswordField.sendKeys(password);
        userPasswordRepeatField.sendKeys(password);
    }

    public void createUserEmail(String email) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(userEmailField));
        userEmailField.sendKeys(email);
    }

    public void createAccountButtonClick() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
    }
}