package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CoachRepository {
    private static final List<Coach> coachs = new ArrayList<>();

    public static List<Coach> coachs() {
        return Collections.unmodifiableList(coachs);
    }

    public static void addCoach(Coach coach) {
        coachs.add(coach);
    }

    public static void deleteCoach(String name) {
        coachs.removeIf(coach -> Objects.equals(coach.getName(), name));
    }

    public static void deleteAll() {
        coachs.clear();
    }

    public static Coach findCrewByName(String name) {
        return coachs().stream()
                .filter(coach -> coach.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
