package supapac;

import com.googlecode.lanterna.graphics.TextImage;


public class Image extends MenuElement{
    private TextImage textImage;

    public Image(Position position, TextImage textImage) {
        super(position);
        this.textImage = textImage;
    }
    public TextImage getTextImage() {return textImage;}
    public void setTextImage(TextImage ti) {this.textImage = ti;}
}
