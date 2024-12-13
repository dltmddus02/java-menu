package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    private static final List<Coach> coachs = new ArrayList<>();

    public static List<Coach> coachs() {
        return Collections.unmodifiableList(coachs);
    }

    public static void addCoach(Coach coach) {
        coachs.add(coach);
    }
}
