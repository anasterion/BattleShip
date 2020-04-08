package lv.tsi.courses.battleship.model;

public class Game {
    private Player player1;
    private Player player2;
    private boolean isPlayer1Turn = true;
    private Player winner;

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getWinner() {
        return winner;
    }

    public synchronized void join(Player player) {
        if (player1 == null) {
            player1 = player;
        } else {
            player2 = player;
        }
    }

    public synchronized boolean isReady() {
        return player1 != null && player2 != null;
    }

    public synchronized boolean setupIsReady() {
        return player1.isReadyToPlay() && player2.isReadyToPlay();
    }

    public synchronized Player getActivePlayer() {
        return isPlayer1Turn ? player1 : player2;
    }

    public synchronized Player getInactivePlayer() {
        return isPlayer1Turn ? player2 : player1;
    }

    public synchronized boolean isMyTurn(Player player) {
        return getActivePlayer() == player;
    }

    public synchronized void fire(String addr) {
        var opponent = getInactivePlayer();
        var player = getActivePlayer();
        var opponentField = opponent.getAllyField();
        var result = "MISS";

        if (opponentField.getState(addr) == CellState.SHIP) {
            opponentField.setState(addr, CellState.HIT);
            player.getEnemyField().setState(addr, CellState.HIT);
            result = "HIT";
            if (!opponentField.hasShips()) {
                winner = player;
            }
        } else if (opponentField.getState(addr) == CellState.EMPTY) {
            opponentField.setState(addr, CellState.MISS);
            player.getEnemyField().setState(addr, CellState.MISS);
            isPlayer1Turn = !isPlayer1Turn;
        } else {
            isPlayer1Turn = !isPlayer1Turn;
        }
        player.addToHistory(String.format("You fired %s: %s", addr, result));
        opponent.addToHistory(String.format("%s fired %s: %s", player.getName(), addr, result));
    }

    public boolean isFinished() {
        return winner != null;
    }
}
