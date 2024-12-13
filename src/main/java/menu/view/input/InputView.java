package menu.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String COMMA = ",";

    public static String[] inputCoachName() {
        String coachName = Console.readLine();
        InputValidator.validateCoachName(coachName);
        return coachName.split(COMMA);
    }

    public static String inputCannotEat() {
        String cannotEat = Console.readLine();
        InputValidator.validateCannotEat(cannotEat);
        return cannotEat;
    }
}
