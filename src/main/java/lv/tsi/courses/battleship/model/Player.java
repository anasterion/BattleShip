package lv.tsi.courses.battleship.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Field allyField = new Field();
    private Field enemyField = new Field();
    private List<String> history = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field getAllyField() {
        return allyField;
    }

    public Field getEnemyField() {
        return enemyField;
    }

    public List<String> getHistory() {
        return history;
    }

    public boolean isReadyToPlay() {
        return allyField.isValid();
    }

    public void addToHistory(String message) {
        history.add(0, message);
    }
}
