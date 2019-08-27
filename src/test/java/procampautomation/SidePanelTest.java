package procampautomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SidePanelTest extends TestBase {

    String loginBtnSelector = "#box-login button";
    // Locators for all submenu tests
    String sidebarLocator = "#sidebar";
    String headerLocator = "#main h1";
    String submenu = "[id^=doc]";
    // Locators for Sidebar
    private String appearanceLocator = "#app-appearance";
    private String catalogLocator = "#app-catalog";
    private String countriesLocator = "#app-countries";
    private String currencyLocator = "#app-currencies";
    private String customerLocator = "#app-customers";
    private String geozoneLocator = "#app-geo_zones";
    private String languageLocator = "#app-languages";
    private String modulesLocator = "#app-modules";
    private String ordersLocator = "#app-orders";
    private String pagesLocator = "#app-pages";
    private String reportsLocator = "#app-reports";
    private String settingsLocator = "#app-settings";
    private String slidesLocator = "#app-slides";
    private String taxLocator = "#app-tax";
    private String translationLocator = "#app-translations";
    private String usersLocator = "#app-users";
    private String modsLocator = "#app-vqmods";

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
        log.info("-- Appearance test is finished --");
    }

    @Test
    public void catalogTest() {
        waitUntilElementIsPresent(catalogLocator);
        assertTrue("No catalog menu", isElementPresent(catalogLocator));
        findElement(catalogLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Catalog test is finished --");
    }

    @Test
    public void countriesTest() {
        waitUntilElementIsPresent(countriesLocator);
        assertTrue("No countries menu", isElementPresent(countriesLocator));
        findElement(countriesLocator).click();
        assertEquals(findElement(countriesLocator).getText(), findElement(headerLocator).getText());
        log.info("-- Countries test is finished --");
    }


    @Test
    public void currencyTest() {
        waitUntilElementIsPresent(currencyLocator);
        assertTrue("No currency menu", isElementPresent(currencyLocator));
        findElement(currencyLocator).click();
        assertEquals(findElement(currencyLocator).getText(), findElement(headerLocator).getText());
        log.info("-- Currency test is finished --");
    }

    @Test
    public void customerTest() {
        waitUntilElementIsPresent(customerLocator);
        assertTrue("No customer menu", isElementPresent(customerLocator));
        findElement(customerLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Customer test is finished --");
    }

    @Test
    public void geozoneTest() {
        waitUntilElementIsPresent(geozoneLocator);
        assertTrue("No geo zone menu", isElementPresent(geozoneLocator));
        findElement(geozoneLocator).click();
        assertEquals(findElement(geozoneLocator).getText(), findElement(headerLocator).getText());
        log.info("-- Geo zone test is finished --");
    }

    @Test
    public void languagesTest() {
        waitUntilElementIsPresent(languageLocator);
        assertTrue("No language menu", isElementPresent(languageLocator));
        findElement(languageLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Language test is finished --");
    }

    @Test
    public void modulesTest() {
        waitUntilElementIsPresent(modulesLocator);
        assertTrue("No modules menu", isElementPresent(modulesLocator));
        findElement(modulesLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Modules test is finished --");
    }

    @Test
    public void ordersTest() {
        waitUntilElementIsPresent(ordersLocator);
        assertTrue("No orders menu", isElementPresent(ordersLocator));
        findElement(ordersLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Orders test is finished --");
    }

    @Test
    public void pagesTest() {
        waitUntilElementIsPresent(pagesLocator);
        assertTrue("No page menu", isElementPresent(pagesLocator));
        findElement(pagesLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Pages test is finished --");
    }

    @Test
    public void reportsTest() {
        waitUntilElementIsPresent(reportsLocator);
        assertTrue("No reports menu", isElementPresent(reportsLocator));
        findElement(reportsLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Reports test is finished --");
    }

    @Test
    public void settingsTest() {
        waitUntilElementIsPresent(settingsLocator);
        assertTrue("No settings menu", isElementPresent(settingsLocator));
        findElement(settingsLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Settings test is finished --");
    }

    @Test
    public void slidesTest() {
        waitUntilElementIsPresent(slidesLocator);
        assertTrue("No slides menu", isElementPresent(slidesLocator));
        findElement(slidesLocator).click();
        assertEquals(findElement(slidesLocator).getText(), findElement(headerLocator).getText());
        log.info("-- Slides test is finished --");
    }

    @Test
    public void taxRatesTest() {
        waitUntilElementIsPresent(taxLocator);
        assertTrue("No tax menu", isElementPresent(taxLocator));
        findElement(taxLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Tax test is finished --");
    }

    @Test
    public void translationTest() {
        waitUntilElementIsPresent(translationLocator);
        assertTrue("No translation menu", isElementPresent(translationLocator));
        findElement(translationLocator).click();
        assertTrue(checkSubMenu(submenu, headerLocator));
        log.info("-- Translation test is finished --");
    }

    @Test
    public void usersTest() {
        waitUntilElementIsPresent(usersLocator);
        assertTrue("No users menu", isElementPresent(usersLocator));
        findElement(usersLocator).click();
        assertEquals(findElement(usersLocator).getText(), findElement(headerLocator).getText());
        log.info("-- Users test is finished --");
    }
    // Failed because there is no h1 locator
    @Test
    public void modsTest() {
        waitUntilElementIsPresent(modsLocator);
        assertTrue("No vQmods menu", isElementPresent(modsLocator));
        findElement(modsLocator).click();
        assertTrue(findElement(headerLocator).isDisplayed());
        log.info("-- vQmods test is finished --");
    }
}

