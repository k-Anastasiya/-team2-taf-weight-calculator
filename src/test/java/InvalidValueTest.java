import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class InvalidValueTest extends WebDriverSettings {


    @Test
    public void testWithInvalidMindValue() throws InterruptedException {
        driver.get(TestSelectors.WEBSITEURL);
        driver.findElement(By.xpath(TestSelectors.NAMEXPATH)).sendKeys(" ");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("49.99");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("2.99");
        Thread.sleep(1000);
        WebElement searchBtn2 = driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH));
        searchBtn2.click();
        String actualMessage = driver.findElement(By.xpath(TestSelectors.ERRORMESSAGECSS)).getText();
        Assert.assertEquals("Не указано имя.\nРост должен быть в диапазоне 50-300 см." +
                "\nВес должен быть в диапазоне 3-500 кг.\nНе указан пол.", actualMessage);

    }

    @Test
    public void testWithInvalidMaxdValue() throws InterruptedException {
        driver.get(TestSelectors.WEBSITEURL);
        driver.findElement(By.xpath(TestSelectors.NAMEXPATH)).sendKeys("  ");
        driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH)).sendKeys("300.01");
        driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH)).sendKeys("500.01");
        Thread.sleep(1000);
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        String actualMessage = driver.findElement(By.xpath(TestSelectors.ERRORMESSAGECSS)).getText();
        Assert.assertEquals("Не указано имя.\nРост должен быть в диапазоне 50-300 см." +
                "\nВес должен быть в диапазоне 3-500 кг.\nНе указан пол.", actualMessage);
    }

    @Test
    public void testWithNoValue() throws InterruptedException {
        driver.get(TestSelectors.WEBSITEURL);
        Thread.sleep(1000);
        driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH)).click();
        String actualMessage = driver.findElement(By.xpath(TestSelectors.ERRORMESSAGECSS)).getText();
        Assert.assertEquals("Не указано имя.\nРост должен быть в диапазоне 50-300 см." +
                "\nВес должен быть в диапазоне 3-500 кг.\nНе указан пол.", actualMessage);
    }
}
