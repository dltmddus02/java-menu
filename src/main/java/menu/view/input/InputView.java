package menu.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCoachName() {
        String coachName = Console.readLine();
        InputValidator.validateCoachName(coachName);
        return coachName;
    }

//    public static String inputCannotEat() {
//        String cannotEat = Console.readLine();
//        InputValidator.validateCannotEat(cannotEat);
//        return cannotEat;
//    }
//
//    public static String inputRecommendationResult() {
//        String recommendationResult = Console.readLine();
//        InputValidator.validateRecommendationResult(recommendationResult);
//        return recommendationResult;
//    }
}
