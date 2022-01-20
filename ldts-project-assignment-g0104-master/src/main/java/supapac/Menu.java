package supapac;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Title> t;
    private List<Button> b;
    private List<Image> i;
    private int sb;  //selected button

    public Menu() {
        this.sb = 0;
        this.t = new ArrayList<>();
        this.b = new ArrayList<>();
        this.i = new ArrayList<>();
    }
    //Getters & Setters

    public List<Title> getTitles() {return t;}
    public List<Button> getButtons() {return b;};
    public List<Image> getImages() {return i;}
    public void setTitles(List<Title> at) {this.t = at;}
    public void setImages(List<Image> ai) {this.i = ai;}
    public void setButtons(List<Button> ab) {
        for(Button c : ab) {
            c.setHover(false);
        }
        if(!ab.isEmpty()) {
            ab.get(sb).setHover(true);
            this.b = ab;
        }
    }
    public Button getSb() {
        if(b.size() == 0) return null;
        return b.get(this.sb);
    }
    public int getSbN() {
        return this.sb;
    }
    public void setSb(int n) {
        if(b.size() == 0) sb = 0;
        else {
            if(n < 0) n = 0;
            if(n > b.size()-1) n = b.size() -1;
            sb = n;
        }
    }

    //Funtions

    public void upB() {
        b.get(sb).setHover(false);
        if(sb == 0) sb = getButtons().size() - 1;
        else {
            sb--;
            b.get(sb).setHover(true);
        }
    }
    public void downB() {
        b.get(sb).setHover(false);
        if(sb == getButtons().size() - 1) sb = 0;
        else {
            sb++;
            b.get(sb).setHover(true);
        }
    }
}
