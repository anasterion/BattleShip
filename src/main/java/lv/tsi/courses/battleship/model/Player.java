package lv.tsi.courses.battleship.model;

public class Player {
    private String name;
    private Field allyField = new Field();
    private Field enemyField = new Field();

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

    public boolean isReadyToPlay() {
        return allyField.isValid();
    }
}
