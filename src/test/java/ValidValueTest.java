import org.junit.*;
import org.openqa.selenium.By;


public class ValidValueTest extends WebDriverSettings {
    @Test
    public void testValidMinValue() {
        // Given
        driver.get(TestSelectors.WEBSITEURL);
        // When
        driver.findElement(By.xpath(TestSelectors.NAMEXPATH)).sendKeys("Кирилл");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("50");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("3");
        driver.findElement(By.xpath(TestSelectors.MALERADIOBUTTONXPATH)).click();
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        // Then
        String result = driver.findElement(By.xpath(TestSelectors.SUCCESSMESSAGEXPATH)).getText();
        System.out.println(result);
        Assert.assertEquals("Слишком малая масса тела", result);
    }
    @Test
    public void testValidMaxValue() {
        // Given
        driver.get(TestSelectors.WEBSITEURL);
        // When
        driver.findElement(By.xpath(TestSelectors.NAMEXPATH)).sendKeys("Кирилл");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("300");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("500");
        driver.findElement(By.xpath(TestSelectors.MALERADIOBUTTONXPATH)).click();
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        // Then
        String result = driver.findElement(By.xpath(TestSelectors.SUCCESSMESSAGEXPATH)).getText();
        System.out.println(result);
        Assert.assertEquals("Значительный избыток массы тела, тучность", result);
    }

}
