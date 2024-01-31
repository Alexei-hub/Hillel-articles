import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class SelenoidExample {

    @Test
    public void executeOnSelenoid() throws MalformedURLException, InterruptedException {
//        // Запускаємо тест на локальній машині
//        WebDriver localDriver = new ChromeDriver();
//        localDriver.get("https://example.com");
//        System.out.println("Executing on local Chrome browser");
//        localDriver.quit();

        //Запускаємо тест на віддаленому вузлі у Selenoid використовуючи Chrome
        RemoteWebDriver remoteChromeDriver = BrowserFactory.initSelenoidDriver("chrome");
        remoteChromeDriver.get("https://example.com");
        System.out.println("Executing on remote Chrome browser");
        sleep(10000);
        remoteChromeDriver.quit();

        //Запускаємо тест на віддаленому вузлі у Selenoid використовуючи Firefox
        RemoteWebDriver remoteFirefoxDriver = BrowserFactory.initSelenoidDriver("firefox");
        remoteFirefoxDriver.get("https://example.com");
        System.out.println("Executing on remote FireFox browser");
        sleep(10000);
        remoteFirefoxDriver.quit();
    }
}
