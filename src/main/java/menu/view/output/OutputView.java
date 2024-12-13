package menu.view.output;

import static menu.view.output.OutputMessage.FINISH_RECOMMENDATION;
import static menu.view.output.OutputMessage.INPUT_CANNOT_EAT;
import static menu.view.output.OutputMessage.INPUT_COACH_NAME;
import static menu.view.output.OutputMessage.INPUT_RECOMMENDATION_RESULT;
import static menu.view.output.OutputMessage.RECOMMENDATION_FORMAT;
import static menu.view.output.OutputMessage.START_RECOMMENDATION;

import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachRepository;

public class OutputView {
    public static void printStartRecommendation() {
        System.out.println(START_RECOMMENDATION.getMessage());
    }

    public static void printCoachName() {
        System.out.println(INPUT_COACH_NAME.getMessage());
    }

    public static void printCannotEat(String name) {
        System.out.printf(INPUT_CANNOT_EAT.getMessage(), name);
    }

    public static void printRecommendationResult(List<String> categoryNames) {
        System.out.println(INPUT_RECOMMENDATION_RESULT.getMessage());

        System.out.printf(RECOMMENDATION_FORMAT.getMessage(), "카테고리", String.join(" | ", categoryNames));
        for (Coach c : CoachRepository.coachs()) {
            System.out.printf(RECOMMENDATION_FORMAT.getMessage(), c.getName(),
                    String.join(" | ", c.getRecommendedMenus()));
        }

        System.out.println(FINISH_RECOMMENDATION.getMessage());
    }
}
