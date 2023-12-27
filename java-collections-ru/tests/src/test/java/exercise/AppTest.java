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
      //  var list = List.of(1, 2, 3, 4, 5, 6);
      //  var expected = List.of(1, 2, 3);
        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        var expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        var actual = App.take(list, 3);
        assertThat(expected).isEqualTo(actual);
      //  Assertions.assertEquals(expected, list);
    }
}
