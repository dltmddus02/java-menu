package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachRepository;

public class RecommendateMenu {
    //    Category category;
    List<String> randomCategories;

    public RecommendateMenu() {
        this.randomCategories = new ArrayList<>();
    }

    public List<String> getRandomCategories() {
        return randomCategories;
    }

    public String pickRandomCategory() {
        return Category.getCategoryNameByCategory(Randoms.pickNumberInRange(1, 5));

    }

    public void recommendateMenu() {
        String randomCategory = String.valueOf(pickRandomCategory());
        if (Collections.frequency(randomCategories, randomCategory) <= 1) {
            randomCategories.add(randomCategory);
        }
        for (Coach coach : CoachRepository.coachs()) {
            recommendPersonalMenu(coach, randomCategories.size());
        }

//        while (randomCategories.size() != 5) {
//            String randomCategory = String.valueOf(pickRandomCategory());
//            if (Collections.frequency(randomCategories, randomCategory) <= 1) {
//                randomCategories.add(randomCategory);
//            }
//        }
//        }
//        for (Coach coach : CoachRepository.coachs()) {
//            // 카테고리에 맞는 음식 추천해줘야함 ok
//            // 못먹는 음식은 제외해야함
//            // 중복 음식은 추천 금지
//            // sheffle로 섞고 첫번째 사용 ok
//            // shuffle 인자에 모든 메뉴 들어가야함 ok
//            recommendPersonalMenu(coach);
//        }
    }

    private void recommendPersonalMenu(Coach coach, Integer dayidx) {
//        for (int dayidx = 0; dayidx < 5; dayidx++) {
        // ex) 일식
        String categoryName = randomCategories.get(dayidx - 1); // dayidx 가 0이면 월욜 카테고리 가져옴
        List<String> allMenu = Category.getMenusByCategoryName(categoryName);
        String menu;
        do {
            menu = Randoms.shuffle(allMenu).get(0);
        } while (coach.isDuplicateMenu(menu) || coach.isCannotEatMenu(menu));
        coach.addRecommendedMenus(menu);
    }

//    }
}
