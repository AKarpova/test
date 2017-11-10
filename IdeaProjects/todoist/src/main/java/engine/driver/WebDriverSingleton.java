package engine.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by гро on 29.10.17.
 */
public class WebDriverSingleton {

    private static WebDriver driver;

    private static void createDriver(){
        File file = new File("\\home\\akarpova\\IdeaProjects\\todoist\\src\\webdrivers\\IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        driver = new InternetExplorerDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriverInstance() {
        if (null==driver){
            createDriver();
        }
        return driver;
    }
    public static void closeWebBrowser(){
        if(null != driver){
            driver.quit();
        }
        driver = null;
    }
}
