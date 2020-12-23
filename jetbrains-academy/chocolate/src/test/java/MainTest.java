
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void dummyMethodTest() {
        int expected = 0;
        int actual = 0;
        assertThat(actual).isEqualTo(expected);
    }

    void testSample1() {
        final Main main = new Main();
        final boolean actual = main.isPossible(4, 2, 6);
        assertThat(actual).isEqualTo(true);
    }

    void testSample2() {
        final Main main = new Main();
        final boolean actual = main.isPossible(2, 10, 7);
        assertThat(actual).isEqualTo(false);
    }

    void testSample3() {
        final Main main = new Main();
        final boolean actual = main.isPossible(7, 4, 21);
        assertThat(actual).isEqualTo(true);
    }

}