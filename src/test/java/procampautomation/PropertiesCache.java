package procampautomation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Read properties from file, located in test resources. Used for cookies
 */
public class PropertiesCache {

    private final Properties configProp = new Properties();

    private static final PropertiesCache INSTANCE = new PropertiesCache();

    private PropertiesCache() {

        InputStream in = getClass().getClassLoader().getResourceAsStream("test.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static String getProperty(String key) {
        return INSTANCE.configProp.getProperty(key);
    }
}



//TODO Check another impl

//    public void checkSubMenu (String locator) {
//        findElement(locator).click();
//        waitUntilElementIsPresent(headerLocator);
//        areElementsPresent(submenu);
//        for (WebElement submenuItem : driver.findElements(By.cssSelector(submenu))) {
//            String tempLocator = "#" + submenuItem.getAttribute("id");
//            findElement(tempLocator);
//            log.info("Clicking on item in submenu: " + tempLocator);
//            wait.until(ExpectedConditions.attributeToBe(headerLocator,"h1",findElement(headerLocator).getText()));
//            log.info("Head text on the main page: " + findElement(headerLocator).getText());
//        }
//
//    }