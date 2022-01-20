package supapac;

public class Size {
    private int height;
    private int width;

    public Size(int h, int w) {
        this.height = h;
        this.width = w;
    }

    //Getters & Setters

    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public void setHeight( int h) {
        this.height = h;
    }
    public void setWidth(int w) {
        this.width = w;
    }
}
