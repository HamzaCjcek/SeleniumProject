package tests.US_029_034_036_037;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Merchant_Dashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_029 extends TestBaseRapor {

    Merchant_Dashboard  merchant_dashboard=new Merchant_Dashboard();


    @Test
    public void TC_01(){


        extentTest=extentReports.createTest("Completed orders list test");

        //merchantStart
        ReusableMethods.merchantLogin();

        extentTest.info("Logged in merchant page");

        //Click the Orders link  in the Dashboard menu
        merchant_dashboard.ordersLink.click();

        extentTest.info("orders link is clicked");

        //Click the Completed link
        merchant_dashboard.completedLink.click();

        extentTest.info("completed link is clicked");

        //Verify that "Completed Today" text is visible on the page.
        Assert.assertTrue(merchant_dashboard.completedText.isDisplayed());

        extentTest.info("Completed Today text is displayed");

        //Verify that completed today orders list is displayed

        List<WebElement>completedOrdersList=merchant_dashboard.completedtodayOrdersList;

        for (WebElement eachElement:completedOrdersList
             ) {

            System.out.println(eachElement.getText());
        }
        extentTest.info("Completed today orders are verified");

        //Close the browser
        Driver.closeDriver();

        extentTest.info("Closed the page");

        extentTest.pass("passed");
    }
     @Test
     public void TC_02(){

         extentTest=extentReports.createTest("Verified the dropdown menus are seclected");

         Merchant_Dashboard  merchant_dashboard=new Merchant_Dashboard();

         //merchantStart
         ReusableMethods.merchantLogin();


         extentTest.info("Logged in merchant page");

         //Click the Orders link  in the Dashboard menu.
         merchant_dashboard.ordersLink.click();

         extentTest.info("orders link is clicked");

         //Click the Completed link
         merchant_dashboard.completedLink.click();

         extentTest.info("completed link is clicked");


         //Choose dinein option in order type menu

         Select select=new Select(merchant_dashboard.orderTypeDdm);
         select.selectByVisibleText("Dinein");

         extentTest.info("Choosed dinein option.");

         //Choose paid option in payment status menu

         Select select2=new Select(merchant_dashboard.paymentStatusDdm);
         select2.selectByVisibleText("Paid");

         extentTest.info("Choosed paid option.");

         //Choose order id-descending option in sort menu

         Select select3=new Select(merchant_dashboard.sortDdm);
         select3.selectByValue("order_id_desc");

         extentTest.info("Choosed order id-descending option.");

         //Close the browser
         Driver.closeDriver();

         extentTest.info("Closed the page");

         extentTest.pass("passed");
     }
    @Test
    public void TC_03(){

        extentTest=extentReports.createTest(" Verified the accepting orders button is enabled");

        Merchant_Dashboard  merchant_dashboard=new Merchant_Dashboard();

        //merchantStart
        ReusableMethods.merchantLogin();

        extentTest.info("Logged in merchant page");

        //Click the Orders link  in the Dasboard menu.
        merchant_dashboard.ordersLink.click();

        extentTest.info("orders link is clicked");


        //Click the Completed link
        merchant_dashboard.completedLink.click();

        extentTest.info("completed link is clicked");

        //Verify that Accepting Orders button is enabled
        merchant_dashboard.acceptingOrdersButton.click();

        extentTest.info("verified the accepting orders");

        //Click the cancel button
        merchant_dashboard.cancelButton.click();

        extentTest.info("Clicked the cancel button");

        //Close the browser
        Driver.closeDriver();

        extentTest.info("Closed the page");

        extentTest.pass("passed");

    }
    }
