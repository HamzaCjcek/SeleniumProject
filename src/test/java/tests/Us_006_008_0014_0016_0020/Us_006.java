package tests.Us_006_008_0014_0016_0020;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
import java.io.IOException;


public class Us_006 extends TestBaseRapor {
    static User_Homepage user_homepage=new User_Homepage();
    SoftAssert softAssert = new SoftAssert();
    @Test (groups = "smoke")
    public void test() throws IOException {


        extentTest=extentReports.createTest("Us_006","Siteye Kayıt");

        User_Homepage user_homepage=new User_Homepage();
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Cookie Kabul
        user_homepage.cookieAcceptButton.click();

        //Sign in Button Tıklama
        user_homepage.signInButton.click();
        extentTest.info("SignIn Buttonun Görünürlüğü :"+ " " +user_homepage.signInButton.isDisplayed());
        // Yeni Açılan Pencerede href olan sign in tıkla
        WebElement hrefsignin= user_homepage.signIn_in_signIn;
        extentTest.info(" href SignIn Buttonun Görünürlüğü :"+ " " +user_homepage.signIn_in_signIn.isDisplayed());
        hrefsignin.click();
        //Yeni Açılan Sayfada bütün textbox'ları faker kütüphanesi ile deneme
        WebElement isimKutusu= user_homepage.signIn_in_signIn_firstname;
        Actions actions= new Actions(Driver.getDriver());
        Faker faker= new Faker();
        String fakeEmailAdress=faker.internet().emailAddress();
        String fakerpassword=faker.internet().password()+"@";
        String fakername=faker.name().firstName();
        Keys enter_key = Keys.ENTER;
        System.out.println(enter_key);
        actions.click(isimKutusu)
                .sendKeys(fakername)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(10))
                .sendKeys(Keys.TAB)
                .sendKeys(fakerpassword)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerpassword)
                .sendKeys(enter_key).perform();
        ReusableMethods.wait(0.5);
        String name ="TC_006_01 ";
        ReusableMethods.getScreenshot(name);
        extentTest.info("Girilen Mail Adresi :" +" "+ fakeEmailAdress);
        extentTest.info("Girilen Password :" + " "+fakerpassword);
        extentTest.info("Girile İsim :"+ " "+fakername);
        //Profil simgesinin görünüp görünmediği kontrol edildi
        WebElement profil= user_homepage.profiliconimg;
        //Assert.assertTrue(profil.isDisplayed());
        softAssert.assertTrue(profil.isDisplayed());
        extentTest.pass("Profil simgesinin görünüp görünmediği kontrolü :"+ " " +profil.isDisplayed());
        //Profil simgesinin görünüp görünmediği kontrol edildi
        WebElement profilsimge= user_homepage.profiliconimg;
        softAssert.assertTrue(profilsimge.isDisplayed());
        extentTest.pass("Profil simgesinin görünürlüğü : " +String.valueOf(profilsimge.isDisplayed()));
        // Profil DropDown Tıklanması
        user_homepage.nameButton.click();
        // DropDown'dan  Manage my account kısmına tıklanması
        user_homepage.dropDownManageMyAccount.click();
        // Url Kontrol
        String Manageurl = Driver.getDriver().getCurrentUrl();
        String Managetesturl ="account";
        softAssert.assertTrue(Manageurl.contains(Managetesturl));
        if(Manageurl.contains(Managetesturl))
        {
            extentTest.pass("Url kontrolü sonucu : Başarılı ");
        }
        else
        {
            extentTest.fail("Url kontrolü sonucu : Hatalı ");
        }
        // Profil İconun yazısının Görünüp Görünmediği Kontrol
        WebElement profiltext= user_homepage.managerprofiltext;
        //Assert.assertTrue(profiltext.isDisplayed());
        softAssert.assertTrue(profiltext.isDisplayed());
        extentTest.pass("Profil simgesinin görünüp görünmediği kontrolü :"+ " " +profiltext.isDisplayed());
        if (profiltext.isDisplayed()==true)
        {
            extentTest.pass("Profil Text Görüntülendi");
        }
        else
        {
            extentTest.fail("Profil Text Görüntülenmedi");
        }
        // ScreenShot
        ReusableMethods.waitFor(2);
        String name2 ="TC_006_02 ";
        ReusableMethods.getScreenshot(name2);
        Driver.closeDriver();
    }

}
