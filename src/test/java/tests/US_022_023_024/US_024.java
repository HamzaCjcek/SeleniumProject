package tests.US_022_023_024;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.Merchant_Dashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class US_024 extends TestBaseRapor {
    Merchant_Dashboard merchant_dashboard = new Merchant_Dashboard();

    Actions actions;

    @Test

    public void test01() {
        merchant_dashboard = new Merchant_Dashboard();

        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("profilegitme", "profilegitme2");

        ReusableMethods.merchantLogin();

        extentTest.info("kullanıcı adı ve şifre ile giriş yapıldı.");


        merchant_dashboard.FoodButonu.click();

        extentTest.info("Food Butonuna basıldı.");

        merchant_dashboard.CategoryButonu.click();

        extentTest.info("Category Butonuna basıldı.");

        assertTrue(merchant_dashboard.CategoryListYazısı.isDisplayed());

        extentTest.pass("Category Sayfasına gittiğim doğrulanır.");


    }

    @Test
    public void test02() {
        merchant_dashboard = new Merchant_Dashboard();

        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("profilegitme", "profilegitme2");

        ReusableMethods.merchantLogin();

        extentTest.info("kullanıcı adı ve şifre ile giriş yapıldı.");


        merchant_dashboard.FoodButonu.click();

        extentTest.info("Food Butonuna basıldı.");

        merchant_dashboard.CategoryButonu.click();

        extentTest.info("Category Butonuna basıldı.");

        assertTrue(merchant_dashboard.CategoryListYazısı.isDisplayed());

        extentTest.pass("Category Sayfasına gittiğim doğrulanır.");

        assertTrue(merchant_dashboard.SignatureRoll.isEnabled());

        extentTest.pass("Signature Roll kategorisinin erişilebilirliği test edildi");

        assertTrue(merchant_dashboard.MakiandclassicRoll.isEnabled());

        extentTest.pass("MakiandclassicRoll kategorisinin erişilebilirliği test edildi");

        assertTrue(merchant_dashboard.Sushibox.isEnabled());

        extentTest.pass("Sushibox kategorisinin erişilebilirliği test edildi");

        assertTrue(merchant_dashboard.PickedForYou.isEnabled());

        extentTest.pass("PickedForYou kategorisinin erişilebilirliği test edildi");


    }

    @Test (groups = "smoke")
    public void test03() {
        merchant_dashboard = new Merchant_Dashboard();

        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("profilegitme", "profilegitme2");

        ReusableMethods.merchantLogin();

        extentTest.info("kullanıcı adı ve şifre ile giriş yapıldı.");


        merchant_dashboard.FoodButonu.click();

        extentTest.info("Food Butonuna basıldı.");

        merchant_dashboard.CategoryButonu.click();

        extentTest.info("Category Butonuna basıldı.");

        merchant_dashboard.AddNewButonu.click();


        extentTest.info("AddNew Butonuna basıldı.");

        merchant_dashboard.NameBox.sendKeys("mehmet");

        extentTest.info("Name boxına isim yazıldı.Böylece erişebilirliğide test edildi.");

        merchant_dashboard.Descriptionbox.sendKeys("Bu menü çok lezzetlidir.");

        extentTest.info("Description boxına tanım yazıldı.Böylece erişebilirliğide test edildi.");

        merchant_dashboard.Browsebox1.click();

        extentTest.info("Browse1 boxına tıklanır.");

        ReusableMethods.waitForPageToLoad(5);

        merchant_dashboard.FeaturedImage.click();

        extentTest.info("FeaturedImage için bir resim seçildi.");

        ReusableMethods.wait(2);

        merchant_dashboard.AddFilesButonu.click();

        extentTest.info("AddFiles butonuna tıklandı");

        ReusableMethods.wait(3);

        merchant_dashboard.Browsebox2.click();

        extentTest.info("browse2 boxına tıklandı");

        ReusableMethods.waitForVisibility(merchant_dashboard.IconImage, 5);

        merchant_dashboard.IconImage.click();

        extentTest.info("IconImage için bir resim seçildi.");

        merchant_dashboard.AddFiles2.click();

        extentTest.info("AddFiles2 butonuna tıklandı");

        ReusableMethods.waitForVisibility(merchant_dashboard.DishBox, 3);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(2);

        merchant_dashboard.DishBox.click();

        actions.sendKeys(Keys.ENTER).perform();


        extentTest.info("Dish Boxı için Meal seçeneği seçildi.");

        Select select = new Select(merchant_dashboard.StatusBox);

        select.selectByVisibleText("Draft");


        extentTest.info("Status boxı için seçim yapıldı.");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(1);

        merchant_dashboard.Savebox.click();

        extentTest.info("Yapılan değişiklikler kaydedildi.");

        assertTrue(merchant_dashboard.SuccesfullyCreatedYazısı.isDisplayed());

        extentTest.pass("Değişikliklerin başarıyla yapıldığı test edildi.");


    }

    @Test
    public void test04() {
        merchant_dashboard = new Merchant_Dashboard();


        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("update", "update2");

        ReusableMethods.merchantLogin();

        extentTest.info("kullanıcı adı ve şifre ile giriş yapıldı.");

        merchant_dashboard.FoodButonu.click();

        extentTest.info("Food Butonuna basıldı.");

        merchant_dashboard.CategoryButonu.click();

        extentTest.info("Category Butonuna basıldı.");

        merchant_dashboard.UpdateButonu.click();

        extentTest.info("Update butonuna basıldı.");


        assertTrue(merchant_dashboard.DetailsBox.isDisplayed());

        extentTest.pass("Update sayfasında olduğum doğrulandı.");

        merchant_dashboard.NameBox.sendKeys("mehmet2");

        extentTest.info("Name boxına isim yazıldı.Böylece erişebilirliğide test edildi.");

        merchant_dashboard.Descriptionbox.sendKeys("  Bu menü çok lezzetlidir.");

        extentTest.info("Description boxına tanım yazıldı.Böylece erişebilirliğide test edildi.");

        merchant_dashboard.Browsebox1.click();

        extentTest.info("Browse1 boxına tıklanır.");

        ReusableMethods.waitForPageToLoad(5);

        merchant_dashboard.UpdateFeaturedImage.click();

        extentTest.info(" Update FeaturedImage için bir resim seçildi.");

        ReusableMethods.wait(2);

        merchant_dashboard.AddFilesButonu.click();

        extentTest.info("AddFiles butonuna tıklandı");


        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(3);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(3);

        merchant_dashboard.Savebox.click();

        extentTest.info("Yapılan değişiklikler kaydedildi.");

        assertTrue(merchant_dashboard.UpdatedYazısı.isDisplayed());

        extentTest.pass("Değişikliklerin başarıyla yapıldığı test edildi.");


    }


    @Test
    public void test05() {

        merchant_dashboard = new Merchant_Dashboard();

        extentTest = extentReports.createTest("profilegitme", "profilegitme2");

        ReusableMethods.merchantLogin();

        extentTest.info("kullanıcı adı ve şifre ile giriş yapıldı.");


        merchant_dashboard.FoodButonu.click();

        extentTest.info("Food Butonuna basıldı.");

        merchant_dashboard.CategoryButonu.click();

        extentTest.info("Category Butonuna basıldı.");

        String SilinmedenÖnce=merchant_dashboard.EntryYazısı.getText();

        merchant_dashboard.DeleteButonu.click();

        extentTest.info("Delete Butonuna Basıldı.");

        merchant_dashboard.DeleteConfirmation.click();

        extentTest.info("Delete işlemi Doğrulandı.");

///asdfghj


        String SilindiktenSonra=merchant_dashboard.EntryYazısı.getText();

        System.out.println(SilinmedenÖnce);

        System.out.println(SilindiktenSonra);






    }


}
