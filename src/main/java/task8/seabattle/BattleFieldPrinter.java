package task8.seabattle;

public class BattleFieldPrinter {
    private FieldView fieldView;

    public BattleFieldPrinter(FieldView fieldView) {
        this.fieldView = fieldView;
    }

    public void printBattleField(boolean displayShips) {
        System.out.printf("%nField: %n");

        FieldViewCellValue[][] viewCellValues = fieldView.getFieldViewCells();
        //print title line (letters)
        StringBuilder titleLineSB = new StringBuilder();
        for (int j = -1; j < viewCellValues[0].length; j++) {

            if (j < 0) {
                titleLineSB.append("  |");
                continue;
            }
            titleLineSB.append(String.format("%c|", 'A' + j));

        }
        printFieldLine(titleLineSB.toString());

        for (int i = 0; i < viewCellValues.length; i++) {
            StringBuilder rowViewSB = new StringBuilder();
            rowViewSB.append(String.format("%-2d|", i + 1));

            for (int j = 0; j < viewCellValues[i].length; j++) {
                String cellViewStr;


                if (!viewCellValues[i][j].isShoot()) {
                    cellViewStr = FieldPrinterMarker.EMPTY.toString();
                    if (displayShips && viewCellValues[i][j].isShip()) {
                        cellViewStr = FieldPrinterMarker.SHIP.toString();

                    }
                } else if (!viewCellValues[i][j].isShip())
                    cellViewStr = FieldPrinterMarker.CHECKED.toString();
                else
                    cellViewStr = FieldPrinterMarker.HIT.toString();

                rowViewSB.append(cellViewStr);
                rowViewSB.append("|");
            }
            printFieldLine(rowViewSB.toString());
        }
    }

    private void printFieldLine(String fieldLineStr) {
        System.out.printf(fieldLineStr);
        System.out.printf("%n");
        for (int i = 0; i < fieldLineStr.length(); i++)
            System.out.printf("_");
        System.out.printf("%n");
    }
}
