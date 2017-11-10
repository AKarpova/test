package todoist;

import com.codeborne.selenide.Configuration;
import engine.driver.WebDriverSingleton;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;

import java.io.File;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

/**
 * Created by гро on 29.10.17.
 */
public class BaseTest {
    @Before
    public void settings() {
        File propertiesFile = new File(".//src//log4j.properties");
        PropertyConfigurator.configure(propertiesFile.toString());

        com.codeborne.selenide.Configuration.browser = "ie";
        com.codeborne.selenide.Configuration.reportsFolder = "target/surefire-reports/screens";
        com.codeborne.selenide.Configuration.reopenBrowserOnFail = false;
        Configuration.holdBrowserOpen = false;
        Configuration.closeBrowserTimeoutMs = 1000;
        Configuration.fastSetValue = true;
        Configuration.startMaximized = true;

        Configuration.baseUrl = "https://ru.todoist.com/";

        setWebDriver(WebDriverSingleton.getWebDriverInstance());
    }
    @After
    public void closeDriver() {
        WebDriverSingleton.closeWebBrowser();
    }
}
