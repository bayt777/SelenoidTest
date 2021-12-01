package google;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenoid.example.BaseTest;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest extends BaseTest {

    @Test
    public void userCanSearchAnyKeyword() {
        System.out.println("Current thread - " + Thread.currentThread().getId());

        open("https://google.com/ncr");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(5));
        $("#res .g").shouldHave(text("selenide.org"));
    }
}
