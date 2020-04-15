package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.LudoBoardPart;
import com.akpanda.ludo.components.enums.Color;
import org.springframework.stereotype.Component;

public class RedPlayer extends Player{
    private LudoBoardPart redPart;

    public RedPlayer(Color color, String playerName, LudoBoardPart redPart) {
        super(color, playerName);
        this.redPart = redPart;
    }

    public LudoBoardPart getRedPart() {
        return redPart;
    }

    public void setRedPart(LudoBoardPart redPart) {
        this.redPart = redPart;
    }
}
