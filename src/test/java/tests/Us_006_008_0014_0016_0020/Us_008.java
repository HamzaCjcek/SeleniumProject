package tests.Us_006_008_0014_0016_0020;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

import java.util.List;

public class Us_008 extends TestBaseRapor {
    static User_Homepage user_homepage=new User_Homepage();
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public static void beforeClass()
    {
        extentTest=extentReports.createTest("Us_008","Orders And Payment");

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Cookie Kabul
        user_homepage.cookieAcceptButton.click();
    }
    @Test
    public void test()
    {

        //Terms and conditions locate
        Actions actions=new Actions(Driver.getDriver());

        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(1);

        user_homepage.Termsandconditions.click();
        //Url 'de terms and conditions olup olmadığını test et
        String testurl="terms-and-conditions";
        String url =  Driver.getDriver().getCurrentUrl();//terms-and-conditions
        //Assert.assertTrue(url.contains(testurl));
        softAssert.assertTrue(url.contains(testurl));
        if (url.contains(testurl)==true)
        {
            extentTest.pass("Url terms and conditions İçeriyor");
        }
        else
        {
            extentTest.fail("Url terms and conditions İçermiyor");
        }
        Boolean ok=false;
        List<WebElement> h2 =Driver.getDriver().findElements(By.xpath("//h2"));
        for (WebElement each:h2
        ) {

            if(each.getText().contains("Orders and Payment"))
            {
                System.out.println("Sayfada Orders and Payment Bulunmaktadır");
                extentTest.pass("Sayfada Orders and Payment Bulunmaktadır");
                System.out.println("--------------------------------------------------------");
                ok=true;
            }
            System.out.println(each.getText());
            extentTest.info(each.getText());

        }
        extentTest.info("--------------------------------------------------------");
        if (ok==true)
        {}
        else
        {
            System.out.println("Sayfada Orders and Payment Bulunmamaktadır");
            extentTest.fail("Sayfada Orders and Payment Bulunmamaktadır");
        }
        System.out.println("--------------------------------------------------------");
        // ORDER AND Payment Açıklamasını Yazdır
        WebElement orderandpayment = user_homepage.Termsandconditionsaciklama1;
        WebElement orderandpayment2 = user_homepage.Termsandconditionsaciklama2;
        extentTest.info("Order And Payment ilk metin yazısının görünüp görünmediği kontrolü :"+ " " +user_homepage.Termsandconditionsaciklama1.isDisplayed());
        extentTest.info("Order And Payment ikinci metin yazısının görünüp görünmediği kontrolü :"+ " " +user_homepage.Termsandconditionsaciklama2.isDisplayed());
        extentTest.pass("Order and Payment");
        extentTest.info(orderandpayment.getText());
        extentTest.info(orderandpayment2.getText());
    }
    @AfterClass
    public static void AfterClass()
    {
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}
