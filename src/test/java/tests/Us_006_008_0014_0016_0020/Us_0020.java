package tests.Us_006_008_0014_0016_0020;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_0020 extends TestBaseRapor {
    static User_Homepage user_homepage=new User_Homepage();
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public static void beforeClass()
    {
        extentTest=extentReports.createTest("Us_0020","BecomeYourPartner");

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Cookie Kabul
        user_homepage.cookieAcceptButton.click();
    }
    @Test
    public void test()
    {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(2);
        //Become Your Partner Click
        user_homepage.becomeyourpartner.click();
        softAssert.assertTrue(user_homepage.becomeyourpartner.isDisplayed());
        if(user_homepage.becomeyourpartner.isDisplayed()==true)
        {
            extentTest.pass("Become Your Partner Sayfada Var Mı : True" );
        }
        else
        {
            extentTest.fail("Become Your Partner Sayfada Var Mı : False" );
        }
        //Login here xpath here
        user_homepage.becomeyourpartner_login.click();
        //Forgot Password xpath here
        user_homepage.becomeyourpartner_login_forgotpassword.click();
        //Url Test
        String url= Driver.getDriver().getCurrentUrl();
        String icericekUrl="resetpswd";
        softAssert.assertTrue(url.contains(icericekUrl));
        if(url.contains(icericekUrl)==true)
        {
            extentTest.pass("Url Test(resetpswd içeriyor mu?) : True" );
        }
        else
        {
            extentTest.fail("Url Test(resetpswd içeriyor mu?) : False" );
        }
        //Sayfa Başlığı Forgot Password xpath here
        System.out.println(user_homepage.becomeyourpartner_login_forgotpassword_header.getText());
        extentTest.info("Sayfa Başlığı Forgot Password :" + user_homepage.becomeyourpartner_login_forgotpassword_header.getText());
        //Sayfa Başlığı Forgot Password Açıklaması xpath here
        System.out.println(user_homepage.becomeyourpartner_login_forgotpassword_info.getText());
        extentTest.info("Sayfa Başlığı Forgot Password Açıklaması :" + user_homepage.becomeyourpartner_login_forgotpassword_info.getText());

    }
    @AfterClass
    public static void AfterClass()
    {
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}
