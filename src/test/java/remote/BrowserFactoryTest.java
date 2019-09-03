package remote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class BrowserFactoryTest {

    static RemoteWebDriver driver;
    //    static WebDriver driver;
    static WebDriverWait wait;

    public static final String USERNAME = "jacksonford2";
    public static final String AUTOMATE_KEY = "pwdSfmsYuFschtYNzF2y";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void start() throws MalformedURLException {


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "69.0 beta");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("resolution", "1280x1024");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        //TODO Change to remote WD
//
//        WebDriverManager.chromedriver().setup();
//        driver = new EventFiringWebDriver(new ChromeDriver());
//        ((EventFiringWebDriver) driver).register(new WebDriverLogger());
        wait = new WebDriverWait(driver, 10);
//
//    driver = new RemoteWebDriver(
//            URI.create("http://192.168.56.102:4444/wd/hub").toURL(),
//    capabilities
//        );

        driver.manage().window().maximize();
        driver.get("http://demo.litecart.net/");

        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".product-column"));
        if (listOfProducts.size() > 0) {
            listOfProducts.get(0).click();
        } else {
            System.out.println("No products");
        }

        Select drbSize = new Select(driver.findElement(By.name("options[Size]")));
        drbSize.selectByValue("Large");
        driver.findElement(By.cssSelector("button.btn-success")).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div.badge.quantity"), "innerText", "1"));
        driver.findElement(By.id("cart")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("remove_cart_item")));
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p > em")));
        Assert.assertEquals("There are no items in your cart.", driver.findElement(By.cssSelector("p > em")).getText());
        driver.quit();


    }
}
