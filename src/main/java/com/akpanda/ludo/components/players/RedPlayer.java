package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.LudoBoardPart;
import org.springframework.stereotype.Component;

public class RedPlayer extends Player{
    private LudoBoardPart redPart;

    public LudoBoardPart getRedPart() {
        return redPart;
    }

    public void setRedPart(LudoBoardPart redPart) {
        this.redPart = redPart;
    }
}
