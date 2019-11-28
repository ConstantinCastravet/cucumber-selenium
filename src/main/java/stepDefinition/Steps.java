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

public class Steps {

    private WebDriver driver;

    @Before
    public void injectDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.md/imghp?hl=ru&tab=wi&authuser=0&ogbl");
    }

    @Given("^Open the Chrome$")
    public void open_the_Chrome() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed());
    }

    @Then("^Enter specified name$")
    public void enter_specified_name() {
        driver.findElement(By.xpath("//*[@id=\"sbtc\"]/div/div[2]/input")).sendKeys("Cats");
    }

    @Then("^Click search button$")
    public void click_search_button() {
        driver.findElement(By.xpath("//*[@id=\"sbtc\"]/button")).click();
    }

    @Then("^Pictures must be view$")
    public void pictures_must_be_view() {
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[@id=\"rg_s\"]")).isDisplayed());
    }

    @After
    private void closeDriver() {
        driver.close();
    }
}
