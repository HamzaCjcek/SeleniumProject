package tests.US_005_030_031_032;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Merchant_Dashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_032_B_Ingredients extends TestBaseRapor {
    Merchant_Dashboard merchant_dashboard = new Merchant_Dashboard();
    SoftAssert softAssert = new SoftAssert();
    Faker faker=new Faker();

    @Test
    public void tc03208_ingredientsListSayfasi() {
        extentTest = extentReports.createTest("Ingredients List sayfasi testi", "Ingredients List sayfasi acilmali");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        ReusableMethods.waitForClickablility(merchant_dashboard.attributesLinki,2);
        merchant_dashboard.attributesLinki.click();
        merchant_dashboard.ingredientsLinki.click();
        extentTest.info("Merchant sayfasına girildi.");
        softAssert.assertTrue(merchant_dashboard.sizeSayfasiBasligi.isDisplayed(), "Size List sayfasi acilmadi");
        softAssert.assertAll();
        extentTest.pass("ingredients List sayfasi basarili bir sekilde acildi.");
    }

    @Test
    public void tc03209_baslik() {
        extentTest = extentReports.createTest("noBasligi, nameBasligi, actionsBasligi, searchSizeBox, addNewButton baslıkları ve simgeleri gorunurlugu testi",
                "noBasligi, nameBasligi, actionsBasligi, searchBox, addNewButton baslıkları ve simgeleri gorunur olmali");
        merchant_dashboard = new Merchant_Dashboard();
        softAssert = new SoftAssert();
        ReusableMethods.merchantLogin();
        ReusableMethods.waitForClickablility(merchant_dashboard.attributesLinki,2);
        merchant_dashboard.attributesLinki.click();
        merchant_dashboard.ingredientsLinki.click();
        extentTest.info("Merchant sayfasına girildi.");
        softAssert.assertTrue(merchant_dashboard.noBasligi.isDisplayed(), "noBasligi gorulmedi");
        softAssert.assertTrue(merchant_dashboard.nameBasligi.isDisplayed(), "nameBasligi gorulmedi");
        softAssert.assertTrue(merchant_dashboard.actionsBasligi.isDisplayed(), "actionsBasligi gorulmedi");
        softAssert.assertTrue(merchant_dashboard.searchSizeBox.isDisplayed(), "searchSizeBox gorulmedi");
        softAssert.assertTrue(merchant_dashboard.addNewButton.isDisplayed(), "addNewButton gorulmedi");
        softAssert.assertTrue(merchant_dashboard.noBasligi.isDisplayed(), "size sayfasi acilmadi");
        softAssert.assertAll();
        extentTest.pass("Ingredients List sayfasi noBasligi, nameBasligi, actionsBasligi, searchSizeBox, addNewButton basliklari ve simgeleri goruldu.");
    }

    @Test
    public void tc03210_yeniUrunEklemeSilme() {
        extentTest = extentReports.createTest("Ingredients List yeni urun ekleme ve silme testi",
                "Ingredients List yeni urun eklenebilmeli ve urun silinebilmeli");
        merchant_dashboard = new Merchant_Dashboard();
        faker=new Faker();
        ReusableMethods.merchantLogin();
        ReusableMethods.waitForClickablility(merchant_dashboard.attributesLinki,2);
        merchant_dashboard.attributesLinki.click();
        merchant_dashboard.ingredientsLinki.click();
        extentTest.info("Merchant sayfasına girildi.");
        String addNameStr=faker.name().name();
        merchant_dashboard.addNewButton.click();
        extentTest.info("Add New buttonuna tiklandi.");
        //String addNameStr="Big Battal";
        merchant_dashboard.sizeNameBox.sendKeys(addNameStr);
        extentTest.info("Name box a isim girildi.");
        merchant_dashboard.saveButton.click();
        extentTest.info("Save buttonuna tiklandi.");
        String eklenenName=merchant_dashboard.listIlkName.getText();
        softAssert.assertEquals(addNameStr+" Publish",eklenenName);
        merchant_dashboard.deleteButtonSizeAll.click();
        ReusableMethods.waitForVisibility(merchant_dashboard.deleteConfirmationButton,2);
        merchant_dashboard.deleteConfirmationButton.click();
        extentTest.info("Eklenen urun silindi.");
        softAssert.assertAll();
        extentTest.pass("Ingredients liste urun ekleme ve silme basariyla gerceklesti");
        Driver.closeDriver();
    }


    @Test
    public void tc03211_update() {
        extentTest = extentReports.createTest("Ingredients List sayfası update fonksiyon testi",
                "Ingredients List sayfasinde urunleri update edebilmeli");
        faker=new Faker();
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        //ReusableMethods.wait(1);
        //ReusableMethods.waitForClickablility(merchant_dashboard.attributesLinki,2);
        merchant_dashboard.attributesLinki.click();
        merchant_dashboard.ingredientsLinki.click();
        extentTest.info("Merchant sayfasına girildi.");
        String ilkName=faker.name().name();
        ReusableMethods.wait(1);
        String updateName=faker.name().nameWithMiddle();
        merchant_dashboard = new Merchant_Dashboard();
        merchant_dashboard.addNewButton.click();
        extentTest.info("Add New buttonuna tiklandi.");
        ReusableMethods.wait(1);
        merchant_dashboard.sizeNameBox.sendKeys(ilkName);
        extentTest.info("Name box a isim girildi.");
        merchant_dashboard.saveButton.click();
        extentTest.info("Save buttonuna tiklandi.");
        ReusableMethods.wait(1);
        merchant_dashboard.updateButton.click();
        extentTest.info("Update buttonuna tiklandi.");
        merchant_dashboard.sizeNameBox.clear();
        merchant_dashboard.sizeNameBox.sendKeys(updateName);
        extentTest.info("Name box taki eski isim silinip guncel isim girildi");
        merchant_dashboard.saveButton.click();
        extentTest.info("Save buttonuna tiklandi.");
        ReusableMethods.wait(1);
        softAssert.assertTrue(merchant_dashboard.succesfullyUpdatedYazisi.isDisplayed(), "update basarisiz");
        merchant_dashboard.ingredientsLinkiActive.click();
        extentTest.info("Liste sayfasina donuldu");
        String eklenenName=merchant_dashboard.listIlkName.getText();
        softAssert.assertEquals(updateName+" Publish",eklenenName);
        extentTest.info("Update edilen urun kontrol edildi.");
        merchant_dashboard.deleteButtonSizeAll.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibility(merchant_dashboard.deleteConfirmationButton,2);
        merchant_dashboard.deleteConfirmationButton.click();
        softAssert.assertAll();
        extentTest.pass("Ingredients List sayfasinde urun basariyla update edildi.");
    }

    @Test
    public void tc03212_urunIsimGirme() {
        softAssert=new SoftAssert();
        extentTest = extentReports.createTest("Ingredients Liste sadece ozel karekter ya da rakamlardan olusan isim girme testi",
                "Ingredients Liste sadece ozel karekter ya da rakamlardan olusan isim girilmemeli");
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        //ReusableMethods.waitForClickablility(merchant_dashboard.attributesLinki,2);
        merchant_dashboard.attributesLinki.click();
        merchant_dashboard.ingredientsLinki.click();
        extentTest.info("Merchant sayfasına girildi.");
        merchant_dashboard.addNewButton.click();
        extentTest.info("Add New buttonuna tiklandi.");
        String addSizeNameOzelKarakter=",;*+-";
        merchant_dashboard.sizeNameBox.sendKeys(addSizeNameOzelKarakter);
        extentTest.info("Name box sadece ozel karakterlerden olusan isim girildi.");
        merchant_dashboard.saveButton.click();
        extentTest.info("Save buttonuna tiklandi.");
        String eklenenNameOzelKarakter=merchant_dashboard.listIlkName.getText();
        softAssert.assertNotEquals(addSizeNameOzelKarakter+" Publish",eklenenNameOzelKarakter,"Size Liste sadece ozel karekterli isim eklendi");
        extentTest.info("Sadece ozel karakterlerden olusan urunun eklenebildiği test edildi.");
        merchant_dashboard.deleteButtonSizeAll.click();
        ReusableMethods.waitForVisibility(merchant_dashboard.deleteConfirmationButton,2);
        merchant_dashboard.deleteConfirmationButton.click();
        extentTest.info("Eklenen urun silindi.");

        merchant_dashboard.addNewButton.click();
        extentTest.info("Add New buttonuna tiklandi.");
        String addSizeNameRakam="0123456987";
        merchant_dashboard.sizeNameBox.sendKeys(addSizeNameRakam);
        extentTest.info("Name box a sadece rakamlardan olusan isim girildi.");
        merchant_dashboard.saveButton.click();
        extentTest.info("Save buttonuna tiklandi.");
        String eklenenNameRakam=merchant_dashboard.listIlkName.getText();
        softAssert.assertNotEquals(addSizeNameRakam+" Publish",eklenenNameRakam,"Size Liste sadece rakamlardan olusan isim eklendi");
        extentTest.info("Sadece rakamlardan olusan urunun eklenebildiği test edildi.");
        merchant_dashboard.deleteButtonSizeAll.click();
        ReusableMethods.waitForVisibility(merchant_dashboard.deleteConfirmationButton,2);
        merchant_dashboard.deleteConfirmationButton.click();
        extentTest.info("Eklenen urun silindi.");
        softAssert.assertAll();

        extentTest.pass("Ingredients Liste sadece ozel karekter ya da rakamlardan olusan isim girilmedi");
    }


    @Test
    public void tc03213_tekrarliIsim() {
        softAssert=new SoftAssert();
        extentTest = extentReports.createTest("Ingredients Add bolumunde aynı isimli urunun tekrarlı kayıt yapılamama testi",
                "Ingredients Add bolumunde aynı isimli urun tekrarli kayit yapilamamali");
        Faker faker=new Faker();
        String addNameStrFkr=faker.name().name();
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        ReusableMethods.waitForClickablility(merchant_dashboard.attributesLinki,2);
        merchant_dashboard.attributesLinki.click();
        merchant_dashboard.ingredientsLinki.click();
        extentTest.info("Merchant sayfasına girildi.");
        merchant_dashboard.addNewButton.click();
        extentTest.info("Add New buttonuna tiklandi.");
        merchant_dashboard.sizeNameBox.sendKeys(addNameStrFkr);
        extentTest.info("Name box yenı urun ismi yazildi.");
        merchant_dashboard.saveButton.click();
        extentTest.info("Save buttonuna tiklandi.");
        String eklenenName1=merchant_dashboard.listIlkName.getText();

        merchant_dashboard.addNewButton.click();
        extentTest.info("Add New buttonuna tiklandi.");
        merchant_dashboard.sizeNameBox.sendKeys(addNameStrFkr);
        extentTest.info("Name box a ayni isimli urun tekrar yazildi.");
        merchant_dashboard.saveButton.click();
        String eklenenName2=merchant_dashboard.listIlkName.getText();
        extentTest.info("Save buttonuna tiklandi.");

        softAssert.assertNotEquals(eklenenName1,eklenenName2);

        merchant_dashboard.deleteButtonSizeAll.click();

        ReusableMethods.waitForVisibility(merchant_dashboard.deleteConfirmationButton,2);
        merchant_dashboard.deleteConfirmationButton.click();

        merchant_dashboard.deleteButtonSizeAll.click();
        ReusableMethods.waitForVisibility(merchant_dashboard.deleteConfirmationButton,2);
        merchant_dashboard.deleteConfirmationButton.click();
        softAssert.assertAll();
        extentTest.pass("Ingredients Add bolumunde aynı isimli urunun kayıt yapılmadigi test edildi");
    }


    @Test
    public void tc03214_searchBox() {
        softAssert=new SoftAssert();
        extentTest = extentReports.createTest("Ingredients List sayfasinda search box testi",
                "Ingredients List sayfasinda search box ta arama yapilmali");
        Faker faker=new Faker();
        String addNameStrFkr=faker.name().name();
        merchant_dashboard = new Merchant_Dashboard();
        ReusableMethods.merchantLogin();
        //ReusableMethods.wait(1);
        //ReusableMethods.waitForClickablility(merchant_dashboard.attributesLinki,2);
        merchant_dashboard.attributesLinki.click();
        merchant_dashboard.ingredientsLinki.click();
        extentTest.info("Merchant sayfasına girildi.");

        merchant_dashboard = new Merchant_Dashboard();
        merchant_dashboard.addNewButton.click();
        extentTest.info("Add New buttonuna tiklandi.");
        merchant_dashboard.sizeNameBox.sendKeys(addNameStrFkr);
        extentTest.info("Name box yeni urunun ismi yazildi.");
        merchant_dashboard.saveButton.click();
        extentTest.info("Save buttonuna tiklandi.");
        String eklenenName=merchant_dashboard.listIlkName.getText();
        merchant_dashboard.searchSizeBox.sendKeys(addNameStrFkr, Keys.ENTER);
        extentTest.info("Search box a eklenen urunun ismi yazilip enter a basildi.");
        String arananName=merchant_dashboard.listIlkName.getText();
        softAssert.assertEquals(eklenenName,arananName);
        merchant_dashboard.deleteButtonSizeAll.click();
        ReusableMethods.waitForVisibility(merchant_dashboard.deleteConfirmationButton,2);
        merchant_dashboard.deleteConfirmationButton.click();
        softAssert.assertAll();
        extentTest.pass("Ingredients List sayfasinda search box ta arama basariyla yapildi.");
    }
}
