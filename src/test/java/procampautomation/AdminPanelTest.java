package procampautomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class AdminPanelTest extends TestBase {

    String logotypeSelector = "#logotype";
    String loginBtnSelector = "#box-login button";
    String sidebarSelector = "#sidebar";


    @Before
    public void openUrl() {
        get("http://demo.litecart.net/admin/");
        waitUntilElementIsPresent(loginBtnSelector);
    }

    @Test
    public void adminPageOpened() {
        assertEquals("demo store", driver.getTitle().toLowerCase());
        log.info("-- Admin page opened test is finished --");
    }

    @Test
    public void login() {
        findElement(loginBtnSelector).click();
        waitUntilElementIsPresent(sidebarSelector);
        assertEquals(true, isElementPresent(logotypeSelector));
        log.info("-- Login test is finished --");
    }
}
