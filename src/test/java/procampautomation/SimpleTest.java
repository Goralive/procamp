package procampautomation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleTest extends TestBase {

    @Test
    public void openGooglePage() {
        get("http://www.google.com");
        assertEquals("google",driver.getTitle().toLowerCase());
    }
}
