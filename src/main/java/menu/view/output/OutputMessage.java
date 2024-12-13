package menu.view.output;

public enum OutputMessage {
    START_RECOMMENDATION("점심 메뉴 추천을 시작합니다.\n"),
    INPUT_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)\n"),
    INPUT_CANNOT_EAT("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n"),
    INPUT_RECOMMENDATION_RESULT("메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    FINISH_RECOMMENDATION("추천을 완료했습니다.\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
