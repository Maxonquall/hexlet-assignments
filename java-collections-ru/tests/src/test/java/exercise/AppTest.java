package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        var list = List.of(1, 5, 3, 4, 5, 6);
        var expected = List.of(1, 5, 3);
        var actual = App.take(list, 3);
        assertThat(expected).isEqualTo(actual);
    }
}
