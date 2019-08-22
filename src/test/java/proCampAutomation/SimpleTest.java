/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package proCampAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;



public class SimpleTest {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-fullscreen");
        driver = new ChromeDriver(opt);

    }

    @After
    public void dropDown() {
        driver.quit();
    }

    @Test
    public void openGooglePage() {
        driver.get("https://www.google.com");
        assertEquals("google",driver.getTitle().toLowerCase());
    }

}
