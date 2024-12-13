package menu.view.output;

import static menu.view.output.OutputMessage.INPUT_COACH_NAME;
import static menu.view.output.OutputMessage.START_RECOMMENDATION;

public class OutputView {
    public static void printStartRecommendation() {
        System.out.println(START_RECOMMENDATION.getMessage());
    }

    public static void printCoachName() {
        System.out.println(INPUT_COACH_NAME.getMessage());
    }
}
