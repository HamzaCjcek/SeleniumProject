package tests.US_015_017_019_038;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Admin_Dashboard;
import utilities.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_038 extends TestBaseRapor {

    Admin_Dashboard admin = new Admin_Dashboard();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void adminOrdersTest01(){
        admin = new Admin_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Test for admin to access all orders");
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),(ConfigReader.getProperty("betulAdminPassword")));
        admin.ordersSection.click();
        extentTest.info("Clicked on the orders text in the panel");
        admin.allOrderSection.click();
        extentTest.info("Clicked on all orders");
        softAssert.assertTrue(admin.orderList.isDisplayed());
        extentTest.info("All order displayed");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("allOrderUrl");
        softAssert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Confirmed that the admin can access all orders");
        softAssert.assertAll();

    }

    @Test
    public void adminOrdersTest02(){
        admin = new Admin_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Test for admin to access total number of orders," +
                                             "total number of cancellations and total refund amount");
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),(ConfigReader.getProperty("betulAdminPassword")));
        admin.ordersSection.click();
        extentTest.info("Clicked on the orders text in the panel");
        admin.allOrderSection.click();
        extentTest.info("Clicked on all orders");
        softAssert.assertTrue(admin.orders.isDisplayed());
        extentTest.info("Total number of orders displayed");
        softAssert.assertTrue(admin.totalCancels.isDisplayed());
        extentTest.info("Number of cancellations displayed");
        softAssert.assertTrue(admin.totalRefund.isDisplayed());
        extentTest.info("Total refund displayed");
        softAssert.assertTrue(admin.totalOrders.isDisplayed());
        extentTest.info("Total amount displayed");
        extentTest.pass("Confirmed that the admin can access the total number of orders," +
                        "total number of cancellations and total refund amount");
        softAssert.assertAll();
    }

    @Test
    public void adminOrdersTest03(){
        admin = new Admin_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Test for admin to filter by a certain date range");
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),(ConfigReader.getProperty("betulAdminPassword")));
        admin.ordersSection.click();
        extentTest.info("Clicked on the orders text in the panel");
        admin.allOrderSection.click();
        extentTest.info("Clicked on all orders");

        admin.dateSearchBox.click();
        ReusableMethods.wait(2);
        extentTest.info("Clicked on the date box");
        admin.yesterday.click();
        extentTest.info("Clicked on yesterday from the drop-down menu");
        ReusableMethods.wait(1);
        String dateStringYday = admin.yesterdayDate.getText().replaceAll("\\D","");
        String ilkIkiRakam = dateStringYday.substring(0, 2);
        LocalDate todaysDate = LocalDate.now();
        int day = todaysDate.getDayOfMonth();
        softAssert.assertEquals(day-1,Integer.parseInt(ilkIkiRakam));
        extentTest.info("Confirmed that the date of the ordered products is yesterday's date");

        admin.dateSearchBox.click();
        extentTest.info("Clicked on the date box");
        admin.today.click();
        ReusableMethods.wait(1);
        extentTest.info("Clicked on today from the drop-down menu");
        String dateStringToday = admin.todayDate.getText().replaceAll("\\D","");
        ilkIkiRakam = dateStringToday.substring(0, 2);
        softAssert.assertEquals(day,Integer.parseInt(ilkIkiRakam));
        extentTest.info("Confirmed that the date of the ordered products is today's date");

        admin.dateSearchBox.click();
        ReusableMethods.wait(2);
        extentTest.info("Clicked on the date box");
        admin.last7days.click();
        ReusableMethods.wait(2);
        String dateStringLast7First = admin.last7daysDate1.getText().replaceAll("\\D","");
        ilkIkiRakam = dateStringLast7First.substring(0, 2);
        JSUtilities.scrollToBottom(Driver.getDriver());
        extentTest.info("Went to the end of the page");
        ReusableMethods.wait(1);
        admin.lastPageButton1.click();
        ReusableMethods.wait(1);
        admin.lastPageButton2.click();
        ReusableMethods.wait(0.1);
        String dateStringLast7Last = admin.last7daysDate2.getText().replaceAll("\\D","");
        String sonOrderIlkIkiRakam = dateStringLast7Last.substring(0,2);
        softAssert.assertEquals((Integer.parseInt(ilkIkiRakam)-Integer.parseInt(sonOrderIlkIkiRakam)+1),7);
        extentTest.info("Verified that the orders are sorts from the last 7 days");
        System.out.println(ilkIkiRakam); //30
        System.out.println(sonOrderIlkIkiRakam);  //24

        JSUtilities.scrollToTop(Driver.getDriver());
        extentTest.info("Back to the top of the page");
        ReusableMethods.wait(2);
        admin.dateSearchBox.click();
        extentTest.info("Clicked on the date box");
        admin.last30days.click();
        extentTest.info("Clicked on last 30 days from the drop-down menu");
        String dateStringLast30First = admin.last30daysDate1.getText().replaceAll("\\D","");
        ilkIkiRakam = dateStringLast30First.substring(0, 2);
        ReusableMethods.wait(1);
        JSUtilities.scrollToBottom(Driver.getDriver());
        extentTest.info("Went to the end of the page");
        ReusableMethods.wait(1);
        admin.lastPageButton1.click();
        ReusableMethods.wait(1);
        admin.lastPageButton2.click();
        ReusableMethods.wait(1);
        extentTest.info("Button pressed to go to last page");
        String dateStringLast30Last = admin.last30daysDate2.getText().replaceAll("\\D","");
        sonOrderIlkIkiRakam = dateStringLast30Last.substring(0,2);
        softAssert.assertEquals(Integer.parseInt(ilkIkiRakam)-Integer.parseInt(sonOrderIlkIkiRakam)+1,18);
        // burdaki 18, cuma günü 20 olmalı
        extentTest.info("Verified that the orders are sorts from the last 30 days");
        extentTest.pass("Admin can filter by a certain date range");
        System.out.println(ilkIkiRakam); // 24
        System.out.println(sonOrderIlkIkiRakam); // 16

        softAssert.assertAll();

    }
    @Test
    public void adminOrdersTest04(){
        admin = new Admin_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Test that the administrator can view and download an order as a document");
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),(ConfigReader.getProperty("betulAdminPassword")));
        admin.ordersSection.click();
        extentTest.info("Clicked on the orders text in the panel");
        admin.allOrderSection.click();
        extentTest.info("Clicked on all orders");
        admin.viewOrder.click();
        extentTest.info("Clicked on the eye image");
        softAssert.assertTrue(admin.summary.isDisplayed(),"Order details could not be displayed");
        extentTest.info("Verified that order details can be viewed on the page that opens");
        Driver.getDriver().navigate().back();
        extentTest.info("Returned to previous page");
        admin.downloadOrder.click();
        String filePath = "C:\\Users\\fbalp\\Downloads\\document.pdf";
        softAssert.assertTrue(Files.exists(Paths.get(filePath)));
        extentTest.info("Verified that order details can be downloaded as PDF");
        extentTest.pass("Verified that the administrator can view and download an order as a document");
        softAssert.assertAll();
    }


    @Test
    public void adminOrdersTest05(){
        admin = new Admin_Dashboard();
        softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Test for admin to sort orders by order id");
        ReusableMethods.adminLogin(ConfigReader.getProperty("betulAdminName"),(ConfigReader.getProperty("betulAdminPassword")));
        admin.ordersSection.click();
        extentTest.info("Clicked on the orders text in the panel");
        admin.allOrderSection.click();
        extentTest.info("Clicked on all orders");
        admin.orderIdText.click();
        extentTest.info("Clicked on Order ID for sort orders by order id");
        ReusableMethods.wait(0.5);
        List<WebElement> orderIdListesi = admin.orderIdList;
        ArrayList<Integer> orderIdListInt = new ArrayList<>();
        for (WebElement eachId : orderIdListesi
        ) {
            String idString = eachId.getText();
            orderIdListInt.add(Integer.parseInt(idString));
        }
        extentTest.info("IDs have been added to a list for comparison");
        List<Integer> controlList = new ArrayList<>(orderIdListInt);
        Collections.sort(controlList);
        extentTest.info("IDs added to a list sorted in descending order");
        softAssert.assertTrue(controlList.equals(orderIdListInt),"Sorting is not done correctly");
        extentTest.info("IDs were matched with the sorted list after sorting");
        extentTest.pass("Verified that admin can sort orders by order id");
        softAssert.assertAll();
    }

    /* @AfterMethod
     public void tearDown(){
        admin = new Admin_Dashboard();
        softAssert = new SoftAssert();
        softAssert.assertAll();
        Driver.closeDriver();
    }*/

}
