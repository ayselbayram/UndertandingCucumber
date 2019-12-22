package com.bookIt.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_stepDefinitions {


    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        System.out.println("user is on the login page");
    }

    @Then("user enters teacher username")
    public void userEntersTeacherUsername() {
        System.out.println("teacher enters username");
    }

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

}
