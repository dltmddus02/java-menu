package menu.view.input;

import menu.view.input.exception.InputErrorMessage;
import menu.view.input.exception.InputException;

public class InputValidator {
    private final static String COMMA = ",";

    public static void validateCoachName(String input) {
        validateNotNullOrEmpty(input);
        if (!input.contains(COMMA)) {
            throw new InputException(InputErrorMessage.INCORRECT_INPUT_FORMAT);
        }
        if (input.split(COMMA).length < 2 || input.split(COMMA).length > 5) {
            throw new InputException(InputErrorMessage.INCORRECT_INPUT_FORMAT);
        }
    }

    public static void validateCannotEat(String input) {
        if (input.contains(COMMA)) {
            if (input.split(COMMA).length > 2) {
                throw new InputException(InputErrorMessage.CANNOT_OVER_TWO_MENU);
            }
        }
    }

    public static void validateNotNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

}
