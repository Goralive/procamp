package remote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

public class BrowserFactoryTest {

    //static RemoteWebDriver driver;
    static WebDriver driver;

    @BeforeClass
    public static void start() throws MalformedURLException {
//    DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("72.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);
        //TODO Change to remote WD

        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver());
        ((EventFiringWebDriver) driver).register(new WebDriverLogger());
//
//    driver = new RemoteWebDriver(
//            URI.create("http://192.168.56.102:4444/wd/hub").toURL(),
//    capabilities
//        );

        driver.manage().window().maximize();
        driver.get("http://demo.litecart.net/");

    }

    @Test
    public void remoteTest() {
        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".product-column"));
        if (listOfProducts.size() > 0) {
            listOfProducts.get(0).click();
        } else {
            System.out.println("No products");
        }
        
        driver.findElement(By.cssSelector("button.btn-success")).click();

    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }

}
