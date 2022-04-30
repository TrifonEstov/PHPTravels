package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;

    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/home/trifon/Desktop/QaiWare/PHPTravels/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    public static void closeBrowser() {
        driver.quit();
    }

}
