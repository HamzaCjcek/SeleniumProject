package tests.US_012_013_021_039;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Merchant_Dashboard;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_021 extends TestBaseRapor {
    SoftAssert softAssert = new SoftAssert();
    Merchant_Dashboard merchant = new Merchant_Dashboard();

    @Test
    public void tc_2101() {

        softAssert = new SoftAssert();
        merchant = new Merchant_Dashboard();

        extentTest = extentReports.createTest("TC_2101",
                "Dashboard paneli testi");

        //Tarayıcı açılır.
        //Url e gidilir.
        //Merchant sayfasına login olunur.
        ReusableMethods.merchantLogin();
        extentTest.info("Login methodu ile tarayici acilir, Url'e gidilir, Merchant sayfasina login olunur.");

        //Dashboard panelinin görünür olduğu doğrulanır.
        softAssert.assertTrue(merchant.dasboardMenusununTamami.isDisplayed(), "Dashboard menusu gorunur degil");
        extentTest.info("Dashboard panelinin görünür olduğu doğrulanır.");
        //System.out.println(merchant.dasboardMenusununTamami.getText()); //>> paneldeki tum menuler yaziyor.
        extentTest.info("Tarayici kapatilir.");

        extentTest.pass("Merchant anasayfasinda dashboard paneli mevcut");
        softAssert.assertAll();

    }

    @Test
    public void tc_2102() {
        softAssert = new SoftAssert();
        merchant = new Merchant_Dashboard();

        extentTest = extentReports.createTest("TC_2102",
                "Dashboard paneli menuleri testi");

        //Tarayıcı açılır
        //Url e gidilir.
        //Merchant sayfasına login olunur.
        //Paneline ait menulerin olduğu doğrulanır.

        ReusableMethods.merchantLogin();
        extentTest.info("Login methodu ile tarayici acilir, Url'e gidilir, Merchant sayfasina login olunur.");

        softAssert.assertTrue(merchant.dashboardMenuButonu.isEnabled(), merchant.dashboardMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.merchantMenuButonu.isEnabled(), merchant.dashboardMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.ordersMenuButonu.isEnabled(), merchant.ordersMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.attributesMenuButonu.isEnabled(), merchant.attributesMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.foodMenuButonu.isEnabled(), merchant.foodMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.orderTypeMenuButonu.isEnabled(), merchant.orderTypeMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.paymentGatewayMenuButonu.isEnabled(), merchant.paymentGatewayMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.promoMenuButonu.isEnabled(), merchant.promoMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.imagesMenuButonu.isEnabled(), merchant.imagesMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.accountMenuButonu.isEnabled(), merchant.accountMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.buyersMenuButonu.isEnabled(), merchant.buyersMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.usersMenuButonu.isEnabled(), merchant.usersMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.reportsMenuButonu.isEnabled(), merchant.reportsMenuButonu.getText() + " menusu aktif değil.");
        softAssert.assertTrue(merchant.inventoryManagementMenuButonu.isEnabled(), merchant.inventoryManagementMenuButonu.getText() + " menusu aktif değil.");
        extentTest.info("Paneline ait menulerin olduğu doğrulanır.");
        extentTest.info("Tarayici kapatilir.");

        extentTest.pass("Dashboard panelinde menuler mevcut");
        softAssert.assertAll();

    }
}
