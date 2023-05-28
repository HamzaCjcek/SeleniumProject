package tests.US_001_002_003_004;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.*;

import java.io.IOException;

public class US_001 extends TestBaseRapor {

    User_Homepage user_homepage=new User_Homepage();
    SoftAssert softAssert = new SoftAssert();

    @Test (groups = "smoke")
    public void homepageTest() throws IOException {
        extentTest=extentReports.createTest("access to the website","Url and Main Banner visibility test");
        user_homepage=new User_Homepage();
        softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("access to the homepage");
        ReusableMethods.waitForPageToLoad(5);
        user_homepage.cookieAcceptButton.click();
        extentTest.info("Cookies accepted");
        softAssert.assertTrue(user_homepage.mainBanner.isDisplayed());
        extentTest.info("Main Banner visibility tested");

        String expectedUrl= "https://qa.mealscenter.com/";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);
        String urlTest="US_001_ScreenShot";
        ReusableMethods.getScreenshot(urlTest);
        extentTest.pass("Url test PASSED");
        softAssert.assertAll();
    }

}
