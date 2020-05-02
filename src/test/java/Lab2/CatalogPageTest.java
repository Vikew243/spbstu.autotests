package Lab2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@Category(SmokeTest.class)
public class CatalogPageTest {

    WebDriver driver;
    CatalogPage page;

    @Before    //создать WebDriver, перейти на сайт Urban Threads и дождаться загрузки страницы
    public void openSite()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://1001dress.ru/komplekty");
        page= PageFactory.initElements(driver, CatalogPage.class);
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("комплекты");
            }
        });
    }

    @Test
    public void testFilter()
    {
        //driver.execute_script("window.scrollTo(0, Y)")
        ((JavascriptExecutor)driver).executeScript("scroll(0,900)");
        page.setFilter();
        ((JavascriptExecutor)driver).executeScript("scroll(0,-900)");
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                //System.out.println(page.getCheckString().getText());
                return (page.getCheckString().getText().toLowerCase().contains("комплекты цвет голубой 11"));
            }
        });
        Assert.assertTrue(page.getCheckString().getText().toLowerCase().contains("комплекты цвет голубой 11"));
    }

    @Test
    public void testClothesClick()
    {
        page.seeSomeClothes();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (d.getTitle().toLowerCase().contains("блуза белая"));
            }
        });
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("блуза белая"));
    }

    @After
    public void closeSite()
    {
        driver.quit();
    }

}
