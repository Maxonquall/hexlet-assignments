package exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> mansList) {
        List<Map<String, String>> users = new ArrayList<>(mansList);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Collections.sort(users, Comparator.comparing(user -> LocalDate.parse(user.get("birthday"), formatter)));
        List<Map<String, String>> filteredUsers = users.stream()
                .filter(user -> "male".equals(user.get("gender")))
                .collect(Collectors.toList());
        return  filteredUsers.stream()
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }
}
