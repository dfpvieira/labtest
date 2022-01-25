package supapac.state.menu;
import supapac.Game;
import supapac.TerminalBuilder;
import supapac.state.State;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;

public class playMenu extends State{
    public playMenu(Game game, TerminalBuilder terminal) {
        super(game, terminal);
    }

    @Override
    public void draw() {
        game.getArena().draw(graphics);
    }

    @Override
    public void execute() throws IOException {
        KeyStroke key = screen.pollInput();
        game.getArena().processKey(key, terminalwindow.getScreen());
    }
}
