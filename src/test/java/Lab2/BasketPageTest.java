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
public class BasketPageTest {

    WebDriver driver;
    BasketPage page;

    @Before    //создать WebDriver, перейти на сайт Urban Threads и дождаться загрузки страницы
    public void openSite()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://1001dress.ru/personal/cart/");
        page= PageFactory.initElements(driver, BasketPage.class);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("корзина");
            }
        });
    }

    @Test
    public void testGpToShop()
    {
        page.goToShop();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                System.out.println(d.getTitle().toLowerCase());
                return d.getTitle().toLowerCase().contains("1001 dress");
            }
        });
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("1001 dress"));
    }

    @Test
    public void testGoToAccount()
    {
        page.goToAccount();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("личный кабинет");
            }
        });
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("личный кабинет"));
    }

    @After
    public void closeSite()
    {
        driver.quit();
    }

}
