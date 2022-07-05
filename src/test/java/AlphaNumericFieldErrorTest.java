import org.junit.*;
import org.openqa.selenium.By;


public class AlphaNumericFieldErrorTest extends WebDriverSettings {
    @Test
    public void testInvalidHeightField() {
        // Given
        driver.get(TestSelectors.WEBSITEURL);
        // When
        driver.findElement(By.xpath(TestSelectors.NAMEXPATH)).sendKeys("Кирилл");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("180привет");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("80");
        driver.findElement(By.xpath(TestSelectors.MALERADIOBUTTONXPATH)).click();
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        // Then
        String result = driver.findElement(By.xpath(TestSelectors.ERRORMESSAGEXPATH)).getText();
        System.out.println(result);
        Assert.assertEquals("Рост должен быть в диапазоне 50-300 см.", result);
    }
    @Test
    public void testInvalidWeightField() {
        // Given
        driver.get(TestSelectors.WEBSITEURL);
        // When
        driver.findElement(By.xpath(TestSelectors.NAMEXPATH)).sendKeys("Кирилл");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("180");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("80привет");
        driver.findElement(By.xpath(TestSelectors.MALERADIOBUTTONXPATH)).click();
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        // Then
        String result = driver.findElement(By.xpath(TestSelectors.ERRORMESSAGEXPATH)).getText();
        System.out.println(result);
        Assert.assertEquals("Вес должен быть в диапазоне 3-500 кг.", result);
    }

}
