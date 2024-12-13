package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {
    private final static String COMMA = ",";
    private final String name;
    private final List<String> cannotEatMenus;
    private List<String> recommendedMenus;

    public Coach(String name, String cannotEatMenus) {
        this.name = name;
        this.cannotEatMenus = parseMenu(cannotEatMenus);
        recommendedMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void addRecommendedMenus(String menu) {
        this.recommendedMenus.add(menu);
    }

    private List<String> parseMenu(String cannotEatMenu) {
        if (cannotEatMenu.isBlank()) {
            return new ArrayList<>();
        }
        if (cannotEatMenu.contains(COMMA)) {
            return Arrays.asList(cannotEatMenu.split(COMMA));
        }
        return List.of(cannotEatMenu);
    }

    public boolean isDuplicateMenu(String input) {
        return recommendedMenus.contains(input);
    }

    public boolean isCannotEatMenu(String input) {
        return cannotEatMenus.contains(input);
    }


}
