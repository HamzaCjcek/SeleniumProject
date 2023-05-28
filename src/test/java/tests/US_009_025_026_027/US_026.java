package tests.US_009_025_026_027;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Merchant_Dashboard;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_026 extends TestBaseRapor {

    Merchant_Dashboard merchant_dashboard=new Merchant_Dashboard();

    @Test (groups = "smoke")
    public void tc2601NewordersGorunur(){
        ReusableMethods.merchantLogin();
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("Neworder linki gorunurlugu testi",
                "Neworder linki sayfada gorunmeli");

        merchant_dashboard=new Merchant_Dashboard();
        extentTest.info("Merchant sayfası acıldi.");

        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");

        merchant_dashboard.newordersbutton.click();
        Assert.assertTrue(merchant_dashboard.newordersdogrulama.isDisplayed());
        extentTest.pass("Neworder linki gorunurlugu basarili bir sekilde test edildi.");

    }
    @Test
    public void tc2602NewordersAccepted(){
        ReusableMethods.merchantLogin();
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("accepted butonu  gorunurlugu testi",
                "accepted butonu gorunmeli");

        merchant_dashboard.ordersLink.click();

        merchant_dashboard.newordersbutton.click();
        Assert.assertTrue(merchant_dashboard.acceptedButton.isDisplayed());
        extentTest.pass("accepted butonunun görünürlülüğü doğrulandı");
        String acceptedOrderNoText = merchant_dashboard.succesaccepted.getText();

        merchant_dashboard.acceptedButton.click();
        extentTest.info("accepted butona basıldı");
       // merchant_dashboard.orderProcessing.click();
       // merchant_dashboard.searchbutton.sendKeys(acceptedOrderNoText);
       // String searchdogrulama=merchant_dashboard.searchdogrulama.getText();

 }
    @Test
    public void tc2603NewordersReject(){
        ReusableMethods.merchantLogin();
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("Reject butonu  gorunurlugu ve çalıştığının testi",
                "Reject butonu gorunmeli ve çalışmalı");

        merchant_dashboard.ordersLink.click();
        merchant_dashboard.newordersbutton.click();
        extentTest.info("new orders buttona basıldı");
        Assert.assertTrue(merchant_dashboard.rejectbutton.isDisplayed());
        extentTest.pass("reject butonun olduğu doğrulandı");
        merchant_dashboard.rejectbutton.click();
        extentTest.info("reject butona basıldı");
        String reason="çoğ pahalı";
        merchant_dashboard.rejectReason.sendKeys(reason);
        merchant_dashboard.rejectOrder.click();
        extentTest.info("reject sebebi yazıldı ve kaydedildi");

    }
    @Test
    public void tc2604newordersAddbutton(){
        ReusableMethods.merchantLogin();
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("Add butonu  gorunurlugu ve çalıştığının testi",
                "add butonu gorunmeli ve çalışmalı");

        String siparis="Sushi Ave Special (6 pcs)";
        merchant_dashboard.ordersLink.click();
        merchant_dashboard.newordersbutton.click();
        Assert.assertTrue(merchant_dashboard.newordersAddbutton.isDisplayed());
        extentTest.pass("aad butonu gorunurlıgu dogrulandı");
        merchant_dashboard.newordersAddbutton.click();
        extentTest.info("add butona basıldı");
        merchant_dashboard.addsearchbox.sendKeys(siparis);
        merchant_dashboard.addbuttonicerik.click();
        extentTest.info("istenen içerik girildi ");
        ReusableMethods.wait(2);
        merchant_dashboard.addorder.click();
        merchant_dashboard.addorderkapatma.click();
        extentTest.info("ekleme yapılma sayfası kapatıldı");



    }




}
