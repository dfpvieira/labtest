package supapac;

import org.w3c.dom.Text;


public class Title /*extends MenuElements*/ {
    private Text text;

    public Title(Position position, Text text) {
        //super(position);
        this.text = text;
    }

    public Text getText() {return text;}
    public void setText(Text text) {this.text = text;}
}

