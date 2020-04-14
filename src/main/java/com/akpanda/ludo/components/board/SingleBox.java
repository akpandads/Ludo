package com.akpanda.ludo.components.board;

import com.akpanda.ludo.components.enums.Color;

public class SingleBox {
    private boolean isSafeBox;
    private Color boxColor;
    private boolean hasGatewayToHome;
    private boolean isStartBox;
    private SingleBox nextNode;
    private SingleHomeBox gateWayToHome;

    public boolean isStartBox() {
        return isStartBox;
    }

    public void setStartBox(boolean startBox) {
        isStartBox = startBox;
    }

    public boolean isSafeBox() {
        return isSafeBox;
    }

    public void setSafeBox(boolean safeBox) {
        isSafeBox = safeBox;
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

    public SingleHomeBox getGateWayToHome() {
        return gateWayToHome;
    }

    public void setGateWayToHome(SingleHomeBox gateWayToHome) {
        this.gateWayToHome = gateWayToHome;
    }
}
