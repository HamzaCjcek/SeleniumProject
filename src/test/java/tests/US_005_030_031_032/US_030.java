package tests.US_005_030_031_032;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.Merchant_Dashboard;
import pages.User_CheckoutPage;
import pages.User_Homepage;
import pages.User_RestaurantUmiSakeHouse;
import utilities.*;

import java.util.List;

import static utilities.ReusableMethods.waitForClickablility;

public class US_030 extends TestBaseRapor {
    SoftAssert softAssert = new SoftAssert();
    Merchant_Dashboard merchant_dashboard = new Merchant_Dashboard();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void tc03001_scheduledGorunurlugu() {
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("Scheduled linki gorunurlugu testi",
                "Scheduled linki sayfada gorunmeli");

        ReusableMethods.merchantLogin();
        extentTest.info("Merchant sayfası acıldi.");
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");

        ReusableMethods.waitForVisibility(merchant_dashboard.scheduledLink, 2);
        Assert.assertTrue(merchant_dashboard.scheduledLink.isDisplayed());
        extentTest.pass("Scheduled linki gorunurlugu basarili bir sekilde test edildi.");
    }

    @Test
    public void tc03002_scheduledSayfasiGorunurlugu() {
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("Scheduled sayfası gorunurlugu testi",
                "Scheduled sayfasi gorunmeli");

        ReusableMethods.merchantLogin();
        extentTest.info("Merchant sayfası acıldi.");
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");

        merchant_dashboard.scheduledLink.click();
        extentTest.info("Scheduled linkine tiklanir.");
        Assert.assertTrue(merchant_dashboard.scheduledBaslikText.isDisplayed());
        extentTest.pass("Scheduled sayfasi gorunurlugu basarili bir sekilde test edildi.");
    }

    @Test
    public void tc03003_completedTodaySayisiGorunurlugu() {
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("Completed Today sayisi sorunurlugu testi",
                "Completed Today Sayisi  sayfada gorunmeli");

        ReusableMethods.merchantLogin();
        extentTest.info("Merchant sayfası acıldi.");
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");

        merchant_dashboard.scheduledLink.click();
        extentTest.info("Scheduled linkine tiklanir.");
        Assert.assertTrue(merchant_dashboard.completedTodayCount.isDisplayed());
        extentTest.pass("Completed Today Sayisi Gorunurlugu basarili bir sekilde test edildi.");
    }

    @Test
    public void tc03004_acceptedRejectAssignButtonAktifligi() {
        softAssert = new SoftAssert();
                merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("Accepted, Reject, Assign buttonlari aktifligi testi",
                "Accepted Reject Assign buttonlari aktif olmali");

        ReusableMethods.merchantLogin();
        extentTest.info("Merchant sayfası acıldi.");
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");

        merchant_dashboard.scheduledLink.click();
        extentTest.info("Scheduled linkine tiklanir.");
        softAssert.assertTrue(merchant_dashboard.acceptedButton.isEnabled(), "acceptedButton gorulmedi");
        softAssert.assertTrue(merchant_dashboard.rejectButton.isEnabled(), "rejectButton gorulmedi");
        softAssert.assertTrue(merchant_dashboard.assignDriverButton.isDisplayed(), "assignDriverButton gorulmedi");
        softAssert.assertAll();
        extentTest.pass("Basarili sekilde Accepted, Reject, Assign buttonlari aktifligi test edildi");

    }

    @Test
    public void tc03005_acceptedAktifligi() {
        extentTest = extentReports.createTest("Accepted buttonu testi",
                "Eklenen urun merchant tarfından accapted edilmeli");
        merchant_dashboard = new Merchant_Dashboard();
        actions = new Actions(Driver.getDriver());
        scheuldedSiparisMethod();
        extentTest.info("Test yapmak için yeni sipariş oluşturuldu.");
        ReusableMethods.merchantLogin();
        extentTest.info("Merchant sayfası acıldi.");
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.scheduledLink.click();
        extentTest.info("scheduled linkine tiklandi.");
        merchant_dashboard.shedueledSort.click();
        extentTest.info("shedueledSort tiklandi.");
        merchant_dashboard.orderIDDescending.click();
        extentTest.info("orderIDDescending seçildi.");
        merchant_dashboard.eklenenSonSiparis.click();
        extentTest.info("eklenenSonSiparis seçildi.");
        ReusableMethods.waitForClickablility(merchant_dashboard.acceptedButton, 3);
        merchant_dashboard.acceptedButton.click();
        extentTest.info("acceptedButton tiklandi.");
        ReusableMethods.wait(0.5);
        String expectedAceptedText = "accepted";
        String actualAceptedText = merchant_dashboard.acceptedText.getText();
        Assert.assertEquals(expectedAceptedText, actualAceptedText);
        extentTest.pass("Accepted buttonunun çalışması başarılı bir şekilde test edildi");
    }

