package com.redi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * f(0) = 0
 * f(1) = 1
 * f(n) = f(n-1) + f(n-2) | n > 1
 * <p>
 * 0, 1, 2, 3, 4, 5, 6,  7,  8,
 * 0, 1, 1, 2, 3, 5, 8, 13, 21,
 */
@Timeout(value = 5)
class FibonacciTest {

    @Test
    void shouldThrowIllegalArgumentExceptionIfNegativeIndex() {
        // Arrange
        Fibonacci fibonacci = new Fibonacci();

        // Act
        assertThrows(IllegalArgumentException.class, () -> fibonacci.get(-1));
    }

    @Test
    void shouldReturnZeroForZero() {
        // Arrange
        Fibonacci fibonacci = new Fibonacci();

        // Act
        long result = fibonacci.get(0);

        // Assert
        assertEquals(0, result, "Given 0 fibonacci must return 0");
    }

    @Test
    void shouldReturn1For1() {
        // Arrange
        Fibonacci fibonacci = new Fibonacci();

        // Act
        long result = fibonacci.get(1);

        // Assert
        assertEquals(1, result, "Given 1 fibonacci must return 1");
    }

    @Test
    @Timeout(value = 5)
    void shouldReturnCorrectValueForALargeIndex() {
        // Arrange
        Fibonacci fibonacci = new Fibonacci();

        // Act
        long result = fibonacci.get(90);

        // Assert
        assertEquals(2880067194370816120L, result, "Given 1 fibonacci must return 1");
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "3, 2",
            "5, 5",
            "8, 21",
    })
    void shouldReturnSumOfPreviousTwoFibonaccisGivenIndexGreaterThan1(int index, long expected) {
        // Arrange
        Fibonacci fibonacci = new Fibonacci();

        // Act
        long result = fibonacci.get(index);

        // Assert
        assertEquals(expected, result, "Given 5 fibonacci must return 5");
    }
}