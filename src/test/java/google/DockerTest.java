package google;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class DockerTest {

    @Test
    public void serchMoon() {
        System.out.println("Current thread - " + Thread.currentThread().getId());

        open("https://google.com/ncr");
        $(By.name("q")).val("aerokube moon").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(5));
        $$x("//*[@href='https://aerokube.com/moon/']").get(0).click();
        assertTrue(Objects.requireNonNull(title()).contains("Aerokube Moon"));
    }
}
