import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class TestApp1 {

    private static String ipForProxy = "45.22.209.157:8888";

    public static void main(String[] args) throws InterruptedException {
        Proxy proxy = new Proxy();
        // Налаштування адреси та порту проксі-сервера
        proxy.setHttpProxy(ipForProxy);
        proxy.setSslProxy(ipForProxy);
        System.out.println(proxy.getSslProxy());

        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", proxy);

        WebDriver driver = new ChromeDriver(options);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        sleep(10000);
        driver.get("https://2ip.ua/ru/");
        driver.manage().deleteAllCookies();
//        sleep(5000);
        WebElement ip = driver.findElement(By.className("ip"));
        String ipText = ip.getText();
        System.out.println(ipText);
        driver.quit();
    }

}
