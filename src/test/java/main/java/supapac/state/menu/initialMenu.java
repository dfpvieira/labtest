package supapac.state.menu;
import supapac.state.State;
import supapac.Game;
import supapac.TerminalBuilder;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import java.io.IOException;

public class initialMenu extends State{
    public initialMenu(Game game, TerminalBuilder terminal) {
        super(game, terminal);
    }

    @Override
    public void draw() {
        try {
            this.screen.clear();

            graphics.setBackgroundColor(TextColor.Factory.fromString("#FE5959"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');

            graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.putString(new TerminalPosition(width / 2 - 8 , 12), "SUPAPAC GAME", SGR.BOLD);

            graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.putString(new TerminalPosition(width / 2 - 17, 19), "PRESS S TO START THE GAME", SGR.BOLD);
            graphics.putString(new TerminalPosition(width / 2 - 17, 21), "PRESS I TO READ THE INSTRUCTIONS", SGR.BOLD);

            this.screen.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() throws IOException {
        getToNextState();
    }

    public void getToNextState() throws IOException {
        KeyStroke key = screen.readInput();
        System.out.println(key.getCharacter());
        if(key.getCharacter() == 's') game.setState(new playMenu(game, terminalwindow));
        if(key.getCharacter() == 'i') game.setState(new instructionMenu(game, terminalwindow));
    }

}
