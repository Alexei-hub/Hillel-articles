import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxSetup implements Browser {
    @Override
    public RemoteWebDriver browserInit() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("browserVersion", "120.0");
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
    }
}
