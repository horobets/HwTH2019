package task8.seabattle;

import task8.seabattle.ships.Ship;

import java.util.ArrayList;
import java.util.List;

public class ShipPrinter {
    private final List<Ship> ships;

    public ShipPrinter(Ship ship) {
        this.ships = new ArrayList<>();
        this.ships.add(ship);
    }

    public ShipPrinter(List<Ship> ships) {
        this.ships = ships;
    }

    public void printShips() {
        for (Ship ship : ships) {

        }
    }
}
