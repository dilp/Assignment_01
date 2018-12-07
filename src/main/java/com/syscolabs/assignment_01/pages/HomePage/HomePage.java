package com.syscolabs.assignment_01.pages.HomePage;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolabs.assignment_01.common.Constants;
import com.syscolabs.assignment_01.pages.BasePage;
import com.syscolabs.assignment_01.utils.DriverSetUpUtil;
import com.syscolabs.assignment_01.utils.LoggerUtil;
import javassist.bytecode.stackmap.BasicBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.List;

public class HomePage extends BasePage {

    private By lblUserName = By.xpath("//a[text()='My account']/../../li[2]/span/span");
    private By btnViewCart = By.xpath("//a[@class='button']");
    //prodcut detail page
    private By lblSucessMessage = By.xpath("//div[@data-bind='html: message.text, afterRender: $parent.addExtraClassName($element)']");
    // start element on secure chekout page page
    private By txtbxFristName = By.xpath("(//input[@name='firstname'])[1]");
    private By txtbxLastName = By.xpath("(//input[@name='lastname'])[1]");
    private By btnContinue = By.xpath("//button[@title='Continue']");
    private By txtbxPhoneNumber = By.xpath("(//input[@name='telephone'])[1]");
    private By txtbxPostalCode = By.xpath("(//input[@name='postcode'])[1]");
    // private By txtDropDownValue = By.xpath("//div[@class='field _required -active _error']/div/ul/li[1]");
    private By lableDiliveryOption = By.xpath("//div[@class='table-checkout-shipping-method']");
    private By checkBoxAuthorityToleave = By.xpath("//div[@class='choice field']//label[@class='label']");
    private By txtAddressLine1 = By.xpath("//div[@name='shippingAddress.street.0']//input");
    private By dropDownDiliveryMethod = By.xpath("//select[@name='delivery_notes']");
    // get validation message click on continue without data on secure checkout
    private By lblRequredFeild = By.xpath("By.xpath(\"//div[@data-role=\\\"checkout-messages\\\"]//div[contains(text(),'Unable to save shipping information. Please check input data.')]\");");
    //credict cards feilds
    private By lableCreditCardOptionLable = By.xpath("//ul[@class='credit-card-types types-list']");
    private By txtCardNumber = By.xpath("(//span[contains(text(),'Card Number')])[1]");
    private By txtExpirationMonth = By.xpath("//input[@id='expiration-month']");
    private By txtExpirationYear = By.xpath("//input[@id='expiration-year']");
    private By txtCvv = By.xpath("//input[@id='cvv']");
    //creditt card product infomation
    private By lblProductNameOnCredictCardPage = By.xpath("//div[@class='opc-product-name']");
    private By lblCartPriceInCreditCardPage = By.xpath("//span[@class='cart-price']");


    public String getUserName() {
        return syscoLabUIOgm.getText(lblUserName);
    }

    public void clickViewCartButton() {

        try {
            syscoLabUIOgm.waitTillElementLoaded(btnViewCart);
            syscoLabUIOgm.click(btnViewCart);
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click view button ", e);
        }
    }

    public void clickProductPage(String productName) {
        try {
            syscoLabUIOgm.click(By.xpath("//a[@title='" + productName + "']"));
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click remove item button ", e);
        }


    }

    public void clickSubProduct(String subProductName) {
        try {
            syscoLabUIOgm.click(By.xpath("//a[@title='" + subProductName + "']"));

        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click continue button ", e);
        }
    }

    public void clickOnproductOnThePage(String Productname) {
        try {

            syscoLabUIOgm.waitTillElementLoaded(By.xpath("//a[@title='" + Productname + "']"));
            syscoLabUIOgm.scrollToElement(By.xpath("//a[@title='" + Productname + "']"));
            syscoLabUIOgm.click(By.xpath("//a[@title='" + Productname + "']"));
        } catch (Exception e) {
            LoggerUtil.logERROR(Constants.ERROR, e);
        }

    }

    public void clickOnTheProductSize() {
        syscoLabUIOgm.waitTillElementLoaded(By.xpath("//div[contains(@class,'active')]/div[not(contains(@class,'outofstock'))][contains(@class,'swatch-option')]"));
        int itemNumber = 0;
        List<WebElement> listOfActiveSize = syscoLabUIOgm.findElements(By.xpath("//div[contains(@class,'active')]/div[not(contains(@class,'outofstock'))][contains(@class,'swatch-option')]"));


        if (!listOfActiveSize.isEmpty()) {
            if (listOfActiveSize.get(itemNumber).isEnabled() && listOfActiveSize.get(itemNumber).isDisplayed()) {
                try {
                    listOfActiveSize.get(itemNumber).click();
                } catch (Exception e) {
                    LoggerUtil.logERROR(Constants.ERROR, e);
                }
            } else {
                itemNumber++;
            }
        }
    }

