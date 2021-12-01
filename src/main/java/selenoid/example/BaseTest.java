package selenoid.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.EventsCollector;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    void setUp() {
        SelenideLogger.addListener("simpleReport", new EventsCollector());
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
