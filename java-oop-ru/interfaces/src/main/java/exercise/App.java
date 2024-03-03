package exercise;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        return apartments.stream()
                .sorted(Home::compareTo)
                .limit(n)
                .map(Object::toString)
                .collect(Collectors.toList());
    }

}
