package tests.US_001_002_003_004;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_004 extends TestBaseRapor {

    User_Homepage user_homepage=new User_Homepage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void footerTest01(){
        extentTest=extentReports.createTest("Homepage Footer Test");
        user_homepage=new User_Homepage();
        softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Access to the homepage");
        ReusableMethods.waitForPageToLoad(5);
        user_homepage.cookieAcceptButton.click();
        extentTest.info("Cookies accepted");
        softAssert.assertTrue(user_homepage.instagramButton.isDisplayed());
        softAssert.assertTrue(user_homepage.Termsandconditions.isDisplayed());
        softAssert.assertTrue(user_homepage.instagramButton.isDisplayed());
        softAssert.assertTrue(user_homepage.becomeyourpartner.isDisplayed());
        softAssert.assertTrue(user_homepage.mealscentercom.isDisplayed());
        softAssert.assertTrue(user_homepage.facebookButton.isDisplayed());
        extentTest.pass("PASSED");
        softAssert.assertAll();
    }

}

