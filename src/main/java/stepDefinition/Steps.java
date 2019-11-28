package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.LoginPOM;

public class Steps {

    private WebDriver driver;
    private LoginPOM loginPage;

    @Before
    public void injectDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\CCastravet\\Downloads\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("localhost:8080");
        loginPage = new LoginPOM(this.driver);
    }

    @Given("^Open the Login Page$")
    public void open_the_Login_Page() {
        Assert.assertTrue(loginPage.getInputName().isDisplayed());
    }

    @Then("^Enter valid username\"(.*?)\"$")
    public void enter_valid_username(String username) {
        loginPage.getInputName().sendKeys(username);
    }

    @Then("^Enter valid password\"(.*?)\"$")
    public void enter_valid_password(String password) {
        loginPage.getInputPassword().sendKeys(password);
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
