package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    static WebDriver driver;

    @BeforeClass
    static public void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get("http://github.com");
    }

    @AfterClass
    static public void closeBrowser() {
        driver.quit();
    }

}
