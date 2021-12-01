package google;

import org.testng.annotations.Test;
import selenoid.example.BaseTest;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.FileFilters.withExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.io.FileUtils.readFileToString;

public class DownloadTest extends BaseTest {

    @Test
    void download() throws IOException {
        System.out.println("Current thread - " + Thread.currentThread().getId());
        open("https://the-internet.herokuapp.com/download");
        File file = $(byText("some-file.txt")).download(withExtension("txt"));
        String fileName = file.getName();

        System.out.println(fileName);
        System.out.println(readFileToString(file, UTF_8));
    }
}
