package task8.seabattle;

public class FieldViewCellValue {
    private boolean isShoot;
    private boolean isShip;

    public FieldViewCellValue(boolean isShoot, boolean isShip) {
        this.isShoot = isShoot;
        this.isShip = isShip;
    }

    public void setShoot(boolean shoot) {
        isShoot = shoot;
    }

    public void setShip(boolean ship) {
        isShip = ship;
    }

    public boolean isShoot() {
        return isShoot;
    }

    public boolean isShip() {
        return isShip;
    }
}
