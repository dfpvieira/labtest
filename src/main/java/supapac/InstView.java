package supapac;

import com.googlecode.lanterna.TextColor;

import java.io.IOException;

import static com.googlecode.lanterna.SGR.BOLD;


public class InstView extends View<InstBlueprint> {

    public InstView(InstBlueprint model) {
        super(model);
        initScreen();
    }

    public void drawTitle() {
        String s1 = "      _ ___ _     _ ___  _      _";
        String s2 = "||\\ ||_  | |_|| ||   | || ||\\ ||_ ";
        String s3 = "|| \\| _| | |\\ |_||_  | ||_|| \\| _|";

        graphics.setForegroundColor(TextColor.Factory.fromString("#b249d2"));   //violet
        graphics.putString(getCol(s1), 2, s1, BOLD);
        graphics.putString(getCol(s2), 3, s2, BOLD);
        graphics.putString(getCol(s3), 4, s3, BOLD);
    }

    public void drawKeys() {

        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));   //green
        String s1 = "         ___                ___      ";
        String s2 = "        | W |              | ^ |     ";
        String s3 = "        |___|              |_|_|     ";
        String s4 = "    ___  ___  ___      ___  ___  ___ ";
        String s5 = "   | A || S || D |    | <-|| | ||-> |";
        String s6 = "   |___||___||___|    |___||_v_||___|";
        graphics.putString(getCol(s1), 14, s1, BOLD);
        graphics.putString(getCol(s2), 15, s2, BOLD);
        graphics.putString(getCol(s3), 16, s3, BOLD);
        graphics.putString(getCol(s4), 17, s4, BOLD);
        graphics.putString(getCol(s5), 18, s5, BOLD);
        graphics.putString(getCol(s6), 19, s6, BOLD);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear(col, row);

        drawTitle();
        drawString("#f2e744", 7, "ENTER \t\tRevel Cell");
        drawString("#f2e744", 8, "SPACE \t\tSet Flag ");
        drawString("#f2e744", 9, "Q \t\t\tQuit         ");
        drawString("#f2e744", 10, "Z \t\t\tUndo         ");
        drawString("#f2e744", 11, "    ESC \t\tGo Back to Menu");
        drawString("#f2e744", 12, "    MOVE \t\tArrows or WASD");
        drawKeys();
        drawString("#FF0000", 21, "Press enter to continue...");

        refresh();
    }
}
