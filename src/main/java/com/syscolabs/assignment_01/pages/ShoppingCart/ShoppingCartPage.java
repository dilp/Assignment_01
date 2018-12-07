package com.syscolabs.assignment_01.pages.ShoppingCart;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.utils.LoggerUtil;
import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage {

    private By btnCloseShoppingCart = By.xpath("//div[@class='close']");
    private By lblNoitemsMessage    = By.xpath("//span[contains(text(),'You have no items in your shopping cart.')]");
    private By btnViewCart = By.xpath("//a[@class='button']");
    public By lblNumberofItem = By.xpath("//span[@class='value']");
    private By iconShoppingCart = By.xpath("//*[@class='minicart-wrapper']");
    //Cart view
    private By btndeleteItemButton = By.xpath("(//*[@class='svg-icon -cross'])[1]");
    private By btnSlogan = By.xpath("//strong[@class='slogan']");
    // pruice and name details from right handside cart page
    private By lblPricefromShppingcart = By.xpath("//span[@class='minicart-price']");
    private By lblProductNameFromShoppingCart = By.xpath("//a[@class='alink -plain']");
    private By btnProceedToCheckOut = By.xpath("//button[@title='Proceed To Checkout']");
    // product detail veiw add to cart button
    private By btnAddToCart = By.xpath("//button[@title='Add to Cart']");
    private By lblPrice = By.xpath("//span[@class='price-container price-final_price tax weee']");
    private By lblProductName = By.xpath("//span[@class='base']");


    public void clickViewCartButton(){syscoLabUIOgm.click(btnViewCart);}

    public void deleteItemsfromTheList() {

        try {
            // syscoLabUIOgm.click(btnContinue);

            if (syscoLabUIOgm.isDisplayed(lblNumberofItem)) {
                int numberOfItem = Integer.parseInt(syscoLabUIOgm.getText(lblNumberofItem));
                if (numberOfItem > 0) {

                    clickShoppingCart();
                    clickViewCartButton();
                    clickRemoveItemButton();
                    numberOfItem--;

                } else {
                    clickOnSlogan();
                }
            } else {
                clickOnSlogan();
            }
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to delete items from Cart items ", e);
        }
    }

    public String getNumberOfItemsInCart() {
        return syscoLabUIOgm.getText(lblNumberofItem);
    }

    public void clickShoppingCart() {
        syscoLabUIOgm.click(iconShoppingCart);
        syscoLabUIOgm.waitTillElementLoaded(btnProceedToCheckOut);
    }

    public void clickRemoveItemButton() {
        try {
            syscoLabUIOgm.click(btndeleteItemButton);
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click continue button ", e);
        }
    }

    public void clickOnSlogan() {
        try {
            syscoLabUIOgm.click(btnSlogan);
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click on Slogan", e);
        }
    }

    public void clickOnProceedToCheckOut() {
        try {
            syscoLabUIOgm.waitTillElementLoaded(btnProceedToCheckOut);
            if (syscoLabUIOgm.isDisplayed(btnProceedToCheckOut)) {
                syscoLabUIOgm.click(btnProceedToCheckOut);
                //syscoLabUIOgm.waitTillElementLoaded(txtbxFristName);
                syscoLabUIOgm.waitTillElementDisappear(By.xpath("//div[@class='loading-mask']"));
            }
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click on proceed to checkout ", e);
        }
    }

    public String getProductNameFromShoppingCart() {
        return syscoLabUIOgm.getText(lblProductNameFromShoppingCart);
    }

    // ................. get price from shopping cart view
    public String getPriceFromShoppingCart() {
        String lablePrice = null;
        try {

            lablePrice = syscoLabUIOgm.getText(lblPricefromShppingcart);
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click continue button ", e);
        }

        return lablePrice;
    }
    public String getPriceofProduct() {
        return syscoLabUIOgm.getText(lblPrice);
    }

    public void clickOnAddToCart() {

        try {
            syscoLabUIOgm.scrollToElement(btnAddToCart);
            syscoLabUIOgm.click(btnAddToCart);
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click on  clickOnAddToCart() ", e);
        }
    }

    public String getNameOfTheProduct() // product detail veiw
    {
        return syscoLabUIOgm.getText(lblProductName);
    }



}
