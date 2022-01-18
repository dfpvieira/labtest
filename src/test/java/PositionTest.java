/*import supapac.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private supapac.gui.Arena arena;
    private supapac.elements.Player player;

    @BeforeEach
    void setUp () {
        player = new supapac.elements.Player(new supapac.Position(5, 5));

        arena = new supapac.gui.Arena(10, 10);
    }
    @Test
    void moveLeft() {
        arena.movePlayer(player.moveLeft());
        assertEquals(4, player.moveLeft().getX());
    }

    @Test
    void moveUp() {
        arena.movePlayer(player.moveUp());
        assertEquals(4, player.moveUp().getY());
    }

    @Test
    void moveDown() {
        arena.movePlayer(player.moveDown());
        assertEquals(6, player.moveDown().getY());
    }

    @Test
    void moveRight() {
        arena.movePlayer(player.moveRight());
        assertEquals(6, player.moveRight().getX());
    }
}
*/