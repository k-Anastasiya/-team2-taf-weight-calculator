import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidValueTest extends WebDriverSettings {

    @Test
    public void testValidMinValue() throws InterruptedException {

        // Given
        driver.get(TestSelectors.WEBSITEURL);
        // When
        driver.findElement(By.xpath(TestSelectors.NAMEXPATH)).sendKeys("Кирилл");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("50");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("3");
        driver.findElement(By.xpath(TestSelectors.MALERADIOBUTTONXPATH)).click();
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        Thread.sleep(1000);
        // Then
        String result = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText();
        System.out.println(result);
        Assert.assertEquals("Слишком малая масса тела", result);
    }
    @Test
    public void testValidMaxValue() throws InterruptedException {
        // Given
        driver.get(TestSelectors.WEBSITEURL);
        // When
        driver.findElement(By.xpath(TestSelectors.NAMEXPATH)).sendKeys("Кирилл");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("300");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("500");
        driver.findElement(By.xpath(TestSelectors.MALERADIOBUTTONXPATH)).click();
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        Thread.sleep(1000);
        // Then
        String result = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText();
        System.out.println(result);
        Assert.assertEquals("Значительный избыток массы тела, тучность", result);
    }

}
