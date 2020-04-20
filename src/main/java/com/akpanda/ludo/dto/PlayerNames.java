package com.akpanda.ludo.dto;

import com.akpanda.ludo.components.enums.Color;

import java.util.HashMap;
import java.util.Map;

public class PlayerNames {
    Map<Color,String> playerColorNameMap;

    public Map<Color, String> getPlayerColorNameMap() {
        return playerColorNameMap;
    }

    public void setPlayerColorNameMap(Map<Color, String> playerColorNameMap) {
        this.playerColorNameMap = playerColorNameMap;
    }
}
