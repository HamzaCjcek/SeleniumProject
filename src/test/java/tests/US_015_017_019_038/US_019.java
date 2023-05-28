package tests.US_015_017_019_038;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Merchant_Dashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_019 extends TestBaseRapor {

    Merchant_Dashboard merchant = new Merchant_Dashboard();
    SoftAssert softAssert = new SoftAssert();


    @DataProvider
    public static Object[][] users() {

        Object[][] userList={{" ","1234567"},
                {"umisakehouseAdmin"," "},
                {"umisakehouseAdmin@gmail.com","0000000"},
                {"umisakehouseAdmingmail.com","1234567"},
                {"umisakehouseAdmin@gmail","A12345678"}};

        return userList;
    }

    @Test (groups = "smoke")
    public void merchantTest01() {
        merchant=new Merchant_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Test that the restaurant owner can access the Merchant panel");
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Navigated to Merchant login page");
        ReusableMethods.wait(0.1);
        softAssert.assertTrue(merchant.loginImage.isDisplayed());
        extentTest.info("Verified that the image is visible on the landing page");
        softAssert.assertTrue(merchant.textMerchantLogin.isDisplayed());
        extentTest.info("Verified visibility of merchant login text");
        softAssert.assertTrue(merchant.amblem.isDisplayed());
        extentTest.info("Meals centre logo confirmed to be visible");
        softAssert.assertTrue(merchant.usernameBox.isEnabled());
        extentTest.info("Verified that the Username box is accessible");
        softAssert.assertTrue(merchant.passwordBox.isEnabled());
        extentTest.info("Verified that the Password box is accessible");
        softAssert.assertTrue(merchant.rememberMeKutucuk.isEnabled());
        extentTest.info("Confirmed that the box next to Remember me is clickable");
        softAssert.assertTrue(merchant.playStoreLink.isDisplayed());
        extentTest.info("Visibility of Application download (play store) button verified");
        softAssert.assertTrue(merchant.appStoreLink.isDisplayed());
        extentTest.info("Visibility of Application download (app store) button verified");
        extentTest.pass("Confirmed that the restaurant owner has access to the Merchant dashboard");
        softAssert.assertAll();
    }

    @Test (groups = "smoke", dataProvider = "users")
    public void merchantTest02(String user,String password) {
        merchant=new Merchant_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Test that the restaurant owner cannot log in to the Merchant dashboard with invalid information");
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Navigated to Merchant login page");
        ReusableMethods.wait(0.1);
        merchant.usernameBox.sendKeys(user + Keys.TAB);
        //extentTest.info("Invalid username typed in username box");
        merchant.passwordBox.sendKeys(password + Keys.ENTER);
        //extentTest.info("Invalid password was typed in the Password box and Sign in button was pressed");
        softAssert.assertTrue(merchant.requiredText.isDisplayed());
        extentTest.info("'Value must be entered' appeared under the tiles");
        softAssert.assertTrue(merchant.incorrectText.isDisplayed());
        extentTest.info("'Incorrect username or password' appeared under the tiles");
        String actualUrl = ConfigReader.getProperty("merchantUrl");
        String expectedUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Verified inability to log in with invalid information");
        softAssert.assertAll();

    }

    @Test (groups = "smoke")
    public void merchantTest03(){
        merchant=new Merchant_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Test that the restaurant owner can log in to the Merchant dashboard with valid information");
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Navigated to Merchant login page");
        ReusableMethods.wait(0.1);
        merchant.usernameBox.sendKeys(ConfigReader.getProperty("merchantUsername"));
        extentTest.info("Valid username typed in the username box");
        merchant.passwordBox.sendKeys(ConfigReader.getProperty("merchantPassword"));
        extentTest.info("Valid password typed in the Password box");
        merchant.signInButton.click();
        extentTest.info("Merchant sign in button clicked");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.mealscenter.com/backoffice/merchant/dashboard";
        softAssert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Verified login with valid information");
        softAssert.assertAll();
    }

   /* @BeforeMethod
    public void before(){
        merchant=new Merchant_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Access test to Merchant page");
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Navigated to Merchant login page");

    }*/

    @AfterMethod
    public void tearDown(){
        merchant=new Merchant_Dashboard();
        softAssert = new SoftAssert();
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
