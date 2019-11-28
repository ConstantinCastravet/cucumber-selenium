package core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {

    private static WebDriver driver;

    public static WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\CCastravet\\Downloads\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
