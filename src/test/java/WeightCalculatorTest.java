import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WeightCalculatorTest {
    WebDriver driver;

    @Before
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testInvalidHeightField() {
        // Given
        driver.get(TestSelectors.WEBSITEURL);
        // When
        WebElement actualName = driver.findElement(By.xpath(TestSelectors.NAMEXPATH));
        actualName.sendKeys("Кирилл");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("180привет");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("80");
        driver.findElement(By.xpath(TestSelectors.MALERADIOBUTTONXPATH)).click();
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        // Then
        String result = driver.findElement(By.cssSelector(TestSelectors.ERRORMESSAGECSS)).getText();
        System.out.println(result);
        Assert.assertEquals("Рост должен быть в диапазоне 50-300 см.", result);
    }

    @After
    public void afterClass() {
        driver.quit();
    }

}
