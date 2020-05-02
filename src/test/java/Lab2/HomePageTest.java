package Lab2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@Category(SmokeTest.class)
public class HomePageTest {
    WebDriver driver;
    HomePage page;

    @Before
    public void openSite()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://1001dress.ru/");
        page= PageFactory.initElements(driver, HomePage.class);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("1001");
            }
        });
    }

    @Test
    public void testSearchDress()
    {
        page.searchDress();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("каталог");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("каталог"));
    }

    @Test
    public void testClickOnCoat()
    {
        page.clickOnCoat();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("пальто");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("пальто", page.getPageHeadline());
    }

    @After
    public void closeSite()
    {
        driver.quit();
    }
}
