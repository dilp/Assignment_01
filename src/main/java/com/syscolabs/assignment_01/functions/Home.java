package com.syscolabs.assignment_01.functions;

import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.pages.HomePage.HomePage;

public class Home extends BasePage {
    public  static HomePage objHomePage = new HomePage();

    public static String  getUserName() {
        System.out.println(objHomePage.getUserName());
        return  objHomePage.getUserName();
    }

    public  static  String getNumbetOfUsers() {
      return   objHomePage.getNumberOfItemsInCart();
    }

    public static void deleteItemsOnCart() {
        objHomePage.deleteItemsfromTheList();
    }

    public static void goToHome() {
        objHomePage.clickOnSlogan();
    }

    public static  void navigateToProductPage(String productName, String subProductName) {
        objHomePage.clickProductPage(productName);
        objHomePage.clickSubProduct(subProductName);
    }

    public  static  void navigateTofirstProductOfthePage(String name) {
      //  objHomePage.clickOnFriestProductOfThePage();
        objHomePage.clickOnproductOnThePage(name);
    }

    public static  String getPriceFromCartPage()
    {
       return objHomePage.getPriceofProduct();
    }


    public  static String getProductNameFromTheCartPage()
    {
        return  objHomePage.getNameOfTheProduct();
    }
    public  static  void  addProductToCart() {
        objHomePage.clickOnTheProductSize();
        objHomePage.clickOnAddToCart();
    }

//;;::::::::::::::::::::::::::getting values from side shopping cart

    public  static String  getPriceNameFromShoppingCart()
    {
      return   objHomePage.getPriceFromShoppingCart();
    }

    public  static  String getProductNameFromShoppingCart()
    {
      return   objHomePage.getProductNameFromShoppingCart();
    }

    public  static  void clickOnProceedToCheckout() {
        objHomePage.clickOnProceedToCheckOut();
    }
    //:::::::::::::::::::::::::::::
    //::::::::::::::::::::::::::::::::::;
    //valdate price from both end

    public  static  boolean isPriceequals()
    {
        return objHomePage.getPriceofProduct().equals(objHomePage.getPriceFromShoppingCart());
    }

    public  static  boolean isProductNameequlas()
    {
        return  objHomePage.getNameOfTheProduct().equals(objHomePage.getProductNameFromShoppingCart());
    }
    public  static  void navigteToShoppingCart()
    {
        objHomePage.clickShoppingCart();
    }
    public  static boolean isSuccessfulMessageDisplayed(String msg1,String msg2 )
    {
        boolean flag = false;
       if(objHomePage.getProductAddedMessage().contains(msg1) && objHomePage.getProductAddedMessage().contains(msg2))
       {
           flag = true;
       }
        return  false;
    }
}
