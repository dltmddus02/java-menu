package menu.domain;

import java.util.List;

public class RecommendResult {
    // 0,1,2,3,4 차례로 월화수목금
    private List<String> days;
    private List<String> categories;

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
