package Lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    void searchDress()
    {
        searchBox.sendKeys("dress");
        searchButton.click();
    }

    void clickOnCoat()
    {
        coat.click();
    }

    String getPageHeadline()
    {
        return headline.getText().toLowerCase();
    }
}
