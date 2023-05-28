package tests.US_007_018_033_040;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Admin_Dashboard;
import utilities.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class US_040  {
    Admin_Dashboard ad;
    Actions actions ;
    @Test
    public void adminCreateCouponTest(){

        ReusableMethods.goToAdminHomePage();
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),ConfigReader.getProperty("betulAdminPassword"));
        ad=new Admin_Dashboard();
        ad.promoMenu.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(ad.couponLink.isDisplayed());
        ad.couponLink.click();
        softAssert.assertTrue(ad.addNewText.isDisplayed());
        ad.plusLink.click();
        actions=new Actions(Driver.getDriver());
        actions.sendKeys(ad.couponNameTextBox,"testcoupon").sendKeys(Keys.TAB)
                        .sendKeys("fixed amount").sendKeys(Keys.TAB)
                        .sendKeys("25").sendKeys(Keys.TAB)
                        .sendKeys("20").sendKeys(Keys.TAB)
                        .sendKeys("monday").sendKeys(Keys.TAB).perform();
        ad.applicableToMerchantTextBox.sendKeys("Umi Sake House"+Keys.ENTER);
        ReusableMethods.wait(2);
        actions.sendKeys(ad.applicableToMerchantTextBox,Keys.TAB).sendKeys(Keys.TAB).perform();
        //ad.selectedRestarountNameUmiSake.click();
       // ad.afterMonthNextButton.click();
        JSUtilities.scrollToBottom(Driver.getDriver());
        Select select=new Select(ad.adminCouponOptionsDDM);
        JSUtilities.clickWithJS(Driver.getDriver(),ad.expirationTextBox);
        ReusableMethods.wait(2);
        ad.afterMonthNextButton.click();
        ReusableMethods.wait(2);
       ad.selectedDay.click();
        select.selectByVisibleText("Unlimited for all user");
        select=new Select(ad.statusboxDdm);
        select.selectByVisibleText("Draft");
        JSUtilities.clickWithJS(Driver.getDriver(),ad.createCouponSaveButton);

    }
    @Test
    public void couponUpdateTest(){
        //1)bir browser aç
        //2)"https://qa.mealscenter.com/backoffice/loginé" url'i gir
        //3)cookies kabul et
        //3) kullanici isim metin kutusuna gecerli kullanici admin ismini girer.
        //4) password kutusuna gecerli admin sifre girer.
        //5)giris yap butonuna tiklar.
        //6)Sayfanin solunda gosterge panelinin altinda promo menusine tiklar.
        //7)kupon menusunun gorunur oldugunu dogrular.
        //8)kupon linkine tıklar.
        //9)acılan sayfanin kupon olusuturma sayfanin saginda yeni ekleme yazisinin gorunurlugunu
        //test eder.
        //10)yeni ekleme yazisinin yanindaki + simgesine tiklar.
        //11)coupon name  kutusuna tiklar.
        //12)coupon name kutusuna coupon ismi olarak 'test coupon guncelle' girer.
        //13)coupon type kutusuna tıklar acılan menuden coupon typeni 'sabit miktar' secer.
        //14)miktar kutusuna tıklar ve mevcut miktari siler ,
        //miktar kutusuna  '10' olarak; girilecek miktar yazar.
        //15)Asgari miktar kutusuna tıklar ve mevcut miktari siler ,
        // asgari alısveris miktarini '25' olarak; yazar.
        //16)Satıcı için geçerli kutusuna tıklar ve acılan menuden birinci restoran secer.
        //17)son (kupon gecerlilik suresini) kutusuna tıklar acılan menuden secili ayın 27'sini  secer
        //18)musait gunler kutusuna tıklar ve acılan menuden ' pazartesi secer.
        //19)coupon secenekleri kutusuna tıklar
        //acılan menuden 'tum kullanicilar icin sinirsiz'secenegini secer.
        //20)durum kutusuna tıklar  'taslak' secenegini secer.
        //21)Kaydetmek butonuna tıklar
        //22)acılan sayfada olusturulan kupon isminin en sag hizasinda  guncelle  simgesine basar.
        //23)kupon ismin guncellenenen kupon olarak degistir.
        //24)sayfayi asagi biraz indirir kaydetmek tusuna basar.
        //25)basariyla guncellendi yazisinin cıktıgını test eder.
        //26)sayfayi kapatir.
        ReusableMethods.goToAdminHomePage();
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),ConfigReader.getProperty("betulAdminPassword"));
        ad=new Admin_Dashboard();
        ad.promoMenu.click();
        ad.couponLink.click();
        ad.updateButtonList.get(2).click();
        actions=new Actions(Driver.getDriver());
        ad.couponNameTextBox.clear();
        ad.couponNameTextBox.sendKeys("updateCoupon");
        JSUtilities.scrollToBottom(Driver.getDriver());
        JSUtilities.clickWithJS(Driver.getDriver(),ad.createCouponSaveButton);
        ad.couponLink.click();
        ReusableMethods.wait(3);
        List<WebElement> couponNameList=ad.couponNameList;
        String expectedCouponName="updateCoupon";
        String actualCouponName=couponNameList.get(2).getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualCouponName.contains(expectedCouponName));
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test
    public void couponSortingTestByName(){
        ReusableMethods.goToAdminHomePage();
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),ConfigReader.getProperty("betulAdminPassword"));
        ad=new Admin_Dashboard();
        ad.promoMenu.click();
        ad.couponLink.click();





    }
    @Test
    public void couponSearchTest(){
        ReusableMethods.goToAdminHomePage();
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),ConfigReader.getProperty("betulAdminPassword"));
        ad=new Admin_Dashboard();
        ad.promoMenu.click();
        ad.couponLink.click();
        List<WebElement> couponNameList=ad.couponNameList;
        String couponNameToSearch=couponNameList.get(3).getText();
        int boslukIndex=couponNameToSearch.indexOf(" ");
        couponNameToSearch=couponNameToSearch.substring(0,boslukIndex);
        System.out.println(couponNameToSearch);
        ad.searchBox.sendKeys(couponNameToSearch);
        ad.couponSearchButton.click();
    }
}
