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
    }

    @Test
    public void adminPageOpened() {
        assertEquals("demo store", driver.getTitle().toLowerCase());
        log.info("Admin page test is finished");
    }

    @Test
    public void login() {
        driver.findElement(By.cssSelector(loginBtnSelector)).click();
        waitUntilElementIsPresent(By.cssSelector(sidebarSelector));
        assertEquals(true, isElementPresent(By.cssSelector(logotypeSelector)));
        log.info("Login test finished");
    }
}
