package com.syscolabs.assignment_01.pages.LoginPage1;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.pages.LandingPage.LandingPage;
import com.syscolabs.assignment_01.pages.myAccount.myAccountPage;
import org.openqa.selenium.By;

public class LoginPage1 extends BasePage {

  //  protected static SyscoLabUI syscoLabUIOgm;


    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnLogin = By.id("send2");
    private By lblEmailError = By.id("email-error");
    private By lblPassError = By.id("pass-error");
    private By lblMyAccount = By.xpath("//a[@title='My account']");

    public void setEmail(String email) {
        syscoLabUIOgm.click(txtEmail);
        syscoLabUIOgm.sendKeys(txtEmail,email);
    }

    public void setPassword (String password) {syscoLabUIOgm.sendKeys(txtPassword,password);}
    public void  clickLogin () {syscoLabUIOgm.click(btnLogin);}
    public String getEmailError() { return  syscoLabUIOgm.getText(lblEmailError);}
    public String getPasswordError() { return syscoLabUIOgm.getText(lblPassError);}
    public void waitForHomePage() {   syscoLabUIOgm.waitTillElementLoaded(lblMyAccount);}
}
