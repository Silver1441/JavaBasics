package task2.negative;

import org.junit.jupiter.api.Test;
import task2.exception.WrongInputException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static task2.support.InputValidator.validateInput;

public class InputValidatorTest {

    @Test
    public void testValidateInputInappropriateSymbols() {
        String input = "OneDotTwelve/34";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }

    @Test
    public void testValidateInputInappropriateFunction() {
        String input = "34^2";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }

    @Test
    public void testValidateInputMultipleDots() {
        String input = "13+34..0";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }

    @Test
    public void testValidateInputUnclosedDotLeft() {
        String input = "13+.1";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }

    @Test
    public void testValidateInputUnclosedDotRight() {
        String input = "34.-64";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }

    @Test
    public void testValidateInputUnclosedLeftParentheses() {
        String input = "((64.6/5)/34";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }

    @Test
    public void testValidateInputUnclosedRightParentheses() {
        String input = "(64.6/5)/34)";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }

    @Test
    public void testValidateInputInappropriateParenthesesLocation() {
        String input = "(34)(64.6/5)";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }

    @Test
    public void testValidateInputEmpty() {
        String input = "";
        assertThrows(WrongInputException.class, (() -> validateInput(input)));
    }
}
