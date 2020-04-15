package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.enums.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player {
    public Color color;
    public Map<Integer,LudoPiece> playerPieces = new HashMap<>();
    public String playerName;
    public int finishedPieces;
    public int pendingPieces;

    Player(Color color,String playerName){
        this.color = color;
        this.playerName = playerName;
        this.finishedPieces = 0;
        this.pendingPieces = 0;
        for(int i=0;i<4;i++){
            playerPieces.put(i+1,new LudoPiece(color));
        }
    }
}
