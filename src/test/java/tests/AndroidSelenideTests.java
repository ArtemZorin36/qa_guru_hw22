package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBase {

    @Test
    void gettingStartedTest() {
        step("Check first screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Free Encyclopedia"));
        });

        step("Set russian language", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/addLangContainer")).click();
            $(AppiumBy.xpath("//*[@text='ADD LANGUAGE']")).click();
            $(AppiumBy.xpath(("//*[@text='Русский']"))).click();
            $(AppiumBy.xpath(("//*[@content-desc='Navigate up']"))).click();
        });

        step("Check russian language", () -> {
            $(AppiumBy.xpath(("//*[contains(@text,'Русский')]"))).shouldHave(text("Русский"));
        });

        step("Go to second screen", () -> {
            $(AppiumBy.xpath(("//*[@text='CONTINUE']"))).click();
        });

        step("Check second screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Customize the feed to your interests"));
        });

        step("Go to third screen", () -> {
            $(AppiumBy.xpath(("//*[@text='CONTINUE']"))).click();
        });

        step("Check third screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Login to your Wikipedia account"));
        });

        step("Go to fourth screen", () -> {
            $(AppiumBy.xpath(("//*[@text='CONTINUE']"))).click();
        });

        step("Check fourth screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Learn more"));

        });
    }

}