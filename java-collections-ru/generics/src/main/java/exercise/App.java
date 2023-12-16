package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;


class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> booksSorted = new ArrayList<>();
        for (var book : books) {
            var entryWhere = where.entrySet();
            var count = 0;
            for (var entry : entryWhere) {
                if (book.get(entry.getKey()).equals(entry.getValue())) {
                    count++;
                }
            }
            if (count == where.size()) {
                booksSorted.add(book);
            }
        }
        return booksSorted;
    }
}
