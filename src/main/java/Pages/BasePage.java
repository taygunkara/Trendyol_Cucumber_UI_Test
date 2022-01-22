package Pages;

import java.time.Instant;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected final String userName = "yourUsername";
    protected final String password = "yourPassword";

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAllElements(By locator){
        return driver.findElements(locator);
    }

    public void clickElement(By locator){
        findElement(locator).click();
    }

    public void type(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return findElement(locator).isDisplayed();
    }

    public void mouseMovementAndClick(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(findElement(locator)).perform();
    }

    public void pressEnter(By locator) {
        findElement(locator).sendKeys(Keys.RETURN);
    }

    public void waitUntilItemShowsUp(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
