package task8.seabattle.battlefield;

import task8.seabattle.ships.Ship;
import task8.seabattle.ships.ShipStatus;
import task8.seabattle.ships.ShipType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SeaBattleField {

    //private final SeaBattleCellValue[][] cells;
    private int fieldXsize;
    private int fieldYsize;

    //private final Map<CellLocation, ShipType> shipsLocations;
    private List<Ship> ships;
    private List<CellLocation> shotCells;

    public SeaBattleField() {
        this(10,10);//10x10 field by default
    }

    public SeaBattleField(int fieldXsize, int fieldYsize) {
        this.fieldXsize = fieldXsize;
        this.fieldYsize = fieldYsize;
        //shipsLocations = new HashMap<>();
        ships = new ArrayList<>();
        shotCells = new ArrayList<>();
    }
    /*    public battlefield(int fieldSizeX, int fieldSizeY) {
        cells = new SeaBattleCellValue[fieldSizeX][fieldSizeY];
        shipsLocations = new HashMap<>();
    }

    private int getMaxX(){
        return cells.length;
    }
    private int getMaxY(){
        return cells[0].length;
    }

    public SeaBattleCellValue getCellValue(CellLocation cellLocation){
        return cells[cellLocation.getX()][cellLocation.getY()];
    }

    public SeaBattleCellValue[][] getCells() {
        return cells;
    }*/


    public int getFieldXsize() {
        return fieldXsize;
    }

    public int getFieldYsize() {
        return fieldYsize;
    }

    public List<CellLocation> getShotCells() {
        return shotCells;
    }


    public ShotResult shotToCell(CellLocation cellLocation) {

        if (!cellFitsField(cellLocation))
            return ShotResult.INVALIDLOCATION;

        if (shotCells.contains(cellLocation)) {
            return ShotResult.ALREADYSHOT;
        }

        if (getAllShipsOccupiedCells(false).contains(cellLocation)) {

            shotCells.add(cellLocation);

            if (isShipDestroyed(findShipOnCell(cellLocation))) {
                markBorderCellsWhenDestroyed();
                return ShotResult.DESTROYED;
            } else
                return ShotResult.HIT;
        }
        shotCells.add(cellLocation);
        return ShotResult.MISS;

    }

    private void markBorderCellsWhenDestroyed() {
        for (Ship ship : ships) {
            if (isShipDestroyed(ship)) {
                for (CellLocation borderCell : getSingleShipBorderCells(ship)) {
                    if (!shotCells.contains(borderCell)) {
                        shotCells.add(borderCell);
                    }
                }
            }
        }
    }

    public boolean addShip(ShipType shipType, CellLocation location) {

        //check location and add new shipType

        if (shipFitsField(shipType, location)) {

            //shipsLocations.put(location, shipType);
            Ship newShip = new Ship(location, this, shipType);

            ships.add(newShip);
            return true;
        }

        return false;
    }

    /*public Map<CellLocation, ShipType> getShipsLocations() {
        return shipsLocations;
    }*/


    public List<Ship> getShips() {
        return ships;
    }

    public int getAliveShipsCount() {
        int aliveShipsCount = 0;
        for (Ship ship : ships) {
            if (!isShipDestroyed(ship))
                aliveShipsCount++;
        }
        return aliveShipsCount;
    }

    private ShipStatus getShipStatus(Ship ship) {
        if (isShipDestroyed(ship))
            return ShipStatus.DESTROYED;
        if (isShipDamaged(ship))
            return ShipStatus.DAMAGED;
        return ShipStatus.HEALTHY;
    }

    private boolean isShipDamaged(Ship ship) {

        return !Collections.disjoint(shotCells, getSingleShipOccupiedCells(ship));
    }

    private boolean isShipDestroyed(Ship ship) {

        return shotCells.containsAll(getSingleShipOccupiedCells(ship));
    }

    private Ship findShipOnCell(CellLocation cell) {
        for (Ship ship : ships) {
            if (getSingleShipOccupiedCells(ship).contains(cell)) {
                return ship;
            }
        }
        return null;
    }

    private boolean shipFitsField(ShipType shipType, CellLocation shipLocation) {
        //check if shipType can be placed to the field to the selected location
        List<CellLocation> shipCells = getSingleShipOccupiedCells(shipType, shipLocation);
        for (CellLocation location : shipCells) {
            return cellFitsField(location);
        }
        return true;
    }

    public boolean cellFitsField(CellLocation cellLocation) {
        return cellLocation.getX() <= getFieldXsize() && cellLocation.getY() <= getFieldYsize();
    }

    private boolean shipFitsFreeSpace(ShipType shipType, CellLocation shipLocation) {
        //check if shipType can be placed to the selected location - check other ships borders
        List<CellLocation> shipCells = getSingleShipOccupiedCells(shipType, shipLocation);

        List<CellLocation> existingShipsAndBordersCells = getAllShipsOccupiedCells(true);

        //if no elements in common
        return Collections.disjoint(shipCells, existingShipsAndBordersCells);

    }

    public List<CellLocation> getAllShipsOccupiedCells(boolean includeBorderCells) {
        List<CellLocation> allShipsOccupiedCells = new ArrayList<>();
        //for (Map.Entry<CellLocation, ShipType> shipLocation : shipsLocations.entrySet()) {
        for (Ship ship : ships) {
            List<CellLocation> shipOccupiedCells = getSingleShipOccupiedCells(ship);
            allShipsOccupiedCells.addAll(shipOccupiedCells);

            //add ship border cells to the list as well
            if (includeBorderCells) {
                allShipsOccupiedCells.addAll(getSingleShipBorderCells(shipOccupiedCells));
            }
        }
        return allShipsOccupiedCells;
    }

    private List<CellLocation> getSingleShipOccupiedCells(Ship ship) {
        return getSingleShipOccupiedCells(ship.getShipType(), ship.getShipLocation());
    }

    private List<CellLocation> getSingleShipOccupiedCells(ShipType shipType, CellLocation shipLocation) {
        int cellsOccupied = shipType.getShipSize();
        List<CellLocation> occupiedCells = new ArrayList<>();
        occupiedCells.add(shipLocation);

        switch (shipType.getShipDirection()) {
            case UP: {
                for (int i = 1; i < shipType.getShipSize(); i++) {
                    CellLocation occupiedCell = new CellLocation(shipLocation.getX(), shipLocation.getY() + 1);
                    occupiedCells.add(occupiedCell);
                }
            }
            break;
            case DOWN: {
                for (int i = 1; i < shipType.getShipSize(); i++) {
                    CellLocation occupiedCell = new CellLocation(shipLocation.getX(), shipLocation.getY() - 1);
                    occupiedCells.add(occupiedCell);
                }
            }
            break;
            case RIGHT: {
                for (int i = 1; i < shipType.getShipSize(); i++) {
                    CellLocation occupiedCell = new CellLocation(shipLocation.getX() + 1, shipLocation.getY());
                    occupiedCells.add(occupiedCell);
                }
            }
            break;
            case LEFT: {
                for (int i = 1; i < shipType.getShipSize(); i++) {
                    CellLocation occupiedCell = new CellLocation(shipLocation.getX() - 1, shipLocation.getY());
                    occupiedCells.add(occupiedCell);
                }
            }
            break;
        }
        return occupiedCells;
    }

    private List<CellLocation> getSingleShipBorderCells(Ship ship) {

        return getSingleShipBorderCells(getSingleShipOccupiedCells(ship));
    }

    private List<CellLocation> getSingleShipBorderCells(List<CellLocation> shipCellsLocations) {
        List<CellLocation> borderCells = new ArrayList<>();

        shipCellsLocations.forEach(location -> {
            List<CellLocation> cellBorderCells = getSingleCellBorderCells(location);
            cellBorderCells.forEach(borderLocation -> {
                if (!shipCellsLocations.contains(borderLocation)) {
                    borderCells.add(borderLocation);
                }
            });
        });
        return borderCells;
    }

    private List<CellLocation> getSingleCellBorderCells(CellLocation cellLocation) {
        List<CellLocation> borderCells = new ArrayList<>();

        borderCells.add(new CellLocation(
                cellLocation.getX() - 1, cellLocation.getY() - 1));
        borderCells.add(new CellLocation(
                cellLocation.getX(), cellLocation.getY() - 1));
        borderCells.add(new CellLocation(
                cellLocation.getX() + 1, cellLocation.getY() - 1));

        borderCells.add(new CellLocation(
                cellLocation.getX() - 1, cellLocation.getY()));
        borderCells.add(new CellLocation(
                cellLocation.getX() + 1, cellLocation.getY()));

        borderCells.add(new CellLocation(
                cellLocation.getX() - 1, cellLocation.getY() + 1));
        borderCells.add(new CellLocation(
                cellLocation.getX(), cellLocation.getY() + 1));
        borderCells.add(new CellLocation(
                cellLocation.getX() + 1, cellLocation.getY() + 1));

        return borderCells;
    }
}
