package stepDefinition;

import core.DriverProvider;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.LoginPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginPageSteps {

    private WebDriver driver;
    private LoginPOM loginPage;
    private String password;
    private String username;
    @Before
    public void injectDriver() {

        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            driver = DriverProvider.getDriver(prop.getProperty("url"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        loginPage = new LoginPOM(this.driver);
    }

    @Given("^Open the Login Page$")
    public void open_the_Login_Page() {
        Assert.assertTrue(loginPage.getInputName().isDisplayed());
    }

    @Then("^Enter valid username\"(.*?)\"$")
    public void enter_valid_username(String username) {
        if (username.equalsIgnoreCase("ValidUsername"))
            loginPage.getInputName().sendKeys(this.username);
    }

    @Then("^Enter valid password\"(.*?)\"$")
    public void enter_valid_password(String password) {
        if (password.equalsIgnoreCase("ValidPassword"))
            loginPage.getInputPassword().sendKeys(this.password);
    }

    @Then("^Click login button$")
    public void click_login_button() {
        loginPage.getLoginButton().click();
    }

    @Then("^User should be$")
    public void user_should_be() {
        driver.findElement(By.xpath("//*[@id=\"goLogout\"]")).isDisplayed();
    }


    @Then("^Enter invalid password\"(.*?)\"$")
    public void enter_invalid_password(String invalidPassword) {
        loginPage.getInputPassword().sendKeys(invalidPassword);
    }

    @Then("^Should be displayed error message$")
    public void should_be_displayed_error_message() {
        Assert.assertTrue(loginPage.getAlertNotification().isDisplayed());
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
