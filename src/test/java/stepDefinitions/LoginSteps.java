package stepDefinitions;

import models.Credentials;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DriverFactory;
import utils.JsonDataReader;

import java.util.Objects;

public class LoginSteps  {

    WebDriver driver;
    LoginPage loginPage;

    Credentials creds = JsonDataReader.readJsonFromResources("credentials.json", Credentials.class);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        driver.get(creds.getAdminURL());
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password()  {
        loginPage.login(creds.getUsername(), creds.getPassword());
    }

    @Then("i_should_be_redirected_to_the_dashboard")
    public void i_should_be_redirected_to_the_dashboard() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("dashboard"));
    }
}
