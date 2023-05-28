package tests.US_001_002_003_004;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.*;

import java.io.IOException;

public class US_002 extends TestBaseRapor {
    User_Homepage user_homepage=new User_Homepage();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void headerTest01() throws IOException {
        extentTest=extentReports.createTest("Homepage Header Test");
        user_homepage=new User_Homepage();
        softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Access to the homepage");
        user_homepage.cookieAcceptButton.click();
        extentTest.info("Cookies accepted");
        String expectedTitle= "Meals Center";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);
        extentTest.info("Title Visibility Tested");
        softAssert.assertTrue(user_homepage.mealscenterButton.isDisplayed());
        extentTest.info("Meals Center Button Visibility Tested");
        softAssert.assertTrue(user_homepage.mainBanner.isDisplayed());
        extentTest.info("Main Banner Visibility Tested");
        softAssert.assertTrue(user_homepage.headerScript.isDisplayed());
        extentTest.info("Header Script Visibility Tested");
        String headerTest="US_002_ScreenShot";
        ReusableMethods.getScreenshot(headerTest);
        extentTest.pass("PASSED");
        softAssert.assertAll();
    }

    @Test
    public void headerTest02(){
        extentTest=extentReports.createTest("Cart Button Test");
        user_homepage=new User_Homepage();
        softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Access to the homepage");
        ReusableMethods.waitForPageToLoad(5);
        user_homepage.cartLinki.click();
        extentTest.info("Cart Button Clicked");
        softAssert.assertTrue(user_homepage.cartScript.isDisplayed());
        extentTest.pass("PASSED");
        softAssert.assertAll();
    }

    @Test
    public void headerTest03(){
        extentTest=extentReports.createTest("Cart Image Test");
        user_homepage=new User_Homepage();
        softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Access to the homepage");
        ReusableMethods.waitForPageToLoad(5);
        user_homepage.cartImage.click();
        extentTest.info("Cart Image Clicked");
        softAssert.assertTrue(user_homepage.cartScript.isDisplayed());
        extentTest.pass("PASSED");
        softAssert.assertAll();
    }

    @Test
    public void headerTest04(){
        extentTest=extentReports.createTest("Sigin Button Test");
        user_homepage=new User_Homepage();
        softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Access to the homepage");
        ReusableMethods.waitForPageToLoad(5);
        user_homepage.signInButton.click();
        extentTest.info("Signin Button Clicked");
        ReusableMethods.waitForPageToLoad(5);
        String expectedUrl="https://qa.mealscenter.com/account/login";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("PASSED");
        softAssert.assertAll();
    }

    @Test
    public void headerTest05(){
        extentTest=extentReports.createTest("Seachbox Test");
        User_Homepage user_homepage=new User_Homepage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Access to the homepage");
        ReusableMethods.waitForPageToLoad(5);
        user_homepage.cookieAcceptButton.click();
        extentTest.info("Cookies accepted");
        user_homepage.searchBox.sendKeys("10001");
        extentTest.info("SendKeys to the Searchbox");
        user_homepage.searchBoxIlkElement.click();
        extentTest.info("First Webelement Clicked");
        ReusableMethods.wait(3);
        String expectedZipCode="10001";
        String actualZipCode= user_homepage.restaurantsAdresSatiri.getText();
        Assert.assertTrue(actualZipCode.contains(expectedZipCode));
        extentTest.pass("PASSED");
        softAssert.assertAll();
    }



}

