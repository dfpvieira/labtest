package supapac.state.menu;
import supapac.Game;
import supapac.TerminalBuilder;
import supapac.state.State;
import supapac.gui.Arena;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelMenu extends State{
    public LevelMenu(Game game, TerminalBuilder terminal) {
        super(game, terminal);
    }


    @Override
    public void draw() {
        try {
            this.screen.clear();

            graphics.setBackgroundColor(TextColor.Factory.fromString("#FE5959"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');

            graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.putString(new TerminalPosition(width / 2 - 6, 5), "LEVELS", SGR.BOLD);

            graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.putString(new TerminalPosition(width / 2 - 16, 9), "Press 1 to play the first level", SGR.BOLD);
            graphics.putString(new TerminalPosition(width / 2 - 16, 11), "Press 2 to play the second level", SGR.BOLD);
            graphics.putString(new TerminalPosition(width / 2 - 16, 13), "Press 3 to play the third level", SGR.BOLD);

            graphics.putString(new TerminalPosition(width / 2 - 23, height - 3), "Press the BackSpace to Go Back to the Main Menu", SGR.BOLD);

            this.screen.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void execute() throws IOException {
        getBackToMenu();
    }

    public void getBackToMenu() throws IOException {
        Arena arena = game.getArena();
        KeyStroke key = screen.readInput();

        if (key.getKeyType() == KeyType.Backspace) game.setState(new initialMenu(game, terminalwindow));
        if(key.getCharacter() == '1') {
            arena.level = 0;
            arena.loadLevel(arena.maps.get(arena.level++));
            game.setState(new playMenu(game, terminalwindow));
        }
        if(key.getCharacter() == '2') {
            arena.level = 1;
            arena.loadLevel(arena.maps.get(arena.level++));
            game.setState(new playMenu(game, terminalwindow));
        }
        if(key.getCharacter() == '3') {
            arena.level = 2;
            arena.loadLevel(arena.maps.get(arena.level++));
            game.setState(new playMenu(game, terminalwindow));
        }
    }









}
