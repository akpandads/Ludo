package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.enums.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    public Color color;
    public List<LudoPiece> playerPieces = new ArrayList<>();
    public String playerName;
    public int finishedPieces = 0;
    public int pendingPieces = 4;
}
