
import jdk.jfr.StackTrace;
import main.java.supapac.Position;
import main.java.supapac.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.supapac.gui.Arena;
import main.java.supapac.gui.walls;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class AllTests {
    private main.java.supapac.gui.Arena arena;
    private main.java.supapac.elements.Monster monster;
    private main.java.supapac.gui.walls wall;
    private main.java.supapac.elements.Portals portal;
    private main.java.supapac.elements.Bomb bomb;
    private main.java.supapac.elements.Player player;
    private int lives = 3;
    private List<Material> materials;

    @BeforeEach
    void setUp() {
        Position p = new Position(5, 5);
        monster = new main.java.supapac.elements.Monster(p.getX(), p.getY());
        arena = new main.java.supapac.gui.Arena(10, 10);
        wall = new main.java.supapac.gui.walls(6, 6);
        portal = new main.java.supapac.elements.Portals(4, 5);
        bomb = new main.java.supapac.elements.Bomb(8, 8);
        player = new main.java.supapac.elements.Player(p.getX(), p.getY());

        arena.setPlayer(player);
    }

    @Test
    void MonsterMove() {

        monster.move();
        assertEquals(true, monster.getPos() == 0 || monster.getPos() == 1 || monster.getPos() == 3 || monster.getPos() == 4);
    }

    void monsterHittingTheWall() {

        monster.move();
        assertEquals(false, monster.getPosition() == wall.getPosition());
    }

    void isPlayerHittingAPortal() {

        arena.movePlayer(player.moveLeft());
        assertEquals(true, player.getPosition() == portal.getPosition());
    }

    @Test
    void movePlayerLeftTest() {
        arena.movePlayer(player.moveLeft());
        assertEquals(new main.java.supapac.Position(4, 5), player.getPosition());
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

    @Test
    void allMaterialsEaten() {

        arena.verifyWin();
        assertEquals(true, arena.getVerified());
    }

    @Test
    void isBobLoosingHisLife() {

        arena.verifyMonsterCollisions();
        assertEquals(0, arena.getLives()) ||
        assertEquals(1, arena.getLives()) ||
        assertEquals(2, arena.getLives());
    }

    @Test
    void isBobDead() {

        arena.verifyBombCollisions();
        assertEquals(true, arena.getDead());
    }
}