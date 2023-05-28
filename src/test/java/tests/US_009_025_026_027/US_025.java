package tests.US_009_025_026_027;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Merchant_Dashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_025 extends TestBaseRapor {
    Merchant_Dashboard merchant_dashboard=new Merchant_Dashboard();
    /*@BeforeClass
    public void setUp() {
        ReusableMethods.merchantLogin();
    }

    @AfterClass
    public void tearDown() {

        Driver.closeDriver();
    }*/

    @Test
    public void tc2501ItemSayfasinindogrulanamasi(){
        merchant_dashboard = new Merchant_Dashboard();
        extentTest = extentReports.createTest("item  sayfası gorunurlugu testi",
                "item sayfasi gorunmeli");
        ReusableMethods.merchantLogin();

        merchant_dashboard.foodelement.click();
        extentTest.info("food linkine tıklandı");
        merchant_dashboard.itemsElement.click();
        extentTest.info("item linkine tıklandı");

        Assert.assertTrue(merchant_dashboard.itemdogrulama.isDisplayed());
        extentTest.info("item sayfasına gidildiği dogrulandi");
    }


    @Test
    public void tc2502itemAddnewbutton(){
        ReusableMethods.merchantLogin();
        merchant_dashboard=new Merchant_Dashboard();
        merchant_dashboard.foodelement.click();
        merchant_dashboard.itemsElement.click();
        Assert.assertTrue(merchant_dashboard.addNewButton.isDisplayed());
        extentTest.pass("addnew butonunun oldugu dogrulandi");

    }
    @Test
    public void tc2503itemAddneweklme(){
        ReusableMethods.merchantLogin();
        Driver.getDriver().navigate().refresh();
        merchant_dashboard.foodelement.click();
        merchant_dashboard.itemsElement.click();
        merchant_dashboard.addNewButton.click();
        //extentTest.info("addnew butonuna tıklandı");
        Actions actions=new Actions(Driver.getDriver());
        String itemname="kebab";
        String ShortDescription="ala";
        String Itemprice="15";
        merchant_dashboard.itemname.sendKeys(itemname);
        actions.sendKeys(Keys.TAB)
                .sendKeys(ShortDescription)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Itemprice)
                //.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();
        merchant_dashboard.categorySavebutton.submit();
        //extentTest.info("yeni içerik dolduruldu");
        Assert.assertTrue(merchant_dashboard.categorysuccesscreated.isDisplayed());
        //extentTest.pass("doldurulan içeriğin kaydolduğu dogrulandı");


    }
    @Test
    public void tc2504UpdateButton(){
        ReusableMethods.merchantLogin();
        merchant_dashboard=new Merchant_Dashboard();
        merchant_dashboard.foodelement.click();
        merchant_dashboard.itemsElement.click();
       Assert.assertTrue(merchant_dashboard.updatebutton.isDisplayed());
       extentTest.pass("update button linkinin oldugu dugrulandı");

    }
    @Test
    public void tc2505UpdateButton(){
        ReusableMethods.merchantLogin();
        merchant_dashboard=new Merchant_Dashboard();
        merchant_dashboard.foodelement.click();
        merchant_dashboard.itemsElement.click();
        merchant_dashboard.updatebutton.click();
        extentTest.info("update butonuna tıklandı");

        String updateicerik="kebabs";
        merchant_dashboard.updateicerik.sendKeys(updateicerik);
        extentTest.info("istenen güncelleme yapıldı");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        merchant_dashboard.updateSavebutton.submit();
        extentTest.info("güncelleme kaydı yapıldı");
        Assert.assertTrue(merchant_dashboard.updatesuccescreated.isDisplayed());
        extentTest.pass("kaydın başarılı şekilde yapıldığı doğrulandı");


    }

}
