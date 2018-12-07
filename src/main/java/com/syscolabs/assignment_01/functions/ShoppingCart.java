package com.syscolabs.assignment_01.functions;


import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.pages.HomePage.HomePage;
import com.syscolabs.assignment_01.pages.ShoppingCart.ShoppingCartPage;

public class ShoppingCart extends BasePage {

    public static ShoppingCartPage objShoppingCartPage = new ShoppingCartPage();


    public  static  String getNumbetOfUsers() {
        return   objShoppingCartPage.getNumberOfItemsInCart();
    }

    public static void deleteItemsOnCart() {
        objShoppingCartPage.deleteItemsfromTheList();
    }

    public static void goToHome() {
        objShoppingCartPage.clickOnSlogan();
    }

    public  static  void navigteToShoppingCart() {
        objShoppingCartPage.clickShoppingCart();
    }
    public  static  void clickOnProceedToCheckout() {
        objShoppingCartPage.clickOnProceedToCheckOut();
    }
    public  static String  getPriceNameFromShoppingCart()
    {
        return   objShoppingCartPage.getPriceFromShoppingCart();
    }
    public  static  String getProductNameFromShoppingCart()
    {
        return   objShoppingCartPage.getProductNameFromShoppingCart();
    }
    //valdate price from both end

    public  static  boolean isPriceequals()
    {
        return objShoppingCartPage.getPriceofProduct().equals(objShoppingCartPage.getPriceFromShoppingCart());
    }

    public  static  boolean isProductNameequlas()
    {
        return  objShoppingCartPage.getNameOfTheProduct().equals(objShoppingCartPage.getProductNameFromShoppingCart());
    }

    public  static void clickAddTocartButton() {
        objShoppingCartPage.clickOnAddToCart();
    }

    public static  String getPriceFromCartPage()
    {
        return objShoppingCartPage.getPriceofProduct();
    }
    public  static String getProductNameFromTheCartPage()
    {
        return  objShoppingCartPage.getNameOfTheProduct();
    }

}
