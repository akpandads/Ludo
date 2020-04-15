package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.LudoBoardPart;
import com.akpanda.ludo.components.enums.Color;
import org.springframework.stereotype.Component;

public class GreenPlayer extends Player{
    private LudoBoardPart greenPart;

    public GreenPlayer(Color color, String playerName, LudoBoardPart greenPart) {
        super(color, playerName);
        this.greenPart = greenPart;
    }

    public LudoBoardPart getGreenPart() {
        return greenPart;
    }

    public void setGreenPart(LudoBoardPart greenPart) {
        this.greenPart = greenPart;
    }
}
