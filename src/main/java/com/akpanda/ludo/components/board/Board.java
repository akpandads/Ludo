package com.akpanda.ludo.components.board;

import com.akpanda.ludo.components.players.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Board {

    private GreenPlayer greenPlayer;
    private YellowPlayer yellowPlayer;
    private RedPlayer redPlayer;
    private BluePlayer bluePlayer;

    public GreenPlayer getGreenPlayer() {
        return greenPlayer;
    }

    public void setGreenPlayer(GreenPlayer greenPlayer) {
        this.greenPlayer = greenPlayer;
    }

    public YellowPlayer getYellowPlayer() {
        return yellowPlayer;
    }

    public void setYellowPlayer(YellowPlayer yellowPlayer) {
        this.yellowPlayer = yellowPlayer;
    }

    public RedPlayer getRedPlayer() {
        return redPlayer;
    }

    public void setRedPlayer(RedPlayer redPlayer) {
        this.redPlayer = redPlayer;
    }

    public BluePlayer getBluePlayer() {
        return bluePlayer;
    }

    public void setBluePlayer(BluePlayer bluePlayer) {
        this.bluePlayer = bluePlayer;
    }
}
