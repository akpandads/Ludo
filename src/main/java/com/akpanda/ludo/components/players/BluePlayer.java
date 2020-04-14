package com.akpanda.ludo.components.players;

import com.akpanda.ludo.components.board.LudoBoardPart;
import com.akpanda.ludo.components.board.SingleBox;
import org.springframework.stereotype.Component;

public class BluePlayer extends Player{
    private LudoBoardPart bluePart;

    public LudoBoardPart getBluePart() {
        return bluePart;
    }

    public void setBluePart(LudoBoardPart bluePart) {
        this.bluePart = bluePart;
    }
}
