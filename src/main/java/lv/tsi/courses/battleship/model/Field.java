package lv.tsi.courses.battleship.model;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private final Map<String, CellState> cells = new HashMap<>();

    public CellState getState(String addr) {
        return cells.getOrDefault(addr, CellState.EMPTY);
    }

    public void setState(String addr, CellState state) {
        cells.put(addr, state);
    }

    public void clear() {
        cells.clear();
    }

    public boolean isValid() {
        return cells.values().stream().filter(cell -> cell == CellState.SHIP).count() == 20;
    }

    public boolean hasShips() {
        return cells.values().stream().anyMatch(cell -> cell == CellState.SHIP);
    }
}
