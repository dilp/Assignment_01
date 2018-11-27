package com.syscolabs.assignment_01.pages.LandingPage;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class LandingPage {
    protected static SyscoLabUI syscoLabUIOgm;
    private By lnkLogin = By.xpath("//a[contains(text(),'Login')]");


    public static void navigateToLandingPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }

    public void navigateToMyAccountPage() {syscoLabUIOgm.click(lnkLogin);}
}


