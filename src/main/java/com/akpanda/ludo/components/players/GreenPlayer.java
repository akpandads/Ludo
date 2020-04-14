package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.LudoBoardPart;
import org.springframework.stereotype.Component;

public class GreenPlayer extends Player{
    private LudoBoardPart greenPart;

    public LudoBoardPart getGreenPart() {
        return greenPart;
    }

    public void setGreenPart(LudoBoardPart greenPart) {
        this.greenPart = greenPart;
    }
}
