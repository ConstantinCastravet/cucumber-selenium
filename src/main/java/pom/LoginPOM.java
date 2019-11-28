package pom;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginPOM {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement inputName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement inputPassword;

    @FindBy(xpath = "/html/body/div/div/form/button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"errorMessage\"]/div")
    WebElement alertNotification;

    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getInputName() {
        return inputName;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getAlertNotification() {
        return alertNotification;
    }
}
