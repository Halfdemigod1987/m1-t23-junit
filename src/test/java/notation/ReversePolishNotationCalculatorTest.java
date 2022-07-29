package notation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReversePolishNotationCalculatorTest {

    private static ReversePolishNotationCalculator calculator;

    @BeforeAll
    public static void initCalculator() {
        calculator = new ReversePolishNotationCalculator();
    }

    @Test
    public void shouldCalculateAddition() {
        assertEquals(7, calculator.calculatePolishNotation("4 3 +"));
    }

    @Test
    public void shouldCalculateSubtraction() {
        assertEquals(-1, calculator.calculatePolishNotation("2 3 -"));
    }

    @Test
    public void shouldCalculateMultiplication() {
        assertEquals(6, calculator.calculatePolishNotation("2 3 *"));
    }

    @Test
    public void shouldCalculateWithAdditionalSpaces() {
        assertEquals(7, calculator.calculatePolishNotation(" 4   3  + "));
    }

    @Test
    public void shouldCalculateWithNegativeDigits() {
        assertEquals(1, calculator.calculatePolishNotation("-4 5 +"));
    }

    @Test
    public void shouldThrowExceptionWhenIllegalOperator() {
        NumberFormatException ex = assertThrows(
                NumberFormatException.class,
                () -> calculator.calculatePolishNotation("-4 5 /")
        );
    }

}