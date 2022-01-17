package supapac.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import supapac.Position;

public abstract class Element {

    public Position position;

    public Element(int x, int y){

        this.position = new Position(x, y);
    }

    public Position getPosition() {

        return position;
    }
    public Position setPosition(Position position) {

        this.position = position;
        return position;
    }

    public abstract void draw(TextGraphics graphics);
}