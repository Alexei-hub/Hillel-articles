import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeSetup implements Browser {

    @Override
    public RemoteWebDriver browserInit() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "latest");
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
    }
}
