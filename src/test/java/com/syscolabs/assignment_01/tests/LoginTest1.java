package com.syscolabs.assignment_01.tests;

import com.syscolabs.assignment_01.functions.Login;
import com.syscolabs.assignment_01.functions.MyAccount;
import com.syscolabs.assignment_01.pages.BasePage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest1 {

    String invalidEmail = "abfdfdfdfsds";
    String txtValidationMessage = "Please enter a valid email address (Ex: johndoe@domain.com).";
    String txtEmptyMessage = "THIS IS A REQUIRED FIELD.";


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
    public void testEmail() {

        MyAccount.clickOnTheLoginButton();
        Login.enterInvalidEmailFormat(invalidEmail);
        //Assert.assertTrue(Login.isEmailValidationErrorExsist(txtValidationMessage));
    }

    @Test(priority = 3)
    public void testRequredFeildValidation() {

        Login.clickOnLoginWithEmptyEmailAndPassword(txtEmptyMessage);
    }

    @AfterClass
    public void tearDown() {
        MyAccount.quiteDriver();
    }
}
