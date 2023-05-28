package tests.US_007_018_033_040;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_Homepage;
import utilities.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US_007 extends TestBaseRapor {


    User_Homepage user_homepage;
    Actions actions;
    SoftAssert softAssert;

    @Test
    public void contactUsLinkSeen() {
        softAssert=new SoftAssert();
        extentTest = extentReports.createTest("contact Us Link Seen on home page ");
        user_homepage = new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("browser opened.");
        extentTest.info("I went to the main page and logged in with the user information.");
        String expectedUrl = ConfigReader.getProperty("userUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.equals(expectedUrl));
        softAssert.assertTrue(user_homepage.ilkLogoElementi.isDisplayed());
        extentTest.info("verified via url that the correct page was opened");
        //5) sayfayi en alta indirir
        JSUtilities.scrollToBottom(Driver.getDriver());
        extentTest.info("The page has been downloaded to the bottom.");
        //6)Anasayfa uzerinde contuct us linkinin gorunur oldugunutest eder.
        softAssert.assertTrue(user_homepage.contactusLinkElementi.isDisplayed());
        extentTest.info("verified contact Us Link Seen on home page");
        extentTest.info("the browser closes.");
        softAssert.assertAll();
        extentTest.pass(" contact Us Link Seen on home page succesfull");


    }

    @Test
    public void contactUsPageAccessTest() {
        softAssert=new SoftAssert();
        extentTest = extentReports.createTest("contactUsPageAccessTest");
        user_homepage = new User_Homepage();//class levelda olusturulup deger atamasi yapılmadi icin
        actions = new Actions(Driver.getDriver());
        extentTest.info("browser opened.");
        ReusableMethods.goTouserHomePage();
        extentTest.info("I went to the main page and logged in with the user information.");
        actions.sendKeys(Keys.CONTROL).keyDown(Keys.END).perform();
        ReusableMethods.wait(2);
        user_homepage.contactusLinkElementi.click();
        extentTest.info("The contact us link was clicked on the home page.");
        String expectedIcerik = "contactus";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedIcerik));
        extentTest.info("It has been confirmed that the contact us page has been verified.");
        extentTest.info("the browser closes.");
        softAssert.assertAll();
        extentTest.pass("Contact us page has been successfully reached.");
    }

    @Test
    public void verificationOfContactInformationTest() {
        softAssert=new SoftAssert();
        extentTest = extentReports.createTest("verification Of Contact Information Test");
        user_homepage = new User_Homepage();
        actions = new Actions(Driver.getDriver());
        extentTest.info("browser opened.");
        ReusableMethods.goTouserHomePage();
        extentTest.info("The main page was accessed via the valid url.");
        actions.sendKeys(Keys.CONTROL).keyDown(Keys.END).perform();
        extentTest.info("The page has been downloaded to the bottom.");
        ReusableMethods.wait(2);
        user_homepage.contactusLinkElementi.click();
        extentTest.info("The contact us link was clicked on the home page.");
        String expectedSitePhoneNumber = ConfigReader.getProperty("sitePhoneNumber");
        String expectedSiteContactGmail = ConfigReader.getProperty("siteContactGmail");
        String actualPhoneNummer = user_homepage.contactPhoneNumberElementi.getText();
        String actualContactGmail = user_homepage.contactGmailElementi.getText();
        softAssert.assertEquals(actualPhoneNummer, expectedSitePhoneNumber);
        extentTest.info("phone number has been verified.");
        softAssert.assertEquals(actualContactGmail, expectedSiteContactGmail);
        extentTest.info("gmail has been verified.");
        extentTest.info("the browser closes.");
        softAssert.assertAll();
        extentTest.pass("phone number and gmail appeared to be correct.");

    }

    @Test
    public void contactMessageSendingTest() {
        softAssert=new SoftAssert();
        extentTest = extentReports.createTest("contact Message Sending Test");
        extentTest.info("browser opened.");
        user_homepage = new User_Homepage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.goTouserHomePage();
        extentTest.info("The main page was accessed via the valid url.");
        actions.sendKeys(Keys.CONTROL).keyDown(Keys.END).perform();
        extentTest.info("The page has been downloaded to the bottom.");
        ReusableMethods.wait(2);
        user_homepage.contactusLinkElementi.click();
        extentTest.info("The contact us link was clicked on the home page.");
        actions.sendKeys(user_homepage.contactPageFulnameBox, "mehmet test")
                .sendKeys(Keys.TAB)
                .sendKeys("merden25@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Bu bir test mesajidir").perform();
        extentTest.info("contact information filled");
        user_homepage.contactPageSubmitButton.click();
        extentTest.info("clicked the send button.");
        softAssert.assertTrue(user_homepage.successfulMessageElementi.isDisplayed());
        extentTest.info("Message sending successful message has been verified.");
        extentTest.info("the browser closes.");
        softAssert.assertAll();
        extentTest.pass("The user can successfully send a message.");

    }

}
