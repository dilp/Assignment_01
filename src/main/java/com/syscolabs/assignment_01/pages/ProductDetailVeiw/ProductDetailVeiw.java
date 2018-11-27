package com.syscolabs.assignment_01.pages.ProductDetailVeiw;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

public class ProductDetailVeiw {

    protected static SyscoLabUI syscoLabUIOgm;

    private By iconShoppingCart = By.xpath("//span[contains(text(),'Add to Cart')");
    // need to select sice of the show before add

    public String clickAddToCartButton() {return  syscoLabUIOgm.getText(iconShoppingCart);}


}
