package com.syscolabs.assignment_01.pages.HomePage;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.assignment_01.common.Constants;
import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.utils.DriverSetUpUtil;
import com.syscolabs.assignment_01.utils.LoggerUtil;
import javassist.bytecode.stackmap.BasicBlock;
import org.openqa.selenium.By;

import java.sql.Driver;

public class HomePage extends BasePage {

    public   By lblNumberofItem = By.xpath("//span[@class='value']");

    private By iconShoppingCart = By.xpath("//*[@class='minicart-wrapper']");
    //svg-icon-shopping-cart
    private By btnSlogan = By.xpath("//strong[@class='slogan']");
  //  private By btnFristProduct = By.xpath("//span[@class='product-image-container' and @xpath='1']");
    //private By lblUserName = By.id("//span[@class='name']/..");
    private By lblUserName = By.xpath("//a[text()='My account']/../../li[2]/span/span");
    private By btnViewCart = By.xpath("//a[@class='button']");
    //Cart view
    private  By btndeleteItemButton = By.xpath("(//*[@class='svg-icon -cross'])[1]");

    //home page womens
    private  By lnkWomen = By.xpath("//a[@title='Womens']");
    //prodcut detail page
    private  By lblSucessMessage = By.xpath("//div[@data-bind='html: message.text, afterRender: $parent.addExtraClassName($element)']");


    //product detail veiw
    private  By btnSize = By.xpath("//div[@class='swatch-option text'][1]");

    // product detail veiw add to cart button
    private  By btnAddToCart = By.xpath("product-addtocart-button");
    private  By lblPrice = By.xpath("//span[@class='price-container price-final_price tax weee']");
    private  By lblProductName = By.xpath("//span[@class='base']");


    // pruice and name details from right handside cart page
    private  By lblPricefromShppingcart = By.xpath("//span[@class='minicart-price']");
    private  By  lblProductNameFromShoppingCart = By.xpath("//a[@class='alink -plain']");
    private  By btnProceedToCheckOut = By.xpath("//button[@title='Proceed To Checkout']");
   public int numberOfItem;


    public void clickShoppingCart(){syscoLabUIOgm.click(iconShoppingCart);}
    public void clickOnSlogan() {syscoLabUIOgm.click(btnSlogan);}
  //  public void clickOnFriestProductOfThePage() {syscoLabUIOgm.click(btnFristProduct);}
    public void dfdfd() {syscoLabUIOgm.getText(lblUserName);}
    public String getUserName() {return  syscoLabUIOgm.getText(lblUserName); }
    public String getNumberOfItemsInCart () { return  syscoLabUIOgm.getText(lblNumberofItem);}
    public  void clickViewCartButton() {
        syscoLabUIOgm.waitTillElementLoaded(btnViewCart);
        syscoLabUIOgm.click(btnViewCart);
    }
    public void clickRemoveItemButton() { syscoLabUIOgm.click(btndeleteItemButton);}
    public void clickProductPage(String productName) {

        syscoLabUIOgm.click(By.xpath("//a[@title='"+productName+"']"));
    }

    public  void clickSubProduct(String subProductName) {
        syscoLabUIOgm.click(By.xpath("//a[@title='"+subProductName+"']"));}

    public void clickOnproductOnThePage(String Productname){
        try{
            syscoLabUIOgm.scrollToElement(By.xpath("//a[@title='"+Productname+"']"));
            syscoLabUIOgm.click(By.xpath("//a[@title='"+Productname+"']"));
        } catch(Exception e)
        {
            LoggerUtil.logERROR(Constants.ERROR,e);
        }


        System.out.println("this is my tempry location ");

    }

    public void clickOnTheProductSize() {
        syscoLabUIOgm.click(btnSize);
        }

     public  void clickOnAddToCart() {
        syscoLabUIOgm.click(btnAddToCart);
     }

     public  String  getProductAddedMessage()
     {
        return syscoLabUIOgm.getText(lblSucessMessage);
     }

     public  String getPriceofProduct()
     {
         return  syscoLabUIOgm.getText(lblPrice);
     }// this is from detail veiw

// ................. get price from shopping cart view
    public  String getPriceFromShoppingCart()
    {
        return syscoLabUIOgm.getText(lblPricefromShppingcart);
    }

    public  String getProductNameFromShoppingCart()
    {
        return  syscoLabUIOgm.getText(lblProductNameFromShoppingCart);
    }

    public  void clickOnProceedToCheckOut() {
        syscoLabUIOgm.click(btnProceedToCheckOut);
    }

    //::::::::::::::::::::::::::::::::::::::::::
    public  String getNameOfTheProduct() // product detail veiw
    {
        return  syscoLabUIOgm.getText(lblProductName);
    }
    public  void deleteItemsfromTheList( )
    {
        if (syscoLabUIOgm.isDisplayed(lblNumberofItem))
        {
          int  numberOfItem=  Integer.parseInt(syscoLabUIOgm.getText(lblNumberofItem));
            if ( numberOfItem >0)
            {

                clickShoppingCart();
                clickViewCartButton();
                clickRemoveItemButton();
                numberOfItem --;

            }
            else
            {
                clickOnSlogan();
            }
        }
        else {
            clickOnSlogan();
        }

    }

}
