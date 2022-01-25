package supapac;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import supapac.gui.Arena;
import supapac.state.menu.initialMenu;
import supapac.state.State;

import java.io.IOException;

public class Game {

    private static Game firstInstance = null;

    private State state;
    private Screen screen;
    private Arena arena;
    private TerminalBuilder window;

    private Game(){
        this.arena = new Arena(50, 30);
        this.window = new TerminalBuilder(50, 30);
        this.state = new initialMenu(this, this.window);
        this.screen = window.getScreen();
    }

    public static Game getInstance(){
        if(firstInstance == null){
            firstInstance = new Game();
        }
        return firstInstance;
    }

    private void draw() throws IOException {
        screen.clear();
        state.draw();
        screen.refresh();
    }
    private void processKey(KeyStroke key) throws IOException {
        arena.processKey(key, screen);
    }

    public void run() throws IOException, InterruptedException {

        int FPS = 5;
        int frameTime = 1000/FPS;

        while(true){
            long startTime = System.currentTimeMillis();

            draw();

            state.execute();


            long sleepTime = calculateSleepTime(frameTime, getElapsedTime(startTime));
            if(sleepTime > 0) Thread.sleep(sleepTime);

        }
    }

    private long getElapsedTime(long startTime) {return System.currentTimeMillis() - startTime;}
    private long calculateSleepTime(int frameTime, long elapsedTime){return frameTime-elapsedTime;}

    public Arena getArena(){
        return this.arena;
    }

    public void setArena(Arena arena) { this.arena = arena; }

    public TerminalBuilder getTerminalBuilder(){
        return this.window;
    }
    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setScreen(Screen screen){
        this.screen = screen;
        this.window.setScreen(screen);
    }

    public void setGraphics(TextGraphics graphics){
        this.window.setGraphics(graphics);
    }

}
