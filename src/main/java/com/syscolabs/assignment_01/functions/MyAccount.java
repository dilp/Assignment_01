package com.syscolabs.assignment_01.functions;

import com.syscolabs.assignment_01.pages.myAccount.myAccountPage;

public class MyAccount {

    public static myAccountPage myAccountPage = new myAccountPage();

    public static boolean isLoginButtonExists() throws  Exception{
        return myAccountPage.isLoginbuttonDisplayed();
    }

    public static void clickOnTheLoginButton() {myAccountPage.clickLoginButton();}

    public static void quiteDriver() {
        myAccountPage.quitDriver();
    }

}
