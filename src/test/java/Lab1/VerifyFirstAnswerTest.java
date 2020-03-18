package Lab1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class VerifyFirstAnswerTest {

    static WebDriver driver;


    @BeforeClass
    public static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
        //  driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    @Test
    public void TryWebDriver(){

        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("yandex.ru");
        element.submit();

        WebElement element2 = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[8]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/a/div/cite"));
        System.out.println(element2.getText());;
        assertEquals(element2.getText(), "yandex.ru");

    }

    @After
    public void ExitBrowser(){
        driver.quit();
    }
}
