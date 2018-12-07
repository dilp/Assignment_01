package com.syscolabs.assignment_01.functions;

import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.pages.LoginPage.LoginPage;
import com.syscolabs.assignment_01.utils.LoggerUtil;

public class Login extends BasePage {

    public static LoginPage objLoginPage = new LoginPage();
    static boolean flag = false;

    public static void enterInvalidEmailFormat(String email) {
        objLoginPage.setEmail(email);
        objLoginPage.clickLoginButton();
    }

    public static boolean clickOnLoginWithEmptyEmailAndPassword(String message) {

        objLoginPage.clickLoginButton();
        if (objLoginPage.getEmailError().toLowerCase().contains(message) && objLoginPage.getPasswordError().toLowerCase().contains(message)) {
            flag = true;
        }
        return flag;
    }

    public static void loginwithCorrectUserNameAndPassword(String UserName, String Password) {
        try {
            objLoginPage.clickLoginlink();
            objLoginPage.setEmail(UserName);
            objLoginPage.setPassword(Password);
            objLoginPage.clickLoginButton();
            objLoginPage.waitForHomePage();
        } catch (Exception e) {
            LoggerUtil.logERROR("failed to login with correct username password", e);
        }
    }
}
