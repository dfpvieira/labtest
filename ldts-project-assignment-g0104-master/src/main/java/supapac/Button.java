package supapac;
import org.w3c.dom.Text;

public class Button extends MenuElement{
    private boolean hover;
    private Text text;
    private Text hoverText;
    private Size size; // altura e largura
    private Actions action;

    public Button(Position position, Text text, Text hoverText,Size size,Actions action) { // com hover size out
        super(position);
        this.hover = false;
        this.text = text;
        this.hoverText = hoverText;
        this.size = size;
        this.action = action;
    }

    public Button(Position position, Text text, Actions action) {
        super(position);
        this.hover = false;
        this.text = text;
        this.hoverText = text;
        //this.size = size;
        this.action = action;
    }
    //Getters and Setters

    public Text getText() {
        return text;
    }
    public Text getHoverText() {
        return hoverText;
    }
    public Size getSize() {
        return size;
    }
    public Actions getAction() {
        return action;
    }

    public void setText(Text t) {
        this.text = t;
    }
    public void setHoverText(Text ht) {
        this.hoverText = ht;
    }
    public Boolean getHover() {return hover;}
    public void setHover(Boolean a) {this.hover = a;}
    public void setSize(Size s) {
        this.size = s;
    }
    public void setAction(Actions a) {
        this.action = a;
    }

    public enum Actions {
        QUIT,
        CONTINUE,
        START,
        LVL_SELECT,
        PLUS,
        MINUS,
        MAIN,
        NONE
    }
}
