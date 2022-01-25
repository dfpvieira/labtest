package supapac.state.menu;
import supapac.Game;
import supapac.TerminalBuilder;
import supapac.state.State;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;

public class instructionMenu extends State {

    public instructionMenu(Game game, TerminalBuilder terminal) {
        super(game, terminal);
    }

    @Override
    public void draw() {
        try {
            this.screen.clear();

            graphics.setBackgroundColor(TextColor.Factory.fromString("#FE5959"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');

            graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.putString(new TerminalPosition(width / 2 - 6, 5), "INSTRUCTIONS", SGR.BOLD);

            graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.putString(new TerminalPosition(width / 2 - 16, 9), "Press the Left Arrow to Move Left", SGR.BOLD);
            graphics.putString(new TerminalPosition(width / 2 - 16, 11), "Press the Right Arrow to Move Right", SGR.BOLD);
            graphics.putString(new TerminalPosition(width / 2 - 16, 13), "Press the Down Arrow to Move Down", SGR.BOLD);
            graphics.putString(new TerminalPosition(width / 2 - 16, 15), "Press the Up Arrow to Move up", SGR.BOLD);
            graphics.putString(new TerminalPosition(width / 2 - 16, 17), "Press q to quit the game", SGR.BOLD);

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
        KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.Backspace) game.setState(new initialMenu(game, terminalwindow));
    }
}