package tests.US_012_013_021_039;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_012 extends TestBaseRapor {

    User_Homepage homepage=new User_Homepage();
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void tc_1201() {
        softAssert=new SoftAssert();

        extentTest = extentReports.createTest("TC_1201",
                       "Sayfada farklı yerel mutfaklara ait restauranlar olmalı");

        beforeMethod();
        extentTest.info("Before method ile tarayici acilir, login olunur, adres girilir, restaurants sayfasina gidilir.");


        List<WebElement> mutfakListesi=Driver.getDriver()
                .findElements(By.xpath("//div/span[@class='a-12 mr-1']"));
        extentTest.info("Sayfadaki restaurant listesi alınır.");


        int flag=0;
        for (int i = 0; i <mutfakListesi.size() ; i++) {
            if (!(mutfakListesi.get(0).getText().equals(mutfakListesi.get(i).getText()))){
                flag++;
                //Mutfaklar Listesinde birbirinden farkli mutfaklar varsa flag artacak
            }
        }
        extentTest.info("Listedeki restaurantlarin yerel mutfaklarina bakilir.");

        //(Farklı mutfakların birden fazla olması yeterli)
        softAssert.assertTrue(flag>1,"Sayfada farklı yerel mutfaklara ait restauranlar mevcut degil");
        extentTest.info("Listedeki restaurantlarin yerel mutfağının birbirinden farklı olduğu doğrulanır.");
        extentTest.info("Tarayici kapatilir.");

        extentTest.pass("Kullanici anasayfasinda farklı yerel mutfaklara ait restaurantlar mevcut");
        softAssert.assertAll();
    }

    @Test
    public void tc_1202() {
        homepage=new User_Homepage();
        softAssert=new SoftAssert();

        extentTest = extentReports.createTest("TC_1202",
                "Sayfada farklı yerel mutfaklara ait restauranlar olmalı" +
                        "Kullanici anasayfasinda farklı yerel mutfaklari getiren filtreleme kutularının calismasi ve doğru sonuç getirmesi");

        beforeMethod();
        extentTest.info("Before method ile tarayici acilir, login olunur, adres girilir, restaurants sayfasina gidilir.");

        homepage.cuisinesShowMoreButton.click();
        extentTest.info("Cuisines filtreleme bölümündeki 'ShowMore' butonuna tiklanir.");

        List<WebElement> cuisineElemanlariTikla=Driver.getDriver().findElements(By.xpath("//div[@class='custom-control custom-checkbox']"));
        List<WebElement> cuisineElemanlariControl=Driver.getDriver().findElements(By.xpath("//div/input[@class='custom-control-input cuisine']"));
        extentTest.info("Cuisines bölümünde farklı yerel mutfaklarin listesi alinir.");


        for (int i = 12; i <cuisineElemanlariTikla.size() ; i++) {
            cuisineElemanlariTikla.get(i).click();
            softAssert.assertTrue(cuisineElemanlariControl.get(i).isSelected(),cuisineElemanlariTikla.get(i).getText()+" checkbox'i aktif değil");
        }
        extentTest.info("Cuisines bölümünde farklı yerel mutfaklar seceneklerinin tıklanabilir oldugu dogrulanir.");

        homepage.filterClearAllButton.click();
        extentTest.info("Cuisines filtreleme bölümündeki 'ClearAll' butonuna tiklanir.");

        homepage.japaneseCheckBox.click();
        ReusableMethods.wait(0.1);
        extentTest.info("Cuisines bölümündeki yerel mutfaklardan Japanese checkbox'ina tıklanır.");

        String expectedMutfakFiltresi= ConfigReader.getProperty("mutfakType");
        String actualMutfakFiltresi=homepage.ilkRestaurantCuisineBilgisi.getText();
        softAssert.assertTrue(actualMutfakFiltresi.contains(expectedMutfakFiltresi),"Cuisine filtrelemedeki "+ homepage.japaneseCheckBox.getText() +"checkbox'i doğru sonuc getirmiyor");
        extentTest.info("Tıklanan mutfak ismi ile gelen restaurantların mutfak isiminin uyumlu olduğu doğrulanır.");
        extentTest.info("Tarayici kapatilir.");

        extentTest.fail("Burger checkbox'i aktif değil");
        softAssert.assertAll();
    }

    public void beforeMethod(){
        homepage=new User_Homepage();

        // Tarayıcı açılır.
        // Url e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        // Cookies kabul edilir.
        homepage.cookieAcceptButton.click();

        // Kullanıcı sayfasına login olunur.
        ReusableMethods.userLoginMethod("duyguUserName","duyguUserPassword");

        // Anasayfadaki teslimat adresi kutusuna gecerli posta kodu(=10001) girilir.
        homepage.adresButton.sendKeys(ConfigReader.getProperty("adres"));

        // Ilk satırdakı 10001 posta koduna tıklanır.
        homepage.adres10001.click();
    }
}
