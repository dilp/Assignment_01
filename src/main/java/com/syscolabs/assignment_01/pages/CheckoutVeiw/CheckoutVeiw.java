package com.syscolabs.assignment_01.pages.CheckoutVeiw;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutVeiw {

    protected static SyscoLabUI syscoLabUIOgm;

    private By lblName = By.xpath("//span[@class='name']");
    private By btnContinue = By.xpath("//button[@title='Continue']");
    private By txtboxPostCode =  By.id("YDLN0YG");
    private By dropDownDiliveryMethod = By.xpath("//select[@id='QU45LYW']");



    public String getNameOfUser() {return syscoLabUIOgm.getText(lblName);}
    public void clickContinue() { syscoLabUIOgm.click(lblName);}
    public void  enterPosrCode(String postCode) { syscoLabUIOgm.sendKeys(txtboxPostCode,postCode);}


    public boolean checkOptions(String[] expected){

        WebElement select = syscoLabUIOgm.findElement(By.id("QU45LYW"));
        List<WebElement> options = select.findElements(By.xpath(".//option"));

        int k = 0;
        for (WebElement opt : options){
            if (!opt.getText().equals(expected[k])){
                return false;
            }
            k = k + 1;
        }
        return true;
    }



}
