package StepDefs;

import Base.BaseUtil;
import Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class StepDefs extends BaseUtil {

    private BaseUtil base;

    public StepDefs(BaseUtil base) {
        this.base = base;
    }

    @When("^I am on the website$")
    public void iAmOnTheWebsite() throws InterruptedException {
        base.Driver.navigate().to(getBaseUrl());
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        homePage.acceptCookies();
    }

    @When("^I click Publikuj Twoja Oferte Bezplatnie$")
    public void iClickPublikujTwojaOferteBezplatnie() {
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        homePage.addNewOffer();
    }

    @When("^I add offer with following: \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void iAddOfferWithFollowing(String category, String title, String description,
                                       String region, String city, String cityArea, String address, String contactName,
                                       String contactEmail, String photoPath) throws InterruptedException {
        AddNewOfferPage addNewOfferPage = new AddNewOfferPage(base);
        PageFactory.initElements(base.Driver, addNewOfferPage);
        addNewOfferPage.selectCategory(category);
        addNewOfferPage.insertTitle(title);
        addNewOfferPage.insertDescription(description);
        addNewOfferPage.selectRegion(region);
        addNewOfferPage.selectCity(city);
        addNewOfferPage.insertCityArea(cityArea);
        addNewOfferPage.insertAddress(address);
        addNewOfferPage.insertContactName(contactName);
        addNewOfferPage.insertContactEmail(contactEmail);
        addNewOfferPage.uploadPhoto(photoPath);
        addNewOfferPage.publishOffer();
    }

    @Then("^I see a message that offer was published successfully$")
    public void iSeeAMessageThatOfferWasPublishedSuccessfully() {
        WebElement message = base.Driver.findElement(By.id("flashmessage"));
        String expectedMessage = "XTwoje ogłoszenie zostało opublikowane";
        Assert.assertEquals(expectedMessage, message.getText());
    }

    @When("^I navigate to home page$")
    public void iNavigateToHomePage() {
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        homePage.navigateToHomePage();
    }

    @When("^I search for following: \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void iSearchForFollowing(String category, String title, String region, String city)
            throws InterruptedException {
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        homePage.insertTitle(title);
        homePage.selectCategory(category);
        homePage.selectVoivodship(region);
        homePage.selectCity(city);
        homePage.clickSearchButton();
    }

    @Then("^On search list I should see: \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void onSearchListIShouldSee(String category, String title, String description, String region, String city) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(base);
        PageFactory.initElements(base.Driver, searchResultsPage);
        System.out.println("Product title found: " + searchResultsPage.getProductTitle()
                + " | Expected: " + title);
        Assert.assertEquals(title, searchResultsPage.getProductTitle());
        System.out.println("Product category found: " + searchResultsPage.getProductCategory()
                + " | Expected: " + category);
        Assert.assertEquals(category, searchResultsPage.getProductCategory());
        System.out.println("Product description found: " + searchResultsPage.getProductDescription()
                + " | Expected: " + description);
        Assert.assertEquals(description, searchResultsPage.getProductDescription());
        System.out.println("Product location found: " + searchResultsPage.getProductLocation()
                + " | Expected: " + city + " (" + region + ")");
        Assert.assertEquals(city + " (" + region + ")", searchResultsPage.getProductLocation());
    }

    @When("^I click Stworz Bezplatne Konto$")
    public void iClickStworzBezplatneKonto() {
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        homePage.createNewUser();
        String actualUrl = base.Driver.getCurrentUrl();
        AddNewUserPage addNewUserPage = new AddNewUserPage(base);
        PageFactory.initElements(base.Driver, addNewUserPage);
        Assert.assertEquals(actualUrl, addNewUserPage.addNewUserPageUrl);
    }

    @When("^I create new user with follwing: \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void iCreateNewUserWithFollwing(String userName, String password, String email) throws InterruptedException {
        AddNewUserPage addNewUserPage = new AddNewUserPage(base);
        PageFactory.initElements(base.Driver, addNewUserPage);
        addNewUserPage.createUserName(userName);
        addNewUserPage.createUserPassword(password);
        addNewUserPage.createUserEmail(email);
        addNewUserPage.createAccountButtonClick();
    }

    @Then("^I see a message that new user has been added$")
    public void iSeeAMessageThatNewUserHasBeenAdded() {
        WebElement message = base.Driver.findElement(By.id("flashmessage"));
        String expectedMessage = "XUżytkownik został utworzony. E-mail aktywacyjny został wysłany.";
        Assert.assertEquals(expectedMessage, message.getText());
    }

    @When("^I click Zaloguj Sie$")
    public void iClickZalogujSie() {
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        homePage.logIn();
    }

    @When("^I enter following user details: \"(.*)\", \"(.*)\"$")
    public void iEnterFollowingUserDetails(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(base);
        PageFactory.initElements(base.Driver, loginPage);
        loginPage.insertEmail(email);
        loginPage.insertPassword(password);
        loginPage.logInButtonClick();
    }

    @Then("^I see a message that user was not registered yet$")
    public void iSeeAMessageThatUserWasNotRegisteredYet() {
        WebElement message = base.Driver.findElement(By.id("flashmessage"));
        String expectedMessage1 = "XUżytkownik nie został aktywowany.";
        String expectedMessage2 = "XUżytkownik nie został jeszcze zatwierdzony. Chcesz, aby ponownie wysłano"
                + " link aktywacyjny?";
        boolean result = false;
        if (message.getText().equals(expectedMessage1)) {
            result = true;
        } else if (message.getText().equals(expectedMessage2)) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertTrue(result);
    }

    @When("^I click Moje Konto$")
    public void iClickMojeKonto() {
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        homePage.openMyAccountPage();
    }

    @When("^I click Edytuj Ogloszenie$")
    public void iClickEdytujOgloszenie() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(base);
        PageFactory.initElements(base.Driver, searchResultsPage);
        searchResultsPage.editOffer();
    }

    @When("^I replace existing description with \"([^\"]*)\"$")
    public void iReplaceExistingDescriptionWith(String newDescription) throws InterruptedException {
        AddNewOfferPage addNewOfferPage = new AddNewOfferPage(base);
        PageFactory.initElements(base.Driver, addNewOfferPage);
        addNewOfferPage.insertDescription(newDescription);
        addNewOfferPage.updateOffer();
    }

    @When("^I click Usun$")
    public void iClickUsun() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(base);
        PageFactory.initElements(base.Driver, searchResultsPage);
        searchResultsPage.deleteOffer();
    }

    @Then("^I should see no offers$")
    public void iShouldSeeNoOffers() {
        Assert.assertTrue(base.Driver.findElement(By
                .xpath("//*[@id='main']//p[contains(text(), 'Nie dodano jeszcze żadnej oferty')]")).isDisplayed());
    }

    @When("^I click Wyloguj$")
    public void iClickWyloguj() {
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        homePage.logout();
    }

    @Then("^I should be able to click Zaloguj Sie again$")
    public void iShouldBeAbleToClickZalogujSieAgain() {
        HomePage homePage = new HomePage(base);
        PageFactory.initElements(base.Driver, homePage);
        Assert.assertTrue(homePage.loginButton.isDisplayed());
    }

    @When("^I add offer as registerd user with following: \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void iAddOfferAsRegisterdUserWithFollowing(String category, String title, String description, String region,
                                                      String city, String cityArea, String address, String photoPath)
            throws InterruptedException {
        AddNewOfferPage addNewOfferPage = new AddNewOfferPage(base);
        PageFactory.initElements(base.Driver, addNewOfferPage);
        addNewOfferPage.selectCategory(category);
        addNewOfferPage.insertTitle(title);
        addNewOfferPage.insertDescription(description);
        addNewOfferPage.selectRegion(region);
        addNewOfferPage.selectCity(city);
        addNewOfferPage.insertCityArea(cityArea);
        addNewOfferPage.insertAddress(address);
        addNewOfferPage.uploadPhoto(photoPath);
        addNewOfferPage.publishOffer();
    }
}