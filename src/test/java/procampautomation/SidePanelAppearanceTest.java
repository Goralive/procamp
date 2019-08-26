package procampautomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SidePanelAppearanceTest extends TestBase {

    String loginBtnSelector = "#box-login button";
    String appearanceLocator = "#app-appearance";
    String headerLocator = "#main h1";
    String submenu = "[id^=doc]";

    @Before
    public void redirectToPage() {
        get("http://demo.litecart.net/admin/");
//        getCookie();
//        addCookie();
        findElement(loginBtnSelector).click();

    }
//

    @Test
    public void appearanceTest() {
        waitUntilElementIsPresent(appearanceLocator);
        assertTrue("No appearance menu", isElementPresent(appearanceLocator));
        findElement(appearanceLocator).click();
        assertTrue("No submenu is present", areElementsPresent(submenu));
        assertTrue(checkSubMenu(submenu, headerLocator));
    }
}

