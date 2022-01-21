package supapac;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.ANSI;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import supapac.gui.Arena;

import java.io.IOException;
public class Game {
    private Screen screen;
    int x = 50;
    int y = 30;
    private Arena arena = new Arena(x, y);

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(x, y);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException {
        arena.processKey(key, screen);
    }

    public void run() throws IOException {
        while(true){
            screen.clear();
            arena.draw(screen.newTextGraphics());
            screen.refresh();
            KeyStroke key = screen.readInput();
            if(key.getKeyType() == KeyType.EOF) break;
            processKey(key);
            if(arena.getDead()){
                System.out.println("You lost :(");
                break;
            }
        }
    }

    public void openMainMenu() throws IOException {


        renderMainMenu();

        screen.refresh();

        handleMainMenu();

    }

    private void handleMainMenu() throws IOException {
        KeyStroke key = screen.readInput();

        if(key != null) {
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 's') run();
        }
    }
    
    private void renderMainMenu() {
        int x=10;
        int y=2;

        drawString(x, y,   "  ########  ###    ###  ##########  #########    ##########  #########  ########", ANSI.CYAN);
        drawString(x, ++y,   "##        ###    ###  ##      ##  ##     ##    ##      ##  ##     ##  ##",      ANSI.CYAN);
        drawString(x, ++y, "  ##        ###    ###  ##      ##  ##     ##    ##      ##  ##     ##  ##",      ANSI.CYAN);
        drawString(x, ++y,   "########  ###    ###  #########   #########    #########   #########  ##",      ANSI.CYAN);
        drawString(x, ++y,   "      ##  ###    ###  ##          ##     ##    ##          ##     ##  ##",      ANSI.CYAN);
        drawString(x, ++y,   "      ##  ###    ###  ##          ##     ##    ##          ##     ##  ##",      ANSI.CYAN);
        drawString(x, ++y,   "########  ##########  ##          ##     ##    ##          ##     ##  ########", ANSI.CYAN);

        screen.doResizeIfNecessary();

        y = y +2;
        x = 25;

        drawString(x, y, "..................................................................................", ANSI.CYAN_BRIGHT);
        drawString(x, ++y, "Press 'S' to Start!\n", ANSI.CYAN);
        drawString(x, ++y, "Press 'Q' to Quit!\n", ANSI.CYAN);
    }


    public void drawString(int x, int y, String string, TextColor.ANSI newColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.putString(x, y, string,null);
}
}