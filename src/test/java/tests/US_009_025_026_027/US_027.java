package tests.US_009_025_026_027;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Merchant_Dashboard;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_027 extends TestBaseRapor {
    Merchant_Dashboard merchant_dashboard=new Merchant_Dashboard();


    @Test
    public void tc2701ordersprocessing(){
        extentTest = extentReports.createTest("orderprocessing  sayfası gorunurlugu testi",
                "orderprocessing sayfasi gorunmeli");
        ReusableMethods.merchantLogin();
        merchant_dashboard=new Merchant_Dashboard();
        merchant_dashboard.ordersLink.click();
        extentTest.info("orders linki tıklandı");
        merchant_dashboard.orderProcessing.click();
        extentTest.info("orderprocessing linki tıklandı");
        Assert.assertTrue( merchant_dashboard.orderprocessindogrulama.isDisplayed());
        extentTest.pass("orderprocessing linki tıklanabildiği dogrulandı");

    }
    @Test
    public void tc2702readyforPickup(){
        extentTest = extentReports.createTest("readyforPickup  butonu gorunurlugu testi",
                "readyforPickup butonu gorunmeli");
        ReusableMethods.merchantLogin();
        merchant_dashboard=new Merchant_Dashboard();
        merchant_dashboard.ordersLink.click();
        merchant_dashboard.orderProcessing.click();
       Assert.assertTrue( merchant_dashboard.readyforpickupbutton.isDisplayed());
       extentTest.pass("readyforPickup  butonu gorunurlugu dogrulandı");
       ReusableMethods.wait(3);
       merchant_dashboard.readyforpickupbutton.click();
       extentTest.info("readyforPickup  butonu");



    }



}
