package com.syscolabs.assignment_01.tests;

import com.syscolabs.assignment_01.data.LoginData;
import com.syscolabs.assignment_01.functions.*;
import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.pages.HomePage.HomePage;
import com.syscolabs.assignment_01.utils.ExcelUtil;
import com.syscolabs.assignment_01.utils.LoggerUtil;
import com.syscolabs.assignment_01.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase {

    String userFromWeb = "william jacob";
    String errorMessage = "this is a required field.";
    String productCategory ="Womens";
    String ProductBrand= "adidas";
    String ProductName = "ADIDAS ULTRABOOST WOMENS CORE BLACK";
    String postalcode = "2000";
    String telephoneNumber = "0718217615";



 /*   @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "My account - Validate My Account Page");
    }

*/


    @Test(priority = 1)
    public  void testVerifyUserName() {
        try {

            Assert.assertEquals(Home.getUserName().toLowerCase(),userFromWeb);
            ShoppingCart.deleteItemsOnCart();
            ShoppingCart.goToHome();
            Home.navigateToProductPage(productCategory,ProductBrand);
            Home.navigateTofirstProductOfthePage(ProductName);

            // adding product to cart
            Home.clickOnTheProductSize();
            ShoppingCart.clickAddTocartButton();
            //get the name and price an
            String cartPrice = ShoppingCart.getPriceFromCartPage();
            String CartProductName = ShoppingCart.getProductNameFromTheCartPage();
            Assert.assertTrue(Home.isSuccessfulMessageDisplayed("You added"," to your shopping cart."));
            // go to shopping cart to validate added item
            ShoppingCart.navigteToShoppingCart();

            Assert.assertTrue(ShoppingCart.isProductNameequlas());
            Assert.assertTrue(ShoppingCart.isPriceequals());

            // then proceed to check out
            ShoppingCart.clickOnProceedToCheckout();

            Assert.assertTrue(Home.isFirstNameCorrect("william"));
            Assert.assertTrue(Home.isLastNameCorrect("jacob"));

            Home.clickOnContinueButton();
       //    Assert.assertTrue(Home.isErrorMessageDispslyedforClickContinueWithoutMandotryFeilds());
           Home.selectPostalCode(postalcode);
            Home.enterAddressLine1();
           Assert.assertTrue(Home.isDiliveryOptionAvailable());

           Home.enterTeleponeNumber(telephoneNumber);
           Home.selectAuthorityToleaveCheckBox();
           Home.selectDeleverymethod();

            Home.clickOnContinueButton();
            Home.selectPaymentTypeCreditCard();
            Home.isCreditCardinformationAvailable();

            // verify prduct name
            Assert.assertEquals(Home.getProductNameFromTheCreditCardPage(),CartProductName);
            Assert.assertEquals(Home.getProductPriceFromCreditCardPage(),cartPrice);






        }catch (Exception e)
        {
            LoggerUtil.logERROR("failed",e);
        }






    }

    @Test(priority = 5)
    public void  testSelectProduct(){


    //Assert.assertTrue(Home.isContinueButtonDisplayed());


    }
     @AfterClass
     public  void tearDown() {
       MyAccount.quiteDriver();
  }

}
