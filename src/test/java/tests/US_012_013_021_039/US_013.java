package tests.US_012_013_021_039;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.User_CheckoutPage;
import pages.User_Homepage;
import pages.User_RestaurantUmiSakeHouse;
import utilities.*;

import java.time.Duration;


public class US_013 extends TestBaseRapor {

    User_Homepage homepage=new User_Homepage();
    SoftAssert softAssert=new SoftAssert();
    User_RestaurantUmiSakeHouse restaurantUmiSakeHouse=new User_RestaurantUmiSakeHouse();
    User_CheckoutPage checkoutPage=new User_CheckoutPage();
    Actions actions=new Actions(Driver.getDriver());

////////////***********   TEST 1 ************////////////////////////////////////////////////////////
    @Test
    public void tc_1301() {

        homepage=new User_Homepage();
        softAssert=new SoftAssert();
        restaurantUmiSakeHouse=new User_RestaurantUmiSakeHouse();

        extentTest = extentReports.createTest("TC_1301",
                "Sepet fonksiyon testi");
        //
        beforeMethod();
        sepeteUrunEklemeMethodu();
        extentTest.info("Launch browser, go to the URL, log in as an user , add the first item from the restaurant to the cart.");
        //
        homepage.mealscenterButton.click();
        extentTest.info("Go to homepage.");
        //
        restaurantUmiSakeHouse.cartButonu.click();
        ReusableMethods.wait(0.1);
        extentTest.info("Click the 'Cart' button on the user homepage.");
        //
        softAssert.assertTrue(homepage.sepetDogrulamaYazisi.isDisplayed(),"Kullanıcı anasayfasındaki Cart butonu ile sepet sayfasına erişilemiyor.");//sepetteki Your cart from yazisi
        extentTest.info("Sepet sayfasının erişilebilirliği doğrulanır.");
        //
        homepage.sepetCloseButonu.click();
        extentTest.info("Sepet kapatilir.");
        //
        restaurantUmiSakeHouse.cartLogoButonu.click();
        ReusableMethods.wait(0.1);
        extentTest.info("Kullanıcı anasayfasindaki 'Cart' butonunun yanindaki sepet logosuna tiklanir.");
        //
        softAssert.assertTrue(homepage.sepetDogrulamaYazisi.isDisplayed(),"Kullanıcı anasayfasındaki CartLogosu butonu ile sepet sayfasına erişilemiyor.");//sepetteki Your cart from yazisi
        extentTest.info("Sepet sayfasının erişilebilirliği doğrulanır.");
        //
        softAssert.assertTrue(homepage.sepetClearButonu.isEnabled(),"Sepetteki clear butonu aktif değil");
        softAssert.assertTrue(homepage.sepetUrunSilmeButonu.isEnabled(),"Sepetteki urun silme(x) butonu aktif değil");
        softAssert.assertTrue(homepage.sepettekiUrunuArttirmaButonu.isEnabled(),"Sepetteki urun arttirma butonu aktif değil");
        softAssert.assertTrue(homepage.sepettekiUrunuAzaltmaButonu.isEnabled(),"Sepetteki urun azaltma butonu aktif değil");
        softAssert.assertTrue(homepage.sepettekiUrunMiktari.isDisplayed(),"Sepetteki urun miktari yazisi gorunur değil");
        extentTest.info("Sepet sayfasının tum fonksiyonlarının calistigi dogrulanir.");
        //
        homepage.sepetCloseButonu.click();
        extentTest.info("Sepet kapatilir.");
        //
        extentTest.info("Tarayici kapatilir.");
        //
        extentTest.pass("Sepet sayfası erişilebilir ve tüm fonksiyonlar aktif");
        //
        softAssert.assertAll();

    }
    ////////////***********   TEST 2 ************////////////////////////////////////////////////////////
    @Test
    public void tc_1302(){
        softAssert=new SoftAssert();
        restaurantUmiSakeHouse=new User_RestaurantUmiSakeHouse();
        checkoutPage=new User_CheckoutPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("TC_1302",
                "Odeme sayfasi fonksiyon testi");
        //
        beforeMethod();
        //
        sepeteUrunEklemeMethodu();
        extentTest.info("Tarayici acilir, Url'e gidilir, login olunur, sepete restauranttaki ilk urun eklenir.");
        //
        restaurantUmiSakeHouse.checkoutButton.click();
        extentTest.info("Sepetteki checkout butonu ile ödeme sayfasına gidilir.");
        //
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="checkout";
        softAssert.assertTrue(actualUrl.contains(expectedUrl),"Odeme sayfasina gidilemedi");
        extentTest.info("Odeme sayfasına erişildiği doğrulanır.");
        //
        urunSatinAlmaBilgileriGitmeMethodu();
        extentTest.info("Urun satin alma bilgileri girilir");
        //
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //
        gecerliAdresBilgileriGirmeMethodu();
        extentTest.info("Gecerli adres bilgisi girilir");
        //
        gecerliOdemeBilgileriGirmeMethodu();
        extentTest.info("Geçerli odeme bilgisi girilir.");
        //
        softAssert.assertTrue(checkoutPage.deliveryButton.isEnabled(),"Checkout sayfasinda 'Delivery' butonu aktif degil");
        softAssert.assertTrue(checkoutPage.phoneButton.isEnabled(),"Checkout sayfasinda 'PhoneNumberBox' butonu aktif degil");
        softAssert.assertTrue(checkoutPage.promotionsButton.isEnabled(),"Checkout sayfasinda 'Promotions' butonu aktif degil");
        softAssert.assertTrue(checkoutPage.includeUtensilsAndCondiments.isEnabled(),"Checkout sayfasinda 'includeUtensilsAndCondiments' secenegi aktif degil");
        softAssert.assertTrue(checkoutPage.deliveryAdress.isEnabled(),"Checkout sayfasinda 'Delivery Adress' butonu aktif degil");
        softAssert.assertTrue(checkoutPage.cashOnDeliveryButton.isEnabled(),"Checkout sayfasinda 'Cash on delivery' butonu aktif degil");
        softAssert.assertTrue(checkoutPage.stripeButton.isEnabled(),"Checkout sayfasinda 'Stripe' butonu aktif degil");
        softAssert.assertTrue(checkoutPage.placeOrderButton.isEnabled(),"Checkout sayfasinda 'Place' butonu aktif degil");
        extentTest.info("Odeme sayfasındaki fonksiyonlarin calısır olduğu doğrulanir.");
        //
        extentTest.info("Tarayici kapatilir.");
        //
        extentTest.pass("Odeme sayfası erişilebilir ve tüm fonksiyonlar aktif");
        //
        softAssert.assertAll();

    }
    ////////////***********   TEST 3 ************////////////////////////////////////////////////////////
    @Test
    public void tc_1303(){
        homepage=new User_Homepage();
        softAssert=new SoftAssert();
        restaurantUmiSakeHouse=new User_RestaurantUmiSakeHouse();
        checkoutPage=new User_CheckoutPage();

        extentTest = extentReports.createTest("TC_1303",
                "Sepetteki urunu dogrulama testi");
        //
        beforeMethod();
        //
        extentTest.info("Before method ile tarayici acilir, Url'e gidilir, login olunur.");
        //
        homepage.umiSakeHouseRestaurantButton.click();
        extentTest.info("Umi Sake Hause restaurant tıklanır.");
        //
        String expectedUrunIsmi=restaurantUmiSakeHouse.ilkUrunIsimElementi.getText();
        extentTest.info("Ilk ürünun ismi kaydedilir.");
        //
        restaurantUmiSakeHouse.ilkUrunAddToCartButton.click();
        extentTest.info("Ilk ürün 'add to cart' butonu ile sepete eklenir.");
        //
        restaurantUmiSakeHouse.checkoutButton.click();
        extentTest.info("Sepetteki checkout butonu ile ödeme sayfasına gidilir.");
        //
        String actualUrunIsmi=checkoutPage.sepettekiUrunIsmi.getText();
        extentTest.info("Sepetteki urun ismine bakilir.");
        //
        softAssert.assertEquals(actualUrunIsmi,expectedUrunIsmi,"Sepete atilan urun ile sepetteki urun ayni degil.");
        extentTest.info("Sepetteki ürün ile sepete eklediğimiz ürünün aynı olduğu doğrulanır.");
        //
        extentTest.info("Tarayici kapatilir.");
        //
        extentTest.pass("Sipariş verilen ürün ile sepete eklenen ürünün aynı.");
        //
        softAssert.assertAll();

    }
    ////////////***********   TEST 4 ************////////////////////////////////////////////////////////
    @Test (groups = "smoke")
    public void tc_1304(){
        homepage=new User_Homepage();
        softAssert=new SoftAssert();
        restaurantUmiSakeHouse=new User_RestaurantUmiSakeHouse();
        checkoutPage=new User_CheckoutPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("TC_1304",
                "Order test with invalid address valid payment information");
        //
        beforeMethod();
        sepeteUrunEklemeMethodu();
        extentTest.info("Launch browser, go to the URL, log in as an user , add the first item from the restaurant to the cart.");
        //
        restaurantUmiSakeHouse.checkoutButton.click();
        extentTest.info("Go to the checkout page with the checkout button in the cart.");
        //
        urunSatinAlmaBilgileriGitmeMethodu();
        extentTest.info("Enter product purchase information.");
        //
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //
        ReusableMethods.wait(0.5);
        checkoutPage.deliveryAdress.click();
        JSUtilities.scrollToElement(Driver.getDriver(),checkoutPage.deliveryAdressEditButton);
        ReusableMethods.wait(0.5);
        checkoutPage.deliveryAdressApartmentFloorBox.clear();
        checkoutPage.deliveryAdressApartmentFloorBox.sendKeys(ConfigReader.getProperty("GecersizAdres"));
        Select select= new Select(checkoutPage.deliveryOptionsButton);
        select.selectByVisibleText("Leave it at my door");
        select.getFirstSelectedOption();
        checkoutPage.deliveryAdressSaveButton.click();
        extentTest.info("Enter invalid address information.");
        //
        gecerliOdemeBilgileriGirmeMethodu();
        extentTest.info("Enter the current payment information.");
        //
        checkoutPage.placeOrderButton.click();
        extentTest.info("Click on the 'place order' button to confirm the order.");
        //
        try {
            softAssert.assertFalse(checkoutPage.siparisOnayYazisi.isDisplayed(),"The product was ordered with invalid address information!!");
        } catch (Exception e) {
            softAssert.assertFalse(false);
        }
        extentTest.info("It is verified that the product could not ordered");
        //
        extentTest.info("Close the browser.");
        //
        extentTest.fail("Products can be ordered with invalid address information.");
        //
        softAssert.assertAll();

    }
    ////////////***********   TEST 5 ************////////////////////////////////////////////////////////
    @Test
    public void tc_1305(){
        homepage=new User_Homepage();
        softAssert=new SoftAssert();
        restaurantUmiSakeHouse=new User_RestaurantUmiSakeHouse();
        checkoutPage=new User_CheckoutPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("TC_1305",
                "Gecersiz odeme gecerli adres bilgisi ile siparis testi");
        //
        beforeMethod();
        //
        sepeteUrunEklemeMethodu();
        extentTest.info("Tarayici acilir, Url'e gidilir, login olunur, sepete restauranttaki ilk urun eklenir.");
        //
        restaurantUmiSakeHouse.checkoutButton.click();
        extentTest.info("Sepetteki checkout butonu ile ödeme sayfasına gidilir.");
        //
        urunSatinAlmaBilgileriGitmeMethodu();
        extentTest.info("Urun satin alma bilgileri girilir");
        //
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //
        gecerliAdresBilgileriGirmeMethodu();
        extentTest.info("Gecerli adres bilgisi girilir");
        //
        try {
            ReusableMethods.wait(0.2);
            odemeBilgileriSilmeMethodu();
            try {
                ReusableMethods.wait(0.2);
                odemeBilgileriSilmeMethodu();
            } catch (Exception e) {}
        } catch (Exception e) {}

        ReusableMethods.wait(0.5);
        checkoutPage.stripeButton.click();
        ReusableMethods.wait(0.5);
        Driver.getDriver().switchTo().frame(checkoutPage.krediKartiIframe);
        checkoutPage.krediKartiNumberTextBox.sendKeys(ConfigReader.getProperty("GecersizKKNumaraBilgileri"));
        checkoutPage.krediKartiDateTextBox.sendKeys(ConfigReader.getProperty("GecersizKKTarihBilgileri"));
        checkoutPage.krediKartiCvcTextBox.sendKeys(ConfigReader.getProperty("GecersizKKCVCbilgileri"));
        Driver.getDriver().switchTo().parentFrame();
        checkoutPage.addStripeButonu.click();
        extentTest.info("Gecersiz odeme bilgisi girilir");
        ReusableMethods.wait(0.1);
        try {
            softAssert.assertTrue(checkoutPage.krediKartinizGecersizYazisi
                    .isDisplayed(),"Gecersiz kredi karti bilgileri sisteme eklenebiliyor!!");
            extentTest.info("Gecersiz KK bilgilerinin sisteme eklenemedigi dogrulanir.");
        } catch (Exception e) {
            checkoutPage.placeOrderButton.click();
            extentTest.info("Siparisi onaylamak icin 'place order' butonuna tiklanir.");
            softAssert.assertFalse(checkoutPage.siparisOnayYazisi.isDisplayed(),"Gecersiz odeme bilgileri ile siparis verilebiliyor.");
            extentTest.info("Gecersiz odeme bilgileri ile siparis verilemedigi dogrulanir.");
        }
        checkoutPage.addStripeCloseButonu.click();
        //
        softAssert.assertTrue(checkoutPage.gecerliOdemeBilgileriGirYazisi
                        .isDisplayed(),"Gecersiz odeme bilgileri ile odeme yapilabiliyor.");
        extentTest.info("Gecersiz odeme bilgileri ile siparis verilemedigi dogrulanir.");
        //
        extentTest.info("Tarayici kapatilir.");
        //
        extentTest.pass("Gecersiz odeme bilgileri ile siparis verilebilyor.");
        //
        softAssert.assertAll();


    }
    ////////////***********   TEST 6 ************////////////////////////////////////////////////////////
    @Test(groups = "smoke")
    public void tc_1306(){

        softAssert=new SoftAssert();
        restaurantUmiSakeHouse=new User_RestaurantUmiSakeHouse();
        checkoutPage=new User_CheckoutPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("TC_1306",
                "Order test with valid payment and valid address information.");
        //
        beforeMethod();
        //
        sepeteUrunEklemeMethodu();
        extentTest.info("Launch browser, go to the URL, log in as an user , add the first item from the restaurant to the cart.");
        //
        restaurantUmiSakeHouse.checkoutButton.click();
        extentTest.info("Go to the checkout page with the checkout button in the cart.");
        //
        urunSatinAlmaBilgileriGitmeMethodu();
        extentTest.info("Enter product purchase information");
        //
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //
        gecerliAdresBilgileriGirmeMethodu();
        extentTest.info("Enter valid address information");
        //
        gecerliOdemeBilgileriGirmeMethodu();
        extentTest.info("Enter the current payment information.");
        //
        checkoutPage.placeOrderButton.click();
        extentTest.info("Click on the 'place order' button to confirm the order.");
        //
        try {
            ReusableMethods.wait(1);
            softAssert.assertTrue(checkoutPage.siparisOnayYazisi
                    .isDisplayed());
        } catch (Exception e) {
            softAssert.assertTrue(false,"Unable to place order with valid address and payment information.");
        }
        extentTest.info("It is verified that the product could be ordered");
        //
        extentTest.info("Close the browser.");
        //
        extentTest.pass("The product can be ordered with valid address and payment information.");
        //
        softAssert.assertAll();

    }


