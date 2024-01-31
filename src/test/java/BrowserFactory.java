import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class BrowserFactory {

    public static RemoteWebDriver initSelenoidDriver(String browser) throws MalformedURLException {
        return getRemoteDriver(browser).browserInit();
    }

    private static Browser getRemoteDriver(String browser) {
        return switch (browser) {
            case "chrome" -> new ChromeSetup();
            case "firefox" -> new FirefoxSetup();
            default -> null;
        };
    }
}
