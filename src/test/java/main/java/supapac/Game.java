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

import static com.googlecode.lanterna.input.KeyType.*;

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

            TextGraphics tg = screen.newTextGraphics();

            screen.startScreen(); // screens must be started

            int x = 2;
            int y = 8;
            tg.putString(x, y,   "  ####  #   #  ####  ####   ####  ####  ####");
            tg.putString(x, ++y, "  #     #   #  #  #  #  #   #  #  #  #  #   ");
            tg.putString(x, ++y, "  ####  #   #  ####  ####   ####  ####  #   ");
            tg.putString(x, ++y, "     #  #   #  #     #  #   #     #  #  #   ");
            tg.putString(x, ++y, "  ####  #####  #     #  #   #     #  #  ####");

            y = y + 2;

            tg.putString(x, ++y, "  ..........................................");

            y = y + 2;

            tg.putString(x, ++y, "  Press 'S' to Start Raging!\n");

            y = y + 2 ;

            tg.putString(x, ++y, "  Press 'Q' Only in Case of Emergency\n");

            y+=2;
            tg.putString(x, ++y, "  Pres 'L' to Select the desired level\n");
            screen.doResizeIfNecessary(); // resize screen if necessary

            screen.refresh();

            screen.readInput();

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
            if(key.getKeyType() == EOF) break;
            processKey(key);
            if(arena.getDead()){
                LoseMenu();
                System.out.println("You lost :(");
                System.out.println(arena.a);
                //break;
            }
        }
    }

    public void openMainMenu() throws IOException {


        //renderMainMenu();

        screen.refresh();

        handleMainMenu();

    }

    private void handleMainMenu() throws IOException {
        KeyStroke key = screen.readInput();

        if(key != null) {
            if (key.getKeyType() == Character && key.getCharacter() == 'q') screen.close();
            if (key.getKeyType() == Character && key.getCharacter() == 's') run();
            if (key.getKeyType() == Character && key.getCharacter() == 'l') LevelMenu();
            if (key.getKeyType() == Character && key.getCharacter() == '1') {
                arena.setA(1);
                run();
            }
            if (key.getKeyType() == Character && key.getCharacter() == '2') {
                arena.setA(2);
                run();
            }
            if (key.getKeyType() == Character && key.getCharacter() == '3') {
                arena.setA(3);
                run();
            }
            if (key.getKeyType() == Character && key.getCharacter() == 'r') { // restart
                Restart();
            };

        }
    }

    private void LoseMenu() throws IOException{
        screen.clear();
        screen.refresh();
                /*TerminalSize terminalSize = new TerminalSize(x, y);
                DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
                Terminal terminal = terminalFactory.createTerminal();
                screen = new TerminalScreen(terminal);
                screen.setCursorPosition(null); */

        TextGraphics lost = screen.newTextGraphics();
        //screen.startScreen(); // screens must be started

        int x = 2;
        int y = 8;
        lost.putString(x-1, y, "#    #   ####   #   #  #      #####  ##### #####");
        lost.putString(x, ++y, "#  #  #     #  #   #  #    #      # #     #    ");
        lost.putString(x, ++y, "# #   #     #  #   #  #    #      # ##### #### ");
        lost.putString(x, ++y, "##    #     #  #   #  #    #      #     # #    ");
        lost.putString(x, ++y, "##     ####    #####  ##### #####   ##### #####");

        y = y + 2;

        lost.putString(x, ++y, "  ..........................................");

        y = y + 2;

        lost.putString(x, ++y, "  Press 'R' to try again \n");

        y++;

        lost.putString(x, ++y, "  Press 'Q' to take the easy way out :(\n");

        screen.doResizeIfNecessary();
        screen.refresh();
        screen.readInput();
        handleMainMenu();
        //screen.close();

    }

    private void LevelMenu() throws IOException {
        screen.clear();
        screen.refresh();
        TextGraphics level = screen.newTextGraphics();
        //screen.startScreen(); // screens must be started

        int x = 2;
        int y = 10;
        /*
        lost.putString(x-1, y, "#    #   ####   #   #  #      #####  ##### #####");
        lost.putString(x, ++y, "#  #  #     #  #   #  #    #      # #     #    ");
        lost.putString(x, ++y, "# #   #     #  #   #  #    #      # ##### #### ");
        lost.putString(x, ++y, "##    #     #  #   #  #    #      #     # #    ");
        lost.putString(x, ++y, "#     ####    #####  ##### #####   ##### #####");

         */
        y = y + 2;

        //lost.putString(x, ++y, "  ..........................................");

        y = y + 2;

        level.putString(x, ++y, "Press the Number Corresponding to the level you wish to play\n");

        y++;

        level.putString(x, ++y, "  Press 'Q' to take the easy way out :(\n");

        screen.doResizeIfNecessary();
        screen.refresh();
        screen.readInput();
        handleMainMenu();

    }

    private void Restart() throws IOException {
        screen.close();
        Game g = new Game();
        g.openMainMenu(); // fazer a app rodar outra vez
    }
    
    /*private void renderMainMenu() {
        int x=10;
        int y=2;

        drawString(x, y,   "  ########  ###    ###  ##########  #########    ##########  #########  ########");
        drawString(x, ++y,   "##        ###    ###  ##      ##  ##     ##    ##      ##  ##     ##  ##"      );
        drawString(x, ++y, "  ##        ###    ###  ##      ##  ##     ##    ##      ##  ##     ##  ##"      );
        drawString(x, ++y,   "########  ###    ###  #########   #########    #########   #########  ##"      );
        drawString(x, ++y,   "      ##  ###    ###  ##          ##     ##    ##          ##     ##  ##"      );
        drawString(x, ++y,   "      ##  ###    ###  ##          ##     ##    ##          ##     ##  ##"      );
        drawString(x, ++y,   "########  ##########  ##          ##     ##    ##          ##     ##  ########");

        screen.doResizeIfNecessary();

        y = y +2;
        x = 25;

        drawString(x, y, "..................................................................................");
        drawString(x, ++y, "Press 'S' to Start!\n");
        drawString(x, ++y, "Press 'Q' to Quit!\n");
    }  */


    public void drawString(int x, int y, String string) {
        TextGraphics tg = screen.newTextGraphics();
        tg.putString(x, y, string);
}
}