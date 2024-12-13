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
    }

    public String getName() {
        return name;
    }

    public List<String> getCannotEatMenus() {
        return cannotEatMenus;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void setRecommendedMenus(List<String> recommendedMenus) {
        this.recommendedMenus = recommendedMenus;
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
}
