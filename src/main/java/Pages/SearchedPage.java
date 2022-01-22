package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchedPage extends BasePage {
    public SearchedPage(WebDriver driver) {
        super(driver);
    }

    private final By productPopUpLocator = By.className("popup");
    private final By productCountLocator = By.className("p-card-wrppr");
    private final By cancelProductPopUpLocator = By.className("prdct-cntnr-wrppr");
    private final By firstProductLocator = By.cssSelector("div.p-card-wrppr:nth-child(2) > div:nth-child(1) > a:nth-child(1)");


    public int getAllProductsCounts(){
        return findAllElements(productCountLocator).size();
    }

    public boolean checkAllProductsCounts(){
        return getAllProductsCounts() > 2;
    }

    public void cancelProductPopUp(){
        if(isDisplayed(productPopUpLocator)){
            waitUntilItemShowsUp(cancelProductPopUpLocator);
            clickElement(cancelProductPopUpLocator);
        }
    }

    public void selectFirstProduct() {
        pressEnter(firstProductLocator);
    }
}
