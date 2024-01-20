package exercise;


import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;

class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new HashMap<>();
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        for (var key : keys) {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else if (data1.containsKey(key)) {
                result.put(key, "deleted");
            } else {
                result.put(key, "added");
            }
        }
        return result;

    }
}
