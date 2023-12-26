package homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareAverageListTest {

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 2", "2, -4, -7, -3"})
    void testGetAverage(int num1, int num2, int num3, double expectedAverage) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        CompareAverageList compareAverageList = new CompareAverageList();
        assertEquals(expectedAverage, compareAverageList.getAverage(list));
    }

    @Test
    void testExpectedException() {
        List<Integer> list = new ArrayList<>();
        CompareAverageList compareAverageList = new CompareAverageList();
        assertThrows(RuntimeException.class, () -> compareAverageList.getAverage(list), "");
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            compareAverageList.getAverage(list);
        });
        assertEquals("Список пуст", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 2, 2, Второй список имеет большее среднее значение",
            "2, 2, 1, 1, Первый список имеет большее среднее значение",
            "1, 1, 1, 1, Средние значения равны"})
    void testCompareAverage(int num1, int num2, int num3, int num4, String message) {
        CompareAverageList compareAverageList = new CompareAverageList();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(num1);
        list1.add(num2);
        list2.add(num3);
        list2.add(num4);
        assertEquals(message, compareAverageList.compareAverage(list1, list2));
    }
}