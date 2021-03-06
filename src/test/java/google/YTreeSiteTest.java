package google;

import org.testng.annotations.Test;
import selenoid.example.BaseTest;
import selenoid.example.pages.GoogleSearchPage;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class YTreeSiteTest extends BaseTest {

    @Test
    public void siteTest() {
        System.out.println("Current thread - " + Thread.currentThread().getId());

        open("http://www.google.com/");
        GoogleSearchPage searchPage = new GoogleSearchPage().search("ytree limited");

        assertTrue(searchPage.results().size() > 0);

        System.out.println("Open Y_TREE site");
        $x("//*[text() = 'Y TREE']").click();
        System.out.println("Go to Meet us tab");
        $x("//*[text() = 'Meet us']").click();
        System.out.println("Enter first name");
        $("#meetingWrap input[name='first_name']").setValue("Elon");
        System.out.println("Enter last name");
        $("#meetingWrap input[name='last_name']").setValue("Musk");
        System.out.println("Enter email name");
        $("#meetingWrap input[name='email']").setValue("em@mail.com");
        System.out.println("Enter second email name");
        $("#meetingWrap input[name='pa_email']").setValue("em_1@mail.com");

    }
}
