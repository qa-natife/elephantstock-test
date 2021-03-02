package com.mycompany.app;

import com.codeborne.selenide.Selenide;
import org.junit.Test;

import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class cartWishList {
    @Test
    public void firstAddItemtoCartWishListBeforeReg() {
        open("https://www.elephantstock.com/collections/best-sellers-wall-art");

        sleep(5000);
        $(".ft-popup--big").shouldHave(attribute("aria-hidden","false"));
        $x("//*[@id=\"shopify-section-static_welcome-popup\"]/div/div[1]").click();

        $(".wishlist__button").click();
        $(".wishlist-count-hidden").isDisplayed();

        int minP = 1;
        int maxP = 15;
        int diffP = maxP - minP;
        Random randomP = new Random();
        int randomProduct = randomP.nextInt(diffP + 1) + minP;
        $$(".alg__result-item").get(randomProduct).click();

        $(".product__wishlist-button").click();
        $(".product__wishlist-button").shouldHave(attribute("data-active", "1"));
        sleep(5000);

        $(".sh__icon--account").click();
        $("h1").shouldHave(text("Login"));
        $("#customer_register_link").click();
        $("#FirstName").setValue("First name");
        $("#LastName").setValue("Second name");

        $("#Email").setValue(System.currentTimeMillis() + "test@gmail.com");
        $("#CreatePassword").setValue("123456789");
        $(".btn").click();
        sleep(5000);
        $x("/html/body/header/div[2]/div[5]/a/div/span").shouldHave(text("First name"));
        $("#account_wishlist-li").click();
        $$(".aw__items .aw__item").shouldHave(sizeNotEqual(0));
        sleep(5000);
        Selenide.clearBrowserCookies();
    }
    @Test
    public void secondAddItemtoCartWishListAfterReg() {
        open("https://www.elephantstock.com/collections/best-sellers-wall-art");

        sleep(5000);
        $(".ft-popup--big").shouldHave(attribute("aria-hidden","false"));
        $x("//*[@id=\"shopify-section-static_welcome-popup\"]/div/div[1]").click();

        $(".wishlist__button").click();
        $(".wishlist-count-hidden").isDisplayed();

        int minP = 1;
        int maxP = 15;
        int diffP = maxP - minP;
        Random randomP = new Random();
        int randomProduct = randomP.nextInt(diffP + 1) + minP;
        $$(".alg__result-item").get(randomProduct).click();

        $(".product__wishlist-button").click();
        $(".product__wishlist-button").shouldHave(attribute("data-active", "1"));
        sleep(5000);

        $(".sh__icon--account").click();
        $("h1").shouldHave(text("Login"));
        $("#CustomerEmail").setValue("test9@gmail.com");
        $("#CustomerPassword").setValue("123456789");
        $(".btn").click();
        $x("/html/body/header/div[2]/div[5]/a/div/span").shouldHave(text("First name"));

        $("#account_wishlist-li").click();
        $$(".aw__items .aw__item").shouldHave(sizeNotEqual(0));
        sleep(5000);
        Selenide.clearBrowserCookies();
   }
}
