package supapac.state;
import supapac.Game;
import supapac.TerminalBuilder;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;

public abstract class State {
    protected Game game;
    protected TerminalBuilder terminalwindow;
    protected Screen screen;
    protected int width;
    protected int height;
    protected TextGraphics graphics;


    public State(Game game, TerminalBuilder terminal){
        this.game = game;
        this.terminalwindow = terminal;
        this.screen = terminal.getScreen();
        this.width = terminal.getWidth();
        this.height = terminal.getHeight();
        this.graphics = terminal.getGraphics();
    }

    public abstract void draw() throws IOException;

    public abstract void execute() throws IOException;

}

