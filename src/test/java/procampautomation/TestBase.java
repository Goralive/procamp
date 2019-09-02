package procampautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;
    public Logger log = LoggerFactory.getLogger(this.getClass());

    public Set<Cookie> cookieSet;
    boolean checkText;


    @Before
    public void setTlDriver() {
        WebDriverManager.chromedriver().setup();
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");

        driver = new ChromeDriver(opt);
        wait = new WebDriverWait(driver, 10);
        tlDriver.set(driver);
        log.info("Browser Start");
        driver.manage().window().maximize();
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                    log.info("Browser Closed");
                }));
    }

    public void get(String url) {
        driver.navigate().to(url);
        log.info("Open Url " + url);
    }

    public WebElement findElement(String selector) {
        return driver.findElement(By.cssSelector(selector));
    }

    public boolean isElementPresent(String locator) {
        try {
            log.info("Is element present " + locator);
            driver.findElement(By.cssSelector(locator));
            return true;
        } catch (NoSuchElementException ex) {
            log.info("Can't find element " + locator);
            return false;
        }
    }

    public boolean waitUntilElementIsPresent(String locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
            log.info("Wait for element located " + locator);
            return true;
        } catch (TimeoutException e) {
            log.info("--- After 10 sec no element is present --- " + locator);
            return false;
        }
    }

    public boolean areElementsPresent(String locator) {
        log.info("Check elements  " + locator + " size is: " + driver.findElements(By.cssSelector(locator)).size());
        return driver.findElements(By.cssSelector(locator)).size() > 0;
    }

    public void addCookie() {
        for (Cookie cookie : cookieSet) {
            driver.manage().addCookie(cookie);
            log.info("Add cookie: " + cookie);
        }
    }

    public void getCookie() {
        cookieSet = driver.manage().getCookies();
    }


}