    @Test
    public void tc03006_rejectAktifligi() {
        extentTest = extentReports.createTest("Reject buttonu testi",
                "Eklenen urun merchant tarfından reject edilmeli");
        merchant_dashboard = new Merchant_Dashboard();
        softAssert=new SoftAssert();
        actions = new Actions(Driver.getDriver());
        scheuldedSiparisMethod();
        extentTest.info("Test yapmak için yeni sipariş oluşturuldu.");
        ReusableMethods.merchantLogin();
        extentTest.info("Merchant sayfası acıldi.");
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.scheduledLink.click();
        extentTest.info("Scheduled linkine tiklanir.");
        merchant_dashboard.shedueledSort.click();
        extentTest.info("shedueledSort tiklandi.");
        merchant_dashboard.orderIDDescending.click();
        extentTest.info("orderIDDescending seçildi.");
        merchant_dashboard.eklenenSonSiparis.click();
        extentTest.info("eklenenSonSiparis seçildi.");
        String silinenOrderNoText = merchant_dashboard.orderNoText.getText();
        merchant_dashboard.rejectButton.click();
        extentTest.info("rejectButton tiklandi.");
        merchant_dashboard.outOfItemButton.click();
        extentTest.info("outOfItemButton tiklandi.");
        merchant_dashboard.rejectOrderButton.click();
        extentTest.info("rejectOrderButton tiklandi.");
        ReusableMethods.wait(1);
        List<WebElement> orderNoList = Driver.getDriver().findElements(By.xpath("//*[@id='vue-order-management']/div[8]//div/ul//div[2]/div"));
        int sayi = 0;
        System.out.println(sayi);
        for (WebElement each : orderNoList
        ) {
            System.out.println(each.getText());
            if (silinenOrderNoText.equals(each.getText()))
                sayi++;
        }
        softAssert.assertEquals(sayi, 0);
        softAssert.assertAll();
        extentTest.pass("Reject buttonunun çalışması başarılı bir şekilde test edildi");
    }

    @Test(groups = "smoke")
    public void tc03007_assignDriverButton() {
        extentTest = extentReports.createTest("Reject button test",
                "The added product must be rejected by the merchant");
        merchant_dashboard = new Merchant_Dashboard();
        softAssert=new SoftAssert();
        actions = new Actions(Driver.getDriver());
        scheuldedSiparisMethod();
        extentTest.info("New order created for testing.");
        ReusableMethods.merchantLogin();
        extentTest.info("Merchant page is open.");
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders link clicked.");
        merchant_dashboard.scheduledLink.click();
        extentTest.info("Scheduled link clicked.");
        merchant_dashboard.assignDriverButton.click();
        extentTest.info("assignDriverButton clicked.");

        try {
            softAssert.assertTrue(merchant_dashboard.assignDriverMaps.isDisplayed());
        } catch (Exception e) {
            softAssert.assertTrue(false,"Assign Driver button not working.");
        }

        softAssert.assertAll();
        extentTest.pass("Verifies that the map is opened.");
    }

    private void scheuldedSiparisMethod() {
        User_Homepage homepage = new User_Homepage();
        User_RestaurantUmiSakeHouse restaurantUmiSakeHouse = new User_RestaurantUmiSakeHouse();
        User_CheckoutPage checkoutPage = new User_CheckoutPage();
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.goTouserHomePage();
        // Kullanıcı sayfasına login olunur.
        ReusableMethods.userLoginMethod("usernameEmailVht", "passwordUserVht");
        // Anasayfadaki teslimat adresi kutusuna gecerli posta kodu(=10001) girilir.
        homepage.adresButton.sendKeys(ConfigReader.getProperty("adres"));
        // Ilk satırdakı 10001 posta koduna tıklanır.
        homepage.adres10001.click();
        // Sepete restauranttaki ilk urun eklenir.
        //sepeteUrunEklemeMethodu();
        //Umi Sake Hause restaurant tıklanır.
        homepage.umiSakeHouseRestaurantButton.click();
        // Ilk ürün 'add to cart' butonu ile sepete eklenir.
        restaurantUmiSakeHouse.ilkUrunAddToCartButton.click();
        //Sepetteki checkout butonu ile ödeme sayfasına gidilir.
        restaurantUmiSakeHouse.checkoutButton.click();
        // Delivery option secilir
        checkoutPage.deliveryButton.click();
        checkoutPage.scheduleForLaterButton.click();
        checkoutPage.scheduleDayDdm.click();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        checkoutPage.scheduleDayTime.click();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        checkoutPage.orderTypeSaveButton.click();
        checkoutPage.placeOrderButton.click();
        ReusableMethods.wait(1);
        Driver.getDriver().navigate().refresh();

    }

}