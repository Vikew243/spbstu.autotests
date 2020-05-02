package Lab4;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasketPage {

    @FindBy(css=".bx-sbb-empty-cart-desc > a:nth-child(1)")
    WebElement goToShop;

    @FindBy(css="ul.footer__nav-list:nth-child(3) > li:nth-child(2) > a:nth-child(1)")
    WebElement goToAccount;

    WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Given("^Open basket page")
    public void openBasketPage()
    {
        driver.get("https://1001dress.ru/personal/cart/");
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("корзина");
            }
        });
    }

    @When("^Go to empty$")
    public void goToEmpty() {
        goToShop.click();
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                System.out.println(d.getTitle().toLowerCase());
                return d.getTitle().toLowerCase().contains("1001 dress");
            }
        });
    }

    @Then("^Verify home page$")
    public void verifyHomePage() {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("1001 dress"));
    }

    @When("^Go to account$")
    public void goToAccount() {
        goToAccount.click();
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("личный кабинет");
            }
        });
    }

    @Then("^Verify account page$")
    public void verifyAccountPage() {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("личный кабинет"));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
