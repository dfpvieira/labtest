package supapac;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextImage;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.IOException;
import java.util.EnumSet;
import java.util.ArrayList;
import java.util.List;

/*

public class MenuLevelBuilder extends MenuBuilder{
    public MenuLevelBuilder(Size size) {super(size);}


    @Override
    protected List<Title> createTitles() {
        return new ArrayList<>();
    }
    @Override
    protected List<Button> createButtons() {
        List<Button> b = new ArrayList<>();
        String color = "#ffbb00";
        String colorHigh = "#0088ff";
        String background = "#000000";

        Text t = new Text("+", color, background, EnumSet.of(Text.TEXTMODIFIER.BOLD)); // EnumSet.of(Text.TEXTMODIFIER.BOLD) em cada
        Text ht = new Text("+", colorHigh, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Text levelt = new Text("01", colorHigh, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Text levelht = new Text("01", colorHigh, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Text mt = new Text("-", color, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Text mht = new Text("-", colorHigh, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Text bt = new Text("Back", color, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Text bht = new Text("Back", colorHigh, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        b.add(new Button(new Position(size.getWidth() / 2 - 3, size.getHeight() / 2 + 1),t, ht, new Size(6, 1), Button.Actions.PLUS));
        b.add(new Button(new Position(size.getWidth() / 2 - 3, size.getHeight() / 2 + 3), levelt, levelht, new Size(6, 3), Button.Actions.LVL_SELECT));
        b.add(new Button(new Position(size.getWidth() / 2 - 3, size.getHeight() / 2 + 7), mt, mht, new Size(6, 1), Button.Actions.MINUS));
        b.add(new Button(new Position(size.getWidth() / 2 - 5, size.getHeight() / 2 + 10), bt, bht, new Size(10, 3), Button.Actions.CONTINUE));
        return b;
    }
    /*@Override // precisa de size, Appearance
    protected List<Image> createImages() throws IOException {
        List<Image> i = new ArrayList<>();
        TextImage bhi = new TextImage(new Size(size.getWidth(), 5), new Appearance(' ', "#000000", "#484848"));
        TextImage bvi = new TextImage(new Size(10, size.getHeight()), new Appearance(' ', "#000000", "#484848"));
        TextImage titleImage = new LoaderTextImageBuilder("select").createTextImage();
        i.add(new Image(new Position(0, 0), bhi));
        i.add(new Image(new Position(0, size.getHeight() - 5), bhi));
        i.add(new Image(new Position(0, 0), bvi));
        i.add(new Image(new Position(size.getWidth() - 10, 0), bvi));
        i.add(new Image(new Position(size.getWidth() / 2 - titleImage.getSize().getWidth() / 2, size.getHeight() / 2 - titleImage.getSize().getHeight() - 2), titleImage));
        return i;
    }

} */
