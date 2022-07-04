
    public class WeightCalculatorTest {

        public static void main (String[]args) throws InterruptedException {
            InvalidValueTest invalidValueTest = new InvalidValueTest();
            invalidValueTest.setUp();
            invalidValueTest.testWithInvalidMaxdValue();
            invalidValueTest.testWithInvalidMindValue();
            invalidValueTest.testWithNoValue();
            invalidValueTest.close();
        }
    }