package supapac;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;

public abstract class View<T extends Blueprint> {
    public static final int COLS_MENU = 50;
    public static final int ROWS_MENU = 25;
    public static final String BACKGROUND_COLOUR = "#010326";

    protected T model;
    private Screen screen;
    protected TextGraphics graphics;

    protected View(T model) {
        this.model = model;
    }

    public TerminalSize getSize() {
        return new TerminalSize(COLS_MENU, ROWS_MENU);
    }

    public void initScreen() {
        try {
            DefaultTerminalFactory factory = new DefaultTerminalFactory().setInitialTerminalSize(getSize());
            Terminal terminal = factory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            graphics = screen.newTextGraphics();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TextGraphics initGraphics() {
        return screen.newTextGraphics();
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

    /*public CommandKey getCommand() throws IOException {
        return new CommandKey().getCommand(screen);
    }*/

    public void setModel(T model) {
        this.model = model;
    }

    public void close() throws IOException {
        screen.close();
    }

    protected void clear(int col, int row) {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString(BACKGROUND_COLOUR));
        graphics.fillRectangle(new TerminalPosition(col, row), getSize(), ' ');
    }

    protected void refresh() throws IOException {
        screen.refresh();
    }

    public abstract void draw(int col, int row) throws IOException;

    protected int getStringLine(int pos) {
        return 10 + pos * 2;
    }

    //Column to the string be at the center of the screen
    public int getCol(String s) {
        return (COLS_MENU - s.length()) / 2;
    }

    protected void drawString(String color, int row, String s) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(getCol(s), row, s);
    }
}
