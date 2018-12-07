package com.syscolabs.assignment_01.pages.myAccount;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class myAccountPage extends BasePage {

    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private  By btnLogin = By.xpath("//a[contains(text(),'Login')]");


    public boolean isLoginbuttonDisplayed() {return  syscoLabUIOgm.isDisplayed(btnLogin);}
    public void clickLoginButton() {
        try {
            syscoLabUIOgm.click(btnLogin);
        }catch (Exception e)
        {
            LoggerUtil.logERROR("unable to click Login button ",e);
        }
        }


    public static void loadMyAccountPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }




    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }
}
