package com.syscolabs.assignment_01.functions;

import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.pages.HomePage.HomePage;

public class Home extends BasePage {
    public  static HomePage objHomePage = new HomePage();

    public static String  getUserName() {
        System.out.println(objHomePage.getUserName());
        return  objHomePage.getUserName();
    }

    public static  void navigateToProductPage(String productName, String subProductName) {
        objHomePage.clickProductPage(productName);
        objHomePage.clickSubProduct(subProductName);
    }

    public  static  void navigateTofirstProductOfthePage(String name) {

        objHomePage.clickOnproductOnThePage(name);
    }

    public  static  void  clickOnTheProductSize() {
        objHomePage.clickOnTheProductSize();

    }

    public  static  void  clickOnContinueButton() {
        objHomePage.clickOnContinueButton();
    }

    public  static  boolean isContinueButtonDisplayed()
    {
        return  objHomePage.isContinueButtonDispslyed();
    }
    //:::::::::::::::::::::::::::::
    //Start checkout page validation
    public static boolean isFirstNameCorrect(String firstName)
    {
        boolean flag =false;
       if(objHomePage.getFirstName().contains(firstName))
       {
           flag = true;
       }
           return flag;
    }

    public static boolean isLastNameCorrect(String lastName)
    {
        boolean flag =false;
    if(objHomePage.getLastName().contains(lastName))
    {
       flag =true;
    }
    return  flag;
    }


    public  static boolean isSuccessfulMessageDisplayed(String msg1,String msg2 )
    {
        boolean flag = false;
       if(objHomePage.getProductAddedMessage().toLowerCase().contains(msg1.toLowerCase())&& objHomePage.getProductAddedMessage().toLowerCase().contains(msg2.toLowerCase()))
       {
           flag = true;
       }
        return  flag;
    }

    public static boolean isErrorMessageDispslyedforClickContinueWithoutMandotryFeilds() {
        boolean flag = false;
        if(objHomePage.IsErrorMessageDispslyed()==true)
        {
            flag = true;
        }
        return  flag;
    }


    public static void selectPostalCode(String postalCode) {
        objHomePage.enterPostalCode(postalCode);
        objHomePage.clickOnTheDropDownValueOfPostalCode();
    }

    public static boolean isDiliveryOptionAvailable() {
       return objHomePage.isDiliveryOptionAvailable();

    }

    public static void enterTeleponeNumber(String telephoneNumber) {
        objHomePage.enterTelephoneNumber(telephoneNumber);
    }

    public static void selectAuthorityToleaveCheckBox() {
        objHomePage.selectAuthorityToLeave();;
        }

        public static void enterAddressLine1() {
        objHomePage.enterAddressLine1();
        }

        public static void selectDeleverymethod() {
        objHomePage.selectDeleverymothod();

    }

    public static void selectPaymentTypeCreditCard() {
        objHomePage.selectCreditCardOption();
        }

        // credit card infomation
    public static boolean isCreditCardinformationAvailable() {
        boolean flag =false;

        if(objHomePage.isCardNumberTextBoxDisplayed())
        {
            flag=true;
        }
        return flag;
    }

    public static  String getProductNameFromTheCreditCardPage() {
        return objHomePage.getproductNameFromtheCreditCardPage();
    }

    public static  String getProductPriceFromCreditCardPage() {
        return  objHomePage.getProductPriceFromCreditCardPage();

    }
}
