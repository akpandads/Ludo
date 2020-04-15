package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.LudoBoardPart;
import com.akpanda.ludo.components.enums.Color;
import org.springframework.stereotype.Component;

public class YellowPlayer extends Player{
    private LudoBoardPart yellowPart;

    public YellowPlayer(Color color, String playerName, LudoBoardPart yellowPart) {
        super(color, playerName);
        this.yellowPart = yellowPart;
    }

    public LudoBoardPart getYellowPart() {
        return yellowPart;
    }

    public void setYellowPart(LudoBoardPart yellowPart) {
        this.yellowPart = yellowPart;
    }
}
