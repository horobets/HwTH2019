package task8.seabattle.battlefield;

import java.util.Objects;

public class CellLocation {
    private int x;
    private int y;

    public CellLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);

        if (obj == this) return true;
        if (!(obj instanceof CellLocation)) {
            return false;
        }
        CellLocation cellLocation = (CellLocation) obj;

        return Integer.compare(x, cellLocation.x) == 0
                && Integer.compare(y, cellLocation.y) == 0;
    }

}
