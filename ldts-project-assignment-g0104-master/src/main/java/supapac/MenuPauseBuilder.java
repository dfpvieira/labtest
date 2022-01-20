package supapac;

import com.googlecode.lanterna.graphics.TextImage;
import org.w3c.dom.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static java.awt.Font.BOLD;
/*
public class MenuPauseBuilder extends MenuBuilder {
    public PauseMenuBuilder(Size size) {super(size);}

    @Override
    protected List<Title> createTitle() {
        return new ArrayList<>();
    }

    @Override
    protected List<Button> createButtons() {
        List<Button> b = new ArrayList<>();
        String color = "#ffbb00";
        String colorHigh = "#0088";
        String background = "#000000";
        Text continueText = new Text("CONTINUE", color, background, BOLD);
        Text continueHighText = new Text("CONTINUE", colorHigh, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Text quitText = new Text("QUIT", color, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Text quitHighText = new Text("QUIT", colorHigh, background, EnumSet.of(Text.TEXTMODIFIER.BOLD));
        Button start_button = new Button(new Position(size.getWidth() / 2 - 6, size.getHeight() / 2 + 2), continueText, continueHighText, new Size(12, 3), Button.Actions.CONTINUE);
        Button quit_button = new Button(new Position(size.getWidth() / 2 - 6, size.getHeight() / 2 + 6), quitText, quitHighText, new Size(12, 3), Button.Actions.MAIN);
        b.add(start_button);
        b.add(quit_button);
        return b;
    }

    /*@Override
    protected List<Image> createImages() throws IOException {
        List<Image> images = new ArrayList<>();
        TextImage borderHorizontalImage = new TextImage(new Size(size.getWidth(), 5), new Appearance(' ', "#000000", "#484848"));
        TextImage borderVerticalImage = new TextImage(new Size(10, size.getHeight()), new Appearance(' ', "#000000", "#484848"));
        TextImage titleImage = new LoaderTextImageBuilder("paused").createTextImage();
        images.add(new Image(new Position(0, 0), borderHorizontalImage));
        images.add(new Image(new Position(0, size.getHeight() - 5), borderHorizontalImage));
        images.add(new Image(new Position(0, 0), borderVerticalImage));
        images.add(new Image(new Position(size.getWidth() - 10, 0), borderVerticalImage));
        images.add(new Image(new Position(size.getWidth() / 2 - titleImage.getSize().getWidth() / 2, size.getHeight() / 2 - titleImage.getSize().getHeight() / 2 - 8), titleImage));
        return images;
    }
}
}*/
