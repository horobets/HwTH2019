package task8.seabattle;

import java.util.List;

public class FieldView {
    private SeaBattleField seaBattleField;
    private FieldViewCellValue[][] fieldViewCellValues;

    public FieldView(SeaBattleField seaBattleField) {
        this.seaBattleField = seaBattleField;
    }
    public void printField(){
    }

    public FieldViewCellValue[][] getFieldViewCells(){
        fieldViewCellValues = new FieldViewCellValue[seaBattleField.getFieldXsize()][seaBattleField.getFieldYsize()];
        initFieldViewCells();
        addShootsAndShipsToFieldView();
        return fieldViewCellValues;
    }

    private void initFieldViewCells() {
        fieldViewCellValues = new FieldViewCellValue[seaBattleField.getFieldXsize()][seaBattleField.getFieldYsize()];
        /*for(FieldViewCellValue[] fieldViewCellRow : fieldViewCellValues){
            for(FieldViewCellValue fieldViewCellValue :fieldViewCellRow){
                fieldViewCellValue = new FieldViewCellValue(false, false);
            }
        }*/

        for (int i = 0; i < fieldViewCellValues.length; i++) {
            for (int j = 0; j < fieldViewCellValues[i].length; j++) {
                fieldViewCellValues[i][j] = new FieldViewCellValue(false, false);
            }
        }
    }

    private void addShootsAndShipsToFieldView() {

        List<CellLocation> shotCells = seaBattleField.getShotCells();
        List<CellLocation> shipsOccupiedCells = seaBattleField.getAllShipsOccupiedCells(false);

        for(int i = 0; i< fieldViewCellValues.length; i++){
            for(int j = 0; j< fieldViewCellValues[i].length; j++){

                CellLocation currentCellLocation = new CellLocation(i, j);
                if (shotCells.contains(currentCellLocation))
                    fieldViewCellValues[i][j].setShoot(true);
                if (shipsOccupiedCells.contains(currentCellLocation))
                    fieldViewCellValues[i][j].setShip(true);
            }
        }
    }
}
