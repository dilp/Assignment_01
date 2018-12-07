package com.syscolabs.assignment_01.pages.LoginPage;

import com.syscolabs.assignment_01.pages.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  //  protected static SyscoLabUI syscoLabUIOgm;


    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    //private By btnLogin = By.id("send2");
    private By lblEmailError = By.id("email-error");
    private By lblPassError = By.id("pass-error");
    private By lblMyAccount = By.xpath("//a[@title='My account']");
    private By lnkLogin = By.xpath("//ul[@class='top-links']/li[1]");
    private By btnLogin = By.xpath("//button[@name='send']");

    public void setEmail(String email) {
        syscoLabUIOgm.click(txtEmail);
        syscoLabUIOgm.sendKeys(txtEmail,email);
    }

    public void setPassword (String password) {syscoLabUIOgm.sendKeys(txtPassword,password);}
    public void  clickLoginlink () {syscoLabUIOgm.click(lnkLogin);}
    public void  clickLoginButton() { syscoLabUIOgm.click(btnLogin);}
    public String getEmailError() { return  syscoLabUIOgm.getText(lblEmailError);}
    public String getPasswordError() { return syscoLabUIOgm.getText(lblPassError);}
    public void waitForHomePage() {   syscoLabUIOgm.waitTillElementLoaded(lblMyAccount);}

}
