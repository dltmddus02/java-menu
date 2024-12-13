package menu.domain;

import static menu.view.input.exception.InputErrorMessage.NON_EXISTENT_MENU;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import menu.view.input.exception.InputException;

public enum Category {
    JAPANESE("일식", List.of()),
    KOREAN("한식", List.of()),
    CHINESE("중식", List.of()),
    ASIAN("아시안", List.of()),
    WESTERN("양식", List.of());

    private final String category;
    private final List<String> menus;

    Category(String category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return menus;
    }

    public static void validateExistMenu(String menu) {
        Optional<Category> menuOptional = Arrays.stream(Category.values())
                .filter(c -> c.menus.contains(menu))
                .findFirst();

        if (menuOptional.isEmpty()) {
            throw new InputException(NON_EXISTENT_MENU);
        }
    }
}
