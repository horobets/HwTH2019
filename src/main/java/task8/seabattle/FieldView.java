package task8.seabattle;

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


    }

    private void getEmptyFieldViewCells(){
        fieldViewCellValues = new FieldViewCellValue[seaBattleField.getFieldXsize()][seaBattleField.getFieldYsize()];
        for(FieldViewCellValue[] fieldViewCellRow : fieldViewCellValues){
            for(FieldViewCellValue fieldViewCellValue :fieldViewCellRow){
                fieldViewCellValue = new FieldViewCellValue(false, false);
            }
        }
    }
    private void addShootsToFieldFieldView(){

        CellLocation

        for(int i = 0; i< fieldViewCellValues.length; i++){
            for(int j = 0; j< fieldViewCellValues[i].length; j++){

                fieldViewCellValues[i]
            }
        }
    }
}
