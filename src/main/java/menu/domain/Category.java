package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.view.input.exception.InputErrorMessage;
import menu.view.input.exception.InputException;

public enum Category {
    JAPANESE("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"), 1),
    KOREAN("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"), 2),
    CHINESE("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"), 3),
    ASIAN("아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"), 4),
    WESTERN("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"), 5);

    private final String categoryName;
    private final List<String> menus;
    private final Integer category;

    Category(String categoryName, List<String> menus, Integer category) {
        this.categoryName = categoryName;
        this.menus = menus;
        this.category = category;
    }

    public static String getCategoryNameByCategory(Integer category) {
        return Arrays.stream(Category.values())
                .filter(c -> c.category.equals(category))
                .map(c -> c.categoryName)
                .findFirst()
                .orElse(null);
    }

    public static List<String> getMenusByCategoryName(String categoryName) {
        return Arrays.stream(Category.values())
                .filter(c -> c.categoryName.equals(categoryName))
                .map(c -> c.menus)
                .findFirst()
                .orElse(new ArrayList<>());
    }

    public static void validate(String menu) {
        if (menu.isBlank()) {
            return;
        }
        if (menu.contains(",")) {
            String[] menus = menu.split(",");
            for (String m : menus) {
                validateExistMenu(m);
            }
            return;
        }

        validateExistMenu(menu);
    }

    public static void validateExistMenu(String menu) {
        for (Category category : Category.values()) {
            if (category.menus.contains(menu)) {
                return;
            }
        }
        throw new InputException(InputErrorMessage.NON_EXISTENT_MENU);

    }
}
