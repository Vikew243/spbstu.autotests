package Lab2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BasketPage {

    @FindBy(css=".bx-sbb-empty-cart-desc > a:nth-child(1)")
    WebElement goToShop;

    @FindBy(css="ul.footer__nav-list:nth-child(3) > li:nth-child(2) > a:nth-child(1)")
    WebElement goToAccount;

    void goToShop(){
        goToShop.click();
    }

    void goToAccount(){
        goToAccount.click();
    }

}
