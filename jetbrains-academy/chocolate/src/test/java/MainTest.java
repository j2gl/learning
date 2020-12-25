
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void dummyMethodTest() {
        int expected = 0;
        int actual = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testSample1() {
        final boolean actual = Main.isPossible(4, 2, 6);
        assertThat(actual).isEqualTo(true);
    }

    @Test
    void testSample2_false() {
        final boolean actual = Main.isPossible(2, 10, 7);
        assertThat(actual).isEqualTo(false);
    }

    @Test
    void testSample3() {
        final boolean actual = Main.isPossible(7, 4, 21);
        assertThat(actual).isEqualTo(true);
    }

    @Test
    void testSample4() {
        final boolean actual = Main.isPossible(5, 4, 5);
        assertThat(actual).isEqualTo(true);
    }

    @Test
    void testSample6_false() {
        final boolean actual = Main.isPossible(2, 4, 3);
        assertThat(actual).isEqualTo(false);
    }

}