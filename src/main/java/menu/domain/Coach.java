package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> cannotEatMenus;
    private List<String> recommendedMenus;

    public Coach(String name, List<String> cannotEatMenus) {
        this.name = name;
        this.cannotEatMenus = cannotEatMenus;
    }
}
