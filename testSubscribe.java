package com.mycompany.app;

import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class testSubscribe {
    @Test
    public void subscribe1() {
        open("https://elephantstock.com/");
        sleep(5000);
        $(".ft-pop__title-heading").shouldHave(text("First Time Here?"));
        $(By.name("customer[email]")).setValue("vlawqwqw@gmail.com");
        $x("//*[@id=\"shopify-section-static_welcome-popup\"]/div/div[2]/div[2]/button").click();
//        $(".ft-pop__ab-subscribe-thanks_show p").shouldHave(text("THANK YOU!"));
        $x("//*[@id=\"shopify-section-static_welcome-popup\"]/div/div[2]/div[3]").isDisplayed();
        Selenide.clearBrowserCookies();
    }

    @Test
    public void subscribe2() {
        open("https://elephantstock.com/");//open website

        sleep(5000);//wait for popap

        $(".ft-popup--big").shouldHave(attribute("aria-hidden", "false"));
        $x("//*[@id=\"shopify-section-static_welcome-popup\"]/div/div[1]").click();//close the popap

        executeJavaScript("var scroll = setInterval (function () {window.scrollBy (0,1000);}, 2000);");
        sleep(10000);


        $x("/html/body/div[9]/div/footer/div[1]/div[1]/form/div[2]/input").shouldBe(visible)
                .setValue("vlad.qa.incode@gmail.com");

        $x("/html/body/div[9]/div/footer/div[1]/div[1]/form/div[2]/button").click();
        sleep(10000);
        executeJavaScript("var scroll = setInterval (function () {window.scrollBy (0,-1000);}, 2000);");
//        $(".ft-pop__ab-subscribe-thanks_show p").shouldHave(text("THANK YOU!"));
        $x("//*[@id=\"shopify-section-static_welcome-popup\"]/div/div[2]/div[3]").isDisplayed();
        Selenide.clearBrowserCookies();
    }

    @Test
    public void subscribe3() {
        open("https://elephantstock.com");
        $x("//*[@id=\"SiteNav-left\"]/li[2]").click();
        $x("//*[@id=\"shopify-section-cf-collection-products\"]/div/div[2]/div[7]/form/input").setValue("vlad.qa.incode@gmail.com");
        $x("//*[@id=\"shopify-section-cf-collection-products\"]/div/div[2]/div[7]/form/button").click();
        $x("//*[@id=\"shopify-section-cf-collection-products\"]/div/div[2]/div[7]/p").isDisplayed();
        Selenide.clearBrowserCookies();
    }

}

