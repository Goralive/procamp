package procampautomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SidePanelTest extends TestBase {

    String loginBtnSelector = "#box-login button";
    // Locators for all submenu tests
    String sidebarLocator = "#sidebar";
    String headerLocator = "div.panel-heading";
    String submenu = "li.doc";
    String appSubmenu = "li.app";
    // Locators for Sidebar


    @Before
    public void redirectToPage() {
        get("http://demo.litecart.net/admin/");
        try {
            findElement(loginBtnSelector).click();
        } catch (NoSuchElementException e) {
            log.info("--- No login page --- sidebar is present --- ");
        }
    }

    @Test
    public void subMenu() {
        waitUntilElementIsPresent(sidebarLocator);
        List<WebElement> webElementList = driver.findElements(By.cssSelector(appSubmenu));
        for (int i = 1; i <= webElementList.size(); i++) {
            findElement(appSubmenu + ":nth-of-type(" + i + ")").click();
            List<WebElement> subElementList = driver.findElements(By.cssSelector(submenu));
            for (int j = 1; j < subElementList.size() + 1; j++) {
                findElement(submenu + ":nth-of-type(" + j + ")").click();
                waitUntilElementIsPresent(headerLocator);
                log.info("Clicking in submenu");
                //Last submenu don't have a header
                assertTrue("Header is absent", findElement(headerLocator).isDisplayed());
            }
        }
    }
}
