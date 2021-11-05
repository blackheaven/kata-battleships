import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class GridTest {
    @Test
    void anEmptyGridShouldBeDisplayed() {
        assertThat(new Grid().repr())
                .isEqualTo("""
                        | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
                       0|   |   |   |   |   |   |   |   |   |   |
                       1|   |   |   |   |   |   |   |   |   |   |
                       2|   |   |   |   |   |   |   |   |   |   |
                       3|   |   |   |   |   |   |   |   |   |   |
                       4|   |   |   |   |   |   |   |   |   |   |
                       5|   |   |   |   |   |   |   |   |   |   |
                       6|   |   |   |   |   |   |   |   |   |   |
                       7|   |   |   |   |   |   |   |   |   |   |
                       8|   |   |   |   |   |   |   |   |   |   |
                       9|   |   |   |   |   |   |   |   |   |   |
                        """);
    }

    @Test
    void shouldAddOneGunShipAtOrigin() {
        assertThat(new Grid().addGunShip(0, 0).repr())
                .isEqualTo("""
                        | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
                       0| g |   |   |   |   |   |   |   |   |   |
                       1|   |   |   |   |   |   |   |   |   |   |
                       2|   |   |   |   |   |   |   |   |   |   |
                       3|   |   |   |   |   |   |   |   |   |   |
                       4|   |   |   |   |   |   |   |   |   |   |
                       5|   |   |   |   |   |   |   |   |   |   |
                       6|   |   |   |   |   |   |   |   |   |   |
                       7|   |   |   |   |   |   |   |   |   |   |
                       8|   |   |   |   |   |   |   |   |   |   |
                       9|   |   |   |   |   |   |   |   |   |   |
                        """);
    }
    @Test
    void shouldAddOneGunShipAlongYAxis() {
        assertThat(new Grid().addGunShip(0, 1).repr())
                .isEqualTo("""
                        | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
                       0|   |   |   |   |   |   |   |   |   |   |
                       1| g |   |   |   |   |   |   |   |   |   |
                       2|   |   |   |   |   |   |   |   |   |   |
                       3|   |   |   |   |   |   |   |   |   |   |
                       4|   |   |   |   |   |   |   |   |   |   |
                       5|   |   |   |   |   |   |   |   |   |   |
                       6|   |   |   |   |   |   |   |   |   |   |
                       7|   |   |   |   |   |   |   |   |   |   |
                       8|   |   |   |   |   |   |   |   |   |   |
                       9|   |   |   |   |   |   |   |   |   |   |
                        """);
    }

    @Test
    void shouldAddOneGunShipAlongXAxis() {
        assertThat(new Grid().addGunShip(1, 0).repr())
                .isEqualTo("""
                        | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
                       0|   | g |   |   |   |   |   |   |   |   |
                       1|   |   |   |   |   |   |   |   |   |   |
                       2|   |   |   |   |   |   |   |   |   |   |
                       3|   |   |   |   |   |   |   |   |   |   |
                       4|   |   |   |   |   |   |   |   |   |   |
                       5|   |   |   |   |   |   |   |   |   |   |
                       6|   |   |   |   |   |   |   |   |   |   |
                       7|   |   |   |   |   |   |   |   |   |   |
                       8|   |   |   |   |   |   |   |   |   |   |
                       9|   |   |   |   |   |   |   |   |   |   |
                        """);
    }

    @Test
    void shouldAddTwoGunShips() {
        assertThat(new Grid().addGunShip(1, 0).addGunShip(0,1).repr())
                .isEqualTo("""
                        | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
                       0|   | g |   |   |   |   |   |   |   |   |
                       1| g |   |   |   |   |   |   |   |   |   |
                       2|   |   |   |   |   |   |   |   |   |   |
                       3|   |   |   |   |   |   |   |   |   |   |
                       4|   |   |   |   |   |   |   |   |   |   |
                       5|   |   |   |   |   |   |   |   |   |   |
                       6|   |   |   |   |   |   |   |   |   |   |
                       7|   |   |   |   |   |   |   |   |   |   |
                       8|   |   |   |   |   |   |   |   |   |   |
                       9|   |   |   |   |   |   |   |   |   |   |
                        """);
    }
    @Test
    void shouldAddOneDestroyerHorizontal() {
        assertThat(new Grid().addDestroyer(1, 0, Orientation.Horizontal).repr())
                .isEqualTo("""
                        | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
                       0|   | d | d | d |   |   |   |   |   |   |
                       1|   |   |   |   |   |   |   |   |   |   |
                       2|   |   |   |   |   |   |   |   |   |   |
                       3|   |   |   |   |   |   |   |   |   |   |
                       4|   |   |   |   |   |   |   |   |   |   |
                       5|   |   |   |   |   |   |   |   |   |   |
                       6|   |   |   |   |   |   |   |   |   |   |
                       7|   |   |   |   |   |   |   |   |   |   |
                       8|   |   |   |   |   |   |   |   |   |   |
                       9|   |   |   |   |   |   |   |   |   |   |
                        """);
    }
    @Test
    void shouldAddOneDestroyerAxisVertical() {
        assertThat(new Grid().addDestroyer(1, 0, Orientation.Vertical).repr())
                .isEqualTo("""
                        | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
                       0|   | d |   |   |   |   |   |   |   |   |
                       1|   | d |   |   |   |   |   |   |   |   |
                       2|   | d |   |   |   |   |   |   |   |   |
                       3|   |   |   |   |   |   |   |   |   |   |
                       4|   |   |   |   |   |   |   |   |   |   |
                       5|   |   |   |   |   |   |   |   |   |   |
                       6|   |   |   |   |   |   |   |   |   |   |
                       7|   |   |   |   |   |   |   |   |   |   |
                       8|   |   |   |   |   |   |   |   |   |   |
                       9|   |   |   |   |   |   |   |   |   |   |
                        """);
    }
}