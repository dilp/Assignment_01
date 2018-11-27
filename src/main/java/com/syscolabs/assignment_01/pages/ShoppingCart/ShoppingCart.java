package com.syscolabs.assignment_01.pages.ShoppingCart;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

public class ShoppingCart {

    protected static SyscoLabUI syscoLabUIOgm;

    private By btnCloseShoppingCart = By.xpath("//div[@class='close']");
    private By lblNoitemsMessage    = By.xpath("//span[contains(text(),'You have no items in your shopping cart.')]");
    private By btnViewCart = By.xpath("//a[@class='button']");

    public void clickViewCartButton(){syscoLabUIOgm.click(btnViewCart);}




}
