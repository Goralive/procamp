package procampautomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static procampautomation.PropertiesCache.getProperty;


public class SidePanelTest extends TestBase {


    String cookieName = getProperty("firstCookieName");
    String cookieValue = getProperty("firstCookieValue");
    String secondCookieName = getProperty("secondCookieName");
    String secondCookieValue = getProperty("secondCookieValue");

    @Before
    public void redirectToPage() {
        get("http://demo.litecart.net/admin/");
        addCookie(cookieName, cookieValue);
        addCookie(secondCookieName, secondCookieValue);
    }

    @Test
    public void appearanceTest() {
        isElementPresent(By.cssSelector("#app-appearance"));
    }

}
