package supapac;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class ControlKey {
    public enum COMMAND {UP, RIGHT, DOWN, LEFT, CLICK, FLAG, UNDO, ESC, QUIT, BACKSPACE, NONE}

    COMMAND command;
    Character key;

    public ControlKey() {
        this.key = ' ';
        this.command = COMMAND.NONE;
    }

    public Character getKey() {
        return key;
    }

    public COMMAND getCommandEnum() {
        return command;
    }


    public ControlKey getCommand(Screen screen) throws IOException {
        KeyStroke key;
        key = screen.pollInput();

        if (key == null)
            return this;

        switch (key.getKeyType()) {
            case EOF:
                this.command = COMMAND.QUIT;
            case ArrowUp:
                this.command = COMMAND.UP;
                break;
            case ArrowDown:
                this.command = COMMAND.DOWN;
                break;
            case ArrowRight:
                this.command = COMMAND.RIGHT;
                break;
            case ArrowLeft:
                this.command = COMMAND.LEFT;
                break;
            case Enter:
                this.command = COMMAND.CLICK;
                break;
            case Escape:
                this.command = COMMAND.ESC;
                break;
            case Backspace:
                this.command = COMMAND.BACKSPACE;
                break;
            case Character:
                this.key = key.getCharacter();
                switch (this.key) {
                    case ' ':
                        this.command = COMMAND.FLAG;
                        break;
                    case 'q':
                        this.command = COMMAND.QUIT;
                        break;
                    case 'z':
                        this.command = COMMAND.UNDO;
                        break;
                    case 'w':
                        this.command = COMMAND.UP;
                        break;
                    case 'a':
                        this.command = COMMAND.LEFT;
                        break;
                    case 's':
                        this.command = COMMAND.DOWN;
                        break;
                    case 'd':
                        this.command = COMMAND.RIGHT;
                        break;
                    default:
                        break;
                }
        }
        return this;
    }
}
