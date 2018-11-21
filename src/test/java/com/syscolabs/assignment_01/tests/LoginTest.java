package com.syscolabs.assignment_01.tests;


import com.syscolabs.assignment_01.data.LoginData;
import com.syscolabs.assignment_01.functions.Login;
import com.syscolabs.assignment_01.utils.ExcelUtil;
import com.syscolabs.assignment_01.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        // Sample way to retrive data from excel
        LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Login.loadLoginPage();
        Login.quiteDriver();

    }
}