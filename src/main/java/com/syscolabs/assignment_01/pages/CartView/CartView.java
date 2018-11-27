package com.syscolabs.assignment_01.pages.CartView;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartView {

    protected static SyscoLabUI syscoLabUIOgm;

  //  public void clickViewCartButton(){syscoLabUIOgm.click(btnViewCart);}
  private By btnClose = By.xpath("//*[@class='svg-icon -cross' and @xpath='1']");
  private By lblMessageForEmptyCart = By.xpath("//p[contains(text(),'There are no items in the shopping cart.')]");
  private  By lblPrice = By.xpath("//div[@class='price-container']");
  private  By lblProductName = By.xpath("//a[@class ='alink -plain']");
  private  By btnProceedToCheckout = By.xpath("//button[@title='Proceed To Checkout']");





  public void clickViewCartButton(){syscoLabUIOgm.click(btnClose);}
  public boolean isCartEmpty() {return  syscoLabUIOgm.isDisplayed(lblMessageForEmptyCart);}
  public String getPrice() {return  syscoLabUIOgm.getText(lblPrice);}
  public String getNameOfItem() {return syscoLabUIOgm.getText(lblProductName);}
  public void clickOnProceedToCheckout() {syscoLabUIOgm.click(btnProceedToCheckout);}








}
