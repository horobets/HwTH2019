package task8.seabattle;

import task8.seabattle.battlefield.SeaBattleField;

import java.util.ArrayList;
import java.util.List;

public class FieldBuilder {

    private final List<Integer> availableShips;
    private SeaBattleField field;

    public FieldBuilder() {
        final List<Integer> shipsLengths = new ArrayList<>();

        //submarine /single-decker /single-funnel: Size: 4 number per player: 1
        shipsLengths.add(4);

        //destroyer /two-decker /two-funnel: Size: 3 number per player: 2
        shipsLengths.add(3);
        shipsLengths.add(3);

        //cruiser /three-decker /three-funnel: Size: 2 number per player: 3
        shipsLengths.add(2);
        shipsLengths.add(2);
        shipsLengths.add(2);

        //battleship /four-decker /four-funnel: Size: 1 number per player: 4
        shipsLengths.add(1);
        shipsLengths.add(1);
        shipsLengths.add(1);
        shipsLengths.add(1);

        this.availableShips = shipsLengths;
    }

    public FieldBuilder(List<Integer> availableShips) {
        this.availableShips = availableShips;
    }

    public SeaBattleField getField() {
        return field;
    }

}
