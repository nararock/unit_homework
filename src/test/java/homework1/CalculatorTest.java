package homework1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @AfterEach
    void cleanup() {
        calculator = null;
    }

    @AfterAll
    static void teardown() {
        System.out.println("After all tests");
    }

    @Test
    @DisplayName("Test addition")
    void testAdd() {
        int result = calculator.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    @DisplayName("Test subtraction")
    void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result, "10 - 4 should equal 6");
    }

    @Test
    @DisplayName("Test multiplication")
    void testMultiply() {
        int result = calculator.multiply(6, 7);
        assertEquals(42, result, "6 * 7 should equal 42");
    }

    @Test
    @DisplayName("Test division")
    void testDivide() {
        int result = calculator.divide(20, 5);
        assertEquals(4, result, "20 / 5 should equal 4");
    }

    @Test
    @DisplayName("Test division by zero")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0), "Division by zero should throw ArithmeticException");
    }

    @Test
    @DisplayName("Test calculate discount")
    void testCalculateDiscount(){
        double result = calculator.calculateDiscount(450.5,40);
        assertEquals(270.3, result, "the amount of 450.5 after deducting 40% should be 270.3");
    }

    @Test
    @DisplayName("Test wrong percentages for calculate discount")
    void testWrongPercentages(){
        assertThrows(ArithmeticException.class, () -> calculator.calculateDiscount(400, 120),
                "Percentages of more than a hundred should be thrown away ArithmeticException");
    }

    @Test
    @DisplayName("Test negative purchase amount")
    void testNegativeAmount(){
        assertThrows(ArithmeticException.class, () -> calculator.calculateDiscount(-400, 20),
                "If the amount of purchases is negative, it should be thrown out ArithmeticException");
    }
}