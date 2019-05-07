package task8.seabattle;

import task8.seabattle.ships.Ship;

import java.util.*;


public class SeaBattleField {

    //private final SeaBattleCellValue[][] cells;
    private int fieldXsize;
    private int fieldYsize;

    private final Map<CellLocation, Ship> shipsLocations;
    private List<CellLocation> shotCells;

    public SeaBattleField() {
        this(10,10);//10x10 field by default
    }

    public SeaBattleField(int fieldXsize, int fieldYsize) {
        this.fieldXsize = fieldXsize;
        this.fieldYsize = fieldYsize;
        shipsLocations = new HashMap<>();
    }
    /*    public SeaBattleField(int fieldSizeX, int fieldSizeY) {
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

    public boolean shotToCell(CellLocation cellLocation) {
        if (!shotCells.contains(cellLocation)) {
            shotCells.add(cellLocation);
            return true;
        }
        return false;
    }


    public boolean addShip(Ship ship, CellLocation location) {

        //check location and add new ship


        shipsLocations.put(location, ship);
        return true;
    }

    public Map<CellLocation, Ship> getShipsLocations() {
        return shipsLocations;
    }

    private boolean shipFitsField(Ship ship, CellLocation shipLocation) {
        //check if ship can be placed to the field to the selected location
        List<CellLocation> shipCells = getSingleShipOccupiedCells(ship, shipLocation);
        for (CellLocation location : shipCells) {
            return cellFitsField(location);
        }
        return true;
    }

    public boolean cellFitsField(CellLocation cellLocation) {
        return cellLocation.getX() <= getFieldXsize() && cellLocation.getY() <= getFieldYsize();
    }

    private boolean shipFitsFreeSpace(Ship ship, CellLocation shipLocation) {
        //check if ship can be placed to the selected location - check other ships borders
        List<CellLocation> shipCells = getSingleShipOccupiedCells(ship, shipLocation);

        List<CellLocation> existingShipsAndBordersCells = getAllShipsOccupiedCells(true);

        //if no elements in common
        return Collections.disjoint(shipCells, existingShipsAndBordersCells);

    }

    public List<CellLocation> getAllShipsOccupiedCells(boolean includeBorderCells) {
        List<CellLocation> allShipsOccupiedCells = new ArrayList<>();
        for (Map.Entry<CellLocation, Ship> shipLocation : shipsLocations.entrySet()) {
            List<CellLocation> shipOccupiedCells = getSingleShipOccupiedCells(shipLocation.getValue(), shipLocation.getKey());
            allShipsOccupiedCells.addAll(shipOccupiedCells);

            //add ship border cells to the list as well
            if (includeBorderCells) {
                allShipsOccupiedCells.addAll(getSingleShipBorderCells(shipOccupiedCells));
            }
        }
        return allShipsOccupiedCells;
    }

    private List<CellLocation> getSingleShipOccupiedCells(Ship ship, CellLocation shipLocation) {
        int cellsOccupied = ship.getShipSize();
        List<CellLocation> occupiedCells = new ArrayList<>();
        occupiedCells.add(shipLocation);

        switch (ship.getShipDirection()) {
            case UP: {
                for (int i = 1; i < ship.getShipSize(); i++) {
                    CellLocation occupiedCell = new CellLocation(shipLocation.getX(), shipLocation.getY() + 1);
                    occupiedCells.add(occupiedCell);
                }
            }
            break;
            case DOWN: {
                for (int i = 1; i < ship.getShipSize(); i++) {
                    CellLocation occupiedCell = new CellLocation(shipLocation.getX(), shipLocation.getY() - 1);
                    occupiedCells.add(occupiedCell);
                }
            }
            break;
            case RIGHT: {
                for (int i = 1; i < ship.getShipSize(); i++) {
                    CellLocation occupiedCell = new CellLocation(shipLocation.getX() + 1, shipLocation.getY());
                    occupiedCells.add(occupiedCell);
                }
            }
            break;
            case LEFT: {
                for (int i = 1; i < ship.getShipSize(); i++) {
                    CellLocation occupiedCell = new CellLocation(shipLocation.getX() - 1, shipLocation.getY());
                    occupiedCells.add(occupiedCell);
                }
            }
            break;
        }
        return occupiedCells;
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
