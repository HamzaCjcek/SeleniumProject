package tests.US_029_034_036_037;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Admin_Dashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_036 extends TestBaseRapor {

    @Test (groups = "smoke")
    public void TC_01() {

        extentTest = extentReports.createTest("Verified the page is logged in correct page.");

        //adminStart
        ReusableMethods.adminLogin("huseyin.senol", "123456");

        extentTest.info("Logged in admin login page");

        //Verify that is logged in on requested page.

        String expectedcontent = "admin/dashboard";
        String actualURL = Driver.getDriver().getCurrentUrl();

        extentTest.info("Verified the page is loggeg in requested page. ");
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(actualURL.contains(expectedcontent));

        softAssert.assertAll();

        //Close the browser
        Driver.closeDriver();

        extentTest.info("closed the page");

        extentTest.pass("passed");
    }

    @Test
    public void TC_02() {

        Admin_Dashboard admin_dashboard = new Admin_Dashboard();
        extentTest = extentReports.createTest("Total summary informartions are displayed");
        //adminStart
        ReusableMethods.adminLogin("huseyin.senol", "123456");

        extentTest.info("Logged in admin login page");

        //Verify that all summary information related to total is  displayed.

        List<WebElement> totalSummaryList = admin_dashboard.dashboardSummaryInfo;

        for (WebElement eachElement : totalSummaryList
        ) {

            System.out.println("Total summary info: " + eachElement.getText());

            extentTest.info("verified that total summary informations are displayed");

        }
        //Close the browser
        Driver.closeDriver();

        extentTest.info("page is closed");

        extentTest.pass("passed");
    }

    @Test (groups = "smoke")
    public void TC_03() {

        Admin_Dashboard admin_dashboard = new Admin_Dashboard();
        extentTest = extentReports.createTest("All commision,subscription and sales overview informations are displayed");

        //adminStart
        ReusableMethods.adminLogin("huseyin.senol", "123456");

        extentTest.info("Logged in admin login page");

        //Verify that all "Commission this week","Commission
        //this month", " Subscriptions this month" informations
        // are displayed.

        List<WebElement> commissionSumList =admin_dashboard.commissionSummary;

        for (WebElement eachElement:commissionSumList
             ) {

            System.out.println(eachElement.getText());

            extentTest.info("Commission summary informartions are displayed");
        }
        //Verify that sales overview information is displayed

        System.out.println("=======Sales overview=======");


        List<WebElement>salesoverviewList=admin_dashboard.salesOverview;

        for (WebElement eachElement:salesoverviewList
             ) {

            System.out.println(eachElement.getText());

            extentTest.info("Sales overview summary is displayed");

        }

        //Close the browser
        Driver.closeDriver();

        extentTest.info("closed the page");

        extentTest.pass("passed");

    }
    @Test
    public void TC_04() {

        Admin_Dashboard admin_dashboard = new Admin_Dashboard();
        extentTest = extentReports.createTest("All commision,subscription informations are displayed");

        //adminStart
        ReusableMethods.adminLogin("huseyin.senol", "123456");

        extentTest.info("Logged in admin login page");

        //Verify all summary information related to
        //"Order received","Today delivered" and
        //"New customer" is visible.

        List<WebElement>ordersList=admin_dashboard.ordersSummary;

        for (WebElement eachElement:ordersList
             ) {

            System.out.println(eachElement.getText());

            extentTest.info("Orders summary is displayed");

            extentTest.pass("pass");

            //Close the browser
            Driver.closeDriver();

            extentTest.info("closed the page");

            extentTest.pass("passed");

        }

    }
}
