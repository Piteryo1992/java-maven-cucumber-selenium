package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

public class LoginStep {
    @Given("^I navigate to the login page of the application$")
    public void iNavigateToTheLoginPageOfTheApplication() {

        System.out.println("I navigate to login page");
    }

    @And("^I click login button$")
    public void iClickLoginButton() {

        System.out.println("I click login button");
    }

    @Then("^I should see the userform$")
    public void iShouldSeeTheUserform() {

        System.out.println("I see the userform page");
    }

    @And("^I enter the following details for login$")
    public void iEnterTheFollowingDetailsForLogin(DataTable table) {

        /*List<List<String>> data = table.raw();

        System.out.println("The value is: " + data.get(0).get(0).toString());
        System.out.println("The value is: " + data.get(0).get(1).toString());*/

        //Create an ArrayList
        List<User> users = new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        for (User user : users) {
            System.out.println("The UserName is: " + user.username);
            System.out.println("The password is: " + user.password);

        }
    }

    public class User {
        //Variables
        public String username;
        public String password;

        //CONSTRUCTOR (alt+insert -> create constructor)
        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }

    }
}