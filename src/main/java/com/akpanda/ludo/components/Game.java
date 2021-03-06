package com.akpanda.ludo.components;

import com.akpanda.ludo.components.players.*;
import com.akpanda.ludo.core.LudoCoreFunctionalities;

public class Game {

    private String gameId;
    private BluePlayer bluePlayer;
    private RedPlayer redPlayer;
    private GreenPlayer greenPlayer;
    private YellowPlayer yellowPlayer;
    private Player currentPlayer;
    private LudoCoreFunctionalities ludoCoreFunctionalities;

    public LudoCoreFunctionalities getLudoCoreFunctionalities() {
        return ludoCoreFunctionalities;
    }

    public void setLudoCoreFunctionalities(LudoCoreFunctionalities ludoCoreFunctionalities) {
        this.ludoCoreFunctionalities = ludoCoreFunctionalities;
    }

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

    public String getGameId() {
        return gameId;
    }
}
