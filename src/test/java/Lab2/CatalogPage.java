package Lab2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.FindBy;

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

    void setFilter(){
        //((Locatable)filterBlue).getLocationOnScreenOnceScrolledIntoView();
        filterBlue.click();
        filterEleven.click();
    }
    WebElement getCheckString(){ return checkString;}

    void seeSomeClothes(){
        someClothes.click();
    }

    WebElement getCheckClothesString(){ return checkClothesString;}
}
