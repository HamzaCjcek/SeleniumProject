package tests.US_005_030_031_032;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.User_Homepage;
import utilities.*;

public class US_005 extends TestBaseRapor {
    User_Homepage userHomepage=new User_Homepage();

    @Test
    public void tc00501_loginTestYanlisMailYanlisPassword(){
        extentTest=extentReports.createTest("Yanlis Mail, Yanlis Password testi","Login olunmamali");
        userHomepage=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("Homepage acildi");
        userHomepage.signInButton.click();
        extentTest.info("Sign in linkine tıklandı");
        userHomepage.usernameBox.sendKeys(ConfigReader.getProperty("yanlisUsernameEmailVht"));
        extentTest.info("Yanlis mail girildi.");
        userHomepage.passwordBox.sendKeys(ConfigReader.getProperty("yanlisPasswordUserVht"));
        extentTest.info("Yanlis password girildi.");
        userHomepage.loginSigninButton.click();
        extentTest.info("Signin buttonuna tiklandi.");
        ReusableMethods.waitForVisibility(userHomepage.loginOlunamadiUyarisi,2);
        Assert.assertTrue(userHomepage.loginOlunamadiUyarisi.isDisplayed());
        extentTest.pass("Test basarili, login olunmadi.");
    }

    @Test (groups = "smoke")
    public void tc00502_loginTestDogruMailYanlisPassword(){
        extentTest=extentReports.createTest("Correct Mail, Wrong Password test","Should not be logged in");
        userHomepage=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("Homepage opened");
        userHomepage.signInButton.click();
        extentTest.info("Sign in link clicked");
        userHomepage.usernameBox.sendKeys(ConfigReader.getProperty("usernameEmailVht"));
        extentTest.info("Correct mail entered.");
        userHomepage.passwordBox.sendKeys(ConfigReader.getProperty("yanlisPasswordUserVht"));
        extentTest.info("Wrong password entered.");
        userHomepage.loginSigninButton.click();
        extentTest.info("Sign in button clicked.");
        ReusableMethods.waitForVisibility(userHomepage.loginOlunamadiUyarisi,2);
        Assert.assertTrue(userHomepage.loginOlunamadiUyarisi.isDisplayed());
        extentTest.pass("Test successful, not logged in.");
    }

    @Test
    public void tc00503_loginTestYanlisMailDogruPassword(){
        extentTest=extentReports.createTest("Yanlis Mail, Dogru Password testi","Login olunmamali");
        userHomepage=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("Homepage acildi");
        userHomepage.signInButton.click();
        extentTest.info("Sign in link clicked");
        userHomepage.usernameBox.sendKeys(ConfigReader.getProperty("yanlisUsernameEmailVht"));
        extentTest.info("Yanlis mail girildi.");
        userHomepage.passwordBox.sendKeys(ConfigReader.getProperty("passwordUserVht"));
        extentTest.info("Dogru password girildi.");
        userHomepage.loginSigninButton.click();
        extentTest.info("Sign in button clicked.");
        ReusableMethods.waitForVisibility(userHomepage.loginOlunamadiUyarisi,2);
        Assert.assertTrue(userHomepage.loginOlunamadiUyarisi.isDisplayed());
        extentTest.pass("Test basarili, login olunmadi.");
    }

    @Test (groups = "smoke")
    public void tc00504_loginTestDogruMailDogruPassword(){
        extentTest=extentReports.createTest("Correct Mail, Correct Password test","Must be logged in");
        userHomepage=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("Homepage opened");
        userHomepage.signInButton.click();
        extentTest.info("Sign in linkine tıklandı");
        userHomepage.usernameBox.sendKeys(ConfigReader.getProperty("usernameEmailVht"));
        extentTest.info("Correct mail entered.");
        userHomepage.passwordBox.sendKeys(ConfigReader.getProperty("passwordUserVht"));
        extentTest.info("Correct password entered.");
        userHomepage.loginSigninButton.click();
        extentTest.info("Signin buttonuna tiklandi.");
        ReusableMethods.waitForVisibility(userHomepage.loginOlunduSimgesi,2);
        Assert.assertTrue(userHomepage.loginOlunduSimgesi.isDisplayed());
        extentTest.pass("Test successful, logged in.");
    }

