import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class GridExample {

    @Test
    public void executeOnGrid() throws MalformedURLException, InterruptedException {
//        // Запускаємо тест на локальній машині
        WebDriver localDriver = new ChromeDriver();
        localDriver.get("https://example.com");
        System.out.println("Executing on local Chrome browser");
        localDriver.quit();

        // Запускаємо тест на віддаленому вузлі у Selenium Grid
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        remoteDriver.get("https://example.com");
        System.out.println("Executing on remote Chrome browser");
        sleep(10000);
        remoteDriver.quit();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver fireFoxDriver = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);
        fireFoxDriver.get("https://example.com");
        System.out.println("Executing on remote FireFox browser");
        sleep(10000);
        fireFoxDriver.quit();
    }
}
