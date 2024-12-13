package menu.view.input.exception;

public enum InputErrorMessage {
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n"),
    INCORRECT_INPUT_FORMAT("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.\n"),
    INVALID_COACH_NUMBER("코치는 최소 2명 이상 입력해야 합니다.\n"),
    INVALID_COACH_NAME_LENGTH("코치 이름은 2글자 이상 4글자 이하입니다.\n"),
    CANNOT_OVER_TWO_MENU("못 먹는 메뉴는 최소 0개, 최대 2개입니다.\n"),
    INTEGER_REQUIRED("숫자만 입력 가능합니다.\n"),
    POSITIVE_NUMBER_REQUIRED("양수만 입력 가능합니다.\n");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    InputErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
