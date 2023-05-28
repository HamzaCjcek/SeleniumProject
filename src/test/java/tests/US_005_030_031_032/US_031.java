package tests.US_005_030_031_032;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Merchant_Dashboard;
import utilities.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class US_031 extends TestBaseRapor {
    Merchant_Dashboard merchant_dashboard = new Merchant_Dashboard();
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void tc03101_allOrdersGorunurlugu() {
        extentTest = extentReports.createTest("All Orders linki gorunurlugu testi", "All Orders linki gorulmeli");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("All Orders sayfası acildi.");
        Assert.assertTrue(merchant_dashboard.allOrdersLinkText.isDisplayed());
        extentTest.pass("All Orders linki goruldu.");
    }

    @Test
    public void tc03102_orderHistorySayfasiGorunurlugu() {
        extentTest = extentReports.createTest("All Orders linki gorunurlugu testi", "All Orders linki gorulmeli");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("All Orders sayfası acildi.");
        Assert.assertTrue(merchant_dashboard.orderHistoryText.isDisplayed());
        extentTest.pass("Order History sayfasi acildi.");
    }

    @Test
    public void tc03103_allOrdersOrdersEntriesSayilarininEsitligi() {
        extentTest = extentReports.createTest("  All Orders, Orders, Entries sayilarinin esitligi testi.",
                "All Orders, Orders, Entries sayilari esit olmali");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("Order History sayfasi acildi.");
        ReusableMethods.wait(2);
        String allOrdersCount = merchant_dashboard.allOrdersCount.getText();
        String ordersCount = merchant_dashboard.ordersCount.getText();
        String entriesText = merchant_dashboard.entriesCount.getText();
        String[] entriesTextArr = entriesText.split(" ");
        String entriesCount = entriesTextArr[5];
        softAssert.assertEquals(entriesCount, allOrdersCount, "entriesCount, allOrdersCount sayilari farkli.");
        softAssert.assertEquals(entriesCount, ordersCount, "entriesCount, ordersCount sayilari farkli.");
        softAssert.assertEquals(allOrdersCount, ordersCount, "allOrdersCount, ordersCount sayilari farkli.");
        softAssert.assertAll();
        extentTest.pass("All Orders, Orders, Entries sayilarinin esitligi dogrulandi.");
    }

    @Test
    public void tc03104_tarihAraligi() {
        extentTest = extentReports.createTest("Tarih araligi testi.",
                "Tarih araligi secilebilmeli.");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("Order History sayfasi acildi.");
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibility(merchant_dashboard.entriesCount, 2);
        String entriesText = merchant_dashboard.entriesCount.getText();
        String[] entriesTextArr = entriesText.split(" ");
        String entriesCountToplam = entriesTextArr[5];
        merchant_dashboard.startDateEndDate.click();
        merchant_dashboard.tarihSecimiYesterday.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibility(merchant_dashboard.entriesCount, 2);
        String entriesTextYesterday = merchant_dashboard.entriesCount.getText();
        String[] entriesTextYesterdayArr = entriesTextYesterday.split(" ");
        String entriesCountYesterday = entriesTextYesterdayArr[5];
        Assert.assertNotEquals(entriesCountToplam, entriesCountYesterday);
        Driver.getDriver().navigate().refresh();
        extentTest.pass("Tarih araligi secimi basariyla yapildi.");
    }

    @Test
    public void tc03105_gorunurluk() {
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Hedear da bulunan Orders, Cancel, Total refund, Total Orders in gorunurlugu testi.",
                "Hedear da bulunan Orders, Cancel, Total refund, Total Orders sayilari gorunmeli.");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("Order History sayfasi acildi.");
        softAssert.assertTrue(merchant_dashboard.ordersCount.isDisplayed());
        softAssert.assertTrue(merchant_dashboard.cancelCount.isDisplayed());
        softAssert.assertTrue(merchant_dashboard.totalRefundMoney.isDisplayed());
        softAssert.assertTrue(merchant_dashboard.totalOrdersMoney.isDisplayed());
        softAssert.assertAll();
        extentTest.pass("Hedear da bulunan Orders, Cancel, Total refund, Total Orders sayilari gorunuyor.");
    }

    @Test
    public void tc03106_filters() {
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("Filters testi",
                "Filtremele yapabilmeli");
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("Order History sayfasi acildi.");
        ReusableMethods.wait(1);
        String entriesText1 = merchant_dashboard.entriesCount.getText();
        String[] entriesTextArr1 = entriesText1.split(" ");
        String entriesCount1 = entriesTextArr1[5];
        merchant_dashboard.filtersButton.click();
        merchant_dashboard.byStatusBox.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER).perform();
        merchant_dashboard.applyFiltersButton.click();
        ReusableMethods.wait(1);
        String entriesText2 = merchant_dashboard.entriesCount.getText();
        String[] entriesTextYArr2 = entriesText2.split(" ");
        String entriesCount2 = entriesTextYArr2[5];
        Assert.assertNotEquals(entriesCount1, entriesCount2);
        Driver.getDriver().navigate().refresh();
        extentTest.pass("Filtre secimi basariyla yapildi.");

    }

    @Test
    public void tc03107_basliklar() {
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Musteri listesindeki customer, orderInformation, actions, orderID basliklarinın gorunurlugu testi.",
                "Musteri listesindeki customer, orderInformation, actions, orderID basliklari gorunmeli.");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("Order History sayfasi acildi.");
        softAssert.assertTrue(merchant_dashboard.customerBaslik.isDisplayed());
        softAssert.assertTrue(merchant_dashboard.orderInformationBaslik.isDisplayed());
        softAssert.assertTrue(merchant_dashboard.actionsBaslik.isDisplayed());
        softAssert.assertTrue(merchant_dashboard.orderIDBaslik.isDisplayed());
        softAssert.assertAll();
        extentTest.pass("Musteri listesindeki customer, orderInformation, actions, orderID basliklari gorunuyor.");
    }

    @Test
    public void tc03108_buttons() {
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Musteri listesi, gosterButtonu, downloadButtonu gorunurlugu testi.",
                "Musteri listesi, gosterButtonu, downloadButtonu gorulmeli.");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("Order History sayfasi acildi.");
        softAssert.assertTrue(merchant_dashboard.musteriBilgi.isDisplayed());
        softAssert.assertTrue(merchant_dashboard.gosterButtonu.isDisplayed());
        softAssert.assertTrue(merchant_dashboard.downloadButtonu.isDisplayed());
        softAssert.assertAll();
        extentTest.pass("Musteri listesi, gosterButtonu, downloadButtonu gorunuyor.");
    }

    @Test
    public void tc03109_displayedButtonu() {
        extentTest = extentReports.createTest("Sipariş ayrıntılarının goruntulenmesi testi.",
                "Sipariş ayrıntıları gorulmeli.");
        merchant_dashboard = new Merchant_Dashboard();
        softAssert=new SoftAssert();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("Order History sayfasi acildi.");
        String ilkSayfaHandle= Driver.getDriver().getWindowHandle();
        extentTest.pass("İlk sayfa handle değeri alındı.");
        merchant_dashboard.gosterButtonu.click();
        extentTest.pass("Ayrıntıları goster butonuna tıklandı.");
        ReusableMethods.switchToWindow2(ilkSayfaHandle);
        extentTest.pass("Açılan yeni sayfaya geçildi.");
        extentTest.pass(".");
        softAssert.assertTrue(merchant_dashboard.summaryText.isDisplayed());
        softAssert.assertAll();
        extentTest.pass("Sipariş ayrıntıları başarılı bir şekilde açıldı.");
    }

    @Test
    public void tc03110_downloadButtons() {
        extentTest = extentReports.createTest("Sipariş ayrıntılarını pdf olarak download testi.",
                "Sipariş ayrıntılarını pdf olarak download edilebilmeli.");
        merchant_dashboard = new Merchant_Dashboard();
        softAssert=new SoftAssert();
        ReusableMethods.merchantLogin();
        merchant_dashboard.ordersLink.click();
        extentTest.info("Orders linkine tiklandi.");
        merchant_dashboard.allOrdersLink.click();
        extentTest.pass("Order History sayfasi acildi.");
        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\document.pdf";
        extentTest.pass(".");
        merchant_dashboard.downloadButtonu.click();
        extentTest.pass("Download butonuna tıklandı.");
        ReusableMethods.wait(3);
        String dosyaYoluDownloads=System.getProperty("user.home")+"\\Downloads\\document.pdf";
        extentTest.pass("Dinamik dosya yolu oluşturuldu.");
        softAssert.assertTrue(Files.exists(Paths.get(dosyaYoluDownloads)));
        softAssert.assertAll();
        extentTest.pass("Sipariş ayrıntıları pdf olarak başarıyla download edildi.");
    }

}
