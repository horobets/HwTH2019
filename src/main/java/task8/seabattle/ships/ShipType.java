package task8.seabattle.ships;

public class ShipType {
    private int shipSize;
    private ShipDirection shipDirection;

    public ShipType(int shipSize, ShipDirection shipDirection) {
        this.shipSize = shipSize;
        this.shipDirection = shipDirection;
    }

    public int getShipSize() {
        return shipSize;
    }

    public ShipDirection getShipDirection() {
        return shipDirection;
    }
}
