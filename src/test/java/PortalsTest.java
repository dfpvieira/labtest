import main.java.supapac.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PortalsTest {
    private main.java.supapac.elements.Portals p;
    private main.java.supapac.elements.Portals p1;

    @Test
    void callMaterial() {
        Position pos = new Position(5, 5);
        p = new main.java.supapac.elements.Portals(pos.getX(), pos.getY());
        p1 = new main.java.supapac.elements.Portals(5, 5);
        Assertions.assertNotEquals(p, p1);
    }
}
