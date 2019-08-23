package procampautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;
    public Logger log = LoggerFactory.getLogger(this.getClass().getName());


    @Before
    public void setTlDriver() {
        WebDriverManager.chromedriver().setup();
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }

        driver = new ChromeDriver();
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

    public boolean isElementPresent (By locator) {
        try {
            log.info("Is element present " + locator);
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            log.info("Can't find element " + locator);
            return false;
        }
    }

    public boolean waitUntilElementIsPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            log.info("Wait for element located " + locator);
            return true;
        } catch (TimeoutException e) {
            log.info("After 10 sec no element is present " + locator);
            return false;
        }
    }

    public boolean waitUntilElementIsPresent(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            log.info("Wait for element web element " + webElement);
            return true;
        } catch (TimeoutException e) {
            log.info("After 10 sec no web element is present " + webElement);
            return false;
        }
    }

   public boolean areElementsPresent (By locator) {
        log.info("Check elements  " + locator + " size is: " + driver.findElements(locator).size());
        return driver.findElements(locator).size() > 0;
   }

   public void addCookie (String name, String value){
        log.info("Adding cookie name: " + name + " and value: " + value);
        driver.manage().addCookie(new Cookie(name,value));
   }
}

