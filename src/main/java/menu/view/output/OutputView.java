package menu.view.output;

import static menu.view.output.OutputMessage.INPUT_CANNOT_EAT;
import static menu.view.output.OutputMessage.INPUT_COACH_NAME;
import static menu.view.output.OutputMessage.INPUT_RECOMMENDATION_RESULT;
import static menu.view.output.OutputMessage.START_RECOMMENDATION;

public class OutputView {
    public static void printStartRecommendation() {
        System.out.println(START_RECOMMENDATION.getMessage());
    }

    public static void printCoachName() {
        System.out.println(INPUT_COACH_NAME.getMessage());
    }

    public static void printCannotEat() {
        System.out.println(INPUT_CANNOT_EAT.getMessage());
    }

    public static void printRecommendationResult() {
        System.out.println(INPUT_RECOMMENDATION_RESULT.getMessage());
    }

}
