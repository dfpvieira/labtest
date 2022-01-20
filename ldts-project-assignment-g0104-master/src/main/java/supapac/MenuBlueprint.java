package supapac;


public class MenuBlueprint implements Blueprint {
    public enum Option {START, INST, PREF, RANKING, EXIT}    //Enum used to avoid typing errors

    public String[] optString = {"NEW GAME", "INSTRUCTIONS", "SETTINGS", "RANKINGS", "EXIT"}; //get the string associated to the enumerator

    Option selected;
    Option[] opt = Option.values();

    public MenuBlueprint(boolean inGame) {
        this.selected = Option.START;
        if (inGame) optString[0] = "CONTINUE";
    }

    public Option getSelected() {
        return selected;
    }

    public int getPosElem(Option target) {
        int i = 0;
        for (; opt[i] != target; i++) ;
        return i;
    }

    public String enumToString(Option menuOption) {
        int position = getPosElem(menuOption);
        return optString[position];
    }

    public void setSelected(Option selected) {
        this.selected = selected;
    }

    public void nextSelected() {
        if (selected == Option.EXIT) selected = Option.START;
        else {
            //find the position of this.selected in the opt array
            int i = getPosElem(selected);
            i++;
            selected = opt[i];
        }
    }

    public void previousSelected() {
        if (selected == Option.START) selected = Option.EXIT;
        else {
            //find the position of this.selected in the opt array
            int i = getPosElem(selected);
            i--;
            selected = opt[i];
        }
    }
}
