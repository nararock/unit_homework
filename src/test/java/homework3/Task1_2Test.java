package homework3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task1_2Test {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 4, -100, -101})
    @DisplayName("Test the number for parity")
    void evenOddNumber(int number) {
        Task1 task1 = new Task1();
        boolean result = task1.evenOddNumber(number);
        assertEquals(number % 2 == 0, result, number % 2 + " == 0 is not " + result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 25,  40, 100, 105})
    @DisplayName("Test the number belongs to the interval")
    void numberInInterval(int number) {
        Task2 task2 = new Task2(25, 100);
        boolean result = task2.numberInInterval(number);
        assertEquals(number > 25 && number < 100, result, "The number " + number + " > 25 &&" + number +
                " < 100 is not " + result);
    }
}