package com.akpanda.ludo.components;

import com.akpanda.ludo.components.players.*;

public class Game {
    private BluePlayer bluePlayer;
    private RedPlayer redPlayer;
    private GreenPlayer greenPlayer;
    private YellowPlayer yellowPlayer;
    private Player currentPlayer;


    public BluePlayer getBluePlayer() {
        return bluePlayer;
    }

    public void setBluePlayer(BluePlayer bluePlayer) {
        this.bluePlayer = bluePlayer;
    }

    public RedPlayer getRedPlayer() {
        return redPlayer;
    }

    public void setRedPlayer(RedPlayer redPlayer) {
        this.redPlayer = redPlayer;
    }

    public GreenPlayer getGreenPlayer() {
        return greenPlayer;
    }

    public void setGreenPlayer(GreenPlayer greenPlayer) {
        this.greenPlayer = greenPlayer;
    }

    public YellowPlayer getYellowPlayer() {
        return yellowPlayer;
    }

    public void setYellowPlayer(YellowPlayer yellowPlayer) {
        this.yellowPlayer = yellowPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
