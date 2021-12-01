package google;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DockerTest {
    @Test
    public void serchMoon() {
        System.out.println("Current thread - " + Thread.currentThread().getId());

        open("https://google.com/ncr");
        sleep(10000);
        $(By.name("q")).val("aerokube moon").pressEnter();
        sleep(10000);
        $$("#res .g").shouldHave(sizeGreaterThan(5));
        $("#res .g").shouldHave(text("selenide.org"));
    }
}
