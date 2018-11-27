package com.syscolabs.assignment_01.tests;

import com.syscolabs.assignment_01.data.LoginData;
import com.syscolabs.assignment_01.functions.Home;
import com.syscolabs.assignment_01.functions.Login;
import com.syscolabs.assignment_01.functions.Login1;
import com.syscolabs.assignment_01.functions.MyAccount;
import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.utils.ExcelUtil;
import com.syscolabs.assignment_01.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase {

    String invalidEmail = "abfdfdfdfsds";
    String txtValidationMessage = "Please enter a valid email address (Ex: johndoe@domain.com).";
    String txtEmptyMessage = "THIS IS A REQUIRED FIELD.";
    String userName = "williamjacob802@gmail.com";
    String passWord = "0okmNHY6" ;
    String userFromWeb = "william jacob";


    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "My account - Validate My Account Page");
    }

    @Test(priority = 1)
    public void testMyAccountPage() throws Exception {


        BasePage.loadMyAccountPage();
        Assert.assertTrue(MyAccount.isLoginButtonExists());


    }

   @Test(priority = 2)
    public void  testEmail() {

        MyAccount.navigateToLoginPage();
        Login1.enterInvalidEmailFormat(invalidEmail);
        Assert.assertTrue(Login1.isEmailValidationErrorExsist(txtValidationMessage));
    }


    @Test(priority = 3)
    public void testRequredFeildValidation() {
        MyAccount.navigateToLoginPage();
        Login1.clickOnLoginWithEmptyEmailAndPassword(txtEmptyMessage);
    }


    @Test(priority = 4)
    public  void testVerifyUserName() {
        Login1.loginwithCorrectUserNameAndPassword(userName,passWord);
        Assert.assertEquals(Home.getUserName().toLowerCase(),userFromWeb);
       // Home.getNumbetOfUsers();
        Home.deleteItemsOnCart();
        Home.goToHome();
        Home.navigateToProductPage("Womens","adidas");
        Home.navigateTofirstProductOfthePage("ADIDAS ULTRABOOST WOMENS CORE BLACK");

        // adding product to cart
        Home.addProductToCart();
        //get the name and price an
        String cartPrice = Home.getPriceFromCartPage();
        String CartProductName = Home.getProductNameFromTheCartPage();
        Assert.assertTrue(Home.isSuccessfulMessageDisplayed("You added"," to your shopping cart."));

        // go to shopping cart to validate added item
        Home.navigteToShoppingCart();

        Assert.assertTrue(Home.isProductNameequlas());
        Assert.assertTrue(Home.isPriceequals());

        // then proceed to check out
        Home.clickOnProceedToCheckout();







    }
/*
    @Test(priority = 5)
    public void  testSelectProduct{


    }*/
     @AfterClass
     public  void tearDown() {
       MyAccount.quiteDriver();
  }

}
