package exercise;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {

    private Map<String, String> storage = new HashMap<>();


    public FileKV(String path, Map<String, String> newMap) throws IOException {
        String fileContent = Utils.readFile(path);
        if (!fileContent.isEmpty()) {
            storage.putAll(Utils.unserialize(fileContent));
        }
        storage.putAll(newMap);
        Utils.writeFile(path, Utils.serialize(storage));
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


