package supapac;

import java.io.IOException;
import java.util.List;

public abstract class MenuBuilder {
    protected final Size size;

    public MenuBuilder(Size asize) {this.size = asize;}

    public Menu createMenu() throws IOException {
        Menu m = new Menu();
        m.setTitles(createTitles());
        m.setButtons(createButtons());
        m.setImages(createImages());
        return m;
    }

    protected abstract List<Title> createTitles();
    protected abstract List<Button> createButtons();
    protected abstract List<Image> createImages() throws IOException;
}