    @Test
    public void tc00505_loginTestYanlisTelNoYanlisPassword(){
        extentTest=extentReports.createTest("Yanlis telNo, Yanlis Password testi","Login olunmamali");
        userHomepage=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("Homepage acildi");
        userHomepage.signInButton.click();
        extentTest.info("Sign in linkine tıklandı");
        userHomepage.signInButton.click();
        userHomepage.usernameBox.sendKeys(ConfigReader.getProperty("yanlisUsernameTelNoVht"));
        extentTest.info("Yanlis telNo girildi.");
        userHomepage.passwordBox.sendKeys(ConfigReader.getProperty("yanlisPasswordUserVht"));
        extentTest.info("Yanlis password girildi.");
        userHomepage.loginSigninButton.click();
        extentTest.info("Signin buttonuna tiklandi.");
        ReusableMethods.waitForVisibility(userHomepage.loginOlunamadiUyarisi,2);
        Assert.assertTrue(userHomepage.loginOlunamadiUyarisi.isDisplayed());
        extentTest.pass("Test basarili, login olunmadi.");
    }

    @Test
    public void tc00506_loginTestDogruTelNoYanlisPassword(){
        extentTest=extentReports.createTest("Dogru telNo, Yanlis Password testi","Login olunmamali");
        userHomepage=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("Homepage acildi");
        userHomepage.signInButton.click();
        extentTest.info("Sign in linkine tıklandı");
        userHomepage.usernameBox.sendKeys(ConfigReader.getProperty("usernameTelNoVht"));
        userHomepage.passwordBox.sendKeys(ConfigReader.getProperty("yanlisPasswordUserVht"));
        extentTest.info("Yanlis password girildi.");
        userHomepage.loginSigninButton.click();
        extentTest.info("Signin buttonuna tiklandi.");
        ReusableMethods.waitForVisibility(userHomepage.loginOlunamadiUyarisi,2);
        Assert.assertTrue(userHomepage.loginOlunamadiUyarisi.isDisplayed());
        extentTest.pass("Test basarili, login olunmadi.");
    }

    @Test
    public void tc00507_loginTestYanlisTelNoDogruPassword(){
        extentTest=extentReports.createTest("Yanlis telNo, Dogru Password testi","Login olunmamali");
        userHomepage=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("Homepage acildi");
        userHomepage.signInButton.click();
        extentTest.info("Sign in linkine tıklandı");
        userHomepage.usernameBox.sendKeys(ConfigReader.getProperty("yanlisUsernameTelNoVht"));
        extentTest.info("Yanlis telNo girildi.");
        userHomepage.passwordBox.sendKeys(ConfigReader.getProperty("passwordUserVht"));
        extentTest.info("Dogru password girildi.");
        userHomepage.loginSigninButton.click();
        extentTest.info("Signin buttonuna tiklandi.");
        ReusableMethods.waitForVisibility(userHomepage.loginOlunamadiUyarisi,2);
        Assert.assertTrue(userHomepage.loginOlunamadiUyarisi.isDisplayed());
        extentTest.pass("Test basarili, login olunmadi.");
    }

    @Test
    public void tc00508_loginTestDogruTelNoDogruPassword(){
        extentTest=extentReports.createTest("Dogru telNo, Dogru Password testi","Login olunmali");
        userHomepage=new User_Homepage();
        ReusableMethods.goTouserHomePage();
        extentTest.info("Homepage acildi");
        userHomepage.signInButton.click();
        extentTest.info("Sign in linkine tıklandı");
        userHomepage.usernameBox.sendKeys(ConfigReader.getProperty("usernameTelNoVht"));
        extentTest.info("Dogru telNo girildi.");
        userHomepage.passwordBox.sendKeys(ConfigReader.getProperty("passwordUserVht"));
        extentTest.info("Dogru password girildi.");
        userHomepage.loginSigninButton.click();
        extentTest.info("Signin buttonuna tiklandi.");
        ReusableMethods.waitForVisibility(userHomepage.loginOlunduSimgesi,2);
        Assert.assertTrue(userHomepage.loginOlunduSimgesi.isDisplayed());
        extentTest.pass("Test basarili, login olundu.");
    }

}
