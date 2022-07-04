import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.chrome.ChromeDriver;

public  class WebDriverManager {
    public static ChromeDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

    }
    @After
    public void close() throws InterruptedException {

        driver.quit();

    }

}