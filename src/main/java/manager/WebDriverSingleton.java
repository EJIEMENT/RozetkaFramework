package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        return createChromeDriver();
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito","--disable-popup-blocking");
        webDriverThreadLocal.set(new ChromeDriver(options));
        webDriverThreadLocal.get().manage().window().maximize();
        webDriverThreadLocal.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return webDriverThreadLocal.get();
    }

    public static void dropDriver() {
        try {
            webDriverThreadLocal.get().quit();
        } finally {
            webDriverThreadLocal.remove();
        }
    }
}
