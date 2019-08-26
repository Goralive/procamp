package procampautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertTrue;


public class SidePanelTest extends TestBase {

    String loginBtnSelector = "#box-login button";
    // Locator for appearance
    String appearanceLocator = "#app-appearance";
    // Locators for all submenu tests
    String sidebarLocator = "#sidebar";
    String headerLocator = "#main h1";
    String submenu = "[id^=doc]";
    // Locators for Catalog submenu
    String catalogLocator = "#app-catalog";

    @Before
    public void redirectToPage() {
        get("http://demo.litecart.net/admin/");
       try {
           findElement(loginBtnSelector).click();
       } catch (NoSuchElementException e) {
           waitUntilElementIsPresent(sidebarLocator);
           log.info("--- No login page --- sidebar is present --- ");
       }
    }

    @Test
    public void appearanceTest() {
        waitUntilElementIsPresent(appearanceLocator);
        assertTrue("No appearance menu", isElementPresent(appearanceLocator));
        findElement(appearanceLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
    }

    @Test
    public void catalogTest() {
        waitUntilElementIsPresent(catalogLocator);
        assertTrue("No catalog menu", isElementPresent(catalogLocator));
        findElement(catalogLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
    }
}

