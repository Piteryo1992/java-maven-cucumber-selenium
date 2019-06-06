package Pages;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewOfferPage extends BaseUtil {

    private BaseUtil base;

    public AddNewOfferPage(BaseUtil base) {
        this.base = base;
    }

    @FindBy(id = "catId")
    private WebElement addCategoryDropdownList;

    @FindBy(id = "titlepl_PL")
    private WebElement titleField;

    @FindBy(id = "descriptionpl_PL")
    private WebElement descriptionField;

    @FindBy(id = "price")
    private WebElement priceField;

    @FindBy(id = "region")
    private WebElement regionField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "cityArea")
    private WebElement cityAreaField;

    @FindBy(id = "address")
    private WebElement addressField;

    @FindBy(id = "contactName")
    private WebElement contactNameField;

    @FindBy(id = "contactEmail")
    private WebElement contactEmailField;

    @FindBy(xpath = "//*[@id=\"restricted-fine-uploader\"]//input")
    private WebElement uploadImageButton;

    @FindBy(xpath = "//*[@id=\"item-post\"]//button[contains(text(),'Publikuj')]")
    private WebElement publishButton;

    @FindBy(xpath = "//*[@id=\"item-post\"]//button[contains(text(),'Aktualizuj')]")
    private WebElement updateButton;

    public void selectCategory(String category) {
        addCategoryDropdownList.click();
        base.Driver.findElement(By.xpath("//*[contains(text(), \"" + category + "\")]")).click();
    }

    public void insertTitle(String title) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(titleField));
        titleField.clear();
        titleField.sendKeys(title);
    }

    public void insertDescription(String description) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void selectCountry(String country) {
        Select countryDropdownList = new Select(base.Driver.findElement(By.id("countryId")));
        countryDropdownList.selectByVisibleText(country);
    }

    public void selectRegion(String region) {
        Select regionDropdownList = new Select(base.Driver.findElement(By.id("regionId")));
        regionDropdownList.selectByVisibleText(region);
    }

    public void selectCity(String city) throws InterruptedException {
        Thread.sleep(2000);
        Select cityDropdownList = new Select(base.Driver.findElement(By.id("cityId")));
        cityDropdownList.selectByVisibleText(city);
    }

    public void insertCityArea(String cityArea) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(cityAreaField));
        cityAreaField.clear();
        cityAreaField.sendKeys(cityArea);
    }

    public void insertAddress(String address) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(addressField));
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void insertContactName(String contactName) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(contactNameField));
        contactNameField.clear();
        contactNameField.sendKeys(contactName);
    }

    public void insertContactEmail(String contactEmail) {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(contactEmailField));
        contactEmailField.clear();
        contactEmailField.sendKeys(contactEmail);
    }

    public void uploadPhoto(String photoPath) {
        uploadImageButton.sendKeys((System.getProperty("user.dir")) + photoPath);
    }

    public void publishOffer() throws InterruptedException {
        Thread.sleep(2000);
        publishButton.click();
    }

    public void updateOffer() throws InterruptedException {
        Thread.sleep(2000);
        updateButton.click();
    }
}