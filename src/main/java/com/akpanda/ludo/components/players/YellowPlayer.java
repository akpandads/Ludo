package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.LudoBoardPart;
import org.springframework.stereotype.Component;

public class YellowPlayer extends Player{
    private LudoBoardPart yellowPart;

    public LudoBoardPart getYellowPart() {
        return yellowPart;
    }

    public void setYellowPart(LudoBoardPart yellowPart) {
        this.yellowPart = yellowPart;
    }
}
