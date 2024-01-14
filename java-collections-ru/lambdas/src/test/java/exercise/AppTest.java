package exercise;

import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @Test
    void testEnlargeArrayImage() {
        String[][] test = {
                {"*", "*"},
                {"*", "*"}
        };
        String[][] expected = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"}
        };

        String[][] actual = App.enlargeArrayImage(test);
        assertThat(actual).isEqualTo(expected);
    }
}
