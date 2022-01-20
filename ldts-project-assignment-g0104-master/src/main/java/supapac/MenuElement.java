package supapac;

import supapac.Position;

import java.util.Objects;

public class MenuElement {
    private Position position;

    public MenuElement(Position p) {
        this.position = p;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position p) {
        this.position = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuElement menuElement = (MenuElement) o;
        return Objects.equals(position, menuElement.position);
    }
}
