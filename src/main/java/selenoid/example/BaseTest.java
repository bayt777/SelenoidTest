package selenoid.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeEach
    void setUp() throws MalformedURLException {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(true)
//                .savePageSource(true));
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "89.0");
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        RemoteWebDriver driver = new RemoteWebDriver(
//                URI.create("http://localhost:4444/wd/hub").toURL(),
//                capabilities
//        );

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder = "target/downloads";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("89.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLog", true);
        Configuration.browserCapabilities = capabilities;

    }

}
