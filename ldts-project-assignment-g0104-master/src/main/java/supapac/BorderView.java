package supapac;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BorderView {
    private int width;
    private int height;
    private TextGraphics graphics;

    public BorderView(int width, int height, TextGraphics graphics) {
        this.width = width;
        this.height = height;
        this.graphics = graphics;
    }

    public int getWidth() {
        return width;
    }

    public void drawTop(int colBegin, int lineBegin) {
        TerminalPosition startLine = new TerminalPosition(colBegin, lineBegin);
        TerminalPosition endLine = new TerminalPosition(colBegin + width - 1, lineBegin);
        graphics.drawLine(startLine, endLine, '-');
    }

    public void drawBottom(int colBegin, int lineBegin) {
        TerminalPosition startLine = new TerminalPosition(colBegin, lineBegin + height - 1);
        TerminalPosition endLine = new TerminalPosition(colBegin + width - 1, lineBegin + height - 1);
        graphics.drawLine(startLine, endLine, '-');
    }

    public void drawLeft(int colBegin, int lineBegin) {
        TerminalPosition startLine = new TerminalPosition(colBegin, lineBegin);
        TerminalPosition endLine = new TerminalPosition(colBegin, lineBegin + height - 1);
        graphics.drawLine(startLine, endLine, '|');
    }

    public void drawRight(int colBegin, int lineBegin) {
        TerminalPosition startLine = new TerminalPosition(colBegin + width - 1, lineBegin);
        TerminalPosition endLine = new TerminalPosition(colBegin + width - 1, lineBegin + height - 1);
        graphics.drawLine(startLine, endLine, '|');
    }

    public void drawCorners(int colBegin, int lineBegin) {
        graphics.putString(colBegin, lineBegin, "+");
        graphics.putString(colBegin, lineBegin + height - 1, "+");
        graphics.putString(colBegin + width - 1, lineBegin, "+");
        graphics.putString(colBegin + width - 1, lineBegin + height - 1, "+");
    }

    public void draw(int colBegin, int lineBegin) {
        drawTop(colBegin, lineBegin);
        drawBottom(colBegin, lineBegin);
        drawRight(colBegin, lineBegin);
        drawLeft(colBegin, lineBegin);
        drawCorners(colBegin, lineBegin);
    }
}
