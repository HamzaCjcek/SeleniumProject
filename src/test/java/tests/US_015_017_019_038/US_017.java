package tests.US_015_017_019_038;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.*;

import java.util.List;

public class US_017 extends TestBaseRapor {

    User_Homepage userHomepage = new User_Homepage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void paymentsTest01() {
        userHomepage = new User_Homepage();
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Kullanıcının Payments sayfasına erişebilmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Url’e gidildi");
        userHomepage.cookieAcceptButton.click();
        extentTest.info("Cookie kabul edildi");
        ReusableMethods.userLoginMethod("betulUserEmail", "betulUserPassword");
        ReusableMethods.waitFor(1);
        userHomepage.nameButton.click();
        extentTest.info("Açılan sayfada kullanıcı adının üzerine tıklandı");
        userHomepage.paymentSection.click();
        extentTest.info("Açılan menüden “Payments option” yazısına tıklandı");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("paymentUrl");
        softAssert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("My orders'a erişilebildiği doğrulandı");
        softAssert.assertAll();
    }

    @Test
    public void paymentsTest02() {
        userHomepage = new User_Homepage();
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest(" Kullanıcının Payments sayfasındaki içeriği görüntülemesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Url’e gidildi");
        userHomepage.cookieAcceptButton.click();
        extentTest.info("Cookie kabul edildi");
        ReusableMethods.userLoginMethod("betulUserEmail", "betulUserPassword");
        ReusableMethods.waitFor(1);
        userHomepage.nameButton.click();
        extentTest.info("Açılan sayfada kullanıcı adının üzerine tıklandı");
        userHomepage.paymentSection.click();
        extentTest.info("Açılan menüden “Payments option” yazısına tıklandı");
        softAssert.assertTrue(userHomepage.cardAndText.isDisplayed(), "Sayfadaki resim ve yazılar görünmüyor");
        extentTest.info("Kart imgesi ve sayfadaki yazıların görünür olduğu doğrulandı");
        softAssert.assertTrue(userHomepage.addPaymentButton.isEnabled());
        extentTest.info("‘Add new payment butonu’nun erişilebilir olduğu doğrulandı");
        List<WebElement> paymentList = userHomepage.paymentMethods;
        for (WebElement eachPayment : paymentList
        ) {
            softAssert.assertTrue(eachPayment.isDisplayed());
        }
        extentTest.pass(" Kullanıcının Payments sayfasındaki içeriği görüntülediği doğrulandı");
        softAssert.assertAll();
    }

    @Test
    public void paymentTest03() {
        userHomepage = new User_Homepage();
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Kullanıcının ödeme bilgisi eklemesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Url’e gidildi");
        userHomepage.cookieAcceptButton.click();
        extentTest.info("Cookie kabul edildi");
        ReusableMethods.userLoginMethod("betulUserEmail", "betulUserPassword");
        ReusableMethods.waitFor(1);
        userHomepage.nameButton.click();
        extentTest.info("Açılan sayfada kullanıcı adının üzerine tıklandı");
        userHomepage.paymentSection.click();
        extentTest.info("Açılan menüden “Payments option” yazısına tıklandı");
        userHomepage.addPaymentButton.click();
        extentTest.info("‘Add new payment butonu’na tıklandı");
        userHomepage.cash.click();
        extentTest.info("‘Cash on delivery’ yazısına tıklandı");
        userHomepage.addCashButton.click();
        extentTest.info("Açılan pencerede ‘Add Cash’ butonuna tıklandı");
        userHomepage.closeAddCash.click();
        extentTest.info("Pencere kapatıldı");
        softAssert.assertTrue(userHomepage.cashAdded.isDisplayed());
        extentTest.info("Alt kısma ödeme bilgisinin eklendiği doğrulandı");
        userHomepage.stripe.click();
        extentTest.info("‘Stripe’ yazısına tıklandı");
        ReusableMethods.wait(1);

        Driver.getDriver().switchTo().frame(userHomepage.iframe);
        ReusableMethods.wait(1);
        userHomepage.cardNoBox.sendKeys("4242424242424242");
        extentTest.info("Kart numarasi girilir");
        userHomepage.dateBox.sendKeys("0424");
        extentTest.info("Son kullanma tarihi girilir");
        userHomepage.cvcBox.sendKeys("123");
        extentTest.info("Güvenlik kodu girilir");
        userHomepage.zipCodeBox.sendKeys("10001");
        Driver.getDriver().switchTo().defaultContent();

        userHomepage.addStripeButton.click();
        extentTest.info("Açılan pencerede ‘Add Stripe’ butonuna tıklandı");
        userHomepage.closeAddStripe.click();
        extentTest.info("Pencere kapatıldı");
        softAssert.assertTrue(userHomepage.addedStripe.isDisplayed());
        extentTest.info("Alt kısma ödeme bilgisinin eklendiği doğrulandı");
        userHomepage.closePaymentButton.click();
        extentTest.pass("Close Payment butonuna basıldı ve kullanıcının ödeme bilgisi ekleyebildiği doğrulandı");
        softAssert.assertAll();

    }

    @Test
    public void paymentTest04() {
        userHomepage = new User_Homepage();
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest(" Kullanıcının ödeme bilgisini silmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Url’e gidildi");
        userHomepage.cookieAcceptButton.click();
        extentTest.info("Cookie kabul edildi");
        ReusableMethods.userLoginMethod("betulUserEmail", "betulUserPassword");
        ReusableMethods.waitFor(1);
        userHomepage.nameButton.click();
        extentTest.info("Açılan sayfada kullanıcı adının üzerine tıklandı");
        userHomepage.paymentSection.click();
        extentTest.info("Açılan menüden “Payments option” yazısına tıklandı");
        userHomepage.deletePaymentButton.click();
        extentTest.info("Kayıtlı ödeme yönteminin üzerindeki delete butonuna tıklandı");
        List<WebElement> paymentList = userHomepage.paymentMethods;
        for (WebElement eachPayment : paymentList
        ) {
            softAssert.assertTrue(eachPayment.isDisplayed());
        }
        extentTest.fail("Kayıtlı ödeme yönteminin silinemediği doğrulandı");
        softAssert.assertAll();

    }

    @Test
    public void paymentTest05() { //****************************
        userHomepage = new User_Homepage();
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest(" Kullanıcının ödeme bilgisini düzenleyebilmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Url’e gidildi");
        userHomepage.cookieAcceptButton.click();
        extentTest.info("Cookie kabul edildi");
        ReusableMethods.userLoginMethod("betulUserEmail", "betulUserPassword");
        ReusableMethods.waitFor(1);
        userHomepage.nameButton.click();
        extentTest.info("Açılan sayfada kullanıcı adının üzerine tıklandı");
        userHomepage.paymentSection.click();
        extentTest.info("Açılan menüden “Payments option” yazısına tıklandı");
        softAssert.assertTrue(userHomepage.editPaymentButton.isDisplayed()); ///***********
        extentTest.info("Kayıtlı ödeme yönteminin üzerindeki edit butonuna tıklanamadı");
        extentTest.fail("Ödeme yönteminin düzenlenemediği doğrulandı");
        softAssert.assertAll();
    }


    @AfterMethod
    public void tearDown() {
        userHomepage = new User_Homepage();
        softAssert = new SoftAssert();
        softAssert.assertAll();
        //Driver.closeDriver();
    }
}


