

import main.java.supapac.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombTest {
    //private main.java.supapac.gui.Arena arena;
    private main.java.supapac.elements.Bomb bomb;
    private main.java.supapac.elements.Bomb bomb1;

    @Test
    void checkMove() {
        Position p = new Position(5, 5);
        bomb = new main.java.supapac.elements.Bomb(5, 5);
        bomb1 = new main.java.supapac.elements.Bomb(p.getX(), p.getY());
        Assertions.assertNotEquals(bomb, bomb1);
    }


}
