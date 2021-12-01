package selenoid.example.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchPage {

    public GoogleSearchPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(GoogleSearchPage.class);
    }

    public ElementsCollection results() {
        return $$("#ires li.g");
    }

}
