package exercise;

import java.util.HashMap;
import java.util.Map;

public class InMemoryKV implements KeyValueStorage {

    private Map<String, String> storage = new HashMap<>();

    public InMemoryKV(Map<String, String> initial) {
        storage.putAll(initial);
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.containsKey(key) ? storage.get(key) : defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }

}
