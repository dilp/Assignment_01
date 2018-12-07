package com.syscolabs.assignment_01.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import com.syscolabs.assignment_01.common.Constants;
import com.syscolabs.assignment_01.utils.DriverSetUpUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage {

    protected static SyscoLabUI syscoLabUIOgm;
    public BasePage() {

    }

        public static void loadMyAccountPage(Capabilities capabilities, String url) {
            syscoLabUIOgm = new SyscoLabWUI(capabilities);
            syscoLabUIOgm.navigateTo(url);
            syscoLabUIOgm.driver.manage().window().maximize();
        }

    public static void loadMyAccountPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            BasePage.loadMyAccountPage(capabilities, Constants.APP_URL);
        } else {
            BasePage.loadMyAccountPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }
    }

