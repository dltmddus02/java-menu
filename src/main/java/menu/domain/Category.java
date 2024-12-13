package menu.domain;

import static menu.view.input.exception.InputErrorMessage.NON_EXISTENT_MENU;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import menu.view.input.exception.InputException;

public enum Category {
    JAPANESE("일식", List.of(), 1),
    KOREAN("한식", List.of(), 2),
    CHINESE("중식", List.of(), 3),
    ASIAN("아시안", List.of(), 4),
    WESTERN("양식", List.of(), 5);

    private final String categoryName;
    private final List<String> menus;
    private final Integer category;

    Category(String categoryName, List<String> menus, Integer category) {
        this.categoryName = categoryName;
        this.menus = menus;
        this.category = category;
    }

    public String getCategoryNameByCategory(Integer category) {
        Arrays.stream(Category.values())
                .filter(c -> c.category == category)
                .map(c -> c.categoryName)
                .findFirst();
//        return cate.get();
    }

    public List<String> getMenus() {
        return menus;
    }

    public Integer getCategory() {
        return category;
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
