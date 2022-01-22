package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By userNameLocator = By.id("login-email");
    private final By loginLocator = By.className("login-button");
    private final By passwordLocator = By.id("login-password-input");
    private final By submitButtonLocator = By.cssSelector(".q-primary.submit");


    public void setUsername() {
        clickElement(loginLocator);
        waitUntilItemShowsUp(userNameLocator);
        type(userNameLocator, userName);
    }
    public void setPassword(){
        waitUntilItemShowsUp(passwordLocator);
        type(passwordLocator, password);
    }
    public void submitLogin() {
        clickElement(submitButtonLocator);
    }

}
