package tests.Us_006_008_0014_0016_0020;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class Us_0014 extends TestBaseRapor {
    static User_Homepage user_homepage=new User_Homepage();
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public static void beforeClass()
    {
        extentTest=extentReports.createTest("Us_0014","Update");

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Cookie Kabul
        user_homepage.cookieAcceptButton.click();

    }
    @Test
    public void test() throws IOException {

        ReusableMethods.userLoginMethod("hamzaUserName","hamzaPasswordUser");
        extentTest.info("Girilen Mail Adresi : " + "hamzacicek@outlook.com.tr");
        extentTest.info("Girilen Password : " + "griffhmz@1082.");

        ReusableMethods.waitFor(2);
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
        extentTest.info("Update İşlemi İçin telefon numarasından 1 hane silinip test edilmiştir");
        ReusableMethods.waitFor(2);
        //Update İşlemi
        WebElement number= user_homepage.dropDownManageMyAccountTelNumberTextbox;
        ReusableMethods.waitFor(2);
        number.click();
        number.sendKeys(Keys.BACK_SPACE);
        number.sendKeys(Keys.TAB);
        number.submit();

        // ScreenShot
        String name ="TC_0014 ";
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot(name);
        //Hata Açıklaması

        extentTest.fail("Update İşlemi yapılırken onay kodu yapılıcak e-posta'nın sonuna .(nokta) eklendiği için onay kodu mail'e gelmiyor");
        extentTest.fail("Hata'nın SS i alınmıştır Dosya Adı :" + name);
    }
    @AfterClass
    public static void AfterClass()
    {
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}
