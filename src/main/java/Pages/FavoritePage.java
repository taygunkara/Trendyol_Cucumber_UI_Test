package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FavoritePage extends BasePage {

    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    private final By allRemoveFavoriteButtonLocator = By.className("i-close");
    private final By emptyFavoriteLocator = By.className("empty-favorites");
    private final By favoriteProductCountLocator = By.className("p-card-chldrn-cntnr");
    private final By logoutButtonLocator = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div[3]/div/div/div/div[1]/div[2]/div/a[9]");
    private final By userAccountMenuLocator = By.cssSelector("#account-navigation-container > div > div.account-nav-item.user-login-container > div.link.account-user");

    public int favoriteProductCounts() {
        return findAllElements(favoriteProductCountLocator).size();
    }
    public boolean checkIfProductAdded() {
        waitUntilItemShowsUp(favoriteProductCountLocator);
        return favoriteProductCounts() >= 1 ;
    }
    public List <WebElement> findAllRemoveFavoriteButtons() {
        return findAllElements(allRemoveFavoriteButtonLocator);
    }
    public void removeFavoriteProduct(int i){
        waitUntilItemShowsUp(allRemoveFavoriteButtonLocator);
        findAllRemoveFavoriteButtons().get(i).click();
    }
    public boolean isFavoritePageEmpty() {
        waitUntilItemShowsUp(emptyFavoriteLocator);
        return isDisplayed(emptyFavoriteLocator);
    }
    public void hoverUserAccount() {
        waitUntilItemShowsUp(userAccountMenuLocator);
        mouseMovementAndClick(userAccountMenuLocator);
    }
    public void clickLogoutButton() {
        waitUntilItemShowsUp(logoutButtonLocator);
        clickElement(logoutButtonLocator);
    }
}
