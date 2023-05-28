package tests.US_029_034_036_037;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Admin_Dashboard;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_037 extends TestBaseRapor {

    Admin_Dashboard admin_dashboard = new Admin_Dashboard();

    @Test
    public void TC_01() {

        extentTest = extentReports.createTest("Verified that list link is visible");

        //adminStart
        ReusableMethods.adminLogin("huseyin.senol", "123456");

        extentTest.info("Logged in admin page");
        //Click the" Merchant" link
        admin_dashboard.merchantLink.click();

        extentTest.info("Merchant link is clicked");

        //Verify that list link is displayed

        Assert.assertTrue(admin_dashboard.listLink.isDisplayed());

        extentTest.info("link list is displayed");

        //Click the list link

        admin_dashboard.listLink.click();

        extentTest.info("List link is clicked");

        //Close the browser
        Driver.closeDriver();

        extentTest.info("Closed the page");

        extentTest.pass("pass");

    }

    @Test
    public void TC_02() {
        Admin_Dashboard admin_dashboard = new Admin_Dashboard();

        extentTest = extentReports.createTest("Verified that All Merchant text is visible");

        //adminStart
        ReusableMethods.adminLogin("huseyin.senol", "123456");

        //Click the" Merchant" link
        admin_dashboard.merchantLink.click();

        extentTest.info("Merchant link is clicked");

        //Click the list link

        admin_dashboard.listLink.click();

        extentTest.info("List link is clicked");

        //Verify that  "All Merchant"text is displayed

        Assert.assertTrue(admin_dashboard.allMerchantText.isDisplayed());

        extentTest.info("verified the all merchant text is visible");

        //Close the browser
        Driver.closeDriver();
        extentTest.info("Closed the page");
        extentTest.pass("pass");
    }

    @Test
    public void TC_03() {

        Admin_Dashboard admin_dashboard = new Admin_Dashboard();

        extentTest = extentReports.createTest
                ("Verified that admin can be able to see,edit and  delete information about merchants");

        //adminStart
        ReusableMethods.adminLogin("huseyin.senol", "123456");

        //Click the" Merchant" link
        admin_dashboard.merchantLink.click();

        extentTest.info("Merchant link is clicked");

        //Verify that list link is displayed

        admin_dashboard.listLink.click();

        extentTest.info("List link is clicked");

        //Click the edit link in the body part

        admin_dashboard.editLink.click();
        //ReusableMethods.wait(0.1);

        extentTest.info("edit link is clicked");

        //Fill out the requested boxes
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(admin_dashboard.restaurantnameBox).
                sendKeys("mike").
                sendKeys(Keys.TAB).
                sendKeys("mary").
                sendKeys(Keys.TAB).
                sendKeys("sos").
                sendKeys(Keys.TAB).
                sendKeys("567890").
                sendKeys(Keys.TAB).
                sendKeys("reesd@gmail.com").
                sendKeys("jake1vgfgu").
                sendKeys(Keys.TAB).
                sendKeys("jake02ghnbdfgy").
                sendKeys(Keys.TAB).
                sendKeys("abcd2ghbndfg8uıyh").
                sendKeys(Keys.TAB).
                sendKeys("345676456465445").
                sendKeys(Keys.TAB).
                sendKeys("janedoe@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("American").sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).
                sendKeys("Dinein").sendKeys(Keys.ENTER).perform();
        ReusableMethods.wait(1);
        Select select = new Select(admin_dashboard.statusboxDdm);
        select.selectByVisibleText("Pending for approval");

        JSUtilities.scrollToElement(Driver.getDriver(), admin_dashboard.merchantsaveBtn);
        ReusableMethods.wait(1);

        extentTest.info("updated the informations about merchants");


        //Click the save button

        admin_dashboard.merchantsaveBtn.click();

        extentTest.info("Save button is clicked");


        //Verify that "Succesfully updated" text  is displayed

        Assert.assertTrue(admin_dashboard.updatedText.isDisplayed());

        Driver.getDriver().navigate().back();

        extentTest.info("Verified the succesfully updated text is visible and came back to previous page");

        // go back to previous page

        Driver.getDriver().navigate().back();

        extentTest.info("Came back to the previous page");

        //Verify that merchant's updated information is displayed in the  body part

        List<WebElement> merchantInfoList = admin_dashboard.updatedMerchantInfo;

        for (WebElement eachElement : merchantInfoList
        ) {

            System.out.println("Merchant info list: " + eachElement.getText());

            extentTest.info("Verified the merchant information is displayed");

        }

        //Search merchant name in the search box

        admin_dashboard.searchBox.sendKeys("jake"+Keys.ENTER);

        extentTest.info("merchant name is searched in the search box");

        //Click the delete link

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(admin_dashboard.deleteButton.isEnabled());
        softAssert.assertAll();


        extentTest.info("Can't click the delete button");


        extentTest.fail("Delete button is not clickable");

    }
}

