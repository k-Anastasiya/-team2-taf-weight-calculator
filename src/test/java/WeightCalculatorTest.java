public class WeightCalculatorTest {

    WebDriver driver;


    @Before
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }



    @After
    public void afterClass() {
        driver.quit();
    }

}
