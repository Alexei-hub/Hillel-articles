import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public interface Browser {

    RemoteWebDriver browserInit() throws MalformedURLException;
}
