package com.syscolabs.assignment_01.functions;

import com.syscolabs.assignment_01.common.Constants;
import com.syscolabs.assignment_01.pages.LoginPage;
import com.syscolabs.assignment_01.pages.myAccount.myAccountPage;
import com.syscolabs.assignment_01.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyAccount {

    public static myAccountPage myAccountPage = new myAccountPage();


 /*   public static void loadMyAccountPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            myAccountPage.loadMyAccountPage(capabilities, Constants.APP_URL);
        } else {
            myAccountPage.loadMyAccountPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }*/

    public static boolean isLoginButtonExists() throws  Exception{
        return myAccountPage.isLoginbuttonDisplayed();
    }

    public static void navigateToLoginPage() {myAccountPage.clickLoginButton();}

    public static void quiteDriver() {
        myAccountPage.quitDriver();
    }

}
