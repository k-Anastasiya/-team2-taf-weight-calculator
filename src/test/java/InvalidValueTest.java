import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidValueTest extends WebDriverManager {


    public ChromeDriver driver;


    @Before
    public void setUp () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testWithInvalidMindValue () throws InterruptedException {
        driver.get(TestSelectors.WEBSITEURL);
        WebElement searchInput = (driver.findElement(By.xpath(TestSelectors.NAMEXPATH)));
        searchInput.sendKeys(" ");

        searchInput =  driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH));
        searchInput.sendKeys("49.99");

        searchInput = driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH));
        searchInput.sendKeys("2.99");

        Thread.sleep(1000);
        WebElement searchBtn2 = driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH));
        searchBtn2.click();

        searchInput = driver.findElement(By.xpath(TestSelectors.ERRORMESSAGECSS));
        String actualMessage = searchInput.getText();
        Assert.assertEquals("Не указано имя.\nРост должен быть в диапазоне 50-300 см." +
                "\nВес должен быть в диапазоне 3-500 кг.\nНе указан пол.", actualMessage);

    }

    @Test
    public void testWithInvalidMaxdValue () throws InterruptedException {
        driver.get(TestSelectors.WEBSITEURL);
        WebElement searchInput = (driver.findElement(By.xpath(TestSelectors.NAMEXPATH)));
        searchInput.sendKeys("  ");

        searchInput = driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH));
        searchInput.sendKeys("300.01");

        searchInput = driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH));
        searchInput.sendKeys("500.01");

        Thread.sleep(1000);
        WebElement searchBtn2 = driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH));
        searchBtn2.click();

        searchInput = driver.findElement(By.xpath(TestSelectors.ERRORMESSAGECSS));
        String actualMessage = searchInput.getText();
        Assert.assertEquals("Не указано имя.\nРост должен быть в диапазоне 50-300 см." +
                "\nВес должен быть в диапазоне 3-500 кг.\nНе указан пол.", actualMessage);
    }
    @Test
    public void testWithNoValue () throws InterruptedException {
        driver.get(TestSelectors.WEBSITEURL);
        WebElement searchInput = (driver.findElement(By.xpath(TestSelectors.NAMEXPATH)));
        searchInput.sendKeys("");

        searchInput =  driver.findElement(By.xpath(TestSelectors.HEIGHTXPATH));
        searchInput.sendKeys("");

        searchInput = driver.findElement(By.xpath(TestSelectors.WEIGHTXPATH));
        searchInput.sendKeys("");

        Thread.sleep(1000);
        WebElement searchBtn2 = driver.findElement(By.xpath(TestSelectors.CALCULATEBUTTONXPATH));
        searchBtn2.click();

        searchInput = driver.findElement(By.xpath(TestSelectors.ERRORMESSAGECSS));
        String actualMessage = searchInput.getText();
        Assert.assertEquals("Не указано имя.\nРост должен быть в диапазоне 50-300 см." +
                "\nВес должен быть в диапазоне 3-500 кг.\nНе указан пол.", actualMessage);
    }

    @After
    public void close () throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();

    }
}