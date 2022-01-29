import main.java.supapac.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaterialTest {
    private main.java.supapac.elements.Material m;
    private main.java.supapac.elements.Material m1;

    @Test
    void callMaterial() {
        Position p = new Position(5, 5);
        m = new main.java.supapac.elements.Material(p.getX(), p.getY());
        m1 = new main.java.supapac.elements.Material(5, 5);
        Assertions.assertNotEquals(m, m1);
    }
}
