package remote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverLogger extends AbstractWebDriverEventListener {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(WebDriverLogger.class);

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        LOGGER.info("WebDriver navigated to '" + url + "'");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOGGER.info("WebDriver click on element - "
                + element);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        LOGGER.info("WebDriver will change value for element - "
                + element);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        LOGGER.info("WebDriver changed value for element - "
                + element);
    }



}
