package supapac;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;

import static com.googlecode.lanterna.SGR.BOLD;
import static supapac.MenuBlueprint.Option.*;

public class MenuView extends View<MenuBlueprint> {
    BorderView borderView;

    public MenuView(MenuBlueprint model) {
        super(model);
        initScreen();
        this.borderView = new BorderView(16, 3, graphics);
    }

    public void drawTitle() {
        String s1 = "            _  _        _  _  _   _  _";
        String s2 = "|\\/| | |\\ | |_ |_  |  | |_ |_ |_| |_ |_|";
        String s3 = "|  | | | \\| |_  _| |/\\| |_ |_ |   |_ |\\ ";
        graphics.setForegroundColor(TextColor.Factory.fromString("#b249d2"));   //violet
        graphics.putString(getCol(s1), 2, s1, BOLD);
        graphics.putString(getCol(s2), 3, s2, BOLD);
        graphics.putString(getCol(s3), 4, s3, BOLD);
    }


    public void drawOptions() {
        drawString("#00FF00", getStringLine(model.getPosElem(START)), model.enumToString(START)); //green
        drawString("#f2e744", getStringLine(model.getPosElem(INST)), model.enumToString(INST));   //yellow
        drawString("#f2e744", getStringLine(model.getPosElem(PREF)), model.enumToString(PREF));   //yellow
        drawString("#f2e744", getStringLine(model.getPosElem(RANKING)), model.enumToString(RANKING)); //yellow
        drawString("#FF0000", getStringLine(model.getPosElem(EXIT)), model.enumToString(EXIT));   //red
    }

    public void drawSelectedBorder() {
        MenuBlueprint.Option selected = model.getSelected();
        int COL_BEGIN_SELECTED = this.getSize().getColumns() / 2 - 8;
        graphics.setForegroundColor(TextColor.Factory.fromString("#b249d2"));       //violet
        borderView.draw(COL_BEGIN_SELECTED, getStringLine(model.getPosElem(selected)) - 1);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear(col, row);

        graphics.setBackgroundColor(TextColor.Factory.fromString("#010326"));       //dark blue
        graphics.fillRectangle(new TerminalPosition(col, row), getSize(), ' ');

        drawTitle();
        drawOptions();
        drawSelectedBorder();

        refresh();
    }
}
