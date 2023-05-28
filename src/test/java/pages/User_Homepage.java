package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class User_Homepage {

public User_Homepage(){

    PageFactory.initElements(Driver.getDriver(),this);
}
    // homepage sol ust mealscenter butonu
    @FindBy(xpath = "//div[@class='top-logo']")
    public WebElement mealscenterButton;

    // homepage header yazisi
    @FindBy (xpath = "//h2[@class='text-center mb-3']")
    public WebElement headerScript;

    // homepage main banner
    @FindBy(xpath = "//div[@id='main-search-banner']")
    public WebElement mainBanner;

    // homepage American butonu
    @FindBy (xpath = "(//div[@class='col cuisineMainPage'])[1]")
    public WebElement americanButton;

    // homepage more butonu
    @FindBy (xpath = "//a[@id='dropdownCuisine']")
    public WebElement moreButton;

    // homepage ust sol yon butonu
    @FindBy (xpath = "(//a[@class='owl-carousel-nav prev mr-4'])[1]")
    public WebElement upperLeftNavigateButton;

    // homepage cookie kabul butonu
    @FindBy (xpath = "(//button[@ref_key='_ref'])[1]")
    public WebElement cookieAcceptButton;

    // .homepage > arama kutusu
    @FindBy(xpath = "//input[@class='form-control form-control-text']")
    public WebElement searchBox;

    // .home page > sign in butonu
    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signInButton;

    // homepage > sign in butonu > user giris sayfasi >> username kutusu
    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernameBox;

    // .user giris sayfasi > password kutusu
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordBox;

    // .user giris sayfasi > signin butonu
    @FindBy(xpath = "//button[@class='btn btn-green w-100']")
    public WebElement loginSigninButton;

    // user sayfasi > sag ustteki user ismi yazisi
    @FindBy(xpath = "//a[@id='dropdownMenuLink']")
    public WebElement nameButton;

    // .isme tiklayinca acilan dropdown menu > My orders seçenegi
    @FindBy(xpath = "//a[text()=' My orders ']")
    public WebElement myOrdersSection;

    // .My orders sayfasi > sipariş miktari yazisi
    @FindBy(xpath = "//div[@class='col-lg-3 d-none d-lg-block']")
    public WebElement orderQuantity;

    // .My orders sayfasi > total amount yazisi
    @FindBy(xpath = "(//div[@class='col-lg-2 d-none d-lg-block'])[2]")
    public WebElement totalAmount;

    // .My orders sayfasi > sepet resmi
    @FindBy(xpath = "(//div[@class='col-lg-2 d-none d-lg-block'])[1]")
    public WebElement bagImage;

    // .My orders sayfasi > sipariş arama kutusu
    @FindBy(xpath = "//input[@placeholder='Search order']")
    public WebElement searchOrderBox;

    // .My orders sayfasi > siparis listesi
    @FindBy(xpath = "//div[@class='kmrs-row row m-0 rounded p-2 mb-2']")
    public List<WebElement> orderList;

    // .My orders sayfasi > end of result yazisi
    @FindBy(xpath = "//p[text()='end of results']")
    public WebElement endOfResult;

    // .goruntulenen siparisin numarası
    @FindBy(xpath = "//h6[text()='Order #10253 ']")
    public WebElement visibleOrderNo;

    //anasayfa en ustundeki logo elementi login olmadan
    @FindBy(xpath = "(//img[@class='img-200'])[1]")
    public WebElement ilkLogoElementi;

    // login olmadan anasayfa en alttaki contact us linki
    @FindBy(xpath = "//a[text()='Contact us']")
    public WebElement contactusLinkElementi;

    //userHp>contact/phoneNumber
    @FindBy(xpath = "(//p//font/b)[1]")
    public WebElement contactPhoneNumberElementi;

    //userHp>contact/gmail
    @FindBy(xpath = "(//p//font/b)[2]")
    public WebElement contactGmailElementi;

    //userHp>contact/fullname isim kutusu
    @FindBy(id = "AR_contact_fullname")
    public WebElement contactPageFulnameBox;

    //userHp>contact/mail kutusu
    @FindBy(xpath = "//label[@for='AR_contact_email_address']")
    public WebElement contactPageEmailBox;

    //userHp>contact/mesaj yazılan yer
    @FindBy(id="AR_contact_message")
    public WebElement userMessageBox;

    //userHp>contact/submit butonu
    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement contactPageSubmitButton;


    // https://qa.mealscenter.com/ >> Adres girme butonu (Enter delivery address)
    // (Login olduktan sonra)
    @FindBy(xpath = "//input[@placeholder='Enter delivery address']")
    public WebElement adresButton;

    // https://qa.mealscenter.com/ >> Adres girme butonu >> girilen adres 10001
    // (Login olduktan sonra)
    @FindBy(xpath = "//h6[text()='10001']")
    public WebElement adres10001;

    // https://qa.mealscenter.com/restaurants >> Cuisines bolumundeki "Show more+" Butonu (Solda ortada)
    // (Login olduktan sonra)
    @FindBy(xpath = "//a[@aria-controls='collapseExample']")
    public  WebElement cuisinesShowMoreButton;

    // https://qa.mealscenter.com/restaurants >> Filter bolumunde
    // (!)filtreleme yaptıktan sonra cıkan(!) "Clear all" Butonu (Solda ustte)
    // (Login olduktan sonra)
    @FindBy(xpath = "(//a[@href='javascript:;'])[27]")
    public WebElement filterClearAllButton;

    // https://qa.mealscenter.com/restaurants >> Cuisines bolumundeki Japanese checkBox Butonu (Solda ortada)
    // (Login olduktan sonra)
    @FindBy(xpath = "(//div[@class='custom-control custom-checkbox'])[19]")
    public WebElement japaneseCheckBox;

    // https://qa.mealscenter.com/restaurants >> Ilk restaurantın ait olduğu cuisine bilgisi
    // (Login olduktan sonra)
    @FindBy(xpath = "(//span[@class='a-12 mr-1'])[1]")
    public WebElement ilkRestaurantCuisineBilgisi;

    // https://qa.mealscenter.com/restaurants >> Umi Sake House Restaurant
    // (Login olduktan sonra)
    @FindBy(xpath = "//h5[text()='Umi Sake House']")
    public WebElement umiSakeHouseRestaurantButton;

    //userHp>contact/submit yaptıktıksonra cıkan yazı basarılı olan
    @FindBy(xpath = "//*[@class='alert alert-success']")
    public WebElement successfulMessageElementi;


    //https://qa.mealscenter.com/ >> Cart'a bastiktan sonraki 'Your cart from' yazısı
    @FindBy(xpath = "//p[@class='m-0 bold']")
    public WebElement sepetDogrulamaYazisi;

    //https://qa.mealscenter.com/ >> Cart'a bastiktan sonraki (x)kapatma butonu
    @FindBy(xpath = "(//button[@aria-label='close drawer'])[2]")
    public WebElement sepetCloseButonu;

    //https://qa.mealscenter.com/ >> Cart'a bastiktan sonra carpının altındaki clear butonu
    @FindBy(xpath = "(//a[@href='javascript:;'])[12]")
    public WebElement sepetClearButonu;

    //https://qa.mealscenter.com/ >> Cart'a bastiktan sonra clear'in altındaki urun silme(x) butonu
    @FindBy(xpath = "//i[@class='zmdi zmdi-close']")
    public WebElement sepetUrunSilmeButonu;

    //https://qa.mealscenter.com/ >> Cart'a bastiktan sonra urun artırma(+) butonu
    @FindBy(xpath = "//a[@data-id='plus']")
    public WebElement sepettekiUrunuArttirmaButonu;

    //https://qa.mealscenter.com/ >> Cart'a bastiktan sonra urun azaltma(-) butonu
    @FindBy(xpath = "//a[@data-id='less']")
    public WebElement sepettekiUrunuAzaltmaButonu;

    //https://qa.mealscenter.com/ >> Cart'a bastiktan sonra yazan urun miktari
    @FindBy(xpath = "//div[@class='qty']")
    public WebElement sepettekiUrunMiktari;

    //https://qa.mealscenter.com/ >> Cart (!)(Anasayfadan Cart'a bastiktan sonra gozuken checkout butonu)
    @FindBy(xpath = "//div[text()='Go to checkout']")
    public WebElement sepetCheckoutButonu;



    // My orders sayfasında siparişlerin sağındaki yatay üç nokta
    @FindBy(xpath = "(//i[@class='zmdi zmdi-more'])[2]")
    public WebElement ucNokta;


    // My orders sayfasında new ibareli siparişin sağındaki yatay üç nokta
    @FindBy(xpath = "(//i[@class='zmdi zmdi-more'])[7]")
    public WebElement ucNoktaNew;

    // My orders sayfasında siparişlerden complete olanın sağındaki yatay üç nokta
    @FindBy(xpath = "(//i[@class='zmdi zmdi-more'])[4]" )
    public WebElement ucNoktaCompleted;

    //  My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > write a review > add review butonu
    @FindBy(xpath = "(//button[@class='btn btn-black w-100'])[2]")
    public WebElement addReviewButton;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > view
    @FindBy(xpath = "(//i[@class='zmdi zmdi-eye mr-2'])[2]")
    public WebElement viewSection;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > view > order detay paneli
    @FindBy(xpath = "//div[@class='order-details-panel section-cart open']")
    public WebElement orderDetail;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm view > order detay paneli > çarpı
    @FindBy(xpath = "//i[@class='zmdi zmdi-close']")
    public WebElement closePanel;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > buy again
    @FindBy(xpath = "(//i[@class='zmdi zmdi-repeat mr-2'])[2]")
    public WebElement buyAgainSection;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > buy again > go to checkout
    @FindBy(xpath = "//div[text()='Go to checkout']")
    public WebElement goToCheckout;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > track
    @FindBy(xpath = "(//i[@class='zmdi zmdi-car mr-2'])[2]")
    public WebElement trackSection;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > track > sipariş serüveni kartı
    @FindBy(xpath = "//ul[@id='progressbar']")
    public WebElement orderTrack;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > download
    @FindBy(xpath = "(//i[@class='zmdi zmdi-collection-pdf mr-2'])[2]")
    public WebElement downloadSection;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > cancel order
    @FindBy(xpath = "(//i[@class='zmdi zmdi-close mr-2'])[7]") //3 nokta new'in indexi ile aynı
    public WebElement cancelSection;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > cancel order > cancel order butonu
    @FindBy(xpath = "//button[@class='btn btn-green w-100']")
    public WebElement cancelOrderButton;

    //  // My orders sayfasında sipariş numarasının yanındaki ibare
    @FindBy(xpath = "(//span[text()='cancelled'])[7]")
    public WebElement cancelled;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > write a review
    @FindBy(xpath = "(//i[@class='zmdi zmdi-star-outline mr-2'])[4]")
    public WebElement writeReviewSection;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > write a review > yorum yazılan alan
    @FindBy(xpath = "//*[@id='review_content']")
    public WebElement reviewArea;

    // My orders sayfasında siparişlerin sağındaki yatay üç nokta > ddm > write a review > çarpı
    @FindBy(xpath = "//i[@class='zmdi zmdi-close font20']")
    public WebElement reviewClose;

    // user login > Sağ üstteki kullanıcı adı > Payments option
    @FindBy(xpath = " //a[text()=' Payments Options ']")
    public WebElement paymentSection;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button
    @FindBy(xpath = "//a[text()='Add new payment']")
    public WebElement addPaymentButton;

    // user login > Sağ üstteki kullanıcı adı > Payments option > sayfadaki text ve image
    @FindBy(xpath = "//div[@class='rounded p-3 grey-bg']")
    public WebElement cardAndText;

    // user login > Sağ üstteki kullanıcı adı > Payments option > kayıtlı ödeme yöntemleri
    @FindBy(xpath = "//div[@class='card p-3 fixed-height card-listing']")
    public List<WebElement> paymentMethods;

    // user login > Sağ üstteki kullanıcı adı > Payments option > delete butonu
    @FindBy(xpath = "//a[text()='Delete']")
    public WebElement deletePaymentButton;

    // user login > Sağ üstteki kullanıcı adı > Payments option > edit butonu
    @FindBy(xpath = "(//i[@class='zmdi zmdi-edit'])[2]")
    public WebElement editPaymentButton;
    // //i[@class='zmdi zmdi-edit']

    //  user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > cash on delivery
    @FindBy(xpath = "//i[@class='zmdi zmdi-money-box']")
    public WebElement cash;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > cash on delivery > add cash
    @FindBy(xpath = "//span[text()='Add Cash']")
    public WebElement addCashButton;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > cash on delivery > çarpı
    @FindBy(xpath = "(//i[@class='zmdi zmdi-close font20'])[1]")
    public WebElement closeAddCash;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > stripe yazısı
    @FindBy(xpath = "(//span[@class='mr-1'])[2]")
    public WebElement stripe;

    //user login > Sağ üstteki kullanıcı adı > Payments option > nakit ödeme yöntemi
    @FindBy(xpath = "(//h5[@class='ml-2'])[2]")
    public WebElement cashAdded;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > stripe yazısı > add stripe
    @FindBy(xpath = "//span[text()='Add Stripe']")
    public WebElement addStripeButton;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > stripe yazısı > iframe
    @FindBy(xpath = "//div//iframe")
    public WebElement iframe;
    //iframe[@frameborder='0']
    //div[@id='root']
    //iframe[@name='__privateStripeFrame89128']

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > stripe yazısı > add stripe > kart no giriş box
    @FindBy(xpath = "(//input[@class='InputElement is-empty Input Input--empty'])[1]")
    public WebElement cardNoBox;

    // kart kullanıcısı adı
    @FindBy(xpath = "//label[text()='Cardholder name']")
    public WebElement cardHolder;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > stripe yazısı > add stripe > kart SKT giriş box
    @FindBy(xpath = "//input[@name='exp-date']")
    public WebElement dateBox;
    //input[@class='InputElement is-empty Input Input--empty']

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > stripe yazısı > add stripe > kart CVC giriş box
    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement cvcBox;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > stripe yazısı > add stripe > zip kodu giriş box
    @FindBy(xpath = "//input[@name='postal']")
    public WebElement zipCodeBox;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment button > stripe yazısı > çarpı
    @FindBy(xpath = "(//i[@class='zmdi zmdi-close font20'])[2]")
    public WebElement closeAddStripe;

    // user login > Sağ üstteki kullanıcı adı > Payments option > Stripe ödeme yöntemi
    @FindBy(xpath = "(//h5[@class='ml-2'])[1]")
    public WebElement addedStripe;

    // user login > Sağ üstteki kullanıcı adı > Payments option > add new payment > close payment
    @FindBy(xpath = "//a[text()='Close Payment']")
    public WebElement closePaymentButton;



    //account/login user
    // girişi başarısız olduğunda çıkan uyarı yazısı:
    //"Unable to login. Check your login information and try again."
    @FindBy (xpath = "//div[@class='alert alert-warning']")
    public WebElement loginOlunamadiUyarisi;


    //login sonrasi homepage sol üstteki simge
    @FindBy (xpath = "//img[@class='img-30 rounded-pill lozad loaded']")
    public WebElement loginOlunduSimgesi;

    //userUrl>login/isim yazan DropdownMenu
    @FindBy(xpath = "//a[@id='dropdownMenuLink']")
    public WebElement nameDropDownMenu;
    //userUrl>login>isimDropDownMunu/saveAdStore
    @FindBy(xpath = "//a[@class='dropdown-item with-icon-savedstore']")
    public WebElement saveAdStoreLink;
    //userUrl>favourites/ordernow uzerindeki Saved Stores yazisi
    @FindBy(xpath = "(//h5[text()='Saved Stores'])[1]")
    public WebElement userFavouritesSavedStores;
    //userUrl>restaurant/restoranisimlerini iceren liste
    @FindBy(xpath = "//h5[@class='m-0 text-truncate']")
    public List<WebElement> restaurantsNameList;
    //adminUrl>accaunt>favaurities
    @FindBy(xpath = "//h5[text()=\"You don't have any save stores here!\"]")
    public WebElement dontHaveAnyStores;
    //saved store sayfasindaki orderButton
    @FindBy(xpath = "(//a[@class='btn btn-green'])[1]")
    public WebElement orderNowButton;
    @FindBy(xpath = "(//h4[@class='m-0'])[1]")
        public WebElement numberOfRestaurants;
    //userUrl>restaurants like buttonlariListesi
    @FindBy(xpath = "//i[@class='zmdi zmdi-favorite-outline']")
    public List<WebElement> likeButtonList;
    @FindBy(xpath = "//a/h5")
    public WebElement favoritesRestourantName;


    // homepage > cart linkini tiklayinca cikan "cart" yazisi
    @FindBy (xpath = "//*[@class='mt-3 mb-0']")
    public WebElement cartScript;

    // homepage > cart linki
    @FindBy (xpath = "(//li[@class='d-none d-lg-inline'])[2]")
    public WebElement cartLinki;

    // homepage > cart resmi
    @FindBy (xpath = "//span[@class='badge small badge-dark rounded-pill']")
    public WebElement cartImage;

    // homepage > sol alt mealscenter butonu
    @FindBy (xpath = "(//img[@class='img-200'])[2]")
    public WebElement solAltMealscenterButonu;

    // homepage > facebook butonu
    @FindBy (xpath = "/html/body/div[5]/div/div[1]/div[2]/div/div[1]")
    public WebElement facebookButton;

    // homepage > aramakutusu > sendkeys yapinca cikan ilk javascript elementi
    @FindBy (xpath = "//*[@id=\"vue-home-search\"]/div[3]/ul/li[1]")
    public WebElement searchBoxIlkElement;

    // homepage > restaurants > safya alt adres satiri
    @FindBy (xpath = "(//h1[@class='mb-4'])[1]")
    public WebElement restaurantsAdresSatiri;
    @FindBy(xpath = "//a[@id='dropdownMenuLink']")
    public WebElement usernamePopupMenu;


    // homepage > instagram button
    @FindBy (xpath = "//a[@class='instagram']")
    public WebElement instagramButton;


    //hamza

    // homepage > sign in > href sign in
    @FindBy (xpath = "//a[@class='btn btn-white p-0 font14']")
    public WebElement signIn_in_signIn;

    // homepage > sign in > href sign in > firstname textbox
    @FindBy (xpath = "//*[@id='firstname']")
    public WebElement signIn_in_signIn_firstname;

    // homepage > kayıt ve girişten sonraki profil icon
    @FindBy (xpath = "//*[@id=\"vue-cart-preview\"]/li[2]/div/button/img")
    public WebElement profiliconimg;

    // homepage > Terms and conditions
    @FindBy (xpath = "//*[text()='Terms and conditions']")
    public WebElement Termsandconditions;

    // homepage > Terms and conditions > order and payment acıklaması
    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[1]/div[2]/p[3]")
    public WebElement Termsandconditionsaciklama1;

    // homepage > Terms and conditions > order and payment acıklaması
    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div[1]/div[2]/p[4]")
    public WebElement Termsandconditionsaciklama2;

    // homepage > DropDown'dan  Manage my account kısmı
    @FindBy (xpath = "//a[@class='dropdown-item with-icon-account']")
    public WebElement dropDownManageMyAccount;

    // homepage > DropDown'dan  Manage my account > Tel number textbox
    @FindBy (xpath = "/html/body/div[2]/div/div[4]/div/div/div[2]/div/div/form/div[2]/div[2]/div[1]/input")
    public WebElement dropDownManageMyAccountTelNumberTextbox;

    // homepage > DropDown'dan  Manage my account > Address
    @FindBy (xpath = "/html/body/nav/ul/li[3]/a")
    public WebElement dropDownManageMyAccountAddress;

    // homepage > DropDown'dan  Manage my account > Address > Address Ekleme Butonu
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[1]/div/div/div[4]/a")
    public WebElement dropDownManageMyAccountAddButtonAddress;

    // homepage > DropDown'dan  Manage my account > Address > Address Ekleme Butonu > Address Kodu textbox
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[3]/div/div/div[1]/div[1]/input")
    public WebElement dropDownManageMyAccountAddButtonAddress_AddressNumber_TextBox;

    // homepage > DropDown'dan  Manage my account > Address > Address Ekleme Butonu > Address Kodu textbox > 10010
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[3]/div/div/div[1]/div[2]/ul/li[1]/a/p")
    public WebElement dropDownManageMyAccountAddButtonAddress_AddressNumber_TextBox_VeriEkleme;

    // homepage > DropDown'dan  Manage my account > Address > Address Ekleme Butonu > Address Kodu textbox > 10010 > Save Button
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[4]/div/div/div[2]/div[2]/button")
    public WebElement dropDownManageMyAccountAddButtonAddress_AddressNumber_TextBox_VeriEkleme_SaveButton;

    // homepage > DropDown'dan  Manage my account > Address > Edit
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[5]/div/div/div[2]/div[1]/a")
    public WebElement dropDownManageMyAccountAddButtonAddress_Edit;

    // homepage > DropDown'dan  Manage my account > Address > Edit > Work Button
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[4]/div/div/div[1]/div[3]/div[3]/label[2]")
    public WebElement dropDownManageMyAccountAddButtonAddress_Edit_WorkButton;

    // homepage > DropDown'dan  Manage my account > Address > Edit > Work Button > Accept Buttonu
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[4]/div/div/div[2]/div[2]/button")
    public WebElement dropDownManageMyAccountAddButtonAddress_Edit_WorkButton_AcceptButton;

    // homepage > DropDown'dan  Manage my account > Address > Delete
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[5]/div/div/div[2]/div[2]/a")
    public WebElement dropDownManageMyAccountAddButtonAddress_Delete;

    // homepage > DropDown'dan  Manage my account > Address > Delete >Accept
    @FindBy (xpath = "/html/body/div[8]/div/div/div[3]/button[2]")
    public WebElement dropDownManageMyAccountAddButtonAddress_Delete_Accept;

    // homepage > Become Your Partner
    @FindBy (xpath = "//*[text()='Become a Partner']")
    public WebElement becomeyourpartner;

    // homepage > Become Your Partner > Login here
    @FindBy (xpath = "/html/body/div[2]/div[1]/div/div/div[1]/form/div[6]/a")
    public WebElement becomeyourpartner_login;

    // homepage > Become Your Partner > Login here > Forgot password
    @FindBy (xpath = "//a [@class='dim underline']")
    public WebElement becomeyourpartner_login_forgotpassword;

    // homepage > Become Your Partner > Login here > Forgot password > Sayfa Başlığı Forgot Password
    @FindBy (xpath = "//h6 [@class='mb-4']")
    public WebElement becomeyourpartner_login_forgotpassword_header;

    // homepage > Become Your Partner > Login here > Forgot password > Sayfa Açıklaması Forgot Password
    @FindBy (xpath = "//p [@class='dim']")
    public WebElement becomeyourpartner_login_forgotpassword_info;

    // homepage > DropDown'dan  Manage my account > Profil Yazısı
    @FindBy (xpath = "//*[@id=\"main-container\"]/div/div[1]/div/h6")
    public WebElement managerprofiltext;


    // homepage > restaurants > safya alt adres satiri
    @FindBy (xpath = "//i[@class='zmdi zmdi-eye']")
    public WebElement passworgGosterButton;

    // homepage > popularnearby
    @FindBy (xpath = "(//h5[@class='m-0 section-title'])[1]")
    public WebElement popularNearBy;

    // homepage > New Restaurant
    @FindBy (xpath = "(//h5[@class='m-0 section-title'])[2]")
    public WebElement newRestaurant;

    // homepage > join butonu
    @FindBy (xpath = "//div[@class='btn-white-parent non-trasparent']")
    public WebElement joinButton;

    // homepage > mobileapp image
    @FindBy (xpath = "(//img[@class='mobileapp'])[1]")
    public WebElement mobileAppImage;

    // homepage > first read button
    @FindBy (xpath = "(//a[@class='btn btn-link readButton'])[1]")
    public WebElement firstReadButton;

    // homepage > end of the page > mealscenter.com
    @FindBy (partialLinkText = "mealscenter.com")
    public WebElement mealscentercom;
}
