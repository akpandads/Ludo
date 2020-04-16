package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.Box;
import com.akpanda.ludo.components.enums.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player {
    public Color color;
    public Map<LudoPiece, Box> playerPieces = new HashMap<>();
    public String playerName;
    public int finishedPieces;

    Player(Color color,String playerName){
        this.color = color;
        this.playerName = playerName;
        this.finishedPieces = 0;
        for(int i=0;i<4;i++){
            playerPieces.put(new LudoPiece(color),null);
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Map<LudoPiece, Box> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(Map<LudoPiece, Box> playerPieces) {
        this.playerPieces = playerPieces;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getFinishedPieces() {
        return finishedPieces;
    }

    public void setFinishedPieces(int finishedPieces) {
        this.finishedPieces = finishedPieces;
    }
}
