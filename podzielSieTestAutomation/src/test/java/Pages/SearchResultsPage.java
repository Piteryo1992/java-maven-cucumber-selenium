package Pages;

import Base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SearchResultsPage extends BaseUtil {

    private BaseUtil base;

    public SearchResultsPage(BaseUtil base) {
        this.base = base;
    }

    @FindBy (xpath = "//*[@id=\"listing-card-list\"]/li/div/div/div[2]/div/div/h4/a")
    private WebElement productTitle;

    @FindBy (xpath = "//*[@id=\"listing-card-list\"]/li/div/div/div[2]/div/div/div/span[1]")
    private WebElement productCategory;

    @FindBy (xpath = "//*[@id=\"listing-card-list\"]/li/div/div/div[2]/div/div/div/span[2]")
    private WebElement productLocation;

    @FindBy (xpath = "//*[@id=\"listing-card-list\"]/li/div/div/div[2]/div/div/p")
    private WebElement productDescription;

    @FindBy (xpath = "//*[@id=\"listing-card-list\"]/li[1]/div/div/div[2]/div/span/a[1]")
    private WebElement editOfferButton;

    @FindBy (xpath = "//*[@id=\"listing-card-list\"]/li[1]/div/div/div[2]/div/span/a[2]")
    private WebElement deleteOfferButton;

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductCategory() {
        return productCategory.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public String getProductLocation() {
        return productLocation.getText();
    }

    public void editOffer() {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(editOfferButton));
        wait.until(ExpectedConditions.elementToBeClickable(editOfferButton));
        editOfferButton.click();
    }

    public void deleteOffer() {
        WebDriverWait wait = new WebDriverWait(base.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(deleteOfferButton));
        wait.until(ExpectedConditions.elementToBeClickable(deleteOfferButton));
        deleteOfferButton.click();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(200);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}