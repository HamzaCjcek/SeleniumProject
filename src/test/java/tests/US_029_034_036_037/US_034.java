package tests.US_029_034_036_037;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Merchant_Dashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class US_034 extends TestBaseRapor {
    Merchant_Dashboard merchant_dashboard = new Merchant_Dashboard();

    @Test
    public void TC_01() {

        extentTest=extentReports.createTest("Delivery page elements test");

        //merchantStart
        ReusableMethods.merchantLogin();

        extentTest.info("Logged in merchant page");

        //Click the order type in the dashboard menu
        merchant_dashboard.orderTypeLink.click();

        extentTest.info("order type link is clicked");

        //Click the delivery link
        merchant_dashboard.deliveryLink.click();

        extentTest.info("delivery link is clicked");

        //Verify that setting link is visible
        Assert.assertTrue(merchant_dashboard.settingText.isDisplayed());

        extentTest.info("verified the setting link is displayed");

        //Close the browser
        Driver.closeDriver();

        extentTest.info("Closed the page");

        extentTest.pass("passed");


    }

    @Test
    public void TC_02() {

        extentTest=extentReports.createTest("Settings update test");

        Merchant_Dashboard merchant_dashboard = new Merchant_Dashboard();

        //merchantStart
        ReusableMethods.merchantLogin();

        extentTest.info("Logged in merchant page");

        //Click the order type in the dashboard menu
        merchant_dashboard.orderTypeLink.click();

        extentTest.info("order type link is clicked");

        //Click the delivery link
        merchant_dashboard.deliveryLink.click();

        extentTest.info("delivery link is clicked");


        //Click the "Enabled Opt in for no contact delivery" checkbox

        merchant_dashboard.checkbox1.click();

        extentTest.info("Clicked the checkbox1");

        //Click the "Free Delivery On First Order" checkbox

        merchant_dashboard.checkbox2.click();

        extentTest.info("Clicked the checkbox2");

        //Verify that Fixed charge dropdownmenu should be selectable

        Select select = new Select(merchant_dashboard.fixedchargeDdm);
        select.selectByVisibleText("Fixed Charge");

        extentTest.info("Fixed charge dropdownmenu is selected");

        //Write  Service fee in the search box
        merchant_dashboard.serviceFeeBox.clear();
        ReusableMethods.wait(1);
        merchant_dashboard.serviceFeeBox.sendKeys("15.00");

        merchant_dashboard.saveButon1.click();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(merchant_dashboard.settingsSavedText.isDisplayed());

        softAssert.assertAll();

        //Assert.assertTrue(merchant_dashboard.settingsSavedText.isDisplayed());

        extentTest.info("Service fee is written in the box");

        //Verify that settings cannot be saved when anything other than requested is entered in the box.
        merchant_dashboard.serviceFeeBox.clear();
        ReusableMethods.wait(1);
        merchant_dashboard.serviceFeeBox.sendKeys("abca");

        merchant_dashboard.saveButon1.click();
        softAssert.assertTrue(merchant_dashboard.errorMessage.isDisplayed());
        softAssert.assertAll();

        //Assert.assertTrue(merchant_dashboard.errorMessage.isDisplayed());

        extentTest.info("negative service fee is written");

        //Close the browser
        Driver.closeDriver();


        extentTest.info("Closed the page");

        extentTest.pass("passed");
    }

    @Test
    public void TC_03() {

        Merchant_Dashboard merchant_dashboard = new Merchant_Dashboard();

        //merchantStart
        ReusableMethods.merchantLogin();

        extentTest.info("Logged in merchant page");

        //Click the order type in the dashboard menu
        merchant_dashboard.orderTypeLink.click();

        extentTest.info("order type link is clicked");

        //Click the delivery link
        merchant_dashboard.deliveryLink.click();

        extentTest.info("delivery link is clicked");


        //Verify that fixed charge is visible and enabled.

        Assert.assertTrue(merchant_dashboard.fixedChargeText.isDisplayed());
        merchant_dashboard.fixedChargeText.click();

        extentTest.info("fixed charge is displayed and enabled.");

        //Close the browser
        Driver.closeDriver();

        extentTest.info("Closed the page");

        extentTest.pass("passed");
    }

    @Test
    public void TC_04() {

        Merchant_Dashboard merchant_dashboard = new Merchant_Dashboard();

        //merchantStart
        ReusableMethods.merchantLogin();
        extentTest.info("Logged in merchant page");

        //Click the order type in the dashboard menu

        merchant_dashboard.orderTypeLink.click();

        extentTest.info("order type link is clicked");

        //Click the delivery link
        merchant_dashboard.deliveryLink.click();

        extentTest.info("delivery link is clicked");


        //Fill out the required boxes on the page

        merchant_dashboard.fixedChargeText.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(merchant_dashboard.priceBox).
                sendKeys("24").
                sendKeys(Keys.TAB).
                sendKeys("45").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).perform();

        extentTest.info("Filled the required boxes");

        //Click the save button
        merchant_dashboard.fixedChargeSaveButon.click();

        extentTest.info("clicked the save button");

       //Verify that "Succesfully updated" text is visible
        Assert.assertTrue(merchant_dashboard.succesfullyupdatedalert.isDisplayed());

        extentTest.info("Succesfully updated is displayed");

        //Close the browser
        Driver.closeDriver();

        extentTest.info("Closed the page");

        extentTest.pass("passed");


    }
}