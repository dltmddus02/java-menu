package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachRepository;

public class RecommendateMenu {
    Category category;
    List<String> randomCategories;

    public RecommendateMenu() {
        this.randomCategories = new ArrayList<>();
    }

    public String pickRandomCategory() {
        return category.getCategoryNameByCategory(Randoms.pickNumberInRange(1, 5));

    }

    public void recommendateMenu() {
        while (randomCategories.size() != 5) {
            String randomCategory = pickRandomCategory();
            if (Collections.frequency(randomCategories, randomCategory) <= 1) {
                randomCategories.add(randomCategory);
            }
        }
        for (Coach coach : CoachRepository.coachs()) {
            // 카테고리에 맞는 음식 추천해줘야함
            // 못먹는 음식은 제외해야함
            // 중복 음식은 추천 금지
            // sheffle로 섞고 첫번째 사용
            // shuffle 인자에 모든 메뉴 들어가야함
            recommendPersonalMenu(coach);
        }
    }

    private void recommendPersonalMenu(Coach coach) {
        for (int dayidx = 0; dayidx < 5; dayidx++) {
            String day = randomCategories.get(dayidx); // dayidx 가 0이면 월욜 카테고리 가져옴

        }

    }
}
