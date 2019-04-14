package task6.tictactoe;

public class WinningLine {
    public WinningLine(WinningLineType type, int lineIndex, CellValue cellValue, boolean isCompletelyFilled, int emptyCellLocation) {
        this.type = type;
        this.lineIndex = lineIndex;
        this.cellValue = cellValue;
        this.isCompletelyFilled = isCompletelyFilled;
        this.emptyCellLocation = emptyCellLocation;
    }

    public WinningLine(WinningLineType type, int lineIndex, CellValue cellValue, boolean isCompletelyFilled) {
        this(type, lineIndex, cellValue, isCompletelyFilled, 0);
    }

    private WinningLineType type;
    private int lineIndex;
    private CellValue cellValue;
    private boolean isCompletelyFilled;//already won
    private int emptyCellLocation;

    public WinningLineType getType() {
        return type;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public CellValue getCellValue() {
        return cellValue;
    }

    public boolean isCompletelyFilled() {
        return isCompletelyFilled;
    }

    public int getEmptyCellLocation() {
        return emptyCellLocation;
    }
}
