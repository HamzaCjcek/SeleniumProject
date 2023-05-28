package tests.Us_006_008_0014_0016_0020;

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

public class Us_0016 extends TestBaseRapor {
    static User_Homepage user_homepage=new User_Homepage();
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public static void beforeClass()
    {
        extentTest=extentReports.createTest("Us_0016","Update");

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
        //System.out.println(profilsimge.isDisplayed());
        softAssert.assertTrue(profilsimge.isDisplayed());
        if(profilsimge.isDisplayed()==true)
        {
            extentTest.pass("Profil simgesinin görünürlüğü : " +String.valueOf(profilsimge.isDisplayed()));
        }
        else
        {
            extentTest.fail("Profil simgesinin görünürlüğü : " +String.valueOf(profilsimge.isDisplayed()));
        }
        // Profil DropDown Tıklanması
        user_homepage.nameButton.click();
        // DropDown'dan  Manage my account kısmına tıklanması
        user_homepage.dropDownManageMyAccount.click();
        // Url Kontrol
        String Manageurl = Driver.getDriver().getCurrentUrl();
        String Managetesturl ="account";
        softAssert.assertTrue(Manageurl.contains(Managetesturl));
        if(Manageurl.contains(Managetesturl)==true)
        {
            extentTest.pass("Url kontrolü : True ");
        }
        else
        {
            extentTest.fail("Url kontrolü : Fail ");
        }
        extentTest.info("Adres eklenmiş Home olan veriyi Work olarak Update Ve Eklenen Adres Silinme İşlemi Yapılmıştır");
        extentTest.info("Adres olarak 10010 seçilmiştir");
        ReusableMethods.waitFor(2);
        //Address Kısmına Tıkla
        user_homepage.dropDownManageMyAccountAddress.click();
        //Address Ekle Butonuna Tıkla
        user_homepage.dropDownManageMyAccountAddButtonAddress.click();
        //Çıkan Textbox
        WebElement address =user_homepage.dropDownManageMyAccountAddButtonAddress_AddressNumber_TextBox;
        //Textbox'a tıkla içine veri ekle
        address.click();
        address.sendKeys("10010");
        ReusableMethods.waitFor(5);
        //Çıkan İlk veriye tıkla
        user_homepage.dropDownManageMyAccountAddButtonAddress_AddressNumber_TextBox_VeriEkleme.click();
        ReusableMethods.waitFor(5);
        //Button'a Tıkla
        user_homepage.dropDownManageMyAccountAddButtonAddress_AddressNumber_TextBox_VeriEkleme_SaveButton.click();
        //Edit buttonuna Tıkla
        user_homepage.dropDownManageMyAccountAddButtonAddress_Edit.click();
        ReusableMethods.waitFor(5);
        //Home'ı Work Olarak Güncelle
        user_homepage.dropDownManageMyAccountAddButtonAddress_Edit_WorkButton.click();
        //Button'a Tıkla
        user_homepage.dropDownManageMyAccountAddButtonAddress_Edit_WorkButton_AcceptButton.click();
        //Delete Silme Buttonu Testi
        ReusableMethods.waitFor(2);
        WebElement Delete= user_homepage.dropDownManageMyAccountAddButtonAddress_Delete;
        Delete.click();
        user_homepage.dropDownManageMyAccountAddButtonAddress_Delete_Accept.click();


    }
    @AfterClass
    public static void AfterClass()
    {
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}
