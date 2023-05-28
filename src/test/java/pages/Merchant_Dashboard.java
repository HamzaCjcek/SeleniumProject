package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Merchant_Dashboard {

    public Merchant_Dashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Merchant Login/usernameBox
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[1]")
    public WebElement usernameBox;

    //Merchant Login/passwordBox
    @FindBy (xpath = "(//input[@class='form-control form-control-text'])[2]")
    public WebElement passwordBox;

    //Merchant Login/signInButton
    @FindBy (xpath = "//input[@class='btn btn-green btn-full']")
    public WebElement signInButton;

    //merchant>dashboard/orders link
    @FindBy (xpath = "//li[@class='merchant_orders']")
    public WebElement ordersLink;

    //merchant>dashboard/scheduled Link
    @FindBy (xpath = "//a[text()='Scheduled']")
    public WebElement scheduledLink;

    //merchant>backoffice/orders>scheduled/scheduledBaslikText
    @FindBy (xpath = "//div[@class='flex-col d-none d-lg-block']")
    public WebElement scheduledBaslikText;

    //merchant>backoffice/orders>scheduled/completedTodayCount
    @FindBy (xpath = "//div[@class='ronded-green']")
    public WebElement completedTodayCount;

    //merchant>backoffice/orders>scheduled/acceptedButton
    @FindBy (xpath = "//button[@class='btn-green btn normal mr-2 font13 mb-3 mb-xl-0']")
    public WebElement acceptedButton;

    //merchant>backoffice/orders>scheduled/rejectButton
    @FindBy (xpath = "//span[text()='Reject']")
    public WebElement rejectButton;

    //backoffice/orders/scheduled>assignDriverButton
    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement assignDriverButton;


    // /backoffice/merchant/dashboard >> Dasboard menusunun tamami
    @FindBy(xpath = "//div[@id='vue-siderbar-menu']")
    public WebElement dasboardMenusununTamami;

    // /backoffice/merchant/dashboard >> Dasboard menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[1]")
    public WebElement dashboardMenuButonu;

    // /backoffice/merchant/dashboard >> Merchant menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[2]")
    public WebElement merchantMenuButonu;

    // /backoffice/merchant/dashboard >> Orders menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[3]")
    public WebElement ordersMenuButonu;

    // /backoffice/merchant/dashboard >> Attributes menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[6]")
    public WebElement attributesMenuButonu;

    // /backoffice/merchant/dashboard >> Food menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[7]")
    public WebElement foodMenuButonu;

    // /backoffice/merchant/dashboard >> Order menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[8]")
    public WebElement orderTypeMenuButonu;

    // /backoffice/merchant/dashboard >> Payment Gateway menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[9]")
    public WebElement paymentGatewayMenuButonu;

    // /backoffice/merchant/dashboard >> Promo menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[10]")
    public WebElement promoMenuButonu;

    // /backoffice/merchant/dashboard >> Images menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[11]")
    public WebElement imagesMenuButonu;

    // /backoffice/merchant/dashboard >> Account menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[12]")
    public WebElement accountMenuButonu;

    // /backoffice/merchant/dashboard >> Buyers menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[14]")
    public WebElement buyersMenuButonu;

    // /backoffice/merchant/dashboard >> Users menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[15]")
    public WebElement usersMenuButonu;

    // /backoffice/merchant/dashboard >> Reports menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[16]")
    public WebElement reportsMenuButonu;

    // /backoffice/merchant/dashboard >> Inventory Management menusu butonu
    @FindBy(xpath = "(//ul[@class='sidebar-nav']/li)[18]")
    public WebElement inventoryManagementMenuButonu;

    // merchant login > image
    @FindBy(xpath = "//div[@class='col-md-6 m-0 p-0 left-container']")
    public WebElement loginImage;

    // merchant login > merchant login yazısı
    @FindBy(xpath = "//h6[@class='mb-4']")
    public WebElement textMerchantLogin;

    // merchant login > meals center amblemi
    @FindBy(xpath = "//img[@class='img-60 rounded-circle']")
    public WebElement amblem;

    // merchant login > remember me kutucuğu
    @FindBy(xpath = "//div[@class='custom-checkbox ml-3']")
    public WebElement rememberMeKutucuk;

    // merchant login > App store download linki
    @FindBy(xpath = "(//div[@class='p-2'])[1]")
    public WebElement appStoreLink;

    // merchant login > Play store download linki
    @FindBy(xpath = "(//div[@class='p-2'])[1]")
    public WebElement playStoreLink;

    // merchant login > This field is required yazısı
    @FindBy(xpath = "(//div[@class='errorMessage'])[1]")
    public WebElement requiredText;

    // merchant login > Incorrect username or password yazısı
    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement incorrectText;


    //merchant > Dasshboard / All Orders link
    @FindBy (xpath = "//li[@class='position-relative orders_history']")
    public WebElement allOrdersLink;


    //merchant > Dasshboard / All Orders link
    @FindBy (xpath = "//a[text()='All Orders']")
    public WebElement allOrdersLinkText;

    //merchant > Dasshboard / orderHistory
    @FindBy (xpath = "//a[@class='navbar-brand']")
    public WebElement orderHistoryText;


    //Merchant>backoffice>orders>completed
    @FindBy(xpath = "//li[@class='position-relative orders_completed']")
    public WebElement completedLink;


    @FindBy(xpath = "//h5[@class='head m-0']")
    public WebElement completedText;

    //merchant>backoffice/orders>completed/completedtodayCount

    @FindBy(xpath = "(//div[@class='col'])[1]")
    public List<WebElement> completedtodayOrdersList;

    //merchant>backoffice/orders>completed/ordertypeddm
    @FindBy(xpath = "(//select[@class='selectpicker'])[1]")
    public WebElement orderTypeDdm;

    //merchant>backoffice/orders>completed/paymentstatusddm
    @FindBy(xpath = "//select[@title='Payment status']")
    public WebElement paymentStatusDdm;

    //merchant>backoffice/orders>completed/sortddm
    @FindBy(xpath = "//select[@title='Sort']")
    public WebElement sortDdm;
    //merchant>backoffice/orders>completed/acceptingOrdersButton
    @FindBy(xpath = "//button[@class='btn btn-green']")
    public WebElement acceptingOrdersButton;

    //merchant>backoffice/orders>completed/cancelButton
    @FindBy(xpath = "(//span[text()='Cancel'])[1]")
    public WebElement  cancelButton;

    //merchantUrl>login/Dashboard menusu altındaki
    @FindBy(xpath = "//li[@class='promo']")
    public WebElement promoLink;
    //merchantUrl>login/Dashoard/Promo/caupon
    @FindBy(xpath = "//a[text()='Coupon']")
    public WebElement couponLink;
    @FindBy(xpath = "//a/h5[text()='Coupon list']")
    public WebElement couponListText;
    @FindBy(xpath = "//i[@class='zmdi zmdi-plus']")
    public WebElement plusLink;

    //merchant/backoffice/food/category_create>merchantname
    @FindBy(xpath="(//a[@id=\"dropdownMenuLink\"])[1]")
    public WebElement merchantname;


    @FindBy(xpath="(//a[@class=\"dropdown-item\"])[1]")
    public WebElement profil;

    @FindBy(xpath="//input[@name=\"AR_merchant_user[first_name]\"]")
    public WebElement firstnamebox;

    @FindBy(xpath = "(//li[@class=\"active\"])[1]")
    public WebElement BasicDetailsbox;

    @FindBy(xpath ="//input[@id=\"AR_merchant_user_last_name\"]" )
    public WebElement Lastnamebox;

    @FindBy(xpath="//input[@id=\"AR_merchant_user_contact_email\"]")
    public WebElement Emailbox;

    @FindBy(xpath="//input[@id=\"AR_merchant_user_contact_number\"]")
    public WebElement Contactnumber;

    @FindBy(xpath="//input[@id=\"AR_merchant_user_username\"]")
    public WebElement Username;

    @FindBy(xpath="//button[@style=\"padding: 0.375rem 0.75rem;\"]")
    public WebElement browseboxı;

    @FindBy(xpath="//img[@src=\"https://qa.mealscenter.com/backoffice/../upload/6/11eabb1f-c0e0-11ed-ac97-2cea7f508bb0@thumbnail.jpg\"]")
    public WebElement browseboxpicture;

    @FindBy(xpath="//span[text()=\"Add Files\"]")
    public WebElement AddFilesbuton;

    @FindBy(xpath="//span[@style=\"font-size: 1.5rem;\"]")
    public WebElement browseçıkış;

    @FindBy(xpath="//input[@type=\"submit\"]")
    public WebElement Savebox1;

    @FindBy(xpath="(//i[@class=\"zmdi zmdi-lock-outline\"])[1]")
    public WebElement ChangePasswordlinki;

    @FindBy(xpath="//input[@id=\"AR_merchant_user_old_password\"]")
    public WebElement Oldpasswordbox;

    @FindBy(xpath="//input[@id=\"AR_merchant_user_new_password\"]")
    public WebElement Newpasswordbox;

    @FindBy(xpath="//input[@id=\"AR_merchant_user_repeat_password\"]")
    public WebElement Confirmpasswordbox;

    @FindBy(xpath="//input[@class=\"btn btn-green btn-full mt-3 changepassButton\"]")
    public WebElement Savebox2;

    @FindBy(xpath="//div[@class=\"alert alert-success\"]")
    public WebElement Updateyazısı;

    @FindBy(xpath="//a[text()=\"Dashboard\"]")
    public WebElement Dashboardyazısı;

    @FindBy(xpath="//div[@class=\"rounded-status-report rounded r1\"]")
    public WebElement TotalOrders;

    @FindBy(xpath="//div[@class=\"rounded-status-report rounded r2\"]")
    public WebElement TotalCancel;

    @FindBy(xpath="//div[@class=\"rounded-status-report rounded r3\"]")
    public WebElement TotalRefund;

    @FindBy(xpath="//div[@class=\"rounded-status-report rounded r4\"]")
    public WebElement TotalSales;

    @FindBy(xpath="(//div[@style=\"padding: 10px;\"])[1]")
    public WebElement SalesThisWeek;

    @FindBy(xpath="(//div[@style=\"padding: 10px;\"])[2]")
    public WebElement EarningThisWeek;

    @FindBy(xpath="(//div[@style=\"padding: 10px;\"])[3]")
    public WebElement YourBalance;

    @FindBy(xpath="(//div[@class=\"card-body\"])[4]")
    public WebElement OrderReceived;

    @FindBy(xpath="(//div[@class=\"card-body\"])[5]")
    public WebElement TodayDelivered;

    @FindBy(xpath="(//div[@class=\"card-body\"])[6]")
    public WebElement TodaySales;

    @FindBy(xpath="(//div[@class=\"card-body\"])[7]")
    public WebElement TodayRefund;

    @FindBy(xpath="(//div[@class=\"card-body\"])[10]")
    public WebElement SalesOverview;

    @FindBy(xpath="(//div[@class=\"card-body\"])[12]")
    public WebElement OverviewOfReview;

    @FindBy(xpath="(//div[@class=\"card-body\"])[11]")
    public WebElement TopCustomers;

    @FindBy(xpath="(//div[@class=\"card-body\"])[8]")
    public WebElement LastOrders;

    @FindBy(xpath="(//div[@class=\"card-body\"])[9]")
    public WebElement PopularItems;

    @FindBy(xpath="//a[text()=\"Food\"]")
    public WebElement FoodButonu;

    @FindBy(xpath="//a[text()=\"Category\"]")
    public WebElement CategoryButonu;

    @FindBy(xpath="//a[@class=\"navbar-brand\"]")
    public WebElement CategoryListYazısı;

    @FindBy(xpath="(//tr[@class=\"even\"])[1]")
    public WebElement SignatureRoll;

    @FindBy(xpath="(//tr[@class=\"even\"])[2]")
    public WebElement MakiandclassicRoll;

    @FindBy(xpath="(//tr[@class=\"odd\"])[2]")
    public WebElement Sushibox;

    @FindBy(xpath="(//tr[@class=\"odd\"])[1]")
    public WebElement PickedForYou;

    @FindBy(xpath = "(//div[@class=\"p-2\"])[1]")
    public WebElement AddNewButonu;

    @FindBy(xpath="//input[@id=\"AR_category_category_name\"]")
    public WebElement NameBox;

    @FindBy(xpath="//textarea[@id=\"AR_category_category_description\"]")
    public WebElement Descriptionbox;

    @FindBy(xpath="//button[@style=\"padding: 0.375rem 0.75rem;\"]")
    public WebElement Browsebox1;

    @FindBy(xpath="(//img[@src=\"https://qa.mealscenter.com/backoffice/../upload/6/11eabb1f-c0e0-11ed-ac97-2cea7f508bb0@thumbnail.jpg\"])[1]")
    public WebElement FeaturedImage;

    @FindBy(xpath="(//span[text()=\"Add Files\"])[1]")
    public WebElement AddFilesButonu;

    @FindBy(xpath="(//button[text()=\"Browse\"])[2]")
    public WebElement Browsebox2;

    @FindBy(xpath ="(//*[@id=\"modalUploader\"]/div/div/div[2]/div[2]/ul/li[1])[2]")
    public WebElement IconImage;

    @FindBy(xpath ="//div[@class=\"alert alert-success\"]")
    public WebElement SuccesfullyCreatedYazısı;


    @FindBy(xpath="(//span[text()=\"Add Files\"])[2]")
    public WebElement AddFiles2;

    @FindBy(xpath ="//span[@class=\"select2-selection select2-selection--multiple\"]")
    public WebElement DishBox;

    @FindBy(xpath="//li[@id=\"select2-AR_category_dish_selected-result-6i3u-1\"]")
    public WebElement MealBox;

    @FindBy(xpath="//select[@id=\"AR_category_status\"]")
    public WebElement StatusBox;

    @FindBy(xpath="//input[@type=\"submit\"]")
    public WebElement Savebox;

    @FindBy(xpath = "//div[@class=\"alert alert-success\"]")
     public WebElement SuccesfulyUpdatedYazısı;

    @FindBy(xpath="//i[@class=\"zmdi zmdi-plus\"]")
    public WebElement ItemTranslationsButton;

    @FindBy(xpath="//input[@id=\"AR_category_category_translation_ja\"]")
    public WebElement JapaneseTranslationBox;

    @FindBy(xpath="//textarea[@id=\"AR_category_category_description_translation_ja\"]")
    public WebElement JapaneseDescriptionBox;

    @FindBy(xpath ="//input[@id=\"AR_category_category_translation_ar\"]")
    public WebElement ArabicTranslationBox;

    @FindBy(xpath="//textarea[@id=\"AR_category_category_description_translation_ar\"]")
    public WebElement ArabicDescriptionBox;

    @FindBy(xpath = "(//i[@class=\"zmdi zmdi-border-color\"])[1]")
    public WebElement UpdateButonu;

    @FindBy(xpath="(//a[@class=\"btn btn-light datatables_delete tool_tips\"])[1]")
    public WebElement DeleteButonu;

    @FindBy(xpath="/html/body/div[1]/div[3]/div/div/div/div/div/div[3]/a")
    public WebElement DeleteConfirmation;

    @FindBy(xpath = "//a[@class=\"btn btn-primary btn-circle\"]")
    public WebElement SortButton;

    @FindBy(xpath="//div[@class=\"breadcrumbs\"]")
    public WebElement CategorySortPage;

    @FindBy(xpath="//input[@id=\"AR_category_category_name\"]")
    public WebElement UpdateName;

    //merchant>dashboard>ordertype
    @FindBy(xpath ="//li[@class='services_settings']")
    public WebElement orderTypeLink;

    //merchant>dashboard>ordertype>delivery
    @FindBy(xpath ="//a[@href='/backoffice/services/delivery_settings']")
    public WebElement deliveryLink;

    //merchant>dashboard>ordertype>delivery>settingtext
    @FindBy(xpath ="(//li[@class='active'])[1]")
    public WebElement settingText;

    //merchant>dashboard>ordertype>delivery>checkbox1
    @FindBy(xpath = "//label[@for='merchant_opt_contact_delivery']")
    public WebElement checkbox1;
    //merchant>dashboard>ordertype>delivery>checkbox2

    @FindBy(xpath = "//label[@for='free_delivery_on_first_order']")
    public WebElement checkbox2;

    //merchant>dashboard>ordertype>delivery>fixedchargeddm
    @FindBy(xpath = "//select[@id='AR_option_merchant_delivery_charges_type']")
    public WebElement fixedchargeDdm;

    //merchant>dashboard>ordertype>delivery>servicefeebox
    @FindBy(xpath ="//input[@type='text']")
    public WebElement serviceFeeBox;

    //merchant>dashboard>ordertype>delivery
    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement errorMessage;

    //merchant>dashboard>ordertype>delivery>savebutton
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement saveButon1;

    //merchant>dashboard>ordertype>delivery>settingsSavedText
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement settingsSavedText;

    //merchant>dashboard>ordertype>delivery>fixedchargetext
    @FindBy(xpath ="//a[@href='/backoffice/services/fixed_charge'][1]")
    public WebElement fixedChargeText;

    //merchant>dashboard>ordertype>delivery>pricebox
    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement priceBox;

    //merchant>dashboard>ordertype>delivery>fixedchargesavebutton
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement fixedChargeSaveButon;

    //merchant>dashboard>ordertype>delivery>alert
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement succesfullyupdatedalert;


    //merchant/dashboard>AllOrders un yanında yazan sayı
    @FindBy(xpath = "//div[@class='badge-pill pull-right badge-notification bg-history']")
    public WebElement allOrdersCount;

    //backoffice/orders/history > header daki Orders sayısı
    @FindBy(xpath = "(//h5[@class='m-0'])[1]")
    public WebElement ordersCount;

    //backoffice/orders/history > sayfanın en altindaki entries sayisi
    @FindBy(xpath = "//div[@class='col-sm-12 col-md-5']")
    public WebElement entriesCount;

    //backoffice/orders/history > Start date end date
    @FindBy(xpath = "//div[@class='input-group fixed-width-field mr-2']")
    public WebElement startDateEndDate;


    //backoffice/orders/history > Start date end date secim Yesterday
    @FindBy(xpath = "//li[@data-range-key='Yesterday']")
    public WebElement tarihSecimiYesterday;

    //backoffice/orders/history > header cancel sayisi
    @FindBy(xpath = "(//h5[@class='m-0'])[2]")
    public WebElement cancelCount;

    //backoffice/orders/history > header Total refund miktari
    @FindBy(xpath = "(//h5[@class='m-0'])[3]")
    public WebElement totalRefundMoney;

    //backoffice/orders/history > header Total Orders miktari
    @FindBy(xpath = "(//h5[@class='m-0'])[4]")
    public WebElement totalOrdersMoney;


    //backoffice/orders/history > header Filters buttonu
    @FindBy(xpath = "//button[@class='btn btn-yellow normal']")
    public WebElement filtersButton;


    //backoffice/orders/history > header Filters buttonu tiklayinca çikan bolumun ikinci secenegi
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[2]")
    public WebElement byStatusBox;


    //backoffice/orders/history > header Filters buttonu tıklayınca cıkan bolumdeki applyFiltersButton
    @FindBy(xpath = "//button[@class='btn btn-green w-100']")
    public WebElement applyFiltersButton;

    //backoffice/orders/history > musteri listesinin basligi
    @FindBy(xpath = "(//th[@class='sorting_disabled'])[2]")
    public WebElement customerBaslik;

    //backoffice/orders/history > musteri listesinin basligi
    @FindBy(xpath = "(//th[@class='sorting_disabled'])[3]")
    public WebElement orderInformationBaslik;

    //backoffice/orders/history > musteri listesinin basligi
    @FindBy(xpath = "(//th[@class='sorting_disabled'])[4]")
    public WebElement actionsBaslik;

    //backoffice/orders/history > musteri listesinin basligi
    @FindBy(xpath = "//th[@class='sorting sorting_desc']")
    public WebElement orderIDBaslik;


    //backoffice/orders/history > musteri listesindeki ilk musteri
    @FindBy(xpath = "(//tr[@class='odd'])[1]")
    public WebElement musteriBilgi;


    //backoffice/orders/history > musteri listesindeki ilk gosterButtonu
    @FindBy(xpath = "(//a[@class='btn btn-light tool_tips'])[1]")
    public WebElement gosterButtonu;


    //backoffice/orders/history > musteri listesindeki ilk musteri downloadButtonu
    @FindBy(xpath = "(//a[@class='btn btn-light tool_tips'])[2]")
    public WebElement downloadButtonu;


    //=================== Size Page=======================

    //merchant/dashboard > attributesLinki
    @FindBy(xpath = "//li[@class='attributes']")
    public WebElement attributesLinki;


    //merchant/dashboard > attributesLinki> sizeLinki
    @FindBy(xpath = "//li[@class='position-relative attrmerchant_size_list']")
    public WebElement sizeLinki;



    //merchant/dashboard > attributesLinki> sizeLinki sayfa aktifken
    @FindBy(xpath = "//li[@class='position-relative attrmerchant_size_list active']")
    public WebElement sizeLinkiActive;


    //merchant/dashboard > attributesLinki> sizeLink > sizeSayfasiBasligi
    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement sizeSayfasiBasligi;


    //merchant/dashboard > attributesLinki>  size list Sayfasi
    @FindBy(xpath = "(//th[@class='sorting'])[1]")
    public WebElement noBasligi;


    //merchant/dashboard > attributesLinki>  size list Sayfasi
    @FindBy(xpath = "(//th[@class='sorting'])[2]")
    public WebElement nameBasligi;


    //merchant/dashboard > attributesLinki>  size list Sayfasi
    @FindBy(xpath = "(//th[@class='sorting'])[3]")
    public WebElement actionsBasligi;


    //merchant/dashboard > attributesLinki>  size list Sayfasi
    @FindBy(xpath = "//input[@class='form-control rounded search w-25']")
    public WebElement searchSizeBox;


    //merchant/dashboard > attributesLinki>  size list Sayfasi
    @FindBy(xpath = "(//input[@type='search']")
    public WebElement searchSizeBox2;


    //merchant/dashboard > attributesLinki>  size list Sayfasi
    @FindBy(xpath = "//a[@type='button']")
    public WebElement addNewButton;


    //================ Add Size ==============================

    //merchant/dashboard > attributesLinki>  size list Add Size
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[1]")
    public WebElement sizeNameBox;


    //merchant/dashboard > attributesLinki>  size list Add Size
    @FindBy(xpath = "//input[@id='AR_size_size_name']")
    public WebElement sizeNameBox2;


    //merchant/dashboard > attributesLinki>  size list Add Size
    @FindBy(xpath = "//input[@class='btn btn-green btn-full mt-3']")
    public WebElement saveButton;


    //merchant/dashboard > attributesLinki>  size list Add Size
    @FindBy(xpath = "(//h6)[2]")
    public WebElement listIlkName;

    //merchant/dashboard > attributesLinki>  size list Add Size
    @FindBy(xpath = "(//a[@class='btn btn-light datatables_delete tool_tips'])[1]")
    public WebElement deleteButtonSizeAll;


    //merchant/dashboard > attributesLinki>  size list Add Size
    @FindBy(xpath = "//a[@class='btn btn-green item_delete']")
    public WebElement deleteConfirmationButton;


    //merchant/dashboard > attributesLinki>  size list Add Size
    @FindBy(xpath = "(//a[@class='btn btn-light tool_tips'])[1]")
    public WebElement updateButton;


    //merchant/dashboard > attributesLinki> Update Size/ Succesfully UpdatedYazisi
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement succesfullyUpdatedYazisi;


    //merchant/dashboard > attributesLinki>ingredientsLinki
    @FindBy(xpath = "//li[@class='position-relative attrmerchant_ingredients_list']")
    public WebElement ingredientsLinki;


    //merchant/dashboard > attributesLinki>ingredientsLinki
    @FindBy(xpath = "//li[@class='position-relative attrmerchant_ingredients_list active']")
    public WebElement ingredientsLinkiActive;


    //merchant/dashboard > attributesLinki>cookingReferenceLinki
    @FindBy(xpath = "//li[@class='position-relative attrmerchant_cookingref_list']")
    public WebElement cookingReferenceLinki;


    //merchant/dashboard > attributesLinki>cookingReferenceLinki
    @FindBy(xpath = "//li[@class='position-relative attrmerchant_cookingref_list active']")
    public WebElement cookingReferenceLinkiActive;

    @FindBy(xpath="(//i[@class=\"zmdi zmdi-info-outline\"])[1]")
    public WebElement DetailsBox;



    //===mmeral===


    @FindBy(xpath="(//img[@src=\"https://qa.mealscenter.com/backoffice/../upload/6/e3ee0883-c0df-11ed-ac97-2cea7f508bb0@thumbnail.jpg\"])[1]")
     public WebElement UpdateFeaturedImage;

   @FindBy(xpath="//div[@class=\"alert alert-success\"]")
    public WebElement UpdatedYazısı;

   @FindBy(xpath = "//div[@id=\"DataTables_Table_0_info\"]")
    public WebElement EntryYazısı;

//=================== scheduled sayfası locater ================
    //merchant/backoffice/orders/scheduled
    @FindBy(xpath="(//div[@class='filter-option'])[3]")
    public WebElement shedueledSort;

    //merchant/backoffice/orders/scheduled
    @FindBy(xpath="//li[@class='chevron selected']")
    public WebElement eklenenSonSiparis;


    //merchant/backoffice/orders/scheduled
    @FindBy(xpath="(//a[@role='option'])[10]")
    public WebElement orderIDDescending;


    //merchant/backoffice/orders/scheduled
    @FindBy(xpath="//span[@class='ml-2 badge']")
    public WebElement acceptedText;


    //merchant/backoffice/orders/scheduled
    @FindBy(xpath="(//a[@class='text-center list-group-item list-group-item-action'])[1]")
    public WebElement outOfItemButton;

    //merchant/backoffice/orders/scheduled
    @FindBy(xpath="(//button[@class='btn btn-green pl-4 pr-4'])[5]")
    public WebElement rejectOrderButton;


    //merchant/backoffice/orders/scheduled
    @FindBy(xpath="(//h5[@class='m-0'])[3]")
    public WebElement orderNoText;




    //merchant/backoffice/orders/scheduled
    @FindBy(xpath="//*[@id='vue-order-management']/div[8]//div/ul//div[2]/div")
    public WebElement orderNoTamami;

        //===mmeral===

    //Merchant > Login > Dashboard/Food
    @FindBy(xpath = "//li[@class='food']")
    public WebElement foodelement;

    //Merchant > Login > Dashboard/Food/Items
    @FindBy(xpath = "//*[text()='Items']")
    public WebElement itemsElement;

    //Merchant > Login > Dashboard/Food/Items
    @FindBy(xpath = "(//*[text()='Item list'])[2]")
    public WebElement itemdogrulama;

    //Merchant > Login > Dashboard/Food/Items/Addnew
    @FindBy(xpath = "(//a[@type='button'])[1]")
    public WebElement addnewButton;

    //Merchant > Login > Dashboard/Food/Items/Addnew>Addnewıtems
    @FindBy(xpath = "//span[text()='Add Item']")
    public WebElement addnewdogrulama;

    //Merchant > Login > Dashboard/Food/Items/Addnew > Addnewıtems/ıtemname
    @FindBy(xpath = "//input[@id='AR_item_item_name']")
    public WebElement itemname;

    //Merchant > Login > Dashboard/Food/Items/Addnew > Addnewıtems/ıtemname/categoryddm
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[1]")
    public WebElement addnewcatagory;

    //Merchant > Login > Dashboard/Food/Items/Addnew > Addnewıtems/ıtemname/categoryddm
    @FindBy(xpath = "(//*[text()='Maki and classic Roll'])[2]")
    public WebElement categoryddm;

    //Merchant > Login > Dashboard/Food/Items/Addnew > Addnewıtems/ıtemname/categoryddm
    @FindBy(xpath = "//*[@value='Save']")
    public WebElement categorySavebutton;

    //Merchant > Login > Dashboard/Food/Items/Addnew > Addnewıtems/ıtemname/categoryddm
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement categorysuccesscreated;

    //Merchant > Login > Dashboard/Food/Items/Update
    @FindBy(xpath = "//*[@class='zmdi zmdi-border-color']")
    public WebElement updatebutton;

    //Merchant > Login > Dashboard/Food/Items/Update
    @FindBy(xpath = "//input[@id='AR_item_item_name']")
    public WebElement updateicerik;

    //Merchant > Login > Dashboard/Food/Items/Update
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement updateSavebutton;

    //Merchant > Login > Dashboard/Food/Items/Update
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement updatesuccescreated;

    //Merchant > Login > Dashboard/Orders
    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement ordersbutton;

    //Merchant > Login > Dashboard/Orders/neworders
    @FindBy(xpath = "//*[text()='New Orders']")
    public WebElement newordersbutton;

    //Merchant > Login > Dashboard/Orders/neworders
    @FindBy(xpath = "//div[@class='ronded-green']")
    public WebElement newordersdogrulama;

    //Merchant > Login > Dashboard/Orders/neworders
    @FindBy(xpath = "//*[text()='Accepted']")
    public WebElement acceptedbutton;

    //Merchant > Login > Dashboard/Orders/neworders
    @FindBy(xpath = "(//h5[@class='m-0'])[3]")
    public WebElement succesaccepted;


    //Merchant > Login > Dashboard/Orders/neworders
    @FindBy(xpath = "//*[text()='Reject']")
    public WebElement rejectbutton;

    //Merchant > Login > Dashboard/Orders/neworders
    @FindBy(xpath = "//*[@id='reason']")
    public WebElement rejectReason;

    //Merchant > Login > Dashboard/Orders/neworders
    @FindBy(xpath = "//*[text()='Reject order']")
    public WebElement rejectOrder;

    @FindBy(xpath = "//i[@class='zmdi zmdi-plus mr-2']")
    public WebElement newordersAddbutton;

    @FindBy(xpath = "(//div[@class='col-7 text-center p-1'])[1]")
    public WebElement addbuttonicerik;
    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement addsearchbox;

    @FindBy(xpath = "//*[text()='Add to order - ']")
    public WebElement addorder;
    @FindBy(xpath = "(//span[@aria-hidden='true'])[10]")
    public WebElement addorderkapatma;




    //Merchant > Login > Dashboard/Orders/ordersprocessing
    @FindBy(xpath = "//li[@class='position-relative orders_processing']")
    public WebElement orderProcessing;

    //Merchant > Login > Dashboard/Orders/ordersprocessing
    @FindBy(xpath = "//div[@class='ronded-green']")
    public WebElement orderprocessindogrulama;

    //Merchant > Login > Dashboard/Orders/ordersprocessing
    @FindBy(xpath = "//*[text()='Ready for pickup']")
    public WebElement readyforpickupbutton;

    //Merchant > Login > Dashboard/Orders/ordersprocessing
    @FindBy(xpath = "//input[@class='form-control py-2 border-right-0 border']")
    public WebElement searchbutton;

    @FindBy(xpath = "(//p[@class='m-0'])[7]")
    public WebElement searchdogrulama;





    //Merchant > Login > Dashboard/orders/history
    @FindBy(xpath = "//h5[text()='Summary']")
    public WebElement summaryText;

    //Merchant > Login > Dashboard/orders/history
    @FindBy(xpath = "(//span[@class='el-radio-button__inner'])[1]")
    public WebElement assignDriverMaps;




}
