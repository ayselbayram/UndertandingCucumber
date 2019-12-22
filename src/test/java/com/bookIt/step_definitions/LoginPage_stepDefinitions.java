package com.bookIt.step_definitions;

import com.bookIt.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_stepDefinitions {






    @And("user enters teacher password")
    public void userEntersTeacherPassword() {
        System.out.println("teacher enters password");
    }

    @When("user clicks sign in button")
    public void userClicksSignInButton() {
        System.out.println("user clicks on sign in button");
    }
    @Then("the page title must be correct")
    public void thePageTitleMustBeCorrect() {
        System.out.println("Page title must be correct");

    }



    @Then("user enters student password")
    public void userEntersStudentPassword() {
        System.out.println("Student enters password");
    }



    @Then("user enters team lead password")
    public void userEntersTeamLeadPassword() {
        System.out.println("team lead enters password");
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        System.out.println("user is on the login page");
    }


    @Then("user enters username: {string}")
    public void userEntersUsernameStudentUsername(String username) {
        System.out.println(ConfigurationReader.getProperty(username));
    }

    @Then("user enters password: {string}")
    public void userEntersPasswordStudentPassword(String password) {
        System.out.println(ConfigurationReader.getProperty(password));
    }

    @Then("4 menu options are shown")
    public void menuOptionsAreShown() {
    }
}
