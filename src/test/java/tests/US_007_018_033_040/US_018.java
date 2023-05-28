package tests.US_007_018_033_040;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Admin_Dashboard;
import pages.Merchant_Dashboard;
import pages.User_Homepage;
import pages.User_RestaurantUmiSakeHouse;
import utilities.*;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class US_018 extends TestBaseRapor {
    User_Homepage uh;
    
    @Test
    public void userSuccessfulLogin(){
        uh=new User_Homepage();
        extentTest=extentReports.createTest("user Successful Login");
        ReusableMethods.goTouserHomePage();
        ReusableMethods.userLoginMethod("duyguUserName","duyguUserPassword");
        extentTest.info("I went to the main page and logged in with the user information.");
        ReusableMethods.waitForClickablility(By.xpath("//a[@id='dropdownMenuLink']"),5);
        WebElement userName=Driver.getDriver().findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        assertTrue(userName.isEnabled());
        extentTest.info("It is verified that the name appears as the user.");
        extentTest.info("the browser closes.");
        extentTest.pass("succesfully the user can login.");
    }
    @Test
    public void likeSaveButtonSeenTest(){
        uh=new User_Homepage();
        extentTest=extentReports.createTest("like Save Button Seen Test");

        ReusableMethods.goTouserHomePage();
        ReusableMethods.userLoginMethod("duyguUserName","duyguUserPassword");
        extentTest.info("I went to the main page and logged in with the user information.");
        ReusableMethods.waitForClickablility(By.xpath("//a[@id='dropdownMenuLink']"),5);
        uh.nameDropDownMenu.click();
        extentTest.info("The pop-up menu with the user name is clicked.");
        assertTrue(uh.saveAdStoreLink.isEnabled());
        extentTest.info("The saved restaourant link is verified to be visible.");
        uh.saveAdStoreLink.click();
        extentTest.info("the saved restaurant link is clicked.");
        assertTrue(uh.userFavouritesSavedStores.isDisplayed());
        extentTest.info("It is verified that the saved restaourant page has been accessed.");
        extentTest.info("the browser closes.");
        extentTest.pass("The saved restaurant page has been accessed successfully.");


    }
    @Test
    public void test(){
        //1)bir browser aç.
        //2)"https://qa.mealscenter.com/" url uzerinden 'mealscenter' sitesine gider.
        //3)Cookies kabul edilir.
        //4)Sign in butonuna basar.
        //5)geccerli emailini email kutusuna yazar.
        //6)gecerli sifresini sifre kutusuna yazar.
        //7)Sign in butonuna basar.
        //8)isminin yazdigi acılır menuye tıklar.
        //9)acılır menude Saved Stores linkine tiklar
        //10)Acilan sayfada "You don't have any save stores here!" yazisinin ciktigini dogrular
        //11)sayfayi kapatir.
        uh=new User_Homepage();
        List<WebElement> restauranNameList=uh.restaurantsNameList;
        ReusableMethods.goTouserHomePage();
        ReusableMethods.userLoginMethod("duyguUserName","duyguUserPassword");
        ReusableMethods.waitForClickablility(By.xpath("//a[@id='dropdownMenuLink']"),5);
        uh.nameDropDownMenu.click();
        uh.saveAdStoreLink.click();
        String actualText=uh.dontHaveAnyStores.getText();
        String expectedText="You don't have any save stores here!";
        assertEquals(expectedText,actualText);
        ReusableMethods.waitForClickablility(uh.orderNowButton,3);
        uh.orderNowButton.click();

        assertTrue(uh.numberOfRestaurants.isDisplayed());
        for (WebElement each:restauranNameList
             ) {
            if (each.getText().equals("Umi Sake House")){
                each.click();
            }
        }
        User_RestaurantUmiSakeHouse ur=new User_RestaurantUmiSakeHouse();
        ur.umiSakiHouseLikeButton.click();
       String actualTextLikeAfter= ur.savedText.getText();
       String expectedTextLike="Saved";
       assertTrue(actualTextLikeAfter.equals(expectedTextLike));



    }
    @Test
    public void addFavoriteRestaurantTest(){
        //1)bir browser aç
        //2)"https://qa.mealscenter.com/" url uzerinden 'mealscenter' sitesine gider.
        //3)Cookies kabul edilir.
        //4)Sign in butonuna basar.
        //5)geccerli emailini email kutusuna yazar.
        //6)gecerli sifresini sifre kutusuna yazar.
        //7)Sign in butonuna basar.
        //8)Sayfanin ortasinda bulunan adres arama kutusuna
        //yasadigi sehrin ismini girer acılan menuden girilen adrese tiklar
        //9)2.Restoran isminin sagındaki begen butonuna basar
        //10)Sayfanin sag ustunde isminin uzerine tıklar.
        //11)Acilan menuden Saved Stores linkine tiklar
        //12)Acilan sayfada begenilen restoranin cıktıgını dogrular.
        //13)sayfayi kapatir.
        extentTest=extentReports.createTest("add Favorite Restaurant Test");
        ReusableMethods.goTouserHomePage();
        ReusableMethods.userLoginMethod("duyguUserName","duyguUserPassword");
        extentTest.info("I went to the main page and logged in with the user information.");
        uh=new User_Homepage();
        uh.adresButton.sendKeys(ConfigReader.getProperty("adres"));
        extentTest.info("writes an address in the address search box");
        uh.adres10001.click();
        extentTest.info("The address written is selected from the drop-down menu.");


       
                JSUtilities.clickWithJS(Driver.getDriver(),uh.likeButtonList.get(2));
                extentTest.info("Click on the restaurant like and save button.");
        uh.nameDropDownMenu.click();
        extentTest.info("The pop-up menu with the user name is clicked.");
        uh.saveAdStoreLink.click();
        extentTest.info("the saved restaurant link is clicked.");
       String actualFavoriteRestaurant= uh.favoritesRestourantName.getText();
       String expectedFavoriRestaurant=uh.restaurantsNameList.get(0).getText();
       assertTrue(expectedFavoriRestaurant.equals(actualFavoriteRestaurant));
       extentTest.info("The saved restaourant is verified to have been added successfully.");
       extentTest.info("the browser closes.");
       extentTest.pass("The saved restaourant  have been added successfully.");


    }

    @Test(dependsOnMethods = "addFavoriteRestaurantTest")
    public void removeFromFavorites(){
        uh=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        ReusableMethods.userLoginMethod("duyguUserName","duyguUserPassword");
        ReusableMethods.waitForClickablility(By.xpath("//a[@id='dropdownMenuLink']"),5);
        uh.nameDropDownMenu.click();
        uh.saveAdStoreLink.click();
        Driver.getDriver().findElement(By.xpath("(//i[@class='zmdi zmdi-favorite text-green'])[1]")).click();
        Driver.getDriver().navigate().refresh();
        String actualText=uh.dontHaveAnyStores.getText();
        String expectedText="You don't have any save stores here!";
        assertEquals(expectedText,actualText);

    }
}