    public String getProductAddedMessage() {
        try {
            syscoLabUIOgm.waitTillElementLoaded(lblSucessMessage);
            ;
            LoggerUtil.logINFO("get the product added message ");
        } catch (Exception e) {
            LoggerUtil.logERROR("Product Adding message Getting failed", e);
        }
        return syscoLabUIOgm.getText(lblSucessMessage);
    }

    //::::::::::::::::::::::::::::::::::::::::::
    public String getFirstName() {
        return syscoLabUIOgm.getAttribute(txtbxFristName, "value");
    }

    public String getLastName() {
        return syscoLabUIOgm.getAttribute(txtbxLastName, "value");
    }

    public void clickOnContinueButton() {
        try {

            syscoLabUIOgm.click(btnContinue);
            LoggerUtil.logINFO("Click on the contiune button from the shopping cart");

        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click continue button ", e);

        }
    }

    public boolean isContinueButtonDispslyed() {
        return syscoLabUIOgm.isDisplayed(btnContinue);
    }

    //;;;;;;;;;;;;;end of secure checkout page


    public boolean IsErrorMessageDispslyed() {
        boolean flag = false;
        try {
            flag = syscoLabUIOgm.isDisplayed(lblRequredFeild);

        } catch (Exception e) {
            LoggerUtil.logERROR("unable to see validation message ", e);
        }

        return flag;
    }

    public void enterPostalCode(String postalCode) {

        try {
            syscoLabUIOgm.sendKeys(txtbxPostalCode, postalCode);
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to send the 200 postal code", e);
        }
    }

    public void clickOnTheDropDownValueOfPostalCode() {
        try {
            syscoLabUIOgm.sleep(2);
            syscoLabUIOgm.sendKeysWithoutClear(txtbxPostalCode, Keys.chord(Keys.ARROW_DOWN));
            syscoLabUIOgm.sendKeysWithoutClear(txtbxPostalCode, Keys.chord(Keys.ENTER));
            syscoLabUIOgm.sleep(2);
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click postal code dropdown value  ", e);
        }
    }

    public boolean isDiliveryOptionAvailable() {
        boolean flag = false;
        try {
            syscoLabUIOgm.scrollToElement(lableDiliveryOption);
            flag = syscoLabUIOgm.isDisplayed(lableDiliveryOption);
        } catch (Exception e) {
            LoggerUtil.logERROR("unable to click postal code dropdown value  ", e);
        }
        return flag;
    }

    public void enterTelephoneNumber(String teleNumber) {
        try {
            syscoLabUIOgm.scrollToElement(txtbxPhoneNumber);
            syscoLabUIOgm.sendKeys(txtbxPhoneNumber, teleNumber);

        } catch (Exception e) {
            LoggerUtil.logERROR("unable to enter telepene number  ", e);
        }
    }

    public void selectAuthorityToLeave() {
        try {
            syscoLabUIOgm.scrollToElement(checkBoxAuthorityToleave);
            if (syscoLabUIOgm.isDisplayed(checkBoxAuthorityToleave) == true) {
                syscoLabUIOgm.click(checkBoxAuthorityToleave);
            }
        } catch (Exception e) {
            LoggerUtil.logERROR("unaable to selecet Authority to leave text box ", e);
        }
    }

    public void enterAddressLine1() {
        try {
            syscoLabUIOgm.scrollToElement(txtAddressLine1);
            syscoLabUIOgm.sendKeys(txtAddressLine1, "test");

        } catch (Exception e) {
            LoggerUtil.logERROR("unaable to selecet Authority to leave text box ", e);
        }
    }

    public void selectDeleverymothod() {
        syscoLabUIOgm.scrollToElement(dropDownDiliveryMethod);
        syscoLabUIOgm.click(dropDownDiliveryMethod);
        syscoLabUIOgm.sendKeys(dropDownDiliveryMethod, Keys.ARROW_DOWN);
        syscoLabUIOgm.sendKeys(dropDownDiliveryMethod, Keys.ENTER);
    }

    //page credit card
    public void selectCreditCardOption() {
        syscoLabUIOgm.click(lableCreditCardOptionLable);
    }

    //credit card infomation
    public boolean isCardNumberTextBoxDisplayed() {
        syscoLabUIOgm.scrollBottom();
        return syscoLabUIOgm.isDisplayed(txtCardNumber);
    }


    public String getproductNameFromtheCreditCardPage() {
        return syscoLabUIOgm.getText(lblProductNameOnCredictCardPage);
    }

    public String getProductPriceFromCreditCardPage() {
        return syscoLabUIOgm.getText(lblCartPriceInCreditCardPage);
    }
}
