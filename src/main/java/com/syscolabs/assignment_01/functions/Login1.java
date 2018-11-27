package com.syscolabs.assignment_01.functions;

import com.syscolabs.assignment_01.pages.LoginPage1.LoginPage1;
import com.syscolabs.assignment_01.pages.myAccount.myAccountPage;

public class Login1 {

    public static LoginPage1 objLoginPage = new LoginPage1();
    static boolean flag = false;

public static void enterInvalidEmailFormat(String email) {
    objLoginPage.setEmail(email);
    objLoginPage.clickLogin();
}

public static boolean  clickOnLoginWithEmptyEmailAndPassword(String message)
{

    objLoginPage.clickLogin();
    if(objLoginPage.getEmailError().toLowerCase().contains(message) && objLoginPage.getPasswordError().toLowerCase().contains(message))
    {
         flag =true;
    }
return  flag;

}

public static void loginwithCorrectUserNameAndPassword(String UserName,String Password)
{
    objLoginPage.setEmail(UserName);
    objLoginPage.setPassword(Password);
    objLoginPage.clickLogin();
    objLoginPage.waitForHomePage();


}


public static  boolean isEmailValidationErrorExsist(String ErrorMessage ){
   return objLoginPage.getEmailError().toLowerCase().contains(ErrorMessage.toLowerCase());

}

}
