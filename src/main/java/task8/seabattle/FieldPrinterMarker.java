package task8.seabattle;

public enum FieldPrinterMarker {
    EMPTY(" "),
    SHIP("^"),
    CHECKED("#"),
    HIT("X"),
    ;

    private String marker;

    FieldPrinterMarker(String marker) {
        this.marker = marker;
    }


    @Override
    public String toString() {
        return marker;
    }
}
