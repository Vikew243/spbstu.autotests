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

public class HomePage {

    @FindBy(css=".input-search-kwd")
    WebElement searchBox;

    @FindBy(css=".btn-action-search")
    WebElement searchButton;

    @FindBy(css=".header__subnav > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")
    WebElement coat;

    @FindBy(css="h1.section__heading")
    WebElement headline;

    WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Given("^Open home page$")
    public void openHomePage() {
        driver.get("https://1001dress.ru/");
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("1001");
            }
        });
    }

    @When("^Search word dress$")
    public void searchDress()
    {
        searchBox.sendKeys("dress");
        searchButton.click();
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("каталог");
            }
        });
    }

    @Then("^Verify search results$")
    public void verifyPageHeadline(){
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("каталог"));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @When("^Go to coat category$")
    public void goToCoatCategory() {
        coat.click();
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("пальто");
            }
        });
    }

    @Then("^Verify category results$")
    public void verifyCategoryResults() {
        Assert.assertEquals("пальто", headline.getText().toLowerCase());
    }
}
