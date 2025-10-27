package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;

    public static WebDriver driver(String url, String browser) {

        if (browser == null) {
            driver = new ChromeDriver();
        } else {
            switch (browser) {
                case "chrome": driver = new ChromeDriver();break;
                case "firefox": driver = new FirefoxDriver();break;
                case "safari": driver = new SafariDriver();break;
            }
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void threadWait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
