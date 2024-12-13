package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.service.RecommendateMenu;
import menu.view.input.InputView;
import menu.view.input.exception.InputException;
import menu.view.output.OutputView;

public class MenuController {
    RecommendateMenu recommendateMenu;

    public MenuController() {
        recommendateMenu = new RecommendateMenu();
    }

    public void run() {
        OutputView.printStartRecommendation();
        prepareCoaches();
        startRecommendation();
    }

    private void prepareCoaches() {
        String[] coaches = inputCoaches();
        for (String c : coaches) {
            String cannotEatMenu = prepareCoachCannotEat(c);
            Coach coach = new Coach(c, cannotEatMenu);
            CoachRepository.addCoach(coach);
        }
    }

    private String[] inputCoaches() {
        return retryOnInvalidInput(() -> {
            OutputView.printCoachName();
            return InputView.inputCoachName();
        });
    }

    private String prepareCoachCannotEat(String name) {
        return retryOnInvalidInput(() -> {
            OutputView.printCannotEat(name);
            String cannotEatMenu = InputView.inputCannotEat();
            Category.validate(cannotEatMenu);
            return cannotEatMenu;
        });
    }

    private void startRecommendation() {
        while (recommendateMenu.getRandomCategories().size() != 5) {
            recommendateMenu.recommendateMenu();
        }
        List<String> categoryNames = recommendateMenu.getRandomCategories();
        OutputView.printRecommendationResult(categoryNames);
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
