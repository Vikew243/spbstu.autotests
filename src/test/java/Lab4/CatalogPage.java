package Lab4;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {
    @FindBy(css="#filter_cont_arrFilter_64_1237327324 > label:nth-child(2) > span:nth-child(1)")
    WebElement filterBlue;

    @FindBy(css="#filter_cont_arrFilter_28_3596227959 > label:nth-child(2) > span:nth-child(1)")
    WebElement filterEleven;

    @FindBy(css="h1.section__heading")
    WebElement checkString;

    @FindBy(css="#bx_3966226736_16044_c80764dfaf26ca80162484593ec7c29b > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)")
    WebElement someClothes;

    @FindBy(css=".product__heading")
    WebElement checkClothesString;

    WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    
    @Given("^Open catalog page$")
    public void openCatalogPage() {
        driver.get("https://1001dress.ru/komplekty");
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("комплекты");
            }
        });
    }


    @When("^Set filter$")
    public void setFilter() {
        ((JavascriptExecutor)driver).executeScript("scroll(0,900)");
        filterBlue.click();
        filterEleven.click();
        ((JavascriptExecutor)driver).executeScript("scroll(0,-900)");
        ((JavascriptExecutor)driver).executeScript("scroll(0,-900)");
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                //System.out.println(page.getCheckString().getText());
                return (checkString.getText().toLowerCase().contains("комплекты цвет голубой 11"));
            }
        });
    }

    @Then("^Verify filter results$")
    public void verifyFilterResults() {
        Assert.assertTrue(checkString.getText().toLowerCase().contains("комплекты цвет голубой 11"));
    }

    @When("^Go to some clothes$")
    public void goToSomeClothes() {
        someClothes.click();
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (d.getTitle().toLowerCase().contains("блуза белая"));
            }
        });
    }

    @Then("^Verify clothes results$")
    public void verifyClothesResults() {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("блуза белая"));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
