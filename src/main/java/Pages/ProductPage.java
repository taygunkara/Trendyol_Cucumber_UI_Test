package Pages;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

    private final By addFavoriteLocator = By.className("fv");
    private final By favoriteLocator = By.linkText("Favorilerim");
    private final By productAttributesLocator = By.className("button-all-features");

    public boolean isOnProductPage() {
        waitUntilItemShowsUp(productAttributesLocator);
        return isDisplayed(productAttributesLocator);
    }

    public void switchNextWindow(){
        driver.switchTo().window(newTab.get(1));
    }

    public void addProductToFavorite() {
        clickElement(addFavoriteLocator);
    }

    public void goToFavoritePage() {
        clickElement(favoriteLocator);
    }
}
