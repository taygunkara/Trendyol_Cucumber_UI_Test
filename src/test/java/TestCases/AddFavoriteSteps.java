package TestCases;

import Pages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddFavoriteSteps {
    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private SearchedPage searchedPage;
    private FavoritePage favoritePage;
    private String searchedItem = "çanta";

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Given("Start Driver and Browser")
    public void start_driver_and_browser() {
        setup();
    }

    @When("Navigate to Trendyol")
    public void navigate_to_trendyol() {
        driver.get("https://www.trendyol.com/");
        driver.manage().window().maximize();
    }

    @And("Click Login Area")
    public void click_login_area() {
        homePage = new HomePage(driver);
        homePage.declineWelcomePopUp();
        homePage.declineCookies();
        homePage.clickLoginButton();
    }

    @Then("Verify Login Page")
    public void verify_login_page() {
        Assert.assertEquals(homePage.isOnLoginPage(),"Giriş Yap");
    }

    @When("Enter Validation Criterias")
    public void enter_validation_criterias() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.setUsername();
        loginPage.setPassword();
    }

    @And("Click Login Button")
    public void click_login_button() {
        loginPage.submitLogin();
    }

    @Then("Verify Logined")
    public void verify_logined() throws InterruptedException {
        Assert.assertEquals(homePage.isLoggedIn(), "Hesabım");
    }

    @When("Search Product")
    public void search_product() {
        homePage.search(searchedItem);
    }

    @And("Verify Searched Page")
    public void verify_searched_page() {
        Assert.assertTrue((homePage.isOnSearchedPage()));
    }

    @And("Verify Products Counts")
    public void verify_products_counts() {
        searchedPage = new SearchedPage(driver);
        searchedPage.cancelProductPopUp();
        Assert.assertTrue((searchedPage.checkAllProductsCounts()));
    }

    @And("Click Product")
    public void click_product() {
        searchedPage.selectFirstProduct();
    }

    @Then("Verify Product Page")
    public void verify_product_page() {
        productPage = new ProductPage(driver);
        productPage.switchNextWindow();
        Assert.assertTrue(productPage.isOnProductPage());
    }

    @When("Add Product to Favorite")
    public void add_product_to_favorite() {
        productPage.addProductToFavorite();
    }

    @And("Enter Favorite Page")
    public void enter_favorite_page() {
        productPage.goToFavoritePage();
    }

    @Then("Verify Favorite Page")
    public void verify_favorite_page() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs("Favoriler - Trendyol"));
        Assert.assertEquals(driver.getTitle(),"Favoriler - Trendyol");
    }

    @When("Check Added Product")
    public void check_added_product() {
        favoritePage = new FavoritePage(driver);
        Assert.assertTrue(favoritePage.checkIfProductAdded());
    }

    @And("Remove Favorite Product")
    public void remove_favorite_product() {
        favoritePage.removeFavoriteProduct(0);
    }

    @And("Check Removed Product")
    public void check_removed_product() {
        Assert.assertTrue(favoritePage.isFavoritePageEmpty());
    }

    @And("Logout")
    public void logout() {
        favoritePage.hoverUserAccount();
        favoritePage.clickLogoutButton();
    }

    @Then("Verify Logout")
    public void verify_logout() throws InterruptedException {
        Assert.assertEquals(homePage.isLoggedOut(), "Giriş Yap");
        driver.close();
        driver.quit();
    }
}
