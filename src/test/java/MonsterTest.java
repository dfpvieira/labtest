
import main.java.supapac.Position;
import main.java.supapac.elements.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import main.java.supapac.gui.Arena;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterTest {
    //private main.java.supapac.gui.Arena arena;
    private main.java.supapac.elements.Monster monster;
    private main.java.supapac.elements.Monster monster1;


    @Test
    void checkMove() {
        Position p = new Position(5, 5);
        monster1 = new main.java.supapac.elements.Monster(5, 5);
        monster = new main.java.supapac.elements.Monster(p.getX(), p.getY());
        Assertions.assertNotEquals(monster, monster1);
    }
}