    public void beforeMethod(){
        homepage=new User_Homepage();

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        homepage.cookieAcceptButton.click();
        ReusableMethods.userLoginMethod("duyguUserName","duyguUserPassword");
        homepage.adresButton.sendKeys(ConfigReader.getProperty("adres"));
        homepage.adres10001.click();

    }
    public void sepeteUrunEklemeMethodu(){
        homepage=new User_Homepage();
        restaurantUmiSakeHouse=new User_RestaurantUmiSakeHouse();

        if (!(Driver.getDriver().getCurrentUrl().equals("https://qa.mealscenter.com/restaurants"))) {
            Driver.getDriver().get("https://qa.mealscenter.com/restaurants");
        }
        //Umi Sake Hause restaurant tıklanır.
        homepage.umiSakeHouseRestaurantButton.click();

        // Ilk ürün 'add to cart' butonu ile sepete eklenir.
        restaurantUmiSakeHouse.ilkUrunAddToCartButton.click();
    }
    public void odemeBilgileriSilmeMethodu(){
        checkoutPage=new User_CheckoutPage();

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        JSUtilities.scrollToElement(Driver.getDriver(),checkoutPage.cashOnDeliveryDeleteButonuUcNokta);
        ReusableMethods.wait(0.1);
        checkoutPage.cashOnDeliveryDeleteButonuUcNokta.click();
        checkoutPage.cashOnDeliveryDeleteButonuDelete.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    public void gecerliOdemeBilgileriGirmeMethodu(){
        checkoutPage=new User_CheckoutPage();
        try {
            ReusableMethods.wait(0.2);
            odemeBilgileriSilmeMethodu();
            try {
                ReusableMethods.wait(0.2);
                odemeBilgileriSilmeMethodu();
            } catch (Exception e) {}
        } catch (Exception e) {}

        ReusableMethods.wait(0.5);
        checkoutPage.stripeButton.click();
        ReusableMethods.wait(0.5);
        Driver.getDriver().switchTo().frame(checkoutPage.krediKartiIframe);
        checkoutPage.krediKartiNumberTextBox.sendKeys(ConfigReader.getProperty("GecerliKKNumaraBilgileri"));
        checkoutPage.krediKartiDateTextBox.sendKeys(ConfigReader.getProperty("GecerliKKTarihBilgileri"));
        checkoutPage.krediKartiCvcTextBox.sendKeys(ConfigReader.getProperty("GecerliKKCVCbilgileri"));
        checkoutPage.krediKartiPostaKoduTextBox.sendKeys(ConfigReader.getProperty("GecerliKKPostaKoduBilgileri"));
        Driver.getDriver().switchTo().parentFrame();
        checkoutPage.addStripeButonu.click();
    }
    public void gecerliAdresBilgileriGirmeMethodu(){
        checkoutPage=new User_CheckoutPage();

        ReusableMethods.wait(0.5);
        checkoutPage.deliveryAdress.click();
        JSUtilities.scrollToElement(Driver.getDriver(),checkoutPage.deliveryAdressEditButton);
        ReusableMethods.wait(0.5);
        checkoutPage.deliveryAdressApartmentFloorBox.clear();
        checkoutPage.deliveryAdressApartmentFloorBox.sendKeys(ConfigReader.getProperty("GecerliAdres"));
        checkoutPage.deliveryAdressSaveButton.click();
    }

    public void urunSatinAlmaBilgileriGitmeMethodu(){
        checkoutPage=new User_CheckoutPage();

        // Delivery option secilir
        ReusableMethods.wait(0.1);
        checkoutPage.deliveryButton.click();
        checkoutPage.orderTypeDelivery.click();
        checkoutPage.orderTypeSaveButton.click();
        // Promotion option secilir
        ReusableMethods.wait(0.1);
        checkoutPage.promotionsButton.click();
        checkoutPage.promotionsOption2.click();
        checkoutPage.promotionsSave.click();
        // Include utensils and condiments option secilir
        ReusableMethods.wait(0.5);
        checkoutPage.includeUtensilsAndCondiments.click();
    }

}
