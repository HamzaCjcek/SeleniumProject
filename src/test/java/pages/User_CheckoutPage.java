package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class User_CheckoutPage {

    public User_CheckoutPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//a[@class='d-block chevron-section transaction-section d-flex align-items-center rounded mb-2']")
    public WebElement deliveryButton;
    @FindBy(xpath = "(//a[@class='d-block chevron-section promo-section d-flex align-items-center rounded mb-2'])[1]")
    public WebElement phoneButton;
    @FindBy(xpath = "(//a[@class='d-block chevron-section promo-section d-flex align-items-center rounded mb-2'])[2]")
    public WebElement promotionsButton;
    @FindBy(xpath = "//div[@class='custom-control custom-switch custom-switch-md']")
    public WebElement includeUtensilsAndCondiments;
    @FindBy(xpath = "(//a[@class='d-block chevron-section medium d-flex align-items-center rounded mb-2'])[1]")
    public WebElement cashOnDeliveryButton;
    @FindBy(xpath = "(//a[@class='d-block chevron-section medium d-flex align-items-center rounded mb-2'])[2]")
    public WebElement stripeButton;
    @FindBy(xpath = "(//div[@class='flexcol'])[5]")
    public WebElement deliveryAdress;
    @FindBy(xpath = "//button[@class='btn btn-green w-100 pointer']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//p[@class='mb-1']")
    public WebElement sepettekiUrunIsmi;





    //UserHomePage/account/checkout >> Delivery Secenekleri Bolumu///////////////////////
    @FindBy(xpath = "(//div[@class='custom-control custom-radio'])[1]")
    public WebElement orderTypeDelivery;
    @FindBy(xpath = "(//div[@class='custom-control custom-radio'])[2]")
    public WebElement orderTypeDinein;
    @FindBy(xpath = "(//div[@class='custom-control custom-radio'])[3]")
    public WebElement orderTypePickup;
    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement orderTypeDeliveryTimeNow;
    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement orderTypeDeliveryTimeScheduleForLater;
    @FindBy (xpath = "(//span[text()='Save'])[2]")
    public WebElement orderTypeSaveButton;
    @FindBy(xpath = "(//i[@class='zmdi zmdi-close font20'])[2]")
    public WebElement orderTypeClose;
    /////////////////////////////

    //UserHomePage/account/checkout >> Telefon Yazma Bolumu//////////////
    @FindBy(xpath = "(//i[@class='zmdi zmdi-close font20'])[3]")
    public WebElement editPhoneClose;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement editPhoneNumberBox;
    @FindBy(xpath = "(//button[@class='btn btn-black w-100'])[1]")
    public WebElement editPhoneCancelButton;
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[3]")
    public WebElement editPhoneContinueButton;
    /////////////////////////////

    //UserHomePage/account/checkout >> Promotions Bolumu//////////////

    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[3]")
    public WebElement promotionsClose;
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[3]")
    public WebElement promotionsAddButton;
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[3]")
    public WebElement promotionsOption1;
    @FindBy(xpath = "(//label[@class='custom-control-label font14 bold'])[5]")
    public WebElement promotionsOption2;
    @FindBy(xpath = "(//div[@class='modal-footer justify-content-start'])[5]")
    public WebElement promotionsSave;
    //////////////////////////////////////

    //UserHomePage/account/checkout >> Catal kasık baharat secenekleri Bolumu//////////////

    //////////////////////////////////////////////////////////////

    //UserHomePage/account/checkout >> Delivery Adress Bolumu//////////////

    @FindBy(xpath = "//input[@id='location_name']")
    public WebElement deliveryAdressApartmentFloorBox;
    @FindBy(xpath = "(//select[@class='form-control custom-select'])[2]")
    public WebElement deliveryOptionsButton; //>> bu buton choose a delivery adress penceresinin icinde
    @FindBy(xpath = "//textarea[@id='delivery_instructions']")
    public WebElement addDeliveryInstructionsButton;
    @FindBy(xpath = "(//button[@class='btn btn-black w-100'])[2]")
    public WebElement deliveryAdressCancelButton;
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[8]")
    public WebElement deliveryAdressSaveButton;
    @FindBy(xpath = "(//i[@class='zmdi zmdi-close font20'])[7]")
    public WebElement getDeliveryAdressClose;
    @FindBy(xpath = "//a[text()='Edit '] ")
    public WebElement deliveryAdressEditButton;
    @FindBy(xpath = "//input[@id='formatted_address']")
    public WebElement completeAdressButonu;
    @FindBy(xpath = "//h5[text()='Confirming your order']")
    public WebElement siparisOnayYazisi;
    @FindBy(xpath = "//p[text()='Payment already exist']")
    public WebElement odemeMevcutYazisi;
    //////////////////////////////

    //UserHomePage/account/checkout >> Payment Methods bolumu/////////////

    //cash on delivery icinde
    @FindBy(xpath = "//span[text()='Add Cash']")
    public WebElement addCashButton;
    //cash on delivery penceresini kapatma butonu
    @FindBy(xpath = "(//a[@class='btn btn-black btn-circle rounded-pill'])[10]")
    public WebElement addCashOnDeliveryClose;
    @FindBy(xpath = "//a[@id='dropdownMenuLink']")
    public WebElement cashOnDeliveryDeleteButonuUcNokta;
    @FindBy(xpath = "//a[text()='Delete']")
    public WebElement cashOnDeliveryDeleteButonuDelete;

    /////////////////////////////////////////////////////////////////////////
    //AddStripe
    @FindBy(xpath = "(//button[@class='btn btn-green w-100'])[10]")
    public WebElement addStripeButonu;
    @FindBy(xpath = "(//a[@class='btn btn-black btn-circle rounded-pill'])[11]")
    public WebElement addStripeCloseButonu;
    @FindBy(xpath = "//iframe[@title='Güvenli kart ödeme giriş çerçevesi']")
    public WebElement krediKartiIframe;
    @FindBy(xpath = "//input[@aria-label='Kredi veya banka kartı numarası']")
    public WebElement krediKartiNumberTextBox;//>>>>IFRAME icinde
    @FindBy(xpath = "//input[@name=\"exp-date\"]")
    public WebElement krediKartiDateTextBox;
    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement krediKartiCvcTextBox;
    @FindBy(xpath = "//input[@autocomplete='postal-code']")
    public  WebElement krediKartiPostaKoduTextBox;

    ////////////////////////
    @FindBy(xpath = "//div[@class=\"alert alert-warning mb-2\"]")
    public WebElement krediKartinizGecersizYazisi;
    @FindBy(xpath = "//p[text()='Please select valid payment method']")
    public WebElement gecerliOdemeBilgileriGirYazisi;


    @FindBy(xpath = "(//*[@class='btn'])[1]")
    public WebElement  scheduleForLaterButton;


    @FindBy(xpath = "//div[@class='schedule-section']")
    public WebElement  scheduleDayDdm;


    @FindBy(xpath = "//select[@id='delivery_time']")
    public WebElement  scheduleDayTime;


}
