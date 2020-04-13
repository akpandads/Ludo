package com.akpanda.ludo.components.board;

import com.akpanda.ludo.components.enums.Color;

public class SingleBox {
    private boolean isStarred;
    private Color boxColor;
    private boolean hasGatewayToHome;
    private SingleBox nextNode;
    private SingleBox gateWayToHome;

    public boolean isStarred() {
        return isStarred;
    }

    public void setStarred(boolean starred) {
        isStarred = starred;
    }

    public Color getBoxColor() {
        return boxColor;
    }

    public void setBoxColor(Color boxColor) {
        this.boxColor = boxColor;
    }

    public boolean isHasGatewayToHome() {
        return hasGatewayToHome;
    }

    public void setHasGatewayToHome(boolean hasGatewayToHome) {
        this.hasGatewayToHome = hasGatewayToHome;
    }

    public SingleBox getNextNode() {
        return nextNode;
    }

    public void setNextNode(SingleBox nextNode) {
        this.nextNode = nextNode;
    }

    public SingleBox getGateWayToHome() {
        return gateWayToHome;
    }

    public void setGateWayToHome(SingleBox gateWayToHome) {
        this.gateWayToHome = gateWayToHome;
    }
}
