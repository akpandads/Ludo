package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.LudoBoardPart;
import com.akpanda.ludo.components.enums.Color;

public class BluePlayer extends Player{
    private LudoBoardPart bluePart;

    public BluePlayer(Color color, String playerName, LudoBoardPart bluePart) {
        super(color, playerName);
        this.bluePart = bluePart;
    }

    public LudoBoardPart getBluePart() {
        return bluePart;
    }

    public void setBluePart(LudoBoardPart bluePart) {
        this.bluePart = bluePart;
    }
}
