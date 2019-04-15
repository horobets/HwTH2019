package task6.tictactoe;

public class WinningLine {
    public WinningLine(WinningLineType type, int lineIndex, Role role, boolean isCompletelyFilled, int emptyCellLocation) {
        this.type = type;
        this.lineIndex = lineIndex;
        this.role = role;
        this.isCompletelyFilled = isCompletelyFilled;
        this.emptyCellLocation = emptyCellLocation;
    }

    public WinningLine(WinningLineType type, int lineIndex, Role role, boolean isCompletelyFilled) {
        this(type, lineIndex, role, isCompletelyFilled, 0);
    }

    private WinningLineType type;
    private int lineIndex;
    private Role role;
    private boolean isCompletelyFilled;//already won
    private int emptyCellLocation;

    public WinningLineType getType() {
        return type;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public Role getRole() {
        return role;
    }

    public boolean isCompletelyFilled() {
        return isCompletelyFilled;
    }

    public int getEmptyCellLocation() {
        return emptyCellLocation;
    }
}
