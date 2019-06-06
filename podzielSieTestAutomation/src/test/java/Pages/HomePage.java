package Pages;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseUtil {

    private BaseUtil base;

    public HomePage(BaseUtil base) {
        this.base = base;
    }

    @FindBy(id = "logo")
    private WebElement logo;

    @FindBy(id = "toggle-publish")
    private WebElement addNewOffer;

    @FindBy(id = "query")
    private WebElement searchTitle;

    @FindBy(xpath = "//*[@id=\"main_search\"]//span[contains(text(), 'Szukaj')]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='main_search']//*[contains(text(), 'Wybierz kategorię')]")
    private WebElement searchCategoryDropdownList;

    @FindBy(xpath = "//*[@id='header']//*[contains(text(), 'Stwórz bezpłatne konto')]")
    private WebElement createNewUser;

    @FindBy(id = "login_open")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='cc-cookies ']/a[contains(text(), 'ACCEPT COOKIES')]")
    private WebElement cookieAccept;

    @FindBy(className = "cc-cookies ")
    private WebElement cookiesBar;

    @FindBy(xpath = "//*[@id='header']//a[contains(text(), 'Moje konto')]")
    private WebElement myAccountButton;

    @FindBy(xpath = "//*[@id='header']//a[contains(text(), 'Wyloguj')]")
    private WebElement logoutButton;

    public void addNewOffer() {
        WebDriverWait wait = new WebDriverWait(base.Driver, 30);
        wait.until(ExpectedConditions.visibilityOf(addNewOffer));
        wait.until(ExpectedConditions.elementToBeClickable(addNewOffer));
        addNewOffer.click();
    }

    public void navigateToHomePage() {
        WebDriverWait wait = new WebDriverWait(base.Driver, 30);
        wait.until(ExpectedConditions.visibilityOf(logo));
        wait.until(ExpectedConditions.elementToBeClickable(logo));
        logo.click();
    }

    public void insertTitle(String title) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 30);
        wait.until(ExpectedConditions.visibilityOf(searchTitle));
        wait.until(ExpectedConditions.elementToBeClickable(searchTitle));
        searchTitle.sendKeys(title);
    }

    public void selectCategory(String category) {
        searchCategoryDropdownList.click();
        base.Driver.findElement(By.xpath("//option[contains(text(), \"" + category + "\")]")).click();
    }

    public void selectVoivodship(String region) {
        Select countryDropdownList = new Select(base.Driver.findElement(By.id("sRegion")));
        countryDropdownList.selectByVisibleText(region);
    }

    public void selectCity(String city) {
        Select countryDropdownList = new Select(base.Driver.findElement(By.id("sCity")));
        countryDropdownList.selectByVisibleText(city);
    }

    public void clickSearchButton() throws InterruptedException {
        Thread.sleep(1000);
        searchButton.click();
    }

    public void createNewUser() {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(createNewUser));
        wait.until(ExpectedConditions.elementToBeClickable(createNewUser));
        createNewUser.click();
    }

    public void logIn() {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void acceptCookies() throws InterruptedException {
        if (cookiesBar.isDisplayed()) {
            cookiesBar.click();
            Thread.sleep(2000);
        }
    }

    public void openMyAccountPage() {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(myAccountButton));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
}