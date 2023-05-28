package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class User_RestaurantUmiSakeHouse {

    public User_RestaurantUmiSakeHouse() {
        PageFactory.initElements(Driver.getDriver(),this);}

    // mealscenter.com/umisakehouse >> Restauranttaki ilk urunun "Add to cart" butonu
    // (Login olduktan sonra)
    @FindBy(xpath = "(//a[@class='btn btn-grey quantity-add-cart'])[1]")
    public WebElement ilkUrunAddToCartButton;

    // mealscenter.com/umisakehouse >> Checkout Butonu (Sagda ortada)
    // (Login olduktan sonra)
    @FindBy(xpath = "//a[@href='/account/checkout']")
    public WebElement checkoutButton;

    // mealscenter.com/restaurants >> Cart yazısı Butonu (Sag ust kosedeki 'Cart' yazan buton)
    // (Login olduktan sonra)
    @FindBy(xpath = "//li[@class='d-none d-lg-inline line-left']")
    public WebElement cartButonu;

    // mealscenter.com/restaurants >> Sepet Resmi Butonu (Sag ust kosedeki sepet resmi olan buton)
    // (Login olduktan sonra)
    @FindBy(xpath = "//li[@class='d-inline mr-3 mr-lg-0']")
    public WebElement cartLogoButonu;

    @FindBy(xpath = "(//section//div/h6)[1]")
    public WebElement ilkUrunIsimElementi;

    //***************/duygu/****************/
    //userUrl>umiSakihause like butonu
    @FindBy(xpath = "(//i[@class='zmdi zmdi-favorite-outline'])[1]")
    public WebElement umiSakiHouseLikeButton;
    //UmisakiHause sayfasindaki begen yaptıktan sonra
    @FindBy(xpath = "//p[text()='Saved']")
    public WebElement savedText;


}

