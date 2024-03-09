package exercise;

import java.io.IOException;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FFileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void clear() throws Exception {
        Files.deleteIfExists(filepath);
    }
    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    @Test
    public void fileKVTest() throws IOException {
        // {}key3":"value3"}":"value3"}3"}
        var expected =  "{\"TestKey\":\"TestValue\"}";
        var newFileKV = new FileKV(filepath.toString(), Map.of("TestKey", "TestValue"));
        var actual = Utils.serialize(newFileKV.toMap());
        assertEquals(expected, actual);
    }

}
