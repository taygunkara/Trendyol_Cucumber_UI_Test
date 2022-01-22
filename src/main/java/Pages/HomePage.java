package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    private final By searchedTextLocator = By.id("search-app");
    private final By welcomePopUpLocator = By.className("modal-close");
    private final By myAccountLocator = By.className("link-text");
    private final By searchBoxLocator = By.className("search-box");
    private final By cookiesLocator = By.className("cookie-policy-accept-button");
    private final By firstProductLocator = By.cssSelector("div.p-card-wrppr:nth-child(2) > div:nth-child(1) > a:nth-child(1)");
    private final By loginButtonLocator = By.cssSelector("#account-navigation-container > div > div.account-nav-item.user-login-container > div.link.account-user");

    public void declineCookies(){
        clickElement(cookiesLocator);
    }
    public void declineWelcomePopUp(){
        clickElement(welcomePopUpLocator);
    }
    public void clickLoginButton(){
        mouseMovementAndClick(loginButtonLocator);
    }
    public String isOnLoginPage() {
        return findElement(myAccountLocator).getText();
    }
    public String isLoggedIn() throws InterruptedException {
        Thread.sleep(2000);
        return findElement(myAccountLocator).getText();
    }
    public void search(String itemToSearch) {
        waitUntilItemShowsUp(searchBoxLocator);
        type(searchBoxLocator, itemToSearch);
        pressEnter(searchBoxLocator);
    }
    public boolean isOnSearchedPage() {
        return isDisplayed(searchedTextLocator);
    }
    public String isLoggedOut() throws InterruptedException {
        Thread.sleep(2000);
        return findElement(myAccountLocator).getText();
    }
}
